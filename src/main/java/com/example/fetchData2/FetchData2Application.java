package com.example.fetchData2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
public class FetchData2Application {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://api.nationalize.io/?name=nathaniel");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int responseCode = conn.getResponseCode();
			if (responseCode != 200) {
				throw new RuntimeException("HTTP response code: " + responseCode);
			} else {
				Scanner scanner = new Scanner(url.openStream());
				StringBuilder jsonResult = new StringBuilder();
				while (scanner.hasNext()) {
					jsonResult.append(scanner.nextLine());
				}
				scanner.close();
				System.out.println(jsonResult.toString());
			}
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
