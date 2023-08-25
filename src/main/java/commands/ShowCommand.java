package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;

public class ShowCommand implements Command{
    CollectionManager collectionManager;

    public ShowCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.show();
        ResponseFormer.appendLine("Collection content");
        return new CommandStatus("Collection content",true);
    }

    @Override
    public String getName() {
        return "show";
    }
}
