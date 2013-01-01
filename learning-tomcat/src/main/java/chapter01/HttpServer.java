package chapter01;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Keesun Baik
 */
public class HttpServer {

	public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

	private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

	private boolean shutdown = false;

	public static void main(String[] args) {
		HttpServer httpServer = new HttpServer();
		httpServer.service();
	}

	private void service() {
		ServerSocket serverSocket = null;
		int port = 8080;
		try {
			serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}

		while (!shutdown) {
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;

			try {
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();

				Request request = new Request(input);
				request.parse();

				Response response = new Response(output);
				response.setRequest(request);
				response.sendStaticResource();

				socket.close();

				if(request.getUri() != null) {
					shutdown = request.getUri().equals(SHUTDOWN_COMMAND);
				}

			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
	}
}
