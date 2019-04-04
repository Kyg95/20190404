package test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class DutyManSystem {
	Duty[] dutys;
	Scanner scan = new Scanner(System.in);
	GregorianCalendar gc = new GregorianCalendar();
	int countOfDuty;// 업무의 갯수용 변수

	void input() {// 업무등록
		System.out.println("등록할 업무의 갯수를 입력하세요.");
		countOfDuty = scan.nextInt();// 입력한 갯수를 저장
		dutys = new Duty[countOfDuty];// 입력한 갯수로 배열 생성
		for (int i = 0; i < countOfDuty; i++) {// 입력한 갯수만큼 반복
			System.out.println("업무의 번호를 입력하세요.");
			int number = scan.nextInt();// 입력된 정수만 저장(엔터제외)
			System.out.println("업무의 이름을 입력하세요.");
			String name = scan.next();// 입력된 문자열만 저장(엔터제외)
			scan.nextLine();// 입력된 엔터를 읽어들임(즉, 엔터를 없앰)
			System.out.println("업무의 설명을 입력하세요.");
			String desc = scan.nextLine();// 입력된 문자열 저장(엔터포함)
			// 업무설명의 경우 문자열 중간에 공백이 포함될 수 있으므로,
			// nestLine()으로 문자열을 처리해야한다.
			int year = gc.get(Calendar.YEAR);// 올해의 년도 생성
			int month = gc.get(Calendar.MONTH) + 1;// 이달을저장
			int date = gc.get(Calendar.DATE);
			int hour = gc.get(Calendar.HOUR);
			int min = gc.get(Calendar.MINUTE);
			int sec = gc.get(Calendar.SECOND);
			String now = year + "/" + month + "/" + date + " " + hour + ":" + min + ":" + sec;
			Duty duty = new Duty(number, name, desc, now);
			dutys[i] = duty;
			System.out.println("업무가 등록되었습니다. ");
		} // end of for
	}

	void doIt() {
		while (true) {// 9번을 선택하기 전까지 무한반복
			menu();
			int input = scan.nextInt();// 입력한 번호를 input에 보관
			switch (input) {
			case 1:
				input();
				break;
			case 2:
				search();
				break;
			case 3:
				update();
				break;
			case 9:
				System.out.println("이용해 주셔서 감사합니다~");
				System.exit(0);// 강제종료(0:정상종료,그외:비정상종료)
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

	void search() { // 조회 메서드
		System.out.println("검색할 업무의 번호를 입력하세요.");
		int number = scan.nextInt();
		boolean flag = false;// ,입력한 업무의 이름의 존재여부를 위한 변수
		for (int i = 0; i < countOfDuty; i++) {// 업무의 갯수만큼 반복
			if (number == (dutys[i].number)) {
				// 입력한 업무의 번호와 저장된 업무의 번호가 같은지 비교
				System.out.println("검색된 업무번호:" + dutys[i].number);
				System.out.println("검색된 업무이름:" + dutys[i].name);
				System.out.println("검색된 업무설명:" + dutys[i].desc);
				System.out.println("검색된 업무등록일:" + dutys[i].date);
				flag = true;
			} // end of if
		} // end of for
		if (flag == false)
			System.out.println("입력한 번호의 업무는 존재하지 않습니다. ");
	}

	void update() {// 업무정보 변경 메서드 (이름과 설명만 변경가능)
		System.out.println("정보를 변경할 업무의 번호을 입력하세요.");
		int number = scan.nextInt();
		boolean flag = false;
		for (int i = 0; i < countOfDuty; i++) {
			if (number == (dutys[i].number)) {// 동일한 번호의 업무찾음
				System.out.println("새 업무 이름을 입력하세요.");
				String name = scan.next();
				scan.nextLine();// 이름에서 입력된 엔터를 처리
				dutys[i].name = name;// 새 이름으로 업무이름 변경
				System.out.println("새 업무 설명을 입력하세요.");
				String desc = scan.nextLine();
				dutys[i].desc = desc;// 새 설명으로 업무설명 변경
				System.out.println("업무 정보가 변경되었습니다.");
				flag = true;
			} // end of if
		} // end of for
		if (flag == false)
			System.out.println("입력한 번호의 업무은 존재하지 않습니다.");
	}

	void menu() {
		System.out.println("#########################");
		System.out.println("# 업무 관리 시스템 ver 1.0 #");
		System.out.println("#                       #");
		System.out.println("# 1. 업무등록              #");
		System.out.println("# 2. 업무 번호로 조회     #");
		System.out.println("# 3. 업무 정보 변경         #");
		System.out.println("#                       #");
		System.out.println("# 9. 종료                   #");
		System.out.println(" 원하는 번호를 입력하세요.");
		System.out.println("#########################");
	}

	public static void main(String[] args) {
		DutyManSystem dm = new DutyManSystem();
		dm.doIt();

	}

}