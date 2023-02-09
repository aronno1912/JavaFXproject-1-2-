package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Classes.*;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.text.TabableView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PlayerTableController implements Initializable {

    List<Player> playerList=new ArrayList();
    List<Club> clubs = new ArrayList();
    List<Country>countryList = new ArrayList();
    private Main main;

    public void init(List<Player> playerList, List<Country> countryList, List <Club> clubs)
    {
        this.playerList=playerList;
        this.countryList=countryList;
        this.clubs=clubs;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        counrtycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
        heightcol.setCellValueFactory(new PropertyValueFactory<>("height"));
        clubcol.setCellValueFactory(new PropertyValueFactory<>("club"));
        poscol.setCellValueFactory(new PropertyValueFactory<>("position"));
        JNocol.setCellValueFactory(new PropertyValueFactory<>("jerseyNo"));
        salarycol.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));

        table.setItems(cpOL);

    }

    @FXML
    private TableView<Player> table;
    @FXML
    private TableColumn<Player,String> namecol;

    @FXML
    private TableColumn<Player, String> counrtycol;

    @FXML
    private TableColumn<Player,Integer> agecol;

    @FXML
    private TableColumn<Player, Double> heightcol;

    @FXML
    private TableColumn<Player,String> clubcol;

    @FXML
    private TableColumn<Player, String> poscol;

    @FXML
    private TableColumn<Player, Integer> JNocol;

    @FXML

    private TableColumn<Player, Double> salarycol;

    ObservableList<Player> cpOL= FXCollections.observableArrayList();


    public void setValues(List<Player> temp)
    {
        //System.out.println(temp.size());
    for(Player player: temp)

    {
        cpOL.add(player);

        //table.getItems().add(player);
        //table.setItems(cpOL);
    }
    //table.setItems(cpOL);

    //initialize();
    }

    /*public void initialize()
    {
        //ObservableList<Player> cpOL= FXCollections.observableArrayList(countryList.get(countryFound).countryPlayers);
        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        counrtycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
        heightcol.setCellValueFactory(new PropertyValueFactory<>("height"));
        clubcol.setCellValueFactory(new PropertyValueFactory<>("club"));
        poscol.setCellValueFactory(new PropertyValueFactory<>("position"));
        JNocol.setCellValueFactory(new PropertyValueFactory<>("jerseyNo"));
       salarycol.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));
       table.getColumns().add(namecol);
        table.getColumns().add( counrtycol);
        table.getColumns().add(agecol);
        table.getColumns().add(heightcol);
        table.getColumns().add(clubcol);
        table.getColumns().add(poscol);
        table.getColumns().add(JNocol);
        table.getColumns().add(salarycol);
       //table.setItems(cpOL);
        //table.getItems().add((Player) cpOL);
        //System.out.println("hello");

    }*/
    @FXML
    private Button mainmenuButton;

    @FXML
    private Button submenu2;

    @FXML
    private Button submenu1;


    @FXML
    void mainmrnuButtonAction(ActionEvent event) throws Exception {
        main.showMainMenu();

    }
    @FXML
    void submenu1Action(ActionEvent event) throws Exception {
main.showSearchPlayerMenu();
    }

    @FXML
    void submenu2Action(ActionEvent event) throws Exception {
main.showSearchClubMenu();
    }



    public void setMain(Main main) {
        this.main=main;
        //System.out.println(cpOL.size());
    }
}
