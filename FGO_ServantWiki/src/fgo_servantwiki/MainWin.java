package fgo_servantwiki;

import java.util.Vector;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;

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
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
       
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Insets;
import java.awt.event.MouseListener;

public class MainWin extends JFrame {
    private Database database;
    private JTable data;
    private String Version = "1.0";
    private String Magic_Cookie = "☆*: .｡. o(≧▽≦)o .｡.:*☆";
    
    public MainWin(String string){
        super(string);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,200);
        
        setVisible(true);
    }
    //This is a Test Constructor;
    public MainWin(Database database){
        super();
        this.database = database;
        data = new JTable(this.database.getCEs().size(),3);
        
        data.getColumnModel().getColumn(1).setCellRenderer(new imageTableCellRenderer());
        data.setRowHeight(108);
        data.getColumnModel().getColumn(0).setMaxWidth(50);
        data.getColumnModel().getColumn(0).setPreferredWidth(50);
        data.getColumnModel().getColumn(1).setMaxWidth(115);
        data.getColumnModel().getColumn(1).setMinWidth(99);
        data.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){   
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                try{
                    CEview(getDB().getCE(row));
                }catch(Exception error){
                    System.err.println(error.getMessage());
                }
            }
        });
        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,200);
        
        //Creating the MenuBar
        JMenuBar menubar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu ce = new JMenu("CE");
        JMenu help = new JMenu("Help");
        JMenuItem new_ = new JMenuItem("New");
        JMenuItem save_ = new JMenuItem("Save");
        JMenuItem saveAs_ = new JMenuItem("Save As");
        JMenuItem open_ = new JMenuItem("Open");
        JMenuItem quit_ = new JMenuItem("Quit");
        JMenuItem addCE_ = new JMenuItem("Add New CE");
        
        save_.addActionListener(event-> onSaveClick());
        saveAs_.addActionListener(event -> onSaveAsClick());
        open_.addActionListener(event -> onOpenClick());
        quit_.addActionListener(event-> onQuitClick());
        addCE_.addActionListener(event-> onAddCEClick());
        
        menubar.add(file);
        menubar.add(ce);
        menubar.add(help);
        file.add(new_);
        file.add(save_);
        file.add(saveAs_);
        file.add(open_);
        file.add(quit_);
        ce.add(addCE_);
        
        setJMenuBar(menubar);
        
        //Creating ToolBar
        JPanel panel = new JPanel();     
        JToolBar toolbar = new JToolBar("Database Commands");
        
        JButton addCE_button = new JButton("Add new CE");
        addCE_button.addActionListener(event->onAddCEClick());
        
        JButton addServant_button = new JButton("Add new Servant");
        addServant_button.addActionListener(event->onAddServantClick());
        
        panel.add(addCE_button);
        panel.add(addServant_button);
        toolbar.add(panel);
        this.getContentPane().add(toolbar, BorderLayout.NORTH);
       
        //Creating JTable to view list of CEs within the database      
        JScrollPane scrollpane = new JScrollPane(data);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollpane);
        updateDisplay();
       
        setVisible(true);
        
    }
    public void updateDisplay(){
        while(database.getCEs().size() != data.getRowCount()){
            DefaultTableModel model = (DefaultTableModel) data.getModel();
            model.addRow(new Vector(3));
            System.out.println("Added new Row");
        }
        for(int i = 0; i < database.getCEs().size(); i++){
            System.out.println("Loading in CE");
            for(int j = 0; j < 3; j++){
                if(j==0){data.setValueAt(this.database.getCE(i).getID(),i,j);}
                if(j==1){data.setValueAt(this.database.getCE(i).getIcon(),i,j);}
                if(j==2){data.setValueAt(this.database.getCE(i).getName(),i,j);}
            }
        } 
    }
    public void onQuitClick(){
        System.exit(0);
    }
    public void onAddCEClick(){
        JDialog newCE = new JDialog();
        newCE.setTitle("Adding New CE");
        newCE.setSize(500,800);
        
        newCE.setLayout(new GridBagLayout());
        // Widget Constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1;
        constraints.weighty = 0;
        constraints.insets = new Insets(2,5,2,5);
        constraints.fill = GridBagConstraints.BOTH;
        constraints.anchor = GridBagConstraints.LINE_START;
        //Label Constraints
        GridBagConstraints constraintsLabel = (GridBagConstraints) constraints.clone();
        constraintsLabel.weightx = 0;
        // ATT/HP Panel constraints
        GridBagConstraints constraintsPanel = (GridBagConstraints) constraints.clone();
        constraintsPanel.insets = new Insets(0,0,0,0);
        
        //CE Name
        JLabel name = new JLabel("Name");
        constraintsLabel.gridx = 0;
        constraintsLabel.gridy = 0;
        newCE.add(name, constraintsLabel);
        JTextField nameField = new JTextField(30);
        constraints.gridx = 1;
        constraints.gridy = 0;
        newCE.add(nameField, constraints);
        //CE ID
        JLabel id = new JLabel("ID#");
        constraintsLabel.gridy = 1;
        newCE.add(id, constraintsLabel);
        SpinnerModel range = new SpinnerNumberModel(0,null,null, 1);
        JSpinner idField = new JSpinner(range);
        constraints.gridy = 1;
        newCE.add(idField, constraints);
        //CE Illustrator
        JLabel illustrator = new JLabel("Illustrator");
        constraintsLabel.gridy = 2;
        newCE.add(illustrator, constraintsLabel);
        JTextField illustratorField = new JTextField(30);
        constraints.gridy = 2;
        newCE.add(illustratorField, constraints);
        //CE Portrait
        JLabel portrait = new JLabel("Portrait");
        constraintsLabel.gridy = 3;
        newCE.add(portrait, constraintsLabel);
        JTextField portraitField = new JTextField("Click here to choose a file",30);
        constraints.gridy = 3;
        portraitField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                portraitField.setText(fileChoose("PNG", "png"));
            }
        });
       newCE.add(portraitField, constraints);
        //CE Icon
        JLabel icon = new JLabel("Icon");
        constraintsLabel.gridy = 4;
        newCE.add(icon, constraintsLabel);
        JTextField iconField = new JTextField("Click here to choose a file",30);
        constraints.gridy = 4;
        iconField.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                iconField.setText(fileChoose("PNG", "png"));
            }
        });
        newCE.add(iconField, constraints);
        // Min/Max Att
        JLabel att = new JLabel("(Min/Max) Attack");
        constraintsLabel.gridy = 5;
        newCE.add(att, constraintsLabel);
        JSpinner minAtt = new JSpinner(new SpinnerNumberModel(0,0,null, 1));
        constraints.gridy = 5;
        JSpinner maxAtt = new JSpinner(new SpinnerNumberModel(0,0,null, 1));
        JPanel attSelections = new JPanel(new GridBagLayout());
        constraintsPanel.gridx = 0;
        attSelections.add(minAtt, constraintsPanel);
        constraintsPanel.gridx = 1;
        attSelections.add(new JLabel("/"),constraintsPanel);
        constraintsPanel.gridx = 2;
        attSelections.add(maxAtt, constraintsPanel);  
        newCE.add(attSelections, constraints);
        // Min/Max HP
        JLabel hp = new JLabel("(Min/Max) HP");
        constraintsLabel.gridy = 6;
        newCE.add(hp, constraintsLabel);
        JSpinner minHP = new JSpinner(new SpinnerNumberModel(0,0,null, 1));
        constraints.gridy = 6;
        JSpinner maxHP = new JSpinner(new SpinnerNumberModel(0,0,null, 1));
        JPanel hpSelections = new JPanel(new GridBagLayout());
        constraintsPanel.gridx = 0;
        hpSelections.add(minHP, constraintsPanel);
        constraintsPanel.gridx = 1;
        hpSelections.add(new JLabel("/"),constraintsPanel);
        constraintsPanel.gridx = 2;
        hpSelections.add(maxHP, constraintsPanel);  
        newCE.add(hpSelections, constraints);
        // Stars(Rarity)
        JLabel rarity = new JLabel("Rarity");
        constraintsLabel.gridy = 7;
        newCE.add(rarity, constraintsLabel);
        JSpinner rarityField = new JSpinner(new SpinnerNumberModel(1,1,5,1));
        constraints.gridy = 7;
        newCE.add(rarityField, constraints);
        // Cost
        JLabel cost = new JLabel("Cost");
        constraintsLabel.gridy = 8;
        newCE.add(cost, constraintsLabel);
        JSpinner costField = new JSpinner(new SpinnerNumberModel(1,1,12,1));
        constraints.gridy = 8;
        newCE.add(costField, constraints);
        //Effects
        JLabel effect = new JLabel("Effects");
        constraintsLabel.gridy = 9;
        newCE.add(effect, constraintsLabel);
        JTextArea effectsText = new JTextArea();
        constraints.gridy = 9;
        newCE.add(effectsText, constraints);
        //MLB Effects
        JLabel mlbEffect = new JLabel("MLB Effects");
        constraintsLabel.gridy = 10;
        newCE.add(mlbEffect, constraintsLabel);
        JTextArea mlbEffectsText = new JTextArea();
        constraints.gridy = 10;
        newCE.add(mlbEffectsText, constraints);
        //Description
        JLabel description = new JLabel("Description");
        constraintsLabel.gridy = 11;
        newCE.add(description, constraintsLabel);
        JTextArea descriptionText = new JTextArea();
        constraints.gridy = 11;
        newCE.add(descriptionText, constraints);
        
        JPanel okCancel = new JPanel();
        
        JButton ok = new JButton("OK");
        ok.addActionListener(event-> {
            try{
                CE enteredCE = new CE(nameField.getText(),(int) idField.getValue());
                enteredCE.setIllustrator(illustratorField.getText());
                enteredCE.setIcon(iconField.getText());
                enteredCE.setFullPicture(portraitField.getText());
                enteredCE.setMinAtt((int) minAtt.getValue());
                enteredCE.setMaxAtt((int) maxAtt.getValue());
                enteredCE.setMinHP((int) minHP.getValue());
                enteredCE.setMaxHP((int) maxHP.getValue());
                enteredCE.setStars((int) rarityField.getValue());
                enteredCE.setCost((int) costField.getValue());
                if(enteredCE.getStars() == 1) enteredCE.setMaxLVL(50);
                if(enteredCE.getStars() == 2) enteredCE.setMaxLVL(55);
                if(enteredCE.getStars() == 3) enteredCE.setMaxLVL(60);
                if(enteredCE.getStars() == 4) enteredCE.setMaxLVL(80);
                if(enteredCE.getStars() == 5) enteredCE.setMaxLVL(100);
                enteredCE.setBuffs(effectsText.getText());
                enteredCE.setMLBBuffs(mlbEffectsText.getText());
                enteredCE.setDescription(descriptionText.getText());                 
                database.addCE(enteredCE);
                newCE.setVisible(false);
                updateDisplay();
            }catch(Exception e){
                JOptionPane error = new JOptionPane();
                error.showMessageDialog(null,"Error occured", null, JOptionPane.ERROR_MESSAGE);
            }
        });
        okCancel.add(ok);
        JButton cancel = new JButton("CANCEL");
        cancel.addActionListener(event-> newCE.setVisible(false));
        okCancel.add(cancel);
        
        constraints.gridy = 12;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        newCE.add(okCancel, constraints);
        
        newCE.pack();
        newCE.setVisible(true);
    }
    public void onSaveClick(){
        File file = new File(this.database.getFilename());
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(Magic_Cookie + '\n');
            bw.write(Version + '\n');
            database.save(bw);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Unable to open " + file + '\n' + e, "Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void onSaveAsClick(){
        File file = new File(fileChoose("Database", "db"));
        database.setFilename(file.getAbsolutePath());
        if(!file.getAbsolutePath().endsWith(".db")){
				file = new File(file.getAbsolutePath() + ".db");
				database.setFilename(file.getAbsolutePath());
			}
			this.onSaveClick();
    }
    public void onOpenClick(){
        File file = new File(fileChoose("Database", "db"));
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
				String magicCookie = br.readLine();
				String fileVersion = br.readLine();
				if(magicCookie.equals(Magic_Cookie) && fileVersion.equals(Version)){
					database = new Database(br);
					database.setFilename(file.getAbsolutePath());
					this.setTitle("FGO Database - ");
					this.updateDisplay();
				}else{
					System.out.println("Didn't pass magicCookie && fileVersion");
				}
			} catch (Exception e) {
                                System.err.println(e);
				JOptionPane.showMessageDialog(this, "Unable to open " + file + '\n' + e, "Failed", JOptionPane.ERROR_MESSAGE);
			}
    }
    public void onAddServantClick(){
        JDialog newCE = new JDialog();
        newCE.setTitle("Adding New Servant");
        
        newCE.setVisible(true);
    }
    public String fileChoose(String s1, String s2){
        final JFileChooser pc = new JFileChooser();
        FileFilter dbFiles = new FileNameExtensionFilter(s1, s2);
        pc.addChoosableFileFilter(dbFiles);
        pc.setFileFilter(dbFiles);
        int result = pc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
           String portraitPath = pc.getSelectedFile().getPath();
           if(s1.equals("PNG") && s2.equals("png")){
               return portraitPath.substring(portraitPath.indexOf("src\\Pictures\\"));
           }
           return portraitPath;
        }
        return "";
    }
    public void CEview(CE ce){
        System.out.println("Entering CEview");
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
        constraints.insets = new Insets(2,5,2,5); // Insets(top, left, bottom, right)
        constraints.anchor = GridBagConstraints.LINE_START;
        //Constraints for Data
        GridBagConstraints dataConstraints = (GridBagConstraints) constraints.clone();
        dataConstraints.gridx = 1;
        //Constraints for FullPicture
        GridBagConstraints fullConstraints = (GridBagConstraints) constraints.clone();
        fullConstraints.gridx = 2;
        fullConstraints.gridheight = 30;
        
     
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
        JLabel descData = new JLabel();
        descData.setText(ce.getDescription());
        dataConstraints.gridy = 10;
        view.add(descData,dataConstraints);
        
        JLabel full = new JLabel(ce.getFullPicture());
        view.add(full,fullConstraints);
        
        view.pack();
        view.setVisible(true);
    }
    //Getters
    public Database getDB(){
        return database;
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
