package lesson6.socketexamples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp { // создание сервера
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            System.out.println("Сервер запущен. Ожидает запросы от клиента...");

            Socket socket = serverSocket.accept(); // вызвали метод "accept", чтобы сокет начал получать сообщения
            System.out.println("Клиент подключился к серверу");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream()); // в конструктор передаем потоки из сокетов
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) { // пока будет производиться обмен будем считывать из DataInputStream строки
                String clientRequest = dataInputStream.readUTF();

                if (clientRequest.equals("end")) break; // "ключ" по которому мы перестаем слушать поток

                System.out.println("Запрос от клиента: " + clientRequest);
                dataOutputStream.writeUTF(clientRequest); // отправляем обратно, то что прислал нам клиент
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
