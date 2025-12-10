package com.medassi.bdpm_ui_grb;

class Composant {
    String code_cis ;
    String denomination_sub ;
    String dosage ;

    @Override
    public String toString() {
        return denomination_sub + "("+dosage+")"; 
    }
    
}
