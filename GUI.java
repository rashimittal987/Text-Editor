import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.util.*;

//import org.w3c.dom.Text;

public class GUI implements ActionListener{
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWraperOn=false;
    JMenuBar menuBar;
    JMenu menuFile,menuEdit,menuFormat,menuColor;
    JMenuItem INew,IOpen,ISave,ISaveAs,IExit;
    JMenuItem IWrap,IFontArial,IFontCSMS,IFontTMS,IFontLine,IFontSize8,IFontSize16,IFontSize12,IFontSize22,IFontSize24,IFontSize30,IFontSize32;
    JMenu menuFront,menuFrontSize;
    JMenuItem IColor1,IColor2,IColor3;
    JMenuItem IRedo,IUndo;
    Function_File file=new Function_File(this);
    Function_Format format=new Function_Format(this);
    Function_Color color=new Function_Color(this);
    Function_Edit edit=new Function_Edit(this);
    KeyHandler khandler=new KeyHandler(this);
    UndoManager um=new UndoManager();
    public GUI(){
        createIndex();
        createTextArea();
        createMenuBar();
        createfileMenu();
        createEditMenu();
        createColorMenu();
        format.selectString="arial";
        format.createFont(24);
        format.wordWraper();
        color.changeColor("White");
        window.setVisible(true);
        
    }
    public void createIndex(){
        window=new JFrame("Notepad");
        window.setSize(300,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void createTextArea(){
        textArea=new JTextArea();
        textArea.setFont(format.arial);
        textArea.addKeyListener(khandler);
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            public void undoubleEditHappened(UndoableEditListener e){
                um.addEdit(e.getEdit());
            }
        });
        scrollPane=new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
        //window.add(textArea);
    }
    public void createMenuBar(){
        menuBar=new JMenuBar();
        window.setJMenuBar(menuBar);
        menuFile=new JMenu("File");
        menuBar.add(menuFile);
        menuEdit=new JMenu("Edit");
        menuBar.add(menuEdit);
        menuFormat=new JMenu("Format");
        menuBar.add(menuFormat);
        menuColor=new JMenu("Color");
        menuBar.add(menuColor);
    }
    public void createfileMenu(){
        INew=new JMenuItem("New");
        INew.addActionListener(this);
        INew.setActionCommand("New");
        menuFile.add(INew);
        IOpen=new JMenuItem("Open");
        IOpen.addActionListener(this);
        IOpen.setActionCommand("Open");
        menuFile.add(IOpen);
        
        ISave=new JMenuItem("Save");
        ISave.addActionListener(this);
        ISave.setActionCommand("Save");
        menuFile.add(ISave);
        ISaveAs=new JMenuItem("SaveAs");
        ISaveAs.addActionListener(this);
        ISaveAs.setActionCommand("SaveAs");
        menuFile.add(ISaveAs);
        IExit=new JMenuItem("Exit");
        IExit.addActionListener(this);
        IExit.setActionCommand("Exit");
        menuFile.add(IExit);
    }
    public void createEditMenu(){
        IUndo=new JMenuItem("Undo");
       
        IUndo.addActionListener(this);
        IUndo.setActionCommand("Undo");
        menuFormat.add(IUndo);
        IRedo=new JMenuItem("Redo");
        IRedo.addActionListener(this);
        IRedo.setActionCommand("Redo");
        menuFormat.add(IRedo);
        
    }
    
    public void createFormatMenu(){
        IWrap=new JMenuItem("Word Wrap: Off");
        IWrap.addActionListener(this);
        IWrap.setActionCommand("Word Wrap");
        menuFormat.add(IWrap);
        menuFront=new JMenu("Font");
        menuFormat.add(menuFront);
        IFontArial=new JMenuItem("Arial");
        IFontArial.addActionListener(this);
        IFontArial.setActionCommand("Arial");
        menuFront.add(IFontArial);
        IFontCSMS=new JMenuItem("Comic Sans MS");
        IFontCSMS.addActionListener(this);
        IFontCSMS.setActionCommand("Comic Sans MS");
        menuFront.add(IFontCSMS);
        IFontTMS=new JMenuItem("Times New York");
        IFontTMS.addActionListener(this);
        IFontTMS.setActionCommand("Times New York");
        menuFront.add(IFontTMS);
        menuFrontSize=new JMenu("Font-Size");
        menuFormat.add(menuFrontSize);
        IFontSize8=new JMenuItem("8");
       // IFontSize8=new JMenuItem("8");
       IFontSize8.addActionListener(this);
       IFontSize8.setActionCommand("size8");
       IFontSize16=new JMenuItem("16");
       // IFontSize8=new JMenuItem("8");
       IFontSize16.addActionListener(this);
       IFontSize16.setActionCommand("size16");
       IFontSize12=new JMenuItem("12");
       // IFontSize8=new JMenuItem("8");
       IFontSize12.addActionListener(this);
       IFontSize12.setActionCommand("size12");
       IFontSize22=new JMenuItem("22");
       // IFontSize8=new JMenuItem("8");
       IFontSize22.addActionListener(this);
       IFontSize22.setActionCommand("size22");
       IFontSize24=new JMenuItem("24");
       // IFontSize8=new JMenuItem("8");
       IFontSize24.addActionListener(this);
       IFontSize24.setActionCommand("size24");
       IFontSize30=new JMenuItem("30");
       // IFontSize8=new JMenuItem("8");
       IFontSize30.addActionListener(this);
       IFontSize30.setActionCommand("size30");
       IFontSize32=new JMenuItem("32");
       // IFontSize8=new JMenuItem("8");
       IFontSize32.addActionListener(this);
       IFontSize32.setActionCommand("size32");

        
        IFontSize8.addActionListener(this);
    }

    public void createColorMenu(){
        IColor1=new JMenuItem("White");
        IColor1.addActionListener(this);
        IColor1.setActionCommand("White");
        menuColor.add(IColor1);
        IColor2=new JMenuItem("Black");
        IColor2.addActionListener(this);
        IColor2.setActionCommand("Black");
        menuColor.add(IColor2);
        IColor3=new JMenuItem("Blue");
        IColor3.addActionListener(this);
        IColor3.setActionCommand("Blue");
        menuColor.add(IColor3);
    }
    
    @Override
    public void ActionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        switch (command) {
            case "New":
            file.newFile();
            break;
            case "Open":
            file.open();
            break;
            case "Save":
            file.save();
            break;  
            case "SaveAs":
            file.saveAs();
            break;  
            case "Exit":
            file.exit();
            break;
            case"Undo":
            edit.undo();
            break;
            case"Redo":
            edit.redo();
            break;
            case "Word Wrap":
            format.wordWraper();
            break;
            case "size8":
            format.createFont(8);
            break;
            case "size16":
            format.createFont(16);
            break;
            case "size12":
            format.createFont(12);
            break;
            case "size24":
            format.createFont(24);
            break;
            case "size30":
            format.createFont(30);
            break;
            case "size32":
            format.createFont(32);
            break;  
            case"arial":
            format.setFont(command);
            break;
            case"Comic Sans MS":
            format.setFont(command);
            break;
            case"Times New York":
            format.setFont(command);
            break;
            case"White":
            color.changeColor(command);
            break;
            case"Black":
            color.changeColor(command);
            break;
            case"Blue":
            color.changeColor(command);
            break;
        }
    }

    public static void main(String[] args) {
    new GUI();
}
    
}