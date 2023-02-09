package sample;

import Classes.Player;
import javafx.application.Platform;
import util.playerDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadThread implements Runnable {
    private final Thread thr;
    private final Main main;


    private static List<Player> soldPlayer = new ArrayList<>();


    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = main.getNetworkUtil().read();
                if (o != null) {
                    if (o instanceof String) {
                        String string = (String) o;
                        String[] s = string.split(",");
                        // System.out.println(club.getName());
                        //System.out.println(club.isOnline());
                        // the following is necessary to update JavaFX UI components from user created threads
                      /* Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                if (s[0].equals("success")) {
                                    try {
                                        main.showAuctionTable(s[1]);
                                        // System.out.println(club.getNetworkUtil());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }*/
                    }
                    if (o instanceof playerDTO) {
                        playerDTO obj = (playerDTO) o;
                        if (obj.getStatus().equals("Sell")) {
                            soldPlayer.add(obj.getPlayer());
                            //System.out.println("in re");
                            main.setSoldPlayer(soldPlayer);
                            for (Player player : soldPlayer) System.out.println(player.getName());
                            //System.out.println("size of sold player in ReadThread is " + soldPlayer.size());
                        }
                        if (obj.getStatus().equals("Buy")) {
                            soldPlayer.remove(obj.getPlayer());
                            main.setSoldPlayer(soldPlayer);
                            for (Player player : soldPlayer) System.out.println(player.getName());
                            //System.out.println("size of sold player in ReadThread is " + soldPlayer.size());
                        }

                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                main.getNetworkUtil().closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}




