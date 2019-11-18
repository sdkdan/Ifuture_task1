package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finder {

    public void findFile(String name, File file) {
        File[] list = file.listFiles();
        if (list != null) {
            for (File fil : list) {
                if (file.isDirectory()) {
                    findFile(name, fil);
                } else if (name.equalsIgnoreCase(fil.getName())) {
                    System.out.println(fil.getParentFile());
                }
            }
        }
    }

//    public String fileFilter(String directory, String extension) {
////        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////        String s = reader.readLine(); //как то получаем имя каталога или папки
////        reader.close();
//        File f = new File(directory);
//        File[] matchingFiles = f.listFiles(new FilenameFilter() {
//            public boolean accept(File dir, String name) {
//                return name.endsWith(extension);  //находим файл с нужным расширением
//            }
//        });
//    }

    public List<String> textFiles(String directory, String extension) {
        List<String> textFiles = new ArrayList<String>();
        File dir = new File(directory);
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((extension))) {
                textFiles.add(file.getName());
            }
        }
        return textFiles;
    }

    public List<String> searching(File rootDir, String extension) {
        List<String> result = new ArrayList<>();

        LinkedList<File> dirList = new LinkedList<>();
        if (rootDir.isDirectory()) {
            dirList.addLast(rootDir);
        }

        while (dirList.size() > 0) {
            File[] filesList = dirList.getFirst().listFiles();
            if (filesList != null) {
                for (File path : filesList) {
                    if (path.isDirectory()) {
                        dirList.addLast(path);
                    } else {
                        String simpleFileName = path.getName();

                        if (simpleFileName.endsWith(extension)) {
                            result.add(path.getAbsolutePath().toString());
                        }
                    }
                }
            }
            dirList.removeFirst();
        }
        return result;
    }

    public boolean fileContainsWord(String fileName, String word) throws IOException {
//        return Files.lines(Paths.get(fileName))
//                .map(line -> line.split(" *"))
//                .flatMap(Arrays::stream)
//                .distinct()
//                .anyMatch(w -> w.equals(word));
        return new String(Files.readAllBytes(Paths.get(fileName))).contains(word);
    }

    public List<String> fileList(String pathName, String extension) {
        List<String> result = new ArrayList<>();
        try {
            Stream<Path> walk = Files.walk(Paths.get(pathName));
            result = walk.map(x -> x.toString())
                    .filter(f -> f.endsWith(extension)).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean wordFound(List<String> wordsToFind, String pathName)  {
        String s;
        int i = wordsToFind.size();
        int counter = 0; //найденные слова
        ArrayList<String> list = new ArrayList<>();
        try {
        FileReader reader = new FileReader(new File(pathName));
        BufferedReader br = new BufferedReader(reader);
        while (i > 0) {
            while ((s = br.readLine()) != null) {
                for (String str : wordsToFind
                ) {
                    if (s.contains(str)) {
                        i--;
                        counter++;
                        System.out.println("слово найдено " + str);

                    } else i--;
                }
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (counter == wordsToFind.size()) {
            System.out.println("слова найдены");
           // list.add(pathName);
            return true;
        } else return false;
    }

    public ArrayList<String> strToList(String s) {
        ArrayList<String> list;
        list = new ArrayList<>(Arrays.asList(s.split("[[ ]*|[,]*|[\\.]*|[:]*|[/]*|[!]*|[?]*|[+]*]+")));
        return list;
    }

//     <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
//        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
//                new Comparator<Map.Entry<K,V>>() {
//                    @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
//                        int res = e1.getValue().compareTo(e2.getValue());
//                        return res != 0 ? res : 1; // Special fix to preserve items with equal values
//                    }
//                }
//        );
//        sortedEntries.addAll(map.entrySet());
//        return sortedEntries;
//    }
}
