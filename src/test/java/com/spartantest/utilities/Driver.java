package com.spartantest.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    //private static variables
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();
    private static ChromeOptions chromeOptions;
    private static FirefoxOptions firefoxOptions;
    private static URL url;

    //Private Constructor: No one can create object of driver Class
// Everyone should call static getter method
    private Driver() {

    }

    /**
     * Synchronized makes method thread safe. It ensure that only 1 thread can use it at the time.
     * Thread safety reduces performance but i makes everything safe.
     */
    public synchronized static WebDriver getDriver() {

        //if webDriver object does not exist
        // create it
        if (driverPool.get() == null) {
            // specify browser type in configuration.properties files
            String browser = ConfigurationReader.getProperty("browser").toLowerCase();

            // browser=firefox
            if (System.getProperty("browser") != null) {
                browser = System.getProperty("browser");
            }

            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driverPool.set(new ChromeDriver(chromeOptions));
                    break;
                case "remote-chrome":
                    chromeOptions = new ChromeOptions();
                    try {
                        URL url = new URL( (ConfigurationReader.getProperty("remoteDriver")));
                        driverPool.set(new RemoteWebDriver(url, chromeOptions));
                    } catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    firefoxOptions = new FirefoxOptions();
                    try {
                        URL url = new URL( (ConfigurationReader.getProperty("remoteDriver")));
                        driverPool.set(new RemoteWebDriver(url, firefoxOptions));
                    } catch (MalformedURLException e){
                        e.printStackTrace();
                    }
                    break;

                case "chromeheadless":
                    //to run chrome without interface (headless mode)
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setHeadless(true);
                    driverPool.set(new ChromeDriver(options));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    break;
                default:
                    throw new RuntimeException("Wrong BrowserUtils Name!");
            }


        }

        return driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
