package view;

import model.domain.Student;

public class SuccessView {

	// 성공 문장출력
	public static void sucMsg(String string) {
		System.out.println(string);

	}

	// 정보 출력
	public static void sucInfo(Student std) {
		System.out.println("학번 : " + std.getNo() + " 이름 : " + std.getName() + " 국어성적 : " + std.getKor() + " 영어 성적 : "
				+ std.getEng() + " 수학 성적 : " + std.getMeth() + " 종합 등급 : " + std.getGrade());
	}

}
