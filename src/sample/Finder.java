package sample;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Finder {

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

    public boolean wordFound(List<String> wordsToFind, String pathName) {
        String s;
        int i = wordsToFind.size();
        int counter = 0; //найденные слова
        ArrayList<String> list = new ArrayList<>();
        try {
            FileReader reader = new FileReader(new File(pathName));
            BufferedReader br = new BufferedReader(reader);
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(pathName)));
            while (i > 0) {
                while ((s = reader1.readLine()) != null) {
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

}
