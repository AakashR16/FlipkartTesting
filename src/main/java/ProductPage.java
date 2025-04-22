import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ProductPage {

    WebDriver driver;

    ProductPage(WebDriver driver){

        this.driver = driver;

    }

    public void addToCartOrEMI(){

        try{

            driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ In9uk2' and text()='Add to cart']")).click();

        }
        catch (NoSuchElementException e){

            driver.findElement(By.xpath("//button[@class='QqFHMw vslbG+ _3Yl67G FMWyoY' and text()='Pay with EMI']")).click();

        }

    }

}