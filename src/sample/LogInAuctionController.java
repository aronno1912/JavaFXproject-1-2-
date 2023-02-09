package sample;

import Classes.Club;
import Classes.Country;
import Classes.Player;
import Classes.SearchOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import util.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LogInAuctionController {
    private Main main;
    List<Player> playerList=new ArrayList();
    List<Club> clubs = new ArrayList();
    List<Country>countryList = new ArrayList();
    List<Player>maxInfoPlayers = new ArrayList();
    List<Player>temp=new ArrayList();
    NetworkUtil networkUtil;

    String clubName;
    int clubFound=-1;
    Club club=new Club();
    SearchOperation find=new SearchOperation();
    public void init(List<Player> playerList, List<Country> countryList, List <Club> clubs)
    {
        this.playerList=playerList;
        this.countryList=countryList;
        this.clubs=clubs;
    }

  @FXML
    private TextField userText;

    @FXML
    private Button loginButton;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button resetButton;

    @FXML
    private Button mainmenuButton;


    @FXML
    void mainmenuAction(ActionEvent event) throws Exception {
          main.showMainMenu();
    }

    @FXML
    void loginAction(ActionEvent event) throws Exception {

        networkUtil =  main.getNetworkUtil();

        clubName = userText.getText();
        clubFound = find.findClub(clubs,clubName);
        club=clubs.get(clubFound);
        String password = passwordText.getText();
        if(clubFound!=-1 && password.equals("abc"))

        {
            networkUtil.write(club);
            temp=club.getClubPlayers();
            //System.out.println(club.clubPlayers.size());
            main.showAuctionTable(temp,clubName);
        }
        /*LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserName(userName);
        loginDTO.setPassword(password);*/

       /* try {
            main.getNetworkUtil().write(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
    @FXML
    void resetAction(ActionEvent event) {
        userText.setText(null);
        passwordText.setText(null);
    }


    public void setMain(Main main) {
        this.main=main;
    }
}
