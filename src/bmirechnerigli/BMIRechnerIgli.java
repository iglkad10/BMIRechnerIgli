/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmirechnerigli;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

/**
 *
 * @author iglkad10
 */
public class BMIRechnerIgli {

    /**
     * @param args the command line arguments
     * 
     */
    
    private static JPanel pTitle;
    private static JPanel pContentMain, pContentL, pContentR;
    private static JPanel pFooter;

    private static Map<String, ContentsPanel> contents= new HashMap<String, ContentsPanel>();
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        pTitle = new JPanel();
        pContentMain = new JPanel();
        pFooter = new JPanel();
        
        pTitle.setLayout(null);
        pTitle.setSize(600, 150);
        pTitle.setLocation(0, 0);
        pTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        
        pContentMain.setLayout(new GridLayout(0, 1, 0, 0));       
        pContentMain.setSize(600, 300);
        pContentMain.setLocation(0,150);
        
        initContents();        
        JButton jBtnCalculate = new JButton("Calculate");
        jBtnCalculate.setSize(20,100);
        //jBtnCalculate.setLocation(5, 5);
        //JLabel jLGender = addContentLabel("Gender :", pContentL);
        //JLabel jLGender2 = addContentLabel("Gender :", pContentR);
        //pContentMain.add(jBtnCalculate);
        pContentMain.setBorder(BorderFactory.createLineBorder(Color.CYAN, 3));

        pFooter.setLayout(null);
        pFooter.setSize(600, 150);
        pFooter.setLocation(0, 300);
        //pFooter.add(jb3);
        pFooter.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 3));

        frame.add(pTitle);
        frame.add(pContentMain);
        frame.add(pFooter);
        //frame.pack();
        frame.setVisible(true);
    }
    
    static int distance = 15;
    static int incr = 1;
    private static JLabel addContentLabel(String text, JPanel panel){
        JLabel label = new JLabel(text);
        //label.setLocation(10, (int) (pContentMain.getY()+(incr*distance)));
        label.setSize(20,100);
        panel.add(label);
        System.out.println("Label added");
        return label;
    }
    private static JTextField addContentTF(JPanel panel){
        JTextField tf = new JTextField();
        //label.setLocation(10, (int) (pContentMain.getY()+(incr*distance)));
        tf.setColumns(10);
        panel.add(tf);
        System.out.println("JTF added");
        return tf;
    }
    private static JRadioButton addContentjRBtn(String text, JPanel panel){
        JRadioButton jRBtn = new JRadioButton();
        jRBtn.setText(text);
        panel.add(jRBtn);
        return jRBtn;
    }
    private static JComboBox addContentCombo(DefaultComboBoxModel lModel, JPanel panel){
        JComboBox combobox = new JComboBox(lModel);
        panel.add(combobox);
        return combobox;
    }
    private static JPanel initContentP(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        pContentMain.add(panel);
        System.out.println("Paneladded");
        return panel;
    }
    
    private static ButtonGroup bgCh = new ButtonGroup();
    private static ButtonGroup bgGender = new ButtonGroup();
    private static void initContents() {
        JPanel pContentGender = initContentP();
        JLabel pCGLab = addContentLabel("Gender :", pContentGender);
        JRadioButton jBtnMale = addContentjRBtn("Male", pContentGender);
        JRadioButton jBtnFemale = addContentjRBtn("Female", pContentGender);
        bgGender.add(jBtnMale);
        bgGender.add(jBtnFemale);
 
        JPanel pContentChild = initContentP();
        JLabel pCCLab = addContentLabel("Age :", pContentChild);
        JRadioButton jBtnAdult = addContentjRBtn("Adult", pContentChild);
        JRadioButton jBtnChild = addContentjRBtn("Child", pContentChild);
        bgCh.add(jBtnAdult);
        bgCh.add(jBtnChild);


        JPanel pContentHeight = initContentP();
        JLabel pCHLab = addContentLabel("Height :", pContentHeight);
        JTextField pCHTf = addContentTF(pContentHeight);
        //putContents(pCHLab, pCHTf, "Height");
        
        JPanel pContentWidth = initContentP();
        JLabel pCWLab = addContentLabel("Width :", pContentWidth);
        JTextField pCWTf = addContentTF(pContentWidth);

        JPanel pContentNr = initContentP();
        JLabel pCNLab = addContentLabel("Age :", pContentNr);
        DefaultComboBoxModel lModel = new DefaultComboBoxModel();
        for(int i=18;i<=100;i++)
            lModel.addElement(i);
        JComboBox list = addContentCombo(lModel, pContentNr);
        list.setSelectedIndex(0);
        
    }
    private static void putContents(JLabel label, JTextField textfield, String name){
        ContentsPanel cp = new ContentsPanel();
        cp.setLabel(label);
        cp.setTextfield(textfield);
        contents.put(name, cp);
    }
    private static void putContents(JLabel label, JComboBox textfield, String name){
        //In-case of age
        ContentsPanel cp = new ContentsPanel();
        cp.setLabel(label);
        //cp.setTextfield(textfield);
        contents.put(name, cp);
    }
}
class ContentsPanel {
    private JLabel label;
    private String type;
    private JTextField textfield;
    private JComboBox jcombo;

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(JLabel label) {
        this.label = label;
    }

        public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
        public JComboBox getCombo() {
        return jcombo;
    }

    public void setCombo(JComboBox jcombo) {
        this.jcombo = jcombo;
    }

    /**
     * @return the textfield
     */
    public JTextField getTextfield() {
        return textfield;
    }

    /**
     * @param textfield the textfield to set
     */
    public void setTextfield(JTextField textfield) {
        this.textfield = textfield;
    }
}
