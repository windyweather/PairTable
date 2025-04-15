package net.windyweather.pairtable;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.Set;

public class PairTableController {
    public TableView<SyncFilesPair> tableView;
    public TableColumn<SyncFilesPair, String> tcName;
    public TableColumn<SyncFilesPair, String> tcStatus;
    @FXML
    private Label lblStatus;

    //
    // Do this in one place so we can easily turn it off later
    //
    public static void printSysOut( String str ) {
        System.out.println(str);
    }

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
        //tcName.setCellValueFactory( new PropertyValueFactory<SyncFilesPair, String>("sPairName"));
        //tcStatus.setCellValueFactory( new PropertyValueFactory<SyncFilesPair, String>("sPairStatus") );


        printSysOut("Set up CellValueFactories for Columns");

        tcName.setCellValueFactory( new Callback<TableColumn.CellDataFeatures<SyncFilesPair, String>, ObservableValue<String>>() {
            public ObservableValue<String> call( TableColumn.CellDataFeatures<SyncFilesPair,
                                String> p) {
                printSysOut("tcName CellValueFactory called");
                return p.getValue().sPairNameProperty();
            }
        });

        tcStatus.setCellValueFactory( new Callback<TableColumn.CellDataFeatures<SyncFilesPair, String>, ObservableValue<String>>() {
            public ObservableValue<String> call( TableColumn.CellDataFeatures<SyncFilesPair,
                    String> p) {
                printSysOut("tcStatus CellValueFactory called");
                return p.getValue().sPairStatusProperty();
            }
        });

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
            printSysOut("OnAddPairs - add some pairs");
            SomeTestPairData();
            SetStatus("Pairs Added");
    }

    public void OnRemovePairs(ActionEvent actionEvent) {
        printSysOut("OnRemovePairs - remove all the pairs");
        pairObservableList.clear();
        SetStatus("Pairs Removed");
    }
}