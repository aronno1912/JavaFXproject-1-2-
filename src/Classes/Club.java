package Classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Club implements Serializable {
    private String name;
   public List<Player> clubPlayers=new ArrayList();
    public List<Player> temp=new ArrayList();






    public Club(String name) {
        this.name=name;

    }

    public Club() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public List <Player> getClubPlayers()
    {
        for(Player player:clubPlayers)
        {
            temp.add(player);
        }
        return temp;
    }


    //total yearly salary of a club
    public double getTotalSalary()
    {
        double totals=0.0;
        for(Player player:clubPlayers)
        {
            totals+=player.getWeeklySalary();
        }
        totals=totals/1000000; //convert total salary to million

        return (totals*52); //a year has 52 weeks
    }
}

