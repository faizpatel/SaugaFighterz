package UserInterface;

import Fighters.Fighter;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Arena
{
    private Fighter player1, player2;
    private Image arenaChoice;
    private Scene arena;
    private ImageView background;
    private Group arenaLayout;
    private Boolean pressAttack = true;

    public void play(Stage stage)
    {
        this.background = new ImageView(this.arenaChoice);
        this.background.setX(0);
        this.background.setY(0);
        this.background.setFitWidth(1200);
        this.background.setFitHeight(603);

        ImageView p1 = new ImageView(this.player1.getImageFighterStanceL());
        p1.setX(100);
        p1.setY(303);

        ImageView p2 = new ImageView(this.player2.getImageFighterStanceR());
        p2.setX(900);
        p2.setY(303);

        arenaLayout = new Group();
        arenaLayout.getChildren().addAll(this.background, p1, p2);
        this.arena = new Scene(arenaLayout, 1200, 603);

        arena.setOnKeyPressed(e ->
                {
                    if(player1.getHealth() > 0 && player2.getHealth() > 0)
                    {
                        // Player 1
                        if (e.getCode() == KeyCode.D) {
                            p1.setImage(player1.getImageFighterForwardL());
                            p1.setLayoutX(p1.getLayoutX() + 30);
                            if (p1.getLayoutX() > 1000) {
                                p1.setLayoutX(p1.getLayoutX() - 30);
                            }
                        }
                        if (e.getCode() == KeyCode.A) {
                            p1.setImage(player1.getImageFighterBackwardL());
                            p1.setLayoutX(p1.getLayoutX() - 10);
                            if (p1.getLayoutX() < -100) {
                                p1.setLayoutX(p1.getLayoutX() + 10);
                            }
                        }
                        if (e.getCode() == KeyCode.F && this.pressAttack)
                        {
                            p1.setImage(new Image("/Assets/Aries/AriesMPunch.gif"));
                            this.pressAttack = false;
                            if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
                            {
                                player2.takeDamage(20);
                            }
                        }
                        else if(e.getCode() == KeyCode.S)
                        {
                            p1.setImage(player1.getImageFighterStanceL());
                        }

                        if (e.getCode() == KeyCode.F && this.pressAttack)
                        {
                            p1.setImage(new Image("/Assets/Aries/AriesMPunch.gif"));
                            this.pressAttack = false;
                            if (p1.getBoundsInParent().intersects(p2.getBoundsInParent()))
                            {
                                player2.takeDamage(20);
                            }
                        }
                        else if(e.getCode() == KeyCode.S)
                        {
                            p1.setImage(player1.getImageFighterStanceL());
                        }


                        // Player 2
                        if (e.getCode() == KeyCode.LEFT)
                        {
                            p2.setImage(player2.getImageFighterForwardR());
                            p2.setLayoutX(p2.getLayoutX() - 30);
                            if (p2.getLayoutX() < -1000) {
                                p2.setLayoutX(p2.getLayoutX() + 30);
                            }
                        }

                        if (e.getCode() == KeyCode.RIGHT)
                        {
                            p2.setImage(player2.getImageFighterBackwardR());
                            p2.setLayoutX(p2.getLayoutX() + 10);
                            if (p2.getLayoutX() > 100) {
                                p2.setLayoutX(p2.getLayoutX() - 10);
                            }
                        }

                        if (e.getCode() == KeyCode.DOWN)
                        {
                            p2.setImage(player2.getImageFighterPunchR());
                        }
                    }
                    else
                        {
                            System.exit(0);
                        }
                }
        );

        arena.setOnKeyReleased(event -> {
            p1.setImage(player1.getImageFighterStanceL());
            p2.setImage(player2.getImageFighterStanceR());
            this.pressAttack = true;
        });


    }


    public void setPlayer1(Fighter player1)
    {
        this.player1 = player1;
    }

    public void setPlayer2(Fighter player2)
    {
        this.player2 = player2;
    }

    public void setArenaChoice(Image aChoice)
    {
        this.arenaChoice = aChoice;
    }

    public Scene getArena()
    {
        return this.arena;
    }
}
