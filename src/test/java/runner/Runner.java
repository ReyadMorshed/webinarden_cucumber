package runner;

import com.vimalselvam.cucumber.listener.Reporter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions (
        // 'features' defines the location of feature files
        features = "C:\\Users\\ASUS\\eclipse-workspace\\webinarden_cucumber\\src\\test\\resources\\Features",
        // 'glue' is used to compile feature files and step definitions in Cucumber
        // and also used here when we have to see if there are any compilation errors
        glue = "stepDefinations",
        tags = "@Regression or @Smoke",
        // When 'dryRun' is true, we do not use tags, otherwise we use tags
        dryRun = false,
        // When 'monochrome' is true, then the console output for the scenarios are readable, otherwise non-readable
        monochrome = true,
        plugin = { "html:target/reports/extent-report.html" }
)

public class Runner {

    

}

