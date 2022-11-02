package _05_Odev;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Soru3 extends BaseDriver {
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
        Actions actions = new Actions(driver);
        List<WebElement> countrys = driver.findElements(By.xpath("//ul[@id='allItems']/li"));
        ArrayList<String> countysBoxs = new ArrayList<>();
        ArrayList<String> citysBoxs = new ArrayList<>();
        driver.manage().window().fullscreen();
        for (WebElement e : countrys) {
            if (e.getAttribute("id").contains("node")) {
                citysBoxs.add(e.getAttribute("id"));
            }
        }

        List<WebElement> citys = driver.findElements(By.xpath("//div[@id='dhtmlgoodies_mainContainer']/div/ul"));
        for (WebElement e : citys) {
            if (e.getAttribute("id").contains("box")) {

                countysBoxs.add(e.getAttribute("id"));
            }
        }

        for (int i = 0; i < citysBoxs.size(); i++) {
            for (int j = 0; j < countysBoxs.size(); j++) {
                WebElement cityss = driver.findElement(By.id(citysBoxs.get(i)));
                WebElement countryys = driver.findElement(By.id(countysBoxs.get(j)));

                actions.clickAndHold(cityss).build().perform();
                Thread.sleep(150);
                try {
                    actions.moveToElement(countryys).release().build().perform();
                    Thread.sleep(150);
                    driver.switchTo().alert().accept();
                } catch (Exception e) {
                }
                actions.moveToElement(countryys).release().build().perform();
                if (cityss.getCssValue("background").contains("rgb(0, 128, 0)")) {

                    break;
                }
            }
        }
        Kapat();
    }
}
