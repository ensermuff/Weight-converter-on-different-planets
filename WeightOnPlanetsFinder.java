package FinalMilestone2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;

import static FinalMilestone2.WeightOnPlanets.*;

/****************************************************************************
 * Final Project: Weight On Different Planets (WODP)
 ****************************************************************************
 * WODP accepts double inputs for the user's weight and then prompts the user
 * which planet the user wants to find their weight and it returns their weight
 * on that planet.
 *______________________________________________________________________________
 * Firaol, Trevon, Miguel, Rohit
 * October 31st, 2019
 * CMSC_255 - 002
 ****************************************************************************/

public class WeightOnPlanetsFinder extends Application {
    private Stage window;
    private Scene scene1;
    private Button Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, Neptune;

    TextArea output = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }
    private static DecimalFormat df = new DecimalFormat("0.00");
    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;
        //Text field input and output
        TextField weight = new TextField();
        TextField convertedWeight = new TextField();
        //Label is a string that user doesn't interact with
        Label label1 = new Label ("Weight in pounds: ");
        Label label2 = new Label ("Pick the planet that you want to compare your earth's weight with: ");
        Label label3 = new Label ("Converted weight on selected planet:");

        //example of positioning button1.setLayoutX(200.0); button1.setLayoutY(200.0);

        //Image array
        Image [] image = new Image [8];
        image [0] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Mercury.png"));
        image [1] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Venus.png"));
        image [2] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Mars.png"));
        image [3] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Jupiter.png"));
        image [4] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Saturn.png"));
        image [5] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Uranus.png"));
        image [6] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Neptune.png"));
        image [7] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Earth.png"));

        Image age = image [0];
        Image age1 = image [1];
        Image age2 = image [2];
        Image age3 = image [3];
        Image age4 = image [4];
        Image age5 = image [5];
        Image age6 = image [6];
        Image age7 = image [7];

        //Setting the image view
        ImageView imageView = new ImageView(age);
        ImageView imageView1 = new ImageView(age1);
        ImageView imageView2 = new ImageView(age2);
        ImageView imageView3 = new ImageView(age3);
        ImageView imageView4 = new ImageView(age4);
        ImageView imageView5 = new ImageView(age5);
        ImageView imageView6 = new ImageView(age6);
        ImageView imageViewE = new ImageView(age7);

        int sizeOfPic = 90;
        //setting the fit height and width of the image view
        imageView.setFitHeight(sizeOfPic); // height and width of Mercury
        imageView.setFitWidth(sizeOfPic);
        imageView1.setFitHeight(sizeOfPic); // height and width of Venus
        imageView1.setFitWidth(sizeOfPic);
        imageView2.setFitHeight(sizeOfPic); // height and width of Mars
        imageView2.setFitWidth(sizeOfPic);
        imageViewE.setFitHeight(sizeOfPic); // height and width of Earth
        imageViewE.setFitWidth(sizeOfPic);
        imageView3.setFitHeight(sizeOfPic); // height and width of Jupiter
        imageView3.setFitWidth(sizeOfPic);
        imageView4.setFitHeight(sizeOfPic); // height and width of Saturn
        imageView4.setFitWidth(sizeOfPic);
        imageView5.setFitHeight(sizeOfPic); // height and width of Uranus
        imageView5.setFitWidth(sizeOfPic);
        imageView6.setFitHeight(sizeOfPic); // height and width of Neptune
        imageView6.setFitWidth(sizeOfPic);


        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        imageView1.setPreserveRatio(true);
        imageView2.setPreserveRatio(true);
        imageView3.setPreserveRatio(true);
        imageView4.setPreserveRatio(true);
        imageView5.setPreserveRatio(true);
        imageView6.setPreserveRatio(true);
        imageViewE.setPreserveRatio(true);




        //Group root = new Group(imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6);
        Group root = new Group(imageView);
        Group root1 = new Group(imageView1);
        Group root7 = new Group(imageViewE);
        Group root2 = new Group(imageView2);
        Group root3 = new Group(imageView3);
        Group root4 = new Group(imageView4);
        Group root5 = new Group(imageView5);
        Group root6 = new Group(imageView6);

        // rounding the decimals
        DecimalFormat df = new DecimalFormat("#.##");

        Mercury = new Button ("Mercury", root);
        Mercury.setOnAction(e -> {
            String Mer = null;
            double userWeight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double mercGrav = 3.7;
            double mercWeight = convMerc(userWeight, earthGrav, mercGrav);
            Mer = String.valueOf(df.format(mercWeight));
            convertedWeight.setText(Mer);
        });

        Venus = new Button ("Venus", root1);
        Venus.setOnAction(e -> {
            String Ven = null;
            double userWeight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double venusGrav = 8.87;
            double venusWeight = convVenus(userWeight, earthGrav, venusGrav);
            Ven = String.valueOf(df.format(venusWeight));
            convertedWeight.setText(Ven);
        });

        Earth = new Button ("Earth", root7);
        Earth.setOnAction(e -> {
            String Ear = null;
            double userWeight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double earWeight = convMerc(userWeight, earthGrav, earthGrav);
            Ear = String.valueOf(df.format(earWeight));
            convertedWeight.setText(Ear);
        });


        Mars = new Button ("Mars", root2);
        Mars.setOnAction(e -> {
            String Mar = null;
            double userWeight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double marsGrav = 3.711;
            double marsWeight = convVenus(userWeight, earthGrav, marsGrav);
            Mar = String.valueOf(df.format(marsWeight));
            convertedWeight.setText(Mar);
        });

        Jupiter = new Button ("Jupiter", root3);
        Jupiter.setOnAction(e -> {
            String Jup = null;
            double userweight = 0;
            userweight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double jupGrav = 24.79;
            double jupiterWeight = convJup(userweight, earthGrav, jupGrav);
            Jup = String.valueOf(df.format(jupiterWeight));
            convertedWeight.setText(Jup);
        });

        Saturn = new Button ("Saturn", root4);
        Saturn.setOnAction(e -> {
            String Sat = null;
            double userweight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double satGrav = 10.44;
            double saturnWeight = convSat(userweight, earthGrav, satGrav);
            Sat = String.valueOf(df.format(saturnWeight));
            convertedWeight.setText(Sat);
        });

        Uranus = new Button ("Uranus", root5);
        Uranus.setOnAction(e -> {
            String Ura = null;
            double userweight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double uranGrav = 8.69;
            double uranusWeight = convUran(userweight, earthGrav, uranGrav);
            Ura = String.valueOf(df.format(uranusWeight));
            convertedWeight.setText(Ura);
        });

        Neptune = new Button ("Neptune", root6);
        Neptune.setOnAction(e -> {
            String Nep = null;
            double userweight = Double.parseDouble(weight.getText());
            double earthGrav = 9.81;
            double neptGrav = 11.15;
            double neptuneWeight = convNept(userweight, earthGrav, neptGrav);
            Nep = String.valueOf(df.format(neptuneWeight));
            convertedWeight.setText(Nep);
        });

        //The vertical layout of scene1
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, weight, label2, Mercury, Venus, Earth, Mars, Jupiter,
                Saturn, Uranus, Neptune, label3, convertedWeight);

        scene1 = new Scene(layout1, 1000,1020);


        // Add the scene to the stage
        window.setScene(scene1); // we didn't incorporate the  action of changing scenes, so if you want to observe
        // the pictures of the planets change to scene2

        // Set the title of the Stage
        window.setTitle("Weight On Different Planets");

        // Display the Stage
        window.show();
    }

}
