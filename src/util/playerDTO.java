package util;

import Classes.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class playerDTO implements Serializable {

    public playerDTO(){}

    private String from;
    private String to;
    private Player player;
    private String status;
    private int index;
   public List<Player> list=new ArrayList<>();
    public List<Player> getList()
    {
        return list;
    }
    public void setList(List<Player>list)
    {
        this.list=list;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    public void addPlayer(Player p){
        list.add(p);
    }

    public void removePlayer(int index){
        list.remove(index);
    }

}
