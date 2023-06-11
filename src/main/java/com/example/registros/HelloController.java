package com.example.registros;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

public class HelloController {
    public TextField usernameTextField;
    public PasswordField passwordField;
    public Label loginMessageField;
    public RadioButton ProfessorButton;
    public RadioButton FuncionarioButton;
    public RadioButton AlunoButton;

    public void MudarParaFuncionario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("funcionario.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void MudarAreaSingUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MudarParaLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }








    public void MudarParaProfessor(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("professor.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void MudarParaAluno(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("aluno.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    public void MudarParaHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("HOME.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }


    @FXML
    private Button cancelButton;

    public void cancelButton(ActionEvent event){
        Stage stage= (Stage)  cancelButton.getScene().getWindow();
        stage.close();
    }




    public void AcessoLogin(){

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getconection();



        String TableName = "";
        if (ProfessorButton.selectedProperty().get()) {
            TableName = "registroprofessor";
        } else if (FuncionarioButton.selectedProperty().get()) {
            TableName = "registrofuncionario";
        } else if (AlunoButton.selectedProperty().get()){
            TableName = "registoaluno";
        }


        String verifyLogin = "SELECT count(1) FROM "+TableName+" WHERE username = '" + usernameTextField.getText() + "' AND password = '" + passwordField.getText() + "'";

        try {

            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    loginMessageField.setText("Welcome");
                    //CreateAccount();

                } else {
                    loginMessageField.setText("Inválido!Tente de novo");
                }
            }


        } catch (Exception e) {
            e.printStackTrace();

        }











    }

    }