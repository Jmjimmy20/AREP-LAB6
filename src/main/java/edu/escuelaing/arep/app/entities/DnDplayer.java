package edu.escuelaing.arep.app.entities;

public class DnDplayer{

    public String name;
    public int lifePoints;
    public String race;
    public String pClass;

    public DnDplayer(){}

    public DnDplayer(String name, int lifePoints, String race, String pClass){
        super();
        this.name = name;
        this.lifePoints = lifePoints;
        this.race = race;
        this.pClass = pClass;
    }


    
    public String getName(){ return name;}
    public void setName(String name){this.name = name;}

    public int getLifePoints(){ return lifePoints;}
    public void setLifePoints(int lifePoints){this.lifePoints = lifePoints;}

    public String getRace(){ return race;}
    public void setRace(String race){this.race = race;}

    public String getPclass(){ return pClass;}
    public void setPclass(String pClass){this.pClass = pClass;}


}