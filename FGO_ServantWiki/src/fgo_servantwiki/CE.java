package fgo_servantwiki;

import javax.swing.ImageIcon;
import java.lang.StringBuilder;

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
    private int numEffs;
    private String buffs;
    private String mlbBuffs;
    private String eventBuffs;
    private String mlbEventBuffs;
    private String description;
    
    //Constructor
    public CE(String name, int iD){
        this.name = name;
        this.iD = iD;
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
    public void setNumEffs(int numEffs){
        this.numEffs = numEffs;
    }
    public void setBuffs(String buffs){
        this.buffs = buffs;
    }
    public void setMLBBuffs(String mlbBuffs){
        this.mlbBuffs= mlbBuffs;
    }
    public void setEventBuffs(String eventBuffs){
        this.eventBuffs = eventBuffs;
    }
    public void setMLBEventBuffs(String mlbEventBuffs){
        this.mlbEventBuffs = mlbEventBuffs;
    }
    public void setDescription(String description){
        //Adding New Line characters into the description in HTML
        description = description.replaceAll("\n","<br>");
        StringBuilder s = new StringBuilder("<html>");
        s.append(description).append("</html>");
        System.out.println(s);
        this.description = s.toString();
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
    public int getNumEffs(){
        return numEffs;
    }
    public String getBuffs(){
        return buffs;
    }
    public String getMLBBuffs(){
        return mlbBuffs;
    }
    public String getEventBuffs(){
        return eventBuffs;
    }
    public String getMLBEventBuffs(){
        return mlbEventBuffs;
    }
    public String getDescription(){
        return description;
    }
}
