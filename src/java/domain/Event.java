/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author yukih
 * 이벤트 페이지 데이터 구조
 */
public class Event {
   int eventID;
   String title;
   String image;
   String writeDate;
   String content;

    public Event(int eventID, String title, String image, String writeDate, String content) {
        this.eventID = eventID;
        this.title = title;
        this.image = image;
        this.writeDate = writeDate;
        this.content = content;
    }

   
    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(String writeDate) {
        this.writeDate = writeDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
   
   
   
}
