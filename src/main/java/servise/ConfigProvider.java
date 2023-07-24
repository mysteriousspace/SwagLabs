package servise;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();
    static Config readConfig(){
        return ConfigFactory.load("application.conf");
    }
    String URL = readConfig().getString("url");
    String LOGIN = readConfig().getString("userParams.test.login");
    String PASSWORD = readConfig().getString("userParams.test.password");
}
