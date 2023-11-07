package 네트워크_19장;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

	private static ServerSocket serverSocket = null;

	public static void main(String[] args) {

		startServer();

		Scanner sc = new Scanner(System.in);

		while (true) {
			String key = sc.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}

		}

		sc.close();

		stopServer();

	}

	public static void startServer() {

		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");

					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다림\n");

						Socket socket = serverSocket.accept();

						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();

						System.out.println("[서버] " + isa.getHostName() + " 의 연결 요청을 수락함");

						DataInputStream dis = new DataInputStream(socket.getInputStream());

						String msg = dis.readUTF();

						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

						dos.writeUTF(msg);

						dos.flush();
						System.out.println("[서버] 받은 데이터를 다시 보냄" + msg);

						socket.close();
						System.out.println("[서버] " + isa.getHostName() + " 의 연결을 끊음");
					}

				} catch (IOException e) {
					System.out.println("[서버]" + e.getMessage());
				}

			}

		});
		thread.start();
	}

	public static void stopServer() {
		try {
			serverSocket.close();
			System.out.println("[서버] 종료됨");
		} catch (IOException e) {
		}
	}

}
