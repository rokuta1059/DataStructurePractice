package day_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class studentData {

	/**
	 * 파일을 읽고 학생 및 과목 정보를 저장한다.
	 * @param inFile
	 * @param StudentList
	 */
	public static void getStudentData (Scanner inFile, SortedLinkedList<Student> StudentList) {

		int studentNum;		// 학생 번호
		String studentName;	// 학생 이름
		String courseName;	// 수업 이름
		int credits;		// 학점
		String grade;		// 성적
		Student Student;
		Course course;
		String lineStr;
		String[] studentStr;
		String[] courseStr;

		// 파일을 읽는다.
		while(inFile.hasNextLine()) {

			// 학생 정보를 먼저 저장해둔다
			lineStr = inFile.nextLine();
			studentStr = lineStr.split(" ");
			studentNum = Integer.parseInt(studentStr[0]);
			studentName = studentStr[1];
			SortedLinkedList<Course> courseList = new SortedLinkedList<Course>();
			courseList.clear();

			// 과목 정보를 읽고 저장한다.
			while (inFile.hasNextLine()) {
				lineStr = inFile.nextLine();
				if(lineStr.isEmpty())
					break;
				else {
					courseStr = lineStr.split(" ");
					courseName = courseStr[0];
					credits = Integer.parseInt(courseStr[1]);
					grade = courseStr[2];
					course = new Course(courseName, credits, grade.charAt(0));
					courseList.insert(course);
				}
			}
			// 과목 정보를 포함한 학생 정보를 저장한다.
			Student = new Student(studentNum, studentName, courseList);
			StudentList.insert(Student);
		}
	}

	/**
	 * 메인 메소드
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner inFile = null; 
		try {
			inFile = new Scanner(new File("src/day_6/input.txt"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error opening the file: input.txt" );
		}
		
		SortedLinkedList<Student> studentList = new SortedLinkedList<>();

		// inFile에서 학생 데이터 읽어 studentList에 저장
		getStudentData(inFile, studentList);
		System.out.print(studentList);
		inFile.close();


	}

}
