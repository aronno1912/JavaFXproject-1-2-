package Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOp {

    //reads from file and so returns a List//
    public List<Player> readFile(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        List<Player>tempList = new ArrayList();
        while(true)
        {
            Player temp=new Player();
            String line = br.readLine();

            if(line == null)break;
            String[] tokens = line.split(",");
            temp.setName(tokens[0]);
            temp.setCountry(tokens[1]);
            temp.setAge(Integer.parseInt(tokens[2]));
            temp.setHeight(Double.parseDouble(tokens[3]));
            temp.setClub(tokens[4]);
            temp.setPosition(tokens[5]);
            temp.setJerseyNo(Integer.parseInt(tokens[6]));
            temp.setWeeklySalary(Double.parseDouble(tokens[7]));
            tempList.add(temp);
        }
        br.close();
        return tempList;

    }
    //write to a file//
    void writeFile(List<Player> playerList,String filename) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter(filename));
        Player temp=new Player();
        for (Player player:
                playerList) {
            temp=player;
            bw.write(temp.getName() + "," + temp.getCountry() + "," + temp.getAge() + "," + temp.getHeight() + "," + temp.getClub() + "," + temp.getPosition() + "," + temp.getJerseyNo() + "," + temp.getWeeklySalary());
            bw.write("\n");

        }
        bw.close();
    }

}
