package com.medassi.bdpm_ui_grb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BDPM {

    private static BDPM baseMariadb = null;
    private Statement statement;

    private BDPM(String adresse, String nomBase, String login, String mdp) {
        try {
            String chaineConnexion = "jdbc:mariadb://" + adresse + "/" + nomBase;
            Connection connection
                    = DriverManager.getConnection(chaineConnexion, login, mdp);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BDPM.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static BDPM getDatabase() {
        if (baseMariadb == null) {
            baseMariadb = new BDPM("192.168.153.10:3306", "simple_bdpm", "sio", "sio");
        }

        return baseMariadb;
    }

    public ArrayList<Medicament> getMedicamentsSurvRenf() {
        ArrayList<Medicament> ms = new ArrayList<>();
        try {
            ResultSet rs;
            rs = statement.executeQuery("Select * from medicaments where surveillance_renforcee='Oui'");
            while (rs.next()) {
                Medicament m = new Medicament();
                m.code_cis = rs.getString("code_cis");
                m.denomination = rs.getString("denomination");
                m.forme = rs.getString("forme");
                m.voies_admin = rs.getString("voies_admin");
                m.statut_admin_amm = rs.getString("statut_admin_amm");
                m.type_auth_amm = rs.getString("type_auth_amm");
                m.etat_comm = rs.getString("etat_comm");
                m.date_amm = rs.getString("date_amm");
                m.statut_bdm = rs.getString("statut_bdm");
                m.numero_auth = rs.getString("numero_auth");
                m.titulaires = rs.getString("titulaires");
                m.surveillance_renforcee = rs.getString("surveillance_renforcee");
                ms.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDPM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ms;
    }

    ObservableList<Composant> getCompositionByMedicament(Medicament m) {
        ObservableList<Composant> ms = FXCollections.observableArrayList();
        try {
            ResultSet rs;
            //String sql = "Select * from compositions where code_cis=\""+m.code_cis+"\"";
            String sql = "Select * from compositions where code_cis='" + m.code_cis + "'";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Composant c = new Composant();
                c.code_cis = rs.getString("code_cis");
                c.denomination_sub = rs.getString("denomination_sub");
                c.dosage = rs.getString("dosage");
                ms.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDPM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ms;
    }

    ObservableList<Medicament> getMedicamentsByMotClef(String commeJeVeux) {
        ObservableList<Medicament> ms = FXCollections.observableArrayList();
        try {
            ResultSet rs;
            String sql = "SELECT * FROM medicaments where denomination like \"%" + commeJeVeux + "%\"";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Medicament m = new Medicament();
                m.code_cis = rs.getString("code_cis");
                m.denomination = rs.getString("denomination");
                m.forme = rs.getString("forme");
                m.voies_admin = rs.getString("voies_admin");
                m.statut_admin_amm = rs.getString("statut_admin_amm");
                m.type_auth_amm = rs.getString("type_auth_amm");
                m.etat_comm = rs.getString("etat_comm");
                m.date_amm = rs.getString("date_amm");
                m.statut_bdm = rs.getString("statut_bdm");
                m.numero_auth = rs.getString("numero_auth");
                m.titulaires = rs.getString("titulaires");
                m.surveillance_renforcee = rs.getString("surveillance_renforcee");
                ms.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDPM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ms;
    }

    Medicament getMedicamentByCodeCIS(String leCodeCis) {
        Medicament m = null;
        String sql = "select * from medicaments where code_cis='" + leCodeCis + "'";
        try {
            ResultSet rs;
            rs = statement.executeQuery(sql);
            if (rs.next()) {
                m = new Medicament();
                m.code_cis = rs.getString("code_cis");
                m.denomination = rs.getString("denomination");
                m.forme = rs.getString("forme");
                m.voies_admin = rs.getString("voies_admin");
                m.statut_admin_amm = rs.getString("statut_admin_amm");
                m.type_auth_amm = rs.getString("type_auth_amm");
                m.etat_comm = rs.getString("etat_comm");
                m.date_amm = rs.getString("date_amm");
                m.statut_bdm = rs.getString("statut_bdm");
                m.numero_auth = rs.getString("numero_auth");
                m.titulaires = rs.getString("titulaires");
                m.surveillance_renforcee = rs.getString("surveillance_renforcee");
            }
        } catch (SQLException ex) {
            System.getLogger(BDPM.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return m;
    }

    ArrayList<Medicament> getMedicamentsByLabo(String commeJeVeux) {
        ArrayList<Medicament> ms = new ArrayList<>();
        try {
            ResultSet rs;
            String sql = "SELECT * FROM medicaments where titulaires like \"%" + commeJeVeux + "%\"";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                Medicament m = new Medicament();
                m.code_cis = rs.getString("code_cis");
                m.denomination = rs.getString("denomination");
                m.forme = rs.getString("forme");
                m.voies_admin = rs.getString("voies_admin");
                m.statut_admin_amm = rs.getString("statut_admin_amm");
                m.type_auth_amm = rs.getString("type_auth_amm");
                m.etat_comm = rs.getString("etat_comm");
                m.date_amm = rs.getString("date_amm");
                m.statut_bdm = rs.getString("statut_bdm");
                m.numero_auth = rs.getString("numero_auth");
                m.titulaires = rs.getString("titulaires");
                m.surveillance_renforcee = rs.getString("surveillance_renforcee");
                ms.add(m);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BDPM.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ms;
    }

}
