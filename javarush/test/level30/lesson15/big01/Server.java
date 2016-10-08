package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    final private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws IOException
    {
        int port = ConsoleHelper.readInt();
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            ConsoleHelper.writeMessage("сервер запущен");
            while (true)
            {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (IOException e){
            ConsoleHelper.writeMessage(e.getMessage());
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (String clientName : connectionMap.keySet()) {
            try {
                connectionMap.get(clientName).send(message);
            }
            catch (IOException e) {
                ConsoleHelper.writeMessage("Не могу отправить сообщение клиенту с именем: " + clientName);
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с удаленным клиентом с адресом: "
                    + socket.getRemoteSocketAddress());

            Connection connection = null;
            String userName = null;
            try {
                connection = new Connection(socket);
                userName = serverHandshake(connection);
                sendListOfUsers(connection, userName);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                serverMainLoop(connection, userName);
            }
            catch (IOException | ClassNotFoundException e){
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом: " +
                        socket.getRemoteSocketAddress());
                try {
                    if (connection != null)
                        connection.close();
                    socket.close();
                } catch (IOException e1) {}
            }
            if (userName != null) {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом закрыто");
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            boolean accepted = false;
            String name = null;
            while (!accepted) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();
                    if (!name.isEmpty() && connectionMap.get(name) == null) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        accepted = true;
                    }
                }
            }
            return name;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()){
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true){
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String newMessage = userName + ": " +message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, newMessage));
                }else {
                    ConsoleHelper.writeMessage(
                            String.format("Ошибка! Недопустимый тип сообщения (MessageType.%s) от клиента: %s",
                            message.getType().toString() ,userName));
                }
            }
        }
    }

}
