package googlesearch;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class StepDefs {

    WebDriver driver;

    public void openUrl(String Url){
        driver.get(Url);
    }

    public void clickElement(String locator){
        boolean clicked = false;
        do {
            try {
                driver.findElement(By.xpath(locator)).click();
                clicked = true;
            } catch (ElementNotInteractableException e) {
                e.printStackTrace();
            }
        } while (!clicked);
    }

    public void enterText(String locator, String searchPattern){
        driver.findElement(By.xpath(locator)).sendKeys(searchPattern);
    }

    public boolean isPatternFound(String locator, String searchPattern){
        List<WebElement> resultList = driver.findElements(By.xpath(locator));
        for(WebElement webElement : resultList){
            if(webElement.getText().contains(searchPattern));
            return true;
        }
        return false;
    }
}
