package sample;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import static sample.StaticConstants.HEIGTH;
import static sample.StaticConstants.WIDTH;

public class Controller extends HitandSlash{

    Scene scene;
    boolean UP,DOWN,LEFT,RIGHT,DASH;
    double TopFrame,BottomFrame,LeftFrame,RightFrame;
    public int movedis = 10;
    public Controller(Scene s)
    {
        scene = s;
        System.out.println("Initialized !");
        UP = false;
        DOWN = false;
        LEFT = false;
        RIGHT = false;
        DASH = false;
    }

    public void Listen(ImageViewGameObject imageViewGameObject2) {

        onKeyPressed(imageViewGameObject2);
        onKeyReleased();
    }

    protected  void onKeyPressed(ImageViewGameObject imageViewGameObject2)
    {
        scene.setOnKeyPressed(
                (e)-> {
                    if(e.getCode() == KeyCode.UP)
                    {
                        System.out.println("UP");
                        UP = true;
                    }
                    if(e.getCode() == KeyCode.DOWN)
                    {
                        System.out.println("DOWN");
                        DOWN = true;
                    }
                    if(e.getCode() == KeyCode.LEFT)
                    {
                        System.out.println("LEFT");
                        LEFT = true;
                    }
                    if(e.getCode() == KeyCode.RIGHT)
                    {
                        System.out.println("RIGHT");
                        RIGHT = true;
                    }
                    if(e.getCode() == KeyCode.D)
                    {
                        System.out.println("Dashing");
                        DASH = true;
                    }

                    controllerSettings(imageViewGameObject2);
                }
        );
    }

    protected  void onKeyReleased()
    {
        scene.setOnKeyReleased(
                (e)-> {
                    if(e.getCode() == KeyCode.UP)
                    {
                        System.out.println("UP");
                        UP = false;
                    }
                    if(e.getCode() == KeyCode.DOWN)
                    {
                        System.out.println("DOWN");
                        DOWN = false;
                    }
                    if(e.getCode() == KeyCode.LEFT)
                    {
                        System.out.println("LEFT");
                        LEFT = false;
                    }
                    if(e.getCode() == KeyCode.RIGHT)
                    {
                        System.out.println("RIGHT");
                        RIGHT = false;
                    }
                    if(e.getCode() == KeyCode.D)
                    {
                        System.out.println("Dashing");
                        DASH = false;
                    }
                }
        );
    }

    protected void controllerSettings(ImageViewGameObject imageViewGameObject2)
    {
        TopFrame = StaticConstants.HEIGTH - imageViewGameObject2.GetY();
        BottomFrame = StaticConstants.HEIGTH - imageViewGameObject2.GetHeight() -imageViewGameObject2.GetY();
        LeftFrame = StaticConstants.WIDTH - imageViewGameObject2.GetX();
        RightFrame = StaticConstants.WIDTH - imageViewGameObject2.GetWidth() - imageViewGameObject2.GetX();

        if(UP == true && LEFT == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX()-movedis, imageViewGameObject2.GetY()-movedis);
            movedis = 10;

        }
        else if(UP == true && RIGHT == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX()+movedis, imageViewGameObject2.GetY()-movedis);
            movedis = 10;
        }
        else if(DOWN == true && LEFT == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX()-movedis, imageViewGameObject2.GetY()+movedis);
            movedis = 10;
        }
        else if(DOWN == true && RIGHT == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX()+movedis, imageViewGameObject2.GetY()+movedis);
            movedis = 10;
        }
        else if(UP == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX(), imageViewGameObject2.GetY()-movedis);
            movedis = 10;
        }
        else if(DOWN == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX(), imageViewGameObject2.GetY()+movedis);
            movedis = 10;
        }
        else if(LEFT == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX()-movedis, imageViewGameObject2.GetY());
            movedis = 10;
        }
        else if(RIGHT == true)
        {
            if(DASH == true)
            {
                movedis = 20;
            }
            imageViewGameObject2.SetXY( imageViewGameObject2.GetX()+movedis, imageViewGameObject2.GetY());
            movedis = 10;
        }
    }
}
