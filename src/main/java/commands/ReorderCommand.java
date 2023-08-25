package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;

public class ReorderCommand implements Command{
    CollectionManager collectionManager;

    public ReorderCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    private final String NAME = "reorder";




    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.reorder();
        ResponseFormer.appendLine("Reverse sort");
        return new CommandStatus("Reverse sort",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
