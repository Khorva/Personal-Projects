package fgo_servantwiki;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JDialog;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
        
import java.awt.FlowLayout;
import java.awt.BorderLayout;

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
        this.database = database;
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,200);
        
        //Creating the MenuBar
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu ce = new JMenu("CE");
        JMenu about = new JMenu("About");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem addCE = new JMenuItem("Add New CE");
        
        quit.addActionListener(event-> onQuitClick());
        addCE.addActionListener(event-> onAddCEClick());
        
        menubar.add(file);
        menubar.add(ce);
        menubar.add(about);
        file.add(quit);
        ce.add(addCE);
        
        setJMenuBar(menubar);
        
        //Creating ToolBar
        JPanel panel = new JPanel();
        
        JToolBar toolbar = new JToolBar("Database Commands");
        toolbar.add(panel);
        this.getContentPane().add(toolbar, BorderLayout.NORTH);
       
        
        //Testing Icon viewing functionality on JFrame  
        //So far, only icons are show on the JFrame. the full portraits aren't 
        JLabel full = new JLabel(this.database.getCE(1).getFullPicture());
        JLabel icon = new JLabel(this.database.getCE(0).getIcon());
        JScrollPane scrollpane = new JScrollPane(full);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollpane);
        
        setVisible(true);
        
    }
    public void onQuitClick(){
        System.exit(0);
    }
    public void onAddCEClick(){
        JDialog newCE = new JDialog();
        newCE.setTitle("Adding New CE");
        
        newCE.setVisible(true);
    }
}
