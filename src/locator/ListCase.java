package locator;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListCase{
//Drag&Drop
        public static void main(String[] args) throws InterruptedException {
        String driverPath="C:\\Users\\mma2928\\IdeaProjects\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver=new ChromeDriver();
        driver.get("https://demoqa.com/droppable/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        WebElement from=driver.findElement(By.id("draggable"));
        WebElement to=driver.findElement(By.id("droppable"));
        Actions builder=new Actions(driver);
        builder.clickAndHold(from).perform();
        builder.moveToElement(to).perform();
        builder.release().perform();
        //builder.dragAndDrop(from,to).perform();
        String textTo=to.getText();
        if(textTo.equals("Dropped!"))
        {
        System.out.println("PASS:Sourceisdroppedtotargetasexpected");
        }
        else
        {
        System.out.println("FAIL:Sourcecouldn'tbedroppedtotargetasexpected");
        }

        }
        }