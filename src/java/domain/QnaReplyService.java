
package domain;

import domain.QnaReply;
import domain.QnaReplyDAO;
import domain.ReplyMyCase;
import domain.ReplyMyCaseDAO;
import java.util.ArrayList;

public class QnaReplyService {
    private QnaReplyDAO qnaReplyDataAccess;
    private QnaReply qnaReply;
    
    public QnaReplyService() {
        qnaReplyDataAccess = new QnaReplyDAO();
    }
    
    public ArrayList <QnaReply> getAllReply(int qnaNum) {
        ArrayList <QnaReply> qnaReplys = null;
        try {
            qnaReplys = qnaReplyDataAccess.getAllReply(qnaNum);
        } catch (Exception e) {
            qnaReply = null;
        }
        return qnaReplys;
    }
    
    
    public QnaReply getReply(int qnaNum) {
        qnaReply = null;
        try {
            qnaReply = qnaReplyDataAccess.getReply(qnaNum);
        } catch (Exception e) {
            qnaReply = null;
        }
        return qnaReply;
    }
    
    public void addQnaReply(int qnaNum, String userID, String content, String writeDate){
        qnaReplyDataAccess.addQnaReply(qnaNum, userID, content, writeDate);
    }
    
    public void deleteQnaReply(String userID, int qnaNum){
        qnaReplyDataAccess.deleteQnaReply(userID, qnaNum);
    }            
}
