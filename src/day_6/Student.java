package day_6;

public class Student implements Comparable<Student> {

	private int number;		// 학번
	private String name;	// 이름
	private SortedLinkedList<Course> courseList;	// 수강 과목

	// 생성자
	public Student(int number, String name, SortedLinkedList<Course> courseList) {
		this.number = number;
		this.name = name;
		this.courseList = courseList;
		courseList.reset();
	}

	/**
	 * 총 학점 수를 계산한 후 반환한다.
	 * @return 총 학점
	 */
	public int getTotalCredits() {
		int total = 0;
		while(courseList.hasNext()) {
			total += courseList.next().getCredit();
		}
		courseList.reset();
		return total;
	}

	/**
	 * 학번 순서를 비교한다.
	 * @param other 다른 학생
	 * @return 1 (다른 학생보다 학번이 늦을 경우)
	 * 		   -1 (다른 학생보다 학번이 빠를 경우)
	 */
	public int compareTo(Student other) {
		if(number >= other.number)
			return 1;
		else 
			return -1;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(number + "\t");
		sb.append(name + "\t");
		sb.append("total credits: " + getTotalCredits() + "\n");
		sb.append(courseList.toString() + "\n");
		courseList.clear();
		
		return sb.toString();
	}

}
