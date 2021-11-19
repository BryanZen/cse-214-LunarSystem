/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-11-16
 */

import java.io.Serializable;
import java.util.ArrayList;

/**
 *Write a fully-documented class named Student that will serve as the stored
 * element of the Lunar System database. Each Student object includes a webID
 * and a list of courses the student has taken, and getters and setters for
 * each. Must implement the Serializable interface.
 */
public class Student implements Serializable {
    private String webID;
    private ArrayList<Course> courses;
    private String name;

    /**
     * This is an empty constructor for the student class, primarily used in
     * initialization when the student has no courses enrolled.
     */
    public Student(){

    }

    /**
     * This is the constructor for the student class
     * @param webID the key for this student in the hash map
     * @param name the name of the student, the webID disregarding case.
     * @param courses the array list of courses
     */
    public Student(String webID, String name, ArrayList<Course> courses){
        this.webID = webID;
        this.name = name;
        this.courses = courses;
    }

    /**
     * gets the webID for this student
     * @return the webID
     */
    public String getWebID() {
        return webID;
    }

    /**
     * sets the webID for the student
     * @param webID the new webID
     */
    public void setWebID(String webID) {
        this.webID = webID;
    }

    /**
     * gets the array list of courses for this student
     * @return the array list of courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * sets the array list of courses for this student
     * @param courses the new array list of courses
     */
    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    /**
     * gets the name of the student
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the student
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }
}
