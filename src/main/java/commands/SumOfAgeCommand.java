package commands;

import commandsLogic.CollectionManager;
import manager.MessageToSer;

public class SumOfAgeCommand implements Command{
    CollectionManager collectionManager;

    public SumOfAgeCommand(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.sumOfAge();
        return new CommandStatus("Sum of age",true);
    }
    @Override
    public String getName() {
        return "sum_of_age";
    }
}
