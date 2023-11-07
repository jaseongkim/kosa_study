package 네트워크_19장;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 50001);

			System.out.println("[클라이언트] 연결 성공");

			String msg = "자바가 좋아";

			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

			dos.writeUTF(msg);

			dos.flush();
			System.out.println("[클라이언트] 데이터 보냄 " + msg);

			DataInputStream dis = new DataInputStream(socket.getInputStream());
			String receiveMsg = dis.readUTF();
			System.out.println("[클라이언트] 데이터 받음 : " + receiveMsg);

			socket.close();
			System.out.println("[클라이언트] 연결 끊음");

		} catch (UnknownHostException e) {
		} catch (IOException e) {
		}

	}

}
