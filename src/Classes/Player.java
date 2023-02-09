package Classes;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import sample.Main;
import util.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
//List<Player> sellingList=new ArrayList<>();
    private String name;
    private String country;
    private int age;
    private double height;
    private String club;
    private String position;
    private int jerseyNo;
    private double weeklySalary;
    private Button button;
    private Main main;
//NetworkUtil networkUtil=new NetworkUtil("this is selling list",55555);
    Player()  {
        //button=new Button("Click");

        /*button.setOnAction( e -> {

                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Selling Request is sent to server");
                    a.showAndWait();


            System.out.println(name);
                   /* try {
                        networkUtil.write(name);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }*/




       // );
    }
    Player(String name,String country,int age,double height, String club,String position,int jerseyNo,double weeklySalary) throws IOException {
        this.name = name;
        this.country = country;
        this.age = age;
        this.weeklySalary = weeklySalary;
        this.jerseyNo = jerseyNo;
        this.height = height;
        this.club = club;
        this.position = position;
        //this.button=new Button("Click");

    }


    public void printPlayerInfo()
    {
        System.out.println("Name: "+name);
        System.out.println("Country: " + country);
        System.out.println(("Age: "+age));
        System.out.println("Height: "+height);
        System.out.println("Club: " + club);
        System.out.println("Position: "+ position);
        System.out.println("Jersey No: "+ jerseyNo);
        System.out.println("Weekly Salary: "+ weeklySalary);
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJerseyNo() {
        return jerseyNo;
    }

    public void setJerseyNo(int jerseyNo) {
        this.jerseyNo = jerseyNo;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
   /* public void setButton(Button button)
    {
        this.button=button;
    }
    public Button getButton()
    {
        return button;
    }*/

}
