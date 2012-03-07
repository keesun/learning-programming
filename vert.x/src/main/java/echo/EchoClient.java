package echo;

import org.vertx.java.core.Handler;
import org.vertx.java.core.app.VertxApp;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.net.NetClient;
import org.vertx.java.core.net.NetSocket;

/**
 * @author Keesun Baik
 */
public class EchoClient implements VertxApp {

    @Override
    public void start() throws Exception {
        NetClient netClient = new NetClient();

        new NetClient().connect(8080, "localhost", new Handler<NetSocket>() {
            @Override
            public void handle(NetSocket socket) {
                System.out.println("Connected!!");

                // 서버에서 메시지가 오면...
                socket.dataHandler(new Handler<Buffer>() {
                    @Override
                    public void handle(Buffer buffer) {
                        System.out.println("서버에서 온 메시지: " + buffer);
                    }
                });

                socket.write("hi");
            }
        });
    }

    @Override
    public void stop() throws Exception {
    }
}
