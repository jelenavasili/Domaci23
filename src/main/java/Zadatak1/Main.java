package Zadatak1;
//Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com,
// izlistati sve kategorije (Stvari) sa leve strane i njihove linkove (kao spoken tekst “kategorija: link”),
// kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu, iskoristiti element iz nje da se klikne),
// kliknuti na Električni (mozete hardcodovati). Ostati na toj strani kao kraj zadatka.
// Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.
//
//Obratiti paznju na "ad" koji kaze da se registrujete.
// Uzeti dugme x i kliknuti ga pre svega da ne bi ste imali problem da ne mozete da kliknete na kategoriju.
//
//Za 5+ nakon klika na kategoriju bicikli, treba izlistati sve kategorije koje pisu (Mountainbike, Gradski itd).


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\IdeaProjects\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kupujemprodajem.com/");

        driver.manage().window().maximize();

        WebElement closeButton = driver.findElement(By.className("kpBoxCloseButton"));
        closeButton.click();

        WebElement closeCookie = driver.findElement(By.className("i-understand")); // dva dana sam se mlatila dok nisam provalila da mora prvo da prihvati cookies, u suprotnom ne moze da otvori "bicikli"
        closeCookie.click();

        List<WebElement> linksStvari = driver.findElements(By.xpath("//*[@id=\"category-tree-content-goods\"]/a"));
        
        for (int i = 0; i < linksStvari.size(); i++) {
            WebElement linkStvari = linksStvari.get(i);
            System.out.println(linkStvari.getText() + " " + linkStvari.getAttribute("href"));
        }

        for (int i = 0; i< linksStvari.size(); i++) {

            if(linksStvari.get(i).getText().equals("Bicikli")) {
                linksStvari.get(i).click();

                WebElement el = driver.findElement(By.xpath("//*[@id=\"groupBox1360\"]/div[1]/h2/a/span"));
                el.click();
                break;
            }
        }
        try {
            Thread.sleep(4000);
            } catch(InterruptedException e){
                    e.printStackTrace();
                }
                driver.quit();
    }
}









