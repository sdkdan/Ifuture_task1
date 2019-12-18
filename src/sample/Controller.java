package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static sample.History.filesFounded;
import static sample.History.wordsSearched;

public class Controller {

    @FXML
    private Button button1;
    @FXML
    private TextArea extensionArea; //расширение
    @FXML
    private TextArea pathArea; //директория
    @FXML
    private TextArea searchArea; //текст для поиска
    @FXML
    private TextArea outputText;  // для вывода файла
    @FXML
    private ListView textToTab; // для вывода файлов с найденным текстом
    @FXML
    private TabPane tabPane;
    @FXML
    private TextArea hsWords;
    @FXML
    private TextArea hsFiles;



    private SingleSelectionModel<Tab> singleSelectionModel;

    public void initialize() {
    }


    public void searchText(ActionEvent event) {
        Finder finder = new Finder();
        History history = new History();
        String extension = extensionArea.getText();
        String path = pathArea.getText();
        String textToSearch = searchArea.getText();
        wordsSearched.add(textToSearch);
        List<String> listWordsToFind = finder.strToList(textToSearch);
        List<String> list = finder.fileList(path, extension);
        List<String> fileList = new ArrayList<>();  //список файлов с найденным текстом
        for (String s : list
        ) {
            if (finder.wordFound(listWordsToFind, s)) {
                fileList.add(s);
                filesFounded.add(s);

            }
        }

        textToTab.getItems().addAll(fileList);
        textToTab.setOnMouseClicked(event1 -> {
            String selectedFile = textToTab.getSelectionModel().getSelectedItems().toString();
            String str = selectedFile.substring(1, selectedFile.length() - 1);
            displayFile(str);
            TextArea textArea = new TextArea();
            Tab tab = new Tab(str, textArea);
            displayFileToTab(str, textArea);
            tab.setClosable(true);
            tabPane.getTabs().add(tab);
            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        });

        for (String s: wordsSearched
             ) {
            hsWords.appendText(s);
        }
        for (String s: filesFounded
        ) {
            hsFiles.appendText(s);
        }

    }


    public void displayFile(String path) {
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(reader);// обычно используем этот
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp866")); //пробовал менять кодировки
            String s;
            while ((s = reader1.readLine()) != null) {
                outputText.appendText(s + '\n');
                //System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void displayFileToTab(String path, TextArea textArea) {
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(reader);// обычно используем этот
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8")); //пробовал менять кодировки
            StringBuilder string = null;
            String s;
            while ((s = reader1.readLine()) != null) {
//                stringBuilder.append(s+'\n');
                //System.out.println(s);
                textArea.appendText(s + '\n');
                System.out.println(s);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class FinderService extends Service<Finder> {
        public Task<Finder> createTask() {
            return new Task<Finder>() {
                @Override
                protected Finder call() throws Exception {
                    return null; //вызов метода
                }

                @Override
                protected void succeeded() {
                    //weather.getValue
                    //settext
                }

                @Override
                protected void failed() {
                    super.failed();
                }
            };
        }
    }
}


