/**
 * Created by anastasiyahrytsyuk on 2/17/16.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
//@CucumberOptions(tags = {},format = {"pretty", "json:target/cucumber.json","html:target/cucumber.html"}, features = {"src/main/java/com/features/"})

@CucumberOptions(
        features = {"src/main/java/Features/" },
        format = {"pretty", "html:target/cucumber.html"},//what formatters to use
        tags = {"@run"})//what tags to include(@)/exclude(@~)

public class CucumberRunner {
}
