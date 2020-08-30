package com.sapient.AvgIncomeCalculator.RW;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sapient.AvgIncomeCalculator.models.OutputEntity;

public class CSVReportGenerator implements ReportGenerator {

	@Override
	public void generateReport(List<OutputEntity> outputList, String outputFilename) {

		try (FileWriter fr = new FileWriter(outputFilename)) {
			fr.append("Country/City");
			fr.append(",");
			fr.append("Gender");
			fr.append(",");
			fr.append("Average Income (USD)");
			fr.append("\n\n");

			for (OutputEntity o : outputList) {

				fr.append(String.join(",", o.getPlace(), o.getGender().name(), String.valueOf(o.getPerCapitaIncome())));
				fr.append('\n');
			}
			fr.flush();
			fr.close();

			System.out.println("CSV Report Generated Successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
