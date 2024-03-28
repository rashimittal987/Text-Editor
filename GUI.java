import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.util.*;

//import org.w3c.dom.Text;

public class GUI implements ActionListener{
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenuBar menuBar;
    JMenu menuFile,menuEdit,menuFormat,menuColor;
    JMenuItem INew,IOpen,ISave,ISaveAs,IExit;
    JMenuItem EUndo,ERedo;
    JMenuItem IWrap,IFontArial,IFontCSMS,IFontTMS,IFontLine,IFontSize8,IFontSize16,IFontSize12,IFontSize22,IFontSize24,IFontSize30;
    JMenu menuFront,menuFrontSize;
    Function_File file=new Function_File(this);
    Function_Format format=new Function_Format(this);
    public GUI(){
        createIndex();
        createTextArea();
        createMenuBar();
        createfileMenu();
        createEditMenu();
        window.setVisible(true);
    }
    public void createIndex(){
        window=new JFrame("Notepad");
        window.setSize(300,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void createTextArea(){
        textArea=new JTextArea();
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
        EUndo=new JMenuItem("Undo");
        menuEdit.add(EUndo);
        ERedo=new JMenuItem("Redo");
        menuEdit.add(ERedo);
        
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
       IFontSize8.setActionCommand("8");

        
        IFontSize8.addActionListener(this);
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
              
        }
    }

    public static void main(String[] args) {
    new GUI();
}
    
}