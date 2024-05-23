package com.test;

import com.lhz.PostGraduateEntranceExamSharing;
import com.lhz.entity.Profession;
import com.lhz.service.PostService;
import com.lhz.service.ProfessionService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PostGraduateEntranceExamSharing.class)
public class ExcelReadTest {
    @Autowired
    private ProfessionService professionService;

    @Test
    public void excelTest() throws Exception{
        String filePath = "D:\\BaiduNetdiskDownload\\17-20研究生复试分数线.xlsx"; // Excel文件路径
        FileInputStream fis = new FileInputStream(new File(filePath));
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // 假设我们要处理第一个工作表

        Iterator<Row> rowIterator = sheet.iterator();
        rowIterator.next(); // 跳过表头行

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            // 假设Excel文件的结构为：ID, Name, Age
            int year = (int) cellIterator.next().getNumericCellValue();
            String schoolLink = cellIterator.next().getStringCellValue();
            String schoolName = cellIterator.next().getStringCellValue();
            String yuanLink = cellIterator.next().getStringCellValue();
            String yuanName = cellIterator.next().getStringCellValue();
            int proCode = 0;
            try {
                proCode = (int) cellIterator.next().getNumericCellValue();
            }catch (Exception e){
                proCode = -1;
            }
            String proLink = cellIterator.next().getStringCellValue();
            String proName = cellIterator.next().getStringCellValue();
            int totalScore = 0;
            int freScore = 0;
            int ploScore = 0;
            int oneScore = 0;
            int twoScore = 0;
            try{
                totalScore = (int)cellIterator.next().getNumericCellValue();
            }catch (Exception e){
                totalScore = -1;
            }try {
                freScore = (int) cellIterator.next().getNumericCellValue();
            }catch (Exception e){
                freScore = -1;
            }
            try{
                ploScore = (int)cellIterator.next().getNumericCellValue();
            }catch (Exception e){
                freScore = -1;
            }
            try {
                oneScore = (int) cellIterator.next().getNumericCellValue();
            }catch (Exception e){
                oneScore = -1;
            }
            try {
                twoScore = (int)cellIterator.next().getNumericCellValue();
            }catch (Exception e){
                twoScore = -1;
            }
            Profession profession = Profession.builder().year(year)
                    .schoolLink(schoolLink)
                    .schoolName(schoolName).yuanLink(yuanLink)
                    .yuanName(yuanName).professionCode(proCode)
                    .professionLink(proLink).professionName(proName)
                    .totalScore(totalScore).foreLangScore(freScore)
                    .politicalScore(ploScore)
                    .professionScoreOne(oneScore).professionScoreTwo(twoScore).build();
            // 存储到数据库
            professionService.save(profession);
        }

        workbook.close();
        fis.close();
    }

}
