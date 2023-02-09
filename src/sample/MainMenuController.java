package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
//import image.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import util.NetworkUtil;

import java.io.IOException;

public class MainMenuController {

private NetworkUtil networkUtil;
    @FXML
    private Button searchPlayerButton;

    @FXML
    private Button SearchClubButton;

    @FXML
    private Button addPlayerButton;
    @FXML
    private ImageView imgview1;

    @FXML
    private ImageView imgview2;

    /*public void init()
    {Image image=new Image(Main.class.getResourceAsStream("tp2.png"));
    imgview1.setImage(image);
        Image image2=new Image(Main.class.getResourceAsStream("pngegg.png"));
        imgview2.setImage(image2);
    }*/

    @FXML
    private Button exitButton;
    @FXML
    private Button auctionButton;
    private Main main;

    @FXML
    void AddPlayerAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Not available");
        alert.setHeaderText("This option is currently unavailable");
        alert.setContentText("Auction is going on..So you can't add player manually");
        alert.showAndWait();
    }

    @FXML
    void SearchClubAction(ActionEvent event) {
        try {
            main.showSearchClubMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SearchPlayerAction(ActionEvent event) {
        try {
            main.showSearchPlayerMenu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void auctionAction(ActionEvent event) {
        try {
            main.loginWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void exitAction(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
        networkUtil.closeConnection();

    }
    void setMain(Main main) {
        this.main = main;
    }

}
