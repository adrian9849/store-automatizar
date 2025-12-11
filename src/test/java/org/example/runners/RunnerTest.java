package org.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org.example.steps", "org.example.DriverManager"},
        plugin = {"pretty"}
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
