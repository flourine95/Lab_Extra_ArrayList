import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Clazz {
    private String name;
    private String year;// 2017, 2018, 2019, ...
    private ArrayList<Student> students = new ArrayList<>();

    public Clazz(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public Clazz(String name, String year, ArrayList<Student> students) {
        this.name = name;
        this.year = year;
        this.students = students;
    }

    // sort students according to the given comparator c
    public void sortStudents(Comparator<Student> c) {
        students.sort(c);
    }

    // get top n students with highest GPA
    public ArrayList<Student> getTopNStudents(int n) {
        if (n <= 0) {
            return null;
        }
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort(new GPAComparator());
        ArrayList<Student> topNStudents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            topNStudents.add(sortedStudents.get(i));
        }
        return topNStudents;
    }

    // get random n students from the list of students
    public ArrayList<Student> getRandomNStudents(int n) {
        /*
        random with Random()
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(students.get(new Random().nextInt(students.size())));
        }
        return list;
        */
        if (n <= 0) {
            return null;
        }
        ArrayList<Student> shuffleStudents = new ArrayList<>(students);
        ArrayList<Student> nStudents = new ArrayList<>();
        Collections.shuffle(shuffleStudents);
        for (int i = 0; i < n; i++) {
            nStudents.add(shuffleStudents.get(i));
        }
        return nStudents;
    }

    // remove a student with a given id
    public boolean removeStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    // get all students who were born in a given birth year.
    public ArrayList<Student> getStudentByBirthYear(int birthYear) {
        return students.stream().filter(student -> student.getBirthYear() == birthYear).collect(Collectors.toCollection(ArrayList::new));
    }

    // similar as toString method, this method prints the name, year, and all
    // students of the class. Note that, using iterator
    public void display() {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public void display(ArrayList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
