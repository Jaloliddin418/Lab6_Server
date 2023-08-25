package commands;

import commandsLogic.CollectionManager;

import data.*;
import manager.MessageToSer;
import response.ResponseFormer;

public class AddCommand implements Command{

    private final String NAME = "add";
    private CollectionManager collectionManager;
    private String message;

    public AddCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        Dragon dragon = message.getDragon();
       // Dragon dragon = DragonReadFromConsole.readDragon();
        if (dragon == null){
            ResponseFormer.appendLine("Dragon not added");
            return new CommandStatus("Dragon not added",false);
        }
        collectionManager.add(dragon);
        ResponseFormer.appendLine("Dragon added successfully!");
        return new CommandStatus("Dragon added successfully!",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}


