package Invent;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Класс для загрузки данных из файла
class LoadFromFile {
    // TODO
    // Считать название директории с отчетами (получить путь)                                   ГОТОВО!!!

    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    private static JFileChooser fc;
    private static int numlines = 0;
    private static int countXP = 0, count7 = 0, count10 = 0;

    // Получаем имя папки с файлами отчетов.
    static String getDirName() {
        fc = new JFileChooser();
        String path = null;
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(LoadFromFile.fc);

        if (returnVal < 1) {
            File file = fc.getSelectedFile();
            path = file.getPath();
        } else {
            System.exit(0);
        }
        return path;
    }
// получаем список файлов в папке и возвращаем отсортированный список

    static List<String> getListFiles(String path) {

        List<String> listOfFiles = new ArrayList<>();
        File files[] = new File(path).listFiles();

        for (File file : files) {
            if (file.isFile()) {
                listOfFiles.add(file.getAbsolutePath());
            }
        }

        return listOfFiles;
    }

    // загружаем данные из файла
    static void loadFromFile() throws FileNotFoundException {
        //Получаем имя папки

        String path = getDirName();
        List<String> fileList = getListFiles(path);

        //Получаем и печатаем список файлов в полученной папке

        getListFiles(path);

        for (String tmpFileName : fileList) {
            readFromFile(tmpFileName);
        }
        System.out.println("XP - " + countXP);
        System.out.println("7 - " + count7);
        System.out.println("10 - " + count10);
    }


    // TODO FUCKING FILE READING!!!!
//  получает список файлов
//    открывает по очереди
//    читает посторочно
//            определяет нужную строку.
    // записывает в нужное поле элемента

    static void readFromFile(String fname) throws FileNotFoundException {


        File file = new File(fname);

        Scanner sc = new Scanner(file);
        String curLine = sc.nextLine();
        String pcName = "";
        String osName = "";
        String osSP = "";
        String ramSize="";
        String lanIP="";
        List<String> printList=new ArrayList<>();
        Map<String, String> licList;

        List<String> tokens;


        while ((sc.hasNextLine() && (curLine != null))) {
// Computer Name
            if (curLine.contains("Комп'ютер  ") || curLine.contains("Компьютер  ")) {
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));

                //TODO записать в элемент инвентаризации
                pcName = tokens.get(2).substring(1, tokens.get(2).length());

                curLine = sc.nextLine();
                curLine = sc.nextLine();
// OS name
                if (curLine.contains("Операцiйна система") || curLine.contains("Операционная система")) {
                    tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));

                    //TODO записать в элемент инвентаризации
                    osName = tokens.get(5) + " " + tokens.get(6).substring(0, 3);
                    switch (tokens.get(5)) {
                        case "XP":
                            countXP++;
                            break;
                        case "7":
                            count7++;
                            break;
                        case "10":
                            count10++;
                            break;
                    }
                }
            }

// Service pack
            if (curLine.contains("Пакет обновления ОС") || curLine.contains("Пакет оновлення ОС")) {
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));
                if (tokens.size() > 5) {
                    osSP = "SP " + tokens.get(6);
                } else {
                    osSP = "-";
                }
                //TODO записать в элемент инвентаризации
            }

// RAM size
            if (curLine.contains("Системна пам'ять") || curLine.contains("Системная память")) {
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));
                int testRAM=Integer.valueOf(tokens.get(3).substring(1, tokens.get(3).length()));

                if (testRAM<1111) {
                    ramSize="1Gb";
                } else if (testRAM<2222 && testRAM>1111) {
                    ramSize="2Gb";
                } else if (testRAM<4444 && testRAM>2222) {
                    ramSize="4Gb";
                } else if (testRAM<8888 && testRAM>4444) {
                    ramSize = "8Gb";
                } else System.out.println(testRAM);

                //TODO записать в элемент инвентаризации
            }

// LAN adress
            if (curLine.contains("Первинна адреса IP") || curLine.contains("Первичный адрес IP")) {
                // System.out.println("Found - "+curLine);
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));

                lanIP=tokens.get(4).substring(tokens.get(4).indexOf("10"),tokens.get(4).length());
                //TODO записать в элемент инвентаризации

//                for (int i = 0; i < tokens.size(); i++) {
//                    System.out.println(i + "-" + tokens.get(i));
//                }

            }
// Printer


            /*
            найти переферийные устройства
            считывать строку пока не найдет DMI
            анализировать на наличие в строке слова принтер.
             */

            if (curLine.contains("Принтер") ) {
                if (curLine.contains("Fax")  || curLine.contains("Microsoft") || curLine.contains("USB")) {
                    // do nothing
                    System.out.println("!!!!"+curLine);
                    curLine = sc.nextLine();
                }
                 System.out.println("Found -"+curLine);
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));

                //   printList.add(tokens.get(2).substring(1,tokens.get(2).length()));
               // printList.add(curLine.substring("Принтер".length()));
              //  printList.add(curLine);
                //TODO записать в элемент инвентаризации
             //   System.out.println(pcName+" -"+printList.toString());
//                while (!curLine.contains("DMI")) {
//                    curLine = sc.nextLine();
//                }
//
//                for (int i = 0; i < tokens.size(); i++) {
//                    System.out.println(i + "-" + tokens.get(i));
//                }

            }

            // Считываем следующую строку ниже по файлу
            curLine = sc.nextLine();

        }


        // TODO Форматированный вывод куда-то. Передавать, например в ReportGenerator.
//          System.out.println(pcName + " " + osName +" "+ osSP+" "+ramSize);

        sc.close();

    }


}
