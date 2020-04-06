package com.swanix.sample.jbehave;

import com.swanix.sample.app.SampleApplication;
import com.swanix.sample.jbehave.step.SampleSteps;
import com.swanix.sample.jbehave.step.ServiceSteps;
import lombok.extern.slf4j.Slf4j;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.List;

@Slf4j
@SpringBootTest(classes = SampleApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@RunWith(JUnitReportingRunner.class)
@RunWith(SpringRunner.class)
public class StoryRunner extends JUnitStories {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private static String storyPath = "resources/stories/**/*.story";

    static {
        String systemStoryPath = System.getProperty("story.path");
        if (systemStoryPath != null && !systemStoryPath.isEmpty()) {
            storyPath = systemStoryPath;
        }
    }

    @Override
    @Test
    public void run() {
        super.run();
    }

    @Override
    public Configuration configuration() {
        Configuration configuration = super.configuration();
        if (configuration == null) {
            configuration = new MostUsefulConfiguration();
        }
        return configuration
                .useStoryReporterBuilder(new StoryReporterBuilder().withFormats(
                        Format.CONSOLE,
                        Format.XML,
                        Format.STATS,
                        Format.HTML
                ))
                .usePendingStepStrategy(new FailingUponPendingStep())
                .useFailureStrategy(Throwable::printStackTrace);
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new SampleSteps(), new ServiceSteps(testRestTemplate, port));
    }

    @Override
    public List<String> storyPaths() {
        URL fromPath = CodeLocations.codeLocationFromClass(this.getClass());
        log.info("Running with story path {} from path {}", storyPath, fromPath);
        return new StoryFinder().findPaths(fromPath, storyPath, null);
    }

}
