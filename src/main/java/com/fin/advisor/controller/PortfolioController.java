/**
 * 
 */
package com.fin.advisor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fin.advisor.dto.CustomPortfolioDTO;
import com.fin.advisor.dto.IdealPortfolioDTO;
import com.fin.advisor.service.PortfolioService;

/**
 * @author rajesh.kumar
 * Controller class to get or create portfolio
 */
@RestController
public class PortfolioController {
	
	@Autowired
	PortfolioService portfolioService;
	
	
	/**
	 * Method to get Ideal portfolio
	 * @param totalAmount
	 * @param riskToleranceScore
	 * @return IdealPortfolioDTO
	 */
	@GetMapping("/getIdealPortfolio")
	public IdealPortfolioDTO getIdealPortfolio(@RequestParam Double totalAmount, @RequestParam Integer riskToleranceScore) {
		return portfolioService.calculateIdealPortfolio(totalAmount, riskToleranceScore); 
	}
	
	/**
	 * Method to calculate custom portfolio
	 * @param customPortfolioDTO
	 * @return CustomPortfolioDTO
	 */
	@PostMapping("/calculateCustomPortfolio")
	public CustomPortfolioDTO getIdealPortfolio(@RequestBody CustomPortfolioDTO customPortfolioDTO) {
		return portfolioService.calculateCustomPortfolio(customPortfolioDTO); 
	}
}
