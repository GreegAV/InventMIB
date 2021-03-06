package Invent;

import javax.swing.*;
import java.io.File;
import java.util.*;

import static Invent.ReportGenerator.doReport;

// Класс для загрузки данных из файла
class LoadFromFile {
    // TODO
    // Считать название директории с отчетами (получить путь)                                   ГОТОВО!!!

    // В цикле пока есть файлы считывать инофрмацию из каждого следующего файла
    // и добавлять в коллекцию
    //
    private static JFileChooser fc;
    private static int numItems = 0;
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
    static void loadFromFile() throws Exception {
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

    private static void readFromFile(String fname) throws Exception {


        File file = new File(fname);

        Scanner sc = new Scanner(file);
        String curLine = sc.nextLine();
        String pcName = "";
        String osName = "";
        String osSP = "";
        String ramSize = "";
        String lanIP;
        List<String> printList = new ArrayList<>();
        Map<String, String> licList = new HashMap<>();
        boolean theEnd = false;

        List<String> tokens;

        InventItem anItem = new InventItem();


        while (!theEnd && (sc.hasNextLine() && (curLine != null))) {
// Computer Name
            if (curLine.contains("Комп'ютер  ") || curLine.contains("Компьютер  ")) {
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));

                //TODO записать в элемент инвентаризации
                pcName = tokens.get(2).substring(1, tokens.get(2).length());
                anItem.setPcName(pcName);

                curLine = sc.nextLine();
                curLine = sc.nextLine();
// OS name
                if (curLine.contains("Операцiйна система") || curLine.contains("Операционная система")) {
                    tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));

                    //TODO записать в элемент инвентаризации
                    osName = tokens.get(5) + " " + tokens.get(6).substring(0, 3);
                    anItem.setOsName(osName);

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
                anItem.setOsSP(osSP);
            }

// RAM size
            if (curLine.contains("Системна пам'ять") || curLine.contains("Системная память")) {
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));
                int testRAM = Integer.valueOf(tokens.get(3).substring(1, tokens.get(3).length()));

                if (testRAM < 1111) {
                    ramSize = "1Gb";
                } else if (testRAM < 2222 && testRAM > 1111) {
                    ramSize = "2Gb";
                } else if (testRAM < 4444 && testRAM > 2222) {
                    ramSize = "4Gb";
                } else if (testRAM < 8888 && testRAM > 4444) {
                    ramSize = "8Gb";
                } else System.out.println(testRAM);

                //TODO записать в элемент инвентаризации
                //   System.out.println(ramSize);
                anItem.setRamSize(ramSize);
            }

// LAN adress
            if (curLine.contains("Первинна адреса IP") || curLine.contains("Первичный адрес IP")) {
                tokens = new ArrayList<>((Arrays.asList(curLine.split(" "))));

                lanIP = tokens.get(4).substring(tokens.get(4).indexOf("10"), tokens.get(4).length());
                //TODO записать в элемент инвентаризации
                anItem.setLanIP(lanIP);

            }
// Printersssss

            if (curLine.contains("Принтер")) {
                if (curLine.contains("Fax")) {
                    // do nothing
                } else { // Если нет Fax
                    if (curLine.contains("USB")) {
                        // do nothing
                    } else { // Если нет USB
                        if (curLine.contains("Microsoft")) {
                            // do nothing
                        } else { // Если нет Microsoft XPS + PDF
                            if (curLine.contains("PDF")) {
                                //do nothing
                            } else { // Если нет  PDF
                                if (curLine.contains("OneNote")) {
                                    // do nothing
                                } else {  // Если нет OneNote
                                    if (curLine.contains("Universal")) {
                                        // do nothing
                                    } else {  // Если нет HP Universal
                                        printList.add(curLine.substring(13));

                                    } //end if-universal
                                } //end if-onenote
                            } //end if-pdf
                        } //end if-MS
                    } //end if-usb
                } //end if-fax

                //TODO записать в элемент инвентаризации
                //    System.out.println(pcName+" -"+printList.toString());
                anItem.setPrintList(printList);
            }
// LICENSES!!!

            if (curLine.contains("Ключ продукт")) {
                curLine = sc.nextLine();
                while (curLine.length() > 0) {
                    tokens = new ArrayList<>((Arrays.asList(curLine.split("\t"))));

                    String softName = tokens.get(2);
                    String licNumber = tokens.get(3);
                    licList.put(softName, licNumber);
                    curLine = sc.nextLine();
                }
                theEnd = true;
            }


            // Считываем следующую строку ниже по файлу
            if (!theEnd) {
                curLine = sc.nextLine();
            }

        }


        // TODO Форматированный вывод куда-то. Передавать, например в ReportGenerator.
        anItem.setLicList(licList);

//        String listLicences = "";
//
//        Set<Map.Entry<String, String>> set = licList.entrySet();
//        for (Map.Entry<String, String> ll : set) {
//            System.out.print(ll.getKey() + ": ");
//            System.out.println(ll.getValue());
//        }
//
//        System.out.println(pcName + " " + osName + " " + osSP + " " + ramSize + "\n " + printList.toString() + "\n " + listLicences);
//        System.out.println(listLicences);

        sc.close();
        doReport(anItem, numItems++);

    }


}
