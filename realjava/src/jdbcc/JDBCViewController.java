package jdbcc;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class JDBCViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboRoll;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtPer;

    Connection con;
    PreparedStatement pst;
    
    
    /*
      void doSave()	
	{
    	LocalDate local=datepicker.getValue();
		try {
				pst=con.prepareStatement("insert into datetimepicker values(?)");
				java.sql.Date date=java.sql.Date.valueOf(local);
				pst.setDate(1, date);
				pst.executeUpdate();
				lblResult.setText("Saved in Table");
			} 
		catch (SQLException e) 
		{	// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     */
    @FXML
    void doDelete(ActionEvent event) 
    {
    	try {
			pst=con.prepareStatement("delete from studs2022 where roll=?");
			pst.setInt(1, Integer.parseInt(comboRoll.getEditor().getText()));
			int count=pst.executeUpdate();
			if(count==0)
				showMsg("Invalid Rollno");
			else
			showMsg("Deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    ResultSet table;
    @FXML
    void doShowAll(ActionEvent event) 
    {
    	try {
    	pst=con.prepareStatement("select * from studs2022");
    	table=pst.executeQuery();
    	while(table.next())
    	{
    		int roll=table.getInt("roll");//col wala name
    		float per=table.getFloat("per");
    		String name=table.getString("name");
    		String doj=table.getString("doj");
    		    		
    		System.out.println(roll+"  "+per+"  "+name+"  "+doj);
    	}
    	}
    	catch(Exception exp)
    	{ 		
    	}
    }
    
   //aaj
    boolean chkRoll(int rollno)
    {
    	boolean jasoos=false;
    	try {
        	pst=con.prepareStatement("select * from studs2022 where roll=?");
        	pst.setInt(1, rollno);
        	
        	table=pst.executeQuery();
        	      	
        	
        	while(table.next())
        	{
        		jasoos=true;
        	}
        	}
        	catch(Exception exp)
        	{ 		
        	}
    	return jasoos;
    }
    
    
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Title");
    	alert.setContentText(msg);
    	alert.show();
    }
    @FXML
    void doSave(ActionEvent event) 
    {
    	int rollno=Integer.parseInt(comboRoll.getEditor().getText());
    	if(chkRoll(rollno)==true)
    		{
    		showMsg("Roll no already Occupied...");
    		return;
    		}
    		
    	//                                                   In parameters
    	try {
			pst=con.prepareStatement("insert into studs2022 values(?,?,?,current_date())");
			pst.setInt(1, Integer.parseInt(comboRoll.getEditor().getText()));
			pst.setString(2, txtName.getText());
			pst.setFloat(3, Float.parseFloat(txtPer.getText()));
			pst.executeUpdate();
			showMsg("Record Inserted Successfullyyyy");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //aaj
    boolean findRecord(int rollno)
    {
    	boolean jasoos=false;
    	try {
        	pst=con.prepareStatement("select * from studs2022 where roll=?");
        	pst.setInt(1, rollno);
        	
        	table=pst.executeQuery();
        	      	
        	
        	while(table.next())
        	{
        		jasoos=true;
        		txtName.setText(table.getString("name"));
        		txtPer.setText(String.valueOf(table.getFloat("per")));
        		
        	}
        	}
        	catch(Exception exp)
        	{ 		
        	}
    	return jasoos;
    }
    //aaj
    @FXML
    void doSearch(ActionEvent event) 
    {
    	String str=comboRoll.getEditor().getText();
    	int rollno=Integer.parseInt(str);
    	if(findRecord(rollno)==false)
    			showMsg("Invalid rollno");
    		
    		
    }

    @FXML
    void doUpdate(ActionEvent event) 
    {
    	try {
			pst=con.prepareStatement("update studs2022 set name=?,per=? where roll=?");
			pst.setInt(3, Integer.parseInt(comboRoll.getEditor().getText()));
			pst.setString(1, txtName.getText());
			pst.setFloat(2, Float.parseFloat(txtPer.getText()));
			
			int count=pst.executeUpdate();
			if(count==0)
				showMsg("Inavlid Rollno");
			else
				
			showMsg("Record Inserted Successfullyyyy");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    //aaj
    void getroll()
    {
    	ArrayList<String> rolls=new ArrayList<String>();
    	try {
        	pst=con.prepareStatement("select distinct roll from studs2022");
        	table=pst.executeQuery();
        	while(table.next())
        	{
        		int roll=table.getInt("roll");//col wala name
        		rolls.add(String.valueOf(roll));
        	}
        	comboRoll.getItems().addAll(rolls);
        	}
        	catch(Exception exp)
        	{ 		
        	}
    }
    @FXML
    void initialize() {
        
    	 con=	DatabaseConnection.doConnect();
    	 getroll();
    }

}
