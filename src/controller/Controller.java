package controller;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import model.Model;
import model.domain.Admin;
import view.FailView;

public class Controller {
	private static Model m = Model.getInstance();
	static Logger logger = Logger.getLogger("Model");

	// id확인
	public static void loginIdCheck(String check) {
		if (m.idCheck(check) != true) {
			FailView.failMsg("잘못된 ID입니다");
			logger.info("잘못입력된 ID : " + check);
			System.exit(0);
		}
	}

	// pw확인
	public static void loginPwCheck(String check) {
		if (m.pwCheck(check) != true) {
			FailView.failMsg("잘못된 PW입니다");
			logger.info("잘못입력된 PW : " + check);
			System.exit(0);
		}
	}

	// 성적 관리 프로그램
	public static void reqRes(int no) {
		if (no == 1) {
			m.insert();
		} else if (no == 2) {
			m.search();
		} else if (no == 3) {
			m.searchAll();
		} else if (no == 4) {
			m.modify();
		} else if (no == 5) {
			m.delete();
		} else {
			FailView.failMsg("잘못된 요청입니다");
		}
	}
}