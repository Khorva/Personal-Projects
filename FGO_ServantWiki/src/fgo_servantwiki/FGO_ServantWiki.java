package fgo_servantwiki;

public class FGO_ServantWiki {
    public static void main(String[] args) {    
        Database database = new Database();
        
        CE Tenacity = new CE("Tenacity", 1);
        Tenacity.setIllustrator("");
        //Keep in mind, the filepathlocation always starts from the actual project. Atm, the filepaths start from C:\Users\kuroi\Documents\NetBeansProjects\GitPersonal-Projects\FGO_ServantWiki
        //Pictures are stored within "Pictures" folder within "src"
        Tenacity.setIcon("src/Pictures/Icon_CE_0001.png");
        Tenacity.setFullPicture("src/Pictures/Portrait_CE_0001.png");
        Tenacity.setMinAtt(0);
        Tenacity.setMaxAtt(0);
        Tenacity.setMinHP(100);
        Tenacity.setMaxHP(300);
        Tenacity.setStars(1);
        Tenacity.setCost(1);
        Tenacity.setMaxLVL(50);
        Tenacity.setBuffs("Increase your DEF by 3%");
        Tenacity.setMLBBuffs("Increase your DEF by 5%");
        Tenacity.setDescription("That which holds sturdy. Training turns the body to rock.");
        
        database.addCE(Tenacity);

        CE Meditation = new CE("Meditation", 2);
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
        Meditation.setBuffs("Increase your Debuff Resist by 5%");
        Meditation.setMLBBuffs("Increase your DEbuff Resist by 10%");
        Meditation.setDescription("A brief, silent moment.\n" + "Man comes to know his origin.\n");

        database.addCE(Meditation);
        
        System.out.println("arraysize = " + database.getCEs().size());
        
        new MainWin(database);
    }
    
}
