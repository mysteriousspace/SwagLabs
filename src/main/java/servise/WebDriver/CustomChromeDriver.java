package servise.WebDriver;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

public class CustomChromeDriver implements WebDriverProvider {
    /**
     * Параметр --headless отвечает за запуск без графического интерфейса
     * Обновил селенид до последней версии,
     * почитав документацию нашел вариант реализации создания драйвера и его обновления
     * @param capabilities
     * @return
     */
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-cache");
        options.addArguments("--disable-cookies");
        options.addArguments("-incognito");
        SeleniumManager.getInstance().getDriverPath(options, false);
        return new ChromeDriver(options);
    }
}
