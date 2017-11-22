/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.dclientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class fprestamo {
    private conexion mysql = new conexion();
    private Connection cn= mysql.conectar();
    private String sSql="";
    private String sSql1="";
    
    public DefaultTableModel mostrar(String buscar)
    {
        DefaultTableModel modelo;
        String [] titulos={"ID","NOMBRE","DNI","CELULAR","TELEFONO","MONTO PRES","INTERES","MORA","TOTAL PRES","FECHA PRES","FECHA PAGO","ESTADO","CS","CP","DISTRITO","DIRECCION"};
        String [] registro = new String[16];
        modelo = new DefaultTableModel(null,titulos);
        sSql="select c.cod_cli,c.nom_cli,c.dni_cli,c.cel_cli,c.tel_cli,p.monto_pres,p.interesSoles_pres,p.mora_pres,p.total_pres,p.fecPrestamo_pres,p.fecPago_pres,e.estado ,c.est_id,p.cod_pres,c.dis_cli,c.dir_cli from estado e inner join cliente c on e.est_id = c.est_id inner join prestamo p on c.cod_cli = p.cod_cli where c.dni_cli like '%"+buscar+"%' order by c.cod_cli desc";
        try 
        {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sSql);
            
            while (rs.next())
            {
                  registro [0]=rs.getString("cod_cli");
                  registro [1]=rs.getString("nom_cli");
                  registro [2]=rs.getString("dni_cli");
                  registro [3]=rs.getString("cel_cli");
                  registro [4]=rs.getString("tel_cli");
                  registro [5]=rs.getString("monto_pres");
                  registro [6]=rs.getString("interesSoles_pres");
                  registro [7]=rs.getString("mora_pres");
                  registro [8]=rs.getString("total_pres");
                  registro [9]=rs.getString("fecPrestamo_pres");
                  registro [10]=rs.getString("fecPago_pres");
                  registro [11]=rs.getString("estado");
                  registro [12] = rs.getString("est_id");
                  registro [13] = rs.getString("cod_pres");
                  registro [14] = rs.getString("dis_cli");
                  registro [15] = rs.getString("dir_cli");
                  
                  
                  
                  modelo.addRow(registro);
                  
            }
            return modelo;  
        } 
        catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }


    
    
    public boolean insertar(dclientes dts)
    {
        
        sSql="insert into cliente (est_id,nom_cli,dni_cli,dis_cli,dir_cli,tel_cli,cel_cli)"+
                "values (?,?,?,?,?,?,?)";
        
        sSql1="insert into prestamo (cod_cli,monto_pres,interesSoles_pres,total_pres,mora_pres,fecPrestamo_pres,fecPago_pres)"+
                "values (?,?,?,?,?,?,?);";

        try {
             PreparedStatement pst= cn.prepareStatement(sSql);
             PreparedStatement pst1=cn.prepareStatement(sSql1);
             
             pst.setInt(1,dts.getEstado());
             pst.setString(2, dts.getNombrecliente());
             pst.setInt(3, dts.getDnicliente());
             pst.setString(4, dts.getDiscliente());
             pst.setString(5, dts.getDircliente());
             pst.setInt(6, dts.getTelcliente());
             pst.setInt(7, dts.getCelcliente());
             
             pst1.setInt(1, dts.getCodigocliente());
             pst1.setDouble(2, dts.getMonto_pres());
             pst1.setInt(3, dts.getInteres());
             pst1.setDouble(4, dts.getTotalpres());
             pst1.setDouble(5, dts.getMora());
             pst1.setDate(6, dts.getFechain());
             pst1.setDate(7, dts.getFechapa());
             
             
             
            int n=pst.executeUpdate();
            int n1=pst1.executeUpdate();
            if(n!=0 & n1!=0)
            {
                return true;
            }
             else
            {
                return false;
            }
             
        } catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean insertarnuevoprestamo(dclientes dts)
    {
        sSql1="insert into prestamo (cod_cli,monto_pres,interesSoles_pres,total_pres,mora_pres,fecPrestamo_pres,fecPago_pres)"+
                "values (?,?,?,?,?,?,?);";
        try {
             
             PreparedStatement pst1=cn.prepareStatement(sSql1);
             
             pst1.setInt(1, dts.getCodigocliente());
             pst1.setDouble(2, dts.getMonto_pres());
             pst1.setInt(3, dts.getInteres());
             pst1.setDouble(4, dts.getTotalpres());
             pst1.setDouble(5, dts.getMora());
             pst1.setDate(6, dts.getFechain());
             pst1.setDate(7, dts.getFechapa());
             
            int n1=pst1.executeUpdate();
            if(n1!=0)
            {
                return true;
            }
             else
            {
                return false;
            }
             
        } catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
    public boolean editarestado(dclientes dts)
    {
        
        sSql="update cliente set est_id=? where cod_cli=?";
        sSql1="update prestamo set total_pres=? where cod_pres=?";

        try {
             PreparedStatement pst= cn.prepareStatement(sSql);
             PreparedStatement pst1= cn.prepareStatement(sSql1);
             pst.setInt(1,dts.getEstado());
             pst.setInt(2,dts.getCodigocliente());
             pst1.setDouble(1, dts.getTotalpres());
             pst1.setInt(2, dts.getCod_pres());
             
            int n=pst.executeUpdate();
            int n1=pst1.executeUpdate();
            if(n!=0 & n1!=0 )
            {
                return true;
            }
             else
            {
                return false;
            }
             
        } catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    
    
}
