package test;

import java.util.GregorianCalendar;
import java.util.Scanner;
import test.Customer;

public class Main {

	public static void main(String[] args) {
		MainSystem Ma = new MainSystem(); // 인스턴스 new 생성
		Ma.doIt();// 부름
	}

}

class Company { // 클래스명
	String name; // 회사 이름
	String price; //
	String desc; // 거래처
	String date; // 거래처 정보

	Company(String a, String b, String c, String d) {// 각 사원들의 정보를 담을 변수선언
		name = a;
		price = b;
		desc = c;
		date = d;
//product p = new product("노트북", 10000, "15인치 노트북", "2019/4/4 9:45:29");
	}
}

class MainSystem {// 정보관리 시스템 시작
	MainSystem() {// 인스턴스

	}

	void menu() {// 메인으로 선택할 정보 출력
		System.out.println("*************************");
		System.out.println("* 정보 관리 시스템 ver 1.0 * ");
		System.out.println("*                        ");
		System.out.println("* 1. 사원 관리 시스템           ");
		System.out.println("* 2. 부서 관리 시스템\t*");
		System.out.println("* 3. 업무 관련 시스템\t*");
		System.out.println("* 4. 거래처 관리 시스템 \t*   ");
		System.out.println("*                        ");
		System.out.println("* 5.  종료         ");
		System.out.println("*************************");
		System.out.println(" 원하는 번호를 입력 하세요.  ");
	}

	Scanner scan = new Scanner(System.in);// 어디에 들어갈것인지 스캐너로 입력받음
	GregorianCalendar gc = new GregorianCalendar();// 달력임 시,분,초
	MainSystem[] Main;// 메인시스템의 배열
	int countOfcompany; // 업체의 개수

	void doIt() { //doit으로 while and switch로 진입시작
		while (true) {
			menu();
			int input = scan.nextInt();
			switch (input) {
			case 1:
				EmployeeManagement Emp = new EmployeeManagement();
				Emp.Emplo();// 사원관리를 부르는 인스턴스
				break;
			case 2:
				Department Empl = new Department();// 부서관리
				Empl.Companyss();//부서관리를 부르는 인스턴스
				break;
			case 3:
				DutyManSystem Dut = new DutyManSystem();
				Dut.doIt();//업무 관련 인스턴스
				break;
			case 4:
				CustomerManager Cus = new CustomerManager();
				Cus.doItCustomer();//거래처 관리시스템 인스턴스 
				// 업무 관리
			case 5:
				System.out.println("이용해 주셔서 감사합니다.");
				System.exit(0);//종료 
			}
		}
	}
}