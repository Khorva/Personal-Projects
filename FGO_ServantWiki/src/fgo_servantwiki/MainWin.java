package fgo_servantwiki;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JDialog;
       
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Insets;

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
       
        //Creating JTable to view list of CEs within the database
        JTable ceTable = new JTable(this.database.getCEs().size(),3);
        ceTable.getColumnModel().getColumn(1).setCellRenderer(new imageTableCellRenderer());
        ceTable.setRowHeight(108);
        ceTable.getColumnModel().getColumn(0).setMaxWidth(50);
        ceTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        ceTable.getColumnModel().getColumn(1).setMaxWidth(115);
        ceTable.getColumnModel().getColumn(1).setMinWidth(99);
        ceTable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){   
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                try{
                    CEview(database.getCE(row));
                }catch(Exception error){
                    System.out.println(error.getMessage());
                }
            }
        });
        
        for(int i = 0; i < this.database.getCEs().size(); i++){
            for(int j = 0; j < 3; j++){
                if(j==0){ceTable.setValueAt(this.database.getCE(i).getID(),i,j);}
                if(j==1){ceTable.setValueAt(this.database.getCE(i).getIcon(),i,j);}
                if(j==2){ceTable.setValueAt(this.database.getCE(i).getName(),i,j);}
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
    public void CEview(CE ce){
        JDialog view = new JDialog(this,ce.getName());
        view.setSize(400,800);
        view.setLayout(new GridBagLayout());
        //These are the constraints for Labels
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 0;
        constraints.weighty = 0;
        constraints.insets = new Insets(2, 5, 2, 5); // Insets(top, left, bottom, right)
        constraints.anchor = GridBagConstraints.LINE_START;
        //Constraints for Data
        GridBagConstraints dataConstraints = (GridBagConstraints) constraints.clone();
        dataConstraints.gridx = 1;
        //Constraints for FullPicture
        GridBagConstraints fullConstraints = (GridBagConstraints) constraints.clone();
        fullConstraints.gridx = 2;
        fullConstraints.gridheight = 10;
        
     
        JLabel name = new JLabel("Name");
        constraints.gridy = 0;
        view.add(name, constraints);
        JLabel nameData = new JLabel(ce.getName());
        dataConstraints.gridy = 0;
        view.add(nameData,dataConstraints);
        
        JLabel id = new JLabel("ID");
        constraints.gridy = 1;
        view.add(id, constraints);
        JLabel idData = new JLabel("" + ce.getID());
        dataConstraints.gridy = 1;
        view.add(idData,dataConstraints);
        
        JLabel illus = new JLabel("Illustrator");
        constraints.gridy = 2;
        view.add(illus, constraints);
        JLabel illusData = new JLabel(ce.getIllustrator());
        dataConstraints.gridy = 2;
        view.add(illusData,dataConstraints);
        
        JLabel att = new JLabel("Att");
        constraints.gridy = 3;
        view.add(att, constraints);
        JLabel attData = new JLabel("" + ce.getMinAtt()+ "/" + ce.getMaxAtt());
        dataConstraints.gridy = 3;
        view.add(attData,dataConstraints);
        
        JLabel hp = new JLabel("HP");
        constraints.gridy = 4;
        view.add(hp, constraints);
        JLabel hpData = new JLabel("" + ce.getMinHP() + "/" + ce.getMaxHP());
        dataConstraints.gridy = 4;
        view.add(hpData,dataConstraints);
        
        JLabel rarity = new JLabel("Rarity");
        constraints.gridy = 5;
        view.add(rarity, constraints);
        JLabel rarityData = new JLabel("" + ce.getStars());
        dataConstraints.gridy = 5;
        view.add(rarityData,dataConstraints);
        
        JLabel cost = new JLabel("Cost");
        constraints.gridy = 6;
        view.add(cost, constraints);
        JLabel costData = new JLabel("" + ce.getName());
        dataConstraints.gridy = 6;
        view.add(costData,dataConstraints);
        
        JLabel level = new JLabel("Max Level");
        constraints.gridy = 7;
        view.add(level, constraints);
        JLabel levelData = new JLabel("" + ce.getMaxLVL());
        dataConstraints.gridy = 7;
        view.add(levelData,dataConstraints);
        
        JLabel effects = new JLabel("Effects");
        constraints.gridy = 8;
        view.add(effects, constraints);
        JLabel effectsData = new JLabel(ce.getBuffs());
        dataConstraints.gridy = 8;
        view.add(effectsData,dataConstraints);
        
        JLabel mlbEff = new JLabel("MLB Effects");
        constraints.gridy = 9;
        view.add(mlbEff, constraints);
        JLabel mlbEffData = new JLabel(ce.getMLBBuffs());
        dataConstraints.gridy = 9;
        view.add(mlbEffData,dataConstraints);
        
        JLabel desc = new JLabel("Description");
        constraints.gridy = 10;
        view.add(desc, constraints);
        JLabel descData = new JLabel(ce.getDescription());
        dataConstraints.gridy = 10;
        view.add(descData,dataConstraints);
        
        JLabel full = new JLabel(ce.getFullPicture());
        view.add(full,fullConstraints);
        
        view.pack();
        view.setVisible(true);
    }
    //Overrides the DefaultTableCellRenderer
    private class imageTableCellRenderer extends DefaultTableCellRenderer{
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int colum){
            String imagePath = value.toString();
            ImageIcon icon = new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(99,108,Image.SCALE_DEFAULT));
            return new JLabel(icon);
        }
    }
}
