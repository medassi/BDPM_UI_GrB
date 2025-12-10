package com.medassi.bdpm_ui_grb;

import java.io.Serializable;

public class Medicament implements Serializable{
    public String code_cis ;
    public String denomination ;
    public String forme ;
    public String voies_admin ;
    public String statut_admin_amm ;
    public String type_auth_amm ;
    public String etat_comm ;
    public String date_amm ;
    public String statut_bdm ;
    public String numero_auth ;
    public String titulaires ;
    public String surveillance_renforcee ;

    @Override
    public String toString() {
        return denomination + "("+code_cis+")"; 
    }

    
            
}
