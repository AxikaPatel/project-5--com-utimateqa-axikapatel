package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseURL = " https://courses.ultimateqa.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        String expectedMessage = "Welcome Back!";

        //Verify the text ‘Welcome Back!’
        WebElement actualTextMessage = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage = actualTextMessage.getText();

        //Checking actual and expected result
        Assert.assertEquals("Error Message Display: ",actualMessage,expectedMessage);
    }

    @Test
    public void verifyTheErrorMessage()
    {
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();

        //Enter invalid username
        driver.findElement(By.xpath("//input[@name='user[email]']")).sendKeys("Axika@yahoo.com");

        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Axi123@");

        //Click on Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();

        String expectedMessage ="Invalid email or password.";

        //Verify the error message
        WebElement actualTextMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualTextMessage.getText();

        //checking actual and expected result
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
