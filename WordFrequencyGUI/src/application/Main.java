package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Main extends Application implements EventHandler<ActionEvent> {

	Stage window;
	Scene scene1, scene2;
	Counter raven = new Counter();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		window = primaryStage;
		Label label1 = new Label("The Raven's most used Words!");
		label1.setFont(Font.font("Helvetica", FontWeight.BOLD, 15));
		Button b1 = new Button("Generate List");
		b1.setOnAction(e -> window.setScene(scene2));

		// Layout 1 - children are laid out in vertical column
		VBox lay1 = new VBox(15);
		lay1.setAlignment(Pos.CENTER);
		lay1.getChildren().addAll(label1, b1);
		scene1 = new Scene(lay1, 325, 200);

		// Button 2
		List<Entry<String, Integer>> result = raven
				.getPoemWordFrequency("https://www.gutenberg.org/files/1065/1065-h/1065-h.htm");

		Text w = new Text(result.toString());
		w.setFont(Font.font("Helvetica", 15));
		w.setWrappingWidth(200);
		Button b2 = new Button("Restart");
		b2.setOnAction(e -> window.setScene(scene1));

		// Layout 2
		VBox lay2 = new VBox(20);
		lay2.setAlignment(Pos.CENTER);
		lay2.getChildren().addAll(w, b2);
		scene2 = new Scene(lay2, 350, 250);

		window.setScene(scene1);
		window.setTitle("The Raven's Word Frequency");
		window.show();

	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}
}
