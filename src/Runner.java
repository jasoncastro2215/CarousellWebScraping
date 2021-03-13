import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileOutputStream;
import java.util.*;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        String[] property = ("https://www.carousell.ph/p/boarding-house-lady-bedspace-lacson-avenue-sta-cruz-manila-273298859/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/makati-male-professional-room-for-rent-bedspace-238002475/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/makati-ladies-bedspace-room-for-rent-boarding-house-dormitory-1022849174/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-bedspace-and-room-for-rent-242280064/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/ladies-bedspace-cubao-qc-boarders-bedspacers-238767323/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/mandaluyong-bedspace-room-for-rent-male-only-240184428/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-dian-street-san-isidro-makati-238585507/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-238619805/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/rooms-and-bedspace-for-rent-238619804/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-near-ust-and-university-belt-male-or-female-239163507/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/all-in-furnished-spacious-female-bedspace-in-gma-kamuning-1047150376/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/all-in-spacious-furnished-bedspace-in-gma-kamuning-1047145937/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-with-free-fiber-wifi-and-bills-included-256370681/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-general-delgado-st-brgy-san-antonio-pasig-city-1073958096/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-laguna-238530136/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-bedspace-for-rent-near-mckinley-west-gate-3-bgc-naia-magallanes-283886380/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-for-rent-1066910150/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspacing-for-men-in-paranaque-for-2k-only-246628124/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-sucat-muntinlupa-1035476240/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=Z_MMLwqGKLpZRsif&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-with-fiber-internet-1067570248/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-in-c5-service-road-near-mckinley-hill-market-market-243031403/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-and-solo-rooms-near-mckinley-hill-bgc-243151723/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-5k-all-in-242140630/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspacer-at-the-pearl-place-250774270/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/room-and-bedspace-for-rent-226492709/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-for-rent-1073224794/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-female-free-water-electricity-linawan-sjdm-bulacan-242561017/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-for-rent-1051938572/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-ladies-only-282403089/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-condo-bedspacing-1054912140/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/ga-tower-female-condo-bedspace-pioneer-boni-ortigas-shaw-rockwell-cybergate-239348899/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/la-verti-condo-bedspace-makati-ayala-buendia-moa-pasay-taft-mrt-lrt-279759601/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-alabang-246061144/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-in-mckinley-hill-taguig-1017571153/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/urgent-urgent-affordable-female-bedspace-makati-1041654074/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/rush-rush-affordable-female-bedspacer-makati-1064300247/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-248437216/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspacer-in-san-juan-city-near-greenhills-ortigas-center-238936765/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-in-cubao-cambridge-st-or-oxford-st-238581000/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=dOFfpLnrhznDjsfv&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspacer-in-quezon-city-255644591/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-at-axis-residences-1073123721/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-at-ga-tower-2-1073122637/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-1063606543/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-male-krus-na-ligas-diliman-quezon-city-1073092018/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-female-decent-dorm-1073082120/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-near-ortigas-center-bridgetowne-and-eastwood-city-1066741510/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-near-ortigas-and-eastwood-238554045/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacers-urgent-268221462/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-condosharing-bedspace-condo-sharing-mckinley-hill-bgc-uptown-280831855/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/better-living-para%C3%B1aque-male-female-bedspacer-dorm-type-249089096/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-available-bf-paranaque-238567704/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-or-room-for-rent-1026173307/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-or-room-for-rent-makati-near-buendia-ayala-pasay-1033809586/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/makati-bedspacer-for-female-or-lady-1017162626/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/ramons-bedspace-rentalsbeds-female-only-238777965/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-ladies-only-san-juan-238746758/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-room-for-rent-in-las-pinas-240369822/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-baliuag-bulacan-232712665/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-only-in-kapitolyo-pasig-1009818611/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=wmUlHOVWl6_pH-tt&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-in-kapitolyo-pasig-1017528038/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/looking-for-1-female-bedspacer-kashare-sa-apartment-west-rembo-makati-1071982335/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-1071524760/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-in-makati-1072007116/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bed-space-female-bedspace-bedspace-bed-space-room-rental-1014031742/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/room-for-rent-lady-bedspace-1013064908/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condoshare-bedspace-for-ladies-only-1071711427/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-in-katipunan-1049616189/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspacer-1072667118/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/aircon-bedspace-for-ladies-1072672381/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/boarding-house-bedspace-room-for-rent-sampaloc-manila-238486610/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/pasig-room-rent-bed-space-bedspace-shaw-pioneer-kapitolyo-09179556319-240523820/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/mandaluyong-female-bedspace-238792752/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-1014043773/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/mandaluyong-men-bedspacer-1060886221/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-for-6-pax-near-mandaluyong-city-hall-251835605/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-238585282/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-condo-sharing-for-rent-at-pioneer-woodlands-mandaluyong-242264145/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-in-makaqti-1071161884/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/dormitory-in-makati-room-and-bedspace-rental-1052915757/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=asoplvizzicOxBgI&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/for-rent-female-bedspacer-in-san-juan-271274092/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-male-manila-back-of-ust-near-dangwa-sm-san-lazaro-238851598/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-makati-ayala-circuit-mall-area-1065267750/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/looking-for-lady-bedspacers-1030094593/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-female-only-bagong-pagasa-qc-near-sm-north-no-flooding-1070272675/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-girls-ortigas-pasig-2-900-all-in-monthly-251545983/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-makati-cbd-female-1031302670/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condo-sharing-room-rent-ortigas-mandaluyong-shaw-boni-pioneer-241428001/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-share-dorm-room-for-rent-apartment-bedspace-ortigas-mandaluyong-239037473/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condo-sharing-condo-share-room-rent-ortigas-mandaluyong-shaw-238462867/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-or-room-for-rent-makati-near-buendia-ayala-pasay-1033791978/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspacer-for-rent-in-makati-city-273494187/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/makati-ayala-bedspace-for-rent-1061345125/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/cheap-male-bedspace-room-for-rent-quezon-city-katipunan-275653890/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/sampaloc-dorm-apts-room-studio-bedspace-near-espana-ust-manila-rent-1020404985/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-in-makati-239795426/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-in-mandaluyong-1047995964/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-makati-city-bgc-sm-aura-1039678667/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-rotonda-pasig-238543851/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/rooms-bedspace-for-rent-at-sta-rosa-laguna-240707420/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=H-o-MJYIC0LeIH2E&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-girls-or-transient-room-katipunan-1072273176/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-qc-1017735701/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/brand-new-bedspace-for-ladies-imus-cavite-1070730876/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/dorm-condo-sharing-dormitory-room-bedspace-for-rent-in-makati-manila-238628577/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-in-makati-near-circuit-century-sm-jazz-1033265190/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condo-sharing-condo-share-ortigas-mandaluyong-pioneer-boni-238891331/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-room-for-rent-in-las-pinas-239341352/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condo-sharing-for-female-250633268/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-in-makati-near-ayala-buendia-pasong-tamo-and-chino-roces-1070698353/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/moonwalk-paranaque-bedspace-for-rent-242986023/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/room-bedspace-for-rent-near-ust-nu-mendiola-cpar-review-centers-238776415/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-for-rent-in-pasay-room-bed-space-1021465081/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-cubao-qc-237573826/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/ladies-bedspace-or-ladies-room-for-rent-good-for-1-2-person-238605369/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-in-mandaluyong-1024971400/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-female-only-1062022227/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-mandaluyong-1065626718/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-in-las-pinas-near-rfc-starmall-239191594/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/admit-bedspacer-1071757772/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-boarding-house-ladies-quezon-city-kamuning-t-morato-scout-239169077/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=1gypE-1182B7UyZ4&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-female-1070279506/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-261470892/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-ladies-1071649435/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-boys-transient-1071641880/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-for-rent-in-pasay-3250-each-only-1room-good-for-2-pax-1-bed-available-free-wifi-hot-shower-water-and-electricity-included-common-sink-and-cr-with-exhaust-fan-located-in-2nd-floor-100-ibarra-street-pasay-city-near-lrt-and-mrt-1070063687/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/makati-female-bedspace-1060966390/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/molo-iloilo-city-room-and-bedspace-for-rental-prime-location-for-inspiro-bpo-call-center-1070212779/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/pasay-bedspace-ladies-private-bedspace-near-victory-pasay-mall-lrt-station-1045658421/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-alabang-239165591/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-with-wifi-female-bed-space-studio-city-alabang-245927235/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-alabang-245919308/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/no-deposit-lady-bedspace-104388314/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/sta-rosa-city-bedspace-1041552284/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-for-rent-inside-bgc-and-mckinley-hill-239872709/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-only-3-pax-in-room-single-beds-w-foam-free-wifi-24-7-239947032/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condo-sharing-ortigas-238523481/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/ortigas-bedspace-condo-sharing-266506457/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-at-axis-residences-1010100366/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/pasig-ladies-bed-spacer-bedspacing-bedspacer-1018466900/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/room-for-rent-bedspace-1028571903/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=AxHNr6rrcObV0cUC&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condosharing-room-rent-ortigas-mandaluyong-shaw-boni-crossing-1002469854/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-employees-students-and-reviewees-238510410/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-room-rent-mandaluyong-ortigas-boni-pioneer-shaw-238854407/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bgc-female-bedspacing-1071164612/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-4500-all-in-room-for-rent-13k-all-in-mandaluyong-city-1064905642/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-mc-kinley-1070894533/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/mplace-condominium-female-bedspace-1071866606/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/the-beacon-makati-condo-sharing-or-bedspace-255844641/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/dorm-apartment-room-rent-dormitory-bedspace-ortigas-mandaluyong-shaw-242035939/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacers-for-a-fully-furnished-boarding-house-238525521/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-in-cubao-walking-distance-to-araneta-city-240140174/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-condosharing-ortigas-mandaluyong-boni-pioneer-255843054/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-in-makati-for-female-only-239809634/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condo-sharing-room-rent-near-ayala-makati-guadalupe-bgc-fort-242038301/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condosharing-room-rent-daily-weekly-ortigas-mandaluyong-boni-1002470541/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacers-for-a-fully-furnished-boarding-house-238525519/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-female-bedspace-in-mckinley-hill-taguig-with-wifi-all-in-1035641700/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-in-mckinley-hill-fort-bonficaio-heigths-bgc-area-taguig-1050609042/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/cubao-condo-bedspace-for-rent-male-263212994/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/girl-bedspace-condoshare-in-mandaluyong-room-for-rent-near-edsa-ortigas-mrt-flair-reliance-megamall-1063534905/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=mm4Pvt6iE5qIucyw&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-employees-students-near-sm-san-lazaro-240897391/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-renta-babae-1064285766/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-in-manila-and-vito-cruz-near-de-la-salle-1017102643/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-1068848784/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-girls-239219902/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-western-bicutan-taguig-252042815/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-room-for-rent-ga-tower-2-male-only-282216080/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-near-sm-city-sta-mesa-and-lrt-2-station-in-v-mapa-1071220253/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-condo-sharing-240442284/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/eastwood-libis-qc-condo-rooms-for-rent-bedspace-condo-sharing-234855272/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/room-bedspace-244324896/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-ortigas-mandaluyong-boni-shaw-pioneer-283211286/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-condo-sharing-bedspace-2br-fully-furnished-unit-273776611/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-277088915/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-in-makati-275350322/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-with-100-mbps-wifi-and-aircon-248100380/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/for-lease-dorm-bedspace-in-makati-manila-and-taguig-area-285936537/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/for-lease-dorm-bedspace-in-taguig-manila-and-makati-285938199/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/room-sharing-bedspacer-in-ortigas-cbd-243729473/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bsa-twin-towers-bedspace-condo-sharing-room-rent-ortigas-mandaluyong-239038022/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=xUYurSn-8LOApOm-&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-in-manila-1072162075/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-girls-only-ortigas-pasig-2-900-all-in-monthly-238476696/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-1069215170/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacers-275828648/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacers-242346077/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/boarding-house-for-male-and-female-bedspacer-luta-sur-malvar-batangas-238557399/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-condo-sharing-mandaluyong-city-238878951/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/for-lease-dorm-bedspace-in-manila-makati-and-taguig-area-285936110/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-condo-sharing-condo-bedspace-for-rent-238488371/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/apartments-rooms-for-rent-bedspace-at-the-center-of-cebu-city-walking-distance-to-swu-ymca-camp-sergio-osmena-normal-university-abellana-etc-1071040096/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/california-garden-square-bedspace-condo-sharing-mandaluyong-1044775819/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-male-in-makati-2500-1054929332/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-ladies-for-rent-in-cubao-238584888/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-california-garden-square-1060471702/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-in-anonas-st-proj-2-238543198/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-in-cubao-239837998/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/first-month-free-makati-dormitories-%E2%80%93-bedspaces-%E2%80%93-co-living-1024477931/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/quezon-city-bedspace-1063108378/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-243185453/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-pasig-shaw-crossing-capitol-commons-ortigas-241996997/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=bKyHRvO65qInNx_Q&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-pasig-shaw-crossing-capitol-commons-ortigas-241996997/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/wanted-male-female-bedspacers-1069463829/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-condo-sharing-makati-near-ayala-1030615786/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/dorm-room-rent-dormitory-apartment-bedspace-pasig-ortigas-1022906664/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-near-kalayaan-c5-and-market-market-2k-all-in-257686692/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-female-bedspace-condosharing-ortigas-mandaluyong-246608258/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-condo-sharing-room-rent-condo-share-ortigas-mandaluyong-239105075/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-in-paco-manila-female-and-male-1050460643/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/2-newly-refurbished-lady-bedspace-rooms-256373194/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-near-bgc-bonifacio-global-city-sm-aura-marketmarket-238877671/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-at-smdc-light-residences-penthouse-261536288/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-dormitory-near-cash-carry-and-ayala-1004640415/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-paranaque-238848919/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/sm-jazz-bedspace-270775350/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-dormitory-near-cash-carry-and-lrt-gil-puyat-station-1046993258/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-bedspace-for-rent-in-makati-near-ayala-1056816000/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-qc-1038961813/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-at-ayala-centera-condominium-edsa-mandaluyong-09085150291-272164765/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-1020313568/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-247840884/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=prsRcfbmuXzU26mz&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspacer-up-campus-1030436612/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspacer-single-up-campus-1030608300/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/pacific-regency-condo-sharing-female-bedspace-lrt-csb-dlsu-st-scho-238529979/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspacer-1068485298/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-condo-sharing-mandaluyong-261910477/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-in-pasay-city-1020407794/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-for-rent-8-beds-in-1-bedroom-1069604120/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-1069602983/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspacers-1061752234/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-1069732435/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lf-working-female-bedspacer-1068424763/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/wanted-bedspacer-ely-buendia-1054645357/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-for-rent-unit-1630-at-studio-zen-1069291732/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspace-makati-238535898/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-in-bgc-1020738189/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-at-ga-tower-2-1068748986/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-in-makati-and-ayala-1017097696/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-in-pasay-near-mall-of-asia-1017088389/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-girl-only-1062181534/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-room-for-rent-ga-tower-2-1061765445/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=oE8zvs0gBqXMEJca&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/sm-jazz-bedspace-p5-000-per-month-1046126238/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-fame-residences-condominium-1039259702/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/male-bedspace-ortigas-with-wifi-1068518652/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-for-female-near-boni-and-shaw-mrt-aircon-wifi-n-274471537/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-makati-cityland-pasong-tamo-chino-roces-no-deposit-280389057/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/for-lease-bedspace-dorm-in-manila-makati-and-taguig-area-285938748/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-in-viceroy-residences-mckinley-hill-taguig-city-near-bonifacio-global-city-217932591/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-bedspacer-manila-216658392/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-in-manila-for-as-low-as-php-2-799-208253033/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-for-rent-ladies-239185562/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/bedspace-in-makati-1031931675/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-with-100-mbps-wifi-and-aircon-148339712/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-212472172/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/moonwalk-paranaque-bedspace-for-rent-243185456/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condo-sharing-bedspace-243190069/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-big-bedspace-up-down-nr-sta-lucia-mall-results-teletech-icct-256295050/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/lady-bedspace-1030942040/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/condominium-bedspace-for-male-1019946617/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/female-bedspacer-1014039908/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular\n" +
                "https://www.carousell.ph/p/fully-furnished-female-boarders-bedspacers-for-rent-1010612715/?t-id=Z7-f89FC7O_1615374952861&t-referrer_browse_type=search_results&t-referrer_request_id=UM6YSHjCCkV9X7kc&t-referrer_search_query=bedspace&t-referrer_sort_by=popular")
        .split("\n");

        int firstProperty = 201;
        int lastProperty = 259;

        String priceXPath = "", unitNameXPath = "", descriptionXPath = "", detailsCategoryClass = "", detailsCSS = "", imageCSS = "";

        WebDriver driver =new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        Map<String, Object[]> data = new TreeMap<>();
        data.put(Integer.toString(1), new Object[] {"Unit Name", "Price", "Description", "Street Address",
                "Bedroom/s", "Bathroom/s", "Region", "City", "Barangay", "Floor Area", "Lot Area", "Parking Space", "Pet Friendly", "Link", "Images", "Special Character?"});
        for (int i = firstProperty-1; i < lastProperty; i++) {
            driver.navigate().to(property[i]);
            if (i == firstProperty-1) {
                try {
                    //new
                    priceXPath = "//*[@id=\"root\"]/div/div[3]/div[3]/div[1]/div[1]/div[1]/p[2]";
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[3]/div[3]/div[1]/div[1]/div[1]/p[2]")));
                    unitNameXPath = "//*[@id=\"root\"]/div/div[3]/div[3]/div[1]/div[1]/div[1]/p[1]";
                    descriptionXPath = "//*[@id=\"root\"]/div/div[3]/div[3]/div[1]/div[1]/div[2]/section/div[4]/div/div/div/div/div/p";
                    detailsCategoryClass = ".D_BT > div > div > p:nth-child(1)";
                    detailsCSS = ".D_BT p + p";
                    imageCSS = ".D_Li > img";
                } catch (Exception e) {
                    //old
                    System.out.println("old");
                    priceXPath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div[2]/div[2]/h2";
                    unitNameXPath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div[2]/div[4]/h1";
                    descriptionXPath = "//*[@id=\"root\"]/div/div[3]/div[1]/div/div[2]/section/div[1]/div[2]/div/div/div/div/p";
                    detailsCategoryClass = ".D_jb.M__k > p";
                    detailsCSS = "p + div > span";
                    imageCSS = ".D_aN.D_ph.D_aO > img";
                }
            }
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(unitNameXPath)));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(priceXPath)));
            } catch (UnhandledAlertException f) {
                try {
                    Alert alert = driver.switchTo().alert();
                    String alertText = alert.getText();
                    System.out.println("Alert data: " + alertText);
                    alert.accept();
                } catch (NoAlertPresentException e) {
                    e.printStackTrace();
                }
            }
            String streetAddress = "", bedroom = "", bathroom = "", region = "", city = "", brngy = "", floorArea = "",
                    lotArea = "", parkingSpace = "", petFriendly = "";
            String unitName = driver.findElement(By.xpath(unitNameXPath)).getText();
            String price = driver.findElement(By.xpath(priceXPath)).getText();
            int finalPrice = Integer.parseInt(price.substring(4).replaceAll(",", "").split("\n")[0]);
            List<WebElement> descElement = driver.findElements(By.xpath(descriptionXPath));
            String description = descElement.size() == 0 ? "" : descElement.get(0).getText();
            List<WebElement> details = driver.findElements(By.cssSelector(detailsCSS));
            List<WebElement> detailsCategory = driver.findElements(By.cssSelector(detailsCategoryClass));
            List<WebElement> images = driver.findElements(By.cssSelector(imageCSS));
            String imgs = "";
            for (WebElement image : images) {
                imgs = imgs + image.getAttribute("src") + ", ";
            }
            System.out.println(detailsCategory.size() + " " + details.size());
            for (int j = 0; j < detailsCategory.size(); j++) {
                switch (detailsCategory.get(j).getText()) {
                    case "Street Address":
                        streetAddress = details.get(j).getText();
                        break;
                    case "Bedrooms":
                        bedroom = details.get(j).getText().replaceAll("\\D+","");
                        break;
                    case "Bathrooms":
                        bathroom = details.get(j).getText().replaceAll("\\D+","");
                        break;
                    case "Region":
                        region = details.get(j).getText();
                        break;
                    case "City":
                        city = details.get(j).getText();
                        break;
                    case "Barangay":
                        brngy = details.get(j).getText();
                        break;
                    case "Floor Area":
                        floorArea = details.get(j).getText().replaceAll(" sqm", "").replaceAll(",", "");
                        break;
                    case "Lot Area":
                        lotArea = details.get(j).getText().replaceAll(" sqm", "").replaceAll(",", "");
                        break;
                    case "Parking Space":
                        parkingSpace = details.get(j).getText();
                        break;
                    case "Pet Friendly":
                        petFriendly = details.get(j).getText();
                        break;
                }
            }
            System.out.println("fetching unit " + (i+1));
            if (!city.isEmpty())
                data.put(Integer.toString(i+2), new Object[] {unitName, finalPrice, description,
                        streetAddress.matches("^[\\p{ASCII}]*$") ? streetAddress : "", bedroom, bathroom, region, city, brngy,
                        floorArea, lotArea, parkingSpace, petFriendly, driver.getCurrentUrl(), imgs.substring(0, imgs.length()-2),
                        unitName.matches("^[\\p{ASCII}]*$") ? (description.matches("^[\\p{ASCII}]*$") ? "" : "description") :
                                (description.matches("^[\\p{ASCII}]*$") ? "unit name" : "unit name & description") });
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