package cn.springmvc.service;

import java.util.List;

import cn.springmvc.model.Student;

public interface StudentService {
	public int insertStu(Student stu);
	public int updateStu(Student stu);
	public int deleteStu(int id);
	public Student selectAllstu();
	public List selectByParam(Student stu);
}
