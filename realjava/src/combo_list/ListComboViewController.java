package combo_list;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
//import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class ListComboViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private ComboBox<String> comboItems;
    @FXML
    private URL location;

    @FXML
    private ToggleGroup discount;

    @FXML
    private RadioButton rad10;

    @FXML
    private RadioButton rad20;
    
    
    @FXML
    private ListView<String> listItems;
    
    @FXML
    void doListDblClicked(MouseEvent event) 
    {
    	int indx;
    		if(event.getClickCount()==2)
    		{
    			 indx=listItems.getSelectionModel().getSelectedIndex();
    			listItems.getItems().remove(indx);
    
    		}
    }

    @FXML
    void doListRemoveAll(ActionEvent event) {
    		listItems.getItems().clear();
    }

    @FXML
    void doListRemoveAllSelected(ActionEvent event) 
    {
    	ObservableList<String>selItems= listItems.getSelectionModel().getSelectedItems();
    	listItems.getItems().removeAll(selItems);
    }

    @FXML
    void doListShowAllSelected(ActionEvent event) 
    {
    		String all="";
    	ObservableList<String>selItems=	listItems.getSelectionModel().getSelectedItems();
    	for (String s : selItems)
    	{
				all=all+s+",";
		}
    	showMsg(all);
    }
    

    @FXML
    void doCheckDiscount(ActionEvent event) 
    {
    	if(rad10.isSelected())
    		showMsg("10% Discount");
    	else
    		if(rad20.isSelected())
        		showMsg("20% Discount");
        	
    	
    		

    }
    void showMsg(String msg)
    {
    	Alert alert=new Alert(AlertType.ERROR);
    	alert.setTitle("Title");
    	alert.setContentText(msg);
    	alert.show();
    }

    @FXML
    void doShowSelectedButton(ActionEvent event) 
    {
    	String item= comboItems.getSelectionModel().getSelectedItem();
    	int index=comboItems.getSelectionModel().getSelectedIndex();
    	showMsg(item+"   "+index);
    }

    @FXML
    void doShowSelectedCombo(ActionEvent event) 
    {
    	String item= comboItems.getSelectionModel().getSelectedItem();
    	int index=comboItems.getSelectionModel().getSelectedIndex();
    	showMsg(item+"   "+index);
    }

    @FXML
    void initialize() 
    {
    	ArrayList<String> items=new ArrayList<String>(Arrays.asList("Select","Pen","Books","Copy","Laptop"));
    	comboItems.getItems().setAll(items);
    	listItems.getItems().setAll(items);
    	listItems.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    	
    	
    }

}
