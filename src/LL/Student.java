package LL;

public class Student implements Comparable<Student> {
    private int studentNumber;
    // Other fields and methods

    public Student(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public int compareTo(Student otherStudent) {
        // Compare student numbers for sorting
        return Integer.compare(this.studentNumber, otherStudent.studentNumber);
    }
}
