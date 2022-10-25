package controller;

import controller.util.InputValidationUtil;
import model.RentalAgreement;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        try{
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter Code for tool to be rented:");
            String toolCode = keyboard.next();
            InputValidationUtil.validateToolCode(toolCode);

            System.out.println("Number of days tool will be rented (must be at least 1 day):");
            int rentalDays = keyboard.nextInt();
            InputValidationUtil.validateRentalDayCount(rentalDays);

            System.out.println("Discount percentage (entered as a value from 0-100) :");
            int discountPercent = keyboard.nextInt();
            InputValidationUtil.validateDiscountPercent(discountPercent);

            System.out.println("Rental start date (MM/dd/YYYY):");
            String rentalDateInput = keyboard.next();
            InputValidationUtil.isValidDateFormat(rentalDateInput);
            String[] splitDateAry = rentalDateInput.split("/");
            LocalDate rentalDate = LocalDate.of(Integer.parseInt(splitDateAry[2]), Integer.parseInt(splitDateAry[0]), Integer.parseInt(splitDateAry[1]));

            RentalAgreement agreement = new RentalAgreement(toolCode, rentalDate, rentalDays, discountPercent);
            agreement.printReceipt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }

}
