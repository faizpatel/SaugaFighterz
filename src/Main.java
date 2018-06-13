import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Main extends Application
{

    private Scene startMenu,characterSelect;

    private ImageView title, ariesStanceMenu, kratosStanceMenu, ariesStanceChar, kratosStanceChar;
    private Button start, quit, ariesStanceCharButton, kratosStanceCharButton;

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException
    {

        stage.setTitle("Sauga Fighters");
        stage.getIcons().add(new Image("/Assets/Logo.png"));

        Image imageBackground = new Image("/Assets/Menu/Start_Menu.gif");
        Image imageStart = new Image(getClass().getResourceAsStream("/Assets/Menu/start.png"));
        Image imageQuit = new Image(getClass().getResourceAsStream("/Assets/Menu/quit.png"));
        Image imageTitle = new Image(getClass().getResourceAsStream("/Assets/Menu/title.png"));
        Image imageAriesStance = new Image(getClass().getResourceAsStream("/Assets/Aries/AriesStance.gif"));
        Image imageKratosStance = new Image(getClass().getResourceAsStream("/Assets/Kratos/KratosStance.gif"));

        // Start Menu
        ImageView backgroundMenu = new ImageView(imageBackground);
        backgroundMenu.setX(0);
        backgroundMenu.setY(0);
        backgroundMenu.setFitHeight(603);
        backgroundMenu.setFitWidth(1200);

        title = new ImageView(imageTitle);
        title.setX(100);
        title.setY(50);

        start = new Button();
        start.setGraphic(new ImageView(imageStart));
        start.setStyle("-fx-background-color: transparent; ");
        start.setOnAction(event -> stage.setScene(characterSelect));
        start.setOnMouseEntered(event -> start.setGraphic(new ImageView("/Assets/Menu/start_hover.png")));
        start.setOnMouseExited(event -> start.setGraphic(new ImageView(imageStart)));
        start.setLayoutX(525);
        start.setLayoutY(300);

        quit = new Button();
        quit.setGraphic(new ImageView(imageQuit));
        quit.setStyle("-fx-background-color: transparent; ");
        quit.setOnAction(event -> System.exit(0));
        quit.setOnMouseEntered(event -> quit.setGraphic(new ImageView("/Assets/Menu/quit_hover.png")));
        quit.setOnMouseExited(event -> quit.setGraphic(new ImageView(imageQuit)));
        quit.setLayoutX(465);
        quit.setLayoutY(375);

        ariesStanceMenu = new ImageView(imageAriesStance);
        ariesStanceMenu.setX(200);
        ariesStanceMenu.setY(325);
        ariesStanceMenu.setFitWidth(156);
        ariesStanceMenu.setFitHeight(222);

        Group startMenuLayout = new Group();
        startMenuLayout.getChildren().addAll(backgroundMenu, title, start, quit, ariesStanceMenu);
        startMenu = new Scene(startMenuLayout, 1200, 603);

        startMenu.setCursor(new ImageCursor(new Image(getClass().getResourceAsStream( "/Assets/cursor.png"))));

        stage.setScene(startMenu);
        stage.show();

        // Character Select Screen

        ImageView backgroundChar = new ImageView(imageBackground);
        backgroundChar.setX(0);
        backgroundChar.setY(0);
        backgroundChar.setFitHeight(603);
        backgroundChar.setFitWidth(1200);


        ariesStanceChar = new ImageView(imageAriesStance);
        ariesStanceChar.setFitWidth(156);
        ariesStanceChar.setFitHeight(222);
        ariesStanceCharButton = new Button("Aries", ariesStanceChar);
        ariesStanceCharButton.setStyle("-fx-background-color: transparent; -fx-font-size: 30px; -fx-text-fill: #FFF000");
        ariesStanceCharButton.setContentDisplay(ContentDisplay.TOP);
        ariesStanceCharButton.setLayoutX(300);
        ariesStanceCharButton.setLayoutY(100);
        ariesStanceCharButton.setMinWidth(156);
        ariesStanceCharButton.setMinHeight(222);
        ariesStanceCharButton.setOnAction(event -> System.out.println("a"));
        ariesStanceCharButton.setOnMouseEntered(event -> ariesStanceCharButton.setGraphic(new ImageView("/Assets/Aries/AriesMPunch.gif")));
        ariesStanceCharButton.setOnMouseExited(event -> ariesStanceCharButton.setGraphic(ariesStanceChar));

        kratosStanceChar = new ImageView(imageKratosStance);
        kratosStanceChar.setFitWidth(226);
        kratosStanceChar.setFitHeight(222);
        kratosStanceCharButton = new Button("Kratos", kratosStanceChar);
        kratosStanceCharButton.setStyle("-fx-background-color: transparent; -fx-font-size: 30px; -fx-text-fill: #FFF000");
        kratosStanceCharButton.setContentDisplay(ContentDisplay.TOP);
        kratosStanceCharButton.setLayoutX(674);
        kratosStanceCharButton.setLayoutY(100);
        kratosStanceCharButton.setMinWidth(226);
        kratosStanceCharButton.setMinHeight(222);
        kratosStanceCharButton.setOnAction(event -> System.out.println("k"));
        kratosStanceCharButton.setOnMouseEntered(event -> kratosStanceCharButton.setGraphic(new ImageView("/Assets/Kratos/KratosHPunch.gif")));
        kratosStanceCharButton.setOnMouseExited(event -> kratosStanceCharButton.setGraphic(kratosStanceChar));

        Group characterMenuLayout = new Group();
        characterMenuLayout.getChildren().addAll(backgroundChar, ariesStanceCharButton, kratosStanceCharButton);
        characterSelect = new Scene(characterMenuLayout, 1200, 603);
        characterMenuLayout.setCursor(new ImageCursor(new Image(getClass().getResourceAsStream( "/Assets/cursor.png"))));



//        StackPane layout = new StackPane();
//        layout.getChildren().add(start);
//        layout.getChildren().add(imageView);

//        start.getStylesheets().add(getClass().getResource("Menu.css").toExternalForm());




//        Image KratosStance = new Image("/Assets/Fighters.Kratos/KratosStance.gif");
//        Image KratosForward = new Image("/Assets/Fighters.Kratos/KratosForward.gif");
//        Image KratosBackward = new Image("/Assets/Fighters.Kratos/KratosBackward.gif");
//        Image KratosKick = new Image("/Assets/Fighters.Kratos/KratosBackward.gif");
//
//        ImageView Fighters.Kratos = new ImageView();
//        Fighters.Kratos.setFitHeight(300);
//        Fighters.Kratos.setFitWidth(290);
//        Fighters.Kratos.setImage(KratosStance);
//        Fighters.Kratos.setPreserveRatio(true);
//        Fighters.Kratos.setX(300);
//        Fighters.Kratos.setY(300);
//        root.getChildren().add(Fighters.Kratos);
//
//
//        scene.setOnKeyPressed(e ->
//                {
//
//                        if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D) {
//                            Fighters.Kratos.setImage(KratosForward);
//                            Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() + 30);
//                            if (Fighters.Kratos.getLayoutX() > 350) {
//                                Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() - 30);
//                            }
//
//                        } else if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A) {
//                            Fighters.Kratos.setImage(KratosBackward);
//                            Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() - 10);
//                            if (Fighters.Kratos.getLayoutX() < -100) {
//                                Fighters.Kratos.setLayoutX(Fighters.Kratos.getLayoutX() + 10);
//                            }
//                        }
//
//                        if (e.getCode() == KeyCode.ENTER)
//                        {
//
//                        }
//
//
//                }
//
//        );
    }
}