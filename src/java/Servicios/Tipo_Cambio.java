/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;
import WS_Banco.TipoCambio;
import WS_Banco.TipoCambioSoap;
import WS_Banco.InfoVariable;
import WS_Banco.ArrayOfVarDolar;
import WS_Banco.VarDolar;
import java.util.List;
/**
 *
 * @author Diego Gramajo
 */
public class Tipo_Cambio {
    TipoCambio ws = new TipoCambio();
    TipoCambioSoap ws_serv = ws.getTipoCambioSoap();
    InfoVariable val = ws_serv.tipoCambioDia();
    ArrayOfVarDolar camb = val.getCambioDolar();
    public float Cambio(){
       float dolar = 0;
       List<VarDolar> CamDolar = camb.getVarDolar();
       for(VarDolar v:CamDolar){
           dolar = v.getReferencia();
       }
       return dolar;
    }
}
