package ifpr.pgua.eic.biblioteca.telas;

import ifpr.pgua.eic.biblioteca.repositorios.Biblioteca;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class CadastroAutor {

    @FXML
    private TextField tfNome;
    
    @FXML
    private TextField tfEmail;
    
    @FXML
    private TextField tfCpf;
    
    private Biblioteca biblioteca;

    public CadastroAutor(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    @FXML
    private void cadastrar(){
        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String cpf = tfCpf.getText();

        String msg = "";
        boolean possuiErro = false;

        if(nome.isBlank() || nome.isEmpty()){
            msg += "Nome não pode ser vazio!\n";
            possuiErro = true;
        }

        if(email.isBlank() || email.isEmpty()){
            msg += "Email não pode ser vazio!\n";
            possuiErro = true;
        }

        if(cpf.isBlank() || cpf.isEmpty()){
            msg += "Cpf não pode ser vazio!";
            possuiErro = true;
        }


        if(!possuiErro){
            boolean retorno = biblioteca.cadastraAutor(nome, email, cpf);
            
            if(retorno){
                msg = "Autor cadastrado com sucesso!!";
            }else{
                msg = "Autor com dados inválidos!!";
            }
        
        }

        Alert popup = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        popup.showAndWait();
    }

    @FXML
    private void limpar(){
        tfNome.clear();
        tfCpf.clear();
        tfEmail.clear();
    }

}
