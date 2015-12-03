package cn.springmvc.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.springmvc.model.Student;
import cn.springmvc.service.StudentService;
import cn.springmvc.service.impl.StudentServiceImpl;

public class StudentTest {
	private StudentService studentService;
@Before
public void before(){
	@SuppressWarnings("resource")
	ApplicationContext context=new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring-mybatis.xml"});
	studentService=(StudentServiceImpl)context.getBean("StudentServiceImpl");
}
@Test
public void addStu(){
	Student stu=new Student();
	stu.setStuName("233333");
	studentService.insertStu(stu);
}
@Test
public void deleteStu(){
	studentService.deleteStu(2);
}
@Test
public void updateStu(){
	Student stu=new Student();
	//long������ʱ�����ֱ��new date().gettime���Ի�ȡ
	stu.setCreateAt(new Date().getTime());
	stu.setStuName("nama");
	studentService.updateStu(stu);
}
@Test
public void selectAllStu(){
	Student stu=studentService.selectAllstu();
	System.out.println(stu.getStuName());
}
@Test
public void selectByParam(){
	Student stu=new Student();
	stu.setStuName("na");
	List<Student> list=studentService.selectByParam(stu);
	for (Student student:list) {
		System.out.println(student.getStuName()+"~~~");
	}
}
}
