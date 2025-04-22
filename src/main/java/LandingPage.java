import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class LandingPage {

    WebDriver driver;
    LandingPage(WebDriver driver){

        this.driver = driver;

    }

    public void openLandingPage(){

        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

    }

    public void loginPopUpClose(){

        try{

            driver.findElement(By.className("_30XB9F")).click();

        }

        catch(NoSuchElementException e){

            System.out.println("There is no element found");

        }
    }

    public void searchProduct(){

        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("Smartphone");
        search.submit();

    }

    public void loginFunctionality(String userInput){

        driver.findElement(By.xpath("//a[@title='Login']//span[text()='Login']")).click();
        WebElement textField = driver.findElement(By.xpath("//div[@class='I-qZ4M vLRlQb']//input[@type='text']"));
        textField.sendKeys(userInput);
        driver.findElement(By.xpath("//button[@class='QqFHMw twnTnD _7Pd1Fp' and text() = 'Request OTP']")).click();

    }

    public void searchCategory() throws InterruptedException {

        Actions actions = new Actions(driver);
        WebElement category = driver.findElement(By.xpath("//div[@aria-label='Electronics']"));
        actions.moveToElement(category);
        actions.perform();

        WebElement drop1 = driver.findElement(By.xpath("//a[text()='Laptop and Desktop']"));
        actions.moveToElement(drop1);
        actions.perform();
        Thread.sleep(1000);

        WebElement drop2 = driver.findElement(By.xpath("//a[@class='_3490ry' and text()='Laptops']"));
        actions.moveToElement(drop2);
        actions.click();
        actions.perform();

    }
}
