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
public class StudentSpecialService implements IStudentSpecialService {

	@Autowired
	private IStudentSpecialRepository studentSpecialRepository;

	/**
	 * 添加学生对象
	 * 
	 */
	@Transactional
	@Override
	public void add(StudentSpecial t) {
		studentSpecialRepository.save(t);
	}
	/**
	 * 更新学生对象
	 * 
	 */
	@Transactional
	@Override
	public void update(StudentSpecial t) {
		studentSpecialRepository.save(t);
	}
	/**
	 * 删除学生对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(String id) {
		studentSpecialRepository.delete(id);
	}
	/**
	 * 加载学生对象
	 * 
	 */
	@Override
	public StudentSpecial load(String id) {
		 return studentSpecialRepository.findOne(id);
	}
	/**
	 * 获取所有的学生对象,不进行分页
	 * 
	 */
	@Override
	public List<StudentSpecial> list() {
		 return studentSpecialRepository.findAll();
	}
	/**
	 * 获取所有的学生对象,进行分页
	 * 
	 */
	@Override
	public Page<StudentSpecial> find(Pageable page) {
		 return studentSpecialRepository.findAll(page);
	}
}
