package chkradio;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class ChkRadViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox chkAll;

    @FXML
    private CheckBox chkCpp;

    @FXML
    private CheckBox chkDsa;

    @FXML
    private CheckBox chkJava;

    @FXML
    private Label lblResult;

    @FXML
    void doCalcFee(ActionEvent event) 
    {
    	
    	float total=0;
    	if(chkCpp.isSelected()==true)
    		total=6800;
    	if(chkJava.isSelected()==true)
    		total+=8500;
    	if(chkDsa.isSelected()==true)
    		total+=7600;
    	
    	lblResult.setText("Total Fee="+total);
    	

    }
    
    
    @FXML
    void doChkUncheckAll(ActionEvent event) 
    {
    	
    	if(chkAll.isSelected())
    	{
    		chkCpp.setSelected(true);
    		chkDsa.setSelected(true);
    		chkJava.setSelected(true);
    	}
    	else
    	{
    		chkCpp.setSelected(false);
    		chkDsa.setSelected(false);
    		chkJava.setSelected(false);
    	}

    }

    @FXML
    void initialize() {
        assert chkAll != null : "fx:id=\"chkAll\" was not injected: check your FXML file 'ChkRadView.fxml'.";
        assert chkCpp != null : "fx:id=\"chkCpp\" was not injected: check your FXML file 'ChkRadView.fxml'.";
        assert chkDsa != null : "fx:id=\"chkDsa\" was not injected: check your FXML file 'ChkRadView.fxml'.";
        assert chkJava != null : "fx:id=\"chkJava\" was not injected: check your FXML file 'ChkRadView.fxml'.";
        assert lblResult != null : "fx:id=\"lblResult\" was not injected: check your FXML file 'ChkRadView.fxml'.";

    }

}
