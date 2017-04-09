package com.uiip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import com.uiip.controllers.UtenteController;
import com.uiip.interfaces.TelefonoDAO;
import com.uiip.interfaces.UtenteDAO;
import com.uiip.interfaces.impl.DefaultTelefonoDAO;
import com.uiip.interfaces.impl.DefaultUtenteDAO;
import com.uiip.model.TelefonoModel;
import com.uiip.model.UtenteModel;
import com.uiip.views.UtenteView;

public class App{
	public static void main(String[] args) {
		try {
	        int scelta;
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, Charset.defaultCharset()));
	        UtenteModel utenteModel = null;
	        TelefonoModel telefonoModel = null;
	        String nome, cognome, indirizzo, telefono, email, modello, size, marca;
			int weight;
	        UtenteView utenteView = new UtenteView(utenteModel);
	        UtenteController utenteController = new UtenteController(utenteModel, utenteView);
	        do {
	            System.out.println("MENU");
	            System.out.println("1.Inserisci utente e il modello del suo telefono");
	            System.out.println("2.Inserisci telefono");
	            System.out.println("3.Visualizza utente");
	            System.out.println("4.Aggiorna indirizzo dell'utente");
	            System.out.println("5.Cancella utente");
	            System.out.println("0.Esci");
	            scelta = parseNumber(in);
	            switch (scelta) {
	                case 1:
	                    nome =insert(in, "nome utente");
	                    cognome = insert(in, "cognome utente");
	                    indirizzo = insert(in, "indirizzo");
	                    email = insert(in, "email utente");
	                    telefono = insert(in, "numero di telefono");
	                    utenteModel = new UtenteModel();
	                    utenteModel.setNome(nome);
	                    utenteModel.setCognome(cognome);;
	                    utenteModel.setIndirizzo(indirizzo);;
	                    utenteModel.setEmail(email);
	                    utenteModel.setTelefono(telefono);;
	                    modello = insert(in, "Modello del telefono");
	                    telefonoModel = getTelefonoFromDB(modello);
	                    if (telefonoModel != null) {
	                        utenteModel.setTelefonoModel(telefonoModel);;
	                        if (insertUtente(utenteModel, modello)) {
	                            System.out.println("L'utente è stato inserito");
	                        } else {
	                            System.out.println("L'utente non è stato inserito");
	                        }
	                    } else {
	                        System.out.println("Il telefono non è presente.");
	                        System.out.println("Non puoi aggiungere un telefono non presente ad un utente");
	                    }
	                    break;
	                case 2:
	                    modello = insert(in, "modello del cellulare");
	                    size = insert(in, "grandezza del cellulare");
	                    weight = Integer.parseInt(insert(in, "peso del cellulare"));
	                    marca = insert(in, "marca del cellulare");
	                    telefonoModel = new TelefonoModel();
	                    telefonoModel.setModello(modello);
	                    telefonoModel.setSize(size);
	                    telefonoModel.setWeight(weight);
	                    telefonoModel.setMarca(marca);
	                    if (insertTelefono(telefonoModel)) {
	                        System.out.println("Telefono inserito");
	                    } else {
	                        System.out.println("Telefono non inserito");
	                    }
	                    break;
	                case 3:
	                    telefono = insert(in, "numero di telefono");
	                    utenteModel = getUtenteFromDB(telefono);
	                    if (utenteModel != null) {
	                        utenteController.setUtenteModel(utenteModel);
	                        utenteController.updateView(utenteModel);
	                        utenteView.printInfo();
	                    } else {
	                        System.out.println("Numero di telefono non presente in rubrica");
	                    }
	                    break;
	                case 4:
	                    telefono = insert(in, "numero di telefono");
	                    indirizzo = insert(in, "indirizzo");
	                    if (updateUser(telefono, indirizzo)) {
	                        utenteModel = getUtenteFromDB(telefono);
	                        utenteController.setUtenteModel(utenteModel);
	                        utenteController.updateView(utenteModel);
	                        System.out.println("Utente aggiornato:");
	                        utenteView.printInfo();
	                    } else {
	                        System.out.println("Numero di telefono non presente in rubrica");
	                    }
	                    break;
	                case 5:
	                    telefono = insert(in, "numero di telefono");
	                    if (deleteUtenteFromDB(telefono)) {
	                        System.out.println("Utente cancellato correttamente");
	                    } else {
	                        System.out.println("Numero di telefono non presente in rubrica");
	                    }
	                    break;
	                case 0:
	                    System.out.println("Bye bye");
	                    break;
	                default:
	                    System.out.println("Scelta errata!");
	                    break;
	            }
	        } while (scelta != 0);
	    } catch (IOException ex) {
	    }
	}

	private static boolean updateUser(String utenteModel, String data) {
	    UtenteDAO utenteDAO = new DefaultUtenteDAO();
	    return utenteDAO.updateUtenteInfo(utenteModel, data);
	}
	
	private static UtenteModel getUtenteFromDB(String numeroTelefono) {
	    UtenteDAO utenteDAO = new DefaultUtenteDAO();
	    return utenteDAO.getUtenteInfo(numeroTelefono);
	}

	private static TelefonoModel getTelefonoFromDB(String modello) {
	    TelefonoDAO telefonoDAO = new DefaultTelefonoDAO();
	    return telefonoDAO.getTelefonoInfo(modello);
	}

	private static boolean insertTelefono(TelefonoModel telefonoModel) {
	    TelefonoDAO telefonoDAO = new DefaultTelefonoDAO();
	    return telefonoDAO.insertTelefono(telefonoModel);
	}

	private static boolean deleteUtenteFromDB(String numeroTelefono) {
	    UtenteDAO utenteDAO = new DefaultUtenteDAO();
	    return utenteDAO.deleteUtente(numeroTelefono);
	}

	private static boolean insertUtente(UtenteModel utenteModel, String modello) {
	    UtenteDAO utenteDAO = new DefaultUtenteDAO();
	    return utenteDAO.insertUtente(utenteModel, modello);
	}
	
	private static int parseNumber(BufferedReader in) throws IOException{
		int toReturn = 0;
        boolean flag;
        do {
            try {
                toReturn = Integer.parseInt(in.readLine());
                if (toReturn >= 0) {
                    flag = false;
                } else {
                    flag = true;
                    System.out.println("Inserisci un numero positivo!");
                }
            } catch (NumberFormatException ex) {
                flag = true;
                System.out.println("Inserisici un numero positivo!");
            }
        } while (flag);
        return toReturn;
	}
	
	public static String insert(BufferedReader in, String whatInsert) throws IOException {
        String toReturn;
        boolean flag;
        do {
            System.out.print("Inserisci " + whatInsert + ": ");
            toReturn = in.readLine();
            flag = "".equals(toReturn);
            if (flag) {
                System.out.println("Inserisci " + whatInsert + "!");
            }
        } while (flag);
        return toReturn;
    }
}
