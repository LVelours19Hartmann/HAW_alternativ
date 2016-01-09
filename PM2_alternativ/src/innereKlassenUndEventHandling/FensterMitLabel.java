package innereKlassenUndEventHandling;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class FensterMitLabel extends Application{

	StackPane root;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		//StackPane 
		root = new StackPane();
		
		Label label = new Label("Hier die Maus bewegen!");
		root.getChildren().add(label);
		label.addEventHandler(MouseEvent.MOUSE_MOVED, new MausBewegungEventHandler());

		primaryStage.setTitle("Fenster mit Label");
		primaryStage.setScene(new Scene(root,200,100));
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
	public class MausBewegungEventHandler implements EventHandler<MouseEvent>{
		@Override
		public void handle(MouseEvent event) {
			System.err.println(event.getSceneX()+", "+event.getSceneY());
		}
	}
	
	//neu
	public class MausKlickEventHandler implements EventHandler<MouseEvent>{
		@Override
		public void handle (MouseEvent event){
			System.err.println("Maustaste geklickt");
		}
	}
}

