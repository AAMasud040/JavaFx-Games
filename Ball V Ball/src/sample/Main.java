package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static sample.StaticConstants.HEIGTH;
import static sample.StaticConstants.WIDTH;

public class Main extends Application {

    HitandSlash HS;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Scene scene = new Scene(createContent(),
                HEIGTH,
                WIDTH,
                Color.GRAY);

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        ImageViewGameObject gobj = HS.getGameObj();

        Controller controller = new Controller(scene);
        controller.Listen(gobj);


    }

    private Parent createContent() {
        HS = new HitandSlash();
        return  HS.getRoot();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
