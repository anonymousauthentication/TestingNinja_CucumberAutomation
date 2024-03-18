package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
                  glue={"stepdefinition","hooks"},
                  publish=true, // store on cloud
                  plugin={"pretty","html:target/CucumberReports/CucumberReport.html"})
 //pretty use for to format output of cucumber output 
 // html use for to create  html report of cucumber test
public class MyRunner {

}
