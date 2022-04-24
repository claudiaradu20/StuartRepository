package javapackage.frontend.stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javapackage.frontend.locators.NewDeliveryPage;
import javapackage.frontend.locators.ScheduledDelivery;
import javapackage.frontend.steps.BaseSteps;
import javapackage.frontend.steps.NewDeliverySteps;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;

@Slf4j
public class NewDeliveryStepDefinitions {

    @Steps
    NewDeliverySteps newDeliverySteps;

    @Steps
    BaseSteps baseSteps;

    @Given("the user is logged in in the application with {string} email and {string} password")
    public void logInTheApplication(String givenEmail, String givenPassword)  {

        String password = newDeliverySteps.getPassword(givenPassword);
        String email = newDeliverySteps.getEmail(givenEmail);

        newDeliverySteps.authenticateInStuartFrontend(email, password);

        baseSteps.closePopup(NewDeliveryPage.UNDERSTOOD_BUTTON_REFUND_MODAL);
        baseSteps.closePopup(NewDeliveryPage.CLOSE_TESTING_SCENARIOS_BUTTON);
        log.info("Authentication successful");
    }

    @And("the user fills in the fields with a {string} address")
    public void fillInFieldsInAddress(String type){

        String address = newDeliverySteps.getAddressByType(type);
        By addressConfirmation = newDeliverySteps.getAddressConfirmation(type);

        if (type.equalsIgnoreCase("far pick-up")){
            newDeliverySteps.fillInFieldsInPickUpForm(address, addressConfirmation);

        } else if (type.equalsIgnoreCase("near pick-up")){
            newDeliverySteps.fillInFieldsInPickUpForm(address, addressConfirmation);

        } else if (type.equalsIgnoreCase("incorrect pick-up")){
            baseSteps.fillInField(NewDeliveryPage.ADDRESS_PICKUP, NewDeliveryPage.INCORRECT_ADDRESS_PICKUP_VALUE);
            baseSteps.clickOnElementIfPresent(NewDeliveryPage.CONFIRM_INCORRECT_ADDRESS_PICKUP);

        } else if (type.equalsIgnoreCase("far drop-off")){
            newDeliverySteps.fillInFieldsInDropOffForm(address, addressConfirmation);

        } else if (type.equalsIgnoreCase("near drop-off")){
            newDeliverySteps.fillInFieldsInDropOffForm(address, addressConfirmation);

        } else if (type.equalsIgnoreCase("incorrect drop-off")){
            baseSteps.fillInField(NewDeliveryPage.ADDRESS_DROPOFF, NewDeliveryPage.INCORRECT_ADDRESS_DROPOFF_VALUE);
            baseSteps.clickOnElementIfPresent(NewDeliveryPage.CONFIRM_INCORRECT_ADDRESS_DROPOFF);
        }
    }

    @Then("message 'The address is not accurate enough' is displayed in {string} Address Form")
    public void addressErrorMessageIsDisplayed(String address){

        if (address.equalsIgnoreCase("pick-up")){
            baseSteps.assertElementIsPresentInPage(NewDeliveryPage.PICK_UP_ADDRESS_ERROR);

        } else if (address.equalsIgnoreCase("drop-off")) {
            baseSteps.assertElementIsPresentInPage(NewDeliveryPage.DROP_OFF_ADDRESS_ERROR);
        }
    }

    @And("the user selects a {string} vehicle")
    public void userSelectsSpecificVehicle(String vehicle){

        newDeliverySteps.selectVehicleFromOptions(vehicle);
        log.info("User selected successfully a " + vehicle + " for transport");
    }

    @And("the user selects an available vehicle")
    public void userSelectsAvailableVehicle(){

        newDeliverySteps.selectEnabledVehicle();
    }

    @Then("{string}, {string}, {string} and {string} vehicles are not available")
    public void checkIfVehicleIsAvailable(String vehicle1, String vehicle2, String vehicle3, String vehicle4){

        newDeliverySteps.checkVehicleTypeDisabled(vehicle1);
        newDeliverySteps.checkVehicleTypeDisabled(vehicle2);
        newDeliverySteps.checkVehicleTypeDisabled(vehicle3);
        newDeliverySteps.checkVehicleTypeDisabled(vehicle4);
    }

    @And("the user selects a {string} as time of delivery")
    public void userSelectsTimeOfDelivery(String time){

        newDeliverySteps.selectTimeOfDelivery(time);
        log.info("User selected successfully a " + time + " as time of delivery");
    }

    @When("the user clicks on the REQUEST BUTTON")
    public void userRequestsDelivery(){

        baseSteps.clickOnElementIfPresent(NewDeliveryPage.REQUEST_BUTTON);
    }

    @Then("a new job is created")
    public void aNewRequestIsCreated(){

        baseSteps.waitAndCheckIfElementPresent(NewDeliveryPage.NEW_JOB_POPUP);
    }

    @Then("a new job is scheduled")
    public void aNewRequestIsScheduled(){

        baseSteps.waitAndCheckIfElementPresent(ScheduledDelivery.SCHEDULED_JOBS_PAGE_ID);
    }






}
