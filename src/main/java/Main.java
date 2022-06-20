
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.event.KeyEvent;
import java.util.Collections;

class HelloSelenium {
        public static void main(String[] args) throws InterruptedException {



            //ACTUAL DATA
            String path = "https://portalpasazera.pl";
            String cookiesAccept = "/html/body";
            String departureLocation="//*[@id=\'departureFrom\']";
            String arrivalLocation = "//*[@id=\'arrivalTo\']";
            String directConnection = "//*[@id=\"accessible-body\"]/div/form/div[8]/div/div/label/span";
            String lookForButton = "//*[@id=\"accessible-body\"]/div/form/div[11]/button";

            String departureTimeInString = "//*[@id=\"accessible-body\"]/div[1]/div[3]/div[3]/div[1]/div[1]/div/div[2]/div[1]/div[2]/span[2]";
            Double departuretimeInInt;
            String buyButton = "//*[@id=\"accessible-body\"]/div[1]/div[3]/div[2]/div[1]/div[2]/div/div[2]/button[2]";

            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();
            option.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            option.setExperimentalOption("useAutomationExtension", false);
            WebDriver driver = new ChromeDriver(option);

            driver.get(path);
            Thread.sleep(1000);

            WebElement cookiesButton = driver.findElement(By.xpath(cookiesAccept));
            cookiesButton.click();

            WebElement departureLocationElement =driver.findElement(By.xpath(departureLocation));
            departureLocationElement.sendKeys("Wodzisław");
            WebElement arrivalLocationElement =driver.findElement(By.xpath(arrivalLocation));
            arrivalLocationElement.sendKeys("Katowice");
            WebElement directConnectionElement = driver.findElement(By.xpath(directConnection));
            directConnectionElement.click();

            WebElement lookForButon = driver.findElement(By.xpath(lookForButton));
            lookForButon.click();

            Thread.sleep(2000);

            WebElement departureTimeElement = driver.findElement(By.xpath(departureTimeInString));

            if(GetTime.istimeGood(GetTime.convertToDouble(departureTimeElement.getText()))){
                WebElement buyButtonElement = driver.findElement(By.xpath(buyButton));
                buyButtonElement.click();
                WebElement buyButtonConfirm = driver.findElement(By.xpath("//*[@id=\"buyTicketWindow\"]/div[3]/div/div[2]/div/div/button"));
                buyButtonElement.click();

            }
            else{
                System.out.println("Za mało czasu ! ");
            }



            System.out.print(departureTimeElement.getText());

        }
    }

