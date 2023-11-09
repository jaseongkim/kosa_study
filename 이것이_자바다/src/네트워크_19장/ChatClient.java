package 네트워크_19장;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {

	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	String chatName;

	public void connect() throws IOException {
		socket = new Socket("localhost", 50001);
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
		System.out.println("클라이언트 서버에 연결됨");
	}

	public void receive() {
		Thread thread = new Thread(() -> {

			try {
				while (true) {
					String json = dis.readUTF();
					JSONObject root = new JSONObject(json);
					String clientIP = root.getString("clientIP");
					String chatName = root.getString("chatName");
					String message = root.getString("message");
					System.out.println("<" + clientIP + "@" + chatName + "> " + message);
				}

			} catch (IOException e) {
				System.out.println("클라이언트 연결 끊어짐");
				System.exit(0);
			}

		});
		thread.start();

	}

	public void send(String json) throws IOException {
		dos.writeUTF(json);
		dos.flush();
	}

	public void unConnect() throws IOException {
		socket.close();
	}

	public static void main(String[] args) {

		try {
			ChatClient chatClient = new ChatClient();
			chatClient.connect();

			Scanner sc = new Scanner(System.in);
			chatClient.chatName = sc.nextLine();

			JSONObject jsonObj = new JSONObject();
			jsonObj.put("commend", "incoming");
			jsonObj.put("data", chatClient.chatName);

			String json = jsonObj.toString();

			chatClient.send(json);

			chatClient.receive();

			System.out.println("-----------------------------");
			System.out.println("그만하려면 q를 입력");
			System.out.println("-----------------------------");

			while (true) {
				String message = sc.nextLine();
				if (message.toLowerCase().equals("q")) {
					break;
				}

				jsonObj = new JSONObject();
				jsonObj.put("commend", "message");
				jsonObj.put("data", message);
				json = jsonObj.toString();

				chatClient.send(json);

			}
			sc.close();
			chatClient.unConnect();

		} catch (IOException e) {
			System.out.println("클라이언트 서버 연결 안됨");
		}

	}

}
