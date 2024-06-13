package awesomecucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        plugin = {"pretty","html:target/cucumber.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //dryRun = true,
        monochrome = true,
        //tags="@scenario1",
        glue={"awesomecucumber.stepDef","awesomecucumber.hooks"},
        features="src/test/resources/awesomecucumber"

)
public class RunCucumberTest extends AbstractTestNGCucumberTests {

    @BeforeClass
    public void beforeClass(){
        System.out.println("\nIn Before Class\n");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("\nIn after Class\n");
    }
}