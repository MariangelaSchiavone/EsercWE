package com.uiip.interfaces;

import com.uiip.model.UtenteModel;

public interface UtenteDAO {
	
	public UtenteModel getUtenteInfo(String numTel);
    public boolean updateUtenteInfo(String numTel, String indirizzo);
    public boolean insertUtente(UtenteModel utenteModel, String modello);
    public boolean deleteUtente(String numTel);
	
}
