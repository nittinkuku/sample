package com.swanix.sample.integrationtest;

import com.swanix.sample.app.SampleApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(classes = SampleApplication.class)
@AutoConfigureMockMvc
//@WebMvcTest - if you want to test only the web layer (this will only instantiate web layer and not the entire context)
public class TestWithoutEmbeddedServer {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSampleController() throws Exception {
        mockMvc.perform(get("/sample/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello!!!")));
    }

}