package commands;

import commandsLogic.CollectionManager;
import lombok.Setter;
import manager.MessageToSer;

@Setter
public class InfoCommand implements Command{
    private final String NAME = "info";
    CollectionManager collectionManager;


    public InfoCommand(CollectionManager collectionManager ) {
        this.collectionManager = collectionManager;
    }
    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.info();
        return new CommandStatus("Info about collection",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
