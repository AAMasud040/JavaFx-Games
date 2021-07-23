package sample;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class SpriteAnimation extends Transition {

    private final ImageView imageView;
    private final int count;
    private final int columns;
    private final int offsetX;
    private final int offsetY;
    private final int width;
    private final int height;


    private int lastIndex;

    private final int scaledWidth;
    private final int scaledHeight;
    private final int scale;

    public SpriteAnimation(
            ImageView imageView,
            Duration duration,
            int count,   int columns,
            int offsetX, int offsetY,
            int width,   int height,
            int scale) {

        this.imageView = imageView;
        this.count     = count;
        this.columns   = columns;
        this.offsetX   = offsetX;
        this.offsetY   = offsetY;
        this.width     = width;
        this.height    = height;
        this.scale = scale;

        this.scaledHeight = height*scale;
        this.scaledWidth = width*scale;
        setCycleDuration(duration);
        setInterpolator(Interpolator.LINEAR);
    }

    protected void interpolate(double k) {
        final int index = Math.min((int)(k * count), count - 1);
        if (index != lastIndex) {

            final int x = (index % columns) * width  + offsetX;
            final int y = (index / columns) * height + offsetY;
            imageView.setViewport(new Rectangle2D(x, y, width, height));

            if(scale>1)
            {
                imageView.setFitWidth(scaledWidth);
                imageView.setFitHeight(scaledHeight);
                imageView.setSmooth(true);
            }

            lastIndex = index;
        }
    }

}