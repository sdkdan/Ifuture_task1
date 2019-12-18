package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private TextField regName;
    @FXML
    private TextField regSurname;
    @FXML
    private TextField regUsername;
    @FXML
    private TextField regPassword;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnRegAction(ActionEvent event) throws Exception{
        User user = new User();
        user.setName(regName.getText());
        user.setSurName(regSurname.getText());
        user.setLogin(regUsername.getText());
        user.setPassword(regPassword.getText());
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Title");
        stage.show();

    }
}
