package locator;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sample {




//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;



        public static void main(String[] args) throws InterruptedException {
//C:\Users\hp\eclipse-workspace\Selinium_Learn
//C:\Users\hp\eclipse-workspace\Selinium_Learn\Drivers\\
            String driverPath="C:\\Users\\mma2928\\IdeaProjects\\chromedriver_win32\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            WebDriver driver=new ChromeDriver();

            driver.get("https://www.google.com/");
            driver.findElement(By.xpath("//input[@type='text']")).sendKeys("selenium");
            //WebDriverWait wait=new WebDriverWait(driver,15);
         Thread.sleep(2000);
            WebElement dropdown=driver.findElement(By.xpath(".//ul[@class='G43f7e']"));
            List<WebElement> list=dropdown.findElements(By.xpath(".//li[@class='sbct']"));
            System.out.println(list.size());
            for(int i=0;i<list.size();i++){
                String searchText=list.get(i).getText();
                System.out.println(searchText);
                if(searchText.equalsIgnoreCase("Selenium tutorial")){
                    list.get(i).click();
                    break;
                }
            }

            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[2]/input")));
            //driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
            ///html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[2]/input
            //driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[2]/input")).sendKeys("Admin");
            //driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[3]/input")).sendKeys("admin123");
            //driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/input")).click();
            //driver.findElement(By.xpath("")).sendKeys("Admin");
            //driver.findElement(By.xpath("")).sendKeys("admin123");
            //driver.findElement(By.xpath("")).click();
        }


    }

//


