/**
 * 
 */
package com.fin.advisor.dto;

/**
 * @author rajesh.kumar
 * DTO class for Risk Level DTO
 */
public class RiskLevelDTO {
	
	private Long tolerance_level;

	private Long bonds_share;
	
	private Long large_cap_share;

    private Long mid_cap_share;
	
    private Long foreign_cap_share;

    private Long small_cap_share;


	public Long getTolerance_level() {
		return tolerance_level;
	}

	public void setTolerance_level(Long tolerance_level) {
		this.tolerance_level = tolerance_level;
	}

	public Long getBonds_share() {
		return bonds_share;
	}

	public void setBonds_share(Long bonds_share) {
		this.bonds_share = bonds_share;
	}

	public Long getLarge_cap_share() {
		return large_cap_share;
	}

	public void setLarge_cap_share(Long large_cap_share) {
		this.large_cap_share = large_cap_share;
	}

	public Long getMid_cap_share() {
		return mid_cap_share;
	}

	public void setMid_cap_share(Long mid_cap_share) {
		this.mid_cap_share = mid_cap_share;
	}

	public Long getForeign_cap_share() {
		return foreign_cap_share;
	}

	public void setForeign_cap_share(Long foreign_cap_share) {
		this.foreign_cap_share = foreign_cap_share;
	}

	public Long getSmall_cap_share() {
		return small_cap_share;
	}

	public void setSmall_cap_share(Long small_cap_share) {
		this.small_cap_share = small_cap_share;
	}
    
    

}
