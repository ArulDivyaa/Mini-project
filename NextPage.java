
package shop;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class NextPage {
	
	

	JPanel pane = new JPanel (new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
	
    
    private JFrame frame;
    private String username;

    public NextPage(String username) {
        database db = null;
        try {
            db = new database("root", "1234");
            this.username = username;
            initialize(db);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(database db) {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lblNewLabel = new JLabel("Welcome: " + this.username);
        frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        JButton device = new JButton("Available devices");
        ActionListener al_device = new ActionListener() {
        //device.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	ArrayList<String> products = db.shopproducts();
                  //  ArrayList<String> products = db.selectAllBooks();
                    String[] productlist = new String[products.size()];
                    for(int i = 0; i < products.size(); i++) {
                        productlist[i] = products.get(i);
                    }
                    JList<String> List = new JList<String>(productlist);
                    frame.getContentPane().add(List, BorderLayout.EAST);
                    
                    List.addListSelectionListener((ListSelectionListener) new ListSelectionListener() 
                    {
                    	public void valueChanged(ListSelectionEvent arg0)
                    	{
                    		String test=List.getSelectedValue();
                            System.out.println(test);
                            try {
                            	
                            	
								ArrayList<String> products1 = db.selectedproduct(test);
								pdtpage(products1);
								 
							} catch (SQLException e) 
                            {
								e.printStackTrace();
							}
                
                    	}

						private void pdtpage( ArrayList<String> products1) {
							// TODO Auto-generated method stub
							
							//JList<String> List1 = new JList<String>(products1);
		                   // frame.getContentPane().add(List1, BorderLayout.SOUTH);
							
						}     	
                    });

                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        };
        device.addActionListener(al_device);
        c.gridx = 0;
        c.gridy = 10;
        
        c.fill = GridBagConstraints.HORIZONTAL;
        pane.add(device,c);
        
       
        frame.add(pane);
        frame.pack();
        device.addActionListener(al_device);
        frame.setVisible(true);
       // frame.getContentPane().add(device, BorderLayout.NORTH);

    }

}
