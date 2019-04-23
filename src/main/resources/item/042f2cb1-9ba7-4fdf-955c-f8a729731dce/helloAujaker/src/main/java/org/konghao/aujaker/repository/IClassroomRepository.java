package org.konghao.aujaker.repository;

import org.konghao.aujaker.model.Classroom;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IClassroomRepository extends BaseRepository<Classroom,Integer>,JpaSpecificationExecutor<Classroom> {

}