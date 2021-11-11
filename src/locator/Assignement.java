package locator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Assignement {
    public static String read(int row,int column) throws IOException {
        String testData=null;
        try{
            String filePath="C:\\Users\\mma2928\\IdeaProjects\\Selinium_Learn\\Excel\\Temp.xlsx";
            FileInputStream file=new FileInputStream(filePath);
            XSSFWorkbook wb=new XSSFWorkbook(file);
            XSSFSheet ws=wb.getSheetAt(0);
            testData =String.valueOf(ws.getRow(row).getCell(column));
            wb.close();
        }
        catch (Exception e){
            System.out.println("Excel Read");
        }
        return testData;
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        String driverPath="C:\\Users\\mma2928\\IdeaProjects\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.kohls.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        WebElement loc=driver.findElement(By.id(read(0,0)));
        loc.sendKeys(read(0,1));
        loc.submit();
        Thread.sleep(5000);

        WebElement dropdown=driver.findElement(By.className("sbSelector"));
        dropdown.click();
        dropdown.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        WebElement dd=driver.findElement(By.className("sbOptions"));
        List<WebElement> list=dd.findElements(By.tagName("li"));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            String searchText=list.get(i).getText();
            System.out.println(searchText);
            if(searchText.equalsIgnoreCase("Price High-Low")){
                list.get(i).click();
                break;
            }
        }
        Thread.sleep(5000);
        WebElement prod=driver.findElement(By.className("products"));
        List<WebElement> lim=prod.findElements(By.tagName("li"));
        lim.get(0).click();

        Thread.sleep(5000);
        WebElement size=driver.findElement(By.className("sbSelector"));
        size.click();
        size.sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
        WebElement sel=driver.findElement(By.className("sbOptions"));
        List<WebElement> siz=sel.findElements(By.tagName("li"));
        for(int i=0;i<siz.size();i++){
            String st=siz.get(i).getText();
            if(st.equalsIgnoreCase(read(2,1))){
                siz.get(i).click();
            }
        }
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div/div[9]/div/div/div/div/img")).click();
    }
}
