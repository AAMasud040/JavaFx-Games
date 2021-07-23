package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/*public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}*/



public class Main extends Application {

    // colums = 6, Count = 12,offset_x = 1,offset_y = 1,W=109,H = 154 Dancing.jg Dancing image
    // colums = 4, Count = 10,offset_x = 18,offset_y = 25,W=374,H = 243 The_Horse_in_Motion.jpg Horse Image

    private static String FileName = "The_Horse_in_Motion.jpg";//"Dancing.jg";
    private static final Image IMAGE = new Image("sample/"+FileName);
    /* //Dancing.JPG
    private static final int COLUMNS  =   6;
    private static final int COUNT    =  12;
    private static final int OFFSET_X =  1;
    private static final int OFFSET_Y =  1;
    private static final int WIDTH    = 109;
    private static final int HEIGHT   = 154;*/

    //The_Horse_in_Motion.jpg
    private static final int COLUMNS  =   4;
    private static final int COUNT    =  10;
    private static final int OFFSET_X =  18;
    private static final int OFFSET_Y =  25;
    private static final int WIDTH    = 374;
    private static final int HEIGHT   = 243;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        // scale = 1 for no scaling, accepts values up to 5 MAX
        final int scale = scaleVerify(1);
        final int SCALEDWIDTH    = WIDTH*scale;
        final int SCALEDHEIGHT   = HEIGHT*scale;
        primaryStage.setTitle("The Horse in Motion");

        final ImageView imageView = new ImageView(IMAGE);

        //for scaled image use scaledheight and width mentioned above uncomment
        imageView.setViewport(new Rectangle2D(OFFSET_X, OFFSET_Y, SCALEDWIDTH, SCALEDHEIGHT));

        final Animation animation = new SpriteAnimation(
                imageView,
                Duration.millis(1000),
                COUNT, COLUMNS,
                OFFSET_X, OFFSET_Y,
                WIDTH, HEIGHT
                ,scale
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();
        primaryStage.setScene(new Scene(new Group(imageView)));
        primaryStage.show();

    }
    public int scaleVerify(int scale)
    {
        if(scale>0 && scale<=5)
        {
            return scale;
        }
        else
        {
            return 1;
        }
    }
}