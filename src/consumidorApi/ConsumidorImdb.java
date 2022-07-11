package consumidorApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class ConsumidorImdb {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		HttpRequest request =  HttpRequest
				.newBuilder()
				.uri(URI.create("https://imdb-api.com/en/API/Top250Movies/<api_key>"))
				.GET()
				.header("Accept", "application/json")
				.timeout(Duration.ofSeconds(20))
				.build();
		
		HttpClient client = HttpClient
				.newBuilder()
				.connectTimeout(Duration.ofSeconds(20))
				.build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		
		System.out.println(response.body());
	}
}
