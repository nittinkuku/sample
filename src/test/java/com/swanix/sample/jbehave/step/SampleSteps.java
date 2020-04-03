package com.swanix.sample.jbehave.step;

import lombok.extern.slf4j.Slf4j;
import org.jbehave.core.annotations.Given;
import org.junit.Assert;

@Slf4j
public class SampleSteps {

    @Given("a sample step")
    public void testStoryRunner() {
        log.info("sample step testStoryRunner method called");
        Assert.assertTrue(true);
    }
}
