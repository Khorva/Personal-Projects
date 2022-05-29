package fgo_servantwiki;

public class FGO_ServantWiki {
    public static void main(String[] args) {    
        Database database = new Database();

        //Keep in mind, the filepathlocation always starts from the actual project. Atm, the filepaths start from C:\Users\kuroi\Documents\NetBeansProjects\GitPersonal-Projects\FGO_ServantWiki
        //Pictures are stored within "Pictures" folder within "src"
        
        new MainWin(database);
    }
    
}
