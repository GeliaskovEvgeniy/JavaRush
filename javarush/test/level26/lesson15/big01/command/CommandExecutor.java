package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.Operation;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {

    private static Map<Operation, Command> operationCommandMap;

    private CommandExecutor()
    {
    }

    static
    {
        operationCommandMap=new HashMap<>();
        operationCommandMap.put(Operation.INFO, new  InfoCommand());
        operationCommandMap.put(Operation.DEPOSIT, new DepositCommand());
        operationCommandMap.put(Operation.WITHDRAW, new WithdrawCommand());
        operationCommandMap.put(Operation.EXIT, new ExitCommand());
        operationCommandMap.put(Operation.LOGIN, new LoginCommand());

    }
    public static final void execute(Operation operation) throws InterruptOperationException
    {
        operationCommandMap.get(operation).execute();
    }
}
