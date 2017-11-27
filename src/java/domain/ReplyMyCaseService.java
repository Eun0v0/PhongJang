/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 *
 * @author yukih
 */
public class ReplyMyCaseService {
    private ReplyMyCaseDAO replyMyCaseDataAccess;
    private ReplyMyCase replyMyCase;
    
    public ReplyMyCaseService() {
        replyMyCaseDataAccess = new ReplyMyCaseDAO();
    }
    
    public ArrayList<ReplyMyCase> myCaseReplyRetrieve() {
        ArrayList<ReplyMyCase> replyMyCases = null;
        try {
            replyMyCases = replyMyCaseDataAccess.myCaseReplyRetrieve();
        } catch (Exception e) {
            replyMyCases = null;
        }
        return replyMyCases;
    }
    
    public ReplyMyCase getMyCase(int myCaseNum) {
        ReplyMyCase replyMyCase = null;
        try {
            replyMyCase = replyMyCaseDataAccess.getMyCase(myCaseNum);
        } catch (Exception e) {
            replyMyCase = null;
        }
        return replyMyCase;
    }
    
    public void addMyCaseReply(int myCaseNum, String account, String image, String dueDate, String content, String status, int price){
            replyMyCaseDataAccess.addMyCaseReply(myCaseNum, account, image, dueDate, content, status, price);
    }
    
    public void myCaseReplyUpdate(int myCaseNum, String status){
        replyMyCaseDataAccess.myCaseReplyUpdate(myCaseNum, status);
    }            
}
