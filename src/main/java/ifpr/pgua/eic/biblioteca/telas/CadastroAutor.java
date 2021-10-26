package ifpr.pgua.eic.biblioteca.telas;

import ifpr.pgua.eic.biblioteca.repositorios.Biblioteca;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class CadastroAutor {

    private VBox root;
    private Label lbNome;
    private TextField tfNome;
    private Label lbEmail;
    private TextField tfEmail;
    private Label lbCpf;
    private TextField tfCpf;
    private Button btAdicionar;
    
    private Biblioteca biblioteca;

    public CadastroAutor(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
        inicializaComponentes();
    }

    private void inicializaComponentes(){
        root = new VBox();

        root.setSpacing(5.0);
        root.setPadding(new Insets(10.0));
        
        lbNome = new Label("Nome:");
        tfNome = new TextField();
        lbNome.setLabelFor(tfNome);
        
        root.getChildren().addAll(lbNome,tfNome);


        lbEmail = new Label("Email:");
        tfEmail = new TextField();
        lbEmail.setLabelFor(tfEmail);
        
        root.getChildren().addAll(lbEmail,tfEmail);

        lbCpf = new Label("Cpf:");
        tfCpf = new TextField();
        lbCpf.setLabelFor(tfCpf);
        
        root.getChildren().addAll(lbCpf,tfCpf);

        btAdicionar = new Button("Adicionar");
        btAdicionar.setOnAction((evt)->{
            cadastra();
        });

        root.getChildren().add(btAdicionar);
    }

    private void cadastra(){
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

    public VBox getRoot(){
        return root;
    }
    
}
