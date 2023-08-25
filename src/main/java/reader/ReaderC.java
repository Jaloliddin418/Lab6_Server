package reader;

import commands.Command;
import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;;
import java.util.*;

public class ReaderC {
    boolean isExit = true;
    private String message;
    private ArrayList <Command> commands = new ArrayList<>();
    private Deque<String> commandHistory = new LinkedList<>();
    private MessageToSer msg;
    CollectionManager collectionManager;
    LineInterpreter interpreter;
    public ReaderC() {
    }
    public Deque<String> getHistory(){
        return new LinkedList<>(commandHistory.stream().limit(7).toList());
    }
    public void addCommand(Command cmd){
        commands.add(cmd);
    }

    public void read(MessageToSer messageToSer){

            try {
                message = messageToSer.getMessage();
            } catch (NoSuchElementException e) {
                return;
            }
        if(message == null){
            ResponseFormer.appendLine("No command found for input");
            return;
        }

        if(message.equals("save")){
                ResponseFormer.appendLine("No command found");
                return;
            }

            boolean commandFound = false;

            for (Command cmd : commands) {
                if (cmd.getName().equals(message)) {
                    commandFound = true;
                    commandHistory.push(cmd.getName());
                    cmd.execute(messageToSer);
                    break;
                }
            }
            if (!commandFound) {
                ResponseFormer.appendLine("No command found for input: " + message);
            }

    }
}

