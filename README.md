# JavaFx-Games

This Code mainly contains Motion Picture animation, pictures by Eadweard Muybridge ( https://commons.wikimedia.org/wiki/Eadweard_Muybridge ). The Dimensions and Timing of the animation can be modified I have provided 2 Still Image files as sprites here, you can add more if u modify the codes.

Classes used:
---------------
1)  https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/ImageView.html
2)  https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Transition.html

protected void interpolate(double k) { // k is the value of the animation time scale 0.00-1.00 depending on which part of the animation you are in.
        final int index = Math.min((int)(k * count), count - 1); //determins which image index needs to be displayed according to timeline of animation.
        if (index != lastIndex) {
            final int x = (index % columns) * width  + offsetX; //index % col means which column we are currently in.
            final int y = (index / columns) * height + offsetY; // this determines which row we are currently in according to sprite sheet
            imageView.setViewport(new Rectangle2D(x, y, width, height)); // sets the cut image according to x,y and h,w provided and displays it from start()
            lastIndex = index;//this basically controls the frame change in the if condition
        } 

On a change of the index the part of the image the ImageView should display is modified to show the appropriate part of the image. Here you iterate through the sprites line by line from left to right.

index % columns
is the rest of the division of index by columns. This means for every increment of index by one the result will increase by 1 until columns is reached; in that case it starts over at 0 instead.

Because of this property, it can be used to determine the horizontal position of image to be displayed. You just have to multiply with the width of a sprite to get the x coordinates of the left.

index / columns
is the division of index by columns without rest, i.e. index / columns and (index - index % columns) / columns result in the same value. The result increases by 1 for every columns you add to index; it increases by 1 when index % column starts over at 0. Therefore it can be used to determine the y coordinate of the sprite; You just have multiply by the height of a sprite.

Examples for columns = 3
index   |   Column     |    row
index   |   index % 3  |   index / 3
--------------------------------------
  0     |     0        |     0
  1     |     1        |     0
  2     |     2        |     0
  3     |     0        |     1
  4     |     1        |     1
  5     |     2        |     1
  6     |     0        |     2
             ...
 10    |    0         |     3
This way you iterate through sprites in the following order
col->0      1     2
      -------------------
      |  1  |  2  |  3  | ----------> row 0
      -------------------
      |  4  |  5  |  6  | ----------> row 1
      -------------------
              ...
      -------------------
      |  10  |  11  |  12  | ----------> row 3
      -------------------
