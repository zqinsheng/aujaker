package org.konghao.aujaker.repository;

import org.konghao.aujaker.model.Special;
import org.konghao.reposiotry.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ISpecialRepository extends BaseRepository<Special,String>,JpaSpecificationExecutor<Special> {

}