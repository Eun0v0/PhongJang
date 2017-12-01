/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author yukih
 * 
 * 나만의 케이스 만들기 데이터 구조
 */
public class MyCase {
    int myCaseNum;
    String userID;
    String title;
    String caseType;
    String phoneType;
    String color;
    String content;
    String image;
    String writeDate;

    public MyCase(int myCaseNum, String userID, String title, String caseType, String phoneType,
            String color, String content, String image, String writeDate) {
        this.myCaseNum = myCaseNum;
        this.userID = userID;
        this.title = title;
        this.caseType = caseType;
        this.phoneType = phoneType;
        this.color = color;
        this.content = content;
        this.image = image;
        this.writeDate = writeDate;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    

    public int getMyCaseNum() {
        return myCaseNum;
    }

    public void setMyCaseNum(int myCaseNum) {
        this.myCaseNum = myCaseNum;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
    
    
}
