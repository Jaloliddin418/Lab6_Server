package commandsLogic;

import commands.*;
import reader.ReaderC;

import java.util.Vector;

public class CommandAdder {
    private CollectionManager collectionManager;

    public CommandAdder(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void setCommand(ReaderC readerC){
        readerC.addCommand(new HelpCommand(collectionManager));
        readerC.addCommand(new AddCommand(collectionManager));
        readerC.addCommand(new ClearCommand(collectionManager));
        readerC.addCommand(new FilterContainsNameCommand(collectionManager));
        readerC.addCommand(new UpdateIDCommand(collectionManager));
        readerC.addCommand(new InfoCommand(collectionManager));
        readerC.addCommand(new ShowCommand(collectionManager));
        readerC.addCommand(new MaxByCoordinatesCommand(collectionManager));
        readerC.addCommand(new ReorderCommand(collectionManager));
        readerC.addCommand(new SortCommand(collectionManager));
        readerC.addCommand(new SumOfAgeCommand(collectionManager));
        readerC.addCommand(new HistoryCommand(readerC));
        readerC.addCommand(new RemoveByIDCommand(collectionManager));
        readerC.addCommand(new SaveCommand(collectionManager));
//        readerC.addCommand(new ExecuteScriptCommand(readerC));
    }
}
