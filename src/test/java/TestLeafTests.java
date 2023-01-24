import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v106.systeminfo.model.Size;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


import java.time.Duration;
import java.util.List;

public class TestLeafTests {

    protected WebDriver driver;
    protected Actions action;
    private Assertion assertion = new Assertion();

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.leafground.com/dashboard.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void textTests() throws InterruptedException {
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node01942ypjnd2ut71nxj7q7p5yjc8371316.node0");
        Thread.sleep(500);
        WebElement pressEnter = driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']"));
        pressEnter.sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        String errorText = driver.findElement(By.xpath("//span[@id='j_idt106:thisform:j_idt110_error-detail']")).getText();

        System.out.println(errorText);
        Thread.sleep(2000);
        if (errorText.equals("Age is mandatory")) {
            System.out.println("Error confirmed");
            WebElement pressEnter1 = driver.findElement(By.xpath("//input[@id='j_idt106:thisform:age']"));
            pressEnter1.sendKeys("28");

        } else {
            System.out.println("Lol no error");
        }

        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='j_idt88:name']")).sendKeys("John Albesa");

        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='j_idt88:j_idt91']")).sendKeys("AppendedMessage");

        Thread.sleep(500);
        WebElement disabledBox = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt93']"));
        try {
            disabledBox.sendKeys("Check If Added");
        } catch (Exception e) {
            System.out.println("Lol so that's an error");
        }
        String actualText = disabledBox.getAttribute("value");
        if (!actualText.equals("Check If Added")) {
            System.out.println("Ya it's not getting added lol");
        } else {
            System.out.println("How did that get added?");
        }

        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='j_idt88:j_idt95']")).clear();

        Thread.sleep(500);
        String retrieveMessage = driver.findElement(By.xpath("//input[@id='j_idt88:j_idt97']")).getAttribute("value");
        System.out.println(retrieveMessage);

        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys("john.albesa@email.com");
        driver.findElement(By.xpath("//input[@id='j_idt88:j_idt99']")).sendKeys(Keys.TAB + " IT HAS SHIFTED TO THE TYPE ABOUT MYSELF SECTION THEREFOR IT MUST HAVE SUCCEEDED");


        Thread.sleep(500);
        WebElement enterAndPick = driver.findElement(By.xpath("//input[@id='j_idt106:auto-complete_input']"));
        enterAndPick.sendKeys("John Albesa");
        enterAndPick.click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[@role='option' and text() ='3']")).click();


		/*
		Thread.sleep(3000);
		Select chooseThird = new Select(driver.findElement(By.xpath("//li[@role='option']")));
		List<WebElement> totalList = chooseThird.getOptions();

		for(WebElement elem : totalList) {
			System.out.println(elem);
		}*/


        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']")).sendKeys("03/26/1995");

        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@tabindex='0' and text() = 25]")).click();
        //li[@data-item-label='John Albesa3']

        Thread.sleep(1000);
        int random = (int) (Math.random() * (100 - 1 + 1) + 1);
        System.out.println(random);
        WebElement randomNumInput = driver.findElement(By.xpath("//input[@id='j_idt106:j_idt118_input']"));
        randomNumInput.sendKeys(String.valueOf(random));


        WebElement digitClicker = driver.findElement(By.xpath("//a[@class='ui-spinner-button ui-spinner-up ui-corner-tr ui-button ui-widget ui-state-default ui-button-text-only']"));


        while (Integer.parseInt(driver.findElement(By.xpath("//input[@id='j_idt106:j_idt118_input']")).getAttribute("value")) < (random + 20)) {
            Thread.sleep(500);
            digitClicker.click();
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='j_idt106:slider']")).sendKeys(String.valueOf(random));

        try {
            System.out.println(driver.findElement(By.xpath("//span[@style='left: 0%;']")));

        } catch (Exception e) {
            System.out.println("0% not being found means that the slider moved because random minimum is 1");
        }

        //j_idt106:j_idt122
        Thread.sleep(500);
        driver.findElement(By.xpath("//input[@id='j_idt106:j_idt122']")).click();
        driver.findElement(By.xpath("//button[@role='button' and text()='Shift']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'J']")).click();
        driver.findElement(By.xpath("//button[@role='button' and text()='Shift']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'o']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'h']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'n']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@title='Space']")).click();
        driver.findElement(By.xpath("//button[@role='button' and text()='Shift']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'A']")).click();
        driver.findElement(By.xpath("//button[@role='button' and text()='Shift']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'l']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'b']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'e']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 's']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//button[@class='keypad-key ui-corner-all ui-state-default' and text() = 'a']")).click();
        digitClicker.click();
    }

    @Test
    public void buttonTests() throws InterruptedException {
        driver.get("https://www.leafground.com/button.xhtml");
        driver.findElement(By.id("j_idt88:j_idt90")).click();
        assertion.assertEquals(driver.getTitle(), "Dashboard");

        driver.navigate().back();
        assertion.assertFalse(driver.findElement(By.xpath("//button[@disabled='disabled']")).isEnabled());

        int pointX = driver.findElement(By.id("j_idt88:j_idt94")).getLocation().getX();
        int pointY = driver.findElement(By.id("j_idt88:j_idt94")).getLocation().getY();
        System.out.println("Position X : " + pointX + " Position Y :" + pointY);

        Dimension size = driver.findElement(By.id("j_idt88:j_idt98")).getSize();
        System.out.println("The size of the button is : " + size);


        action = new Actions(driver);
        String originalColor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']")).getAttribute("class");
        System.out.println(originalColor);
        action.moveToElement(driver.findElement(By.id("j_idt88:j_idt100"))).perform();
        String hoveredColor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']")).getAttribute("class");
        System.out.println(hoveredColor);
        assertion.assertNotEquals(hoveredColor, originalColor);


        List<WebElement> elementList = driver.findElements(By.id("j_idt88"));

        for (WebElement elem : elementList) {
            System.out.println(elem);
        }
        ;

        List<WebElement> webElementList = driver.findElements(By.xpath("//form[@id='j_idt88']/div/div[2]/div[4]/button"));
        System.out.println("There are: " + webElementList.size() + " rounded buttons");


    }


}
