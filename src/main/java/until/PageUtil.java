package until;

import java.util.ArrayList;
import java.util.List;

import cn.springmvc.model.Student;


public class PageUtil {
	public static List<Student> studentPage(List<Student> students, int page,
			int size) {
		List<Student> list = new ArrayList<Student>();
		for (int i = page * size; i < (page + 1) * size && i < students.size(); i++) {
			list.add(students.get(i));
		}
		return list;
	}
}
