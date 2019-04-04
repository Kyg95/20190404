package test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Department {
	Department() {
	}

	public void menu() {
		System.out.println("*************************");
		System.out.println("* 부서 관리 시스템 ver 1.0 * ");
		System.out.println("*                        ");
		System.out.println("* 1. 부서 등록           ");
		System.out.println("* 2. 부서 조회\t*");
		System.out.println("* 3. 부서 정보 변경\t*");
		System.out.println("*                        ");
		System.out.println("* 5.  종료         ");
		System.out.println("*************************");
		System.out.println(" 원하는 번호를 입력 하세요.  ");
	}

	Scanner scan = new Scanner(System.in);
	GregorianCalendar gc = new GregorianCalendar();
	MainSystem[] Main;
	int countOfcompany; // 업체의 개수
	private Company[] companys;

	public void Companyss() {
		while (true) {
			menu();
			int input = scan.nextInt();
			switch (input) {
			case 1:
				Employee();
				break;
			case 2:
				Employeeinquiry();
				break;
			case 3:
				update();
				break;
			case 5:
				System.out.println("부서관리 시스템을 종료합니다.");
				System.exit(0);
			}
		}
	}

	public void Employee() {// 부서등록
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		countOfcompany = scan.nextInt();
		companys = new Company[countOfcompany]; // 입력개수로 배열생성
		for (int i = 0; i < countOfcompany; i++) {
			System.out.println("등록할 부서의 이름을 입력하세요.");
			String name = scan.next();
			System.out.println("등록할 부서의 권한을 입력하세요.");
			String price = scan.next();
			scan.nextLine();
			System.out.println("부서번호를 입력하세요.");
			String desc = scan.nextLine();
			int year = gc.get(Calendar.YEAR);
			int month = gc.get(Calendar.MONTH) + 1;
			int date = gc.get(Calendar.DATE);
			int hour = gc.get(Calendar.HOUR);
			int min = gc.get(Calendar.MINUTE);
			int sec = gc.get(Calendar.SECOND);
			String now = year + "/" + month + "/" + date + "  " + hour + ":" + min + ":" + sec;
			Company compan = new Company(name, price, desc, now);
			companys[i] = compan;
			System.out.println("부서 등록 완료");

		}
	}

	public void Employeeinquiry() {
		System.out.println("검색할 부서를 입력하세요.");
		String sName = scan.next();
		boolean flag = false;
		for (int i = 0; i < countOfcompany; i++) {
			if (sName.equals(companys[i].name)) {
				System.out.println("검색된 부서이름   : " + companys[i].name);
				System.out.println("검색된 부서권한   : " + companys[i].price);
				System.out.println("검색된 부서정보   : " + companys[i].desc);
				System.out.println("검색된 부서등록일 : " + companys[i].date);
				flag = true;
			}
		}
		if (flag == false) {
			System.out.println("입력하신 이름의 부서는 존재하지 않습니다.");
		}
	}

	public void update() {
		System.out.println("정보를 변경할 부서의 이름을 입력하세요.");
		String name = scan.next();
		boolean flag = false;
		for (int i = 0; i < countOfcompany; i++) {
			if (name.equals(companys[i].name)) {
				System.out.println("새 부서의 권한을 입력하세요.");
				String price = scan.next();
				scan.nextLine();
				companys[i].price = price;
				System.out.println("부서의 정보를 입력하세요.");
				String desc = scan.nextLine();
				companys[i].desc = desc;
				System.out.println("부서 정보가 변경되었습니다.");
				flag = true;
			} // end of if
		} // end of for
		if (flag == false)
			System.out.println("입력한 부서의 사원은 존재하지 않습니다.");
	}
}