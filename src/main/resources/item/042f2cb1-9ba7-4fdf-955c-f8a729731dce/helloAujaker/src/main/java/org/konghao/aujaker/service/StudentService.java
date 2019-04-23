package org.konghao.aujaker.service;

import org.konghao.aujaker.repository.*;
import org.konghao.aujaker.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	/**
	 * 添加学生对象
	 * 
	 */
	@Transactional
	@Override
	public void add(Student t) {
		studentRepository.save(t);
	}
	/**
	 * 更新学生对象
	 * 
	 */
	@Transactional
	@Override
	public void update(Student t) {
		studentRepository.save(t);
	}
	/**
	 * 删除学生对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		studentRepository.delete(id);
	}
	/**
	 * 加载学生对象
	 * 
	 */
	@Override
	public Student load(Integer id) {
		 return studentRepository.findOne(id);
	}
	/**
	 * 获取所有的学生对象,不进行分页
	 * 
	 */
	@Override
	public List<Student> list() {
		 return studentRepository.findAll();
	}
	/**
	 * 获取所有的学生对象,进行分页
	 * 
	 */
	@Override
	public Page<Student> find(Pageable page) {
		 return studentRepository.findAll(page);
	}
}
