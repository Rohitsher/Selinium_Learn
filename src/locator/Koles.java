package locator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.util.List;

public class Koles {
    private static Koles Tuxedo;

    public static String readExcel(int row, int column) throws Exception {
        String testdata = null;
        try {
            String filePath = "C:\\Users\\mma2928\\IdeaProjects\\Selinium_Learn\\Excel\\Temp.xlsx";
            FileInputStream file = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(file);
            XSSFSheet ws = wb.getSheetAt(0);
            testdata = String.valueOf(ws.getRow(row).getCell(column));
            wb.close();
        } catch (Exception e) {
            System.out.println("Excel Read");
        }
        return testdata;
    }

    public static void main(String[] args) throws Exception {
        String driverPath = "C:\\Users\\mma2928\\IdeaProjects\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kohls.com/");
        driver.manage().window().maximize();

        String search = Tuxedo.readExcel(0, 1);
        driver.findElement(By.id("search")).sendKeys(search);
        Actions act = new Actions(driver);
        act.sendKeys(Keys.ENTER).perform();
        Thread.sleep(10000);
        //SortBy
        driver.findElement(By.linkText("Featured")).click();
        WebElement dropdown = driver.findElement(By.className("sbOptions"));
        List<WebElement> list = dropdown.findElements(By.tagName("li"));
        //System.out.println(list.size());
        String sortby = Tuxedo.readExcel(1, 1);
        for (int i = 0; i < list.size(); i++) {
            String searchText = list.get(i).getText();
            //System.out.println(searchText);
            if (searchText.equalsIgnoreCase(sortby)) {
                list.get(i).click();
                break;
            }
        }
        //selecting result
        Thread.sleep(5000);
        WebElement selectResult = driver.findElement(By.className("products"));
        List<WebElement> listSort = selectResult.findElements(By.className("products_grid"));
        for (int i = 0; i < listSort.size(); i++) {
            if (i == 0) {
                listSort.get(i).click();
                Thread.sleep(5000);
                break;
            }
        }
        driver.findElement(By.linkText("Please Choose a Size")).click();
        WebElement size = driver.findElement(By.linkText("Please Choose a Size"));
        List<WebElement> sizelist = driver.findElements(By.tagName("li"));
        String sl = Tuxedo.readExcel(2, 1);
        for (int i = 0; i < sizelist.size(); i++) {
            String searchText = sizelist.get(i).getText();
            //System.out.println(searchText);
            if (searchText.equalsIgnoreCase(String.valueOf(size))) {
                list.get(i).click();
                break;
            }
            driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div/div[7]/div[1]/div/div/ul/li[3]/div/p")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("addtobagID")).click();
            Thread.sleep(1000);
            // driver.findElement(By.className("number-items boss-number-items nonzero-items")).click();
            //driver.findElement(By.className("viewBag_ghr")).click();
            driver.findElement(By.id("checkout-container")).click();
            WebElement product = driver.findElement(By.xpath("//*[@id=\"panel1074\"]/div[1]/div[1]/div[2]/div[1]/a"));
            String pr = product.getText();
            if (pr.equalsIgnoreCase("Men's Steve Harvey Maybach Solid Blue Geo Besom-Pocket Tuxedo Jacket")) {
                System.out.println("pass");
            } else {
                System.out.println("fail");
            }
            driver.quit();

        }

    }
}
