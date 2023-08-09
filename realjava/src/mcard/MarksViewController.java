package mcard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class MarksViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField grd;

    @FXML
    private TextField per;

    @FXML
    private TextField ttl;

    @FXML
    private TextField txtc;

    @FXML
    private TextField txtd;

    @FXML
    private TextField txtj;
    float cpp,java,dsa,percentage=0;
    
    void getValues() 
    {

		String sva = txtc.getText();
		String svb = txtj.getText();
		String svc = txtd.getText();
		// Integer.parseInt(sva);
		cpp = Float.parseFloat(sva);
		java = Float.parseFloat(svb);
		dsa = Float.parseFloat(svc);

	}
    @FXML
    void calcgrade(ActionEvent event) 
    {
    	getValues();
    	
    	String ch;
    	if(percentage>=90)
    	{
    		ch="A";
    	}
    	else if(percentage>=80&&percentage<90)
    	{
    		ch="B";
    	}
    	else
    		ch="C";
    	grd.setText(ch);
    	
    }

    @FXML
    void calcper(ActionEvent event) 
    {
    	getValues();
    	float total=dsa+java+cpp;

		percentage=(total/300)*100;
		per.setText(String.valueOf(percentage));
    }

   
    @FXML
    void doclr(ActionEvent event) 
    {
    	txtj.setText("");
		txtd.setText("");
		txtc.setText("");
		ttl.setText("");
		per.setText("");
		grd.setText("");

    }

    @FXML
    
    void dototal(ActionEvent event) 
    {
    	getValues();
    	
    	float total=cpp+dsa+java;
    		ttl.setText(String.valueOf(total));
    }

    @FXML
    void initialize() 
    {
    }

}
