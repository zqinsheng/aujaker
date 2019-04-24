package org.zhouqinsheng.faceExam.repository;

import org.zhouqinsheng.faceExam.model.ExamPerson;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IExamPersonRepository extends BaseRepository<ExamPerson,String>,JpaSpecificationExecutor<ExamPerson> {

}