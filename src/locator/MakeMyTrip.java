package locator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class MakeMyTrip {
    public static String read(int row,int column) throws IOException{
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
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys(read(1,1));
        Thread.sleep(5000);
        WebElement dropdown=driver.findElement(By.xpath(".//ul[@class='G43f7e']"));
        List<WebElement> list=dropdown.findElements(By.xpath(".//li"));
        System.out.println(list.size());
        for(int i=0;i<list.size();i++){
            String searchText=list.get(i).getText();
            System.out.println(searchText);
            if(searchText.equalsIgnoreCase("Rohit Sharma")){
                list.get(i).click();
                break;
            }
        }


    }
}
