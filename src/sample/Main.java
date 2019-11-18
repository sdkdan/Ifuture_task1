package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage)  {
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();
//        SplitPane splitPane = new SplitPane();
//        splitPane.getItems().addAll(createListView(), createListView());
//
//        TabPane tabPane = new TabPane();
//        Tab splitTab = new Tab("SplitPane Tab");
//        splitTab.setContent(splitPane);
//        tabPane.getTabs().addAll(new Tab("Empty Tab"), splitTab);
//
//        Scene scene = new Scene(tabPane, 500, 500);
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("SplitPane Inside TabPane Sample");
//        primaryStage.show();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            //Parent p = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("My Application");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private ListView<String> createListView() {
        ObservableList<String> items = FXCollections.observableArrayList("Animal", "Mineral", "Vegetable");
        ListView<String> listView = new ListView<String>(items);
        return listView;
    }


    public static void main(String[] args) throws IOException {
        launch(args);
        //File dir = new File("/Users/daniilstoletov/Documents"); ///lab7.pages
//        if (dir.isDirectory()) {
//            for (File item : dir.listFiles()) {
//
//                if (item.isDirectory()) {
//                    System.out.println(item.getName() + "  \t folder");
//                } else {
//
//                    System.out.println(item.getName() + "\t file");
//                }
//            }
//        }

//        Finder finder = new Finder();
//        try {
//            System.out.println(
//                    finder.fileContainsWord("/Users/daniilstoletov/Desktop/1.rtf", "idi suda suka priv"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        FileReader reader = new FileReader(new File("/Users/daniilstoletov/Desktop/1.rtf"));
//        BufferedReader br = new BufferedReader(reader);
//        String s = null;
//        ArrayList<String> wordsToFind = new ArrayList<>();
//        ArrayList<String> wordsToFind1 = new ArrayList<>();
//        wordsToFind1.add("search me");
//        wordsToFind.add("demon");
//        wordsToFind.add("r2d2suka");
//        wordsToFind.add("solve");
//        wordsToFind.add("kurt");
//        wordsToFind.add("friend");
//        wordsToFind.add("my");
//        wordsToFind.add("booooy");
//        wordsToFind.add("stay");
        // wordsToFind.add("solve1");
//        while((s = br.readLine()) != null) {
//            if(s.contains("falsefalse")) {
//                System.out.println("String found");
//                return;
//            }
//        }
////        System.out.println("String not found");
//        int i = wordsToFind.size();
//        int counter = 0; //найденные слова
//        while (i > 0) {
//            while ((s = br.readLine()) != null) {
//                for (String str : wordsToFind
//                ) {
//                    if (s.contains(str)) {
//                        i--;
//                        counter++;
//                        System.out.println("slovo naideno " + str);
//                    } else {
//
//                    }
//
//
//                }
//            }
//        }
//        if (counter == i) System.out.println("слова найдены");

//        Finder f1 = new Finder();
//        List<String> list;
//        list = f1.fileList("/Users/daniilstoletov", "rtf");
//        for (String string: list
//             ) {
//            f1.wordFound(wordsToFind, string);
//        }

//        System.out.println((f1.wordFound(wordsToFind, "/Users/daniilstoletov/Desktop/1.rtf")));
//        for (String s1 : f1.strToList("privet, et ya: dfd. EEF")
//        ) {
//            System.out.println(s1);
//        }

//        System.out.println(f.textFiles("/Users/daniilstoletov/Desktop", ".rtf"));
//        System.out.println(list);
        //File file = new File("/Users/daniilstoletov");
//        System.out.println(f.searching(file,".rtf"));
//        List<String> list = f.searching(file,".rtf");
//
//        for (String str: list
//             ) {
//            f.wordFound(wordsToFind1, str);
//        }


//        for (String s1: f.strToList("privet, et ya: dfd. EEF")
//        ) {
//            System.out.println(s1);
//        }
//        try (Stream<Path> walk = Files.walk(Paths.get("/Users/daniilstoletov/desktop"))) {
//
//            List<String> result = walk.map(x -> x.toString())
//                    .filter(f -> f.endsWith(".rtf")).collect(Collectors.toList());
//
//            result.forEach(System.out::println);
//            for (String str: result
//             ) {
//                System.out.println(f1.wordFound(wordsToFind, str));
//        }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
