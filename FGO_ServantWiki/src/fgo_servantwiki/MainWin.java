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
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.DefaultTableModel;
        
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;

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
        JLabel full = new JLabel(this.database.getCE(0).getFullPicture());
        JLabel icon = new JLabel(this.database.getCE(0).getIcon());
          
        JTable ceTable = new JTable(database.getCEs().size(),3);
        ceTable.getColumnModel().getColumn(1).setCellRenderer(new imageTableCellRenderer());
        ceTable.setRowHeight(108);
        
        for(int i = 0; i < database.getCEs().size(); i++){
            for(int j = 0; j < 3; j++){
                if(j==0){ceTable.setValueAt(database.getCE(i).getID(),i,j);}
                if(j==1){ceTable.setValueAt(database.getCE(i).getIcon(),i,j);}
                if(j==2){ceTable.setValueAt(database.getCE(i).getName(),i,j);}
            }
        }
        
        JScrollPane scrollpane = new JScrollPane(ceTable);
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
    private class imageTableCellRenderer extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int colum){
            String imagePath = value.toString();
            ImageIcon icon = new ImageIcon(new ImageIcon("src/" + imagePath).getImage().getScaledInstance(99,108,Image.SCALE_DEFAULT));
            return new JLabel(icon);
        }
    }
}
