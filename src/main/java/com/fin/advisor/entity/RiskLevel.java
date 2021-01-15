/**
 * 
 */
package com.fin.advisor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rajesh.kumar
 * Entity class for Risk Levels.
 *
 */

@Entity
@Table(name = "RISK_LEVEL")
public class RiskLevel {
	
	@Id
    @Column(name = "TELERANCE_LEVEL")
	private Long id;

	@Column(name = "BONDS")
	private Long bonds;
	
    @Column(name = "LARGE_CAP")
	private Long largeCap;

    @Column(name = "MID_CAP")
    private Long midCap;
	
    @Column(name = "FOREIGN_CAP")
    private Long foreignCap;

    @Column(name = "SMALL_CAP")
    private Long smallCap;
    
    @Column(name = "ACTIVE_FLAG")
    private String activeFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBonds() {
		return bonds;
	}

	public void setBonds(Long bonds) {
		this.bonds = bonds;
	}

	public Long getLargeCap() {
		return largeCap;
	}

	public void setLargeCap(Long largeCap) {
		this.largeCap = largeCap;
	}

	public Long getMidCap() {
		return midCap;
	}

	public void setMidCap(Long midCap) {
		this.midCap = midCap;
	}

	public Long getForeignCap() {
		return foreignCap;
	}

	public void setForeignCap(Long foreignCap) {
		this.foreignCap = foreignCap;
	}

	public Long getSmallCap() {
		return smallCap;
	}

	public void setSmallCap(Long smallCap) {
		this.smallCap = smallCap;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	
    
    
}
