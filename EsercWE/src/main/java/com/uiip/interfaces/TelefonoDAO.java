package com.uiip.interfaces;

import com.uiip.model.TelefonoModel;

public interface TelefonoDAO {
	
	public TelefonoModel getTelefonoInfo(String name);
    public boolean insertTelefono(TelefonoModel telefono);

}
