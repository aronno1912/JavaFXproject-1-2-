package server;

import Classes.Club;
import Classes.Player;
import util.Clubinfo;
import util.NetworkUtil;
import util.SellPlayer;
import util.playerDTO;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ReadThreadServer implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;
    public HashMap<String, Clubinfo> userMap;
    private playerDTO pd;
    private List<Player>playerList;


    public ReadThreadServer(HashMap<String, Clubinfo> map, NetworkUtil networkUtil, List<Player> playerList) {
        this.userMap = map;
        this.playerList = playerList;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof Club) {
                        Club club = (Club) o;
                        Clubinfo clubinfo = userMap.get(club.getName());
                        if(clubinfo != null){

                            clubinfo.setNetworkUtil(networkUtil);
                            clubinfo.setOnline(true);
                           // System.out.println(clubinfo.isOnline());
                            //networkUtil.write("success,"+ club.getName());
                        }else{
                            //
                            // networkUtil.write("failure");
                        }
                    }
                    if(o instanceof playerDTO) {
                        playerDTO obj = (playerDTO) o; //for the write in sell button//
                        if (obj.getStatus().equals("Sell")) {
                            //System.out.println("Sold Player in Server :" + obj.getPlayer().getName());
                            //playerList.add(obj.getPlayer());
                            //obj.addPlayer(obj.getPlayer());
                            Iterator<String> iterator = userMap.keySet().iterator();
                            while (iterator.hasNext()) {
                                String name = iterator.next();
                                Clubinfo clientInfo = userMap.get(name);
                               // System.out.println("In sell if" + obj.getPlayer().getName() + clientInfo.isOnline());

                                if (!name.equals(obj.getFrom()) && clientInfo.isOnline()) {
                                    clientInfo.getNetworkUtil().write(obj);
                                     //System.out.println("In sell if" + obj.getPlayer().getName() + clientInfo.isOnline());

                                }
                            }
                        }
                        if(obj.getStatus().equals("Buy")){
                            Iterator<String> iterator = userMap.keySet().iterator();
                            while (iterator.hasNext()) {
                                String name = iterator.next();
                                Clubinfo clientInfo = userMap.get(name);
                                if (!name.equals(obj.getFrom()) && clientInfo.isOnline()) {
                                    clientInfo.getNetworkUtil().write(obj);
                                }
                            }
                        }
                    }
                    /*if(o instanceof SellPlayer)
                    {
                        SellPlayer obj=(SellPlayer) o;
                        playerList=obj.getPlayer();
                        for(Player player:playerList)
                        {
                            System.out.println(player.getName());
                        }
                    }*/
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




