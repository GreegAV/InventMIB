package Invent;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    }


    // TODO FUCKING FILE READING!!!!
//  получает список файлов
//    открывает по очереди
//    читает посторочно
//            определяет нужную строку.
    // записывает в нужное поле элемента

    static void readFromFile(String fname) throws FileNotFoundException {

        int numlines = 0;

        File file = new File(fname);

        Scanner sc = new Scanner(file);
        String curLine = sc.nextLine();
        String pcName;

        while ((sc.hasNextLine() && (curLine != null))) {
            if (curLine.contains("Комп'ютер  ") || curLine.contains("Компьютер  ")) {
                String[] tokens = curLine.split(" ");
                List<String> tokens2 = new ArrayList<>();

                for (String t : tokens) {
                    if (t != " ") {
                        tokens2.add(t);
                    }
                }
                tokens2.add(0, tokens2.get(0).substring(2, tokens2.get(0).length()));
                tokens2.add(1, tokens2.get(3).substring(1, tokens2.get(3).length()));
                pcName = tokens2.get(1);                                                      //TODO записать в элемент инвентаризации
            }

            curLine = sc.nextLine();

        }

        sc.close();
    }


}
