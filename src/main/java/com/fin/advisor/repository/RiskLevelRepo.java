package com.fin.advisor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fin.advisor.entity.RiskLevel;

/**
 * @author rajesh.kumar
 * Repository Interface for Risk Levels
 */
public interface RiskLevelRepo  extends JpaRepository<RiskLevel, Long> {

	/**
	 * Method to fetch all active Risk Levels data.
	 * @param activeFlag
	 * @return List<RiskLevel>
	 */
	public List<RiskLevel> findByActiveFlag(String activeFlag);
}
