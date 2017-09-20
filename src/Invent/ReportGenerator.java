package Invent;// класс генерации суммарного отчета

import jxl.*;
import jxl.write.*;

import java.io.File;
import java.io.IOException;

public class ReportGenerator {
    static int col=0;
    static int row=0;
    static boolean fileOpen=false;
    static WritableWorkbook xls;
    static WritableSheet xlsReport;
    public static void main(String[] args) throws Exception {

    }
 //TODO подумать в каком виде оно должно быть

    static void doReport(InventItem item) throws Exception {


        xlsReport.addCell(new Label(col,row,item.getPcName()));
        xlsReport.addCell(new Label(col++,row,item.getOsName()));
        xlsReport.addCell(new Label(col++,row,item.getOsSP()));
        xlsReport.addCell(new Label(col++,row,item.getRamSize()));
        xlsReport.addCell(new Label(col++,row,item.getLanIP()));

        xlsReport.addCell(new Label(col++,row,item.getPrintList().toString()));
        xlsReport.addCell(new Label(col++,row,item.getLicList().toString()));

    }

    static void closeReport() throws IOException, WriteException {
        xls.write();
        xls.close();
    }


    static WritableSheet createReport() throws Exception {
            System.out.println("Генерируем отчет.");
            File report = new File("report.xls");
            xls= Workbook.createWorkbook(report);
            xlsReport=xls.createSheet("HQ",0);
            return xlsReport;
        }

    }

