package controller;

//컨트롤러의 경우, 데이터베이스와 화면 사이에서 사용자가 요청한 정보를 제공하거나 아니면
//사용자가 입력한 정보를 데이터베이스에 입력하는 중간다리 역할을 맡는 클래스들이다.
import java.util.ArrayList;

import model.EmployeeDTO;

public class EmployeeController {

    // db대체 arraylist 필드
    private static ArrayList<EmployeeDTO> list;
    // 다음입력사원의 번호를 저장할 int필드
    private int nextId;

    public EmployeeController() {
        list = new ArrayList<>();
        nextId = 1;
    }

    public void insert(EmployeeDTO e) {
        e.setId(nextId++);
        list.add(e);

    }

    public ArrayList<EmployeeDTO> selectAll() {

        ArrayList<EmployeeDTO> temp = new ArrayList<>();
        for (EmployeeDTO e : list) {
            temp.add(new EmployeeDTO(e));
        }
        return temp;

    }

    public EmployeeDTO selectOne(int id) {
        for(EmployeeDTO e : list) {
            if(e.getId() == id) {
                return new EmployeeDTO(e);
            }
        }
        return null;
    }

    // 파라미터로 들어온 EmployeeDTO 객체를
    // 원본의 해당 객체와 교체하는
    // update
    public void update(EmployeeDTO e) {

        list.set(list.indexOf(e), e);
        
     /*   EmployeeDTO origin = list.get(list.indexOf(e));
        origin.setName(e.getName());
        origin.setRankCode(e.getRankCode());
        origin.setDepartment(e.getDepartment());
    */
    }

    public void delete(int id) {

        EmployeeDTO e = new EmployeeDTO();
        e.setId(id);
        list.remove(e);
    }

}
