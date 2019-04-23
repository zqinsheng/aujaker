package org.konghao.aujaker.repository;

import org.konghao.aujaker.model.Student;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IStudentRepository extends BaseRepository<Student,Integer>,JpaSpecificationExecutor<Student> {

}