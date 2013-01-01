package chapter01;

import java.io.*;
import java.net.Socket;

/**
 * @author Keesun Baik
 */
public class SocketDemo {

	public static void main(String[] args) throws IOException, InterruptedException {
		Socket socket = new Socket("127.0.0.1", 8080);
		PrintWriter writer = new PrintWriter(socket.getOutputStream());
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		writer.println("GET /index.html HTTP/1.1");
		writer.println("Host: localhost:8080");
		writer.println("Connection: keep-alive");
		writer.println("Cache-Control: max-age=0");
		writer.println("User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_5) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.101 Safari/537.11");
		writer.println("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
		writer.println("Accept-Encoding: gzip,deflate,sdch");
		writer.println("Accept-Language: ko-KR,ko;q=0.8,en-US;q=0.6,en;q=0.4");
		writer.println("Accept-Charset: windows-949,utf-8;q=0.7,*;q=0.3");
		writer.println();
		writer.println("body=body");
		writer.flush();

		boolean loop = true;
		StringBuffer sb = new StringBuffer(8096);
		while(loop) {
			if(reader.ready()) {
				System.out.println("response");
				int i = 0;
				while (i != -1) {
					i = reader.read();
					sb.append((char)i);
				}
				loop = false;
			}
			Thread.currentThread().sleep(50);
		}

		System.out.println(sb.toString());
		socket.close();
	}
}
