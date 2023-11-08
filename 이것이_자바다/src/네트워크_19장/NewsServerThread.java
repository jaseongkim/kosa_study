package 네트워크_19장;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewsServerThread {

	private static DatagramSocket datagramSocket = null;
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
		datagramSocket.close();
		executorService.shutdownNow();
		System.out.println("서버 종료");

	}

	private static void startServer() {

		Thread thread = new Thread() {
			@Override
			public void run() {

				try {
					datagramSocket = new DatagramSocket(50001);
					System.out.println("서버 연결됨");

					while (true) {

						DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
						datagramSocket.receive(receivePacket);

						executorService.execute(() -> {

							try {
								String msg = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");
								SocketAddress socketAddress = receivePacket.getSocketAddress();

								for (int i = 1; i < 11; i++) {
									String news = msg + ": 뉴스" + i;
									byte[] bytes = news.getBytes("UTF-8");
									DatagramPacket sendPacket = new DatagramPacket(bytes,0, bytes.length, socketAddress);
									datagramSocket.send(sendPacket);
								}

							} catch (Exception e) {

							}

						});

					}

				} catch (Exception e) {
					System.out.println("서버 끊김" + e.getMessage());
				}

			}

		};
		thread.start();

	}

}
