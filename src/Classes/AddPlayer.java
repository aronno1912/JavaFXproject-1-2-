package Classes;

import java.util.List;

public class AddPlayer {

    boolean foundName=false;
    boolean addedToClub=false;
    boolean jerseyFound=false;

    SearchOperation find=new SearchOperation();


    //to make the list of country for the players exist in the file//
    public void countryAddition(List<Country> countryList, Player temp) {
        int countryFound ;
        int countryIndex = -1;

        countryFound = find.findCountry(countryList,temp.getCountry()); // if country found returns index else returns -1 **/

        if (countryFound != -1) {       /** if found, add the player to the country  else, create a new country and add the player **/
            countryIndex = countryFound;
            countryList.get(countryIndex).countryPlayers.add(temp);
        } else {
            Country c = new Country(temp.getCountry());
            countryList.add(c);
            countryList.get(countryList.size() - 1).countryPlayers.add(temp);
        }


    }
    //same as country//
    public void clubAddition(List<Club> clubs, Player temp) {


        int clubFound;
        int clubIndex = -1;

        clubFound = find.findClub(clubs, temp.getClub());

        if (clubFound != -1 ) {

            clubIndex = clubFound;

            if(clubs.get(clubIndex).clubPlayers.size() >= 7){   // if player no is more or equal to 7 in the found club
               // System.out.println("There are already 7 players,can't add more players in this club!!");
                return;
            }
            else {
                clubs.get(clubIndex).clubPlayers.add(temp);
                addedToClub = true;
            }

        }
        else {
            Club c = new Club(temp.getClub()); // new club is created//
            clubs.add(c);
            clubs.get(clubs.size() - 1).clubPlayers.add(temp);
            addedToClub = true;
        }

    }
    public void addNewPlayer(List<Player> playerList, List<Country> countryList, List<Club> clubs, Player temp) {

        //to check if the name is unique or not//
        for(Player player:playerList)
        {
            if(temp.getName().equalsIgnoreCase(player.getName()))
            {
                //System.out.println("Names must be unique!");
                foundName=true;
                return;
            }

        }

        for(Player player : playerList ){
            if(temp.getJerseyNo()== player.getJerseyNo()){  // if jersey number matches
                jerseyFound =true;
                //System.out.println("Same jersey number can't remain in a same club !!!");
                return;
            }
        }

        //add the new player to specific club
        clubAddition(clubs,temp);

        //add the new to the specific country
        countryAddition(countryList,temp);

//add the new player to the playerlist if conditions are satisfied
        if(addedToClub&&!foundName)
            playerList.add(temp);


    }
}
