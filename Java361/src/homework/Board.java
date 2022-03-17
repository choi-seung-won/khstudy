package homework;

import util.ScannerUtil;

public class Board {
    
    
    
    private int id;
    private String title;
    private String writer;
    private String content;

    
    // getter setter 메소드생성
    
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
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getWriter() {
        return writer;
    }
    public void setWriter(String writer) {
        this.writer = writer;
    }
    
    // 2. equals()
    public boolean equals(Object o) {
        
        if(o instanceof Board) {
            Board b = (Board)o;
            return this.id == b.id;
            
        }
        return false;
    }
    
    // 3. printBoard()
    public void printBoard() {
        System.out.println("\n========================");
        System.out.println(title);
        System.out.println("--------------------------");
        System.out.println("작성자: "+ writer);
        System.out.println("--------------------------");
        System.out.println("내용");
        System.out.println("--------------------------");
        System.out.println(content);
        System.out.println("\n========================");
        
    }
    
    
}
