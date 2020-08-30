package com.sapient.AvgIncomeCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sapient.AvgIncomeCalculator.RW.CSVRecordsReader;
import com.sapient.AvgIncomeCalculator.RW.CSVReportGenerator;
import com.sapient.AvgIncomeCalculator.RW.DollarConverter;
import com.sapient.AvgIncomeCalculator.RW.RecordsReader;
import com.sapient.AvgIncomeCalculator.RW.ReportGenerator;
import com.sapient.AvgIncomeCalculator.models.Gender;
import com.sapient.AvgIncomeCalculator.models.InputEntity;
import com.sapient.AvgIncomeCalculator.models.OutputEntity;

public class App {

	// Can be autowired in spring
	private static RecordsReader recordsReader;
	private static ReportGenerator reportGenerator;

	static {
		recordsReader = new CSVRecordsReader();
		reportGenerator = new CSVReportGenerator();
	}

	public static void main(String[] args) {

		// change as per requirement
		String inputFilename = "Sample input file Assignment 3.csv";
		String outputFilename = "sample-report.csv";

		Map<String, List<InputEntity>> recordsMap;
		recordsMap = readInput(inputFilename);

		List<OutputEntity> outputList = calculatePerCapitaIncome(recordsMap);

		generatePerCapitaIncomeReport(outputList, outputFilename);

	}

	public static Map<String, List<InputEntity>> readInput(String inputFilename) {

		return recordsReader.readRecords(inputFilename);
	}

	public static List<OutputEntity> calculatePerCapitaIncome(Map<String, List<InputEntity>> recordsMap) {

		DollarConverter converter = new DollarConverter();
		List<OutputEntity> outputList = new ArrayList<OutputEntity>();
		Double mInc, fInc, temp;
		int m, f;
		for (String key : recordsMap.keySet()) {
			m = f = 0;
			mInc = fInc = 0.0;
			for (InputEntity ip : recordsMap.get(key)) {
				temp = converter.amountToDollar(ip.getAmount(), ip.getCurrency());
				if (ip.getGender() == Gender.M) {
					m++;
					mInc = mInc + temp;
				} else {
					f++;
					fInc = fInc + temp;
				}
			}
			outputList.add(new OutputEntity(key, Gender.F,
					BigDecimal.valueOf(fInc / f).setScale(2, RoundingMode.HALF_UP).doubleValue()));
			outputList.add(new OutputEntity(key, Gender.M,
					BigDecimal.valueOf(mInc / m).setScale(2, RoundingMode.HALF_UP).doubleValue()));
		}

		System.out.println("Average Income in USD Calculated ");
		return outputList;
	}

	private static void generatePerCapitaIncomeReport(List<OutputEntity> outputList, String outputFilename) {

		reportGenerator.generateReport(outputList, outputFilename);

	}
}