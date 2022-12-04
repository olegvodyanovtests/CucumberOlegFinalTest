package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SolutionHooks {
    public static WebDriver webDriver;

    @Before
    public static void beforeScenario() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After
    public static void afterScenario() {
        webDriver.quit();
    }

    @Before("@test_assignment")
    public static void beforeScenario(Scenario scenario) {
        System.out.println("Название сценария: " + scenario.getName());
    }

}
