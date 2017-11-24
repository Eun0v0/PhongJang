package domain;

import java.util.Date;

public class Payment {
    int paymentID;
    String userID;
    String caseName;
    int numbers;
    int price;
    String address;
    String phoneNumber;
    String creditCardNumber;
    String creditCardPassword;
    String status;
    String parcelNumber;
    String orderDate;
    String phoneType;
    String caseType;
    String color;
    
    public Payment(int paymentID, String userID, String caseName, int numbers, int price, String address,
                   String phoneNumber, String creditCardNumber, String creditCardPassword, String status, 
                   String parcelNumber, String orderDate, String phoneType, String caseType, String color) {
        this.paymentID = paymentID;
        this.userID = userID;
        this.caseName = caseName;
        this.numbers = numbers;
        this.price = price;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.creditCardPassword = creditCardPassword;
        this.status= status;
        this.parcelNumber=parcelNumber;
        this.orderDate = orderDate;
        this.phoneType = phoneType;
        this.caseType = caseType;
        this.color = color;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParcelNumber() {
        return parcelNumber;
    }

    public void setParcelNumber(String parcelNumber) {
        this.parcelNumber = parcelNumber;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardPassword() {
        return creditCardPassword;
    }

    public void setCreditCardPassword(String creditCardPassword) {
        this.creditCardPassword = creditCardPassword;
    }
    
    
}