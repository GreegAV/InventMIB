package Invent;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс для загрузки данных из файла
public class LoadFromFile  {
    // TODO
    // Считать название директории с отчетами (получить путь)                                   ГОТОВО!!!

    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    static JFileChooser fc;

// Получаем имя папки с файлами отчетов.
    private static String getDirName(){
        fc = new JFileChooser();
        String path=null;
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(LoadFromFile.fc);

        if (returnVal <1) {
            File file = fc.getSelectedFile();
            path=file.getPath();
        } else {
            System.exit(0);
        }
        return path;
    }
// получаем список файлов в папке

    private static List getListFiles(String path){
        List<String> listOfFiles = new ArrayList<String>();

        File files[] = new File(path).listFiles();

        for (File file: files) {
            if (file.isFile()) {
                listOfFiles.add(file.getName());
            }
        }
        Collections.sort(listOfFiles);

        return listOfFiles;
    }

// загружаем данные из файла
    public static void loadFromFile(){
      //Получаем имя папки

        String path=getDirName();

     //Получаем и печатаем список файлов в полученной папке

        getListFiles(path);

    }


}
