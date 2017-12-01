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
 * 마이 케이스 글에 대해 답변을 달기 위한 데이터 구조
 */
public class ReplyMyCase {
    int myCaseNum;
    String account;
    String image;
    String dueDate;
    String content;
    String status;
    int price;

    public ReplyMyCase(int myCaseNum, String account, String image, String dueDate, String content, String status, int price) {
        this.myCaseNum = myCaseNum;
        this.account = account;
        this.image = image;
        this.dueDate = dueDate;
        this.content = content;
        this.status = status;
        this.price= price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    public int getMyCaseNum() {
        return myCaseNum;
    }

    public void setMyCaseNum(int myCaseNum) {
        this.myCaseNum = myCaseNum;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
