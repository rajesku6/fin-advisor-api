package com.fin.advisor.constant;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class ApplicationConstant {

	public static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance(Locale.US);
	public static final NumberFormat NUMBER_FORMATTER = DecimalFormat.getNumberInstance(Locale.US);
	public static final String NULL_STRING = "null";
	public static final String BLANK_SPACE = "";
	public static final String YES_FLAG = "Y";

	public static final String BONDS_STRING="Bonds";
	public static final String LARGE_CAP_STRING="Large Cap";
	public static final String MID_CAP_STRING="Mid Cap";
	public static final String FOREIGN_STRING="Foreign";
	public static final String SMALL_CAP_STRING="Small Cap";
	public static final String TRANSFER_MSG="Transfer {0} from {1} to {2}.";
}
