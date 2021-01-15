/**
 * 
 */
package com.fin.advisor.service;

import static com.fin.advisor.constant.ApplicationConstant.YES_FLAG;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fin.advisor.dto.RiskLevelDTO;
import com.fin.advisor.entity.RiskLevel;
import com.fin.advisor.repository.RiskLevelRepo;

/**
 * @author rajesh.kumar
 * Service Impl class for Risk Levels. 
 */
@Service
public class RiskServiceImpl implements RiskService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RiskLevelRepo riskLevelRepo;

	List<RiskLevelDTO> riskLevelDTOList = new ArrayList<>();

	/**
	 * Method to get Risk Levels from cache.
	 * 
	 * @return List<RiskLevel>
	 */
	public List<RiskLevelDTO> getRiskLevels() {
		if (ObjectUtils.isEmpty(riskLevelDTOList)) {
			fetchRiskLevelsFromDb();
		}
		logger.info("riskLevelDTOList size: "+riskLevelDTOList.size());
		return riskLevelDTOList;
	}

	/**
	 * Method to fetch Risk Levels from database
	 */
	
	@PostConstruct
	public void fetchRiskLevelsFromDb() {
		convertToRiskLevelDTO(riskLevelRepo.findByActiveFlag(YES_FLAG));
	}
	
	private void convertToRiskLevelDTO(List<RiskLevel> riskLevelList ) {
		riskLevelList.stream().forEach(x -> {
			RiskLevelDTO riskLevelDTO = new RiskLevelDTO();
			riskLevelDTO.setTolerance_level(x.getId());
			riskLevelDTO.setBonds_share(x.getBonds());
			riskLevelDTO.setLarge_cap_share(x.getLargeCap());
			riskLevelDTO.setMid_cap_share(x.getMidCap());
			riskLevelDTO.setForeign_cap_share(x.getForeignCap());
			riskLevelDTO.setSmall_cap_share(x.getSmallCap());
			riskLevelDTOList.add(riskLevelDTO);
		});
	}

	@Override
	public RiskLevelDTO getRiskToleranceData(Integer riskToleranceScore) {
		if (ObjectUtils.isEmpty(riskLevelDTOList)) {
			fetchRiskLevelsFromDb();
		}
		System.out.println("size:: "+riskLevelDTOList.size());
		return riskLevelDTOList.get(riskToleranceScore-1);
	}
}
