package steps;

import api.WeatherApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Assert;

@CucumberContextConfiguration
public class ApiStepDefs {
    private int actualStatus;

    @Given("Get weather from site for city {}")
    public void getWeatherFromSiteForCityNewYork(String city) {
        actualStatus = WeatherApi.getResultCode(city);
    }

    @Then("Status_code equals {}")
    public void statusCodeEquals(int expectedStatus) {
        Assert.assertEquals(expectedStatus, actualStatus);
    }
}
