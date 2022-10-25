package controller;

import controller.util.InputValidationUtil;
import model.RentalAgreement;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        String toolCode = "";
        int rentalDays = 0;
        int discountPercent = -1;
        LocalDate rentalDate = null;

        while (true){
            try {
                System.out.println("Enter Code for tool to be rented:");
                toolCode = keyboard.next();
                InputValidationUtil.validateToolCode(toolCode);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true){
            try {
                System.out.println("Number of days tool will be rented (must be at least 1 day):");
                rentalDays = keyboard.nextInt();
                InputValidationUtil.validateRentalDayCount(rentalDays);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true){
            try {
                System.out.println("Discount percentage (entered as a value from 0-100) :");
                discountPercent = keyboard.nextInt();
                InputValidationUtil.validateDiscountPercent(discountPercent);
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        while (true){
            try {
                System.out.println("Rental start date (MM/dd/YYYY):");
                String rentalDateInput = keyboard.next();
                InputValidationUtil.isValidDateFormat(rentalDateInput);
                String[] splitDateAry = rentalDateInput.split("/");
                rentalDate = LocalDate.of(Integer.parseInt(splitDateAry[2]), Integer.parseInt(splitDateAry[0]), Integer.parseInt(splitDateAry[1]));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            RentalAgreement agreement = new RentalAgreement(toolCode, rentalDate, rentalDays, discountPercent);
            agreement.printReceipt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
