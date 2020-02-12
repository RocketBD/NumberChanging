package window;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import util.Constant;
import util.Util;

public class MainController {

	@FXML TextField bin;
	@FXML TextField oct;
	@FXML TextField dec;
	@FXML TextField hex;
	
	@SuppressWarnings("unused")
	private Main application;
	    
	    
	public void setApp(Main application){
		this.application = application;
	}
	
	@FXML private void initialize() {
		bin.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				char check = arg0.getCharacter().charAt(0);
				if(!(check=='0'||check=='1')) {
					arg0.consume();
				}
			}
		});
		oct.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				char check = arg0.getCharacter().charAt(0);
				if(!(check>='0'&&check<='7')) {
					arg0.consume();
				}
			}
		});
		dec.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				char check = arg0.getCharacter().charAt(0);
				if(!Util.charCheckO(check)) {
					arg0.consume();
				}
			}
		});
		hex.setOnKeyTyped(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				char check = arg0.getCharacter().charAt(0);
				if(!Util.charCheckH(check)) {
					arg0.consume();
				}
			}
		});
	}
	


	@FXML public void modifyTextFieldHEX() {
		Integer value = Util.numberToDEC(hex.getText(), Constant.jz16);
		bin.setText(Util.setBIN(value));
		dec.setText(value.toString());
		oct.setText(Util.setOCT(value));
	}

	@FXML public void modifyTextFieldBIN() {
		Integer value = Util.numberToDEC(bin.getText(), Constant.jz2);
		dec.setText(value.toString());
		oct.setText(Util.setOCT(value));
		hex.setText(Util.setHEX(value));
	}

	@FXML public void modifyTextFieldOCT() {
		Integer value = Util.numberToDEC(oct.getText(), Constant.jz8);
		bin.setText(Util.setBIN(value));
		dec.setText(value.toString());
		hex.setText(Util.setHEX(value));
	}

	@FXML public void modifyTextFieldDEC() {
		Integer value = Util.numberToDEC(dec.getText(), Constant.jz10);
		bin.setText(Util.setBIN(value));
		oct.setText(Util.setOCT(value));
		hex.setText(Util.setHEX(value));
	}
	
}
