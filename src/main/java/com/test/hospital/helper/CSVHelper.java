package com.test.hospital.helper;

import com.test.hospital.dao.Patient;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
        public static ByteArrayInputStream ConvertToCSV(Patient patient) throws IOException {
            final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
            try (ByteArrayOutputStream out = new ByteArrayOutputStream();
                 CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {

                List<String> data = new ArrayList<>();
                     data.add(patient.getName());
                     data.add(patient.getAge().toString());
                     data.add(patient.getLast_visit_date().toString());
                     data.add(patient.getAge().toString());
                    csvPrinter.printRecord(data);
                csvPrinter.flush();
                return new ByteArrayInputStream(out.toByteArray());
            } catch (IOException e) {
                throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
            }
        }
}


