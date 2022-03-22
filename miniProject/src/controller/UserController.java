package controller;

//TODO

//회원가입,로그인

import java.util.*;
import model.UserDTO;

public class UserController {
    


    private final String OPTION_GO_BACK = "X"; // ignorecase

    private ArrayList<UserDTO> list;

    private int nextId;

    public UserController() {

        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 3; i++) {
            UserDTO u = new UserDTO();
            u.setUserName("u" + i);
            u.setUserPassword("1");
            u.setNickname("사용자" + i);
            u.setUserRateCode(i);
            add(u);
        }

    }

    public void add(UserDTO u) {

        u.setId(nextId++);
        list.add(u);

    }

    public ArrayList<UserDTO> selectAll() {

        ArrayList<UserDTO> temp = new ArrayList<>();
        for (UserDTO u : list) {

            temp.add(new UserDTO(u));
        }
        return temp;

    }

    public boolean validateUsername(String username) {

        if (username.equalsIgnoreCase(OPTION_GO_BACK)) {
            // 입력값을 x/X로받았을시 false=break
            return true;
        }
        for (UserDTO u : list) {
            if (u.getUserName().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    public UserDTO selectOne(int id) {
        for (UserDTO u : list) {
            if (u.getId() == id) {

                return new UserDTO(u);
            }

        }
        return null;
    }
    public void update(UserDTO u) {
        
        list.set(list.indexOf(u), u);
        
    }
    
    public void delete(int id) {
        
        UserDTO temp = new UserDTO();
        temp.setId(id);
        list.remove(temp);
    }
    
    public UserDTO auth(String username , String password) {
        for(UserDTO u : list) {
            if(u.getUserName().equalsIgnoreCase(username) && u.getUserPassword().equals(password)) {
                
                return new UserDTO(u);
            }
        }
        return null;
    }
    


}
