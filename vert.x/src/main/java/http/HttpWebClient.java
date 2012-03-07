package http;

import org.vertx.java.core.Handler;
import org.vertx.java.core.app.VertxApp;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.HttpClient;
import org.vertx.java.core.http.HttpClientResponse;

/**
 * @author Keesun Baik
 */
public class HttpWebClient implements VertxApp {

	HttpClient httpClient;

	@Override
	public void start() throws Exception {
		httpClient = new HttpClient().setHost("localhost").setPort(8080);
		//routing
		httpClient.getNow("/hello", new Handler<HttpClientResponse>() {
			public void handle(HttpClientResponse response) {
				response.dataHandler(new Handler<Buffer>() {
					public void handle(Buffer buffer) {
						System.out.println(buffer);
					}
				});
			}
		});
	}

	@Override
	public void stop() throws Exception {
		httpClient.close();
	}
}