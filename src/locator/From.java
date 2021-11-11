package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class From {
    public static void main(String[] args) throws InterruptedException {
        String dp="C:\\Users\\mma2928\\IdeaProjects\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",dp);
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.goibibo.com/flights/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("Hyd");
      Thread.sleep(5000);
        WebElement dropdown=driver.findElement(By.className("inputSrch"));
        List<WebElement> list=dropdown.findElements(By.className("inputSrch"));
        for(int i=0;i<list.size();i++){
            String searchText=list.get(i).getText();
            System.out.println(searchText);
            if(searchText.equalsIgnoreCase((driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]"))).getText())){
                list.get(i).click();
                break;
            }
        }
    }

}
