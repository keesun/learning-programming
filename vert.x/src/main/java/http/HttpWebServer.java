package http;

import org.vertx.java.core.Handler;
import org.vertx.java.core.app.VertxApp;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;

import java.io.BufferedWriter;
import java.io.OutputStream;

/**
 * @author Keesun Baik
 */
public class HttpWebServer implements VertxApp{

	HttpServer httpServer;

	@Override
	public void start() throws Exception {
		httpServer = new HttpServer().requestHandler(new Handler<HttpServerRequest>() {
			public void handle(HttpServerRequest req) {
				System.out.println(req);
				System.out.println(req.uri);
				System.out.println(req.path);
				req.response.putHeader("Content-Type", "text/html; charset=UTF-8")
					.end("<html><h1>Hello Vert.x</hi></html>");
			}
		}).listen(8080);
	}

	@Override
	public void stop() throws Exception {
		httpServer.close();
	}
	
	public static void main(String... args) {
		OutputStream out = null;
		BufferedWriter writer = null;

	}
}
