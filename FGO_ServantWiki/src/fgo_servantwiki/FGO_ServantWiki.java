package fgo_servantwiki;

public class FGO_ServantWiki {
    public static void main(String[] args) {    
        Database database = new Database();
        
        CE Tenacity = new CE("Tenacity", 1, 1);
        Tenacity.setIllustrator("");
        //Keep in mind, the filepathlocation always starts from the actual project. Atm, the filepaths start from C:\Users\kuroi\Documents\NetBeansProjects\FGO_ServantWiki
        Tenacity.setIcon("Pictures/Tenacityicon.png");
        Tenacity.setFullPicture("Pictures/TenacityFull.png");
        Tenacity.setMinAtt(0);
        Tenacity.setMaxAtt(0);
        Tenacity.setMinHP(100);
        Tenacity.setMaxHP(300);
        Tenacity.setStars(1);
        Tenacity.setCost(1);
        Tenacity.setMaxLVL(50);
        Tenacity.setNumEffects(1);
        Tenacity.setBuffs(3, 0);
        Tenacity.setMLBBuffs(5,0);
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
        
        //Printing Buffs & MLBBUFFS
        for(int i = 0; i < Tenacity.getNumEffects(); i++){
            System.out.println("Buffs = " + Tenacity.getBuffs().get(i));
        }
        for(int i = 0; i < Tenacity.getNumEffects(); i++){
            System.out.println("MLBBuffs = " + Tenacity.getMLBBuffs().get(i));
        }
        System.out.println(Tenacity.getDescription());
        
        new MainWin(database);
    }
    
}
