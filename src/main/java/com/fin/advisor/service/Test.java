package com.fin.advisor.service;

import static com.fin.advisor.constant.ApplicationConstant.BLANK_SPACE;
import static com.fin.advisor.constant.ApplicationConstant.CURRENCY_FORMATTER;
import static com.fin.advisor.constant.ApplicationConstant.NULL_STRING;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	static List<String> msgList = new ArrayList<>();

	public static void main(String[] args) {
		Double B = -1.00;
		Double L= 44.00;
		Double M = -5.00;
		Double F =-16.00;
		Double S = -22.00;
				
		Map<Double, String> differenceMap = new HashMap<>();
		Map<Double, String> differenceMap1 = new HashMap<>();

		Map<String, Double> newDifferenceMap = new HashMap<>();
		
		
		differenceMap.put(B, "Bonds");
		differenceMap.put(L, "LargeCap");
		differenceMap.put(M, "MidCap");
		differenceMap.put(F, "ForeignCap");
		differenceMap.put(S, "SmallCap");
		
		newDifferenceMap.put("Bonds" ,B);
		newDifferenceMap.put("LargeCap", L);
		newDifferenceMap.put("MidCap", M);
		newDifferenceMap.put("ForeignCap", F);
		newDifferenceMap.put("SmallCap", S);
		
		
		
		cal(B, "Bonds", newDifferenceMap);
		cal(B, "LargeCap", newDifferenceMap);
		cal(B, "MidCap", newDifferenceMap);
//		cal(B, "SmallCap", newDifferenceMap);
		
		
		
		
		
//		if(B < 0) {
//			
//		} else {
//			double min4 = findMin(L,M,F,S);			
//			System.out.println(differenceMap.get(min4));
//			msgList.add("Transfer "+min4+" $ from "+differenceMap.get(min4)+ " to bonds");
//			
//			if(B+min4 >0) {
//				double min3 = findMin(L,M,F);			
//				System.out.println(differenceMap.get(min3));
//				msgList.add("Transfer "+min3+" $ from "+differenceMap.get(min3)+ " to bonds");
//				
//				if(B+min4+min3 >0) {
//					double min2 = findMin(L,M);			
//					System.out.println(differenceMap.get(min2));
//					msgList.add("Transfer "+min2+" $ from "+differenceMap.get(min2)+ " to bonds");
//					
//					if(B+min4+min3+min2 >0) {
//						double min1 = findMin(L);			
//						System.out.println("LargeCap");
//						msgList.add("Transfer "+min1+" $ from LargeCap to bonds");
//					} else if(B+min4+min3+min2 == 0) {
//						System.out.println("values are equalized");
//					} else {
//						System.out.println("Remaining Amount:: "+ (B+min4+min3+min2));
//					}
//					
//					
//				}
//			}
//			
//			
//			
//
		}
//		
//		System.out.println(msgList);
		
	
	
	private static double findMin(double... vals) {
		   double min = 0;

		   for (double d : vals) {
		      if (d < min) min = d;
		   }

		   return min;
		}
	
	
	private static void cal(double value, String entity, Map<String, Double> newDifferenceMap) {
		
		System.out.println("Processing -----------------------> "+entity);
		System.out.println("Before:: "+newDifferenceMap);
		
		if(newDifferenceMap.get(entity) > 0) {
			
			double min = 0.00;
			if(entity =="Bonds") {
			min = findMin(newDifferenceMap.get("LargeCap"), newDifferenceMap.get("MidCap"),
					newDifferenceMap.get("ForeignCap"), newDifferenceMap.get("SmallCap"));			
			} else if(entity =="LargeCap") {
				min = findMin(newDifferenceMap.get("MidCap"),
						newDifferenceMap.get("ForeignCap"), newDifferenceMap.get("SmallCap") , newDifferenceMap.get("Bonds"));
			} else if(entity =="MidCap") {
				min = findMin(
						newDifferenceMap.get("ForeignCap"), newDifferenceMap.get("SmallCap"),  newDifferenceMap.get("LargeCap"), newDifferenceMap.get("Bonds"));
			} else if (entity =="ForeignCap" ) {
				min = findMin(
						newDifferenceMap.get("SmallCap"), newDifferenceMap.get("MidCap"),  newDifferenceMap.get("LargeCap"), newDifferenceMap.get("Bonds"));
			}  else {
				min = findMin(
						newDifferenceMap.get("ForeignCap"), newDifferenceMap.get("MidCap"),  newDifferenceMap.get("LargeCap"), newDifferenceMap.get("Bonds"));
			}
			
			
			if(newDifferenceMap.get("SmallCap") != 0.00 && newDifferenceMap.get("SmallCap") == min ) {
				System.out.println("1");
				if(newDifferenceMap.get(entity) + min == 0.00) {
					System.out.println("1.1");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("SmallCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from SmallCap to "+entity);

				} else if(newDifferenceMap.get(entity) + min > 0.00) {
					System.out.println("1.2");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("SmallCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from SmallCap to "+entity);
					cal((newDifferenceMap.get(entity) + min), entity,newDifferenceMap);
				} else {
					System.out.println("1.3");
					msgList.add("Transfer "+getCurrencyValueOf(newDifferenceMap.get(entity))+ " from SmallCap to "+entity);

					newDifferenceMap.put("SmallCap", newDifferenceMap.get(entity) + min);
					newDifferenceMap.put(entity, 0.00);
					
				}
				
			}
			if(newDifferenceMap.get("ForeignCap") != 0.00 && newDifferenceMap.get("ForeignCap") == min ) {
				System.out.println("2");
				if(newDifferenceMap.get(entity) + min == 0.00) {
					System.out.println("2.1");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("ForeignCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from ForeignCap to "+entity);


				} else if(newDifferenceMap.get(entity) + min > 0.00) {
					System.out.println("2.2");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("ForeignCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from ForeignCap to "+entity);

					cal((newDifferenceMap.get(entity) + min), entity, newDifferenceMap);

				} else {
					System.out.println("2.3");
					msgList.add("Transfer "+getCurrencyValueOf(newDifferenceMap.get(entity))+ " from ForeignCap to "+entity);
					newDifferenceMap.put("ForeignCap", newDifferenceMap.get(entity) + min);
					newDifferenceMap.put(entity, 0.00);

				}
			}
			if(newDifferenceMap.get("MidCap") != 0.00 &&  newDifferenceMap.get("MidCap") == min ) {
				System.out.println("3");
				System.out.println(newDifferenceMap.get(entity) + min);
				if(newDifferenceMap.get(entity) + min == 0.00) {
					System.out.println("3.1");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("MidCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from MidCap to "+entity);


				} else if(newDifferenceMap.get(entity) + min > 0.00) {
					System.out.println("3.2");
					newDifferenceMap.put(entity, (newDifferenceMap.get(entity) + min));
					newDifferenceMap.put("MidCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from MidCap to "+entity);
					cal((newDifferenceMap.get(entity) + min), entity,newDifferenceMap);

				} else {
					System.out.println("3.3");
					msgList.add("Transfer "+ getCurrencyValueOf(newDifferenceMap.get(entity))+ " from MidCap to "+entity);
					newDifferenceMap.put("MidCap", (newDifferenceMap.get(entity) + min));
					newDifferenceMap.put(entity, 0.00);


				}
			}
			if(newDifferenceMap.get("LargeCap") != 0.00 &&  newDifferenceMap.get("LargeCap") == min ) {
				System.out.println("4");
				if(newDifferenceMap.get(entity) + min == 0.00) {
					System.out.println("4.1");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("LargeCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from LargeCap to "+entity);


				} else if(newDifferenceMap.get(entity) + min > 0.00) {
					System.out.println("4.2");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("LargeCap", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from LargeCap to "+entity);

				} else {
					System.out.println("4.3");
					msgList.add("Transfer "+getCurrencyValueOf(newDifferenceMap.get(entity)) + " from LargeCap to "+entity);
					newDifferenceMap.put("LargeCap", newDifferenceMap.get(entity) + min);
					newDifferenceMap.put(entity, 0.00);

				}
			}
			
			if(newDifferenceMap.get("Bonds") != 0.00 &&  newDifferenceMap.get("Bonds") == min ) {
				System.out.println("5");
				if(newDifferenceMap.get(entity) + min == 0.00) {
					System.out.println("5.1");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("Bonds", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from Bonds to "+entity);


				} else if(newDifferenceMap.get(entity) + min > 0.00) {
					System.out.println("5.2");
					newDifferenceMap.put(entity, newDifferenceMap.get(entity) + min);
					newDifferenceMap.put("Bonds", 0.00);
					msgList.add("Transfer "+getCurrencyValueOf(min)+ " from Bonds to "+entity);

				} else {
					System.out.println("5.3");
					msgList.add("Transfer "+getCurrencyValueOf(newDifferenceMap.get(entity)) + " from Bonds to "+entity);
					newDifferenceMap.put("Bonds", newDifferenceMap.get(entity) + min);
					newDifferenceMap.put(entity, 0.00);

				}
			}
			
		}
		System.out.println("After:: "+newDifferenceMap);
		System.out.println("msgList:: "+msgList);
		System.out.println("********************************** \n");
	}
	
	public static String getCurrencyValueOf(Object currencyObject) {
        String result = BLANK_SPACE;
        if(null != currencyObject && !NULL_STRING.equalsIgnoreCase(currencyObject.toString().trim()) && !BLANK_SPACE.equalsIgnoreCase(currencyObject.toString().trim())){
            result = CURRENCY_FORMATTER.format(Double.parseDouble(currencyObject.toString().trim()));
        }
        return result;
    }
}
