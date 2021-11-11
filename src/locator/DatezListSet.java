package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatezListSet {
    public static void main(String[] args) throws InterruptedException {
        String dp="C:\\Users\\mma2928\\IdeaProjects\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",dp);
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.goibibo.com/flights/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"departureCalendar\"]")).click();

        //WebElement dept_date=driver.findElement(By.xpath("//*[@id=\"searchWidgetCommon\"]/div[1]/div[1]/div[1]/div/div[6]/div/div/div/div[2]/div/div[1]/div"));
        //String str=dept_date.getText();


        String[] x=new String[2];
        x[0]=(" ");
        x[1]=(" ");
        while(!(x[0].equalsIgnoreCase("april") && x[1].equals("2022"))){

            WebElement dept_date=driver.findElement(By.xpath("//*[@id=\"searchWidgetCommon\"]/div[1]/div[1]/div[1]/div/div[6]/div/div/div/div[2]/div/div[1]/div"));
            String str1=dept_date.getText();
            x=str1.split(" ");
            //System.out.println(x[0]+"  "+x[1]);
            if(x[0].equalsIgnoreCase("april") && x[1].equals("2022")){
                System.out.println(x[0]+"  "+x[1]);
                break;
            }

            driver.findElement(By.xpath("//*[@id=\"searchWidgetCommon\"]/div[1]/div[1]/div[1]/div/div[6]/div/div/div/div[1]/span[2]")).click();
            //str=dept_date.getText();
            //x=str.split(" ");
            System.out.println(x[0]+"  "+x[1]);

        }
        String ele="22";
        Thread.sleep(5000);
        List<WebElement> striList=driver.findElements(By.className("calDate"));


        for(int i=0;i<striList.size();i++){
            String date=striList.get(i).getText();
            if(date.equals(ele)){
                striList.get(i).click();
                break;
            }

        }


    }

}
