package Invent;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
        List<String> tokens2;


        while ((sc.hasNextLine() && (curLine != null))) {
            if (curLine.contains("Комп'ютер  ") || curLine.contains("Компьютер  ")) {
                String[] tokens = curLine.split(" ");
                tokens2 = new ArrayList<>((Arrays.asList(tokens)));

//                for (String t : tokens) {
//                    if (t != " ") {
//                        tokens2.add(t);
//                    }
//                }

                //TODO записать в элемент инвентаризации
                pcName = tokens2.get(2).substring(1, tokens2.get(2).length());

                curLine = sc.nextLine();
                curLine = sc.nextLine();
                if (curLine.contains("Операцiйна система") || curLine.contains("Операционная система")) {
                    tokens2 = new ArrayList<>((Arrays.asList(curLine.split(" "))));

//                    for (String t : tokensOS) {
//                            tokens2OS.add(t);
//                    }

                    //TODO записать в элемент инвентаризации
                    osName = tokens2.get(5) + " " + tokens2.get(6).substring(0, 3);
                    switch (tokens2.get(5)) {
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
                    // TODO Форматированный вывод куда-то. Передавать, например в ReportGenerator.
                    System.out.println(pcName + " " + osName);
                }
            }


            if (curLine.contains("Пакет обновления ОС") || curLine.contains("Пакет оновлення ОС")) {
                System.out.println("Found !");
                tokens2 = new ArrayList<>((Arrays.asList(curLine.split(" "))));

//                for (String t : tokens) {
//                        tokens2.add(t);
//                }
            }


            // Считываем следующую строку ниже по файлу
            curLine = sc.nextLine();

        }

        sc.close();

    }


}
