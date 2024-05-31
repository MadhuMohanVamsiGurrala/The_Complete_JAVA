public aimport javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;

public class BasesFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Label codeBaseLabel = new Label();
        Label documentBaseLabel = new Label();
        
        URL codeBase = getClass().getProtectionDomain().getCodeSource().getLocation();
        codeBaseLabel.setText("Code base: " + codeBase.toString());
        
        // Document base is not directly available in JavaFX, but if needed, 
        // it can be managed similarly to code base.
        URL documentBase = getClass().getResource("/");
        documentBaseLabel.setText("Document base: " + documentBase.toString());
        
        root.getChildren().addAll(codeBaseLabel, documentBaseLabel);
        
        Scene scene = new Scene(root, 300, 100);
        primaryStage.setScene(scene);
        primaryStage.setTitle("BasesFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
 {
    
}
