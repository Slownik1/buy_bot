
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;

class HelloSelenium {
        public static void main(String[] args) {

            //TEST DATA
            String pathTest="https://www.onet.pl/";
            String buttonPathTest="//*[@id='tabMenu']/div/ul/li[1]/a";

            //ACTUAL DATA
            String path = "https://sklep.pgg.pl/produkty/13/6/pieklorz-ekogroszek-1000-kg-luz";
            String buttonPath="//*[@id=main]/div/div[1]/div[3]/div[3]/form/button";

            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            option.setExperimentalOption("useAutomationExtension", false);
            WebDriver driver = new ChromeDriver(option);

            driver.get(pathTest);
            try {
                Thread.sleep(5000);
            }catch (Exception e){

            }


            WebElement cartBox =driver.findElement(By.xpath(buttonPathTest));
            cartBox.click();

        }
    }

