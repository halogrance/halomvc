package cn.springmvc.dao;

import java.util.List;

import cn.springmvc.model.Student;

public interface StudentDAO {
public int insertStun(Student stu);
public int updateStun(Student stu);
public int deleteStun(int id);
public Student selectAllstu();
public List selectByParam(Student stu);
}
