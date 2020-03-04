package googlesearch;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StepDefs {

    WebDriver driver;

    public void clickElement(String locator){
        boolean clicked = false;
        do {
            try {
                driver.findElement(By.xpath(locator)).click();
                clicked = true;
            } catch (ElementNotInteractableException e) {
            }
        } while (!clicked);
    }

    public void inputText(String locator, String searchPattern){
        driver.findElement(By.xpath(locator)).sendKeys(searchPattern);
    }

    public boolean isMatchFound(String locator, String searchPattern){
        List<WebElement> webElementList = driver.findElements(By.xpath(locator));
        for(WebElement element : webElementList){
            if(element.getText().contains(searchPattern)){
                return true;
            }
        }
        return false;
    }

    public void openURL(String Url){
        driver.get(Url);
    }
}

