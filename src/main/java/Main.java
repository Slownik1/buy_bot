
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

class HelloSelenium {
        public static void main(String[] args) {

            String path = "https://sklep.pgg.pl/produkty/13/6/pieklorz-ekogroszek-1000-kg-luz";

            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            option.setExperimentalOption("useAutomationExtension", false);
            WebDriver driver = new ChromeDriver(option);

            driver.get(path);
            try {
                Thread.sleep(10000);
            }catch (Exception e){

            }


            WebElement cartBox =driver.findElement(By.xpath("//*[@id=main]/div/div[1]/div[3]/div[3]/form/button"));
            cartBox.click();

        }
    }

