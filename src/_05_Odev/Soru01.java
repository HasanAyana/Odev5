package _05_Odev;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import javax.swing.plaf.basic.BasicSliderUI;
import java.util.ArrayList;
import java.util.List;

public class Soru01 extends BaseDriver {
    @Test

    public  void test1() throws InterruptedException {

        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        Actions aksiyonlar=new Actions(driver);

        //List<WebElement> sehir=driver.findElements(By.xpath("//div[@id='answerDiv']/div"));
        ArrayList<String> sehirler=new ArrayList<>();


        List<WebElement> ulke=driver.findElements(By.xpath("//div[@class='dragDropSmallBox']"));
        ArrayList<String> ulkeler=new ArrayList<>();
        driver.manage().window().fullscreen();
        for (WebElement s:ulke) {
            if (s.getAttribute("id").contains("a")){
                sehirler.add(s.getAttribute("id"));
            }
            else ulkeler.add(s.getAttribute("id"));
        }

        for (int i=0;i<sehirler.size();i++){
            for (int j=0;j<ulkeler.size();j++){
                WebElement seh= driver.findElement(By.id(sehirler.get(i)));
                WebElement ulk= driver.findElement(By.xpath("//div[@id='" + ulkeler.get(j) + "']//following-sibling::div"));
                Action aksiyon=aksiyonlar.clickAndHold(seh).build();
                aksiyon.perform();
                Thread.sleep(150);
                aksiyon=aksiyonlar.moveToElement(ulk).release().build();
                aksiyon.perform();
                Thread.sleep(150);
                WebElement boxsColor = driver.findElement(By.xpath("//div[@id='" + sehirler.get(i) + "']"));
                if (boxsColor.getCssValue("background").contains("rgb(0, 128, 0)")) {
                    ulkeler.remove(ulkeler.get(j));
                    break;
                }
            }
        }

        Kapat();
    }
}
