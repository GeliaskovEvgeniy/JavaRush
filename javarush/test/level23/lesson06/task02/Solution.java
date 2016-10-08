package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static class Constants {
         final static String SNAE = "Server is not accessible for now.";
        final static String UUX = "User is not authorized.";
        final static String BUX = "User is banned.";
        final static String RE = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.SNAE);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.SNAE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.UUX);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.UUX, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.BUX);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.BUX, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.RE);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.RE, cause);
        }
    }
}
