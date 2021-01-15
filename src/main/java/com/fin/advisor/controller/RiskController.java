/**
 * 
 */
package com.fin.advisor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fin.advisor.dto.RiskLevelDTO;
import com.fin.advisor.service.RiskService;

/**
 * @author rajesh.kumar
 * Controller class to fetch Risk Levels.
 */
@RestController
public class RiskController {

	@Autowired
	RiskService riskService;
	
	/**
	 *  Method to fetch Risk Levels.
	 * @return List<RiskLevelDTO>
	 */
	@GetMapping("/riskLevels")
	public List<RiskLevelDTO> getRiskLevel() {
		return riskService.getRiskLevels();
	}
	
	
}
