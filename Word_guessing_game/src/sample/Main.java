package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {

    private Stage window; //setting an object of Stage to later on close the game.

    private  static final String [] guess_words = new String[]{//randomly generated words from my head
            "apple",
            "orange",
            "banana",
            "car",
            "mask",
            "bike",
            "cycle",
            "laptop",
            "computer",
            "record"
    };

    private ArrayList<String> tracker = new ArrayList(); // creating an array list to keep track of game end

    private Text word = new Text("");
    private TextField userInput = new TextField();
    private Text score = new Text("SCORE:0");

    @Override
    public void start(Stage stage) throws Exception{
        window =stage;
        stage.setScene(new Scene(CreateContent()));
        stage.show();
    }

    //creating components for screen
    private Parent CreateContent() {
        word.setFont(Font.font(30));
        userInput.setFont(Font.font(30));
        score.setFont(Font.font(30));

        userInput.setOnAction(e->guess(userInput.getText()));//waits for user to press enter once pressed check with the word puzzle on display

        VBox vbox = new VBox(50,score,word,userInput);//adding the components to the screen
        vbox.setPrefSize(800,600); //Setting Frame Size
        vbox.setAlignment(Pos.CENTER);   //Setting Frame Position
        nextWord(); // sets the word puzzle on display

        return  vbox;
    }

    private void nextWord()
    {
        boolean isAlive = true;
        var randomword = guess_words[new Random().nextInt(guess_words.length)];//drawing a random word
        if(tracker.size() ==guess_words.length)
        {
            JOptionPane.showMessageDialog(null,"congratulations ! you have cleared the game !");
            window.close();
        }
        else
        {
            while(isAlive)
            {
                System.out.println(randomword);
                if( tracker.indexOf(randomword)==-1) // checking if array list contains the word
                {
                    isAlive = false; //setting state of loop to dead
                }
                else
                {
                    randomword = guess_words[new Random().nextInt(guess_words.length)];//drawing a new random word
                }
            }
        }

        tracker.add(randomword);

        var randomwordNumbers = "";

        for(char c: randomword.toCharArray())//sending the individual elements of the word for int conversion
        {
            randomwordNumbers+= charToInt(c)+"_"; //adding the integer value of c to _ and creating a number string
        }

        word.setText(randomwordNumbers.substring(0,randomwordNumbers.length()-1)); //rendering on display
        word.getProperties().put("word",randomword);
    }

    private int charToInt(char c) {
        //a=1,b=2,c=3,d=4...
        int i = c;//storing ASCII value of c in i
        i-=96;
        return  i;
    }

    private void guess(String text) {
        String actualWord = (String) word.getProperties().get("word");
        if(userInput.getText().equalsIgnoreCase(actualWord))
        {
            System.out.println("correct !");
            clearScreen();
            incrementScore();
            nextWord();
        }
        else
        {
            System.out.println("incorrect !");
            clearScreen();
        }

    }

    private void clearScreen() {
        userInput.setText("");
    }

    private void incrementScore() {
        String s = score.getText();

        String [] sep = s.split(":");
        int increment_score = Integer.parseInt(sep[1]);
        increment_score++;
        score.setText("SCORE:"+String.valueOf(increment_score));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
