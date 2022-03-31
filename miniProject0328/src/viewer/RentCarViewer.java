package viewer;

import java.util.Scanner;

import controller.RentCarController;

import java.util.ArrayList;

import model.UserDTO;
import model.rentCarDTO;
import util.ScannerUtil;

public class RentCarViewer {
    public void setUserViewer(UserViewer userViewer) {
        this.userViewer = userViewer;
    }

    public void setTicketViewer(TicketViewer ticketViewer) {
        this.ticketViewer = ticketViewer;
    }

    public void setTicketingLogViewer(TicketingLogViewer ticketingLogViewer) {
        this.ticketingLogViewer = ticketingLogViewer;
    }

    public void setRentCarLogViewer(RentCarLogViewer rentCarLogViewer) {
        this.rentCarLogViewer = rentCarLogViewer;
    }

    public void setHotelViewer(HotelViewer hotelViewer) {
        this.hotelViewer = hotelViewer;
    }

    public void setHotelRoomViewer(HotelRoomViewer hotelRoomViewer) {
        this.hotelRoomViewer = hotelRoomViewer;
    }

    public void setBookingLogViewer(BookingLogViewer bookingLogViewer) {
        this.bookingLogViewer = bookingLogViewer;
    }

    private Scanner scanner;
    private UserViewer userViewer;
    private TicketViewer ticketViewer;
    private TicketingLogViewer ticketingLogViewer;
    private RentCarLogViewer rentCarLogViewer;
    private HotelViewer hotelViewer;
    private HotelRoomViewer hotelRoomViewer;
    private BookingLogViewer bookingLogViewer;

    private UserDTO logIn;
    private rentCarDTO rentCarDTO;
    private RentCarController rentCarController;

    public void setLogIn(UserDTO logIn) {
        this.logIn = logIn;
    }

    public void setScanner(Scanner scanner) {

        this.scanner = scanner;

    }

    public void showMainMenu() {
        String message = "1. 렌터카 목록 보기 2. 렌터카 예약기록 보기 3. 뒤로 가기";
        int userChoice = ScannerUtil.nextInt(scanner, message, 1, 4);
        if (userChoice == 1) {
            showCarList();
        } else if (userChoice == 2) {
            // rentCarLogViewer.showmenu();
        } else {

        }

    }

    private void showCarList() {

        String message = "";
        int userChoice;
        if (logIn.getUserGrade() != 3) {
            message = "1. 2. 3";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 3);
            if (userChoice == 1) {
                printList();
            } else if (userChoice == 2) {
                addNewCar();
            }
        } else {
            printList();
        }

    }

    private void printList() {
        ArrayList<rentCarDTO> list = rentCarController.filterByReserved();
        if (list.isEmpty()) {
            System.out.println("렌터카가 없습니다.");
        } else if (logIn.getUserGrade() == 3) {
            list = rentCarController.selectAll();
            for (rentCarDTO r : list) {
                System.out.printf("고유번호: %d , 차 번호: %d , 차 색상: %s , 차 기종: %s", r.getId(), r.getCarId(), r.getColor(),
                        r.getType());
            }
        } else {
            for (rentCarDTO r : list) {
                System.out.printf("고유번호: %d , 차 번호: %d , 차 색상: %s , 차 기종: %s", r.getId(), r.getCarId(), r.getColor(),
                        r.getType());
            }
        }
        
        String message = "상세보기할 차량의 번호 또는 뒤로가시려면 0을 입력해주세요.";
        int userChoice = ScannerUtil.nextInt(scanner, message);
        while(userChoice != 0 && rentCarController.selectOne(userChoice) == null) {
            System.out.println("잘못 입력하셨습니다.");
            userChoice = ScannerUtil.nextInt(scanner, message);
        }
        if(logIn.getUserGrade() == 1 && rentCarController.filterByReserved(userChoice) == true) {
            System.out.println("이미 예약된 항목입니다.");
        }else if(userChoice != 0) {
            printOne(userChoice);
        }
    }
    
    private void printOne(int id) {
        rentCarDTO r = rentCarController.selectOne(id);
        System.out.printf("고유번호: %d , 차 번호: %d , 차 색상: %s , 차 기종: %s", r.getId(), r.getCarId(), r.getColor(),
                r.getType());
        String message = "";
        int userChoice = 0;
        if(logIn.getUserGrade() == 3) {
            message = "1. 해당 렌터카 정보 수정 2. 해당 렌터카 삭제 3. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message,1,3);
            updateAndDelete(userChoice,id);
        }else if(logIn.getUserGrade() == 2) {
            message = "1. 해당 렌터카 정보 수정 2. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
            updateAndDelete(userChoice,id);
        }else if(logIn.getUserGrade() == 1 && r.getReserved() == false) {
            message = "1. 해당 렌터카 예약 2. 뒤로 가기";
            userChoice = ScannerUtil.nextInt(scanner, message, 1, 2);
            if(userChoice == 1) {
                if(r.getReserved() == true) {
                    System.out.println("에러처리필요");
                }else {
                    r.setReserved(true);
                    r.setReservedUserId(logIn.getId());
                    rentCarController.update(r);
                    //logViewer.updatefromviewer
                    System.out.println("예약이 완료되었습니다.");
                }
            }
        }
    }
    
    private void updateCarInfo(int id) {
        rentCarDTO r = rentCarController.selectOne(id);
        
        String message = "차량번호판넘버 입력.";
        r.setCarId(ScannerUtil.nextInt(scanner, message));
        message = "차량 색상 입력.";
        r.setColor(ScannerUtil.nextLine(scanner, message));
        message = "차량 기종 입력.";
        r.setType(ScannerUtil.nextLine(scanner, message));
        
        rentCarController.add(r);
        
    }
    
    private void deleteCarInfo(int id) {
        String message = "정말로 삭제하시겠습니까? Y/N";
        String yesNo = ScannerUtil.nextLine(scanner, message);

        if (yesNo.equalsIgnoreCase("Y")) {
            rentCarController.delete(id);
            printList();
        }else {
            printOne(id);
        }
    }
    
    private void updateAndDelete(int userChoice, int carId) {
        if(userChoice == 1) {
            updateCarInfo(carId);
        }else if(userChoice == 2 && logIn.getUserGrade() == 3) {
            deleteCarInfo(carId);
        }
        
    }
    
    private void addNewCar() {
        rentCarDTO r = new rentCarDTO();
        
        String message = "차량번호판넘버 입력.";
        r.setCarId(ScannerUtil.nextInt(scanner, message));
        message = "차량 색상 입력.";
        r.setColor(ScannerUtil.nextLine(scanner, message));
        message = "차량 기종 입력.";
        r.setType(ScannerUtil.nextLine(scanner, message));
        
        rentCarController.add(r);
        
    }
}
