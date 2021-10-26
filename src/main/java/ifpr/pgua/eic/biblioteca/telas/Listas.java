package ifpr.pgua.eic.biblioteca.telas;

import ifpr.pgua.eic.biblioteca.modelos.Autor;
import ifpr.pgua.eic.biblioteca.modelos.ItemAcervo;
import ifpr.pgua.eic.biblioteca.repositorios.Biblioteca;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;

public class Listas {

    private FlowPane root;

    private Label lbAutores;
    private ListView<Autor> lstAutores;
    private Label lbItems;
    private ListView<ItemAcervo> lstItems;

    private Biblioteca biblioteca;

    public Listas(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
        inicializaComponentes();
    }

    private void inicializaComponentes(){
        root = new FlowPane();

        root.setHgap(8.0);
        root.setVgap(8.0);
        root.setPadding(new Insets(10.0));


        
        lbAutores = new Label("Autores:");
        lstAutores = new ListView<>();
        lbAutores.setLabelFor(lstAutores);

        lstAutores.getItems().addAll(biblioteca.getAutores());

        VBox tmp = new VBox();
        tmp.setSpacing(5.0);
        tmp.getChildren().addAll(lbAutores,lstAutores);

        root.getChildren().addAll(tmp);

        lbItems = new Label("Items:");
        lstItems = new ListView<>();

        lstItems.getItems().addAll(biblioteca.getLivros());
        lstItems.getItems().addAll(biblioteca.getRevistas());
        

        tmp = new VBox();
        tmp.setSpacing(5.0);
        tmp.getChildren().addAll(lbItems,lstItems);

        root.getChildren().addAll(tmp);
    }

    public FlowPane getRoot(){
        return root;
    }

    
}
