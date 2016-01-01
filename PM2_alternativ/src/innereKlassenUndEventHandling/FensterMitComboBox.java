package innereKlassenUndEventHandling;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FensterMitComboBox extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		ObservableList<String> eintraege = FXCollections.observableArrayList("Jan","Hein","Klas");
		ComboBox<String> auswahlBox = new ComboBox<String>(eintraege);
		auswahlBox.setValue(eintraege.get(0));
		
		//mit Lambda
		auswahlBox.setOnAction(ereignis->System.out.println(auswahlBox.getValue()));
		
		//Mit anonymer innerer Klasse
		auswahlBox.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println(auswahlBox.getValue());
			}
		});
		
		primaryStage.setTitle("Fenster mit Knopf");
		StackPane root = new StackPane();
		root.getChildren().add(auswahlBox);
		primaryStage.setScene(new Scene(root,100,100));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
