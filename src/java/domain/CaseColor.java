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
 * 케이스 색상(종류) 데이터 구조
 */
public class CaseColor {
    String CaseName;
    String CaseColor;
    int stock;

    public CaseColor(String CaseName, String CaseColor, int stock) {
        this.CaseName = CaseName;
        this.CaseColor = CaseColor;
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
