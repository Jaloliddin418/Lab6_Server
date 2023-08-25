import commandsLogic.CollectionManager;
import commandsLogic.CommandAdder;
import data.Dragon;
import database.CSVDataBase;
import manager.MessageToSer;
import reader.AsyncConsoleInput;
import reader.ReaderC;
import response.ResponseFormer;
import response.ResponseToClient;
import java.io.*;
import java.net.*;;
import java.util.Vector;

import static response.ClientHandle.handleClient;

public class Main {
//    public static void main(String[] args) {
//        AsyncConsoleInput asyncConsoleInput = AsyncConsoleInput.getInstance();
//        Thread consoleInputThread = new Thread(asyncConsoleInput);
//        consoleInputThread.start();
//
//        ReaderC readerC = new ReaderC();
//        CollectionManager collectionManager = new CollectionManager(new Vector<>());
//        CommandAdder commandAdder = new CommandAdder(collectionManager);
//        for(Dragon d : CSVDataBase.readCoordinates("csv_data.csv")){
//            collectionManager.add(d);
//        };
//        commandAdder.setCommand(readerC);
//
//        while (true) {
//
//            try {
//                // Создание серверного сокета
//                ServerSocket serverSocket = new ServerSocket(1234);
//                System.out.println("Сервер запущен и ожидает подключений...");
//
//
//                // Ожидание подключения клиента
//                Socket clientSocket = serverSocket.accept();
//                System.out.println("Подключился клиент: " + clientSocket.getInetAddress());
//
//                // Получение сообщения от клиента
//                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
//                MessageToSer message = MessageToSer.fromJson((String) inputStream.readObject());
//
//                readerC.read(message);
//                ResponseToClient responseToClient = new ResponseToClient();
//                responseToClient.setResponseText(ResponseFormer.flush());
//
//                // Отправка ответа клиенту
//                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
//                outputStream.writeObject(responseToClient.toJson());
//                outputStream.flush();
//
//                //trash
//                if (asyncConsoleInput.isTextReady()) {
//                    if (asyncConsoleInput.getText().equals("save")) {
//                        collectionManager.saveCollection();
//                    }
//                }
//
//                // Закрытие ресурсов
//                inputStream.close();
//                outputStream.close();
//                clientSocket.close();
//            } catch (Exception e) {
//                System.out.println("Exception in server" + e.getMessage());
////                try {
////                    Thread.sleep(10000);
////                    ResponseFormer.appendLine("is read");
////                } catch (InterruptedException ex) {
////                    ex.printStackTrace();
////                }
//            }
//        }
//    }

    private static final int RECONNECT_INTERVAL = 5000;

    public static void main(String[] args) {
        AsyncConsoleInput asyncConsoleInput = AsyncConsoleInput.getInstance();
        Thread consoleInputThread = new Thread(asyncConsoleInput);
        consoleInputThread.start();

        ReaderC readerC = new ReaderC();
        CollectionManager collectionManager = new CollectionManager(new Vector<>());
        CommandAdder commandAdder = new CommandAdder(collectionManager);
        for (Dragon d : CSVDataBase.readCoordinates("csv_data.csv")) {
            collectionManager.add(d);
        }
        commandAdder.setCommand(readerC);

        try {
            // Создание серверного сокета
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Сервер запущен и ожидает подключений...");

            while (true) {
                try {
                    // Ожидание подключения клиента
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Подключился клиент: " + clientSocket.getInetAddress());

                    // Создание и запуск отдельного потока для обработки клиента
                    Thread clientThread = new Thread(() -> handleClient(clientSocket, readerC));
                    clientThread.start();
                } catch (IOException e) {
                    System.out.println("Ошибка при подключении клиента: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании серверного сокета: " + e.getMessage());
        }
    }
}




