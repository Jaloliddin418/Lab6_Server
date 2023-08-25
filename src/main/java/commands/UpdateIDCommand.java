package commands;

import commandsLogic.CollectionManager;
import data.Dragon;
import data.DragonReadFromConsole;
import manager.MessageToSer;
import response.ResponseFormer;

public class UpdateIDCommand implements Command {
    private final CollectionManager collectionManager;

    public UpdateIDCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        if (message.getArg().length == 0) {
            ResponseFormer.appendLine("Not enough argument");
            return new CommandStatus("Not enough argument", false);
        }
        int id;
        try {
            id = Integer.parseInt(message.getArg()[0]);
        } catch (Exception e) {
            e.printStackTrace();
            ResponseFormer.appendLine("Argument must be integer");
            return new CommandStatus("Argument must be integer", false);
        }
        if (!collectionManager.isThereDragon(id)) {
            ResponseFormer.appendLine("Dragon not found");
            return new CommandStatus("Dragon not found", false);
        }
        Dragon dragon = message.getDragon();
        if (dragon == null) {
            ResponseFormer.appendLine("Invalid dragon data");
            return new CommandStatus("Invalid dragon data", false);
        }
        collectionManager.updateId(id, dragon);
        ResponseFormer.appendLine("Element updated successfully");
        return new CommandStatus("Element updated successfully", true);
    }


    @Override
    public String getName() {
        return "update_id";
    }

}
