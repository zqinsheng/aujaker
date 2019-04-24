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
public class ExamInfoService implements IExamInfoService {

	@Autowired
	private IExamInfoRepository examInfoRepository;

	/**
	 * 添加考试对象
	 * 
	 */
	@Transactional
	@Override
	public void add(ExamInfo t) {
		examInfoRepository.save(t);
	}
	/**
	 * 更新考试对象
	 * 
	 */
	@Transactional
	@Override
	public void update(ExamInfo t) {
		examInfoRepository.save(t);
	}
	/**
	 * 删除考试对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(String id) {
		examInfoRepository.delete(id);
	}
	/**
	 * 加载考试对象
	 * 
	 */
	@Override
	public ExamInfo load(String id) {
		 return examInfoRepository.findOne(id);
	}
	/**
	 * 获取所有的考试对象,不进行分页
	 * 
	 */
	@Override
	public List<ExamInfo> list() {
		 return examInfoRepository.findAll();
	}
	/**
	 * 获取所有的考试对象,进行分页
	 * 
	 */
	@Override
	public Page<ExamInfo> find(Pageable page) {
		 return examInfoRepository.findAll(page);
	}
}
