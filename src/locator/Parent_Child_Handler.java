package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Parent_Child_Handler {
    public static void main(String[] args) throws InterruptedException {
        String driverpath="C:\\Users\\mma2928\\IdeaProjects\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverpath);
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.rediff.com");
        Thread.sleep(5000);


        driver.manage().window().maximize();

        Thread.sleep(5000);
        driver.findElement(By.linkText("Create Account")).click();
        List<WebElement> list=driver.findElements(By.tagName("a"));
        driver.findElement(By.linkText("terms and conditions")).click();
        String parentWindow = driver.getWindowHandle();
        System.out.println(parentWindow);

        Set<String> s1=driver.getWindowHandles();

        Iterator<String> i1=s1.iterator();

        while(i1.hasNext()) {
            String childWindow=i1.next();
            System.out.println(childWindow);
            if(!parentWindow.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                // System.out.println(childWindow);

                String s2=driver.getTitle();
                System.out.println(s2);
                if(s2.equals("Terms and Conditions")) {
                    System.out.println("Pass");
                }
                else
                    System.out.println("fail");

                driver.close();
            }
        }
        driver.switchTo().window(parentWindow);
        driver.quit();



    }
}
