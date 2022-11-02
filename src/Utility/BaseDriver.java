package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;

    static{
        KalanOncekileriKapat();

        Logger logger=Logger.getLogger("");
        logger.setLevel(Level.SEVERE); //sadece errorları gösterir.
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().deleteAllCookies();

        Duration dr=Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);//Sadece tüm sayfalanın kodlarını bilgisayarınıza inmesi süresyile ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar(sonsuza) bekler: 30 sn süresince sayfanın bekle yüklenmezse hata verir.

        driver.manage().timeouts().implicitlyWait(dr); //Elementin load edilmesi için geçmesi gereken max süre


    }

    public static void Kapat(){
        MyFunc.Bekle(5);
        driver.quit();
    }
    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }
}
