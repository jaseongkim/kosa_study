package 네트워크_19장;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class NewsClient {

	public static void main(String[] args) {

		try {
			DatagramSocket datagramSocket = new DatagramSocket();

			String data = "정치";

			byte[] bytes = data.getBytes("UTF-8");

			DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length,
					new InetSocketAddress("localhost", 50001));

			datagramSocket.send(sendPacket);

			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(new byte[1024], 1024);
				datagramSocket.receive(receivePacket);

				String news = new String(receivePacket.getData(), 0, receivePacket.getLength(), "UTF-8");

				System.out.println(news);

				if (news.contains("뉴스10")) {
					break;
				}

			}

			datagramSocket.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
