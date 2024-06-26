import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class Activity11 {
    public static void main(String[] args) {
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();
//
//      // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();
        // Open the browser
        driver.get("http://alchemy.hguy.co/crm");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement login = driver.findElement(By.id("user_name"));
        login.sendKeys("admin");
        WebElement pwd = driver.findElement(By.id("username_password"));
        pwd.sendKeys("pa$$w0rd");

        driver.findElement(By.id("bigbutton")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
        WebElement activity = driver.findElement(By.id("grouptab_0"));

        Actions action = new Actions(driver);
        action.moveToElement(activity).build().perform();

        WebElement nav = driver.findElement(By.id("moduleTab_9_Leads"));
        nav.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[4]")));

        WebElement importBtn = driver.findElement(By.xpath("//*[@id=\"actionMenuSidebar\"]/ul/li[4]"));
        importBtn.click();

        WebElement userF = driver.findElement(By.id("userfile"));
        String filePath = "C:\\Users\\PoojaM\\Downloads\\Leads.csv";
        userF.sendKeys(filePath);

        WebElement nextButton1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("gonext")));
        nextButton1.click();

        WebElement nextButton2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("gonext")));
        nextButton2.click();

// Submit to finish the import process
        WebElement nextButton3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"gonext\"]")));
        nextButton3.click();

        WebElement importSubmitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"importnow\"]")));
        importSubmitButton.click();

        WebElement viewLead = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/div[1]/div/div/div[1]/ul/li[3]/a/div[2]")));
        viewLead.click();


        //Close the browser
        driver.quit();
    }
}