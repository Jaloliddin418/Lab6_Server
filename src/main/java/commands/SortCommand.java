package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;

public class SortCommand implements Command{
    CollectionManager collectionManager;

    public SortCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.sort();
        ResponseFormer.appendLine("Collection sorted");
        return new CommandStatus("Collection sorted",true);
    }

    @Override
    public String getName() {
        return "sort";
    }

}
