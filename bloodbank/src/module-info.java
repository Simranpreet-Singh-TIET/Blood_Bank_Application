
module bloodbank 
{
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	requires javafx.base;
//	exports reports;
//	opens reports to javafx.graphics;

	
//	requires javafx.controls;

	requires javafx.media;

	opens loginview to javafx.graphics,javafx.fxml;
	opens application to javafx.graphics,javafx.fxml;
	opens donor to javafx.graphics,javafx.fxml;
	opens bloodunit to javafx.graphics,javafx.fxml;
	opens issueblood to javafx.graphics,javafx.fxml;
}
