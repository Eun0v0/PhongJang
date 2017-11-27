/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author yukih
 */
public class CaseColor {
    String CaseName;
    String CaseColor;

    public CaseColor(String CaseName, String CaseColor) {
        this.CaseName = CaseName;
        this.CaseColor = CaseColor;
    }

    public String getCaseName() {
        return CaseName;
    }

    public void setCaseName(String CaseName) {
        this.CaseName = CaseName;
    }

    public String getCaseColor() {
        return CaseColor;
    }

    public void setCaseColor(String CaseColor) {
        this.CaseColor = CaseColor;
    }
}
