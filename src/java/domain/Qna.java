/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

public class Qna {
    int qnaNum;
    String userName;
    int passWord;
    String qnaTitle;
    String qnaContent;
    String qnaTime;

    public Qna(int qnaNum, String userName, int passWord, String qnaTitle, String qnaContent, String qnaTime) {
        this.qnaNum = qnaNum;
        this.userName = userName;
        this.passWord = passWord;
        this.qnaTitle = qnaTitle;
        this.qnaContent = qnaContent;
        this.qnaTime = qnaTime;
    }

    public int getQnaNum() {
        return qnaNum;
    }

    public void setQnaNum(int qnaNum) {
        this.qnaNum = qnaNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassWord() {
        return passWord;
    }

    public void setPassWord(int passWord) {
        this.passWord = passWord;
    }

    public String getQnaTitle() {
        return qnaTitle;
    }

    public void setQnaTitle(String qnaTitle) {
        this.qnaTitle = qnaTitle;
    }

    public String getQnaContent() {
        return qnaContent;
    }

    public void setQnaContent(String qnaContent) {
        this.qnaContent = qnaContent;
    }

    public String getQnaTime() {
        return qnaTime;
    }

    public void setQnaTime(String qnaTime) {
        this.qnaTime = qnaTime;
    }
}