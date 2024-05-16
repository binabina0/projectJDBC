package tutorial;

import java.util.List;

public class App {
    public static void main(String[] args) {

        List<Student> students = CRUDUtils.getStudentData("SELECT * FROM students");
        System.out.println(students);

        Student student = new Student();
        student.setName("Ivan");
        student.setName("Ivanov");
        student.setName("Automation QA");

        System.out.println(CRUDUtils.saveStudent(student));
        System.out.println(CRUDUtils.updateStudent(1, "Automation QA"));
        System.out.println(CRUDUtils.deleteStudent(1));
    }
}
