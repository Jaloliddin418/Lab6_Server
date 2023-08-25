package commands;

import manager.MessageToSer;

public interface Command {
    CommandStatus execute(MessageToSer message);
    String getName();

    record CommandStatus(String message, Boolean isSuccess){
        @Override
        public String message() {
            return message;
        }
        @Override
        public Boolean isSuccess() {
            return isSuccess;
        }
    }
}
