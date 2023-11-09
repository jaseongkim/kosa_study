package 네트워크_19장;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {

	ServerSocket serverSocket;
	ExecutorService executorService = Executors.newFixedThreadPool(100);
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());

	public void startServer() throws IOException {

		serverSocket = new ServerSocket(50001);
		System.out.println("서버 시작");

		Thread thread = new Thread(() -> {

			try {
				while (true) {
					Socket socket = serverSocket.accept();
					SocketClient sc = new SocketClient(this, socket);
				}
			} catch (IOException e) {
			}

		});
		thread.start();
	} // end startServer

	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIP;
		chatRoom.put(key, socketClient);
		System.out.println("입장 " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}

	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIP;
		chatRoom.remove(key);
		System.out.println("나감 " + key);
		System.out.println("현재 채팅자 수 : " + chatRoom.size() + "\n");
	}

	public void sendToAll(SocketClient send, String message) {
		JSONObject json = new JSONObject();
		json.put("clientIP", send.clientIP);
		json.put("chatName", send.chatName);
		json.put("message", message);

		String msg = json.toString();

		Collection<SocketClient> socketClient = chatRoom.values();
		for (SocketClient sc : socketClient) {
			if (sc == send) {
				continue;
			}
			sc.send(msg);
		}
	}

	public void stopServer() {
		try {
			serverSocket.close();
			executorService.shutdownNow();
			chatRoom.values().stream().forEach(sc -> sc.close());
			System.out.println("서버 종료");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			ChatServer chatServer = new ChatServer();
			chatServer.startServer();

			Scanner sc = new Scanner(System.in);
			while (true) {
				String key = sc.nextLine();
				if (key.toLowerCase().equals("q")) {
					break;
				}
			}
			sc.close();

			chatServer.stopServer();
		} catch (IOException e) {
			System.out.println("서버" + e.getMessage());
		}

	}

}
