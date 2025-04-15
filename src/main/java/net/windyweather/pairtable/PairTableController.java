package net.windyweather.pairtable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Set;

public class PairTableController {
    public TableView<SyncFilesPair> tableView;
    public TableColumn<SyncFilesPair, String> tcName;
    public TableColumn<SyncFilesPair, String> tcStatus;
    @FXML
    private Label lblStatus;

    void SetStatus( String sts ) {
        lblStatus.setText( sts );
    }
    /*
    Define the list that the TableView will watch
 */
    ObservableList<SyncFilesPair> pairObservableList = FXCollections.observableArrayList();

    @FXML

    void initialize() {

        /*
            What are the strings in the following calls for?
            Do they need to match the property names in the SyncFilesPair class?
         */
        tcName.setCellValueFactory( new PropertyValueFactory<SyncFilesPair, String>("sPairName"));
        tcStatus.setCellValueFactory( new PropertyValueFactory<SyncFilesPair, String>("sPairStatus") );
    }


    /*
    Load the list with some pair names/status
 */
    private void SomeTestPairData() {
        pairObservableList.setAll(
                new SyncFilesPair( "1st Pair", "none"),
                new SyncFilesPair( "2nd Pair", "none"),
                new SyncFilesPair( "3rd Pair", "none"),
                new SyncFilesPair( "4th Pair", "none"),
                new SyncFilesPair( "5th Pair", "none"),
                new SyncFilesPair( "6th Pair", "none"),
                new SyncFilesPair( "7th Pair", "none"),
                new SyncFilesPair( "8th Pair", "none"),
                new SyncFilesPair( "9th Pair", "none"),
                new SyncFilesPair( "10th Pair", "none")
        );
    }

        public void OnAddPairs(ActionEvent actionEvent) {
            SomeTestPairData();
            SetStatus("Pairs Added");
    }

    public void OnRemovePairs(ActionEvent actionEvent) {
        pairObservableList.clear();
        SetStatus("Pairs Removed");
    }
}