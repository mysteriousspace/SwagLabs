package servise.WebDriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

public class LocalWebDriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities desiredCapabilities) {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("disable-logging");
        options.addArguments("disable-infobars");
        options.addArguments("disable-translate");
        options.addArguments("disable-plugins");
        options.addArguments("disable-extensions");
        options.addArguments("disable-web-security");
        options.addArguments("no-default-browser-check");
        options.addArguments("no-sandbox");
        options.addArguments("no-first-run");
        options.addArguments("silent");
        options.addArguments("window-size=1920,1080");
        options.addArguments("lang=ru");
        options.addArguments("disable-gpu");
        options.addArguments("disable-notifications");
        options.addArguments("disable-cache");
        options.addArguments("disable-cookies");

        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "ignore");
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "normal");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().setScriptTimeout(120, TimeUnit.MILLISECONDS);
        return driver;
    }
}
