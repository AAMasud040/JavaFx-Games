package sample;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ImageViewGameObject {
    private ImageView imageView;
    private Image image;

    ImageViewGameObject(Pane root, String url, double Height, double Width)
    {
        image = new Image(url,Height,Width,false,true);
        imageView = new ImageView(image);
        imageView.setCache(true);

        root.getChildren().add(imageView);
    }
    void SetXY(double X,double Y)
    {
        imageView.setX(X);
        imageView.setY(Y);
    }

    protected void SetX(double X)
    {
        imageView.setX(X);
    }

    protected  void SetY(double Y)
    {
        imageView.setY(Y);
    }
    protected ImageView getImageView()
    {
        return imageView;
    }

    protected Bounds getImageViewBounds()
    {
        return imageView.getBoundsInParent();
    }

    protected double GetX()
    {
        return imageView.getX();
    }

    protected  double GetY()
    {
        return imageView.getY();
    }

    protected  double GetHeight()
    {
        return image.getHeight();
    }

    protected  double GetWidth()
    {
        return image.getWidth();
    }

    protected  void moveHorizontally(double x)
    {
        SetX( (GetX()+x) );
    }
    protected  void moveVertically(double y)
    {
        SetY( (GetY()+y) );
    }

}
