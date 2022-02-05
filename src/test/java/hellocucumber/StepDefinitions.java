package hellocucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.*;


public class StepDefinitions {
    private WebDriver driver = null;

    public StepDefinitions() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("I open {string} link")
    public void i_open_link(String link) {
        driver.get(link);
    }
    @Given("I click search input")
    public void i_click_search_input() {
        WebElement searchInput = driver.findElement(By.cssSelector(".desktopOldAutosuggestTheme-input"));
        searchInput.click();
    }
    @Given("I type {string} in search input")
    public void i_type_in_search_input(String string) {
        WebElement searchInput = driver.findElement(By.cssSelector(".desktopOldAutosuggestTheme-input"));
        searchInput.sendKeys(string);
    }
    @When("I click search button")
    public void i_click_search_button() {
        WebElement searchButton = driver.findElement(By.cssSelector(".SearchBoxOld-buttonContainer"));
        searchButton.click();
    }
    @Then("I should see {string} products in suggest list")
    public void i_should_see_products_in_suggest_list(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement suggestList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-list")));
        String suggestText = suggestList.getText();

        assertTrue(suggestText.contains(searchText));
    }


    @Given("I click main login button")
    public void iClickMainLoginButton() {
        WebElement myAccount = driver.findElement(By.cssSelector("#myAccount"));
        Actions builder = new Actions(driver);
        builder.moveToElement(myAccount).perform();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#login")));
        loginButton.click();
    }

    @When("I login with {string} email and {string} password")
    public void iLoginWithEmailAndPassword(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement eMailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUserName")));
        eMailElement.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(eMailElement).sendKeys(email).perform();

        WebElement loginButton = driver.findElement(By.cssSelector("#btnLogin"));
        loginButton.click();
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#txtPassword")));
        passwordElement.sendKeys(password);

        WebElement login = driver.findElement(By.cssSelector("#btnEmailSelect"));
        login.click();
    }

    @Then("I see my name")
    public void iSeeMyName() {
        // TODO find user anme input exist
    }
}
