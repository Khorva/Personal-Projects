package fgo_servantwiki;

import javax.swing.ImageIcon;

public class CE {
    private String name;
    private int iD;
    private String illustrator;
    private ImageIcon icon;
    private ImageIcon fullPicture;
    private int minAtt;
    private int minHP;
    private int maxAtt;
    private int maxHP;
    private int stars;
    private int cost;
    private int maxLevel;
    private int numEffects;
    private String buffs;
    private String mlbBuffs;
    private String description;
    
    //Constructor
    public CE(String name, int iD, int numEffects){
        this.name = name;
        this.iD = iD;
        this.numEffects = numEffects;
    }
    //Setters
    public void setIllustrator(String string){
        this.illustrator = string;
    }
    public void setIcon(String string){
        this.icon = new ImageIcon(string);
    }
    public void setFullPicture(String string){
        this.fullPicture = new ImageIcon(string);
    }
    public void setMinAtt(int att){
        this.minAtt = att;
    }
    public void setMaxAtt(int att){
        this.maxAtt = att;
    }
    public void setMinHP(int hp){
        this.minHP = hp;
    }
    public void setMaxHP(int hp){
        this.maxHP = hp;
    }
    public void setStars(int stars){
        this.stars = stars;
    }
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setMaxLVL(int maxLevel){
        this.maxLevel = maxLevel;
    }
    public void setNumEffects(int num){
        this.numEffects = num;
    }
    public void setBuffs(String buffs){
        this.buffs = buffs;
    }
    public void setMLBBuffs(String mlbBuffs){
        this.mlbBuffs= mlbBuffs;
    }
    public void setDescription(String description){
        this.description = description;
    }
    //Getters
    public String getName(){
        return name;
    }
    public int getID(){
        return iD;
    }
    public String getIllustrator(){
        return illustrator;
    }
    public ImageIcon getIcon(){
        return icon;
    }
    public ImageIcon getFullPicture(){
        return fullPicture;
    }
    public int getMinAtt(){
        return minAtt;
    }
    public int getMaxAtt(){
        return maxAtt;
    }
    public int getMinHP(){
        return minHP;
    }
    public int getMaxHP(){
        return maxHP;
    }
    public int getStars(){
        return stars;
    }
    public int getCost(){
        return cost;
    }
    public int getMaxLVL(){
        return maxLevel;
    }
    public int getNumEffects(){
        return numEffects;
    }
    public String getBuffs(){
        return buffs;
    }
    public String getMLBBuffs(){
        return mlbBuffs;
    }
    public String getDescription(){
        return description;
    }
}
