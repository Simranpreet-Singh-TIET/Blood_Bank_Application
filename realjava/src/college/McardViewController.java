package college;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class McardViewController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtA;

	@FXML
	private TextField txtB;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtResult;

	@FXML
	void doHello(ActionEvent event) {
		String name = txtName.getText();
		txtName.setText("Hello " + name);
		System.out.println("Hello:" + name);

	}

	float fva, fvb;// instance var

	void getValues() {

		String sva = txtA.getText();
		String svb = txtB.getText();
		// Integer.parseInt(sva);
		fva = Float.parseFloat(sva);
		fvb = Float.parseFloat(svb);

	}

	@FXML
	void doMulti(ActionEvent event) {
		getValues();
		float multi = fva * fvb;

		txtResult.setText(String.valueOf(multi));
	}

	@FXML
	void doSaaaf(ActionEvent event) 
	{
			txtA.setText("");
			txtB.setText("");
			txtResult.setText("");
			
	}
	 @FXML
	    void doMinus(ActionEvent event) {
			getValues();
			float minus = fva - fvb;

			txtResult.setText(String.valueOf(minus));

	    }

	@FXML
	void doSum(ActionEvent event) {
		getValues();
		float sum = fva + fvb;

		txtResult.setText(String.valueOf(sum));

	}

	@FXML
	void initialize() {

	}

}
