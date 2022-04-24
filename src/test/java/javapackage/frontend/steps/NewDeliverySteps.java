package javapackage.frontend.steps;

import javapackage.frontend.locators.AuthenticatePage;
import javapackage.frontend.locators.NewDeliveryPage;
import javapackage.frontend.locators.VehicleCard;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.By;
import utils.URLManager;

public class NewDeliverySteps {


   @Steps
   BaseSteps baseSteps;

   @Step("authenticate in Stuart")
   public void authenticateInStuartFrontend(String email, String password){

      baseSteps.navigatetoURL(URLManager.AUTHENTICATEPAGEURL, AuthenticatePage.EMAIL);
      baseSteps.fillInField(AuthenticatePage.EMAIL, email);
      baseSteps.fillInField(AuthenticatePage.PASSWORD, password);
      baseSteps.clickWithWait(AuthenticatePage.LOG_IN_BUTTON, NewDeliveryPage.REQUEST_DELIVERY_TAB);
   }

   @Step("get password to log in")
   public String getPassword(String password){

      if (password.equalsIgnoreCase("blank")) {
         password = "";
      } else if (password.equalsIgnoreCase("incorrect")){
         password = "123";
      } else if (password.equalsIgnoreCase("correct")){
         password = AuthenticatePage.authenticatePassword;
      } else throw new IllegalArgumentException(password);

      return password;
   }

   @Step("get email to log in")
   public String getEmail(String email){

      if (email.equalsIgnoreCase("blank")) {
         email = "";
      } else if (email.equalsIgnoreCase("incorrect")){
         email = "123";
      } else if (email.equalsIgnoreCase("correct")){
         email = AuthenticatePage.authenticateEmail;
      } else throw new IllegalArgumentException(email);

      return email;
   }

   @Step("get address by type")
   public String getAddressByType(String type){

      String address = null;

      if (type.equalsIgnoreCase("far pick-up")){
         address = NewDeliveryPage.FAR_ADDRESS_PICKUP_VALUE;
      } else if (type.equalsIgnoreCase("near pick-up")){
         address = NewDeliveryPage.NEAR_ADDRESS_PICKUP_VALUE;
      } else if (type.equalsIgnoreCase("incorrect pick-up")){
         address = NewDeliveryPage.INCORRECT_ADDRESS_PICKUP_VALUE;
      } else if (type.equalsIgnoreCase("far drop-off")){
         address = NewDeliveryPage.FAR_ADDRESS_DROPOFF_VALUE;
      } else if (type.equalsIgnoreCase("near drop-off")){
         address = NewDeliveryPage.NEAR_ADDRESS_DROPOFF_VALUE;
      } else if (type.equalsIgnoreCase("incorrect drop-off")) {
         address = NewDeliveryPage.INCORRECT_ADDRESS_DROPOFF_VALUE;
      }

      return address;
   }

   @Step("get address confirmation based on address type")
   public By getAddressConfirmation(String type){

      By addressConfirmation = null;

      if (type.equalsIgnoreCase("far pick-up")){
         addressConfirmation = NewDeliveryPage.CONFIRM_FAR_ADDRESS_PICKUP;
      } else if (type.equalsIgnoreCase("near pick-up")){
         addressConfirmation = NewDeliveryPage.CONFIRM_NEAR_ADDRESS_PICKUP;
      } else if (type.equalsIgnoreCase("far drop-off")){
         addressConfirmation = NewDeliveryPage.CONFIRM_FAR_ADDRESS_DROPOFF;
      } else if (type.equalsIgnoreCase("near drop-off")){
         addressConfirmation = NewDeliveryPage.CONFIRM_NEAR_ADDRESS_DROPOFF;
      }

      return addressConfirmation;
   }

   @Step("fill in fields in PICK-UP form")
   public void fillInFieldsInPickUpForm(String addressType, By addressConfirmation){

      baseSteps.fillInField(NewDeliveryPage.ADDRESS_PICKUP, addressType);
      baseSteps.clickOnElementIfPresent(addressConfirmation);
      baseSteps.fillInField(NewDeliveryPage.FIRST_NAME_PICKUP, NewDeliveryPage.FIRST_NAME_PICKUP_VALUE);
      baseSteps.fillInField(NewDeliveryPage.LAST_NAME_PICKUP, NewDeliveryPage.LAST_NAME_PICKUP_VALUE);
      baseSteps.fillInField(NewDeliveryPage.COMPANY_PICKUP, NewDeliveryPage.COMPANY_PICKUP_VALUE);
      baseSteps.fillInField(NewDeliveryPage.PHONE_PICKUP, NewDeliveryPage.PHONE_PICKUP_VALUE);
      baseSteps.fillInField(NewDeliveryPage.EMAIL_PICKUP, NewDeliveryPage.EMAIL_PICKUP_VALUE);
      baseSteps.fillInField(NewDeliveryPage.DETAILS_PICKUP, NewDeliveryPage.DETAILS_PICKUP_VALUE);
   }

   @Step("fill in fields in DROP-OFF form")
   public void fillInFieldsInDropOffForm(String address, By addressConfirmation){

      baseSteps.fillInField(NewDeliveryPage.ADDRESS_DROPOFF, address);
      baseSteps.clickOnElementIfPresent(addressConfirmation);
      baseSteps.fillInField(NewDeliveryPage.FIRST_NAME_DROPOFF, NewDeliveryPage.FIRST_NAME_DROPOFF_VALUE);
      baseSteps.fillInField(NewDeliveryPage.LAST_NAME_DROPOFF, NewDeliveryPage.LAST_NAME_DROPOFF_VALUE);
      baseSteps.fillInField(NewDeliveryPage.COMPANY_DROPOFF, NewDeliveryPage.COMPANY_DROPOFF_VALUE);
      baseSteps.fillInField(NewDeliveryPage.PHONE_DROPOFF, NewDeliveryPage.PHONE_DROPOFF_VALUE);
      baseSteps.fillInField(NewDeliveryPage.EMAIL_DROPOFF, NewDeliveryPage.EMAIL_DROPOFF_VALUE);
      baseSteps.fillInField(NewDeliveryPage.DETAILS_DROPOFF, NewDeliveryPage.DETAILS_DROPOFF_VALUE);
   }

   @Step("select vehicle from options")
   public void selectVehicleFromOptions(String option){

      baseSteps.scrollToElement(VehicleCard.CAR_VEHICLE);

      if (option.equalsIgnoreCase("Walker")) {
         baseSteps.clickOnElementIfPresent(VehicleCard.WALKER_VEHICLE);
      } else if (option.equalsIgnoreCase("Bike")){
         baseSteps.clickOnElementIfPresent(VehicleCard.BIKE_VEHICLE);
      } else if (option.equalsIgnoreCase("Motorbike")){
         baseSteps.clickOnElementIfPresent(VehicleCard.MOTORBIKE_VEHICLE);
      } else if (option.equalsIgnoreCase("Cargobike")){
         baseSteps.clickOnElementIfPresent(VehicleCard.CARGOBIKE_VEHICLE);
      } else throw new IllegalArgumentException(option);
   }

   @Step("get vehicle by type")
   public By getVehicleByType(String type){

      By vehicle = null;

      if (type.equalsIgnoreCase("Walker")) {
         vehicle = VehicleCard.WALKER_VEHICLE;
      } else if (type.equalsIgnoreCase("Bike")){
         vehicle = VehicleCard.BIKE_VEHICLE;
      } else if (type.equalsIgnoreCase("Motorbike")){
         vehicle = VehicleCard.MOTORBIKE_VEHICLE;
      } else if (type.equalsIgnoreCase("Cargobike")){
         vehicle = VehicleCard.CARGOBIKE_VEHICLE;
      } else throw new IllegalArgumentException(type);

      return vehicle;
   }

   @Step("check if vehicle type is disabled")
   public void checkVehicleTypeDisabled(String vehicleType){

      By vehicle = getVehicleByType(vehicleType);
      baseSteps.assertElementDisabled(vehicle);
   }

   @Step("get enabled vehicle and select")
   public void selectEnabledVehicle(){

      baseSteps.scrollToElement(VehicleCard.CAR_VEHICLE);
      baseSteps.assertElementsAreEnabledAndClick(VehicleCard.LISTOFVEHICLES);
   }

   @Step("select time of delivery from options")
   public void selectTimeOfDelivery(String option){

      if (option.equalsIgnoreCase("Now")) {
         baseSteps.clickOnElementIfPresent(NewDeliveryPage.NOW_TIME_OF_DELIVERY);
      } else if (option.equalsIgnoreCase("Later")){
         baseSteps.clickOnElementIfPresent(NewDeliveryPage.LATER_TIME_OF_DELIVERY);
      } else throw new IllegalArgumentException(option);
   }
}
