import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    CartPage(WebDriver driver){

        this.driver = driver;

    }

    public void placeOrder() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Place Order']")).click();
    }
}