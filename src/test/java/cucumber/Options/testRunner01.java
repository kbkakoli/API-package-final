package cucumber.Options;


	import org.junit.runner.RunWith;	
	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources/feature/",
	                 glue= {"stepDefinitionpack"},
	                 monochrome=true,
	                 plugin= {"pretty","html:target/HTMLReports",
	                         "json:target/JsonReport/Repotr.json",
	                        "junit:target/JUNITReports/Report.xml"})
	
	public class testRunner01 {


}
