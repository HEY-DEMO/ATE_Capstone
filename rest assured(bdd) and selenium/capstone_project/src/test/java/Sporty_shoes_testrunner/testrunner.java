package Sporty_shoes_testrunner;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = {"Sporty_shoes_bdd" })
public class testrunner {

}