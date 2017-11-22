/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class dclientes {
    private int _codigocliente;
    private int _estado;
    private String _nombrecliente;
    private int _dnicliente;
    private String _discliente;
    private String _dircliente;
    private int _telcliente;
    private int _celcliente;
    
    private int _cod_pres;
    private double _monto_pres;
    private int _interes;
    private double _totalpres;
    private int _mora;
    private Date  _fechain;
    private Date _fechapa; 

    public dclientes() {
    }

    public dclientes(int _codigocliente, int _estado, String _nombrecliente, int _dnicliente, String _discliente, String _dircliente, int _telcliente, int _celcliente, int _cod_pres, double _monto_pres, int _interes, double _totalpres, int _mora, Date _fechain, Date _fechapa) {
        this._codigocliente = _codigocliente;
        this._estado = _estado;
        this._nombrecliente = _nombrecliente;
        this._dnicliente = _dnicliente;
        this._discliente = _discliente;
        this._dircliente = _dircliente;
        this._telcliente = _telcliente;
        this._celcliente = _celcliente;
        this._cod_pres = _cod_pres;
        this._monto_pres = _monto_pres;
        this._interes = _interes;
        this._totalpres = _totalpres;
        this._mora = _mora;
        this._fechain = _fechain;
        this._fechapa = _fechapa;
    }

    public int getCodigocliente() {
        return _codigocliente;
    }

    public void setCodigocliente(int _codigocliente) {
        this._codigocliente = _codigocliente;
    }

    public int getEstado() {
        return _estado;
    }

    public void setEstado(int _estado) {
        this._estado = _estado;
    }

    public String getNombrecliente() {
        return _nombrecliente;
    }

    public void setNombrecliente(String _nombrecliente) {
        this._nombrecliente = _nombrecliente;
    }

    public int getDnicliente() {
        return _dnicliente;
    }

    public void setDnicliente(int _dnicliente) {
        this._dnicliente = _dnicliente;
    }

    public String getDiscliente() {
        return _discliente;
    }

    public void setDiscliente(String _discliente) {
        this._discliente = _discliente;
    }

    public String getDircliente() {
        return _dircliente;
    }

    public void setDircliente(String _dircliente) {
        this._dircliente = _dircliente;
    }

    public int getTelcliente() {
        return _telcliente;
    }

    public void setTelcliente(int _telcliente) {
        this._telcliente = _telcliente;
    }

    public int getCelcliente() {
        return _celcliente;
    }

    public void setCelcliente(int _celcliente) {
        this._celcliente = _celcliente;
    }

    public int getCod_pres() {
        return _cod_pres;
    }

    public void setCod_pres(int _cod_pres) {
        this._cod_pres = _cod_pres;
    }

    public double getMonto_pres() {
        return _monto_pres;
    }

    public void setMonto_pres(double _monto_pres) {
        this._monto_pres = _monto_pres;
    }

    public int getInteres() {
        return _interes;
    }

    public void setInteres(int _interes) {
        this._interes = _interes;
    }

    public double getTotalpres() {
        return _totalpres;
    }

    public void setTotalpres(double _totalpres) {
        this._totalpres = _totalpres;
    }

    public int getMora() {
        return _mora;
    }

    public void setMora(int _mora) {
        this._mora = _mora;
    }

    public Date getFechain() {
        return _fechain;
    }

    public void setFechain(Date _fechain) {
        this._fechain = _fechain;
    }

    public Date getFechapa() {
        return _fechapa;
    }

    public void setFechapa(Date _fechapa) {
        this._fechapa = _fechapa;
    }

    





    
    
    
}
