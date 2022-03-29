package model;

public class UserDTO {

    private int id;
    private String userName;
    private String userPassword;
    private String userNickname;
    private int userGrade;
    private boolean promotionWating;
    
    public boolean getPromotionWating() {
        return promotionWating;
    }

    public void setPromotionWating(boolean promotionWating) {
        this.promotionWating = promotionWating;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public int getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(int userGrade) {
        this.userGrade = userGrade;
    }

    
    public boolean equals(Object o) {
        if(o instanceof UserDTO) {
            UserDTO u = (UserDTO)o;
            return this.id == u.id;
        }
        return false;
    }
    
    public UserDTO() {
        
    }
    
    public UserDTO(UserDTO u) {
        this.id = u.id;
        this.userName = u.userName;
        this.userPassword = u.userPassword;
        this.userNickname = u.userNickname;
        this.userGrade = u.userGrade;
        this.promotionWating = u.promotionWating;
    }
    
    
}
