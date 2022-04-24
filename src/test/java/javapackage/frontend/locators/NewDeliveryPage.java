package javapackage.frontend.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NewDeliveryPage {

    public static By REQUEST_DELIVERY_TAB = By.id("newRequest-link");
    public static By UNDERSTOOD_BUTTON_REFUND_MODAL = By.xpath("//div/button/span[contains(text(),'Understood')]");
    public static By CLOSE_TESTING_SCENARIOS_BUTTON = By.id("ScenarioTooltipCloseButton");

    public static By NOW_TIME_OF_DELIVERY = By.id("now");
    public static By LATER_TIME_OF_DELIVERY = By.id("later");

    public static By REQUEST_BUTTON = By.id("requestButton");

    public static By NEW_JOB_POPUP = By.id("activeJobsCards");

    public static By PICK_UP_ADDRESS_ERROR = By.id("pickUp-error");
    public static By DROP_OFF_ADDRESS_ERROR = By.id("dropOff-error");

    //PICK-UP FORM
    public static By ADDRESS_PICKUP = By.id("pickUpCard-0-fields-field-address");
    public static By CONFIRM_NEAR_ADDRESS_PICKUP = By.id("item-15-rue-pereire-92500-rueil-malmaison");
    public static By CONFIRM_FAR_ADDRESS_PICKUP = By.id("item-82-rue-de-rivoli-75004-paris");
    public static By CONFIRM_INCORRECT_ADDRESS_PICKUP = By.id("item-rue-de-rivoli-paris");
    public static By FIRST_NAME_PICKUP = By.id("pickUpCard-0-fields-field-firstname");
    public static By LAST_NAME_PICKUP = By.id("pickUpCard-0-fields-field-lastname");
    public static By COMPANY_PICKUP = By.id("pickUpCard-0-fields-field-company");
    public static By PHONE_PICKUP = By.id("pickUpCard-0-fields-field-phone");
    public static By EMAIL_PICKUP = By.id("pickUpCard-0-fields-field-email");
    public static By DETAILS_PICKUP = By.id("pickUpCard-0-fields-field-comment");

    //DROP-OFF FORM
    public static By ADDRESS_DROPOFF = By.id("dropOffCard-0-fields-field-address");
    public static By CONFIRM_NEAR_ADDRESS_DROPOFF = By.id("item-2-rue-des-martinets-92500-rueil-malmaison");
    public static By CONFIRM_FAR_ADDRESS_DROPOFF = By.id("item-5-rue-des-picots-28260-rouvres");
    public static By CONFIRM_INCORRECT_ADDRESS_DROPOFF = By.id("item-rue-des-martinets-92500-rueil-malmaison");
    public static By FIRST_NAME_DROPOFF = By.id("dropOffCard-0-fields-field-firstname");
    public static By LAST_NAME_DROPOFF = By.id("dropOffCard-0-fields-field-lastname");
    public static By COMPANY_DROPOFF = By.id("dropOffCard-0-fields-field-company");
    public static By PHONE_DROPOFF = By.id("dropOffCard-0-fields-field-phone");
    public static By EMAIL_DROPOFF = By.id("dropOffCard-0-fields-field-email");
    public static By DETAILS_DROPOFF = By.id("dropOffCard-0-fields-field-comment");
    public static By ORDER_ID = By.id("dropOffCard-0-fields-field-clientReference");
    public static By ODER_INFO = By.id("dropOffCard-0-fields-field-packageDescription");

    //PICKUP VALUES
    public static String NEAR_ADDRESS_PICKUP_VALUE = "15 Rue Pereire, 92500 Rueil-Malmaison, France";
    public static String FAR_ADDRESS_PICKUP_VALUE = "82 Rue de Rivoli, 75004 Paris, France";
    public static String INCORRECT_ADDRESS_PICKUP_VALUE = "Rue de Rivoli";
    public static String FIRST_NAME_PICKUP_VALUE = "Pick";
    public static String LAST_NAME_PICKUP_VALUE = "Up";
    public static String COMPANY_PICKUP_VALUE = "Company Pickup";
    public static String PHONE_PICKUP_VALUE = "0707707070";
    public static String EMAIL_PICKUP_VALUE = "pickup@email.com";
    public static String DETAILS_PICKUP_VALUE = "Details for pickup";


    //DROPOFF VALUES
    public static String NEAR_ADDRESS_DROPOFF_VALUE = "2 Rue des Martinets, 92500 Rueil-Malmaison, France";
    public static String FAR_ADDRESS_DROPOFF_VALUE = "5 Rue des Picots, 28260 Rouvres, France";
    public static String INCORRECT_ADDRESS_DROPOFF_VALUE = "Rue des Martinets";
    public static String FIRST_NAME_DROPOFF_VALUE = "Drop";
    public static String LAST_NAME_DROPOFF_VALUE = "Off";
    public static String COMPANY_DROPOFF_VALUE = "Company Dropoff";
    public static String PHONE_DROPOFF_VALUE = "0707707071";
    public static String EMAIL_DROPOFF_VALUE = "dropoff@email.com";
    public static String DETAILS_DROPOFF_VALUE = "Details for dropoff";
    public static String ORDER_ID_VALUE = "";
    public static String ODER_INFO_VALUE = "";

}
