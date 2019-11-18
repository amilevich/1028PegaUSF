package come.example.sorting;

import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {

	public int compare(Student s1, Student s2) {
		// TODO Auto-generated method stub
		if(s1.getName().compareTo(s2.getName()) > 0) {
			return 1;
		} else if(s1.getName().compareTo(s2.getName()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	

}