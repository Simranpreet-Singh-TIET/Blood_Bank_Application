module java2022_june 
{
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;

	
	
	opens application to javafx.graphics, javafx.fxml,javafx.base;
	opens college to javafx.graphics, javafx.fxml,javafx.base;
	opens chkradio to javafx.graphics, javafx.fxml,javafx.base;
	opens mcard to javafx.graphics, javafx.fxml,javafx.base;
	opens listorder to javafx.graphics, javafx.fxml,javafx.base;
	opens combo_list to javafx.graphics, javafx.fxml,javafx.base;
	opens jdbcc to javafx.graphics, javafx.fxml,javafx.base;
	
}
