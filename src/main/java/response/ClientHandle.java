package response;

import manager.MessageToSer;
import reader.ReaderC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandle {
    public static void handleClient(Socket clientSocket, ReaderC readerC) {
    try {
        // Получение сообщения от клиента
        ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
        MessageToSer message = MessageToSer.fromJson((String) inputStream.readObject());

        readerC.read(message);
        ResponseToClient responseToClient = new ResponseToClient();
        responseToClient.setResponseText(ResponseFormer.flush());

        // Отправка ответа клиенту
        ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        outputStream.writeObject(responseToClient.toJson());
        outputStream.flush();

        // Закрытие ресурсов
        inputStream.close();
        outputStream.close();
        clientSocket.close();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("Ошибка при обработке клиента: " + e.getMessage());
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}
}
