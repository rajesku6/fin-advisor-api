package com.fin.advisor.dto;

/**
 * @author rajesh.kumar
 * DTO class for Ideal Portfolio
 */
public class IdealPortfolioDTO {
	
	private Integer tolerance_level;
	
	private Double total_amount;

	private Double bonds_cal_val;
	
	private Double large_cap_cal_val;

    private Double mid_cap_cal_val;
	
    private Double foreign_cap_cal_val;

    private Double small_cap_cal_val;

	public Integer getTolerance_level() {
		return tolerance_level;
	}

	public void setTolerance_level(Integer tolerance_level) {
		this.tolerance_level = tolerance_level;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public Double getBonds_cal_val() {
		return bonds_cal_val;
	}

	public void setBonds_cal_val(Double bonds_cal_val) {
		this.bonds_cal_val = bonds_cal_val;
	}

	public Double getLarge_cap_cal_val() {
		return large_cap_cal_val;
	}

	public void setLarge_cap_cal_val(Double large_cap_cal_val) {
		this.large_cap_cal_val = large_cap_cal_val;
	}

	public Double getMid_cap_cal_val() {
		return mid_cap_cal_val;
	}

	public void setMid_cap_cal_val(Double mid_cap_cal_val) {
		this.mid_cap_cal_val = mid_cap_cal_val;
	}

	public Double getForeign_cap_cal_val() {
		return foreign_cap_cal_val;
	}

	public void setForeign_cap_cal_val(Double foreign_cap_cal_val) {
		this.foreign_cap_cal_val = foreign_cap_cal_val;
	}

	public Double getSmall_cap_cal_val() {
		return small_cap_cal_val;
	}

	public void setSmall_cap_cal_val(Double small_cap_cal_val) {
		this.small_cap_cal_val = small_cap_cal_val;
	}

	
}
