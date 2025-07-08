package ru.catinasw.springcourse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "https://reqres.in/api/users/2";
//        String response = restTemplate.getForObject(url, String.class);
//        System.out.println(response);
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", "reqres-free-v1");

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> jsonToSend = new HashMap<>();
        jsonToSend.put("name", "test Name");
        jsonToSend.put("job", "test Job");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend, headers);

        String postUrl = "https://reqres.in/api/users";
        String response = restTemplate.postForObject(postUrl, request, String.class);
        System.out.println(response);
    }
}
