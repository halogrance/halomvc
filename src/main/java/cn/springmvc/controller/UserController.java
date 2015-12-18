package cn.springmvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import cn.springmvc.model.Student;
import cn.springmvc.service.impl.StudentServiceImpl;
import until.PageUtil;

@Controller
@RequestMapping("/")
public class UserController {

	@RequestMapping("index2")
	public String index(){
		return "index2";
	}
	@Autowired
	StudentServiceImpl studentServiceImpl;
	@RequestMapping(value="/serch",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView serchStu(HttpServletResponse response) throws IOException{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Student/serch");
		Map stuMap=new HashMap();
		Student stu=studentServiceImpl.selectAllstu();
//		for (int i = 0; i < stulist.size(); i++) {
//			Student stu=(Student)stulist.get(i);
//			stuMap.put("stu1", stu);
//		}
		mav.addObject("stu", stuMap);
//		JSONArray json = JSONArray.fromObject(map);
//		return json;
		return mav;
		
	}
	@RequestMapping(value = "student/login", method = RequestMethod.GET)
	public String loginUser(){
		return "login";
	}
	@RequestMapping(value = "/u/student", method = RequestMethod.GET)
	public String getStudents(
			ModelMap mm,
			@RequestParam(value = "page", required = false, defaultValue = "0") int page,
			@RequestParam(value = "size", required = false, defaultValue = "10") int size) {
		Student stu =new Student();
		List<Student> students =studentServiceImpl.selectByParam(stu);
		if(students != null){
			mm.put("students", PageUtil.studentPage(students, page, size));
		}else{
			mm.put("students", null);
		}
		mm.put("title", "studentList");
		mm.put("currentPage", page);
		int totalCount = 0;
		if (students != null) {
			totalCount = students.size();
		}
		mm.put("totalCount", totalCount);
		return "index";
	}
	@RequestMapping("reAdd")
	public String reAdd() {
		return "stuAdd";
	}
	@RequestMapping("regUser")
	public String regUser() {
		return "register";
	}
	@RequestMapping(value = "student", method = RequestMethod.POST)
	public String postStudent(Student student) {
		student.setCreateAt(System.currentTimeMillis());
		this.studentServiceImpl.insertStu(student);
		return "redirect:/u/student";
	}
//	@RequestMapping(value = "student/{id}", method = RequestMethod.POST)
//	public String putStudent(Student student, @PathVariable int id) {
//		student.setId(id);
//		student.setUpdateAt(System.currentTimeMillis());
//		this.studentServiceImpl.updateStu(student);
//		return "redirect:/api/student";
//	}
//	@RequestMapping("student/edit/{id}")
//	public String reEdit(ModelMap mm, @PathVariable int id) {
//		Student stu =new Student();
//		stu.setId(id);
//		Student student = (Student)this.studentServiceImpl.selectByParam(stu).get(0);
//		mm.put("student", student);
//		mm.put("title", "studentEdit");
//		return "stuEdit";
//	}
}

