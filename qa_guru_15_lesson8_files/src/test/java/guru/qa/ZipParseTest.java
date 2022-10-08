package guru.qa;
import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import static org.assertj.core.api.Assertions.assertThat;
import guru.qa.bankingDetails.BankingDetails;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ZipParseTest {
    ClassLoader cl = ZipParseTest.class.getClassLoader();

    @Test
     void zipTest() throws Exception{
        ZipFile zipArchive = new ZipFile(new File("src/test/resources/files.zip"));
    try (ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("files.zip"))){
         ZipEntry entry;
    while ((entry = is.getNextEntry()) !=null) {
        switch (entry.getName()) {
            case "cities.csv":
                try (InputStream inputStream = zipArchive.getInputStream(entry);
                     CSVReader reader = new CSVReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                    List<String[]> content = reader.readAll();
                    String[] row = content.get(3);
                    String csvContent = row[8];
                    assertThat(csvContent).isEqualTo("Yakima");
                }
                break;
            case "1.xlsx":
                try (InputStream inputStream = zipArchive.getInputStream(entry)) {
                    XLS xls = new XLS(inputStream);
                    assertThat(
                            xls.excel.getSheetAt(0)
                                    .getRow(0)
                                    .getCell(0)
                                    .getStringCellValue()
                    ).isEqualTo("Василий");
                }
                break;
            case "logi.pdf":
                try (InputStream inputStream = zipArchive.getInputStream(entry)) {
                    PDF pdf = new PDF(inputStream);
                    assertThat(pdf.text).contains("LIGHTSPEED Wireless Gaming Mouse");
                }
                break;}
    }
    }
    }

    @Test
    void jsonTest() throws Exception {
            File file = new File("src/test/resources/BankingDetails.json");
            ObjectMapper objectMapper = new ObjectMapper();
            BankingDetails bankingDetails = objectMapper.readValue(file, BankingDetails.class);

            assertThat(bankingDetails.uid).isEqualTo("5678-3456-2345-7895");
            assertThat(bankingDetails.accType).isEqualTo("ruble");
            assertThat(bankingDetails.info.get(0).accNum).isEqualTo("40817810400000006810");
    }
}