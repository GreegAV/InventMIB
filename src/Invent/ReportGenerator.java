package Invent;// класс генерации суммарного отчета

import jxl.*;
import jxl.write.*;

import java.io.File;
import java.io.IOException;

public class ReportGenerator {
    static boolean fileOpen = false;
    static WritableWorkbook xls;
    static WritableSheet xlsReport;

    public static void main(String[] args) throws Exception {

    }
    //TODO подумать в каком виде оно должно быть

    static void doReport(InventItem item, int row) throws Exception {

        xlsReport.addCell(new Label(0, row, item.getPcName()));
        xlsReport.addCell(new Label(1, row, item.getOsName()));
        xlsReport.addCell(new Label(2, row, item.getOsSP()));
        xlsReport.addCell(new Label(3, row, item.getRamSize()));
        xlsReport.addCell(new Label(4, row, item.getLanIP()));

        xlsReport.addCell(new Label(5, row, item.getPrintList().toString()));
        xlsReport.addCell(new Label(6, row, item.getLicList().toString()));
    }

    static void closeReport() throws IOException, WriteException {
        xls.write();
        xls.close();
    }


    static WritableSheet createReport() throws Exception {
        System.out.println("Генерируем отчет.");
        File report = new File("report.xls");
        xls = Workbook.createWorkbook(report);
        xlsReport = xls.createSheet("HQ", 0);
        return xlsReport;
    }

}

