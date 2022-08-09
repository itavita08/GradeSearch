package model.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Student {
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int meth;
	
	public String getGrade() {
		String grade = null;
		float avg = (kor+eng+meth)/3;
		if(avg>=90) {
			return "A";
		}else if(avg>=80) {
			return "B";
		}else {
			return "C";
		}
	}
}
