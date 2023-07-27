package servise.WebDriver;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserSettings {

    public static void chromeSettings() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--start-maximized");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }
}