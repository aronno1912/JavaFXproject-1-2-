package Classes;

import java.util.ArrayList;
import java.util.List;

public class GetMaxInfo {
    public static List<Player> getHighestSalary(List<Player> clubPlayers) {

        double highestSalary = 0;
        List<Player> tempList = new ArrayList();

        for (Player player : clubPlayers) {
            if (player.getWeeklySalary() > highestSalary) {
                highestSalary = player.getWeeklySalary();
            }
        }
        for (Player player : clubPlayers) {
            if (player.getWeeklySalary() == highestSalary) {
                tempList.add(player);
            }
        }

        return tempList;
    }


    public static List<Player> getMaxAge(List<Player> clubPlayers) {

        int age = 0;
        List<Player> tempList = new ArrayList();
        for(Player player:clubPlayers){
            if(player.getAge() > age){
                age = player.getAge();
            }
        }



        for(Player player :clubPlayers ){
            if(player.getAge() == age){
                tempList.add(player);
            }
        }

        return tempList;
    }

    public static List<Player> getMaxHeight(List<Player> clubPlayers) {
        double height = 0;
        List<Player> tempList = new ArrayList();
        for(Player player:clubPlayers){
            if(player.getHeight() > height){
                height = player.getHeight();
            }
        }



        for(Player player :clubPlayers ){
            if(player.getHeight() == height){
                tempList.add(player);
            }
        }

        return tempList;
    }
}
