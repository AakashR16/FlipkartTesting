import org.openqa.selenium.*;
import java.util.Set;

public class SearchResultPage {

    WebDriver driver;

    SearchResultPage(WebDriver driver) {

        this.driver = driver;

    }

    public void choosePhone() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement phone = driver.findElement(By.xpath("//div[@class='KzDlHZ' and text()='Apple iPhone 16 Pro (Natural Titanium, 1 TB)']"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView({behaviour: 'auto', block: 'center', inline: 'center'});", phone);
        Thread.sleep(5000);
        phone.click();

        String originalHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String tabs : windowHandles) {
            if (!tabs.equals(originalHandle)) {
                driver.switchTo().window(tabs);
            }
        }

    }

    public void searchByBrand(){

        driver.findElement(By.xpath("//div[@title='SAMSUNG']")).click();

    }

    public void searchByBrandClear() throws InterruptedException {

        Thread.sleep(1000);
        driver.findElement(By.className("aGZXck")).click();

    }

    public void choosePhoneByBrand() throws InterruptedException {

        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)']")).click();

        String originalHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String tabs : windowHandles) {
            if (!tabs.equals(originalHandle)) {
                driver.switchTo().window(tabs);

            }
        }

    }
}
