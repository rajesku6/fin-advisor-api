/**
 * 
 */
package com.fin.advisor.service;

import com.fin.advisor.dto.CustomPortfolioDTO;
import com.fin.advisor.dto.IdealPortfolioDTO;

/**
 * @author rajesh.kumar
 * Service Interface for portfolio.
 */
public interface PortfolioService {
	/**
	 * Method to calculate ideal portfolio.
	 * @param totalAmount
	 * @param riskToleranceScore
	 * @return PortfolioDTO
	 */
	public IdealPortfolioDTO calculateIdealPortfolio(Double totalAmount, Integer riskToleranceScore);
	
	/**
	 * Method to calculate custom portfolio.
	 * @param customPortfolioDTO
	 * @return CustomPortfolioDTO
	 */
	public CustomPortfolioDTO calculateCustomPortfolio(CustomPortfolioDTO customPortfolioDTO);
	

}
