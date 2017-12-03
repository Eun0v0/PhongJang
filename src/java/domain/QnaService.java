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

    public ArrayList<Qna> getMyQna(String userName) {
        ArrayList<Qna> qnas = null;
        try {
            qnas = qnaDataAccess.myQna(userName);
        } catch (Exception e) {
            qnas = null;
        }
        return qnas;
    }
    public void insertQna(String userName, String passWord, String qnaTitle, String qnaContent, String s_date) {
        qnaDataAccess.qnaInsert(userName, passWord, qnaTitle, qnaContent, s_date);
    }

    public void deleteQna(int qnaNum, String password) {
        qnaDataAccess.qnaDelete(qnaNum, password);
    }
    
    public void updateQna(int qnaNum, String userName, String qnaTitle, String qnaContent) {
        qnaDataAccess.qnaUpdate(qnaNum, userName, qnaTitle, qnaContent);
    }

    public Qna getQnaInfo(int qnaNum) {
        Qna qna = null;
        try {
            qna = qnaDataAccess.getQnaInfo(qnaNum);
        } catch (Exception e) {
            qna = null;
        }
        return qna;
    }
}
