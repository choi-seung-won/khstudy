package model;

public class EmployeeDTO {

    
    private int id;
    // 이름
    private String name;
    // 부서
    private String department;
    // 부서코드
    private int departmentCode;
    // 직급코드
    private int rankCode;
    // 연봉
    private int salary;
    
    
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(int departmentCode) {
        
        if (departmentCode == 1) {
            department = "총무";
        } else if (departmentCode == 2) {
            department = "개발";
        } else if (departmentCode == 3) {
            department = "영업";
        }
        
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    
    
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    
    public int getRankCode() {
        return rankCode;
    }
    public void setRankCode(int rankCode) {
        this.rankCode = rankCode;
    }
    

    public boolean equals(Object o) {
        if(o instanceof EmployeeDTO) {
            EmployeeDTO e = (EmployeeDTO)o;
            
            return this.id == e.id;
        }
        
        return false;
    }
    public int getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(int departmentCode) {
        this.departmentCode = departmentCode;
    }
    
    
    public EmployeeDTO() {
        
    }
    
    public EmployeeDTO(EmployeeDTO e){
        this.id = e.id;
        this.name = e.name;
        this.departmentCode = e.departmentCode;
        this.rankCode = e.rankCode;
        this.salary = e.salary;
        
        
    }
}
