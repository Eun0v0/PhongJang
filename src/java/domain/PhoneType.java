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
 * 케이스 별로 핸드폰 기종에 대한 정보를 저장하기 위한 데이터 구조
 */
public class PhoneType {
    String caseName;
    String phoneType;

    public PhoneType(String caseName, String phoneType) {
        this.caseName = caseName;
        this.phoneType = phoneType;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    
}
