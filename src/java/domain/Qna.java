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
 * 질문 게시판 데이터 구조
 */
public class Qna {
    int qnaNum;
    String userName;
    String passWord;
    String qnaTitle;
    String qnaContent;
    String qnaTime;

    public Qna(int qnaNum, String userName, String passWord, String qnaTitle, String qnaContent, String qnaTime) {
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
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