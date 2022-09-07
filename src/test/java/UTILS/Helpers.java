package UTILS;



import com.github.javafaker.Faker;

import java.security.SecureRandom;

public class Helpers {



    public String randomStr(int strLenght) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(strLenght);
        for (int i = 0; i < strLenght; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public String randomEmail(int strLength) {
        String email;
        String AB = "abcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(strLength);
        for (int i = 0; i < strLength; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        email = sb.toString().concat("@gmail.com");
        System.out.println(email);
        return email;

    }

    public String randomFirstName() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        System.out.println(firstName);
        return firstName;
    }
    public String randomLastName() {
        Faker faker = new Faker();
        String lastName = faker.name().lastName();
        System.out.println(lastName);
        return lastName;

    }

    public String randomAddress() {
        Faker faker = new Faker();
        String streetAddress = faker.address().streetAddress();
        System.out.println(streetAddress);
        return  streetAddress;

    }

    public String randomCompany(int strLenght) {
        String company;
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(strLenght);
        for (int i = 0; i < strLenght; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        company = sb.toString().concat(" Company LTD");
        System.out.println(company);
        return company;
    }

    public String randomNumber(int strLenght) {
        String phoneNumber;
        String AB = "1234567890";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(strLenght);
        for (int i = 0; i < strLenght; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        phoneNumber = sb.toString();
        System.out.println(phoneNumber);
        return phoneNumber;

    }





}
