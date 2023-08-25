package commands;


import manager.MessageToSer;
import reader.ReaderC;
import response.ResponseFormer;

import java.util.Deque;

public class HistoryCommand implements Command{
    public static final String NAME = "history";

    private final ReaderC readerC;

    public HistoryCommand(ReaderC readerC) {
        this.readerC = readerC;
    }

    @Override
    public CommandStatus execute(MessageToSer message) {
        Deque<String> commandHistory = readerC.getHistory();

        int size = Math.min(commandHistory.size() , 7);
        for (int i = 0; i < size; i++) {
            ResponseFormer.appendLine(commandHistory.removeLast());
        }
        return new CommandStatus("Command history:",true);
    }

    @Override
    public String getName() {
        return NAME;
    }
}
