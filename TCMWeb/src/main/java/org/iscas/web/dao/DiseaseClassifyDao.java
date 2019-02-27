package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.iscas.web.entity.DiseaseClassify;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface DiseaseClassifyDao extends JpaRepository<DiseaseClassify,Long> {
}
