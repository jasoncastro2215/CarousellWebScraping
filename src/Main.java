//old

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileOutputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.navigate().to("https://www.carousell.ph/search/bedspace");
        int page = 13;
        int noOfCards;
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".D_gu"), 0));
        List<WebElement> cards = driver.findElements(By.cssSelector(".D_gu"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        noOfCards = cards.size();
        int prevNoOfCards = 0;
        for (int i = 0; i < page; i++) {
            for (int j = prevNoOfCards; j < noOfCards; j++) {
                try{
                    String link = cards.get(j).getAttribute("href");
                    if (link.length() > 25 ? link.substring(24, 27).equalsIgnoreCase("/p/") : false)
                        System.out.println(link);
                } catch (Exception e) {}
            }
            js.executeScript("javascript:window.scrollBy(0, 10000)");
            List<WebElement> loadMoreButton = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/main/div/button"));
            loadMoreButton.get(0).click();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".D_gu"), noOfCards));
            prevNoOfCards = noOfCards;
            cards = driver.findElements(By.cssSelector(".D_gu"));
            noOfCards = cards.size();
        }
    }
}