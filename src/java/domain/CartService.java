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
public class CartService {
    private CartDAO cartDataAccess;
    public CartService(){
        cartDataAccess = new CartDAO();
    }
    public ArrayList<Cart> getCart(String userID){
        ArrayList<Cart> carts = null;
        try{
            carts = cartDataAccess.cartRetrieve(userID);
        } catch (Exception e){
            carts = null;
        }
        return carts;
    }
    public void addToCart(String userID, String caseName, String color, int numbers, int price){
        cartDataAccess.addToCart(userID, caseName, color, numbers, price);
    }
    public void deleteFromCart(String userID, int caseID){
        cartDataAccess.deleteFromCart(userID, caseID);
    }
    /*public void cleanCart(String userID){
        cartDataAccess.cleanCart(userID);
    }*/
}
