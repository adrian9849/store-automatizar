package org.example.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:target/cucumber/cucumber-report.html",
                "json:target/cucumber/cucumber.json"},
        features = "src/test/resources/features",
        glue = {"org.example.stepdefinition", "org.example.steps", "org.example.core"},
        monochrome = true,
        tags = "@testfeature"
)
public class RunnerTest {}
