package shop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class database {
    private Statement stmt;
    private ResultSet rs;
    private Connection conn;
    private boolean loggedIn;
	private ArrayList<String> allpdts;
	private ArrayList<String> pdts;
    public database(String username, String password) throws ClassNotFoundException {
        this.stmt = null;
        this.rs = null;
        this.loggedIn = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school",username,password);
            System.out.println("Connected successfully");
            this.loggedIn = true;
        } catch (SQLException e) {
//          e.printStackTrace();
            System.out.println("Incorrect username and/or password");
        }
    }


    public ArrayList<String> shopproducts() throws SQLException {
		// TODO Auto-generated method stub
		
		this.stmt = this.conn.createStatement();
        this.rs = this.stmt.executeQuery("SELECT * FROM shopproducts;");
        ArrayList<String> pdts = new ArrayList<String>();

        while(rs.next()) {
            System.out.println(rs.getString("id") +":"+ rs.getString("prod_name"));
            pdts.add(rs.getString("prod_name"));
        }
        System.out.println(pdts);
        return pdts;
		
		
	}

    
    
    public ArrayList<String> selectedproduct(String test) throws SQLException {
        this.stmt = this.conn.createStatement();
        this.rs = this.stmt.executeQuery("SELECT * FROM shopproducts;");
        String sql="SELECT * FROM shopproducts where prod_name=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1,(test.toString()));
        
        ResultSet rs=pstmt.executeQuery();
        allpdts = null;
		while(rs.next()) 
		{
            System.out.println(rs.getString("prod_name") + rs.getString("description")+rs.getString("price"));
            allpdts.add(rs.getString("prod_name")+ ""+rs.getString(" description")+""+rs.getString(" price"));

        }
		System.out.println(allpdts);
		return allpdts;    

		
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }




	
	
}

