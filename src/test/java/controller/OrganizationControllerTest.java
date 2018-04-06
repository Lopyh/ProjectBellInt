package controller;

import eas.orika.OrganizationOrika;
import eas.service.OrgService;
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
public class OrganizationControllerTest {
    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    RestTemplate restTemplate = new RestTemplate(requestFactory);

    @Autowired
    OrganizationOrika organizationOrika;

    @Autowired
    OrgService orgService;



    @Test
    public void getById() throws URISyntaxException {
        String url = "http://localhost:8080/api/organization/1";
        OrganizationOrika response = restTemplate.getForObject(new URI(url),OrganizationOrika.class);
        OrganizationOrika organizationOrika = orgService.getById(1);
        Assert.assertEquals(response.getFullName(),organizationOrika.getFullName());
        Assert.assertEquals(response.getPhone(),organizationOrika.getPhone());
        Assert.assertEquals(response.getInn(),organizationOrika.getInn());
        Assert.assertEquals(response.getIsActive(),organizationOrika.getIsActive());
    }



    @Test
    public void updateOrg() {
        String url = "http://localhost:8080/api/organization/update";
        String requestJson = "{\n" +
                "\t\"id\":2,\n" +
                "\t\"name\":\"AVon\",\n" +
                "\t\"fullName\":\"agg Avon\",\n" +
                "\t\"inn\":\"fgsg\",\n" +
                "\t\"kpp\":\"\",\n" +
                "\t\"address\":\"sdgff\",\n" +
                "\t\"phone\":\"5345\",\n" +
                "\t\"isActive\":\"true\"\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }

    @Test
    public void deleteOrg() {
        String url = "http://localhost:8080/api/organization/delete";
        String requestJson = "{\"id\":3}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }

    @Test
    public void saveOrg() {
        String url = "http://localhost:8080/api/organization/save";
        String requestJson = "{\n" +
                "        \"name\":\"Makfa\",\n" +
                "        \"fullName\":\"OAO Makfa\",\n" +
                "        \"inn\":\"2134\",\n" +
                "        \"kpp\":\"asf\",\n" +
                "        \"address\":\"wfghhgj\",\n" +
                "        \"phone\":\"785212\",\n" +
                "        \"isActive\":\"true\"\n" +
                "}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
        String answer = restTemplate.postForObject(url, entity, String.class);

        Assert.assertEquals(answer,"{\"result\":\"success\"}");
    }
}
