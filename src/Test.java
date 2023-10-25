import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath() + "\\src\\students.txt";
        Clazz clazz;
        try {
            clazz = new Clazz("CNTT", "2022", StudentUtils.loadStudents(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        clazz.display();
        clazz.sortStudents(new GPAComparator());
        System.out.println("-SORT GPA-");
        clazz.display();
        System.out.println("-GET TOP STUDENTS-");
        clazz.display(clazz.getTopNStudents(5));
        System.out.println("-GET RANDOM STUDENTS-");
        clazz.display(clazz.getRandomNStudents(5));
        System.out.println("-REMOVE STUDENT BY ID-");
        System.out.print("-GET STUDENT BY BIRTH YEAR- ");
        System.out.println(clazz.removeStudent("18130110"));
        clazz.display(clazz.getStudentByBirthYear(1997));

    }
}
