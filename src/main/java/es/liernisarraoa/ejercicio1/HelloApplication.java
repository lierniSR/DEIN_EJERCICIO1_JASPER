package es.liernisarraoa.ejercicio1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        visualizarReporte();
    }

    private void visualizarReporte() {
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = String.valueOf(HelloApplication.class.getResource("Ejercicio1.jasper"));

            // Cargar el archivo Jasper
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(reportPath);

            // Configurar conexión a la base de datos
            String dbUrl = "jdbc:mariadb://localhost:3306/paises";
            String dbUser  = "root";
            String dbPassword = "WinRar3009*.";

            Connection connection = DriverManager.getConnection(dbUrl, dbUser , dbPassword);

            // Llenar el informe con datos
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, connection);

            // Mostrar el informe
            JasperViewer.viewReport(jasperPrint, false);

            // Exportar a PDF (opcional)
            JasperExportManager.exportReportToPdfFile(jasperPrint, "report.pdf");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}