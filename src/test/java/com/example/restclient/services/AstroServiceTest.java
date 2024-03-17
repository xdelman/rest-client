package com.example.restclient.services;

import com.example.restclient.json.AstroResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {

    private final Logger logger = LoggerFactory.getLogger(AstroService.class);

    @Autowired
    private AstroService service;

    @Test
    void getAstroResponse() {
        AstroResponse response = service.getAstroResponse();

        logger.info(response.toString());
        assertAll(
                () -> assertTrue(response.number() > 0),
                () -> assertEquals("success", response.message()),
                () -> assertEquals(response.number(), response.people().size())
        );
    }
}
