package org.konghao.aujaker.repository;

import org.konghao.aujaker.model.StudentSpecial;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IStudentSpecialRepository extends BaseRepository<StudentSpecial,String>,JpaSpecificationExecutor<StudentSpecial> {

}