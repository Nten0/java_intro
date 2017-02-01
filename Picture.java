import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Picture extends JFrame implements ActionListener {
   
           JButton Right= new JButton("Align Right");
           JButton  Center= new JButton("Align Center");
           JButton Left= new JButton("Align Left");
           JButton Resize = new JButton("Resize");
         
           JLabel wid = new JLabel("Width:   ");
           JLabel hei = new JLabel("Height:  ");
           
           JTextField width = new JTextField(10);
           JTextField height = new JTextField(10);
           
           JMenuItem reset = new JMenuItem("Reset");
           JMenu menu = new JMenu("Options");
           JMenuBar menubar = new JMenuBar();
           
           JPanel panel1=new JPanel();
           JPanel pane = new JPanel();
           JPanel pane1 = new JPanel();
           
           ImageIcon image = new ImageIcon("icon_01.jpg");
           Image imag = image.getImage();
           JLabel label = new JLabel(image);    
           
      public Picture() {
           super("Image Application");
         
           setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         
           pane.add(Left);
           pane.add(Center);
           pane.add(Right);
           add(pane);
          
         
           pane1.add(wid);
           pane1.add(width);
           pane1.add(hei);
           pane1.add(height);
           pane1.add(Resize);
           add(pane1);
          
           
         //menu
     
           menu.add(reset);
           menubar.add(menu);
           setJMenuBar(menubar);
          
         
         //diepifaneia 
           BorderLayout bord = new BorderLayout();
           setLayout(bord);
           
           add(pane,BorderLayout.NORTH);
        
           add(pane1, BorderLayout.SOUTH);
         
           add(label,BorderLayout.CENTER);
           GridLayout grid = new GridLayout(3,2);
           pane1.setLayout(grid);
           
      
           height.addActionListener(this);
           width.addActionListener(this);
           Resize.addActionListener(this);
           reset.addActionListener(this);   
           Left.addActionListener(this);
           Center.addActionListener(this);
           Right.addActionListener(this);
           setVisible(true);
      }
        
      public void actionPerformed(ActionEvent evt) {

          Object o = evt.getSource();

          if( o == reset )      { repaint();}
          if( o == Left )        {label.setHorizontalAlignment(JLabel.LEFT);}
          if( o == Right )       {label.setHorizontalAlignment(JLabel.RIGHT);}
          if( o == Center )      {label.setHorizontalAlignment(JLabel.CENTER);}
          if( o == Resize) {
 
              String textw = width.getText();
              String texth = height.getText();
  
              int x = Integer.parseInt(textw);
              int y = Integer.parseInt(texth);
   
              Image temp = imag.getScaledInstance(x,y,0);
              ImageIcon oasis = new ImageIcon(temp);
              label.setIcon(oasis);
          }
          if( o == reset) {
              label.setIcon(image);
          }
      }
      
      public static void main(String[] args ) {
          Picture imge = new Picture();
          imge.pack();
          imge.setSize(600,600);
      }
}