package org.zhouqinsheng.faceExam.repository;

import org.zhouqinsheng.faceExam.model.ExamRoom;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IExamRoomRepository extends BaseRepository<ExamRoom,String>,JpaSpecificationExecutor<ExamRoom> {

}