package Invent;

import javax.swing.*;
import java.io.File;

// Класс для загрузки данных из файла
public class LoadFromFile extends JPanel {
    // TODO
    // Считать название директории с отчетами (получить путь)
    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    public static String s1;
    static JFileChooser fc;

    public LoadFromFile() {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//do nothing
    }


    public static String getDirName(){
        fc = new JFileChooser();
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fc.showOpenDialog(LoadFromFile.fc);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
        }
        s1= "Запускаем окно выбора папки\n";

        String path="";

        if (path.length()>0) {

            System.out.println(path);
        } else
        {
            s1+="Path not found!\n";
        }

        s1+= "Получаем путь\n\n";

        return s1;
    }

    public static void loadFromFile(String path){

        path="Проверяем наличие файла\n";
        path+="Если файл есть - считываем его содержимое и добавляем в коллекцию\n";
        System.out.println(s1+path);
    }


}
