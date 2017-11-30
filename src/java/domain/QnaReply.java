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
public class QnaReply {
    int qnaNum;
    String userID;
    String content;
    String writeDate;

    public QnaReply(int qnaNum, String userID, String content, String writeDate) {
        this.qnaNum = qnaNum;
        this.userID = userID;
        this.content = content;
        this.writeDate = writeDate;
    }

    public int getQnaNum() {
        return qnaNum;
    }

    public void setQnaNum(int qnaNum) {
        this.qnaNum = qnaNum;
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

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }
    
    
}
