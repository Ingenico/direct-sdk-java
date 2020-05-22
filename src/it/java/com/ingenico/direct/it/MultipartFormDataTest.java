package com.ingenico.direct.it;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import com.ingenico.direct.BodyHandler;
import com.ingenico.direct.Communicator;
import com.ingenico.direct.CommunicatorConfiguration;
import com.ingenico.direct.Factory;
import com.ingenico.direct.MultipartFormDataObject;
import com.ingenico.direct.MultipartFormDataRequest;
import com.ingenico.direct.ResponseHeader;
import com.ingenico.direct.UploadableFile;
import com.ingenico.direct.defaultimpl.DefaultMarshaller;

public class MultipartFormDataTest extends ItTest {

	@Test
	public void testMultipartFormDataUploadPostMultipartFormDataObjectWithResponse() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				@SuppressWarnings("unchecked")
				Map<String, Object> response = communicator.post("/post", null, null, multipart, Map.class, null);

				Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> files = (Map<String, Object>) response.get("files");
				Assert.assertEquals(1, files.size());
				Assert.assertNotNull(files.get("file"));
				Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
				Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

				Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> form = (Map<String, Object>) response.get("form");
				Assert.assertEquals(1, form.size());
				Assert.assertNotNull(form.get("value"));
				Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
				Assert.assertEquals(form.get("value"), "Hello World");
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	@Test
	public void testMultipartFormDataUploadPostMultipartFormDataRequestWithResponse() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				@SuppressWarnings("unchecked")
				Map<String, Object> response = communicator.post("/post", null, null, new MultipartFormDataObjectWrapper(multipart), Map.class, null);

				Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> files = (Map<String, Object>) response.get("files");
				Assert.assertEquals(1, files.size());
				Assert.assertNotNull(files.get("file"));
				Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
				Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

				Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> form = (Map<String, Object>) response.get("form");
				Assert.assertEquals(1, form.size());
				Assert.assertNotNull(form.get("value"));
				Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
				Assert.assertEquals(form.get("value"), "Hello World");
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	@Test
	public void testMultipartFormDataUploadPostMultipartFormDataObjectWithBodyHandler() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				communicator.post("/post", null, null, multipart, new BodyHandler() {

					@Override
					public void handleBody(InputStream bodyStream, List<ResponseHeader> headers) {
						@SuppressWarnings("unchecked")
						Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

						Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> files = (Map<String, Object>) response.get("files");
						Assert.assertEquals(1, files.size());
						Assert.assertNotNull(files.get("file"));
						Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
						Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

						Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> form = (Map<String, Object>) response.get("form");
						Assert.assertEquals(1, form.size());
						Assert.assertNotNull(form.get("value"));
						Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
						Assert.assertEquals(form.get("value"), "Hello World");
					}
				}, null);
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	@Test
	public void testMultipartFormDataUploadPostMultipartFormDataRequestWithBodyHandler() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				communicator.post("/post", null, null, new MultipartFormDataObjectWrapper(multipart), new BodyHandler() {

					@Override
					public void handleBody(InputStream bodyStream, List<ResponseHeader> headers) {
						@SuppressWarnings("unchecked")
						Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

						Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> files = (Map<String, Object>) response.get("files");
						Assert.assertEquals(1, files.size());
						Assert.assertNotNull(files.get("file"));
						Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
						Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

						Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> form = (Map<String, Object>) response.get("form");
						Assert.assertEquals(1, form.size());
						Assert.assertNotNull(form.get("value"));
						Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
						Assert.assertEquals(form.get("value"), "Hello World");
					}
				}, null);
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	@Test
	public void testMultipartFormDataUploadPutMultipartFormDataObjectWithResponse() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				@SuppressWarnings("unchecked")
				Map<String, Object> response = communicator.put("/put", null, null, multipart, Map.class, null);

				Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> files = (Map<String, Object>) response.get("files");
				Assert.assertEquals(1, files.size());
				Assert.assertNotNull(files.get("file"));
				Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
				Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

				Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> form = (Map<String, Object>) response.get("form");
				Assert.assertEquals(1, form.size());
				Assert.assertNotNull(form.get("value"));
				Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
				Assert.assertEquals(form.get("value"), "Hello World");
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	@Test
	public void testMultipartFormDataUploadPutMultipartFormDataRequestWithResponse() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				@SuppressWarnings("unchecked")
				Map<String, Object> response = communicator.put("/put", null, null, new MultipartFormDataObjectWrapper(multipart), Map.class, null);

				Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> files = (Map<String, Object>) response.get("files");
				Assert.assertEquals(1, files.size());
				Assert.assertNotNull(files.get("file"));
				Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
				Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

				Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
				@SuppressWarnings("unchecked")
				Map<String, Object> form = (Map<String, Object>) response.get("form");
				Assert.assertEquals(1, form.size());
				Assert.assertNotNull(form.get("value"));
				Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
				Assert.assertEquals(form.get("value"), "Hello World");
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	@Test
	public void testMultipartFormDataUploadPutMultipartFormDataObjectWithBodyHandler() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				communicator.put("/put", null, null, multipart, new BodyHandler() {

					@Override
					public void handleBody(InputStream bodyStream, List<ResponseHeader> headers) {
						@SuppressWarnings("unchecked")
						Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

						Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> files = (Map<String, Object>) response.get("files");
						Assert.assertEquals(1, files.size());
						Assert.assertNotNull(files.get("file"));
						Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
						Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

						Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> form = (Map<String, Object>) response.get("form");
						Assert.assertEquals(1, form.size());
						Assert.assertNotNull(form.get("value"));
						Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
						Assert.assertEquals(form.get("value"), "Hello World");
					}
				}, null);
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	@Test
	public void testMultipartFormDataUploadPutMultipartFormDataRequestWithBodyHandler() throws URISyntaxException, IOException {

		CommunicatorConfiguration configuration = getCommunicatorConfiguration();
		configuration.setApiEndpoint(URI.create("http://httpbin.org"));

		Communicator communicator = Factory.createCommunicator(configuration);
		try {
			InputStream content = getClass().getResourceAsStream("/itconfiguration.properties");
			try {
				MultipartFormDataObject multipart = new MultipartFormDataObject();
				multipart.addFile("file", new UploadableFile("file.txt", content, "text/plain"));
				multipart.addValue("value", "Hello World");

				communicator.put("/put", null, null, new MultipartFormDataObjectWrapper(multipart), new BodyHandler() {

					@Override
					public void handleBody(InputStream bodyStream, List<ResponseHeader> headers) {
						@SuppressWarnings("unchecked")
						Map<String, Object> response = DefaultMarshaller.INSTANCE.unmarshal(bodyStream, Map.class);

						Assert.assertThat(response.get("files"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> files = (Map<String, Object>) response.get("files");
						Assert.assertEquals(1, files.size());
						Assert.assertNotNull(files.get("file"));
						Assert.assertThat(files.get("file"), Matchers.instanceOf(String.class));
						Assert.assertThat((String) files.get("file"), Matchers.containsString("\ndirect.api.endpoint.host"));

						Assert.assertThat(response.get("form"), Matchers.instanceOf(Map.class));
						@SuppressWarnings("unchecked")
						Map<String, Object> form = (Map<String, Object>) response.get("form");
						Assert.assertEquals(1, form.size());
						Assert.assertNotNull(form.get("value"));
						Assert.assertThat(form.get("value"), Matchers.instanceOf(String.class));
						Assert.assertEquals(form.get("value"), "Hello World");
					}
				}, null);
			} finally {
				content.close();
			}
		} finally {
			communicator.close();
		}
	}

	private static final class MultipartFormDataObjectWrapper implements MultipartFormDataRequest {

		private final MultipartFormDataObject multipart;

		private MultipartFormDataObjectWrapper(MultipartFormDataObject multipart) {
			this.multipart = multipart;
		}

		@Override
		public MultipartFormDataObject toMultipartFormDataObject() {
			return multipart;
		}
	}
}
