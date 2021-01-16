/**
 * 
 */
package com.fin.advisor.service;

import static com.fin.advisor.constant.ApplicationConstant.BONDS_STRING;
import static com.fin.advisor.constant.ApplicationConstant.FOREIGN_STRING;
import static com.fin.advisor.constant.ApplicationConstant.LARGE_CAP_STRING;
import static com.fin.advisor.constant.ApplicationConstant.MID_CAP_STRING;
import static com.fin.advisor.constant.ApplicationConstant.SMALL_CAP_STRING;
import static com.fin.advisor.constant.ApplicationConstant.TRANSFER_MSG;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.fin.advisor.common.CommonUtil;
import com.fin.advisor.dto.CustomPortfolioDTO;
import com.fin.advisor.dto.IdealPortfolioDTO;
import com.fin.advisor.dto.RiskLevelDTO;

/**
 * @author rajesh.kumar
 * Service Impl class for Portfolio.
 */
@Service
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	RiskService riskService;

	List<String> msgList;
	
	@Autowired
	CommonUtil commonUtil;

	@Override
	public IdealPortfolioDTO calculateIdealPortfolio(Double totalAmount, Integer riskToleranceScore) {
		IdealPortfolioDTO portfolioDTO = new IdealPortfolioDTO();
		portfolioDTO.setTolerance_level(riskToleranceScore);
		portfolioDTO.setTotal_amount(totalAmount);
		RiskLevelDTO riskLevelDTO = riskService.getRiskToleranceData(riskToleranceScore);

		if (!ObjectUtils.isEmpty(riskLevelDTO.getTolerance_level())) {
			portfolioDTO.setBonds_cal_val((double) Math.round(totalAmount * (riskLevelDTO.getBonds_share() / 100.0)));
			portfolioDTO.setLarge_cap_cal_val(
					(double) Math.round(totalAmount * (riskLevelDTO.getLarge_cap_share() / 100.0)));
			portfolioDTO
					.setMid_cap_cal_val((double) Math.round(totalAmount * (riskLevelDTO.getMid_cap_share() / 100.0)));
			portfolioDTO.setForeign_cap_cal_val(
					(double) Math.round(totalAmount * (riskLevelDTO.getForeign_cap_share() / 100.0)));
			portfolioDTO.setSmall_cap_cal_val(
					(double) Math.round(totalAmount * (riskLevelDTO.getSmall_cap_share() / 100.0)));
		}
		return portfolioDTO;

	}

	@Override
	public CustomPortfolioDTO calculateCustomPortfolio(CustomPortfolioDTO customPortfolioDTO) {
		msgList = new ArrayList<>();
		Double total_amount = customPortfolioDTO.getBonds_custom_val() + customPortfolioDTO.getLarge_cap_custom_val()
				+ customPortfolioDTO.getMid_cap_custom_val() + customPortfolioDTO.getForeign_cap_custom_val()
				+ customPortfolioDTO.getSmall_cap_custom_val();

		customPortfolioDTO
				.setIdealPortfolioDTO(calculateIdealPortfolio(total_amount, customPortfolioDTO.getTolerance_level()));

		customPortfolioDTO.setBonds_diff_val(customPortfolioDTO.getIdealPortfolioDTO().getBonds_cal_val()
				- customPortfolioDTO.getBonds_custom_val());
		customPortfolioDTO.setLarge_cap_diff_val(customPortfolioDTO.getIdealPortfolioDTO().getLarge_cap_cal_val()
				- customPortfolioDTO.getLarge_cap_custom_val());
		customPortfolioDTO.setMid_cap_diff_val(customPortfolioDTO.getIdealPortfolioDTO().getMid_cap_cal_val()
				- customPortfolioDTO.getMid_cap_custom_val());
		customPortfolioDTO.setForeign_cap_diff_val(customPortfolioDTO.getIdealPortfolioDTO().getForeign_cap_cal_val()
				- customPortfolioDTO.getForeign_cap_custom_val());
		customPortfolioDTO.setSmall_cap_dif_val(customPortfolioDTO.getIdealPortfolioDTO().getSmall_cap_cal_val()
				- customPortfolioDTO.getSmall_cap_custom_val());
		// required calculation.
		Map<String, Double> differenceMap = new HashMap<>();
		differenceMap.put(BONDS_STRING, customPortfolioDTO.getBonds_diff_val());
		differenceMap.put(LARGE_CAP_STRING, customPortfolioDTO.getLarge_cap_diff_val());
		differenceMap.put(MID_CAP_STRING, customPortfolioDTO.getMid_cap_diff_val());
		differenceMap.put(FOREIGN_STRING, customPortfolioDTO.getForeign_cap_diff_val());
		differenceMap.put(SMALL_CAP_STRING, customPortfolioDTO.getSmall_cap_dif_val());

		cal(BONDS_STRING, differenceMap);
		cal(LARGE_CAP_STRING, differenceMap);
		cal(MID_CAP_STRING, differenceMap);
		cal(FOREIGN_STRING, differenceMap);

		customPortfolioDTO.setRecommendedTransferList(msgList);

		return customPortfolioDTO;
	}



	private void cal(String entity, Map<String, Double> differenceMap) {
		if (differenceMap.get(entity) > 0) {
			double min = 0.00;
			if (entity == BONDS_STRING) {
				min = commonUtil.findMin(differenceMap.get(LARGE_CAP_STRING), differenceMap.get(MID_CAP_STRING),
						differenceMap.get(FOREIGN_STRING), differenceMap.get(SMALL_CAP_STRING));
			} else if (entity == LARGE_CAP_STRING) {
				min = commonUtil.findMin(differenceMap.get(MID_CAP_STRING), differenceMap.get(FOREIGN_STRING),
						differenceMap.get(SMALL_CAP_STRING), differenceMap.get(BONDS_STRING));
			} else if (entity == MID_CAP_STRING) {
				min = commonUtil.findMin(differenceMap.get(FOREIGN_STRING), differenceMap.get(SMALL_CAP_STRING),
						differenceMap.get(BONDS_STRING), differenceMap.get(LARGE_CAP_STRING));
			} else if (entity == FOREIGN_STRING) {
				min = commonUtil.findMin(differenceMap.get(LARGE_CAP_STRING), differenceMap.get(MID_CAP_STRING),
						differenceMap.get(BONDS_STRING), differenceMap.get(SMALL_CAP_STRING));
			} else {
				min = commonUtil.findMin(differenceMap.get(LARGE_CAP_STRING), differenceMap.get(MID_CAP_STRING),
						differenceMap.get(FOREIGN_STRING), differenceMap.get(BONDS_STRING));
			}

			if (differenceMap.get(SMALL_CAP_STRING) != 0.00 && differenceMap.get(SMALL_CAP_STRING) == min) {
				if (differenceMap.get(entity) + min == 0.00) {
					updateCalcuatedData(min, differenceMap, SMALL_CAP_STRING, entity);
				} else if (differenceMap.get(entity) + min > 0.00) {
					updateCalcuatedData(min, differenceMap, SMALL_CAP_STRING, entity);
					cal(entity, differenceMap);
				} else {
					msgList.add(MessageFormat.format(TRANSFER_MSG, commonUtil.getCurrencyValueOf(differenceMap.get(entity)),
							SMALL_CAP_STRING, entity));
					differenceMap.put(SMALL_CAP_STRING, differenceMap.get(entity) + min);
					differenceMap.put(entity, 0.00);

				}

			}
			if (differenceMap.get(FOREIGN_STRING) != 0.00 && differenceMap.get(FOREIGN_STRING) == min) {
				if (differenceMap.get(entity) + min == 0.00) {
					updateCalcuatedData(min, differenceMap, FOREIGN_STRING, entity);
				} else if (differenceMap.get(entity) + min > 0.00) {
					updateCalcuatedData(min, differenceMap, FOREIGN_STRING, entity);
					cal(entity, differenceMap);

				} else {
					msgList.add(MessageFormat.format(TRANSFER_MSG, commonUtil.getCurrencyValueOf(differenceMap.get(entity)),
							FOREIGN_STRING, entity));
					differenceMap.put(FOREIGN_STRING, differenceMap.get(entity) + min);
					differenceMap.put(entity, 0.00);

				}
			}
			if (differenceMap.get(MID_CAP_STRING) != 0.00 && differenceMap.get(MID_CAP_STRING) == min) {
				if (differenceMap.get(entity) + min == 0.00) {
					updateCalcuatedData(min, differenceMap, MID_CAP_STRING, entity);
				} else if (differenceMap.get(entity) + min > 0.00) {
					updateCalcuatedData(min, differenceMap, MID_CAP_STRING, entity);
					cal(entity, differenceMap);

				} else {
					msgList.add(MessageFormat.format(TRANSFER_MSG, commonUtil.getCurrencyValueOf(differenceMap.get(entity)),
							MID_CAP_STRING, entity));
					differenceMap.put(MID_CAP_STRING, (differenceMap.get(entity) + min));
					differenceMap.put(entity, 0.00);

				}
			}
			if (differenceMap.get(LARGE_CAP_STRING) != 0.00 && differenceMap.get(LARGE_CAP_STRING) == min) {
				if (differenceMap.get(entity) + min == 0.00) {
					updateCalcuatedData(min, differenceMap, LARGE_CAP_STRING, entity);
				} else if (differenceMap.get(entity) + min > 0.00) {
					updateCalcuatedData(min, differenceMap, LARGE_CAP_STRING, entity);
				} else {
					msgList.add(MessageFormat.format(TRANSFER_MSG, commonUtil.getCurrencyValueOf(differenceMap.get(entity)),
							LARGE_CAP_STRING, entity));
					differenceMap.put(LARGE_CAP_STRING, differenceMap.get(entity) + min);
					differenceMap.put(entity, 0.00);

				}
			}
			
			if (differenceMap.get(BONDS_STRING) != 0.00 && differenceMap.get(BONDS_STRING) == min) {
				if (differenceMap.get(entity) + min == 0.00) {
					updateCalcuatedData(min, differenceMap, BONDS_STRING, entity);
				} else if (differenceMap.get(entity) + min > 0.00) {
					updateCalcuatedData(min, differenceMap, BONDS_STRING, entity);
				} else {
					msgList.add(MessageFormat.format(TRANSFER_MSG, commonUtil.getCurrencyValueOf(differenceMap.get(entity)),
							BONDS_STRING, entity));
					differenceMap.put(BONDS_STRING, differenceMap.get(entity) + min);
					differenceMap.put(entity, 0.00);

				}
			}

		}
	}

	private void updateCalcuatedData(double value, Map<String, Double> differenceMap, String sourceEntity,
			String targetEntity) {
		differenceMap.put(targetEntity, differenceMap.get(targetEntity) + value);
		differenceMap.put(sourceEntity, 0.00);
		msgList.add(MessageFormat.format(TRANSFER_MSG, commonUtil.getCurrencyValueOf(value), sourceEntity, targetEntity));
	}

	
}
