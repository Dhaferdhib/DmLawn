package domain;


import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber"}, tags = {"@Lawn"}
)
public class MowerLawnCucumberTest {
}
