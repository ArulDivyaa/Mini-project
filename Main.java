package shop;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main {
	 
	
   public static void main(String[] args) 
    {
	   java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            buildGUI();
        }
    });
}
public static void buildGUI() {

    	
        // TODO Auto-generated method stub
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel pane = new JPanel (new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        JLabel l1 = new JLabel("username: ");
        c.gridx = 0;
        c.gridy = 0;
        pane.add(l1,c);

        JLabel l2= new JLabel("password: ");
        c.gridx = 0;
        c.gridy = 1;
        pane.add(l2,c);

        JTextField f1 = new JTextField(10);       
        c.gridx = 1;
        c.gridy = 0;
        pane.add(f1,c);

        JPasswordField f2 = new JPasswordField(10);
        c.gridx = 1;
        c.gridy = 1;
        pane.add(f2,c);

        JButton login = new JButton("login");
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String username = 	f1.getText();
            	String password = String.valueOf(f2.getPassword());
            	System.out.println(username);
            	System.out.println(password);
            	if (username.equals("arul") && password.equals("1234")) 
            	{ 
            		
            		NextPage page = new NextPage(username);
            		
            		page.getFrame().setVisible(true);
//            		JFrame frame1 = new JFrame();
// 
//                    frame1.setBounds(100, 100, 450, 300);
//                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//                    JLabel lblNewLabel = new JLabel("Welcome: ");
//                    frame1.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
//            		
            		} else 
            		{
            		// show error message
            		System.out.println("Please enter valid username and password");
            		}
            	}
        };
        
        login.addActionListener(al);
        c.gridx = 1;
        c.gridy = 10;
     
      c.fill = GridBagConstraints.HORIZONTAL;
      pane.add(login,c);

      JButton clear = new JButton("Clear");
      ActionListener al_clear = new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          
             f1.setText("");
             f2.setText("");

          }
      };
      clear.addActionListener(al_clear);
      c.gridx = 0;
      c.gridy = 10;
      //c.gridwidth = 3;
      c.fill = GridBagConstraints.HORIZONTAL;
      pane.add(clear,c);
      frame.add(pane);
      frame.pack();
      login.addActionListener(al);
      frame.setVisible(true);
        }
} 		
                






