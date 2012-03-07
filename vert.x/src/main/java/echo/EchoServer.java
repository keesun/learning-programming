package echo;

import org.vertx.java.core.Handler;
import org.vertx.java.core.app.VertxApp;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.net.NetServer;
import org.vertx.java.core.net.NetSocket;

/**
 * @author Keesun Baik
 */
public class EchoServer implements VertxApp{
	
	NetServer server;

	@Override
	public void start() throws Exception {
		server = new NetServer().connectHandler(new Handler<NetSocket>() {
			public void handle(final NetSocket netSocket) {
				System.out.println("누가 왔다.... " + netSocket);
				netSocket.dataHandler(new Handler<Buffer>() {
					public void handle(Buffer buffer) {
						netSocket.write(buffer);
					}
				});
			}
		}).listen(8080);
	}

	@Override
	public void stop() throws Exception {
		server.close();
	}
}
