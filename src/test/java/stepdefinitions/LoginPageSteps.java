package stepdefinitions;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginPageSteps {
    static WebDriver driver;
    static String actTitle;
    static String expTitle;

    @Given("user is on login page")
    public void user_is_on_login_page() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(8000);
    }
    @When("user enters username {string}")
    public void user_enters_username(String string) {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.id("login-button")).click();
    }
    @Then("user gets the title of the page")
    public void user_gets_the_title_of_the_page() throws InterruptedException {
        Thread.sleep(6000);
        actTitle = driver.getTitle();
    }
    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        expTitle = "Swag Labs";
        Assert.assertEquals(actTitle, expTitle);
    }


}



