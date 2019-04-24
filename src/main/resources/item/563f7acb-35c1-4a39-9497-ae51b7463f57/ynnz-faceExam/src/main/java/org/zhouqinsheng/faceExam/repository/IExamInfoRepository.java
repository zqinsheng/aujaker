package org.zhouqinsheng.faceExam.repository;

import org.zhouqinsheng.faceExam.model.ExamInfo;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IExamInfoRepository extends BaseRepository<ExamInfo,String>,JpaSpecificationExecutor<ExamInfo> {

}