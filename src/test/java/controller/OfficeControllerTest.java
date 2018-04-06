package controller;

import eas.service.OfficeService;
import org.junit.Assert;
import eas.orika.OfficeOrika;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
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
public class OfficeControllerTest {
    @Autowired
    OfficeOrika officeOrika;

    @Autowired
    OfficeService officeService;

    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    RestTemplate restTemplate = new RestTemplate(requestFactory);

    @Test
    public void getById() throws URISyntaxException {
        String url = "http://localhost:8080/api/office/2";
        OfficeOrika response = restTemplate.getForObject(new URI(url),OfficeOrika.class);
        OfficeOrika officeOrika = officeService.getById(2);
        Assert.assertEquals(response.getName(),officeOrika.getName());
        Assert.assertEquals(response.getAddress(),officeOrika.getAddress());
        Assert.assertEquals(response.getPhone(),officeOrika.getPhone());
        Assert.assertEquals(response.getOrgId(),officeOrika.getOrgId());
    }

    @Test
    public void updateOffice() {
        String url = "http://localhost:8080/api/office/update";
        String requestJson = "{\n" +
                "        \"id\":\"1\",\n" +
                "        \"name\":\"\",\n" +
                "        \"address\":\"\",\n" +
                "        \"phone\":\"\",\n" +
                "        \"isActive\":\"true\"\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }

    @Test
    public void deleteOffice() {
        String url = "http://localhost:8080/api/office/delete";
        String requestJson = "{\n" +
                "        \"id\":\"4\"\n" +
                "       \n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }

    @Test
    public void saveOffice() {
        String url = "http://localhost:8080/api/office/save";
        String requestJson = "{\n" +
                "        \"orgId\":1,\n" +
                "        \"name\":\"asgfg\",\n" +
                "        \"address\":\"asgghhhhh\",\n" +
                "        \"phone\":\"12355\",\n" +
                "        \"isActive\":\"true\"\n" +
                "       \n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }


}
