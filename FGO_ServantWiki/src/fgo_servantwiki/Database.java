package fgo_servantwiki;

import java.util.ArrayList;

public class Database {
    private ArrayList<CE> CEs;
    
    public Database(){
        CEs = new ArrayList<>();
    }
    public ArrayList<CE> getCEs(){
        return CEs;
    }
    public void addCE(CE ce){
        CEs.add(ce);
    }
    public CE getCE(int index){
        return CEs.get(index); 
    }
}
