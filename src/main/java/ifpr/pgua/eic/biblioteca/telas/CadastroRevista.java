package ifpr.pgua.eic.biblioteca.telas;

import ifpr.pgua.eic.biblioteca.repositorios.Biblioteca;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CadastroRevista {
    
    private VBox root;

    private Label lbTitulo;
    private TextField tfTitulo;

    private Label lbEditora;
    private TextField tfEditora;

    private Label lbNumero;
    private TextField tfNumero;

    private Label lbPaginas;
    private TextField tfPaginas;

    private Label lbAnoPublicacao;
    private TextField tfAnoPublicacao;

    private Button btAdicionar;
    private Button btLimpar;
    
    private Biblioteca biblioteca;

    public CadastroRevista(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
        inicializa();
    }

    private void inicializa(){
        root = new VBox();
        root.setSpacing(5.0);
        root.setPadding(new Insets(8.0));

        lbTitulo = new Label("Título:");
        lbTitulo.setLabelFor(tfTitulo);
        tfTitulo = new TextField();
        root.getChildren().addAll(lbTitulo,tfTitulo);

        lbEditora = new Label("Editora:");
        lbEditora.setLabelFor(tfEditora);
        tfEditora = new TextField();
        root.getChildren().addAll(lbEditora,tfEditora);

        lbNumero = new Label("Número:");
        lbNumero.setLabelFor(tfNumero);
        tfNumero = new TextField();
        root.getChildren().addAll(lbNumero,tfNumero);

        lbPaginas = new Label("Páginas:");
        lbPaginas.setLabelFor(tfPaginas);
        tfPaginas = new TextField();
        root.getChildren().addAll(lbPaginas,tfPaginas);

        lbAnoPublicacao = new Label("Ano de Publicação:");
        lbAnoPublicacao.setLabelFor(tfAnoPublicacao);
        tfAnoPublicacao = new TextField();
        root.getChildren().addAll(lbAnoPublicacao,tfAnoPublicacao);

        HBox botoes = new HBox();
        botoes.setSpacing(5.0);

        btAdicionar = new Button("Adicionar");
        btAdicionar.setOnAction((evt)->{
            cadastrar();
        });
        
        botoes.getChildren().addAll(btAdicionar);

        btLimpar = new Button("Limpar");
        btLimpar.setOnAction((evt)->{
            limpar();
        });

        botoes.getChildren().addAll(btLimpar);

        root.getChildren().add(botoes);
    }

    private void cadastrar(){
        String titulo = tfTitulo.getText();
        String editora = tfEditora.getText();
        int anoPublicacao = Integer.valueOf(tfAnoPublicacao.getText());
        int numero = Integer.valueOf(tfNumero.getText());
        int paginas = Integer.valueOf(tfPaginas.getText());

        String msg = "";
        boolean flag = true;

        if( paginas < 10 ){
            msg += "Número de páginas inválido!";
            flag = false;
        }

        if(flag){
            
            boolean ret = biblioteca.cadastraRevista(titulo, numero, anoPublicacao, paginas, editora);
            if(ret){
                msg = "Cadastro realizado!";
                limpar();
            }else{
                msg = "Cadastro não realizado!";
            }
        }

        Alert popup = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
        popup.showAndWait();
    }

    private void limpar(){
        tfTitulo.setText("");
        tfAnoPublicacao.setText("");
        tfEditora.setText("");
        tfNumero.setText("");
        tfPaginas.setText("");
    }

    public VBox getRoot(){
        return this.root;
    }
}
