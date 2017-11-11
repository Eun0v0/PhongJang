package domain;
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

    public Payment(int paymentID, String userID, String caseName, int numbers, int price, String address, String phoneNumber, String creditCardNumber, String creditCardPassword) {
        this.paymentID = paymentID;
        this.userID = userID;
        this.caseName = caseName;
        this.numbers = numbers;
        this.price = price;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.creditCardNumber = creditCardNumber;
        this.creditCardPassword = creditCardPassword;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
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