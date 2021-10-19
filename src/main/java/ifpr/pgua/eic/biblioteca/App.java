package ifpr.pgua.eic.biblioteca;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws Exception{
        

        var scene = new Scene(new VBox(), 640, 480);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}