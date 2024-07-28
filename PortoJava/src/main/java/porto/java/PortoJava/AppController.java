package porto.java.PortoJava;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;

public class AppController implements Initializable {
	@FXML
	private TableView<DataObject> Table;
	@FXML
	private TableColumn<DataObject, String> C1;
	@FXML
	private TableColumn<DataObject, String> C2;
	@FXML
	private TableColumn<DataObject, String> C3;
	@FXML
	private TableColumn<DataObject, String> Delete;
	@FXML
	private TextField C1F;
	@FXML
	private TextField C2F;
	@FXML
	private TextField C3F;
	@FXML
	private Button Update;
	@FXML
	private Button Create;
	
	int SelectedId = -1;

	ObservableList<DataObject> data =
            FXCollections.observableArrayList(
            		new DataObject(0, 1, 2),
            		new DataObject(3, 4, 5),
            		new DataObject(6, 7, 8),
            		new DataObject(9, 10, 11),
            		new DataObject(12, 13, 14),
            		new DataObject(15, 16, 17),
            		new DataObject(18, 19, 20)
            		);
	
	// Event Listener on TableView[#Table].onMouseClicked
	@FXML
	public void Select(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on TableColumn[#C1].onEditCommit
	@FXML
	public void C1D(CellEditEvent event) {
		((DataObject) event.getTableView().getItems().get(
				event.getTablePosition().getRow())
				).setC1(String.valueOf(event.getNewValue()));
	}
	// Event Listener on TableColumn[#C2].onEditCommit
	@FXML
	public void C2D(CellEditEvent event) {
		((DataObject) event.getTableView().getItems().get(
				event.getTablePosition().getRow())
				).setC2(String.valueOf(event.getNewValue()));
	}
	// Event Listener on TableColumn[#C3].onEditCommit
	@FXML
	public void C3D(CellEditEvent event) {
		((DataObject) event.getTableView().getItems().get(
				event.getTablePosition().getRow())
				).setC3(String.valueOf(event.getNewValue()));
	}
		
	// Event Listener on Button[#Update].onAction
	@FXML
	public void OnUpdate(ActionEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#Create].onAction
	@FXML
	public void OnCreate(ActionEvent event) {
		// TODO Autogenerated
		
		if (!C1F.getText().isEmpty()) {
			if (!C2F.getText().isEmpty()) {
				if (!C3F.getText().isEmpty()) {
			        data.add(new DataObject(
			        		Integer.valueOf(C1F.getText()),
			        		Integer.valueOf(C2F.getText()),
			        		Integer.valueOf(C3F.getText())));
			        C1F.clear();
			        C2F.clear();
			        C3F.clear();
				}
			}
		}
	}
	
	// Event Listener on Button[#Delete].onAction
	@FXML
	public void OnDelete(CellEditEvent event) {
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "You sure want to delete ?", ButtonType.YES, ButtonType.CANCEL);
		alert.showAndWait();
		if (alert.getResult() == ButtonType.YES) {
			DataObject rkr = ((DataObject) event.getTableView().getItems().get(
					event.getTablePosition().getRow())
			);
			data = UpdateDel(rkr);
			Table.setItems(data);
		}
	}
	public ObservableList UpdateDel(DataObject vts) {
		ObservableList<DataObject> dets = FXCollections.observableArrayList(data);
		dets.remove(data.indexOf(vts));
		return dets;
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		C1.setCellFactory(TextFieldTableCell.forTableColumn());
		C2.setCellFactory(TextFieldTableCell.forTableColumn());
		C3.setCellFactory(TextFieldTableCell.forTableColumn());
		
		// TODO Auto-generated method stub		
        C1.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("C1"));
        C2.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("C2"));
        C3.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("C3"));
        Delete.setCellValueFactory(
                new PropertyValueFactory<DataObject, String>("Del"));
        
		Table.setItems(data);
	}
	
	public class DataObject {
		int C1;
		int C2;
		int C3;
		String Ids = "";
		String Del = "Delete";
		
		DataObject(int C1, int C2, int C3) {
			this.C1 = C1;
			this.C2 = C2;
			this.C3 = C3;
		}
		
		public String getC1() {
			return String.valueOf(C1);
		}
		public String getC2() {
			return String.valueOf(C2);
		}
		public String getC3() {
			return String.valueOf(C3);
		}
		public String getDel() {
			return Del;
		}

		
		public void setC1(String val) {
			this.C1 = Integer.valueOf(val);
		}
		public void setC2(String val) {
			this.C2 = Integer.valueOf(val);
		}
		public void setC3(String val) {
			this.C3 = Integer.valueOf(val);
		}
	}
}
