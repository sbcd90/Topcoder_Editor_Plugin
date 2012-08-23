/**
 *
 * @author sbcd90
 */
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
public class mytcplugin {
    private JPanel myPanel;
    private JTextArea myEditor;
    private String className;
    private String methodName;
    private List<String> parmTypes;
    private String rcType;
    private int flag;
    public mytcplugin(){
        myEditor=new JTextArea();
        myEditor.setForeground(Color.blue);
        myEditor.setBackground(Color.white);
        myPanel=new JPanel(new BorderLayout());
        myPanel.add(new JScrollPane(myEditor),BorderLayout.CENTER);
    }
    public JPanel getEditorPanel(){
        flag=0;
        return myPanel;
    }
    public String getSource(){
        if(flag==0){
            myEditor.append("#include<iostream>\n#include<vector>\n#include<string>\n#include<cstdio>\n#include<cstring>\n#include<cmath>\n#include<algorithm>\nusing namespace std;\n");
            myEditor.append("class "+className+"{\npublic:\n\t"+rcType+" "+methodName+"(");
            int f=0;
            Iterator it=parmTypes.iterator();
            while(it.hasNext()){
                String value=(String)it.next();
                if(f!=0){
                    myEditor.append(","+value);
                    f++;
                }
                else{
                    myEditor.append(value);
                    f++;
                }
            }
            myEditor.setCaretPosition(myEditor.getDocument().getLength());
            myEditor.setCaretColor(Color.red);
            myEditor.append("){\n\n\t}\n};");
            flag++;
        }  
        return myEditor.getText();
    }
    public void setSource(String source){
        myEditor.setText(source);
    }
    public void setSignature(String classN,String methodN,List<String> parmT,String rcT){
        className=classN;
        methodName=methodN;
        parmTypes=parmT;
        rcType=rcT;
    }
}