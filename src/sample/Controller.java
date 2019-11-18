package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
        listView1.setOnMouseClicked(event1 ->{
        String selectedFile = listView1.getSelectionModel().getSelectedItems().toString();
        String str = selectedFile.substring(1,selectedFile.length()-1);
            displayFile(str);});
        //int selectedFileId = Integer.parseInt(listView1.getSelectionModel().getSelectedIndices().toString());

        //listView1.getOnMouseClicked();
    }

    public void displayFile(String path) {
        try {
            FileReader reader = new FileReader(new File(path));
            BufferedReader br = new BufferedReader(reader);// обычно используем этот
            BufferedReader reader1 = new BufferedReader(new InputStreamReader(new FileInputStream(path),"Cp866")); //пробовал менять кодировки

            String s;
            while (( s = reader1.readLine()) != null) {
                textArea5.appendText(s + '\n');
                //System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayFile(MouseEvent mouseEvent) {
    }
}
