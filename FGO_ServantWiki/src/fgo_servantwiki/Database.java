package fgo_servantwiki;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

public class Database {
    private ArrayList<CE> CEs;
    private String filename;
    
    public Database(){
        CEs = new ArrayList<>();
        filename = "untitled.db";
    }
    public Database(BufferedReader br) throws IOException{
      CEs = new ArrayList<CE>(); 
      while(br.ready()){
          CE ce = new CE(br);
          this.addCE(ce);
      }
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
    public void save(BufferedWriter bw) throws IOException{
        for (CE ce : CEs){
            ce.save(bw);
        }
    }
    public String getFilename(){
        return filename;
    }
    public void setFilename(String filename){
        this.filename = filename;
    }
}
