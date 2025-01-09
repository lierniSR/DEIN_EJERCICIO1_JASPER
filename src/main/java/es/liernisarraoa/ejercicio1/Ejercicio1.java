package es.liernisarraoa.ejercicio1;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.Connection;
import java.sql.DriverManager;

public class Ejercicio1 extends Application {
    @Override
    public void start(Stage stage) {
        visualizarReporte();
    }

    private void visualizarReporte() {
        try {
            // Ruta del archivo Jasper (compilado)
            String reportPath = "C:\\DM2\\DEIN\\ProyectoFXJasper\\Ejercicio1\\src\\main\\resources\\es\\liernisarraoa\\ejercicio1\\Jasper\\Ejercicio1.jasper";

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
            JasperExportManager.exportReportToPdfFile(jasperPrint, "reporte.pdf");

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}