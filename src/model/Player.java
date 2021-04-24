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
    private double blocks;
    /**
     * Name: book
     * Constructor method of a player. <br>
     * @param name - name of the player  - name = String, name != null, name != ""
     * @param team - team of the player  - team = String, team != null, team != ""
     * @param year - year of player´s debut - year = int
     * @param age - age of player - age = int
     * @param per - Player efficiency rating - per = double
     * @param trueShooting - TrueShoting - trueShooting = double
     * @param rebounds - rebounds of the player - rebounds = double
     * @param assists - assists of the player - assists = double
     * @param steals - steals of the player - steals = double
     * @param blocks - blocks of the player - block = double
     */
    public Player(String name, String team, int year, int age, double per, double trueShooting, double rebounds, double assists, double steals, double blocks){
        this.name = name;
        this.team = team;
        this.year = year;
        this.age = age;
        this.per = per;
        this.trueShooting = trueShooting;
        this.rebounds = rebounds;
        this.assists = assists;
        this.steals = steals;
        this.blocks = blocks;
    }
	/**
	 * Name: getName
	 * Method used to get the name of the player. <br>
	 * @return A String representing the name of the player.
	*/
    public String getName() {
        return name;
    }
	/**
	 * Name: setName
	 * Method used to update the name of the player.  <br>
	 * @param name - name of the player - name = String, name != null, name != ""
	*/
    public void setName(String name) {
        this.name = name;
    }
	/**
	 * Name: getTeam
	 * Method used to get the team of the player. <br>
	 * @return A String representing the team of the player.
	*/
    public String getTeam() {
        return team;
    }
	/**
	 * Name: setTeam
	 * Method used to update the team of the player.  <br>
	 * @param team - team  of the player - team  = String, team  != null, team  != ""
	*/
    public void setTeam(String team) {
        this.team = team;
    }
	/**
	 * Name: getYear
	 * Method used to get the year debut of the player. <br>
	 * @return A int representing the year debut of the player.
	*/
    public int getYear() {
        return year;
    }
	/**
	 * Name: setYear
	 * Method used to update the year debut of the player.  <br>
	 * @param year - year debut of the player - year = int
	*/
    public void setYear(int year) {
        this.year = year;
    }
	/**
	 * Name: getPer
	 * Method used to get the Player efficiency rating of the player. <br>
	 * @return A double representing the Player efficiency rating of the player.
	*/
    public double getPer() {
        return per;
    }
	/**
	 * Name: setPer
	 * Method used to update the  Player efficiency rating of the player.  <br>
	 * @param per -  Player efficiency rating of the player - per = double
	*/
    public void setPer(double per) {
        this.per = per;
    }
	/**
	 * Name: getTrueShooting
	 * Method used to get the trueShooting of the player. <br>
	 * @return A double representing the trueShooting of the player.
	*/
    public double getTrueShooting() {
        return trueShooting;
    }
	/**
	 * Name: setTrueShooting
	 * Method used to update the TrueShooting of the player.  <br>
	 * @param trueShooting - stTrueShooting of the player - TrueShooting = double
	*/
    public void setTrueShooting(double trueShooting) {
        this.trueShooting = trueShooting;
    }
    /**
	 * Name: getRebounds
	 * Method used to get the rebounds of the player. <br>
	 * @return A double representing the rebounds of the player.
	*/
    public double getRebounds() {
        return rebounds;
    }
	/**
	 * Name: setRebounds
	 * Method used to update the rebounds of the player.  <br>
	 * @param rebounds - rebounds of the player - rebounds = double
	*/
    public void setRebounds(double rebounds) {
        this.rebounds = rebounds;
    }
    /**
	 * Name: getAssists
	 * Method used to get the Assists of the player. <br>
	 * @return A double representing the Assists of the player.
	*/
    public double getAssists() {
        return assists;
    }
	/**
	 * Name: setAssists
	 * Method used to update the assists of the player.  <br>
	 * @param assists - assists of the player - assists = double
	*/
    public void setAssists(double assists) {
        this.assists = assists;
    }
    /**
	 * Name: getSteals
	 * Method used to get the steals of the player. <br>
	 * @return A double representing the steals of the player.
	*/
    public double getSteals() {
        return steals;
    }
	/**
	 * Name: setSteals
	 * Method used to update the steals of the player.  <br>
	 * @param steals - steals of the player - steals = double
	*/
    public void setSteals(double steals) {
        this.steals = steals;
    }
    /**
	 * Name: getAge
	 * Method used to get the age of the player. <br>
	 * @return A int representing the age of the player.
	*/
    public int getAge(){
        return age;
    }
	/**
	 * Name: setAge
	 * Method used to update the age of the player.  <br>
	 * @param age - age of the player - age = int
	*/
    public void setAge(int age){
        this.age = age;
    }
    /**
	 * Name: getBlocks
	 * Method used to get the blocks of the player. <br>
	 * @return A double representing the blocks of the player.
	*/
    public double getBlocks() {
        return blocks;
    }
	/**
	 * Name: setBlocks
	 * Method used to update the blocks of the player.  <br>
	 * @param blocks - blocks of the player - blocks = double
	*/
    public void setBlocks(double blocks) {
        this.blocks = blocks;
    }
}
