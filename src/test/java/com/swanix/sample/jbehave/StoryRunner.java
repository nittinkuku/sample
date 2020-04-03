package com.swanix.sample.jbehave;

import com.github.valfirst.jbehave.junit.monitoring.JUnitReportingRunner;
import com.swanix.sample.jbehave.step.SampleSteps;
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
import org.junit.runner.RunWith;

import java.net.URL;
import java.util.List;

@Slf4j
@RunWith(JUnitReportingRunner.class)
public class StoryRunner extends JUnitStories {

    private static String storyPath = "resources/stories/**/*.story";

    static {
        String systemStoryPath = System.getProperty("story.path");
        if (systemStoryPath != null && !systemStoryPath.isEmpty()) {
            storyPath = systemStoryPath;
        }
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
        return new InstanceStepsFactory(configuration(), new SampleSteps());
    }

    @Override
    public List<String> storyPaths() {
        URL fromPath = CodeLocations.codeLocationFromClass(this.getClass());
        log.info("Running with story path {} from path {}", storyPath, fromPath);
        return new StoryFinder().findPaths(fromPath, storyPath, null);
    }

}
