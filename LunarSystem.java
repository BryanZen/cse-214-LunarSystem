/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-11-16
 */

import java.io.*;
import java.util.*;

/**
 *Write a full-documented class named LunarSystem that will allow the user to
 * interact with a database of Students. Provide the user with a menu-based
 * interface that allows them to add, remove, and edit Students, as well as
 * their courses. You will need to be able to serialize (save) the database
 * at the end of the program and deserialize (load) the database if a file
 * containing the database already exists. The database will have a Student’s
 * netID as the key and the associated Student object as the value.
 */
public class LunarSystem {
    private static HashMap<String, Student> database;

    /**
     *On startup, the LunarSystem should check to see if the file Lunar.ser
     * exists in the current directory. If it does, then the file should be
     * loaded and deserialized into the database instance. If the file does
     * not exist, a new HashMap should be created and used instead. In either
     * case, the user should be allowed to fully interact with the
     * LunarSystem without issues.
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the Lunar System, a second place " +
                "course registration system for second rate courses at " +
                "a second class school. \n");
        File file = new File("/Users/bryanzen/IdeaProjects" +
                "/cse214_hw6/" + "Lunar.ser");
        boolean fileExists = file.exists();
        if (fileExists){
            FileInputStream fileInput = new FileInputStream("Lunar.ser");
            ObjectInputStream inStream = new ObjectInputStream(fileInput);
            database = (HashMap<String, Student>) inStream.readObject();
            inStream.close();
            System.out.println("Previous data loaded. \n");
        } else{
            database = new HashMap<String, Student>();
            System.out.println("No previous data found. \n");
        }
        boolean x = true;
        while (x) {
            System.out.println("""
                    Menu:

                        L) Login

                        X) Save state and quit

                        Q) Quit without saving state.""");
            System.out.println("\n" + "Please select an option: ");
            char choice = sc.next().charAt(0);
            try {
                if (choice >= '0' && choice <= '9') {
                    throw new Exception("Bad input! ");
                }
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
            choice = Character.toUpperCase(choice);
            switch(choice){
                case 'L' -> {
                    System.out.println("Please enter webID: ");
                    sc.nextLine();
                    String webID = sc.nextLine().toLowerCase();
                    if (webID.equals("registrar")){
                        System.out.println("""

                            Welcome Registrar.

                            Options:

                                 R) Register a student

                                 D) De-register a student

                                 E) View course enrollment

                                 L) Logout
                            """);
                        boolean y = true;
                        while(y){
                            System.out.println("Please select an option: ");
                            char choiceL = sc.next().charAt(0);
                            try {
                                if (choiceL >= '0' && choiceL <= '9') {
                                    throw new Exception("Bad input! ");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                            choiceL = Character.toUpperCase(choiceL);
                            switch(choiceL) {
                                case 'R' -> {
                                    System.out.println("Please enter a " +
                                            "webID for the new student: ");
                                    sc.nextLine();
                                    String newWebID = sc.nextLine();
                                    if (database.get(newWebID.toLowerCase())
                                            == null){
                                        Student newStudent = new Student();
                                        newStudent.setName(newWebID);
                                        newStudent.setWebID(newWebID
                                                .toLowerCase());
                                        database.put(newStudent.getWebID()
                                                , newStudent);
                                        System.out.printf("%s registered." +
                                                " \n", newWebID);
                                    } else{
                                        System.out.printf("%s is already " +
                                                "registered. \n", newWebID);
                                    }
                                }
                                case 'D' -> {
                                    System.out.println("Please enter a " +
                                            "webID for the student " +
                                            "to be deregistered: ");
                                    sc.nextLine();
                                    String webIDD = sc.nextLine();
                                    if (database.get(webIDD.toLowerCase())
                                            != null){
                                        database.remove(webIDD.toLowerCase());
                                        System.out.printf("%s deregistered. " +
                                                "\n", webIDD);
                                    } else{
                                        System.out.println("Student not " +
                                                "registered. ");
                                    }
                                }
                                case 'E' -> {
                                    System.out.println("Please enter course: ");
                                    sc.nextLine();
                                    String courseName = sc.nextLine()
                                            .toUpperCase();
                                    String[] courseArray = courseName
                                            .split(" ");
                                    System.out.printf("Students Registered " +
                                            "in %s: \n", courseName);
                                    System.out.println("""
                                            Student    Semester
                                            -------------------""");
                                    for (Student student : database.values()){
                                        if (student.getCourses()
                                                != null && student
                                                .getCourses().size() > 1) {
                                            for (Course course :
                                                    student.getCourses()){
                                                if (course.getDepartment()
                                                        .equals(courseArray[0])
                                                        && course.getNumber()
                                                        == Integer.parseInt
                                                        (courseArray[1])){
                                                    System.out.printf("%-11s",
                                                            student.getName());
                                                    System.out.printf("%s\n",
                                                            course.getSemester
                                                                            ());
                                                }
                                            }
                                        }
                                        if (student.getCourses() != null
                                                && student.getCourses()
                                                .size() == 1){
                                            if (student.getCourses().get(0)
                                                    .getDepartment()
                                                    .equals(courseArray[0])
                                                    && student.getCourses()
                                                    .get(0).getNumber() ==
                                                    Integer.parseInt
                                                            (courseArray[1])){
                                                System.out.printf("%-11s"
                                                        , student.getName());
                                                System.out.printf("%s\n"
                                                        , student.getCourses()
                                                                .get(0)
                                                                .getSemester());
                                            }
                                        }
                                    }
                                }
                                case 'L' -> {
                                    y = false;
                                    System.out.println("Registrar " +
                                            "logged out. ");
                                }
                            }
                        }
                    } else {
                        System.out.printf("\nWelcome %s. \n",
                                database.get(webID).getName());
                        System.out.println("""
                                Options:

                                    A) Add a class

                                    D) Drop a class

                                    C) View your classes sorted by course name
                                    /department

                                    S) View your courses sorted by semester
                                """);
                        boolean z = true;
                        while (z) {
                            System.out.println("Please select an option: ");
                            char choiceLA = sc.next().charAt(0);
                            try {
                                if (choiceLA >= '0' && choiceLA <= '9') {
                                    throw new Exception("Bad input! ");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                            choiceLA = Character.toUpperCase(choiceLA);
                            switch (choiceLA) {
                                case 'A' -> {
                                    System.out.println("Please enter course " +
                                            "name: ");
                                    sc.nextLine();
                                    String courseName = sc.nextLine()
                                            .toUpperCase();
                                    String[] courseArray = courseName.split
                                            (" ", 2);
                                    if (courseArray[1].length() > 3) {
                                        throw new IllegalArgumentException();
                                    }
                                    int courseInt = Integer.parseInt
                                            (courseArray[1]);
                                    if (courseInt > 999) {
                                        throw new IllegalArgumentException();
                                    }
                                    String courseLetters = courseArray[0]
                                            .toUpperCase();
                                    System.out.println("Please select a " +
                                            "semester: ");
                                    String semester = sc.nextLine()
                                            .toUpperCase();
                                    if (semester.length() > 5) {
                                        throw new IllegalArgumentException();
                                    }
                                    Course addCourse = new Course(courseLetters
                                            , courseInt, semester);
                                    if (database.get(webID).getCourses()
                                            == null){
                                        ArrayList<Course> courses =
                                                new ArrayList<>(0);
                                        courses.add(addCourse);
                                        database.get(webID).setCourses(courses);
                                    } else{
                                        database.get(webID).getCourses()
                                                .add(addCourse);
                                    }
                                    System.out.printf("%s added in %s. \n",
                                            courseName, addCourse
                                                    .getSemesterWords());
                                }
                                case 'D' -> {
                                    System.out.println("Please enter " +
                                            "course name: ");
                                    sc.nextLine();
                                    String courseName = sc.nextLine();
                                    String[] courseArray = courseName
                                            .split(" ", 2);
                                    if (database.get(webID).getCourses()
                                            == null){
                                        throw new IllegalArgumentException();
                                    }
                                    if (courseArray[1].length() > 3) {
                                        throw new IllegalArgumentException();
                                    }
                                    int courseInt = Integer
                                            .parseInt(courseArray[1]);
                                    if (courseInt > 999) {
                                        throw new IllegalArgumentException();
                                    }
                                    String courseLetters = courseArray[0]
                                            .toUpperCase();
                                    int courseNum = Integer
                                            .parseInt(courseArray[1]);
                                    String semester = "";
                                    if (database.get(webID).getCourses()
                                            .size() == 1){
                                        if (database.get(webID).getCourses()
                                                .get(0).getDepartment()
                                                .equals(courseLetters)
                                                && database.get(webID)
                                                .getCourses().get(0)
                                                .getNumber() == courseNum){
                                            database.get(webID).getCourses()
                                                    .remove(database.get(webID)
                                                            .getCourses()
                                                            .get(0));
                                            semester = database.get(webID)
                                                    .getCourses().get(0)
                                                    .getSemesterWords();
                                            System.out.printf("%s dropped " +
                                                    "from %s. \n", courseName,
                                                    semester);
                                        }
                                    }else {
                                        boolean found = false;
                                        boolean go = true;
                                        while (go){
                                            for (Course course : database
                                                    .get(webID).getCourses()) {
                                                if (course.getDepartment()
                                                        .equals(courseLetters)
                                                        && course.getNumber()
                                                        == courseNum) {
                                                    database.get(webID)
                                                            .getCourses()
                                                            .remove(course);
                                                    semester = course
                                                            .getSemesterWords();
                                                    found = true;
                                                    System.out.printf("%s " +
                                                            "dropped from " +
                                                            "%s. \n",
                                                            courseName,
                                                            semester);
                                                    break;
                                                }
                                            }
                                            go = false;
                                        }
                                        if (!found){
                                            System.out.println("Course " +
                                                    "not found! ");
                                        }
                                    }
                                }
                                case 'C' -> {
                                    System.out.println("""
                                            Dept. Course Semester
                                            -------------------------------""");
                                    ArrayList<Course> listCourse = database
                                            .get(webID).getCourses();
                                    Collections.sort(listCourse, new
                                            CourseNameComparator());
                                    for (Course course : listCourse) {
                                        System.out.printf("%s   %s    %s\n",
                                                course.getDepartment(),
                                                course.getNumber(),
                                                course.getSemester());
                                    }
                                    System.out.println();
                                }
                                case 'S' -> {
                                    System.out.println("""
                                            Dept. Course Semester
                                            -------------------------------""");
                                    List<Course> listCourse = database
                                            .get(webID).getCourses();
                                    Collections.sort(listCourse, new
                                            SemesterComparator());
                                    for (Course course : listCourse) {
                                        System.out.printf("%s   %s    %s\n",
                                                course.getDepartment(),
                                                course.getNumber(),
                                                course.getSemester());
                                    }
                                    System.out.println();
                                }
                                case 'L' -> {
                                    z = false;
                                    System.out.printf("%s logged out. ", webID);
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
                case 'X' -> {
                    FileOutputStream fileOutput
                            = new FileOutputStream("Lunar.ser");
                    ObjectOutputStream outStream
                            = new ObjectOutputStream(fileOutput);
                    outStream.writeObject(database);
                    outStream.close();
                    System.out.println("System state saved, " +
                            "system shut down for maintenance.");
                    x = false;
                }
                case 'Q' -> {
                    x = false;
                    System.out.println("Good bye, please pick " +
                            "the right SUNY next time!");
                }
            }
        }
    }
}
