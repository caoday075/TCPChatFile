/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author SE130531
 */
public class CommonValidator {

    /**
     * This is method is used to validate View more at
     * <a herf ='google.com>click here</a>
     *
     * @param code to be validated. Must be one of: SE, IA,
     * @return true/false accordingly
     */
    private static Scanner sc = new Scanner(System.in);

    
    /*-------------------SUPPLIER-------------------*/
    public static boolean checkSupCode(String code) {
        return code.matches("[A-Z]{1,5}");
    }

    public static boolean checkName(String name) {
        return name.matches(".{5,30}");
    }

    public static boolean checkAddress(String add) {
        return add.matches(".{5,30}");
    }
    
    /*-------------------ITEM-------------------*/
    public static boolean checkItemCode(String code) {
        return code.matches("E\\d{4}");
    }
    
    public static boolean checkItemName(String name) {
        return name.matches(".{3,50}");
    }
    
    public static boolean checkItemUnit(String unit) {
        return unit.matches(".{3,30}");
    }
    
    public static boolean checkDouble(String number) {
        return number.matches("[0-9]{1,13}(\\.[0-9]*)?");
    }

}
