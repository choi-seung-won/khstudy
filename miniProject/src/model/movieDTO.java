package model;

public class movieDTO {

    private int id;
    private String name;
    private String plot;
    private String movieRate;
    private int movieRateCode;

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

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getMovieRate() {
        return movieRate;
    }

    public void setMovieRate(int movieRateCode) {
        if (movieRateCode == 1) {
            movieRate = "전체 이용가";
        } else if (movieRateCode == 2) {
            movieRate = "15세이상 이용가";
        } else if (movieRateCode == 3) {
            movieRate = "청소년 관람불가";
        }
    }

    public int getMovieRateCode() {
        return movieRateCode;
    }

    public void setMovieRateCode(int movieRateCode) {
        this.movieRateCode = movieRateCode;
        if(movieRateCode == 1) {
            movieRate = "전체이용가";
        }else if(movieRateCode == 2) {
            movieRate = "15세이상 이용가";
        }else if(movieRateCode == 3) {
            movieRate = "청소년 관람불가";
        }
    }

    public movieDTO() {

    }

    public movieDTO(movieDTO m) {
        
        this.id = m.id;
        this.movieRate = m.movieRate;
        this.name = m.name;
        this.plot = m.plot;
        this.movieRateCode = m.movieRateCode;
        
    }
    
    public boolean equals(Object o) {
        if(o instanceof movieDTO) {
            movieDTO m = (movieDTO)o;
            
            return this.id == m.id;
        }
        
        return false;
    }

}
