package com.sapient.processing_fee_calculator.RW;

import java.util.List;

import com.sapient.processing_fee_calculator.Transactions.Transaction;

public interface RecordsReader {

	List<Transaction> readRecords(String filename);
}
