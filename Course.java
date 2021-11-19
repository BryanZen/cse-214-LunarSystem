/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-11-16
 */

import java.io.Serializable;

/**
 *Write a full-documented class named Course. Courses will be associated with
 * the Students that are taking them. Each course will have a designated
 * department (Ex. “CSE”), a three-digit course number (Ex. 214), and a
 * semester associated with it (Ex. “F2021”). As always, each data field
 * must have getters and setters. Must implement the Serializable interface.
 */
public class Course implements Serializable {
    private String department;
    private int number;
    private String semester;
    private String semesterWords;
    private int year;

    /**
     * Main constructor for the course class, creates a course object.
     * @param department the department of the course being assigned.
     *                   EX: CSE 114, CSE is department
     * @param number the number for this class EX: 114
     * @param semester the semester that the class is being taken in
     */
    public Course(String department, int number, String semester){
        this.department = department;
        this.number = number;
        this.semester = semester;
        setSemesterWords(semester);
        setYear(semester);
    }

    /**
     * gets the department of the course
     * @return the department as string
     */
    public String getDepartment(){
        return department;
    }

    /**
     * sets the department of the course
     * @param department is the new department
     */
    public void setDepartment(String department){
        this.department = department;
    }

    /**
     * gets the number of the course
     * @return the number as an int
     */
    public int getNumber(){
        return number;
    }

    /**
     * sets the number of the course
     * @param number is the new number
     */
    public void setNumber(int number){
        this.number = number;
    }

    /**
     *
     * @return
     */
    public String getSemester(){
        return semester;
    }

    /**
     *
     * @param semester
     */
    public void setSemester(String semester){
        this.semester = semester;
    }

    /**
     *
     * @return
     */
    public String getSemesterWords() {
        return semesterWords;
    }

    /**
     *
     * @param semester
     */
    public void setSemesterWords(String semester) {
        String[] semesterArray = semester.split("", semester.length());
        String semesterWords = "";
        if (semesterArray[0].equalsIgnoreCase("S")){
            semesterWords = "Spring " + semesterArray[1] + semesterArray[2]
                    + semesterArray[3] + semesterArray[4];
        } else if (semesterArray[0].equalsIgnoreCase("F")){
            semesterWords = "Fall " + semesterArray[1] + semesterArray[2]
                    + semesterArray[3] + semesterArray[4];
        }
        this.semesterWords = semesterWords;
    }

    /**
     *
     * @return
     */
    public int getYear() {
        return year;
    }
    public void setYear(String semester) {
        String[] semesterYear = semester.split("", semester.length());
        String yearS = semesterYear[1] + semesterYear[2] + semesterYear[3]
                + semesterYear[4];
        this.year = Integer.parseInt(yearS);
    }
}
