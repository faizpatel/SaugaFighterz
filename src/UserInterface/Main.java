package UserInterface;

import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application
{

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws FileNotFoundException
    {
        stage.setTitle("Sauga Fighterz");
        stage.getIcons().add(new Image("/Assets/Logo.png"));
        stage.setResizable(false);

        Menu ms = new Menu(stage);
        ArenaSelectScreen as = new ArenaSelectScreen(stage);
        CharacterSelectScreen cs = new CharacterSelectScreen(stage);
        ControlsMenu cm = new ControlsMenu(stage, ms);
        Arena arena = new Arena();

        cs.setArenaSelect(as);
        cs.setArena(arena);
        as.setArenaSetup(arena);
        ms.setCm(cm);
        ms.setCs(cs);
        stage.setScene(ms.getStartMenu());
        stage.show();

    }
}