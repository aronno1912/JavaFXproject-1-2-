package sample;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import Classes.*;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CountryWisePlayerCountController implements Initializable {
    List<Player> playerList;
    List<Country> countryList;
    List<Club> clubList;

private Main main;
    @FXML
    private AnchorPane ap;
    @FXML
    private PieChart pieChart;
    @FXML
    private Button submenu;

    @FXML
    void submenuAction(ActionEvent event) throws Exception {
main.showSearchPlayerMenu();
    }


    void init(List<Player> playerList, List<Country> countryList, List<Club> clubList){
        this.playerList = playerList;
        this.countryList= countryList;
        this.clubList = clubList;
        ap.getChildren().add(pieChart);

    }

    public void setMain(Main main) {
        this.main=main;
    }
    AnchorPane getAp()
    {return ap;}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData=
                FXCollections.observableArrayList(
                        new PieChart.Data("Spain",3),
                        new PieChart.Data("England",3),
                        new PieChart.Data("France",2),
                        new PieChart.Data("Portugal",2),
                        new PieChart.Data("Uruguay",1),
                        new PieChart.Data("Brazil",3),
                        new PieChart.Data("Belgium",1),
                        new PieChart.Data("Germany",3),
                        new PieChart.Data("Senegal",1),
                        new PieChart.Data("Italy",1),
                        new PieChart.Data("Netherlands",1),
                        new PieChart.Data("Egypt",1),
                        new PieChart.Data("Switzerland",1),
                        new PieChart.Data("Ghana",1),
                        new PieChart.Data("Gabon",1));

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(),"-",data.pieValueProperty()
                        )
                )

                );

pieChart.getData().addAll(pieChartData);


    }
}
