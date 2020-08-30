package com.sapient.AvgIncomeCalculator.RW;

import java.util.List;

import com.sapient.AvgIncomeCalculator.models.OutputEntity;

public interface ReportGenerator {

	void generateReport(List<OutputEntity> outputList, String outputFilename);

}
