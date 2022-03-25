package controller;

import java.util.*;
import model.UserDTO;

public class UserController {
    private ArrayList<UserDTO> list;
    private int nextId;

    private final String KEYWORD_BACK = "X";

    public UserController() {
        list = new ArrayList<>();
        nextId = 1;

        for (int i = 1; i <= 4; i++) {
            UserDTO u = new UserDTO();
            u.setUsername("u" + i);
            u.setPassword("1");
            u.setNickname("사용자" + i);
            u.setCategory(i % 3 + 1); // 2, 3 , 1
            add(u);
        }

    }

    public void add(UserDTO u) {
        u.setId(nextId++);
        list.add(u);
    }

    public boolean validateUsername(String username) {
        if (username.equalsIgnoreCase(KEYWORD_BACK)) {
            return true;
        }

        for (UserDTO u : list) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }

        return false;
    }

    public UserDTO auth(String username, String password) {
        for (UserDTO u : list) {
            if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equals(password)) {
                return new UserDTO(u);
            }
        }
        return null;
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
        int index = list.indexOf(u); 
        list.set(index,u); //list.set(list.indexOf(u), u);
    }
    
    public void delete(int id) {
        UserDTO u = new UserDTO();
        u.setId(id);
        list.remove(u);
    }

    public ArrayList<UserDTO> selectAll() {

        ArrayList<UserDTO> temp = new ArrayList<>();
        for (UserDTO u : list) {

            temp.add(new UserDTO(u));
        }
        return temp;

    }




}
