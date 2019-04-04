package test;

import java.util.Scanner;

public class CustomerManager {

	Scanner scan = new Scanner(System.in);
	Customer[] cusArray;
	int CountOfCustomer;

	public void menuCustomer() {
		System.out.println("**********************");
		System.out.println("거래처 관리 시스템 ver 1.0");
		System.out.println("*                     ");
		System.out.println("* 1. 거래처 등록               ");
		System.out.println("* 2. 거래처 조회               ");
		System.out.println("* 3. 거래처 정보 변경          ");
		System.out.println("*                     ");
		System.out.println("* 5. 종료                     ");
		System.out.println("**********************");
		System.out.println("원하시는 번호를 입력하세요.");
	}

	public void doItCustomer() {
		while (true) {
			menuCustomer();

			int input = scan.nextInt();
			scan.nextLine();

			switch (input) {
			case 1:
				insertCustomer();
				break;
			case 2:
				searchCustomer();
				break;
			case 3:
				updateCustomer();
				break;
			case 5:
				System.out.println("거래처 관리 시스템을 종료 합니다.");
				System.exit(0);
				// 종료 아니면 메인 메뉴 실행 메소드 입력
			}
		}
	}

	public void insertCustomer() {
		System.out.println("등록할 거래처 수량을 입력하세요.");
		CountOfCustomer = scan.nextInt();
		scan.nextLine();
		cusArray = new Customer[CountOfCustomer];
		boolean check = false;
		for (int i = 0; i < CountOfCustomer; i++) {
			System.out.println("거래처 이름을 입력하세요.");
			String name = scan.nextLine();
			System.out.println("거래처 설명을 입력하세요.");
			String desc = scan.nextLine();

			Customer cus = new Customer();

			cus.name = name;
			cus.desc = desc;

			cusArray[i] = cus;

			System.out.println(i + 1 + "번째 거래처가 등록되었습니다.");
			System.out.println("이름은 " + cusArray[i].name + " 설명은 " + cusArray[i].desc);
			check = true;
		}
		if (check) {
			System.out.println("거래처 등록이 완료 되었습니다.");
		} else {
			System.out.println("입력이 잘못 되었습니다.");
		}

	}

	public void searchCustomer() {
		System.out.println("전체 거래처 목록을 출력합니다.");
		for (int i = 0; i < CountOfCustomer; i++) {
			System.out.print("이름은 " + cusArray[i].name);
			System.out.println(" 설명은 " + cusArray[i].desc);
		}
		System.out.println("전체 거래처 목록이 조회되었습니다.");
		System.out.println("찾을 거래처 이름을 입력하세요.");
		String name = scan.nextLine();
		boolean check = false;
		for (int i = 0; i < CountOfCustomer; i++) {
			if (cusArray[i].name.equals(name)) {
				System.out.print("이름은 " + cusArray[i].name);
				System.out.println(" 설명은 " + cusArray[i].desc);
				System.out.println("거래처가 조회 되었습니다.");
				check = true;
			}
		}
		if (check) {
			System.out.println("거래처 조회 메뉴가 종료되었습니다.");
		} else {
			System.out.println(name + "으로 입력한 이름과 동일한 거래처를 찾지 못하였습니다.");
		}

	}

	public void updateCustomer() {
		System.out.println("전체 거래처 목록을 출력합니다.");
		for (int i = 0; i < CountOfCustomer; i++) {
			System.out.print("이름은 " + cusArray[i].name);
			System.out.println(" 설명은 " + cusArray[i].desc);
		}
		System.out.println("전체 거래처 목록이 조회되었습니다.");
		System.out.println("정보를 변경할 거래처 이름을 입력하세요");
		String name = scan.nextLine();
		boolean check = false;
		for (int i = 0; i < CountOfCustomer; i++) {
			if (cusArray[i].name.equals(name)) {
				System.out.print("이름은 " + cusArray[i].name);
				System.out.println(" 설명은 " + cusArray[i].desc);
				System.out.println("변경할 거래처 이름을 입력하세요");
				String changeName = scan.nextLine();
				cusArray[i].name = changeName;
				System.out.println("변경할 거래처 설명을 입력하세요");
				String changeDesc = scan.nextLine();
				cusArray[i].desc = changeDesc;
				System.out.println(
						name + "거래처 정보가 " + "이름은 " + cusArray[i].name + " 설명은 " + cusArray[i].desc + "로 변경 되었습니다.");
				check = true;
			}
		}
		if (check) {
			System.out.println("거래처 정보 변경 메뉴가 종료되었습니다.");
		} else {
			System.out.println(name + "으로 입력한 이름과 동일한 거래처를 찾지 못하였습니다.");
		}
	}
}