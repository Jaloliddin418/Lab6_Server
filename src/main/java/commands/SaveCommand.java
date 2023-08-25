package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;

public class SaveCommand implements Command{
    CollectionManager collectionManager;

    public SaveCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.saveCollection();
        return new CommandStatus("Collection saved",true);
    }

    @Override
    public String getName() {
        return "save";
    }
}
