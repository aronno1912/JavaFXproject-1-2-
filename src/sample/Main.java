package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Classes.*;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private Stage stage;
    private int found;
    private NetworkUtil networkUtil;
    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public Stage getStage() {
        return stage;
    }
    List<Player> playerList=new ArrayList();
    List<Player> tempPlayerList=new ArrayList();
    List<Player>soldPlayers=new ArrayList<>();
    List<Club> clubs = new ArrayList();
    List<Country>countryList = new ArrayList();
    List<Player>tempcp=new ArrayList<>();
    List<Player>aucplayerlist=new ArrayList<>();

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 4444;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }
    @Override
    public void start(Stage primaryStage) throws Exception{
        //read the txt file//
        FileOp fileOp=new FileOp();
        try {
            playerList=fileOp.readFile("players.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // Create a AddPlayer object to add the players to the club and the country class

        AddPlayer addPlayer = new AddPlayer();

        for (Player temp : playerList) {
            addPlayer.clubAddition(clubs,temp);
            addPlayer.countryAddition(countryList,temp);

        }
        stage=primaryStage;
        connectToServer();
        showMainMenu();

    }

   public void showMainMenu() throws Exception {
       // XML Loading using FXMLLoader
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("mainmenu.fxml"));
       Parent root = loader.load();

       // Loading the controller
       MainMenuController controller = loader.getController();
       controller.setMain(this);
       //controller.init();

       // Set the primary stage
       stage.setTitle("MainMenu");
       stage.setScene(new Scene(root, 636, 600));
       stage.show();
    }

    public void showSearchPlayerMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchPlayerMenu.fxml"));
        Parent root = loader.load();

        // Loading the controller
      SearchPlayerMenuController controller = loader.getController();
        controller.init(playerList,countryList, clubs);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("SearchPlayerMenu");
        stage.setScene(new Scene(root, 938, 700));
        stage.show();

    }
    public void showSearchClubMenu() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SearchClubMenu.fxml"));
        Parent root = loader.load();

        // Loading the controller
        SearchClubMenuController controller = loader.getController();
        controller.init(playerList,countryList, clubs);
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("SearchClubMenu");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();

    }

    public void showCountryWiseCount() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CountryWisePlayerCount.fxml"));
        Parent root = loader.load();

        // Loading the controller
       CountryWisePlayerCountController controller = loader.getController();
       // controller.init(playerList,countryList, clubs);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("CountryWiseCount");
        stage.setScene(new Scene(root, 600, 600));
        stage.show();

    }
    public void showPlayerCard() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PlayerCard.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PlayerCardController controller = loader.getController();
       controller.init(playerList,countryList, clubs);
        controller.setData(playerList.get(found));
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("PlayerCard");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showPlayerTable(List<Player>temp) throws Exception {
       tempPlayerList=temp;
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PlayerTable.fxml"));
        Parent root = loader.load();

        // Loading the controller
        PlayerTableController controller = loader.getController();
        controller.init(playerList,countryList, clubs);
        controller.setValues(tempPlayerList);

        //controller.setData(playerList.get(found));
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("PlayerTable");
        stage.setScene(new Scene(root, 712,800 ));
        stage.show();
    }
    public void loginWindow() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("LogInAuction.fxml"));
        Parent root = loader.load();

        // Loading the controller
       LogInAuctionController controller = loader.getController();
        controller.setMain(this);
        controller.init(playerList,countryList,clubs);

        // Set the primary stage
        stage.setTitle("Log In as your Club Name");
        stage.setScene(new Scene(root, 600, 507));
        stage.show();
    }
    public void showAuctionTable(List<Player> temp, String clubName) throws IOException {
       aucplayerlist=temp;
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("auctionTable.fxml"));
        Parent root = loader.load();

        // Loading the controller
        auctionTableController controller = loader.getController();
        controller.init(aucplayerlist,countryList, clubs,clubName,networkUtil);
        controller.setValues(aucplayerlist,clubName,networkUtil);

        //controller.setData(playerList.get(found));
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("atTable");
        stage.setScene(new Scene(root, 800,800 ));
        stage.show();
    }



    public static void main(String[] args) {

       /* List<Player> playerList=new ArrayList();
        List<Club> clubs = new ArrayList();
        List<Country>countryList = new ArrayList();*/


        launch(args);
    }


    public void setFind(int found) {
        this.found=found;
    }

    public List<Player> getSoldPlayer()
    {
        return soldPlayers;
    }
    public void setSoldPlayer(List<Player>soldPlayers)
    {
        System.out.println(soldPlayers.size());
        this.soldPlayers=soldPlayers;
    }
    public List<Player>getTempcp(){return tempcp;}
    public void setTempcp(List<Player>tempcp)
    {this.tempcp=tempcp;}


}
