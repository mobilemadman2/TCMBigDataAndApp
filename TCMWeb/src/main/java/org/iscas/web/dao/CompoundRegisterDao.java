package org.iscas.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.iscas.web.entity.CompoundRegister;
import org.iscas.web.entity.NaturalMedicine;
import org.iscas.web.entity.Prescription;

/**
 * Created by suemi on 17-7-1.
 */
@Repository
public interface CompoundRegisterDao extends JpaRepository<CompoundRegister,Long> {
	CompoundRegister findByAccessNo(String accessNo);
}