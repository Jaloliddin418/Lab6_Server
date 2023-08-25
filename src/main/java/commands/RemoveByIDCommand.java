package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;

public class RemoveByIDCommand implements Command{
    CollectionManager collectionManager;

    public RemoveByIDCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        if (message.getArg() == null) {
            ResponseFormer.appendLine("Not enough parameters");
            return new CommandStatus("Not enough parameters",false);
        }
        int id;

        try {
            id = Integer.parseInt(message.getArg()[0]);
        }catch (Exception e) {
            ResponseFormer.appendLine("argument must be integer");
            return new CommandStatus("Param must be integer",false);
        }
        if (!collectionManager.isThereDragon(id)) {
            ResponseFormer.appendLine("Dragon not found");
            return new CommandStatus("Dragon not found", false);
        }
        collectionManager.removeById(id);
        ResponseFormer.appendLine("Element removed successfully");
        return new CommandStatus("Element removed successfully",true);
    }
    @Override
    public String getName() {
        return "remove_by_id";
    }
}
