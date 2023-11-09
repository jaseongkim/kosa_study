package 네트워크_19장;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {

	ChatServer chatServer;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	String clientIP;
	String chatName;

	public SocketClient(ChatServer chatServer, Socket socket) {
		try {
			this.chatServer = chatServer;
			this.socket = socket;

			this.dis = new DataInputStream(socket.getInputStream());

			this.dos = new DataOutputStream(socket.getOutputStream());

			InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();

			this.clientIP = isa.getHostName();

			receive();
		} catch (IOException e) {
		}
	}

	public void receive() {
		chatServer.executorService.execute(() -> {

			try {
				while (true) {
					String receiveJson = dis.readUTF();

					JSONObject jsonObject = new JSONObject(receiveJson);
					String commend = jsonObject.getString("commend");

					switch (commend) {
					case "incoming":
						this.chatName = jsonObject.getString("data");
						chatServer.sendToAll(this, "들어오셨습니다");
						chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonObject.getString("data");
						chatServer.sendToAll(this, message);
						break;
					}

				}
			} catch (IOException e) {
				chatServer.sendToAll(this, "나가셨습니다");
				chatServer.removeSocketClient(this);
			}

		});

	}

	public void send(String json) {
		try {
			dos.writeUTF(json);
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
		}
	}

}
