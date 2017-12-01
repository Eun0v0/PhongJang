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
 * 케이스 데이터 구조
 */
public class PhoneCase {
    
    int caseID;
    String caseName;
    String caseType;
    String explanation;
    int price;
    String img;
    String detailImg;
    int stock;

    public PhoneCase(int caseID, String caseName, String caseType, String explanation, int price, String img, String detailImg, int stock) {

        this.caseID = caseID;
        this.caseName = caseName;
        this.caseType = caseType;
        this.explanation = explanation;
        this.price = price;
        this.img = img;
        this.detailImg = detailImg;
        this.stock = stock;
        
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}