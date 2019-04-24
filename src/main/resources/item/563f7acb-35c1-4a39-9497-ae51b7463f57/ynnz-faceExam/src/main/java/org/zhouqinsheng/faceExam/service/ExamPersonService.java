package org.zhouqinsheng.faceExam.service;

import org.zhouqinsheng.faceExam.repository.*;
import org.zhouqinsheng.faceExam.model.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamPersonService implements IExamPersonService {

	@Autowired
	private IExamPersonRepository examPersonRepository;

	/**
	 * 添加考生对象
	 * 
	 */
	@Transactional
	@Override
	public void add(ExamPerson t) {
		examPersonRepository.save(t);
	}
	/**
	 * 更新考生对象
	 * 
	 */
	@Transactional
	@Override
	public void update(ExamPerson t) {
		examPersonRepository.save(t);
	}
	/**
	 * 删除考生对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(String id) {
		examPersonRepository.delete(id);
	}
	/**
	 * 加载考生对象
	 * 
	 */
	@Override
	public ExamPerson load(String id) {
		 return examPersonRepository.findOne(id);
	}
	/**
	 * 获取所有的考生对象,不进行分页
	 * 
	 */
	@Override
	public List<ExamPerson> list() {
		 return examPersonRepository.findAll();
	}
	/**
	 * 获取所有的考生对象,进行分页
	 * 
	 */
	@Override
	public Page<ExamPerson> find(Pageable page) {
		 return examPersonRepository.findAll(page);
	}
}
