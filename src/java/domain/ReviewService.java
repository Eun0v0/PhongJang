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
public class ReviewService {
    private ReviewDAO reviewDataAccess;
    private Review review;
    
    public ReviewService() {
        reviewDataAccess = new ReviewDAO();
    }
    
    public ArrayList<Review> reviewRetrieve(int caseID){
        ArrayList<Review> reviews = null;
        try {
            reviews = reviewDataAccess.reviewRetrieve(caseID);
        } catch (Exception e) {
            reviews = null;
        }
        return reviews;
    }
    
    public void addReview(int caseID, String userID, String content, String grade, String writeDate){
        reviewDataAccess.addReview(caseID, userID, content, grade, writeDate);
    }
    
    public void deleteReview(String userID, int replyNum, int caseID){
        reviewDataAccess.deleteReview(userID, replyNum, caseID);
    }
}
