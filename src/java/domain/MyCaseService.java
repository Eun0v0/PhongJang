/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author yukih
 */
public class MyCaseService {
    private MyCaseDAO myCaseDataAccess;
    private MyCase myCase;
    
    public MyCaseService() {
        myCaseDataAccess = new MyCaseDAO();
    }
    
    public ArrayList<MyCase> getAllMyCases(String userID) {
        ArrayList<MyCase> myCases = null;
        try {
            myCases = myCaseDataAccess.myCaseRetrieve(userID);
        } catch (Exception e) {
            myCases = null;
        }
        return myCases;
    }
    
    public void addMyCase(String userID, String title, String caseType, String phoneType,
            String color, String content, String image, String writeDate) {
        myCaseDataAccess.addMyCase(userID, title, caseType, phoneType, color, content, image, writeDate);
    }
    
    public void myCaseUpdate(int myCaseNum, String title, String caseType, String phoneType,
            String color, String content, String image){
        myCaseDataAccess.myCaseUpdate(myCaseNum, title, caseType, phoneType, color, content, image);
    }
    
    public MyCase getMyCase(int myCaseNum){
        MyCase myCase = null;
        try {
            myCase = myCaseDataAccess.getMyCase(myCaseNum);
        } catch (Exception e) {
            myCase = null;
        }
        return myCase;
    }
    public void deleteMyCase(String userID, int myCaseNum){
         myCaseDataAccess.deleteMyCase(userID, myCaseNum);
    }
            
}
