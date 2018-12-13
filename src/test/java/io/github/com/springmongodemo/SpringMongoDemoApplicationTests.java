package io.github.com.springmongodemo;

import io.github.com.springmongodemo.model.Contact;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringMongoDemoApplicationTests {
	private static final String URL = "http://localhost:8080/contact/";
	private static final String JSON_MIME_TYPE = "application/json";
	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllContact() throws IOException {
		HttpUriRequest request = new HttpGet( URL );
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
		String mimeType = ContentType.getOrDefault(httpResponse.getEntity()).getMimeType();
		assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.OK.value());
		assertEquals( JSON_MIME_TYPE, mimeType );
	}

	@Test
	public void testPostContact() throws IOException {
		Contact contact = new Contact();
		contact.setName("New Bean");
		contact.setEmail("bean@gmail.com");
		contact.setAge(20);

		StringEntity entity = new StringEntity(contact.toString(),
				ContentType.APPLICATION_JSON);
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(URL);
		request.setEntity(entity);

		HttpResponse response = httpClient.execute(request);
		String mimeType = ContentType.getOrDefault(response.getEntity()).getMimeType();
		assertEquals(response.getStatusLine().getStatusCode(), HttpStatus.OK.value());
		assertEquals( JSON_MIME_TYPE, mimeType );
	}


}

