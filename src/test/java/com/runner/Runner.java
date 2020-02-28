package test.java.com.runner;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import test.java.com.tests.JohnLewisTest;

import java.util.Collections;
import java.util.List;


public class Runner extends JUnitStories {

    private final Configuration configuration;

    public Runner() {
        super();
        configuration = new MostUsefulConfiguration();
        configuration.usePendingStepStrategy(new FailingUponPendingStep());
        EmbedderControls embedderControls = configuredEmbedder().embedderControls();
        embedderControls.doGenerateViewAfterStories(false);
    }

    @Override
    public Configuration configuration() {
        return configuration;
    }

    @Test
    public void test() throws Throwable {
        super.run();
    }

    @Override
    protected List<String> storyPaths() {
        String searchDir = "./src";
        List<String> storyPaths = new StoryFinder().findPaths(searchDir,
                Collections.singletonList("/test/resources/story/johnLewis.story"),
                Collections.singletonList("/test/resources/story/*excluded.story"));
        return storyPaths;
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new JohnLewisTest());
    }
}
