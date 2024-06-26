import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity14 {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");
        String title=driver.getTitle();
        System.out.println(title);
        WebElement userName = driver.findElement(By.id("user_name"));
        userName.sendKeys("admin");

        WebElement password = driver.findElement(By.id("username_password"));
        password.sendKeys("pa$$w0rd");
        password.sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement salesOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"grouptab_0\"]")));
        salesOption.click();

        // Click on Opportunities
        WebElement opportunitiesOption = driver.findElement(By.xpath("//*[@id=\"moduleTab_9_Opportunities\"]"));
        opportunitiesOption.click();

        // Click on Filter icon
        WebElement filterIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/thead/tr[2]/td/table/tbody/tr/td[1]/ul[3]/li/a")));
        filterIcon.click();

        // Click on Advanced Filter
        WebElement advancedFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div/div[3]/div/div/div/div[1]/ul/li[2]")));
        advancedFilter.click();
        WebElement Clear = driver.findElement(By.xpath("//*[@id=\"search_form_clear_advanced\"]"));
        Clear.click();
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"search_form_submit_advanced\"]"));
        WebElement popUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"range_amount_advanced\"]")));
        popUp.click();
        WebElement selectUser = driver.findElement(By.name("assigned_user_id_advanced[]"));
        Select user = new Select(selectUser);
        new Actions(driver)
                .click(popUp)
                .sendKeys("500")
                .sendKeys(Keys.TAB)
                .perform();
        user.selectByVisibleText("admin");
        WebElement selectSales = driver.findElement(By.name("sales_stage_advanced[]"));
        Select sales = new Select(selectSales);
        sales.selectByVisibleText("Prospecting");
        submit.click();
        WebElement accountName = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[3]/form[2]/div[3]/table/tbody/tr/td[4]/a"));
        System.out.println(accountName.getText());
        WebElement clearFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pagination\"]/td/table/tbody/tr/td[1]/ul[4]/li[1]")));
        clearFilter.click();
        // Close the browser
        driver.quit();
    }
}