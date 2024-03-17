package com.example.restclient.services;

import com.example.restclient.json.AstroResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class AstroService {
    private RestClient restClient;
    private final String baseUrl = "http://api.open-notify.org";

    AstroService(){
        this.restClient = RestClient.create(baseUrl);
    }

    public AstroResponse getAstroResponse(){
       return restClient.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(AstroResponse.class);
    }
}
