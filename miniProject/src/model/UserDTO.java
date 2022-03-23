package model;

public class UserDTO {

    
    private int id;
    private String userName;
    private String userPassword;
    private String nickname;
    
    
    private String userRate;
    private int userRateCode;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    

    public String getUserRate() {
        return userRate;
    }

    public void setUserRate(String userRate) {
        this.userRate = userRate;

    }

    public int getUserRateCode() {
        return userRateCode;
    }
    
    public void setUserRateCode(int userRateCode) {
        if(userRateCode == 1) {
            userRate = "일반관람객";
        }else if(userRateCode == 2) {
            userRate = "전문평론가";
        }else if(userRateCode == 3) {
            userRate = "관리자";
        }
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
        
        id = u.id;
        nickname = u.nickname;
        userName = u.userName;
        userPassword = u.userPassword;
        userRate = u.userRate;
        userRateCode = u.userRateCode;
        
    }

    

}
