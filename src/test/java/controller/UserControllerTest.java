package controller;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebAppConfiguration("web.xml")
@ContextConfiguration(locations = "classpath:/appConfig.xml")
public class UserControllerTest {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    RestTemplate restTemplate = new RestTemplate(requestFactory);

    @Test
    public void updateUser() {
        String url = "http://localhost:8080/api/user/update";
        String requestJson = "{\n" +
                "        \"id\":2,\n" +
                "        \"firstName\":\"Pavel\",\n" +
                "        \"lastName\":\"Dikin\",\n" +
                "        \"middleName\":\"Sergeevich\",\n" +
                "        \"position\":\"Programmer\",\n" +
                "        \"phone\":\"916\",\n" +
                "        \"docName\":\"Passport of the citizen of the Russian Federation\",\n" +
                "        \"docNumber\":\"5432\",\n" +
                "        \"docDate\":\"2015-01-20\",\n" +
                "        \"citizenshipName\":\"\",\n" +
                "        \"citizenshipCode\":\"643\",\n" +
                "        \"isIdentified\":\"true\"\n" +
                "       \n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }

    @Test
    public void deleteUser() {
        String url = "http://localhost:8080/api/user/delete";
        String requestJson = "{\n" +
                "        \"id\":3\n" +
                "       \n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }

    @Test
    public void saveUser() {
        String url = "http://localhost:8080/api/user/save";
        String requestJson = "{\n" +
                "        \"officeId\":1,\n" +
                "        \"firstName\":\"Pavel\",\n" +
                "        \"lastName\":\"Dikin\",\n" +
                "        \"middleName\":\"Sergeevich\",\n" +
                "        \"position\":\"Programmer\",\n" +
                "        \"phone\":\"916\",\n" +
                "        \"docCode\":\"21\",\n" +
                "        \"docName\":\"\",\n" +
                "        \"docNumber\":\"5432\",\n" +
                "        \"docDate\":\"2015-01-20\",\n" +
                "        \"citizenshipName\":\"\",\n" +
                "        \"citizenshipCode\":\"643\",\n" +
                "        \"isIdentified\":\"true\"\n" +
                "       \n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }
}
