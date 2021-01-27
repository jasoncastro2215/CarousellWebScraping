//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        String cardClass = "._1gJzwc_bJS._2rwkILN6KA.Rmplp6XJNu.mT74Grr7MA.nCFolhPlNA.lqg5eVwdBz.uxIDPd3H13._30RANjWDIv";
        String priceXPath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div[2]/div[2]/h2";
        String unitNameXPath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div[2]/div[4]/h1";
        String descriptionXPath = "._1gJzwc_bJS._2NNa9Zomqk.Rmplp6XJNu._2rtT6NUaXc._2m1WFlGyTw.lqg5eVwdBz._19l6iUes6V.OEczB0h3_O._3k5LISAlf6";
        String detailsCategoryClass = ".VSdV5689oq > p";
        String detailsCSS = "p + div > span";
        String imageCSS = "span._3nH6adLACP.AkA9bU1pCx img.P2llUzsDMi";
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30L);
        driver.navigate().to("https://www.carousell.ph/search/bedspace");
        int page = 10;
        int startCard = 0;
        int card = 10;
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cardClass), 0));
        List<WebElement> cards = driver.findElements(By.cssSelector(cardClass));
        int noOfCards = cards.size();
        JavascriptExecutor js = (JavascriptExecutor)driver;

        for(int i = 0; i < page; ++i) {
            js.executeScript("javascript:window.scrollBy(0, 10000)", new Object[0]);
            List<WebElement> loadMoreButton = driver.findElements(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div[2]/main/div/button"));
            if (loadMoreButton.size() == 0) {
                break;
            }

            ((WebElement)loadMoreButton.get(0)).click();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cardClass), noOfCards));
            noOfCards = driver.findElements(By.cssSelector(cardClass)).size();
        }

        Map<String, Object[]> data = new TreeMap();
        data.put(Integer.toString(1), new Object[]{"Unit Name", "Price", "Description", "Street Address", "Bedroom/s", "Bathroom/s", "Region", "City", "Barangay", "Floor Area", "Lot Area", "Parking Space", "Pet Friendly", "Link", "Images"});

        String city;
        for(int i = startCard; i < card; ++i) {
            cards = driver.findElements(By.cssSelector(cardClass));
            ((WebElement)cards.get(i)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitNameXPath)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceXPath)));
            String streetAddress = "";
            String bedroom = "";
            String bathroom = "";
            String region = "";
            city = "";
            String brngy = "";
            String floorArea = "";
            String lotArea = "";
            String parkingSpace = "";
            String petFriendly = "";
            String unitName = driver.findElement(By.xpath(unitNameXPath)).getText();
            String price = driver.findElement(By.xpath(priceXPath)).getText();
            int finalPrice = Integer.parseInt(price.substring(4).replaceAll(",", ""));
            List<WebElement> descElement = driver.findElements(By.cssSelector(descriptionXPath));
            String description = descElement.size() == 0 ? "" : ((WebElement)descElement.get(0)).getText();
            List<WebElement> details = driver.findElements(By.cssSelector(detailsCSS));
            List<WebElement> detailsCategory = driver.findElements(By.cssSelector(detailsCategoryClass));
            List<WebElement> images = driver.findElements(By.cssSelector(imageCSS));
            String imgs = "";

            WebElement image;
            for(Iterator var37 = images.iterator(); var37.hasNext(); imgs = imgs + image.getAttribute("src") + ", ") {
                image = (WebElement)var37.next();
            }

            for(int j = 0; j < detailsCategory.size(); ++j) {
                String var58 = ((WebElement)detailsCategory.get(j)).getText();
                byte var39 = -1;
                switch(var58.hashCode()) {
                case -1904123844:
                    if (var58.equals("Lot Area")) {
                        var39 = 7;
                    }
                    break;
                case -1850928364:
                    if (var58.equals("Region")) {
                        var39 = 3;
                    }
                    break;
                case -1688407169:
                    if (var58.equals("Barangay")) {
                        var39 = 5;
                    }
                    break;
                case -761180578:
                    if (var58.equals("Parking Space")) {
                        var39 = 8;
                    }
                    break;
                case 2100619:
                    if (var58.equals("City")) {
                        var39 = 4;
                    }
                    break;
                case 245080780:
                    if (var58.equals("Pet Friendly")) {
                        var39 = 9;
                    }
                    break;
                case 399807585:
                    if (var58.equals("Floor Area")) {
                        var39 = 6;
                    }
                    break;
                case 613365975:
                    if (var58.equals("Street Address")) {
                        var39 = 0;
                    }
                    break;
                case 1178342341:
                    if (var58.equals("Bathrooms")) {
                        var39 = 2;
                    }
                    break;
                case 1476537143:
                    if (var58.equals("Bedrooms")) {
                        var39 = 1;
                    }
                }

                switch(var39) {
                case 0:
                    streetAddress = ((WebElement)details.get(j)).getText();
                    break;
                case 1:
                    bedroom = ((WebElement)details.get(j)).getText().replaceAll("\\D+", "");
                    break;
                case 2:
                    bathroom = ((WebElement)details.get(j)).getText().replaceAll("\\D+", "");
                    break;
                case 3:
                    region = ((WebElement)details.get(j)).getText();
                    break;
                case 4:
                    city = ((WebElement)details.get(j)).getText();
                    break;
                case 5:
                    brngy = ((WebElement)details.get(j)).getText();
                    break;
                case 6:
                    floorArea = ((WebElement)details.get(j)).getText().replaceAll(" sqm", "").replaceAll(",", "");
                    break;
                case 7:
                    lotArea = ((WebElement)details.get(j)).getText().replaceAll(" sqm", "").replaceAll(",", "");
                    break;
                case 8:
                    parkingSpace = ((WebElement)details.get(j)).getText();
                    break;
                case 9:
                    petFriendly = ((WebElement)details.get(j)).getText();
                }
            }

            if (!city.isEmpty()) {
                data.put(Integer.toString(i + 2), new Object[]{unitName, finalPrice, description, streetAddress, bedroom, bathroom, region, city, brngy, floorArea, lotArea, parkingSpace, petFriendly, driver.getCurrentUrl(), imgs.substring(0, imgs.length() - 2)});
            }

            driver.navigate().back();
        }

        driver.close();
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Carousell Data");
        Set<String> keyset = data.keySet();
        int rownum = 0;
        Iterator var47 = keyset.iterator();

        while(var47.hasNext()) {
            city = (String)var47.next();
            Row row = sheet.createRow(rownum++);
            Object[] objArr = (Object[])data.get(city);
            int cellnum = 0;
            Object[] var52 = objArr;
            int var53 = objArr.length;

            for(int var54 = 0; var54 < var53; ++var54) {
                Object obj = var52[var54];
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String) {
                    cell.setCellValue((String)obj);
                } else if (obj instanceof Integer) {
                    cell.setCellValue((double)(Integer)obj);
                }
            }
        }

        try {
            FileOutputStream out = new FileOutputStream("CarousellData.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("CarousellData.xlsx written successfully on disk.");
        } catch (Exception var40) {
            var40.printStackTrace();
        }

    }
}
