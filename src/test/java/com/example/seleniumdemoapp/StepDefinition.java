package com.example.seleniumdemoapp;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class StepDefinition {

    static WebDriver driver;


    @Given("SVT Play is available")
    public void svt_play_is_available() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.get("https://svtplay.se");
    }

    @When("User visits SVT Play")
    public void user_visits_svt_play() {
        driver.manage().window().maximize();
    }

    @Then("The title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle, "Länken verkar ej synas");
        driver.quit();
    }

    @Then("The menu links should be {string}, {string} and {string}")
    public void the_menu_links_should_be_and(String firstMenuLink, String secondMenuLink, String thirdMenuLink) {
        List<WebElement> actualMenuLinks = driver.findElements(By.className("sc-354ed288-1"));
        assertAll(
                () -> assertEquals(firstMenuLink, actualMenuLinks.get(0).getAttribute("href"), "Menylänk1 stämmer inte..."),
                () -> assertEquals(secondMenuLink, actualMenuLinks.get(1).getAttribute("href"), "Menylänk2 stämmer inte..."),
                () -> assertEquals(thirdMenuLink, actualMenuLinks.get(2).getAttribute("href"), "Menylänk3 stämmer inte...")
        );
        driver.quit();
    }

    @Then("The logo should be visible")
    public void the_logo_should_be_visible() {
        WebElement logo = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/a"));
        boolean result = logo.isDisplayed();
        assertTrue(result, "Loggan verkar inte synas");
        driver.quit();
    }

    @Then("The name for the main menu links should be {string}, {string} and {string}")
    public void the_name_for_the_main_menu_links_should_be_and(String firstMenuName, String secondMenuName, String thirdMenuName) {
        List<WebElement> actualMenuText = driver.findElements(By.className("sc-354ed288-1"));
        assertAll(
                () -> assertEquals(firstMenuName, actualMenuText.get(0).getText(), "Menytext1 stämmer inte..."),
                () -> assertEquals(secondMenuName, actualMenuText.get(1).getText(), "Menytext2 stämmer inte..."),
                () -> assertEquals(thirdMenuName, actualMenuText.get(2).getText(), "Menytext3 stämmer inte...")
        );
        driver.quit();
    }

    @When("Cookies are accepted")
    public void cookies_are_accepted() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div[2]/button[3]")));
        WebElement cookieButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[3]/div[2]/div/div/div[2]/button[3]"));
        cookieButton.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("fHHyBJ")));
    }

    @Then("The correct link in the footer should be visible")
    public void the_correct_link_in_the_footer_should_be_visible() {
        WebElement footerlink = driver.findElement(By.xpath("//a[@href=\"https://kontakt.svt.se/guide/tillganglighet\"]"));
        boolean result = footerlink.isDisplayed();
        assertTrue(result, "Länken verkar inte synas");
    }

    @And("the link text should be correct")
    public void the_link_text_should_be_correct() {
        WebElement footerlink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[5]/div[2]/p[1]/a/span[2]"));
        String text = footerlink.getText();
        assertEquals("Tillgänglighet i SVT Play", text, "Länkens text verkar inte stämma");
        driver.quit();
    }

    @Then("The link in footer should be clicked")
    public void the_link_in_footer_should_be_clicked() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href=\"https://kontakt.svt.se/guide/tillganglighet\"]")));
        driver.findElement(By.xpath("//a[@href=\"https://kontakt.svt.se/guide/tillganglighet\"]")).click();
    }

    @And("The headline in the following page should be correct")
    public void the_headline_in_the_following_page_should_be_correct() {
        String text = driver.findElement(By.className("text-3xl")).getText();
        assertEquals("Så arbetar SVT med tillgänglighet", text, "Rubriken verkar inte stämma");
        driver.quit();
    }

    @Then("The link to Program should be clicked")
    public void the_link_to_program_should_be_clicked() {
        WebElement programElement = driver.findElement(By.xpath("//a[@href=\"/program\"]"));
        programElement.click();
    }

    @Then("There should be {int} categories in the Program page")
    public void there_should_be_categories_in_the_program_page(Integer categories) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article.sc-a9073dc0-0")));
        List<WebElement> actualCategories = driver.findElements(By.cssSelector("article.sc-a9073dc0-0"));
        assertEquals(categories, actualCategories.size(), "Antalet kategorier verkar inte stämma");
        driver.quit();
    }

    @Then("There should be {int} stripes available on the start page")
    public void there_should_be_stripes_available_on_the_start_page(Integer stripes) {
        List<WebElement> actualStripes = driver.findElements(By.cssSelector("a.sc-f796aafd-4"));
        assertEquals(stripes, actualStripes.size(), "Antalet stripes verkar inte stämma");
        driver.quit();
    }

    @When("User click on KANALER")
    public void user_click_on_kanaler() {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/header/div[2]/div/div/nav/ul/li[3]/a")).click();
    }

    @Then("The title on the page should be {string}")
    public void the_title_on_the_page_should_be(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"play_main-content\"]/div/h1")));
        String actualTitle = driver.findElement(By.cssSelector("h1.sc-c358b5df-0")).getText();
        assertEquals(title, actualTitle, "Rubriken i Kanaler verkar inte stämma");
        driver.quit();
    }

    @And("User enters the settings page")
    public void user_enters_the_settings_page(){
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[3]/a[1]")).click();
    }

    @Then("The link for dataanvändning should be visible")
    public void the_link_for_dataanvändning_should_be_visible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"play_main-content\"]/div/div[1]/div/div/p[2]/a")));
        WebElement link = driver.findElement(By.xpath("//*[@id=\"play_main-content\"]/div/div[1]/div/div/p[2]/a"));
        boolean result = link.isDisplayed();
        assertTrue(result, "Länken verkar inte synas");
        driver.quit();
    }

    @And("User enters the contact page")
    public void user_enters_the_contact_page() {
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[3]/div/footer/div/div[3]/a[2]")).click();
    }

    @Then("There should be {int} shortcuts listed")
    public void there_should_be_shortcuts_listed(Integer shortcuts) {
        List<WebElement> actualShortcuts = driver.findElements(By.cssSelector("a.py-6"));
        assertEquals(shortcuts, actualShortcuts.size(), "Antalet genvägar verkar inte stämma");
        driver.quit();
    }

    @Then("SVT Plays logo should be visible in the footer of the page")
    public void svt_plays_logo_should_be_visible_in_the_footer_of_the_page() {
        WebElement logoType = driver.findElement(By.className("sc-87f10045-1"));
        boolean result = logoType.isDisplayed();
        assertTrue(result, "Loggan i sidfoten syns inte");
    }
}

