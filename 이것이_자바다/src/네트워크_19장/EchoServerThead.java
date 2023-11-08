package 네트워크_19장;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServerThead {

	private static ServerSocket serverSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

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

	private static void stopServer() {
		try {
			serverSocket.close();
			executorService.shutdownNow();
			System.out.println("서버 종료");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void startServer() {
		Thread thread = new Thread() {

			@Override
			public void run() {
				
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("서버 연결됨");
					
					
					while(true) {
						Socket socket = serverSocket.accept();
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println(isa.getHostName() + " 연결됨");
						
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String msg = dis.readUTF();
						
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(msg);
						dos.flush();
						
						System.out.println("에코 다시 보냄" + msg);
						
						socket.close();
						System.out.println("소켓 연결 끊음");
						
					}
					
					
				} catch (IOException e) {
					System.out.println("서버 연결 끊음" + e.getMessage());
				}
				
			}

		};
		thread.start();

	}

}
