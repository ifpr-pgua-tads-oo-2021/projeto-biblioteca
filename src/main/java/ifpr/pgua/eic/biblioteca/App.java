package ifpr.pgua.eic.biblioteca;

import ifpr.pgua.eic.biblioteca.repositorios.Biblioteca;
import ifpr.pgua.eic.biblioteca.telas.CadastroAutor;
import ifpr.pgua.eic.biblioteca.telas.CadastroRevista;
import ifpr.pgua.eic.biblioteca.telas.Listas;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 * JavaFX App
 */
public class App extends Application {

    private CadastroAutor cadastroAutor;
    private CadastroRevista cadastroRevista;
    private Listas listas;
    private Biblioteca biblioteca = new Biblioteca();

    private BorderPane painelPrincipal;
    private StackPane regiaoCentral;
    private VBox regiaoEsquerda;

    @Override
    public void start(Stage stage) throws Exception{
        
        painelPrincipal = new BorderPane();

        regiaoCentral = new StackPane();
        
        regiaoEsquerda = new VBox();
        regiaoEsquerda.setSpacing(5.0);
        regiaoEsquerda.setPadding(new Insets(10.0));

        painelPrincipal.setLeft(regiaoEsquerda);
        painelPrincipal.setCenter(regiaoCentral);

        Button btListas = new Button("Listas");
        btListas.setOnAction((evt)->{
            
            listas = new Listas(biblioteca);
            regiaoCentral.getChildren().clear();
            regiaoCentral.getChildren().add(listas.getRoot());
        });

        regiaoEsquerda.getChildren().add(btListas);

        Button btAutores = new Button("Cadastro Autor");
        btAutores.setOnAction((evt)->{
            //cadastroAutor = new CadastroAutor(biblioteca);
            regiaoCentral.getChildren().clear();
            regiaoCentral.getChildren().add(loadFXML("fxml/cadastro_autor.fxml", (o)->{return new CadastroAutor(biblioteca);}));
        });
        regiaoEsquerda.getChildren().add(btAutores);

        Button btRevista = new Button("Cadastro de Revista");
        btRevista.setOnAction((evt)->{
            cadastroRevista = new CadastroRevista(biblioteca);
            regiaoCentral.getChildren().clear();
            regiaoCentral.getChildren().add(cadastroRevista.getRoot());
        });
        regiaoEsquerda.getChildren().add(btRevista);

        Scene scene = new Scene(painelPrincipal, 640, 480);
        
        stage.setScene(scene);
        stage.show();
    }

    private Parent loadFXML(String fxml, Callback controller){

        Parent root = null;
        
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxml));
            loader.setControllerFactory(controller);

            root = loader.load();

        }catch(Exception e){
            System.out.println("Deu erro no carregamento do FXML!! Está certo? "+fxml);
        }

        return root;
    }

    public static void main(String[] args) {
        launch();
    }

}