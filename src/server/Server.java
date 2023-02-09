package server;

import Classes.Player;
import util.Clubinfo;
import util.NetworkUtil;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Server {

    private ServerSocket serverSocket;
    public HashMap<String, String> userMap;
    public HashMap<String, Clubinfo>userMap1;
    public List<Player> playerList;
    public List<Player>sp=new ArrayList<>();

 Server() {
        userMap = new HashMap<>();
        userMap.put("Manchester United", "abc");
        userMap.put("Manchester City", "abc");
        userMap.put("Chelsea", "abc");
        userMap.put("Liverpool", "abc");
        userMap.put("Arsenal", "abc");
         userMap1=new HashMap<>();
        userMap1.put("Arsenal", new Clubinfo());
        userMap1.put("Manchester United" , new Clubinfo());
        userMap1.put("Manchester City" , new Clubinfo());
        userMap1.put("Chelsea" , new Clubinfo());
        userMap1.put("Liverpool" , new Clubinfo());

        try {
            serverSocket = new ServerSocket(4444);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }


    public void serve(Socket clientSocket) throws IOException {
        NetworkUtil networkUtil = new NetworkUtil(clientSocket);
        new ReadThreadServer(userMap1, networkUtil,playerList);

    }
    //public void setsp(List<Player>sp){this.sp=sp;}
    //public List<Player>getsp(){return sp;}

    public static void main(String[] args) {
        new Server();
    }
}
