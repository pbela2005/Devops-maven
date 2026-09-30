import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebpageTest {

    private WebDriver driver;

    @BeforeTest
    public void openBrowser() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://localhost:63342/Devovexp-2/index.html");
    }

    @Test
    public void titleValidationTest() {

        String actualTitle = driver.getTitle();

        System.out.println("Page Title: " + actualTitle);

        String expectedTitle = "Explore India";

        Assert.assertEquals(
                actualTitle,
                expectedTitle,
                "Title does not match"
        );

        Assert.assertTrue(
                actualTitle.contains("India"),
                "Title should contain 'India'"
        );
    }

    @AfterTest
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}