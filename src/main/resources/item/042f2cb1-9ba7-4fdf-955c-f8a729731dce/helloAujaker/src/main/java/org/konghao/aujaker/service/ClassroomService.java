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
public class ClassroomService implements IClassroomService {

	@Autowired
	private IClassroomRepository classroomRepository;

	/**
	 * 添加班级对象
	 * 
	 */
	@Transactional
	@Override
	public void add(Classroom t) {
		classroomRepository.save(t);
	}
	/**
	 * 更新班级对象
	 * 
	 */
	@Transactional
	@Override
	public void update(Classroom t) {
		classroomRepository.save(t);
	}
	/**
	 * 删除班级对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(Integer id) {
		classroomRepository.delete(id);
	}
	/**
	 * 加载班级对象
	 * 
	 */
	@Override
	public Classroom load(Integer id) {
		 return classroomRepository.findOne(id);
	}
	/**
	 * 获取所有的班级对象,不进行分页
	 * 
	 */
	@Override
	public List<Classroom> list() {
		 return classroomRepository.findAll();
	}
	/**
	 * 获取所有的班级对象,进行分页
	 * 
	 */
	@Override
	public Page<Classroom> find(Pageable page) {
		 return classroomRepository.findAll(page);
	}
}
