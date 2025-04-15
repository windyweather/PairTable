module net.windyweather.pairtable {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.windyweather.pairtable to javafx.fxml;
    exports net.windyweather.pairtable;
}