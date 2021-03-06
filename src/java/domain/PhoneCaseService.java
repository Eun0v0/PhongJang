/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

public class PhoneCaseService {
    
    private PhoneCaseDAO phoneCaseDataAccess;
    private PhoneCase phoneCase;
    
    public PhoneCaseService() {
        phoneCaseDataAccess = new PhoneCaseDAO();
    }
    
    public ArrayList<PhoneCase> getAllPhoneCase() {
        ArrayList<PhoneCase> phoneCases = null;
        try {
            phoneCases = phoneCaseDataAccess.allPhoneCaseRetrieve();
        } catch (Exception e) {
            phoneCases = null;
        }
        return phoneCases;
    }
    public ArrayList<PhoneCase> popPhoneCaseRetrieve() {
        ArrayList<PhoneCase> phoneCases = null;
        try {
            phoneCases = phoneCaseDataAccess.popPhoneCaseRetrieve();
        } catch (Exception e) {
            phoneCases = null;
        }
        return phoneCases;
    }
    
    public ArrayList<PhoneCase> getPhoneCase(String caseName) {
        ArrayList<PhoneCase> phoneCases = null;
        try {
            phoneCases = phoneCaseDataAccess.phoneCaseRetrieve(caseName);
        } catch (Exception e) {
            phoneCases = null;
        }
        return phoneCases;
    }

    public void insertPhoneCase(String caseType, String caseName, String explanation, int price, String img, String detailImg, int stock) {
        phoneCaseDataAccess.productInsert(caseType, caseName, explanation, price, img, detailImg, stock);
    }
    
    //(int caseID, String caseType, String caseName, String explanation, int price)
    public void updatePhoneCase(int caseID, String caseType, String caseName, String explanation, int price, String img, String detailImg) {
        phoneCaseDataAccess.productUpdate(caseID, caseType, caseName, explanation, price, img, detailImg);
    }
    
    public void deletePhoneCase(int caseID) {
        phoneCaseDataAccess.productDelete(caseID);
    }
    
    public PhoneCase getPhoneCase(int caseID) {
        phoneCase = phoneCaseDataAccess.productGet(caseID);
        return phoneCase;
    }
    public ArrayList<PhoneCase> getPhoneCaseType(String caseType) {
        ArrayList<PhoneCase> phoneCases = null;
        try {
            phoneCases = phoneCaseDataAccess.phoneCaseTypeRetrieve(caseType);
        } catch (Exception e) {
            phoneCases = null;
        }
        return phoneCases;
    }
    public void stockChange(int caseID, int stock){
        phoneCaseDataAccess.stockChange(caseID, stock);
    }
    
    public int getCaseID(String caseName) {
        int caseID = 0;
        try {
            caseID = phoneCaseDataAccess.getCaseID(caseName);
        } catch (Exception e) {
            caseID = 0;
        }
        return caseID;
    }
}