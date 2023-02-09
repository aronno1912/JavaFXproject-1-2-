package sample;
import Classes.Club;
import Classes.Country;
import Classes.Player;
import Classes.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public class SearchClubMenuController {
    List<Player> playerList=new ArrayList();
    List<Club> clubs = new ArrayList();
    List<Country>countryList = new ArrayList();
    List<Player>maxInfoPlayers = new ArrayList();
    List<Player>temp=new ArrayList();
    private Main main;
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
    private ImageView liverpoolim;

    @FXML
    private ImageView arsenalim;

    @FXML
    private ImageView chelseaim;

    @FXML
    private ImageView mancityim;

    @FXML
    private ImageView manunitedim;
    @FXML
    private Button op1button;

    @FXML
    private Button op3button;

    @FXML
    private Button op2button;

    @FXML
    private Button op4button;

    @FXML
    private Button op5button;

    @FXML
    private Label cnLabel;

    @FXML
    private TextField cNText;

    @FXML
    private Button ok;
    @FXML
    private Label totalSLabel;



    @FXML
    void okAction(ActionEvent event) {
        clubName=cNText.getText();
        clubFound = find.findClub(clubs,clubName);


        if(clubFound == -1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not available");
            alert.setHeaderText("No club with such name");
            alert.setContentText("Please Enter a correct CLUB name");
            alert.showAndWait();
            cNText.setText(null);


        }
        club = clubs.get(clubFound); //that index
        totalSLabel.setText(String.valueOf(club.getTotalSalary()));
        op1button.setVisible(true);
        op2button.setVisible(true);
        op3button.setVisible(true);
        op4button.setVisible(true);
        op5button.setVisible(true);
        if(clubName.equalsIgnoreCase("Liverpool")) liverpoolim.setVisible(true);
        else if(clubName.equalsIgnoreCase("Arsenal")) arsenalim.setVisible(true);
        else if(clubName.equalsIgnoreCase("Chelsea")) chelseaim.setVisible(true);
       else if(clubName.equalsIgnoreCase("Manchester city")) mancityim.setVisible(true);
        else if(clubName.equalsIgnoreCase("Manchester united")) manunitedim.setVisible(true);
        else {
            liverpoolim.setVisible(false);
            arsenalim.setVisible(false);
            chelseaim.setVisible(false);
            mancityim.setVisible(false);
            manunitedim.setVisible(false);
        }

    }
public void setValue(Club club)
{

}

    @FXML
    void op1action(ActionEvent event) throws Exception {
        totalSLabel.setVisible(false);
        maxInfoPlayers = GetMaxInfo.getHighestSalary(club.clubPlayers);
        for(Player player:maxInfoPlayers)
        {
            temp.add(player);
            main.showPlayerTable(temp);
        }

    }

    @FXML
    void op2action(ActionEvent event) throws Exception {
        totalSLabel.setVisible(false);
        maxInfoPlayers = GetMaxInfo.getMaxAge(club.clubPlayers);
        for(Player player:maxInfoPlayers)
        {
            temp.add(player);
            main.showPlayerTable(temp);
        }

    }

    @FXML
    void op3action(ActionEvent event) throws Exception {
        totalSLabel.setVisible(false);
        maxInfoPlayers = GetMaxInfo.getMaxHeight(club.clubPlayers);
        for(Player player:maxInfoPlayers)
        {
            temp.add(player);
            main.showPlayerTable(temp);
        }

    }

    @FXML
    void op4action(ActionEvent event) {
        totalSLabel.setVisible(false);
        totalSLabel.setText(String.valueOf(club.getTotalSalary()));
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Total Salary of this club is "+totalSLabel.getText()+" Million");
        //a.setContentText("This player is added to your club now");
        a.showAndWait();

       // setValue(club);
    }

    @FXML
    void op5action(ActionEvent event) {
        totalSLabel.setVisible(false);
        try {
            main.showMainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void setMain(Main main) {
        this.main=main;
    }
}



