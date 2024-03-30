import java.awt.Font;

public class Function_Format {
    GUI gui;
    Font arial,comicSansMC,timeMenuFont;
    String selectString;
    public Function_Format(GUI gui){
        this.gui=gui;
    }
    public void wordWraper(){
        if(gui.wordWraperOn==false){
gui.wordWraperOn=true;
gui.textArea.setLineWrap(true);
gui.textArea.setWrapStyleWord(true);
gui.IWrap.setText("Word Wrap On");
       }
       else if(gui.wordWraperOn==true){
        gui.wordWraperOn=false;
gui.textArea.setLineWrap(false);
gui.textArea.setWrapStyleWord(false);
gui.IWrap.setText("Word Wrap Off");
       }
    }
    public void createFont(int fontSize){
        arial=new Font("arial",Font.PLAIN,fontSize); 
        comicSansMC=new Font("comicSansMC",Font.PLAIN,fontSize);
        timeMenuFont=new Font("timeNewRoman",Font.PLAIN,fontSize);
    setFont(selectString);
    }
    public void setFont(String Font){
       selectString=Font;
       switch (selectString) {
        case "arial":
            gui.textArea.setFont(arial);
            break;
        case"comicSansMC":
           gui.textArea.setFont(comicSansMC);
           break;
        case"timeNewRoman":
           gui.textArea.setFont(timeMenuFont);
           break;
       
        
       }
    }
}
