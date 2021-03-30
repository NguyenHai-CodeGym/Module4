package com.hai.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class User implements Validator {


    @NotEmpty
    @Size(min = 5,max = 45)
    private String firstName;
    private String lastName;
    @Min(18)
    private int age;
    private String email;

    private String phoneNumber;

    public User(){}

    public User(@NotEmpty @Size(min = 5, max = 45) String firstName, String lastName, @Min(18) int age, @Email String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        User users = (User) target;
        String number = users.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors,"phoneNumber","phoneNumber.empty");
        if (number.length()<10 || number.length()>11){
            errors.rejectValue("phoneNumber","phoneNumber.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("phoneNumber","phoneNumber.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber","phoneNumber.matches");
        }

        String email = users.getEmail();
        ValidationUtils.rejectIfEmpty(errors,"email","email.empty");
        if (!email.matches("^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$")){
            errors.rejectValue("email","email.matches");
        }
    }
}
