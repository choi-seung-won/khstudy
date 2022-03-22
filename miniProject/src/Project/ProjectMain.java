package Project;
/*
 * 1. 개요: 영화 관리 프로그램
  해당 프로그램은 영화를 관리하는 프로그램으로써
  어느 영화의 정보, 평점, 상영 극장, 상영 시간 등의 정보를 관리하는 프로그램
 
2. 클래스 설명
  A. 회원
     사용자에는
     회원 번호, 아이디, 비밀번호, 닉네임, 등급이 존재한다.
     등급의 경우, 일반 관람객, 전문 평론가, 관리자로 나뉘며
     int 값을 통해 각 등급이 결정된다.
     일반 관람객 혹은 전문 평론가, 관리자 모두 똑같은 User 클래스로
     아이디와 비밀번호를 만들게 된다.
  B. 영화
     영화에는
     영화 번호, 영화 제목, 영화 줄거리, 영화 등급이 존재합니다.
  C. 평점
     평점에는
     평점 번호, 작성 회원 번호, 영화 번호, 평점, 평론이 존재합니다.
  D. 극장
     극장에는
     극장 번호, 극장 이름, 극장 위치, 극장 전화번호가 존재합니다.
  E. 상영정보
     상영정보에는
     상영정보 번호, 영화 번호, 극장 번호, 상영 시간이 존재합니다.
​
3. 기능 설명
  A. 회원가입
  B. 로그인
  C. 영화 목록 보기
  D. 영화 개별 보기
  E. 영화별 전체 평점 보기
  F. 영화별 평론가 평점 보기
  G. 영화별 일반 관람객 평점 보기
  H. (관리자 전용) 새로운 영화 등록하기
  I. (관리자 전용) 기존 영화 정보 수정하기
  J. (관리자 전용) 기존 영화 정보 삭제하기
  K. 극장 목록 보기
  L. 극장 개별 보기
  M. 해당 극장 상영중인 영화 목록 보기
  N. (관리자 전용) 새로운 극장 등록하기
  O. (관리자 전용) 기존 극장 정보 수정하기
  P. (관리자 전용) 기존 극장 정보 삭제하기
  Q. (관리자 전용) 새로운 상영정보 등록하기
  R. (관리자 전용) 기존 상영정보 수정하기
  S. (관리자 전용) 기존 상영정보 삭제하기
​
위의 기능이 "필수적"으로 포함이 되고 여러분들이 직접 부수적인 기능이 추가 되어 있는 프로그램을 만드시오.
​
목요일 22시까지 패키지를 압축하여 chojeyungbit@gmail.com 으로 보내주시면 됩니다.
​
점수 기준표
100: 모든 기능이 정확히 돌아감
60: 흐름도를 강사가 보고 이해함
0: 안됨
 * 
 */

import viewer.UserViewer;

public class ProjectMain {
    public static void main(String[] args) {

        UserViewer userViewer = new UserViewer();
        userViewer.showIndex();

    }
}
