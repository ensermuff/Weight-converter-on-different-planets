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
    private Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8;
    private Button button1, button2, button3, button4, button5, button6, button7,
            button8, Mercury, Venus, Mars, Jupiter, Saturn, Uranus, Neptune;

    TextArea output = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }
    private static DecimalFormat df = new DecimalFormat("0.00");
    public void start(Stage primaryStage) throws FileNotFoundException {
        window = primaryStage;
        TextField weight = new TextField();
        //Label is a string that user doesn't interact with
        Label label1 = new Label ("Weight: ");
        weight.setPromptText("Input your body weight in pounds: ");
        output.setPromptText("Your weight is: " + weight);
        output.setPrefColumnCount(20);
        output.setPrefRowCount(10);


        //example of positioning button1.setLayoutX(200.0); button1.setLayoutY(200.0);

        //button2 = new Button("Change scene");
        //button action makes us go to another scene with different physical contents of JavaFx application
        //button2.setOnAction(e -> window.setScene(scene2));


        Image [] image = new Image [7];
        image [0] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Mercury.png"));
        image [1] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Venus.png"));
        image [2] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Mars.png"));
        image [3] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Jupiter.png"));
        image [4] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Saturn.png"));
        image [5] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Uranus.png"));
        image [6] = new Image(WeightOnPlanetsFinder.class.getResourceAsStream("Neptune.png"));

        Image age = image [0];
        Image age1 = image [1];
        Image age2 = image [2];
        Image age3 = image [3];
        Image age4 = image [4];
        Image age5 = image [5];
        Image age6 = image [6];

        //Setting the image view
        ImageView imageView = new ImageView(age);
        ImageView imageView1 = new ImageView(age1);
        ImageView imageView2 = new ImageView(age2);
        ImageView imageView3 = new ImageView(age3);
        ImageView imageView4 = new ImageView(age4);
        ImageView imageView5 = new ImageView(age5);
        ImageView imageView6 = new ImageView(age6);


        //Setting the position of the image
        imageView.setX(25); //positions Mercury
        imageView.setY(25);
        imageView1.setX(100);//positions Venus
        imageView1.setY(25);
        imageView2.setX(175);// positions Mars
        imageView2.setY(25);
        imageView3.setX(250);// positions Jupiter
        imageView3.setY(25);
        imageView4.setX(325);// positions Saturn
        imageView4.setY(25);
        imageView5.setX(400);// positions Uranus
        imageView5.setY(25);
        imageView6.setX(475);// positions Neptune
        imageView6.setY(25);


        //setting the fit height and width of the image view
        imageView.setFitHeight(100); // height and width of Mercury
        imageView.setFitWidth(100);
        imageView1.setFitHeight(100); // height and width of Venus
        imageView1.setFitWidth(100);
        imageView2.setFitHeight(100); // height and width of Mars
        imageView2.setFitWidth(100);
        imageView3.setFitHeight(100); // height and width of Jupiter
        imageView3.setFitWidth(100);
        imageView4.setFitHeight(100); // height and width of Saturn
        imageView4.setFitWidth(100);
        imageView5.setFitHeight(100); // height and width of Uranus
        imageView5.setFitWidth(100);
        imageView6.setFitHeight(100); // height and width of Neptune
        imageView6.setFitWidth(100);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);
        imageView1.setPreserveRatio(true);
        imageView2.setPreserveRatio(true);
        imageView3.setPreserveRatio(true);
        imageView4.setPreserveRatio(true);
        imageView5.setPreserveRatio(true);
        imageView6.setPreserveRatio(true);

        //Group root = new Group(imageView,imageView1,imageView2,imageView3,imageView4,imageView5,imageView6);
        Group root = new Group(imageView);
        Group root1 = new Group(imageView1);
        Group root2 = new Group(imageView2);
        Group root3 = new Group(imageView3);
        Group root4 = new Group(imageView4);
        Group root5 = new Group(imageView5);
        Group root6 = new Group(imageView6);

        //Setting the scenes widths and heights

        scene2 = new Scene(root, 600, 500);
        scene3 = new Scene(root1, 400, 400);
        scene4 = new Scene(root2, 400, 400);
        scene5 = new Scene(root3, 400, 400);
        scene6 = new Scene(root4, 400, 400);
        scene7 = new Scene(root5, 400, 400);
        scene8 = new Scene(root6, 400, 400);

        Label label2 = new Label ("Pick the planet that you want to compare your earth's weight with: ");

        DecimalFormat df = new DecimalFormat("#.##");
        Mercury = new Button ("Mercury");
        Mercury.setOnAction(
                e -> {
                    String Mer = null;
                    try {
                        double userWeight = Double.parseDouble(weight.getText());
                        double earthGrav = 9.81;
                        double mercGrav = 3.7;
                        double mercWeight = convMerc(userWeight, earthGrav, mercGrav);
                        Mer = String.valueOf(mercWeight);
                        Merc = df.format(Mer);

                    } catch (NumberFormatException ex) {

                    } finally {
                         weight.setText(Mer);
                    }
                }
        );
        Venus = new Button ("Venus");
        Venus.setOnAction(e -> {
            String Ven = null;
            try {
                double userWeight = Double.parseDouble(weight.getText());
                double earthGrav = 9.81;
                double venusGrav = 8.87;
                double venusWeight = convVenus(userWeight, earthGrav, venusGrav);
                Ven = String.valueOf(venusWeight);
            } catch (NumberFormatException ex) {

            } finally {
                weight.setText(Ven);
            }
        } );
        Mars = new Button ("Mars");
        Mars.setOnAction(e -> {
            String Mar = null;
            try {
                double userWeight = Double.parseDouble(weight.getText());
                double earthGrav = 9.81;
                double marsGrav = 3.711;
                double marsWeight = convVenus(userWeight, earthGrav, marsGrav);
                Mar = String.valueOf(marsWeight);
            } catch (NumberFormatException ex) {

            } finally {
                weight.setText(Mar);
            }
        });
        Jupiter = new Button ("Jupiter");
        Jupiter.setOnAction(e -> {
            String Jup = null;
            try {
                double userweight = Double.parseDouble(weight.getText());
                double earthGrav = 9.81;
                double jupGrav = 24.79;
                double jupiterWeight = convJup(userweight, earthGrav, jupGrav);
                Jup = String.valueOf(jupiterWeight);
            } catch (NumberFormatException ex){

            }
        });
        Saturn = new Button ("Saturn");
        Saturn.setOnAction(e -> window.setScene(scene6));
        Uranus = new Button ("Uranus");
        Uranus.setOnAction(e -> window.setScene(scene7));
        Neptune = new Button ("Neptune");
        Neptune.setOnAction(e -> window.setScene(scene8));


        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, weight, label2, Mercury, root, Venus, root1, Mars, root2, Jupiter, root3,
                Saturn, root4, Uranus, root5, Neptune, root6);

        scene1 = new Scene(layout1, 1000,1000);

        // Add the scene to the stage
        window.setScene(scene1); // we didn't incorporate the  action of changing scenes, so if you want to observe
        // the pictures of the planets change to scene2

        // Set the title of the Stage
        window.setTitle("Weight On Different Planets");

        // Display the Stage
        window.show();
    }

}
