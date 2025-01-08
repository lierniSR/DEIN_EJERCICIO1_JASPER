module es.liernisarraoa.ejercicio1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.liernisarraoa.ejercicio1 to javafx.fxml;
    exports es.liernisarraoa.ejercicio1;
}