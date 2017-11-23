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
public class CaseColorService {
    private CaseColorDAO caseColorDataAccess;
    private CaseColor caseColor;
    
    public CaseColorService() {
        caseColorDataAccess = new CaseColorDAO();
    }
    public ArrayList<CaseColor> getCaseColor(String CaseName) {
        ArrayList<CaseColor> caseColors = null;
        try {
            caseColors = caseColorDataAccess.caseColorRetrieve(CaseName);
        } catch (Exception e) {
            caseColors = null;
        }
        return caseColors;
    }
    public void caseColorInsert(String CaseName, String caseColor) {
        caseColorDataAccess.caseColorInsert(CaseName, caseColor);
    }
}
