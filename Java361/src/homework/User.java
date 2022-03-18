package homework;

public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;

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
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    public boolean equals(Object o){
        if(o instanceof User) {
            User u = (User)o;
            return id == u.id;
        }
        return false;
    }
    
    public void printInfo() {
        System.out.println("\n------------------------------");
        System.out.println(nickname + "회원님의 정보");
        System.out.println("\n------------------------------");
        System.out.printf("회원 번호 : %d\n", id);
        System.out.printf("회원 유저네임 : %s\n", username);
        System.out.printf("회원 닉네임: %s\n",nickname);
        System.out.println("-------------------------------\n");
    }

}
