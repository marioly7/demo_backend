package bo.edu.ucb.demo.Backend;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Student {
    JdbcTemplate jdbcTemplate;
    private Integer studentId;
    private String fullName;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Student findById(int studentIdg) {
        List result = jdbcTemplate.query("SELECT * FROM student WHERE student_id = studentIdg;",
                new Object[]{}, (resultSet, i) -> {
                    Student student = new Student();
                    student.setStudentId(resultSet.getInt(1));
                    student.setFullName(resultSet.getString(2));
                    return student;
                });
        return (Student) result.get(0);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
