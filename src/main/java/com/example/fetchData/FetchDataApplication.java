package com.example.fetchData;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class FetchDataApplication {

	public static void main(String[] args) {

		try {
			URL url = new URL(" https://api.zippopotam.us/us/33162");
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
