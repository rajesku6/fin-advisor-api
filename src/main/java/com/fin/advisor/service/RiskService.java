/**
 * 
 */
package com.fin.advisor.service;

import java.util.List;

import com.fin.advisor.dto.RiskLevelDTO;

/**
 * @author rajesh.kumar
 * Service Interface for Risk Levels.
 */
public interface RiskService {

	/**
	 * Method to fetch risk levels.
	 * @return List<RiskLevelDTO>
	 */
	public List<RiskLevelDTO> getRiskLevels();
	
	/**
	 * Method to fetch risk level for a specific risk tolerance score.
	 * @param riskToleranceScore
	 * @return  RiskLevelDTO
	 */
	public RiskLevelDTO getRiskToleranceData(Integer riskToleranceScore);
}
