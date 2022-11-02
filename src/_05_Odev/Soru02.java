package _05_Odev;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Soru02 extends BaseDriver {
    @Test
    public void Test() throws InterruptedException {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        Actions actions = new Actions(driver);

        List<WebElement> student = driver.findElements(By.xpath("//*[@id='allItems']//li"));
        List<WebElement> team = driver.findElements(By.xpath("//*[@id='dhtmlgoodies_mainContainer']//ul"));

        Actions aksiyonlar=new Actions(driver);

        ArrayList<String> students=new ArrayList<>();
        ArrayList<String> teams=new ArrayList<>();

        for (WebElement s:student){
            if (s.getAttribute("id").contains("node")){
                students.add(s.getAttribute("id"));
            }

        }
        for (WebElement t:team){
            if (t.getAttribute("id").contains("box")){
                teams.add(t.getAttribute("id"));
            }

        }

        for (int i = 0; i < students.size(); i++) {
            for (int j= 0;  j< teams.size();j++) {
                driver.manage().window().fullscreen();
                WebElement stu= driver.findElement(By.id(students.get(i)));
                WebElement tea= driver.findElement(By.id(teams.get(j)));
                Action aksiyon= aksiyonlar.clickAndHold(stu).build();
                aksiyon.perform();
                Thread.sleep(150);
                aksiyon=aksiyonlar.moveToElement(tea).release().build();
                aksiyon.perform();
                Thread.sleep(150);

            }

        }

        Kapat();

    }
}