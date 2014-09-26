package org.rdgie.assetmanagement.util;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.rdgie.assetmanagement.domain.Employee;

public class MessageUtil {
	
	public static void sendMessage(List<Employee> employees) {

		String apiToken = "dad4da8a7d6a0bc40ae935b792627b54f7aaa51c";

		try {
			HttpClient c = HttpClientBuilder.create().build();

			HttpPost request = new HttpPost("https://textit.in/api/v1/messages");
			request.addHeader("Authorization", "Token " + apiToken);
			request.setEntity(new StringEntity("{\"urns\": ["
					+ getNumberString(employees) + "],\"text\":\""+ "Hello, you have an Item to return. Thanks! RDGIE" + "\"}", ContentType.create("application/json")));

			c.execute(request);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getNumberString(List<Employee> employees) {
		String numberString = "";
		for (Employee e : employees) {
			numberString += "\"tel:" + e.getPhone() + "\",";
		}
		return numberString.substring(0, numberString.lastIndexOf(","));
	}

}
