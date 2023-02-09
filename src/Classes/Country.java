package Classes;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    public List<Player> countryPlayers = new ArrayList();


    public Country(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Country() {
    }

    public void printCountryPlayers() {
        for (Player player : countryPlayers) {
            player.printPlayerInfo();
            System.out.println();
        }
    }

}