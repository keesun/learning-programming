package fanout;

import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.app.VertxApp;
import org.vertx.java.core.app.cli.VertxMgr;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.net.NetServer;
import org.vertx.java.core.net.NetSocket;
import org.vertx.java.core.shared.SharedData;

import java.util.Set;

/**
 * @author Keesun Baik
 */
public class FanoutServer implements VertxApp{
	
	NetServer server;
	
	@Override
	public void start() throws Exception {
		final Set<Long> connections = SharedData.getSet("connections");
		System.out.println("shared data: " + System.identityHashCode(connections));
		
		server = new NetServer().connectHandler(new Handler<NetSocket>() {
			@Override
			public void handle(NetSocket socket) {
				connections.add(socket.writeHandlerID);
				socket.dataHandler(new Handler<Buffer>() {
					@Override
					public void handle(Buffer buffer) {
						for(Long connectionId : connections) {
							Vertx.instance.sendToHandler(connectionId, buffer);
						}
					}
				});
			}
		}).listen(8080);
	}

	@Override
	public void stop() throws Exception {
		server.close();
	}
	
	public static void main(String... args) {
		String[] argsString = "run -main fanout.FanoutServer -cp test-classes".split(" ");
		VertxMgr.main(argsString);
	}

}
