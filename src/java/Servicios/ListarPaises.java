/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import Services.ArrayOftCountryCodeAndName;
import Services.TCountryCodeAndName;
import Services.CountryInfoServiceSoapType;
import Services.CountryInfoService;
import java.util.List;


public class ListarPaises {
    CountryInfoService ws_serv = new CountryInfoService();
    CountryInfoServiceSoapType ws = ws_serv.getCountryInfoServiceSoap();
    ArrayOftCountryCodeAndName list = ws.listOfCountryNamesByCode();
    
    public List<TCountryCodeAndName> ListaP(){
        List<TCountryCodeAndName> Pais = list.getTCountryCodeAndName();
        return Pais;
    }
}
