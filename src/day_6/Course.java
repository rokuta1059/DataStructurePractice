package day_6;

class Course implements Comparable<Course> {

    private String name;    // 과목명
    private int credit;     // 학점 수
    private char grade;     // 학점

    public Course(String name, int credit, char grade) {
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getCredit() {
        return credit;
    }

    public char getGrade() {
        return grade;
    }

    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("\t");
        s.append(String.format("%-20s", name));
        s.append(String.format("%8d", credit));
        s.append(String.format("%7s", grade));
        s.append("\n");
        return s.toString();

    }

    public int compareTo(Course other) {
        return name.compareTo(other.name);
    }

}
