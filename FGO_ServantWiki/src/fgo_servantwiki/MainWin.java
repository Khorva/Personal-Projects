package fgo_servantwiki;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
        
import java.awt.FlowLayout;

public class MainWin extends JFrame {
    private Database database;
    
    public MainWin(String string){
        super(string);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,200);
        
        setVisible(true);
    }
    //This is a Test Constructor; Will Delete after Sprint 1
    public MainWin(Database database){
        super();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,200);
        
        JMenuBar menubar = new JMenuBar();
        JMenuItem file = new JMenuItem("File");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem about = new JMenuItem("About");
        
        this.database = database;
        
        JLabel full = new JLabel(this.database.getCE(0).getFullPicture());
        JLabel icon = new JLabel(this.database.getCE(0).getIcon());
        this.add(full);
        this.add(icon);
        setLayout(new FlowLayout());
        this.pack();
        setVisible(true);
        
    }
}
