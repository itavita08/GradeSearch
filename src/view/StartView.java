package view;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import controller.Controller;
import model.Model;
import model.domain.Student;
import static model.Model.list;
public class StartView {

	public static void main(String[] args) {
		int select = 0;
		Scanner sc = new Scanner(System.in);
		Controller cont = new Controller();
		Logger logger = Logger.getLogger("StartView");
		list.add(Student.builder().no(22001).name("안유진").kor(90).eng(50).meth(40).build());
		list.add(Student.builder().no(22002).name("가을").kor(90).eng(40).meth(60).build());
		list.add(Student.builder().no(22003).name("레이").kor(90).eng(70).meth(80).build());
		list.add(Student.builder().no(22004).name("장원영").kor(80).eng(60).meth(90).build());
		list.add(Student.builder().no(22005).name("리즈").kor(50).eng(80).meth(90).build());
		list.add(Student.builder().no(22006).name("이서").kor(70).eng(90).meth(100).build());
		list.add(Student.builder().no(22007).name("카리나").kor(50).eng(60).meth(70).build());
		list.add(Student.builder().no(22008).name("윈터").kor(70).eng(80).meth(80).build());
		list.add(Student.builder().no(22009).name("지젤").kor(60).eng(50).meth(90).build());
		list.add(Student.builder().no(22010).name("닝닝").kor(80).eng(60).meth(50).build());
		list.add(Student.builder().no(22011).name("지수").kor(100).eng(80).meth(100).build());
		list.add(Student.builder().no(22012).name("제니").kor(40).eng(50).meth(70).build());
		list.add(Student.builder().no(22013).name("로제").kor(90).eng(70).meth(70).build());
		list.add(Student.builder().no(22014).name("리사").kor(90).eng(80).meth(90).build());


		// 로그인 확인
		System.out.println("로그인 화면");
		System.out.println("ID를 입력해주세요");
		cont.loginIdCheck(sc.next());
		System.out.println("PW를 입력해주세요");
		cont.loginPwCheck(sc.next());

		// 성적관리
		while (true) {
			try {
				System.out.println("성적 관리 프로젝트");
				System.out.println("0.종료 1.추가 2.검색 3.전체검색 4.수정 5.삭제");
				select = sc.nextInt();
				if (select == 0) {
					SuccessView.sucMsg("프로그램을 종료합니다");
					System.exit(0);
				} else if (select > 6 || select < 0) {
					FailView.failMsg("정해진 범위 안에서 선택하세요");
				} else {
					cont.reqRes(select);
				}
			} catch (Exception e) {
				logger.info(e);
				e.printStackTrace();
				FailView.failMsg("Exceptio 발생 강제 종료");
				System.exit(0);
			}

		}
	}

}
