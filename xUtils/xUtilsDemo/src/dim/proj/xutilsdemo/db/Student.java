package dim.proj.xutilsdemo.db;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Table;

/**
 * 
 * @author Phlin
 * @date 2015 06 25
 */

/*
 * table name
 */
@Table(name = "student")
public class Student {
	int id;

	@Column(column = "name")
	String name = "";

	// column age
	@Column(column = "age")
	int age = 0;
	// column height
	@Column(column = "height")
	int height = 0;
	// column grade
	@Column(column = "grade")
	int grade;
	// column score
	@Column(column = "scores")
	int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
