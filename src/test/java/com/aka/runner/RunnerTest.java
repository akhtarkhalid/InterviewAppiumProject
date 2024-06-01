package com.aka.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"summary","pretty","html:target/cucumber"},
        features={"src/test/featurefiles"},
        glue={"com.aka.stepdef"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true,
        dryRun = true

)
public class RunnerTest {

}
