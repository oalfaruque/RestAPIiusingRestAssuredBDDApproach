package restapitest;

import org.apache.commons.lang3.RandomStringUtils;

//This class is created to generate auto credentials for frequent uses.
public class RestUtilities {
    public static String generateFirstName(){
        String generatedFirstName = RandomStringUtils.randomAlphabetic(4);
        return ("Mike"+generatedFirstName);
    }
    public static String generateLastName(){
        String generatedLastName = RandomStringUtils.randomAlphabetic(6);
        return ("Miller"+generatedLastName);
    }
    public static String generateUserName(){
        String generatedUserName = RandomStringUtils.randomAlphanumeric(5);
        return ("username"+generatedUserName);
    }
    public static String generatePassword(){
        String generatedPassword = RandomStringUtils.randomAlphanumeric(5);
        return generatedPassword;
    }
    public static String generateEmaiId(){
        String generatedEmailID = RandomStringUtils.randomAlphanumeric(6);
        return (generatedEmailID+"@gmail.com");
    }
    public static String generateEmpName(){
        String generatedEmpName = RandomStringUtils.randomAlphabetic(6);
        return generatedEmpName;
    }
    public static String generatedEmpAge(){
        String generatedEmpAge = RandomStringUtils.randomNumeric(2);
        return generatedEmpAge;
    }
    public static String generateEmpSalary(){
        String generatedEmpSalary = RandomStringUtils.randomNumeric(5);
        return generatedEmpSalary;
    }
}
