package sample;

import Classes.Club;
import Classes.Country;
import Classes.Player;
import Classes.SearchOperation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class SearchPlayerMenuController {
    private Main main;
    private CountryWisePlayerCountController cp;


    List<Player> playerList = new ArrayList();
    List<Club> clubs = new ArrayList();
    List<Country> countryList = new ArrayList();
    List<Player> temp = new ArrayList<>();
    public SearchOperation find = new SearchOperation();

    @FXML
    private Button op1button;

    @FXML
    private Button op2button;

    @FXML
    private Button op3button;

    @FXML
    private Button op4button;

    @FXML
    private Button op5button;

    @FXML
    private Button op6button;

    @FXML
    private Label pname;

    @FXML
    private TextField pnameText;

    @FXML
    private Button Go1;


    @FXML
    private Label clubName;

    @FXML
    private Label countryName;

    @FXML
    private TextField CountryNameText;

    @FXML
    private TextField clubnameText;

    @FXML
    private Button Go2;

    @FXML
    private Label positionName;

    @FXML
    private TextField positionNameText;

    @FXML
    private Button Go3;

    @FXML
    private Label uRange;

    @FXML
    private Label Lrange;

    @FXML
    private TextField UrangeText;

    @FXML
    private TextField LrangeText;

    @FXML
    private Button Go4;

    @FXML
    private ImageView im;

    public void init(List<Player> playerList, List<Country> countryList, List<Club> clubs) {
        this.playerList = playerList;
        this.countryList = countryList;
        this.clubs = clubs;
    }

    @FXML
    void op1action(ActionEvent event) {

        pname.setVisible(true);
        pnameText.setVisible(true);
        Go1.setVisible(true);
        clubName.setVisible(false);
        clubnameText.setVisible(false);
        countryName.setVisible(false);
        CountryNameText.setVisible(false);
        Go2.setVisible(false);
        positionName.setVisible(false);
        positionNameText.setVisible(false);
        Go3.setVisible(false);
        UrangeText.setVisible(false);
        uRange.setVisible(false);
        LrangeText.setVisible(false);
        Lrange.setVisible(false);
        Go4.setVisible(false);
    }

    @FXML
    void op2action(ActionEvent event) {
        clubName.setVisible(true);
        clubnameText.setVisible(true);
        countryName.setVisible(true);
        CountryNameText.setVisible(true);
        Go2.setVisible(true);
        positionName.setVisible(false);
        positionNameText.setVisible(false);
        Go3.setVisible(false);
        UrangeText.setVisible(false);
        uRange.setVisible(false);
        LrangeText.setVisible(false);
        Lrange.setVisible(false);
        Go4.setVisible(false);
        pname.setVisible(false);
        pnameText.setVisible(false);
        Go1.setVisible(false);
    }

    @FXML
    void op3action(ActionEvent event) {
        positionName.setVisible(true);
        positionNameText.setVisible(true);
        Go3.setVisible(true);
        UrangeText.setVisible(false);
        uRange.setVisible(false);
        LrangeText.setVisible(false);
        Lrange.setVisible(false);
        Go4.setVisible(false);
        pname.setVisible(false);
        pnameText.setVisible(false);
        Go1.setVisible(false);
        clubName.setVisible(false);
        clubnameText.setVisible(false);
        countryName.setVisible(false);
        CountryNameText.setVisible(false);
        Go2.setVisible(false);
    }

    @FXML
    void op4action(ActionEvent event) {
        UrangeText.setVisible(true);
        uRange.setVisible(true);
        LrangeText.setVisible(true);
        Lrange.setVisible(true);
        Go4.setVisible(true);
        clubName.setVisible(false);
        clubnameText.setVisible(false);
        countryName.setVisible(false);
        CountryNameText.setVisible(false);
        Go2.setVisible(false);
        positionName.setVisible(false);
        positionNameText.setVisible(false);
        Go3.setVisible(false);
        pname.setVisible(false);
        pnameText.setVisible(false);
        Go1.setVisible(false);

    }

    @FXML
    void op5action(ActionEvent event) {


        try {
            main.showCountryWiseCount();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void op6action(ActionEvent event) {
        try {
            main.showMainMenu();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void Go1Action(ActionEvent event) throws Exception {
        String pName = pnameText.getText();
        int found;
        found = find.findPlayer(playerList, pName);// findPlayer returns the index of matched players,else returns -1
        //System.out.println(playerList.size());
        if (found == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not available");
            alert.setHeaderText("No player with such name");
            alert.setContentText("Please Enter a correct player name");
            alert.showAndWait();
            pnameText.setText(null);
        } else {

            main.setFind(found);
            main.showPlayerCard();

        }
        pname.setVisible(false);
        pnameText.setVisible(false);
        Go1.setVisible(false);
    }

    @FXML
    void Go2Action(ActionEvent event) throws Exception {
        String clubName = clubnameText.getText();
        String countryName = CountryNameText.getText();
        int clubFound, countryFound;
        Country country = new Country();
        Club club = new Club();

        countryFound = find.findCountry(countryList, countryName);

        if (countryFound == -1) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not available");
            alert.setHeaderText("No country with such name");
            alert.setContentText("Please Enter a correct Country name");
            alert.showAndWait();
            CountryNameText.setText(null);
        } else {
            country = countryList.get(countryFound);

        }
        if (clubName.equalsIgnoreCase("ANY")) {
           /* PlayerTableController pc=new PlayerTableController();
            pc.setValues(countryFound);
            main.showPlayerTable();*/
            // List<Player>temp=new ArrayList<>();
            temp = country.countryPlayers;


            //PlayerTableController pc=new PlayerTableController();


            main.showPlayerTable(temp);

        } else {
            clubFound = find.findClub(clubs, clubName);

            if (clubFound == -1) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not available");
                alert.setHeaderText("No Club with such name");
                alert.setContentText("Please Enter a correct Club name");
                alert.showAndWait();
                clubnameText.setText(null);
            } else {
                //List<Player> temp = new ArrayList<>();
                for (Player player : country.countryPlayers) {
                    if (player.getClub().equalsIgnoreCase(clubName)) {

                        //club=clubs.get(clubFound);

                        temp.add(player);
                    }
                }
                main.showPlayerTable(temp);



               /* else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Not available");
                    alert.setHeaderText("No Player of such country are in this Club");
                    alert.setContentText("Please Enter Again");
                    alert.showAndWait();
                    clubnameText.setText(null);
                }*/


            }
        }


    }

    @FXML
    void Go3Action(ActionEvent event) throws Exception {
        String pos = positionNameText.getText();
        boolean positionFound = false;
        // List<Player> temp = new ArrayList<>();
        System.out.println(playerList.size());
        for (Player player : playerList) {
            if (player.getPosition().equalsIgnoreCase(pos)) {
                temp.add(player);
                positionFound = true;

                main.showPlayerTable(temp);
            }
        }
        if (!positionFound) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not available");
            alert.setHeaderText("No such position exist");
            alert.setContentText("Please Enter Again");
            alert.showAndWait();
            positionNameText.setText(null);

        }


    }

    @FXML
    void Go4Action(ActionEvent event) throws Exception {
        //List<Player> temp = new ArrayList<>();
        double upperRange, lowerRange;
        upperRange = Double.parseDouble(UrangeText.getText());
        lowerRange = Double.parseDouble(LrangeText.getText());
        boolean rangeFound = false;


        for (Player player : playerList) {
            double salary = player.getWeeklySalary();
            if (salary >= lowerRange && salary <= upperRange) {
                temp.add(player);

                rangeFound = true;
                main.showPlayerTable(temp);
            }
        }
        //System.out.println(playerList.size());
        if (!rangeFound) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Not available");
            alert.setHeaderText("No player with this weekly salary range");
            alert.setContentText("Please Enter Again");
            alert.showAndWait();
            UrangeText.setText(null);
            LrangeText.setText(null);
        }


    }

    void setMain(Main main) {
        this.main = main;
    }


}
