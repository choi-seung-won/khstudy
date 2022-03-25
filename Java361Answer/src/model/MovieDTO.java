package model;

public class MovieDTO {

    private int id;
    private String title;
    private String summary;
    private int grade;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public boolean equals(Object o) {
        if(o instanceof MovieDTO) {
            MovieDTO m = (MovieDTO)o;
            
            return this.id == m.id;
        }
        
        return false;
    }

    public MovieDTO() {

    }

    public MovieDTO(MovieDTO m) {
        
        this.id = m.id;
        title = m.title;
        summary = m.summary;
        grade = m.grade;
        
    }
    

}
