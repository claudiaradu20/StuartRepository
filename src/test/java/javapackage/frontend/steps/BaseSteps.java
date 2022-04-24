package javapackage.frontend.steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BaseSteps extends PageObject {

    public void navigatetoURL(String url, By element){

        this.getDriver().get(url);
        assertElementIsPresentInPage(element);
    }

    public void assertElementIsPresentInPage(By element) {

        log.info("Evaluated element: " + element.toString());
        Assert.assertTrue($(element).waitUntilPresent().isPresent());
    }

    public void assertElementIsNotPresentInPage(By element) {

        log.info("Evaluated element: " + element.toString());
        Assert.assertFalse($(element).waitUntilPresent().isPresent());
    }

    public void clickOnElementIfPresent(By element) {

        if (this.$(element).isCurrentlyVisible()) {
            this.$(element).waitUntilClickable().click();
        }
    }

    @Step("Writing a value in a field")
    public void fillInField(By element, String value){

        this.$(element).waitUntilEnabled().type(new CharSequence[]{value});
    }


    @Step("clicks with wait on element {0} and checks the presence of element {1}")
    public void clickWithWait(By elementToClick, By elementToCheck) {

        this.$(elementToClick).waitUntilClickable().click();
        assertElementIsPresentInPage(elementToCheck);
    }

    @Step("close pop-up if shown")
    public void closePopup(By element) {

        if (this.$(element).isCurrentlyVisible()) {
            do {
                this.$(element).waitUntilClickable().click();
            } while (this.$(element).isCurrentlyVisible());
        } else {
            log.info("Element " + element + " is not visible");
        }
    }

    @Step("wait and check if element is present")
    public void waitAndCheckIfElementPresent(By element){

        waitABit(10000);
        assertElementIsPresentInPage(element);
    }

    @Step("scroll to element")
    public void scrollToElement(By element) {

        this.evaluateJavascript("arguments[0].scrollIntoView(true);", new Object[]{getDriver().findElement(element)});
    }

    @Step("check if element is enabled")
    public void assertElementEnabled(By element){

        var foundElement = getDriver().findElement(element);
        Assert.assertTrue(foundElement.isEnabled());
    }

    @Step("check if element is disabled")
    public void assertElementDisabled(By element){

        var foundElement = getDriver().findElement(element);
        Assert.assertFalse(foundElement.isEnabled());
    }

    @Step("check if element is enabled and click on element")
    public void assertElementsAreEnabledAndClick(List<By> listOfElements) {

        for (By element : listOfElements) {
            var foundElement = getDriver().findElement(element);
            if (foundElement.isEnabled()) {
                clickOnElementIfPresent(element);
            }
        }
    }




}
