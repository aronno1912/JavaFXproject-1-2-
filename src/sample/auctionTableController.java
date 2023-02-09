package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Classes.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import server.Server;
import util.NetworkUtil;
import util.SellPlayer;
import util.playerDTO;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class auctionTableController implements Initializable {

    List<Player> playerList = new ArrayList();
    List<Club> clubs = new ArrayList();
    List<Country> countryList = new ArrayList();
    private Main main;
    private Club club=new Club();
    private NetworkUtil networkUtil;
    private String clubName;
    private List<Player> soldPlayer;
    private playerDTO pd = new playerDTO();
    //private SellPlayer sellPlayer=new SellPlayer();
    private List<Player> tempcp = new ArrayList<>();
     private List<Player> actualP=new ArrayList<>();
    SearchOperation find=new SearchOperation();
    int clubFound;


   /* public auctionTableController() {
    }*/

    public void init(List<Player> playerList, List<Country> countryList, List<Club> clubs, String clubName, NetworkUtil networkUtil) {
        this.playerList = playerList;
        this.countryList = countryList;
        this.clubs = clubs;
        this.clubName = clubName;
        this.networkUtil = networkUtil;


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        namecol.setCellValueFactory(new PropertyValueFactory<>("name"));
        counrtycol.setCellValueFactory(new PropertyValueFactory<>("country"));
        agecol.setCellValueFactory(new PropertyValueFactory<>("age"));
        heightcol.setCellValueFactory(new PropertyValueFactory<>("height"));
        //clubcol.setCellValueFactory(new PropertyValueFactory<>("club"));
        poscol.setCellValueFactory(new PropertyValueFactory<>("position"));
        JNocol.setCellValueFactory(new PropertyValueFactory<>("jerseyNo"));
        salarycol.setCellValueFactory(new PropertyValueFactory<>("weeklySalary"));
        // buttonCol.setCellValueFactory(new PropertyValueFactory<>("button"));
        buyButton.setVisible(false);
        //table.getColumns().add(buttonCol);
        table.setItems(cpOL);
        //table.setEditable(true);
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

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
    private TableView<Player> table;
    @FXML
    private TableColumn<Player, String> namecol;

    @FXML
    private TableColumn<Player, String> counrtycol;

    @FXML
    private TableColumn<Player, Integer> agecol;

    @FXML
    private TableColumn<Player, Double> heightcol;

  /*  @FXML
    private TableColumn<Player,String> clubcol;*/

    @FXML
    private TableColumn<Player, String> poscol;

    @FXML
    private TableColumn<Player, Integer> JNocol;

    @FXML

    private TableColumn<Player, Double> salarycol;

    @FXML
    private TableColumn<Player, String> buttonCol;

    ObservableList<Player> cpOL = FXCollections.observableArrayList();
    //ObservableList<Player>tempcpOl=FXCollections.observableArrayList();


    public void setValues(List<Player> temp, String clubName, NetworkUtil networkUtil) {
        //System.out.println(temp.size());
        for (Player player : temp) {
            cpOL.add(player);

            //table.getItems().add(player);
            //table.setItems(cpOL);
        }
        //tempcp=cpOL;
        this.clubName = clubName;
        this.networkUtil = networkUtil;
        clubn.setText(clubName);
        //table.setItems(cpOL);
       /* clubFound = find.findClub(clubs,clubName);
        club=clubs.get(clubFound);
        actualP=club.getClubPlayers();*/


        //initialize();


        if(clubName.equalsIgnoreCase("Liverpool")) liverpoolim.setVisible(true);
        else if(clubName.equalsIgnoreCase("Arsenal")) arsenalim.setVisible(true);
        else if(clubName.equalsIgnoreCase("Chelsea")) chelseaim.setVisible(true);
        else if(clubName.equalsIgnoreCase("Manchester city")) mancityim.setVisible(true);
        else if(clubName.equalsIgnoreCase("Manchester united")) manunitedim.setVisible(true);
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
    private Label clubn;

    @FXML
    private Button submenu1;
    @FXML
    private Button sellButton;
    @FXML
    private Button clubTableButton;
    @FXML
    private Button buyButton;
    @FXML
    private Button marketButton;
    @FXML
    private Label marketLabel;


    @FXML
    void marketAction(ActionEvent event) throws Exception {
        marketLabel.setVisible(true);
        sellButton.setVisible(false);
        buyButton.setVisible(true);
        clubTableButton.setVisible(true);
        cpOL.clear();
        //List<Player>marketPlayers=new ArrayList<>();
        // playerDTO pd = new playerDTO();
        soldPlayer = main.soldPlayers;

        System.out.println(soldPlayer.size());

        for (Player player : soldPlayer) {
            cpOL.add(player);
           // tempcp.remove(player);
           // actualP.add(player);
            playerList.add(player);
        }
        //System.out.println("size os cpol is " + cpOL.size());
        //main.showPlayerTable(cpOL);
    }


    @FXML
    void buyAction(ActionEvent event) throws IOException, ClassNotFoundException {
        //playerDTO pd = new playerDTO();
        sellButton.setVisible(false);

        Player player = table.getSelectionModel().getSelectedItem();

//club.clubPlayers.add(player);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Buying is completed successfully!!!");
        a.setContentText("This player is added to your club now");
        a.showAndWait();


        int idx = table.getSelectionModel().getSelectedIndex();
        cpOL.remove(idx);
        soldPlayer.remove(player);
       // tempcp.add(player);
        //playerList.add(player);
        //actualP.add(player);


        pd.setFrom(clubName);
        pd.setTo("ALL");
        pd.setStatus("Buy");
        pd.setPlayer(player);

        try {
            networkUtil.write(pd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sellAction(ActionEvent event) throws IOException, ClassNotFoundException {
/*ObservableList<Player>sellingP=table.getSelectionModel().getSelectedItems();
        System.out.println(sellingP.size());
networkUtil.write(sellingP.get(0));*/
        sellButton.setVisible(true);
        buyButton.setVisible(false);
        marketLabel.setVisible(false);
        //playerDTO pd=new playerDTO();
        Player player = table.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText("Selling request is sent to Server");
        a.showAndWait();

        int idx = table.getSelectionModel().getSelectedIndex();
        cpOL.remove(idx);
        playerList.remove(player);
       // actualP.remove(player);


        //tempcpOl.remove(idx);
        //pd.list.add(player);
        //sellPlayer.setPlayer(player);
        System.out.println("Player sold: " + player.getName());

        pd.setFrom(clubName);
        pd.setTo("ALL");
        pd.setStatus("Sell");
        pd.setPlayer(player);
        pd.setIndex(idx);

        try {
            networkUtil.write(pd);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //networkUtil.write(sellPlayer);

       for(Player p:cpOL)
       {
           tempcp.add(p);
       }
       // System.out.println("size of tempcpol is " + tempcp.size());
        //main.setTempcp(cpOL);
       // System.out.println("sizeof main er tempcp " + main.getTempcp().size());


    }

    @FXML
    void clubTableAction(ActionEvent event) throws IOException {
        // table.setEditable(true);
        // table.setItems( tempcpOl);
        //main.showAuctionTable(tempcpOl,clubName);
        marketLabel.setVisible(false);
        buyButton.setVisible(false);
        sellButton.setVisible(true);
        cpOL.clear();
        //tempcp = main.getTempcp();
        //System.out.println("sizeof main er tempcp in cp button " + tempcp.size());
        for (Player player : playerList) {
            if(!soldPlayer.contains(player)&&!cpOL.contains(player))
            cpOL.add(player);
        }
        //System.out.println("size of tempcpol is in ct button"+tempcp.size());
        //System.out.println("size of cpol is in ct button"+cpOL.size());

    }


    @FXML
    void submenu1Action(ActionEvent event) throws Exception {
        main.loginWindow();
    }


    public void setMain(Main main) {
        this.main = main;
        //System.out.println(cpOL.size());
    }
}
