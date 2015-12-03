package cn.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.springmvc.dao.StudentDAO;
import cn.springmvc.model.Student;
import cn.springmvc.service.StudentService;
@Service(value="StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
	@Autowired
StudentDAO studentDAO;
	public int insertStu(Student stu) {
		// TODO Auto-generated method stub
		return studentDAO.insertStun(stu);
	}
	public int updateStu(Student stu) {
		// TODO Auto-generated method stub
		return studentDAO.updateStun(stu);
	}
	public int deleteStu(int id) {
		// TODO Auto-generated method stub
		return studentDAO.deleteStun(id);
	}
	public Student selectAllstu() {
		// TODO Auto-generated method stub
		return studentDAO.selectAllstu();
	}
	public List selectByParam(Student stu) {
		// TODO Auto-generated method stub
		return studentDAO.selectByParam(stu);
	}

}
