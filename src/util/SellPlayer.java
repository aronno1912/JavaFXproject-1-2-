package util;

import Classes.Player;

import java.util.ArrayList;
import java.util.List;


public class SellPlayer {
    private Player player;
    private List<Player>sp=new ArrayList<>();
    public void setPlayer(Player player)
    {sp.add(player);}
    public List<Player> getPlayer()
    {return sp;}
}
