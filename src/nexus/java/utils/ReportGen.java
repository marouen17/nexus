/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nexus.java.utils;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import nexus.java.connection.Cnx;

/**
 *
 * @author VOSTRO
 */
public class ReportGen {

    public ReportGen(String titre,String ressource) {

        try {
            // - Connexion Ã  la base
            Connection connection = Cnx.getInstance().getConnection();
            // - Chargement et compilation du rapport
            JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Documents\\NetBeansProjects\\S.O.S Animaux\\src\\nexus\\java\\utils\\Declaration.jrxml");
            // - ParamÃ¨tres Ã  envoyer au rapport
            Map parameters = new HashMap();
            parameters.put("Titre", titre);
            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            // - CrÃ©ation du rapport au format PDF
            String fileName = "C:\\" + titre + "-" + new Date() + ".pdf";
            JasperExportManager.exportReportToPdfFile(jasperPrint, fileName);
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("rundll32 url.dll,FileProtocolHandler " + fileName );

        } catch (JRException | IOException e) {
            System.out.println("erreur" + e.getMessage());
        }
    }

}
