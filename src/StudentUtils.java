import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StudentUtils {
    // read the content of a text file
    public static ArrayList<Student> loadStudents(String fileName) throws IOException {
        ArrayList<Student> result = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line, id, firstName, lastName;
        StringTokenizer tokens;
        int birthYear;
        double GPA;
        while (true) {
            line = reader.readLine();
            if (line == null)
                break;
            tokens = new StringTokenizer(line, "\t");
            id = tokens.nextToken();
            firstName = tokens.nextToken();
            lastName = tokens.nextToken();
            birthYear = Integer.parseInt(tokens.nextToken());
            GPA = Double.parseDouble(tokens.nextToken());
            result.add(new Student(id, firstName, lastName, birthYear, GPA));
        }
        reader.close();
        return result;
    }
}
