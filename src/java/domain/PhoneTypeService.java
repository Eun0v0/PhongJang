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
public class PhoneTypeService {
    private PhoneTypeDAO phoneTypeDataAccess;
    private PhoneType phoneType;
    
    public PhoneTypeService() {
        phoneTypeDataAccess = new PhoneTypeDAO();
    }
    public ArrayList<PhoneType> getPhoneType(String CaseName) {
        ArrayList<PhoneType> phoneTypes = null;
        try {
            phoneTypes = phoneTypeDataAccess.phoneTypeRetrieve(CaseName);
        } catch (Exception e) {
            phoneTypes = null;
        }
        return phoneTypes;
    }
    public void phoneTypeInsert(String CaseName, String phoneType) {
        phoneTypeDataAccess.phoneTypeInsert(CaseName, phoneType);
    }
}
