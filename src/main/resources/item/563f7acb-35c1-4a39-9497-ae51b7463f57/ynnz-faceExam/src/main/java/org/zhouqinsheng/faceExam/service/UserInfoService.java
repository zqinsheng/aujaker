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
public class UserInfoService implements IUserInfoService {

	@Autowired
	private IUserInfoRepository userInfoRepository;

	/**
	 * 添加用户对象
	 * 
	 */
	@Transactional
	@Override
	public void add(UserInfo t) {
		userInfoRepository.save(t);
	}
	/**
	 * 更新用户对象
	 * 
	 */
	@Transactional
	@Override
	public void update(UserInfo t) {
		userInfoRepository.save(t);
	}
	/**
	 * 删除用户对象
	 * 
	 */
	@Transactional
	@Override
	public void delete(String id) {
		userInfoRepository.delete(id);
	}
	/**
	 * 加载用户对象
	 * 
	 */
	@Override
	public UserInfo load(String id) {
		 return userInfoRepository.findOne(id);
	}
	/**
	 * 获取所有的用户对象,不进行分页
	 * 
	 */
	@Override
	public List<UserInfo> list() {
		 return userInfoRepository.findAll();
	}
	/**
	 * 获取所有的用户对象,进行分页
	 * 
	 */
	@Override
	public Page<UserInfo> find(Pageable page) {
		 return userInfoRepository.findAll(page);
	}
}
