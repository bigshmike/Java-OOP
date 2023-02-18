package application;

import java.util.Random;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SampleController {
	private int randomNumb1;
	private int randomNumb2;
	private int randomNumb3;
	private int randomNumb4;
	private Random rand = new Random();
	private String filePath = "file:/Users/Michael/eclipse-workspace/MP3_mbrown99_randomCards/img/";
	
	@FXML
	private ImageView card1;
	
	@FXML
	private ImageView card2;
	
	@FXML
	private ImageView card3;
	
	@FXML
	private ImageView card4;
	
	@FXML
	private Button exitButton;
	
	public void initialize() {
		randomNumb1 = rand.nextInt(54)+1;
		randomNumb2 = rand.nextInt(54)+1;
		randomNumb3 = rand.nextInt(54)+1;
		randomNumb4 = rand.nextInt(54)+1;
	}
	
	public void onImgClicked(MouseEvent e) {
		if(e.getSource().equals(card1)) {
			card1.setImage(new Image(filePath + randomNumb1 + ".png"));
		}
		else if(e.getSource().equals(card2)) {
			card2.setImage(new Image(filePath + randomNumb2 + ".png"));
		}
		else if(e.getSource().equals(card3)) {
			card3.setImage(new Image(filePath + randomNumb3 + ".png"));
		}
		else if(e.getSource().equals(card4)) {
			card4.setImage(new Image(filePath + randomNumb4 + ".png"));
		}
	}
	
	public void onButtonClicked() {
		randomNumb1 = rand.nextInt(54)+1;
		randomNumb2 = rand.nextInt(54)+1;
		randomNumb3 = rand.nextInt(54)+1;
		randomNumb4 = rand.nextInt(54)+1;
		card1.setImage(new Image(filePath + "backCard.png"));
		card2.setImage(new Image(filePath + "backCard.png"));
		card3.setImage(new Image(filePath + "backCard.png"));
		card4.setImage(new Image(filePath + "backCard.png"));
	}
	
	public void quitProgram() {
		exitButton.setOnMouseClicked((MouseEvent e) -> {
			Platform.exit();
		});
	}
}
