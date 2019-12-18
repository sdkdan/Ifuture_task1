package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;



import java.net.URL;
import java.util.ResourceBundle;

import static sample.User.users;

public class LoginController implements Initializable {

    @FXML
    private PasswordField txtPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private Label lblMessage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnLoginAction(ActionEvent event) throws Exception {
        for (User u: users
             ) {
            if((txtPassword.getText().equals(u.getPassword()) && (txtUsername.getText().equals(u.getLogin())) )){
                ((Node) (event.getSource())).getScene().getWindow().hide();
                Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(parent);
                stage.setScene(scene);
                stage.setTitle("Title");
                stage.show();
            }else {
                lblMessage.setText("Имя пользователя или пароль неверные");
            }
        }


//        if (txtPassword.getText().equals("1") && txtUsername.getText().equals("1")) {
//            ((Node) (event.getSource())).getScene().getWindow().hide();
//            Parent parent = FXMLLoader.load(getClass().getResource("sample.fxml"));
//            Stage stage = new Stage();
//            Scene scene = new Scene(parent);
//            stage.setScene(scene);
//            stage.setTitle("Title");
//            stage.show();
//        } else {
//            lblMessage.setText("Имя пользователя или пароль неверные");
//        }
    }

    public void btnLoginReg(ActionEvent event) throws Exception {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent parent = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Title");
        stage.show();
    }
}
