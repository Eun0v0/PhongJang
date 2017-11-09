/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

public class PhoneCaseService {
    
    private PhoneCaseDAO phoneCaseDataAccess;
    
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
    
    public ArrayList<PhoneCase> getPhoneCase(String caseName) {
        ArrayList<PhoneCase> phoneCases = null;
        try {
            phoneCases = phoneCaseDataAccess.phoneCaseRetrieve(caseName);
        } catch (Exception e) {
            phoneCases = null;
        }
        return phoneCases;
    }
    
    public void insertPhoneCase(String caseType, String caseName, String explanation, int price) {
        phoneCaseDataAccess.productInsert(caseType, caseName, explanation, price);
    }
    
    public void updatePhoneCase(int caseID, String caseType, String caseName, String explanation, int price) {
        phoneCaseDataAccess.productUpdate(caseID, caseType, caseName, explanation, price);
    }
}