package com.swanix.sample.integrationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.swanix.sample.app.SampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(classes = SampleApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestWithEmbeddedServer {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testSampleController() throws Exception {
        assertEquals("Hello!!!",testRestTemplate.getForObject("http://localhost:" + port + "/sample/hello", String.class));
    }

}