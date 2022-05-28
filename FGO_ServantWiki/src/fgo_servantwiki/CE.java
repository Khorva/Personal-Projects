package fgo_servantwiki;

import javax.swing.ImageIcon;
import java.lang.StringBuilder;
import java.lang.Integer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;


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
    public CE(BufferedReader br){
        
    }
    public void save(BufferedWriter bw) throws IOException{
        bw.write(name + '\n');
        bw.write(Integer.toString(getID()) + '\n');
        bw.write(illustrator + '\n');
        bw.write(icon.toString() + '\n');
        bw.write(fullPicture.toString() + '\n');
        bw.write(Integer.toString(getMinAtt()) + '\n');
        bw.write(Integer.toString(getMinHP()) + '\n');
        bw.write(Integer.toString(getMaxAtt()) + '\n');
        bw.write(Integer.toString(getMaxHP()) + '\n');
        bw.write(Integer.toString(getStars()) + '\n');
        bw.write(Integer.toString(getCost()) + '\n');
        bw.write(Integer.toString(getMaxLVL()) + '\n');
        bw.write(Integer.toString(getNumEffs()) + '\n');
        bw.write(getBuffs() + '\n');
        bw.write(getMLBBuffs() + '\n');
        bw.write(getDescription() + '\n');
        if(numEffs == 2){
            bw.write(getEventBuffs() + '\n');
            bw.write(getMLBEventBuffs() + '\n');
        }
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
