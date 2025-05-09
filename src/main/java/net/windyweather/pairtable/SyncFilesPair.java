package net.windyweather.pairtable;

/*
    The Pair stores all the information about the source and destination folder tree paths
     and the options that control copying files between the folder trees.
 */

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SyncFilesPair {

    public SimpleStringProperty sPairName;
    public SimpleStringProperty sPairStatus;
    public SimpleStringProperty sFilePathOne;
    public SimpleStringProperty sFilePathTwo;
    public SimpleStringProperty sExcludeFileTypes;
    public SimpleBooleanProperty bSubfolders;
    public SimpleBooleanProperty bVerifyCopied;
    public SimpleBooleanProperty bVerifyNotCopied;
    public SimpleBooleanProperty bRecoverVerifyFailure;
    public SimpleBooleanProperty bOverrideReadOnly;


    public SyncFilesPair() {

    }

    public SyncFilesPair( String sName, String sStatus ){

        sPairName = new SimpleStringProperty( sName );
        sPairStatus = new SimpleStringProperty( sStatus );
    }

    public SyncFilesPair( String sName ) {
        sPairName = new SimpleStringProperty( sName );
    }

    public StringProperty sPairNameProperty() { return sPairName; }
    public StringProperty sPairStatusProperty() {return sPairStatus; }
}
