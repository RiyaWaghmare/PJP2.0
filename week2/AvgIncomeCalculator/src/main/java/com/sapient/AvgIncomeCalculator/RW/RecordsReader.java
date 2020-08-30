package com.sapient.AvgIncomeCalculator.RW;

import java.util.List;
import java.util.Map;

import com.sapient.AvgIncomeCalculator.models.InputEntity;

public interface RecordsReader {

	Map<String, List<InputEntity>> readRecords(String inputFilename);
}
