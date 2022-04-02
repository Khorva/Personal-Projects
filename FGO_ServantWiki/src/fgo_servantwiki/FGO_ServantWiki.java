package fgo_servantwiki;

public class FGO_ServantWiki {
    public static void main(String[] args) {    
        Database database = new Database();
        
        CE Tenacity = new CE("Tenacity", 1, 1);
        Tenacity.setIllustrator("");
        //Keep in mind, the filepathlocation always starts from the actual project. Atm, the filepaths start from C:\Users\kuroi\Documents\NetBeansProjects\FGO_ServantWiki
        Tenacity.setIcon("src/Pictures/Icon_CE_0001.png");
        Tenacity.setFullPicture("src/Pictures/Portrait_CE_0001.png");
        Tenacity.setMinAtt(0);
        Tenacity.setMaxAtt(0);
        Tenacity.setMinHP(100);
        Tenacity.setMaxHP(300);
        Tenacity.setStars(1);
        Tenacity.setCost(1);
        Tenacity.setMaxLVL(50);
        Tenacity.setNumEffects(1);
        Tenacity.setBuffs("Increase your DEF by 3%");
        Tenacity.setMLBBuffs("Increase your DEF by 5%");
        Tenacity.setDescription("That which holds sturdy. Training turns the body to rock.");
        
        database.addCE(Tenacity);
        
        System.out.println("Illustrator = " + Tenacity.getIllustrator());
        System.out.println(Tenacity.getMinAtt());
        System.out.println(Tenacity.getMaxAtt());
        System.out.println(Tenacity.getMinHP());
        System.out.println(Tenacity.getMaxHP());
        System.out.println(Tenacity.getStars());
        System.out.println(Tenacity.getCost());
        System.out.println(Tenacity.getMaxLVL());
        System.out.println(Tenacity.getNumEffects());
        
        CE Meditation = new CE("Meditation", 2, 1);
        Meditation.setIllustrator("");
        Meditation.setIcon("src/Pictures/Icon_CE_0002.png");
        Meditation.setFullPicture("src/Pictures/Portrait_CE_0002.png");
        Meditation.setMinAtt(0);
        Meditation.setMaxAtt(0);
        Meditation.setMinHP(150);
        Meditation.setMaxHP(450);
        Meditation.setStars(1);
        Meditation.setCost(1);
        Meditation.setMaxLVL(50);
        Meditation.setNumEffects(1);
        Meditation.setBuffs("Increase your Debuff Resist by 5%");
        Meditation.setMLBBuffs("Increase your DEbuff Resist by 10%");
        Meditation.setDescription("A brief, silent moment. Man comes to know his origin.");
        
        System.out.println("Illustrator = " + Meditation.getIllustrator());
        System.out.println(Meditation.getMinAtt());
        System.out.println(Meditation.getMaxAtt());
        System.out.println(Meditation.getMinHP());
        System.out.println(Meditation.getMaxHP());
        System.out.println(Meditation.getStars());
        System.out.println(Meditation.getCost());
        System.out.println(Meditation.getMaxLVL());
        System.out.println(Meditation.getNumEffects());
        
        database.addCE(Meditation);
        
        System.out.println("arraysize = " + database.getCEs().size());
        
        //Printing Buffs & MLBBUFFS
        for(int i = 0; i < Tenacity.getNumEffects(); i++){
            System.out.println("Buffs = " + Tenacity.getBuffs());
        }
        for(int i = 0; i < Tenacity.getNumEffects(); i++){
            System.out.println("MLBBuffs = " + Tenacity.getMLBBuffs());
        }
        System.out.println(Tenacity.getDescription());
        
        new MainWin(database);
    }
    
}
