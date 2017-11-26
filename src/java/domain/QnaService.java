/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

public class QnaService {

    private QnaDAO qnaDataAccess;

    public QnaService() {
        qnaDataAccess = new QnaDAO();
    }

    public ArrayList<Qna> getAllQna() {
        ArrayList<Qna> qnas = null;
        try {
            qnas = qnaDataAccess.allQnaRetrieve();
        } catch (Exception e) {
            qnas = null;
        }
        return qnas;
    }

    public ArrayList<Qna> getQna(int qnaNum) {
        ArrayList<Qna> qnas = null;
        try {
            qnas = qnaDataAccess.qnaRetrieve(qnaNum);
        } catch (Exception e) {
            qnas = null;
        }
        return qnas;
    }

    public void insertQna(String userName, String passWord, String qnaTitle, String qnaContent, String s_date) {
        qnaDataAccess.qnaInsert(userName, passWord, qnaTitle, qnaContent, s_date);
    }

    public void deleteQna(int qnaNum) {
        qnaDataAccess.qnaDelete(qnaNum);
    }
    
    public void updateQna(String userName, String passWord, String qnaTitle, String qnaContent, String s_date) {
        qnaDataAccess.qnaUpdate(userName, passWord, qnaTitle, qnaContent, s_date);
    }
}
