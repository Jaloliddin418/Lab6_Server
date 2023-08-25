
package commands;
import commandsLogic.CollectionManager;
import manager.MessageToSer;
import response.ResponseFormer;

import java.util.Objects;

public class ClearCommand implements Command{
    public static final String NAME = "clear";
    private final CollectionManager collectionManager;

    public ClearCommand(CollectionManager manager) {
        this.collectionManager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClearCommand that = (ClearCommand) o;
        return Objects.equals(collectionManager, that.collectionManager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectionManager);
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        collectionManager.clearCollection();
        ResponseFormer.appendLine("Collection is cleared");
        return new CommandStatus("Collection is cleared",true);
    }

    @Override
    public String getName() {
        return NAME;
    }

}
