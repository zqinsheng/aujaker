package org.zhouqinsheng.faceExam.repository;

import org.zhouqinsheng.faceExam.model.TeacherInfo;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ITeacherInfoRepository extends BaseRepository<TeacherInfo,String>,JpaSpecificationExecutor<TeacherInfo> {

}