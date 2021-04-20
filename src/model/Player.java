package model;

public class Player {
    private String name;
    private String team;
    private int year;
    private int age;
    private double per;
    private double trueShooting;
    private double rebounds;
    private double assists;
    private double steals;

    public Player(String name, String team, int year, int age, double per, double trueShooting, double rebounds, double assists, double steals){
        this.name = name;
        this.team = team;
        this.year = year;
        this.age = age;
        this.per = per;
        this.trueShooting = trueShooting;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPer() {
        return per;
    }

    public void setPer(double per) {
        this.per = per;
    }

    public double getTrueShooting() {
        return trueShooting;
    }

    public void setTrueShooting(double trueShooting) {
        this.trueShooting = trueShooting;
    }

    public double getRebounds() {
        return rebounds;
    }

    public void setRebounds(double rebounds) {
        this.rebounds = rebounds;
    }

    public double getAssists() {
        return assists;
    }

    public void setAssists(double assists) {
        this.assists = assists;
    }

    public double getSteals() {
        return steals;
    }

    public void setSteals(double steals) {
        this.steals = steals;
    }

    public int getAge(int age){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
