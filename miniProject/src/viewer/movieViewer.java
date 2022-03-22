package viewer;

import java.util.Scanner;

import model.UserDTO;
import viewer.UserViewer;

public class movieViewer {
    
    private Scanner scanner;
    private UserDTO userDTO;
    private UserViewer userViewer;
    
    public void setUserViewer(UserViewer userViewer) {
        
        this.userViewer = userViewer;
        
    }
    
    
    public movieViewer() {
        
        
    }

}
