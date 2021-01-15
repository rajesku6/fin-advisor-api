/**
 * 
 */
package com.fin.advisor.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rajesh.kumar
 * DTO class for Custom Portfolio
 */
public class CustomPortfolioDTO{
	private Integer tolerance_level;

	private Double bonds_custom_val;
	private Double large_cap_custom_val;
    private Double mid_cap_custom_val;
    private Double foreign_cap_custom_val;
    private Double small_cap_custom_val;
    
    private Double bonds_diff_val;
	private Double large_cap_diff_val;
    private Double mid_cap_diff_val;
    private Double foreign_cap_diff_val;
    private Double small_cap_dif_val;
    
    private IdealPortfolioDTO idealPortfolioDTO;
    private List<String> recommendedTransferList = new ArrayList<>();


	/**
	 * @return the bonds_custom_val
	 */
	public Double getBonds_custom_val() {
		return bonds_custom_val;
	}


	/**
	 * @param bonds_custom_val the bonds_custom_val to set
	 */
	public void setBonds_custom_val(Double bonds_custom_val) {
		this.bonds_custom_val = bonds_custom_val;
	}


	/**
	 * @return the large_cap_custom_val
	 */
	public Double getLarge_cap_custom_val() {
		return large_cap_custom_val;
	}


	/**
	 * @param large_cap_custom_val the large_cap_custom_val to set
	 */
	public void setLarge_cap_custom_val(Double large_cap_custom_val) {
		this.large_cap_custom_val = large_cap_custom_val;
	}


	/**
	 * @return the mid_cap_custom_val
	 */
	public Double getMid_cap_custom_val() {
		return mid_cap_custom_val;
	}


	/**
	 * @param mid_cap_custom_val the mid_cap_custom_val to set
	 */
	public void setMid_cap_custom_val(Double mid_cap_custom_val) {
		this.mid_cap_custom_val = mid_cap_custom_val;
	}


	/**
	 * @return the foreign_cap_custom_val
	 */
	public Double getForeign_cap_custom_val() {
		return foreign_cap_custom_val;
	}


	/**
	 * @param foreign_cap_custom_val the foreign_cap_custom_val to set
	 */
	public void setForeign_cap_custom_val(Double foreign_cap_custom_val) {
		this.foreign_cap_custom_val = foreign_cap_custom_val;
	}


	/**
	 * @return the small_cap_custom_val
	 */
	public Double getSmall_cap_custom_val() {
		return small_cap_custom_val;
	}


	/**
	 * @param small_cap_custom_val the small_cap_custom_val to set
	 */
	public void setSmall_cap_custom_val(Double small_cap_custom_val) {
		this.small_cap_custom_val = small_cap_custom_val;
	}


	/**
	 * @return the bonds_diff_val
	 */
	public Double getBonds_diff_val() {
		return bonds_diff_val;
	}


	/**
	 * @param bonds_diff_val the bonds_diff_val to set
	 */
	public void setBonds_diff_val(Double bonds_diff_val) {
		this.bonds_diff_val = bonds_diff_val;
	}


	/**
	 * @return the large_cap_diff_val
	 */
	public Double getLarge_cap_diff_val() {
		return large_cap_diff_val;
	}


	/**
	 * @param large_cap_diff_val the large_cap_diff_val to set
	 */
	public void setLarge_cap_diff_val(Double large_cap_diff_val) {
		this.large_cap_diff_val = large_cap_diff_val;
	}


	/**
	 * @return the mid_cap_diff_val
	 */
	public Double getMid_cap_diff_val() {
		return mid_cap_diff_val;
	}


	/**
	 * @param mid_cap_diff_val the mid_cap_diff_val to set
	 */
	public void setMid_cap_diff_val(Double mid_cap_diff_val) {
		this.mid_cap_diff_val = mid_cap_diff_val;
	}


	/**
	 * @return the foreign_cap_diff_val
	 */
	public Double getForeign_cap_diff_val() {
		return foreign_cap_diff_val;
	}


	/**
	 * @param foreign_cap_diff_val the foreign_cap_diff_val to set
	 */
	public void setForeign_cap_diff_val(Double foreign_cap_diff_val) {
		this.foreign_cap_diff_val = foreign_cap_diff_val;
	}


	/**
	 * @return the small_cap_dif_val
	 */
	public Double getSmall_cap_dif_val() {
		return small_cap_dif_val;
	}


	/**
	 * @param small_cap_dif_val the small_cap_dif_val to set
	 */
	public void setSmall_cap_dif_val(Double small_cap_dif_val) {
		this.small_cap_dif_val = small_cap_dif_val;
	}


	/**
	 * @return the recommendedTransferList
	 */
	public List<String> getRecommendedTransferList() {
		return recommendedTransferList;
	}


	/**
	 * @param recommendedTransferList the recommendedTransferList to set
	 */
	public void setRecommendedTransferList(List<String> recommendedTransferList) {
		this.recommendedTransferList = recommendedTransferList;
	}


	/**
	 * @return the idealPortfolioDTO
	 */
	public IdealPortfolioDTO getIdealPortfolioDTO() {
		return idealPortfolioDTO;
	}


	/**
	 * @param idealPortfolioDTO the idealPortfolioDTO to set
	 */
	public void setIdealPortfolioDTO(IdealPortfolioDTO idealPortfolioDTO) {
		this.idealPortfolioDTO = idealPortfolioDTO;
	}


	/**
	 * @return the tolerance_level
	 */
	public Integer getTolerance_level() {
		return tolerance_level;
	}


	/**
	 * @param tolerance_level the tolerance_level to set
	 */
	public void setTolerance_level(Integer tolerance_level) {
		this.tolerance_level = tolerance_level;
	}
    
    
    
    
}
