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
 * 리뷰 작성을 위한 데이터 구조
 */
public class Review {
    int replyNum;
    int caseID;
    String userID;
    String content;
    String grade;
    String writeDate;

    public Review(int replyNum, int caseID, String userID, String content, String grade, String writeDate) {
        this.replyNum = replyNum;
        this.caseID = caseID;
        this.userID = userID;
        this.content = content;
        this.grade = grade;
        this.writeDate = writeDate;
    }

    public int getCaseID() {
        return caseID;
    }

    public void setCaseID(int caseID) {
        this.caseID = caseID;
    }
        
    public int getReplyNum() {
        return replyNum;
    }

    public void setReplyNum(int replyNum) {
        this.replyNum = replyNum;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
    
    
}
