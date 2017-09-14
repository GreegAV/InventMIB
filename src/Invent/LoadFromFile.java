package Invent;

import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Класс для загрузки данных из файла
class LoadFromFile  {
    // TODO
    // Считать название директории с отчетами (получить путь)                                   ГОТОВО!!!

    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    private static JFileChooser fc;

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
// получаем список файлов в папке и возвращаем отсортированный список

     private static List getListFiles(String path){

        List<String> listOfFiles = new ArrayList<>();
        File files[] = new File(path).listFiles();

        for (File file: files) {
            if (file.isFile()) {
                listOfFiles.add(file.getAbsolutePath());
            }
        }
        // Collections.sort(listOfFiles);

        return listOfFiles;
    }

// загружаем данные из файла
    static void loadFromFile(){
      //Получаем имя папки

        String path=getDirName();
        List<String> fileList=getListFiles(path);

     //Получаем и печатаем список файлов в полученной папке

        getListFiles(path);

        for (int i = 0; i <fileList.size() ; i++) {
        String tmpFileName =fileList.get(i);
        readFromFile(path, tmpFileName);
        }

    }


    // TODO FUCKING FILE READING!!!!
    // Крашится иногда :(


    static void readFromFile(String path, String fname){

        int numlines=0;
        try (BufferedReader reader = Files.newBufferedReader (
                Paths.get( fname ), StandardCharsets.UTF_8 )) {
            String line;

            while (( line = reader.readLine()) != null ) {
// process line
                numlines++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Файл "+fname+" содержит "+ numlines+ " строк.");
    }



}
