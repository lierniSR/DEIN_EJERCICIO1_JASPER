module es.liernisarraoa.ejercicio1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires org.mariadb.jdbc;
    requires slf4j.api;


    opens es.liernisarraoa.ejercicio1 to javafx.fxml;
    exports es.liernisarraoa.ejercicio1;
}