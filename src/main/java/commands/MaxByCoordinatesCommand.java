package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;

public class MaxByCoordinatesCommand implements Command{
    CollectionManager collectionManager;

    public MaxByCoordinatesCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.maxByCoordinates();
        return new CommandStatus("Dragon by max coordinates",true);
    }
    @Override
    public String getName() {
        return "max_by_coordinates";
    }
}
