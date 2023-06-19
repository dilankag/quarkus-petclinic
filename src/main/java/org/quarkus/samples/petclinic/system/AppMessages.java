package org.quarkus.samples.petclinic.system;

import io.quarkus.qute.i18n.Message;
import io.quarkus.qute.i18n.MessageBundle;

@MessageBundle
public interface AppMessages {

    @Message("Quarkus Pet Clinic")
    String product_title();

    @Message("Find Owner")
    String find_owner();

    @Message("Edit Owner")
    String edit_owner();

    @Message("Add Owner")
    String add_owner();

    @Message("Find Owners")
    String find_owners();

    @Message("Name")
    String name();

    @Message("First Name")
    String first_name();

    @Message("Last Name")
    String last_name();

    @Message("Address")
    String address();

    @Message("Telephone")
    String telephone();

    @Message("Email")
    String email();

    @Message("Password")
    String password();

    @Message("City")
    String city();

    @Message("Pets")
    String pets();

    @Message("Pet")
    String pet();

    @Message("Opps")
    String error();

    @Message("User not found!")
    String error_user_not_found();

    @Message("User credentials not matched!")
    String error_user_credentials_not_matched();

    @Message("User credentials not supplied!")
    String error_user_credentials_not_supplied();

    @Message("User authentication has failed!")
    String error_user_authentication_has_failed();

    @Message("OTP not matched!")
    String error_otp_not_matched();

    @Message("User already exist!")
    String error_user_already_exist();

    @Message("None")
    String none();

    @Message("Veterinarians")
    String veterinarians();

    @Message("Specialties")
    String specialties();

    @Message("Welcome to")
    String welcome_to();

    @Message("Sign in to")
    String sign_in_to();

    @Message("New to")
    String new_to();

    @Message("Back to")
    String back_to();

    @Message("Sign in")
    String sign_in();

    @Message("Sign up")
    String sign_up();

    @Message("Sign out")
    String sign_out();

    @Message("Forgot password?")
    String forgot_password();

    @Message("Create an account")
    String create_an_account();

    @Message("Birthdate")
    String birthdate();

    @Message("Type")
    String type();

    @Message("Owner")
    String owner();

    @Message("User")
    String user();

    @Message("Edit Pet")
    String edit_pet();

    @Message("Add Pet")
    String add_pet();

    @Message("Add Visit")
    String add_visit();

    @Message("Visit Date")
    String visit_date();

    @Message("Description")
    String description();

    @Message("New")
    String new_();

    @Message("Visit")
    String visit();

    @Message("Date")
    String date();

    @Message("Home")
    String home();

    @Message("Pets and Visits")
    String pets_and_visits();

    @Message("Previous Visits")
    String previous_visits();

    @Message("Something went wrong!!!")
    String something_went_wrong();

    @Message("Information")
    String information();

    @Message("OTP")
    String OTP();

    @Message("Verify")
    String verify();

    @Message("Alert")
    String alert();
}
