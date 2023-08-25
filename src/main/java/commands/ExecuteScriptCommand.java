//package commands;
//
//
//import manager.MessageToSer;
//import reader.ReaderC;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//import java.util.ArrayDeque;
//
//public class ExecuteScriptCommand implements Command {
//    private final ArrayDeque<String> history = new ArrayDeque<>();
//    private final ReaderC readerC;
//
//    public ExecuteScriptCommand(ReaderC readerC) {
//        this.readerC = readerC;
//    }
//
//
//    @Override
//    public CommandStatus execute(MessageToSer message) {
//
//        if(message.getArg().length == 0){
//            return new CommandStatus("Not enough params",false);
//        }
//        String fileName;
//        try {
//            fileName = String.valueOf(message.getArg()[1]);
//            InputStream reader = new FileInputStream(fileName);
//            if (history.contains(fileName)) {
//                history.clear();
//                return new CommandStatus("Recursion occurred!",false);
//            }
//            history.add(fileName);
//            this.readerC.read(new MessageToSer(reader));
//        } catch (Exception e) {
//            return new CommandStatus(e instanceof FileNotFoundException ?
//                    "File not found" : "Not enough params or error reading file",false);
//        }
//        return new CommandStatus("Script worked successfully",true);
//    }
//
//
//
//    @Override
//    public String getName() {
//        return "execute_script";
//    }
//}
