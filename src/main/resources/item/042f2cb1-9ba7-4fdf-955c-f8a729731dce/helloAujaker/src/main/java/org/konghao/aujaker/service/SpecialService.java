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
public class SpecialService implements ISpecialService {

	@Autowired
	private ISpecialRepository specialRepository;

	/**
	 * 添加专业对象
	 * 
	 */
	@Transactional
	@Override
	public void add(Special t) {
		specialRepository.save(t);
	}
	/**
	 * 更新专业对象
	 * 
	 */
	@Transactional
	@Override
	public void update(Special t) {
		specialRepository.save(t);
	}
	/**
	 * 删除专业对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(String id) {
		specialRepository.delete(id);
	}
	/**
	 * 加载专业对象
	 * 
	 */
	@Override
	public Special load(String id) {
		 return specialRepository.findOne(id);
	}
	/**
	 * 获取所有的专业对象,不进行分页
	 * 
	 */
	@Override
	public List<Special> list() {
		 return specialRepository.findAll();
	}
	/**
	 * 获取所有的专业对象,进行分页
	 * 
	 */
	@Override
	public Page<Special> find(Pageable page) {
		 return specialRepository.findAll(page);
	}
}
