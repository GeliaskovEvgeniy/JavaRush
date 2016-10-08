package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient client = new BotClient();
        client.run();

    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] nameAndText = message.split(":");
            if (nameAndText.length == 2) {
                String name = nameAndText[0].trim();
                String text = nameAndText[1].trim();
                String simplDateFormat = null;
                switch (text) {
                    case "дата":
                        simplDateFormat = "d.MM.YYYY";
                        break;
                    case "день":
                        simplDateFormat = "d";
                        break;
                    case "месяц":
                        simplDateFormat = "MMMM";
                        break;
                    case "год":
                        simplDateFormat = "YYYY";
                        break;
                    case "время":
                        simplDateFormat = "H:mm:ss";
                        break;
                    case "час":
                        simplDateFormat = "H";
                        break;
                    case "минуты":
                        simplDateFormat = "m";
                        break;
                    case "секунды":
                        simplDateFormat = "s";
                        break;
                }
                if (simplDateFormat != null) {
                    String answer = String.format("Информация для %s: %s", name,
                            new SimpleDateFormat(simplDateFormat).format(Calendar.getInstance().getTime()));
                    sendTextMessage(answer);
                }
            }
        }
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = "date_bot_%d";
        int random = (int) (Math.random() * 100);
        return String.format(botName, random);
    }
}
