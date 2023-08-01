package servise;

import org.aeonbits.owner.Config;
@Config.Sources("classpath:Application.properties")
public interface TestConfig extends Config {

    @Key("login.url")
    String url();

    @Key("login.login")
    String user();

    @Key("login.password")
    String password();
}
