//여러가지 메소드 구현

package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import model.domain.Admin;
import model.domain.Student;
import view.StartView;
import view.FailView;
import view.SuccessView;

public class Model {
	Scanner sc = new Scanner(System.in);
	public static ArrayList<Student> list = new ArrayList<>();
	int no;
	String name;
	int kor;
	int eng;
	int meth;
	boolean exist = false;
	ArrayList<Integer> noList = new ArrayList<>();

	
	// 로그인 아이디
	static Admin am = Admin.builder().id("admin").pw("1q2w3e").build();

	// 싱글톤
	private static Model instance = new Model();

	private Model() {
	}

	public static Model getInstance() {
		return instance;
	}
	
	public static ArrayList arrayList(ArrayList list) {
		return list;
	}
	
	
	
	// id 확인
	public static boolean idCheck(String check) {
		if (!check.equals(am.getId())) {
			return false;
		}
		return true;
	}

	// pw 확인
	public static boolean pwCheck(String pw) {
		if (!pw.equals(am.getPw())) {
			return false;
		}
		return true;
	}

	// 입력
	public void insert() {
		int stu_num = 0;
		System.out.println("몇명의 학생을 입력하겠습니까");
		stu_num = sc.nextInt();
		for (int i = 0; i < stu_num; i++) {
			System.out.println("학번을 입력하세요");
			no = sc.nextInt();
			System.out.println("이름을 입력하세요");
			name = sc.next();
			System.out.println("국어성적을 입력하세요");
			kor = sc.nextInt();
			if (kor > 100) {
				FailView.failMsg("100점이 최대점수입니다");
				FailView.failMsg("다시 입력하세요");
				kor = sc.nextInt();
			}
			System.out.println("영어성적을 입력하세요");
			eng = sc.nextInt();
			if (eng > 100) {
				FailView.failMsg("100점이 최대점수입니다");
				FailView.failMsg("다시 입력하세요");
				eng = sc.nextInt();
			}
			System.out.println("수학성적을 입력하세요");
			meth = sc.nextInt();
			if (meth > 100) {
				FailView.failMsg("100점이 최대점수입니다");
				FailView.failMsg("다시 입력하세요");
				meth = sc.nextInt();
			}
			for (int j = 0; j < list.size(); j++) {

				if (list.get(j).getNo() == no) {
					FailView.failMsg("이미 존재하는 학번입니다");
					exist = true;
					break;
				}
			}
			if (exist == false) {
				list.add(Student.builder().no(no).name(name).kor(kor).eng(eng).meth(meth).build());
				SuccessView.sucMsg("저장 완료");
			}

		}
		noList.clear();
		for (Student temp : list) {
			noList.add(temp.getNo());
		}
	}

	// 학번으로 조회
	public void search() {
		noList.clear();
		for (Student temp2 : list) {
			noList.add(temp2.getNo());
		}
		int find = 0;
		Student temp = null;
		System.out.println("검색할 학번을 입력하세요");
		find = sc.nextInt();
		for (Student z : list) {
			if (find == z.getNo()) {
				temp = z;
				break;
			}
		}
		if (temp != null) {
			SuccessView.sucInfo(temp);
		} else {
			FailView.failMsg("학번을 정확하게 입력하세요");
		}
	}

	// 전체 검색
	public void searchAll() {
//		int sort = 0;
//		System.out.println("정렬할 기준을 입력하세요(내림차순) 1.학번 2.이름 3.국어성적 4.영어성적 5.수학성적");
//		sort = sc.nextInt();
//		if(sort = 1) {
		for (Student z : list) {
			SuccessView.sucInfo(z);
		}
	}

	// 수정
	public void modify() {
		noList.clear();
		for (Student temp2 : list) {
			noList.add(temp2.getNo());
		}
		int modifyFind = 0;
		System.out.println("수정할 학번을 입력하세요");
		modifyFind = sc.nextInt();
		for (Student z : list) {
			if (modifyFind == z.getNo()) {
				System.out.println("수정할 부분을 선택하세요 0.취소 1.일괄수정 2.학번수정 3.이름수정 4.국어성적수정 5.영어성적수정 6.수학성적수");
				int select = sc.nextInt();

				if (select == 1) {
					System.out.println("학번을 입력하세요");
					no = sc.nextInt();
					if (noList.contains(no) == true) {
						FailView.failMsg("이미 존재하는 학번입니다 다른 학번을 지정해주세요");
						FailView.failMsg("다시 입력하세요");
						no = sc.nextInt();
					}
					z.setNo(no);
					System.out.println("이름을 입력하세요");
					z.setName(sc.next());
					System.out.println("국어성적을 입력하세요");
					kor = sc.nextInt();
					if (kor > 100) {
						FailView.failMsg("100점이 최대점수입니다");
						FailView.failMsg("다시 입력하세요");
						kor = sc.nextInt();
					}
					z.setKor(kor);
					System.out.println("영어성적을 입력하세요");
					eng = sc.nextInt();
					if (meth > 100) {
						FailView.failMsg("100점이 최대점수입니다");
						FailView.failMsg("다시 입력하세요");
						eng = sc.nextInt();
					}
					z.setEng(eng);
					System.out.println("수학성적을 입력하세요");
					meth = sc.nextInt();
					if (meth > 100) {
						FailView.failMsg("100점이 최대점수입니다");
						FailView.failMsg("다시 입력하세요");
						meth = sc.nextInt();
					}
					z.setEng(meth);
					SuccessView.sucMsg("변경완료되었습니다");
					SuccessView.sucInfo(z);
					break;
				} else if (select == 2) {
					System.out.println("변경할 학번을 입력하세요");
					no = sc.nextInt();
					if (noList.contains(no) == true) {
						FailView.failMsg("이미 존재하는 학번입니다 다른 학번을 지정해주세요");
						FailView.failMsg("다시 입력해주세요");
						no = sc.nextInt();
					}
					z.setNo(no);
				} else if (select == 3) {
					System.out.println("변경할 이름을 입력하세요");
					z.setName(sc.next());
					SuccessView.sucMsg("변경완료되었습니다");
					SuccessView.sucInfo(z);
					break;
				} else if (select == 4) {
					System.out.println("변경할 국어성적을 입력하세요");
					kor = sc.nextInt();
					if (kor > 100) {
						FailView.failMsg("100점이 최대점수입니다");
						FailView.failMsg("다시 입력하세요");
						kor = sc.nextInt();
					}
					SuccessView.sucMsg("변경완료되었습니다");
					SuccessView.sucInfo(z);
					break;
				} else if (select == 5) {
					System.out.println("변경할 영어성적을 입력하세요");
					eng = sc.nextInt();
					if (meth > 100) {
						FailView.failMsg("100점이 최대점수입니다");
						FailView.failMsg("다시 입력하세요");
						eng = sc.nextInt();
					}
					z.setEng(eng);
					SuccessView.sucMsg("변경완료되었습니다");
					SuccessView.sucInfo(z);
					break;
				} else if (select == 6) {
					System.out.println("변경할 수학성적을 입력하세요");
					meth = sc.nextInt();
					if (meth > 100) {
						FailView.failMsg("100점이 최대점수입니다");
						FailView.failMsg("다시 입력하세요");
						meth = sc.nextInt();
					}
					z.setEng(meth);
					SuccessView.sucMsg("변경완료되었습니다");
					SuccessView.sucInfo(z);
					break;
				} else if (select == 0) {
					break;
				} else {
					FailView.failMsg("잘못된 요청입니다");
					break;

				}
			}
		}
	}

	public void delete() {
		int delNo = 0;
		int select = 0;
		System.out.println("0.취소  1.전체 삭제  2.선택 삭제");
		select = sc.nextInt();
		if (select == 1) {
			list.clear();
			SuccessView.sucMsg("전체 삭제 완료");
		} else if (select == 2) {
			System.out.println("삭제할 학생의 학번을 입력하세요");
			delNo = sc.nextInt();
			ArrayList<Student> removed = new ArrayList<>();
			for (Iterator<Student> iterator = list.iterator(); iterator.hasNext();) {
				Student z = iterator.next();
				if (z.getNo() == delNo) {
					iterator.remove();
				}
			}
		}

	}

}
