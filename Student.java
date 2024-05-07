package XML;
import java.io.FileWriter; 
import java.io.IOException; 
import java.util.ArrayList; import java.util.List;

public class Student { private String name; private int age; private double gpa;

public Student(String name, int age, double gpa) {
    this.name = name;
    this.age = age;
    this.gpa = gpa;
}

public String toXMLString() {
    return "<student>\n" +
            "    <name>" + name + "</name>\n" +
            "    <age>" + age + "</age>\n" +
            "    <gpa>" + gpa + "</gpa>\n" +
            "</student>\n";
}

public static void main(String[] args) {
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("Alice", 20, 3.5));
    studentList.add(new Student("Bob", 21, 3.2));
    studentList.add(new Student("Charlie", 22, 3.8));

    try {
        FileWriter outputFile = new FileWriter("student_list.xml");
        outputFile.write("<student_list>\n");
        for (Student student : studentList) {
            outputFile.write(student.toXMLString());
        }
        outputFile.write("</student_list>");
        outputFile.close();
        System.out.println("XML file generated successfully.");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}