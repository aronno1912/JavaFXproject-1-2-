package Classes;

//needed many times to find a country,player and club
import java.util.List;

public class SearchOperation {
    public int findCountry(List<Country> countryList, String country) {
        for(int i = 0;i<countryList.size();i++){
            if(countryList.get(i).getName().equalsIgnoreCase(country)){
                return i;
            }
        }
        return -1;
    }

    public int findPlayer(List<Player> playerList, String pName) {
        for(int i = 0;i<playerList.size();i++){
            if(playerList.get(i).getName().equalsIgnoreCase(pName)){
                return i;
            }
        }
        return -1;
    }

    public int findClub(List<Club> clubs, String clubName) {
        for(int i = 0;i<clubs.size();i++){
            if(clubs.get(i).getName().equalsIgnoreCase(clubName)){
                return i;
            }
        }
        return -1;
    }
}
