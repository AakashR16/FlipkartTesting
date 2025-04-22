import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class MainTest {
    WebDriver driver;

    LandingPage page1;
    SearchResultPage page2;
    ProductPage page3;
    CartPage page4;

    @BeforeClass
    public void driverSetup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium Webdriver\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();

        page1 = new LandingPage(driver);
        page2 = new SearchResultPage(driver);
        page3 = new ProductPage(driver);
        page4 = new CartPage(driver);

    }

    @Test
    public void test1(){

        page1.openLandingPage();
        String windowTitle = driver.getTitle();
        Assert.assertNotNull(windowTitle);
        Assert.assertTrue(windowTitle.contains("Online Shopping Site"), "Title Mismatch, Test-1 Failed");

    }

    @Test
    public void test2(){

        page1.loginPopUpClose();

    }

    @Test
    public void test3(){

        page1.searchProduct();
        String url = driver.getCurrentUrl();
        Assert.assertNotNull(url);
        Assert.assertEquals(url, "https://www.flipkart.com/search?q=Smartphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off", "URL Mismatch, Test-3 Failed");

    }

    @Test
    public void test4(){

        page2.searchByBrand();
        String url = driver.getCurrentUrl();
        Assert.assertNotNull(url);
        Assert.assertEquals(url, "https://www.flipkart.com/search?q=Smartphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=off&as=off&p%5B%5D=facets.brand%255B%255D%3DSAMSUNG", "URL Mismatch, Test-4 Failed");

    }

    @Test
    public void test5() throws InterruptedException{

        page2.choosePhoneByBrand();
        String phoneTitle = driver.getTitle();
        Assert.assertNotNull(phoneTitle);
        Assert.assertEquals(phoneTitle, "SAMSUNG Galaxy F05 (Twilight Blue, 64 GB) (4 GB RAM)", "Title Mismatch, Test-5 Failed");

    }

    @Test
    public void test6(){

        page3.addToCartOrEMI();

    }

    @Test
    public void test7(){

        try{

            page4.placeOrder();

        }
        catch(NoSuchElementException a){

            System.out.print("CartPage has not loaded");

        }
        catch (InterruptedException b) {

            System.out.print("Interruption has occurred");

        }
    }

    @AfterClass
    public void tearDown() throws InterruptedException {

        Thread.sleep(8000);
        driver.quit();

    }

}