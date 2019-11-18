package sample;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private Button button1;
    @FXML
    private TextArea textArea1; //расширение
    @FXML
    private TextArea textArea2; //директория
    @FXML
    private TextArea textArea3; //текст для поиска
    @FXML
    private TextArea textArea5;  // для вывода файла
    @FXML
    private ListView listView1; // для вывода файлов с найденным текстом
    @FXML
    private TabPane tabPane;


    private SingleSelectionModel<Tab> singleSelectionModel;

    public void initialize() {
    }


    public void searchText(ActionEvent event) {
        Finder finder = new Finder();
        String extension = textArea1.getText();
        String path = textArea2.getText();
        String textToSearch = textArea3.getText();
        List<String> listWordsToFind = finder.strToList(textToSearch);
        List<String> list = finder.fileList(path, extension);
        List<String> fileList = new ArrayList<>();
        for (String s : list
        ) {
            if (finder.wordFound(listWordsToFind, s)) {
                fileList.add(s);
            }
        }

        listView1.getItems().addAll(fileList);
        listView1.setOnMouseClicked(event1 -> {
            String selectedFile = listView1.getSelectionModel().getSelectedItems().toString();
            String str = selectedFile.substring(1, selectedFile.length() - 1);
            displayFile(str);
            TextArea textArea = new TextArea();
            Tab tab = new Tab(str, textArea);
            displayFileToTab(str, textArea);
            tab.setClosable(true);
            tabPane.getTabs().add(tab);
            tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        });

    }


    public void displayFile(String path) {
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(reader);// обычно используем этот
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp866")); //пробовал менять кодировки
            String s;
            while ((s = reader1.readLine()) != null) {
                textArea5.appendText(s + '\n');
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
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp866")); //пробовал менять кодировки
            StringBuilder string = null;
            String s;
            while ((s = reader1.readLine()) != null) {
//                stringBuilder.append(s+'\n');
                //System.out.println(s);
                textArea.appendText(s + '\n');

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class FinderService extends Service<Finder>{
        public Task<Finder> createTask(){
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


