public aimport javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class ACDemoFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("Open HTML File");
        btn.setOnAction(event -> {
            try {
                File file = new File("Test.html"); // Ensure Test.html is in the same directory
                if (file.exists()) {
                    Desktop.getDesktop().browse(file.toURI());
                } else {
                    System.out.println("File not found");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        Scene scene = new Scene(root, 300, 50);

        primaryStage.setTitle("ACDemoFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
 {
    
}
