package model;

public class UserDTO {

    private int id;
    private String username;
    private String userpassword;
    private String nickname;
    private int category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return userpassword;
    }

    public void setPassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean equals(Object o) {
        if (o instanceof UserDTO) {
            UserDTO u = (UserDTO) o;
            return this.id == u.id;
        }
        return false;
    }

    public UserDTO() {

    }

    public UserDTO(UserDTO u) {

        id = u.id;
        nickname = u.nickname;
        username = u.username;
        userpassword = u.userpassword;
        category = u.category;

    }

}
