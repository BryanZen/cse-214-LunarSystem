/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-11-16
 */

import java.util.Comparator;
import java.io.Serializable;

/**
 *Write a fully-documented class named Semester that allows us to compare two
 * courses based on the semester they were offered. The SemesterComparator
 * class should implement the Comparator interface and override the
 * compare method.
 */
public class SemesterComparator implements Comparator<Course>, Serializable {

    /**
     * @param left the left course we are comparing
     * @param right the right course we are comparing
     * @return Should return: -1 if the left course’s semester is less than
     * the right, 0 if the semesters are equal, and 1 if the left’s
     * semester is greater than the right.
     */
    @Override public int compare(Course left, Course right){
        String leftSeason = String.valueOf(left.getSemester().charAt(0))
                .toUpperCase();
        int leftYear = left.getYear();
        String rightSeason = String.valueOf(right.getSemester().charAt(0))
                .toUpperCase();
        int rightYear = right.getYear();
        int retVal = 0;
        if (leftSeason.equals("S") && rightSeason.equals("F")){
            retVal = 1;
        }else if (leftSeason.equals("F") && rightSeason.equals("S")){
            retVal = -1;
        }else {
            if (leftYear > rightYear){
                retVal = 1;
            }
            if (leftYear < rightYear){
                retVal = -1;
            }
        }
        return retVal;
    }
}
