package aufgabenblatt4_soloversion;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Klasse die die Tabelle mit den vorhandenen Polygonen darstellt
 */
public class PolygonTabelle {
	private TableView<Polygon> tabelle;
	private PolygonModell polygonModell;

	public PolygonTabelle(TableView<Polygon> tabelle, PolygonModell polygonModell) {
		this.tabelle = tabelle;
		this.polygonModell = polygonModell;
	}

	/**
	 * Methode zum initialisieren der Tabelle
	 */
	public void inititalisiere() {
		tabelle.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		List<Polygon> polygone = new ArrayList<Polygon>(polygonModell.getListePolygone());
		final ObservableList<Polygon> daten = FXCollections.observableArrayList(polygone);
		TableColumn<Polygon, String> polys = new TableColumn<>("Polygone");
		polys.setCellValueFactory(new PropertyValueFactory<>("info"));
		tabelle.setItems(daten);
		tabelle.getColumns().add(polys);
	}

	/**
	 * Methode zu updaten der Tabelle
	 */
	public void refresh() {
		tabelle.getItems().clear();
		List<Polygon> polygone = new ArrayList<Polygon>(polygonModell.getListePolygone());
		final ObservableList<Polygon> daten = FXCollections.observableArrayList(polygone);
		tabelle.setItems(daten);
	}
}
