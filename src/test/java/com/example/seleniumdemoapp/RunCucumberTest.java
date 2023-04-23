package com.example.seleniumdemoapp;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/seleniumdemoapp/resources", plugin = {"pretty", "html:target/cucumber-reports", "json:target/Cucumber.json", "junit:target/cucumber.xml"})
public class RunCucumberTest {
}
