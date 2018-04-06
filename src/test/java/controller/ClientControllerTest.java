package controller;

import eas.service.ClientService;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@WebAppConfiguration("web.xml")
@ContextConfiguration(locations = "classpath:/appConfig.xml")
public class ClientControllerTest {

    @Autowired
    ClientService clientService;

    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    RestTemplate restTemplate = new RestTemplate(requestFactory);



    @Test
    public void hashCodeString() throws URISyntaxException {
        String url = "http://localhost:8080/api/activation?code=qwer123";
        String response = restTemplate.getForObject(new URI(url),String.class);
        Assert.assertEquals(response, clientService.hashCode("qwer123"));
    }

    @Test
    public void registerClient() {
        String url = "http://localhost:8080/api/register";
        String requestJson = "{\n" +
                "        \"login\":\"Pahsa321\",\n" +
                "        \"password\":\"lolly\",\n" +
                "        \"name\":\"Pavel\"\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }

    @Test
    public void loginClient() {
        String url = "http://localhost:8080/api/login";
        String requestJson = "{\n" +
                "        \"login\":\"Pahsa322\",\n" +
                "        \"password\":\"lolly\"\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }
}
