package com.example.registros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Objects;

public class Alunocontroller {
    public AnchorPane VoltarPagina;
    public TextField campoApelido;
    public TextField campoUsername;
    public TextField campoNome;
    public TextField campoTelefone;
    public TextField campoEmail;
    public PasswordField campoPassword;
    public DatePicker campoData;
    public Button butaoRegistroAluno;
    @FXML
    private Button cancelButton;

    public void cancelButton(ActionEvent event){
        Stage stage= (Stage)  cancelButton.getScene().getWindow();
        stage.close();
    }
    public void MudarAreaSingUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void StudentRegister(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getconection();

        String apelido = campoApelido.getText();
        String nome = campoNome.getText();
        String username = campoUsername.getText();
        String password = campoPassword.getText();
        String email = campoEmail.getText();
        String data = String.valueOf(campoData.getTooltip());
        String telefon = campoTelefone.getText();

        String insertFiels = "INSERT INTO registoaluno(nome,apelido,Username,dataNascimento,numerotelefone,email,password) VALUES ('";
        String insertValues = nome +"','"+ apelido +"','"+ username +"','"+ data+"','"+telefon+"','"+email+"','"+password+"')";

        String insertToRegister = insertFiels + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    
}
}
