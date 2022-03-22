package model;

import java.util.Calendar;

public class CommentDTO {
    
    private int id;
    private String comment;
    private Calendar commentDate;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getcomment() {
        return comment;
    }
    public void setcomment(String comment) {
        comment = comment;
    }
    public Calendar getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(Calendar commentDate) {
        this.commentDate = commentDate;
    }
    
    public CommentDTO() {
        
        
    }
    
    public CommentDTO(CommentDTO c) {
        id = c.id;
        comment = c.comment;
        commentDate = Calendar.getInstance();
        commentDate.setTime(c.commentDate.getTime());
        
    }
    
    public boolean equals(Object o) {
        if(o instanceof CommentDTO) {
            CommentDTO c = (CommentDTO)o;
            return id == c.id;
        }
        return false;
    }

}
