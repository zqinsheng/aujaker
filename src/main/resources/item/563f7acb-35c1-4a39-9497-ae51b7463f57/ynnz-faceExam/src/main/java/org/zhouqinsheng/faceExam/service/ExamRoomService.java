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
public class ExamRoomService implements IExamRoomService {

	@Autowired
	private IExamRoomRepository examRoomRepository;

	/**
	 * 添加考场对象
	 * 
	 */
	@Transactional
	@Override
	public void add(ExamRoom t) {
		examRoomRepository.save(t);
	}
	/**
	 * 更新考场对象
	 * 
	 */
	@Transactional
	@Override
	public void update(ExamRoom t) {
		examRoomRepository.save(t);
	}
	/**
	 * 删除考场对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(String id) {
		examRoomRepository.delete(id);
	}
	/**
	 * 加载考场对象
	 * 
	 */
	@Override
	public ExamRoom load(String id) {
		 return examRoomRepository.findOne(id);
	}
	/**
	 * 获取所有的考场对象,不进行分页
	 * 
	 */
	@Override
	public List<ExamRoom> list() {
		 return examRoomRepository.findAll();
	}
	/**
	 * 获取所有的考场对象,进行分页
	 * 
	 */
	@Override
	public Page<ExamRoom> find(Pageable page) {
		 return examRoomRepository.findAll(page);
	}
}
