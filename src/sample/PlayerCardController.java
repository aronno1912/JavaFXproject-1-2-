package sample;
import Classes.*;
import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class PlayerCardController {
private Main main;

    List<Player> playerList=new ArrayList();
    List<Club> clubs = new ArrayList();
    List<Country>countryList = new ArrayList();
    public void init(List<Player> playerList, List<Country> countryList, List <Club> clubs)
    {
        this.playerList=playerList;
        this.countryList=countryList;
        this.clubs=clubs;
    }
    @FXML
    private Label a;

    @FXML
    private Label name;

    @FXML
    private Label b;

    @FXML
    private Label countryN;

    @FXML
    private Label c;

    @FXML
    private Label age;

    @FXML
    private Label d;

    @FXML
    private Label height;

    @FXML
    private Label e;

    @FXML
    private Label clubN;

    @FXML
    private Label f;

    @FXML
    private Label pos;

    @FXML
    private Label g;

    @FXML
    private Label Jno;

    @FXML
    private Label h;

    @FXML
    private Label salary;
    @FXML
    private Button back;
    @FXML
    private ImageView im1;

    @FXML
    void BackAction(ActionEvent event) throws Exception {
main.showSearchPlayerMenu();
    }

    public void setData(Player ob)
    {
       name.setText(ob.getName());
       countryN.setText(ob.getCountry());
       age.setText(String.valueOf(ob.getAge()));
       height.setText(String.valueOf(ob.getHeight()));
       clubN.setText(ob.getClub());
       pos.setText(ob.getPosition());
       Jno.setText(String.valueOf(ob.getJerseyNo()));
       salary.setText(String.valueOf(ob.getWeeklySalary()));

    }

    public void setMain(Main main) {
        this.main=main;
    }


}
