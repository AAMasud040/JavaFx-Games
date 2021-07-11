package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import static sample.StaticConstants.HEIGTH;
import static sample.StaticConstants.WIDTH;

public class HitandSlash {
    Pane root;
    public int moveDis = 3;
    public String url = "/Assets/images/cannon ball_2.png";
    ImageViewGameObject imageViewGameObject2;
    public HitandSlash() {

        root = new Pane();

        ImageViewGameObject imageViewGameObject1 = new ImageViewGameObject(root,url,50,50);
        imageViewGameObject2 = new ImageViewGameObject(root,url,50,50);

        double H = ( HEIGTH - imageViewGameObject1.GetHeight() );
        double W = ( WIDTH - imageViewGameObject1.GetWidth() ) / 2;

        imageViewGameObject1.SetXY(W,H);

        H =(HEIGTH-imageViewGameObject2.GetHeight())/2;
        W =(WIDTH-imageViewGameObject2.GetWidth())/2;

        imageViewGameObject2.SetXY(W,H);

        //starts timeline here
        startTimeline(imageViewGameObject1,0);

        Scene scene = root.getScene();



    }

    private void isHitTopBottom(ImageViewGameObject imageViewGameObject)
    {
        if((HEIGTH-imageViewGameObject.GetY())>HEIGTH)
        {
            moveDis = moveDis * -1;
        }
        if((HEIGTH-imageViewGameObject.GetHeight()-imageViewGameObject.GetY())<0)
        {
            moveDis = moveDis * -1;
        }
        imageViewGameObject.SetY(imageViewGameObject.GetY() -  moveDis);
    }

    private  void isCollide(ImageViewGameObject imageViewGameObject_1,ImageViewGameObject imageViewGameObject_2)
    {
        if(imageViewGameObject_1.getImageViewBounds().intersects(imageViewGameObject_2.getImageViewBounds()))
        {
            startTimeline(imageViewGameObject_2,30);
        }
    }

    private void startTimeline(ImageViewGameObject imageViewGameObject,int delay)
    {
        Timeline timeline = new Timeline(
                new KeyFrame(
                        Duration.millis(20),
                        (evt)->{
                            isHitTopBottom(imageViewGameObject);
                        }

                ));
        timeline.setDelay(Duration.seconds(delay));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    public Parent getRoot()
    {
        return root;
    }

    public ImageViewGameObject getGameObj()
    {
        return  imageViewGameObject2;
    }
}
