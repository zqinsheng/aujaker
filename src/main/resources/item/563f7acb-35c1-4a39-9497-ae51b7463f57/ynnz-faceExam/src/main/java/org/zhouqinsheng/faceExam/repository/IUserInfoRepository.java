package org.zhouqinsheng.faceExam.repository;

import org.zhouqinsheng.faceExam.model.UserInfo;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IUserInfoRepository extends BaseRepository<UserInfo,String>,JpaSpecificationExecutor<UserInfo> {

}