package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;


public class FilterContainsNameCommand implements Command{
    CollectionManager collectionManager;
    public FilterContainsNameCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }
    @Override
    public CommandStatus execute(MessageToSer message) {
        if (message.getArg()==null){
            ResponseFormer.appendLine("Argument is null");
        }
        if (message.getArg().length == 0) {
            ResponseFormer.appendLine("Not enough argument");
            return new CommandStatus("Not enough argument",false);
        }
        String searchSubstring;
        try {
            searchSubstring = message.getArg()[0];
        }catch (Exception e) {
            ResponseFormer.appendLine("Invalid argument");
            return new CommandStatus("Invalid params",false);
        }
        collectionManager.filterContainsName(searchSubstring);
        return new CommandStatus("Dragon is found",true);
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

}
