/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Pruebas;

import GUI.PantallaInicioSesion;
import GUI.PantallaMenu;
import Persistencia.ILicenciaDAO;
import Persistencia.IPersonaDAO;
import Persistencia.LicenciaDAO;
import Persistencia.PersonaDAO;

/**
 *
 * @author Marcos Toledo 00000234963
 */
public class ProyectoAgenciaTransito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IPersonaDAO personaDAO = new PersonaDAO();
        ILicenciaDAO licenciaDAO = new LicenciaDAO();
        PantallaMenu frmMenu = new PantallaMenu(personaDAO, licenciaDAO);
        frmMenu.setVisible(true);
    }

}
