/**
 * @Author Bryan Zen 113252725
 * @version 1.0
 * @since 2021-11-16
 */

import java.util.Comparator;
import java.io.Serializable;

/**
 *Write a fully-documented class named CourseNameComparator that allows us to
 * compare two course names with the following priority: department and then
 * number. The CourseNameComparator class should implement the Comparator
 * interface and override the compare method.
 */
public class CourseNameComparator implements Comparator<Course>, Serializable {

    /**
     * @param left the left course we are comparing
     * @param right the right course we are comparing
     * @return Should return: -1 if the left course name is “less” than the
     * right course name, 0 if they are equal, and 1 if the left course name
     * is “greater” than the right course.
     */
    public int compare(Course left, Course right){
        String leftDep = left.getDepartment();
        String[] leftDepArray = leftDep.split("", leftDep.length());
        int leftNum = left.getNumber();
        String rightDep = right.getDepartment();
        String[] rightDepArray = rightDep.split("", rightDep.length());
        int rightNum = right.getNumber();
        int retVal = 0;
        for (int i = 0; i < 3; i++){
            int res = leftDepArray[i].compareTo(rightDepArray[i]);
            if (res > 0){
                retVal = 1;
                break;
            }
            if (res < 0){
                retVal = -1;
                break;
            }
        }
        if (retVal == 0){
            if (leftNum > rightNum){
                retVal = 1;
            }
            if (leftNum < rightNum){
                retVal = -1;
            }
        }
        return retVal;
    }
}
