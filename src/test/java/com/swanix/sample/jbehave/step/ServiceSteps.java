package com.swanix.sample.jbehave.step;

import lombok.extern.slf4j.Slf4j;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.springframework.boot.test.web.client.TestRestTemplate;

@Slf4j
public class ServiceSteps {
    private TestRestTemplate testRestTemplate;
    private int port;

    public ServiceSteps(TestRestTemplate testRestTemplate, int port) {
        this.testRestTemplate = testRestTemplate;
        this.port = port;
    }

    @Then("the service with url ($url) should return status: $status")
    public void runGetServiceFromUrlForStatus(String url, String status) {

    }

    @Then("the service with url ($url) should return json: $json")
    public void runGetServiceFromUrlForJsonReturn(String url, String json) {
        Assert.assertEquals(json, testRestTemplate.getForObject("http://localhost:" + port + url, String.class));
    }

    @Then("the post service with url ($url) should return status: $status")
    public void runPostServiceFromUrlForStatus(String url, String status) {

    }

    @Then("the post service with url ($url) should return json: $json")
    public void runPostServiceFromUrlForJsonReturn(String url, String json) {

    }

    @Then("the post service with url ($url) and json string: $inputJson should return status: $status")
    public void runPostServiceFromUrlWithInputJsonForStatus(String url, String inputJson, String status) {

    }

    @Then("the post service with url ($url) and json string: $inputJson should return json: $json")
    public void runPostServiceFromUrlWithInputJsonForJsonString(String url, String inputJson, String json) {

    }

}
