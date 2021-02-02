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
import java.io.FileOutputStream;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        int firstProperty = 0;
        int lastProperty = 20;

        String cardClass = ".D_cr.D_c_.D_cC.D_cG.D_cI.D_cL.D_cO.D_co";
        String priceXPath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div[2]/div[2]/h2";
        String unitNameXPath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div[2]/div[4]/h1";
        String descriptionXPath = ".D_cr.D_cA.D_cC.D_cF.D_cJ.D_cL.D_cN.D_uQ.D_uR.D_cn";
        String detailsCategoryClass = ".D_uL > p";
        String detailsCSS = ".D_cr.D_c_.D_cC.D_cF.D_cJ.D_cL.D_cN.D_uQ.D_cn";
        String imageCSS = ".D_eJ.D_wP.D_eK > img";
        String loadMoreButtonCSS = ".D_aO.D_bj.D_bb.D_aW.D_bn.D_av";

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        driver.navigate().to("https://www.carousell.ph/search/bedspace");
        int page = 100;
        int noOfCards;
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cardClass), 0));
        List<WebElement> cards = driver.findElements(By.cssSelector(cardClass));
        noOfCards = cards.size();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < page; i++) {
            js.executeScript("javascript:window.scrollBy(0, 10000)");
            List<WebElement> loadMoreButton = driver.findElements(By.cssSelector(loadMoreButtonCSS));
            if (loadMoreButton.size() == 0)
                break;
            loadMoreButton.get(0).click();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(cardClass), noOfCards));
            noOfCards = driver.findElements(By.cssSelector(cardClass)).size();
        }

        Map<String, Object[]> data = new TreeMap<>();
        data.put(Integer.toString(1), new Object[] {"Unit Name", "Price", "Description", "Street Address",
        "Bedroom/s", "Bathroom/s", "Region", "City", "Barangay", "Floor Area", "Lot Area", "Parking Space", "Pet Friendly", "Link", "Images", "Special Character?"});
        for (int i = firstProperty-1; i < lastProperty; i++) {
            cards = driver.findElements(By.cssSelector(cardClass));
            cards.get(i).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitNameXPath)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceXPath)));
            String streetAddress = "", bedroom = "", bathroom = "", region = "", city = "", brngy = "", floorArea = "",
                    lotArea = "", parkingSpace = "", petFriendly = "";
            String unitName = driver.findElement(By.xpath(unitNameXPath)).getText();
            String price = driver.findElement(By.xpath(priceXPath)).getText();
            int finalPrice = Integer.parseInt(price.substring(4).replaceAll(",", ""));
            List<WebElement> descElement = driver.findElements(By.cssSelector(descriptionXPath));
            String description = descElement.size() == 0 ? "" : descElement.get(0).getText();
            List<WebElement> details = driver.findElements(By.cssSelector(detailsCSS));
            List<WebElement> detailsCategory = driver.findElements(By.cssSelector(detailsCategoryClass));
            List<WebElement> images = driver.findElements(By.cssSelector(imageCSS));
            String imgs = "";
            for (WebElement image : images) {
                imgs = imgs + image.getAttribute("src") + ", ";
            }

            for (int j = 0; j < detailsCategory.size(); j++) {
                switch (detailsCategory.get(j).getText()) {
                    case "Street Address":
                        streetAddress = details.get(j+1).getText();
                        break;
                    case "Bedrooms":
                        bedroom = details.get(j+1).getText().replaceAll("\\D+","");
                        break;
                    case "Bathrooms":
                        bathroom = details.get(j+1).getText().replaceAll("\\D+","");
                        break;
                    case "Region":
                        region = details.get(j+1).getText();
                        break;
                    case "City":
                        city = details.get(j+1).getText();
                        break;
                    case "Barangay":
                        brngy = details.get(j+1).getText();
                        break;
                    case "Floor Area":
                        floorArea = details.get(j+1).getText().replaceAll(" sqm", "").replaceAll(",", "");
                        break;
                    case "Lot Area":
                        lotArea = details.get(j+1).getText().replaceAll(" sqm", "").replaceAll(",", "");
                        break;
                    case "Parking Space":
                        parkingSpace = details.get(j+1).getText();
                        break;
                    case "Pet Friendly":
                        petFriendly = details.get(j+1).getText();
                        break;
                }
            }
            System.out.println("fetching unit " + (i+1));
            if (!city.isEmpty())
                data.put(Integer.toString(i+2), new Object[] {unitName, finalPrice, description, streetAddress, bedroom, bathroom, region, city, brngy, floorArea, lotArea, parkingSpace,
                    petFriendly, driver.getCurrentUrl(), imgs.substring(0, imgs.length()-2),
                        unitName.matches("^[\\p{ASCII}]*$") ? (description.matches("^[\\p{ASCII}]*$") ? "" : "description") :
                                (description.matches("^[\\p{ASCII}]*$") ? "unit name" : "unit name & description") });
            driver.navigate().back();
        }
        driver.close();

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Carousell Data");

        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
                Cell cell = row.createCell(cellnum++);
                if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            FileOutputStream out = new FileOutputStream("CarousellData.xlsx");
            workbook.write(out);
            out.close();
            System.out.println("CarousellData.xlsx written successfully on disk.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}