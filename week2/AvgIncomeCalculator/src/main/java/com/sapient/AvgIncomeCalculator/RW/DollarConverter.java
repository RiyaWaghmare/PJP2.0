package com.sapient.AvgIncomeCalculator.RW;

import java.util.HashMap;
import java.util.Map;

import com.sapient.AvgIncomeCalculator.models.Currency;

public class DollarConverter {

	private static Map<Currency, Double> conversionRules = new HashMap<Currency, Double>();

	static {
		conversionRules.put(Currency.INR, new Double((double) 1 / 66));
		conversionRules.put(Currency.USD, new Double(1));
		conversionRules.put(Currency.GBP, new Double((double) 1 / 0.67));
		conversionRules.put(Currency.SGP, new Double((double) 1 / 1.5));
		conversionRules.put(Currency.HKD, new Double((double) 1 / 8));
		
	}

	public double amountToDollar(double amount, Currency currency) {

		return amount * conversionRules.get(currency);
	}

}
