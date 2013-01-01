package simple;

import org.vertx.java.core.Handler;
import org.vertx.java.core.Vertx;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.deploy.Verticle;

/**
 * @author Keesun Baik
 */
public class SimpleServer extends Verticle {

	@Override
	public void start() throws Exception {
		Vertx vertx = Vertx.newVertx();
		vertx.createHttpServer().requestHandler(new Handler<HttpServerRequest>() {
			public void handle(HttpServerRequest req) {
				String file = req.path.equals("/") ? "index.html" : req.path;
				req.response.sendFile("webroot/" + file);
			}
		}).listen(8080);
	}

}
