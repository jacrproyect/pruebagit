/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prestancion;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import datos.dclientes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.time.Instant;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.conexion;
import logica.fprestamo;

/**
 *
 * @author HP
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     */
    
    private String sSql="";
    private conexion mysql = new conexion();
    private Connection cn= mysql.conectar();
    int prestamo,num1,num2,resultado,tinteres,total,tpmora,mora,tpcm;
    public frmPrincipal() {
        initComponents();
        txtestado.setVisible(false);
        txtestado.setText("1");
        deshabilitar();
        txtcodpres.setVisible(false);
        txtcodpres.setText("");
    }
     private String accion="guardar";
     
     

     
    void calcular()
    {
        prestamo = Integer.parseInt(txtprestamo.getText());
        num1 = Integer.parseInt(txtprestamo.getText());
        num2 = Integer.parseInt(txtinteres.getText());
        resultado = num1*num2/100;
        
        txttinteres.setText(String.valueOf(resultado));
        
        tinteres = Integer.parseInt(txttinteres.getText());
        
        total = prestamo+tinteres;
        
        txttotal.setText(String.valueOf(total));
  
    }
    void limpiar()
    {
        txtcelular.setText("");
        txtcodigo.setText("");
        txtdireccion.setText("");
        txtdistrito.setText("");
        txtdni.setText("");
        txtestado.setText("");
        txtinteres.setText("");
        txtmora.setText("");
        txtnombre.setText("");
        txtprestamo.setText("");
        txttelefono.setText("");
        txttinteres.setText("");
        txttotal.setText("");
        txtcodpres.setText("");
        date1.setDate(null);
        date2.setDate(null);
    }
    void deshabilitar()
    {
        txtcelular.setEnabled(false);
        txtcodigo.setEnabled(false);
        txtdistrito.setEnabled(false);
        txtdireccion.setEnabled(false);
        txtestado.setEnabled(false);
        txtinteres.setEnabled(false);
        txtmora.setEnabled(false);
        txtnombre.setEnabled(false);
        txttelefono.setEnabled(false);
        txtprestamo.setEnabled(false);
        txttinteres.setEnabled(false);
        txttotal.setEnabled(false);
        btnagregar.setEnabled(false);
        btncal.setEnabled(false);
        btnguardar.setEnabled(false);
        cmbxestado.setEnabled(false);
        date1.setEnabled(false);
        date2.setEnabled(false);
    }
    void habilitar()
    {
        txtcelular.setEnabled(true);
        txtcodigo.setEnabled(true);
        txtdistrito.setEnabled(true);
        txtdireccion.setEnabled(true);
        txtestado.setEnabled(true);
        txtinteres.setEnabled(true);
        txtmora.setEnabled(true);
        txtnombre.setEnabled(true);
        txttelefono.setEnabled(true);
        txtprestamo.setEnabled(true);
        txttinteres.setEnabled(true);
        txttotal.setEnabled(true);
        btnagregar.setEnabled(false);
        btncal.setEnabled(true);
        btnguardar.setEnabled(true);
        cmbxestado.setEnabled(false);
        date1.setEnabled(true);
        date2.setEnabled(true);
        btnbuscar.setEnabled(false);
        btnnuevo.setEnabled(false);
    }
    void btnagregar()
    {
        txtprestamo.setEnabled(true);
        txtinteres.setEnabled(true);
        txttinteres.setEnabled(true);
        txttotal.setEnabled(true);
        btncal.setEnabled(true);
        date1.setEnabled(true);
        date2.setEnabled(true);
        txtmora.setEnabled(true);
        btnagregar.setEnabled(true);
        btnguardar.setEnabled(false);
        btnnuevo.setEnabled(false);
        cmbxestado.setEnabled(false);
        btnagregar.setEnabled(false);  
    }
    void btnmas()
    {
        txtprestamo.setText("");
        txtinteres.setText("");
        txtmora.setText("");
        txttinteres.setText("");
        txttotal.setText("");
        date1.setDate(null);
        date2.setDate(null);
        btnguardar.setEnabled(false);
        cmbxestado.setEnabled(true);
        btnnuevo.setEnabled(false);
        btnagregar.setEnabled(true);
        
    }
            
    void numero()
    {
        String c="";
        sSql ="SELECT MAX(cod_cli+1) AS cod_cli FROM cliente";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs= st.executeQuery(sSql);
            if (rs.next())
            {
                c=rs.getString("cod_cli");
                txtcodigo.setText(c);
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, c);
        }
    }
            
    
    
   
    
    void mostrar(String buscar)
    {
        try {
            DefaultTableModel modelo;
            fprestamo fun=new fprestamo();
            modelo =fun.mostrar(buscar);
            tblistado.setModel(modelo);
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtdistrito = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtdireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtcelular = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        txtestado = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtprestamo = new javax.swing.JTextField();
        txtinteres = new javax.swing.JTextField();
        txttinteres = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        date1 = new com.toedter.calendar.JDateChooser();
        date2 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtmora = new javax.swing.JTextField();
        btnnuevo = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        cmbxestado = new javax.swing.JComboBox<>();
        btncal = new javax.swing.JToggleButton();
        btmas = new javax.swing.JButton();
        txtcodpres = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblistado = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        jPanel1.setBackground(new java.awt.Color(31, 111, 67));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Datos Personales ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CODIGO :");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRES");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DISTRITO");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("DIRECCION");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CELULAR");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("TEL.FIJO");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DNI");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtdireccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtdistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnbuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txttelefono))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtcelular))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(36, 36, 36)
                            .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtdistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(31, 111, 67));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Prestamo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Comic Sans MS", 2, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Prestamo S/.");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Interes %");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total Interes S/.");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total S/.");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Día Prestamo");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Día Pago");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Monto Mora S/.");

        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnagregar.setText("AGREGAR");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        cmbxestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));
        cmbxestado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbxestadoMouseClicked(evt);
            }
        });
        cmbxestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbxestadoActionPerformed(evt);
            }
        });

        btncal.setText("cal");
        btncal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncalActionPerformed(evt);
            }
        });

        btmas.setText("+");
        btmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(date1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(date2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtcodpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtmora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtprestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtinteres, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttinteres, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnnuevo)
                .addGap(19, 19, 19)
                .addComponent(btnagregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnguardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btmas))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(txtprestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtinteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttinteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncal))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtcodpres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(date2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(date1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnnuevo)
                    .addComponent(btnagregar)
                    .addComponent(btnguardar)
                    .addComponent(cmbxestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btmas))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(31, 111, 67));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lista ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        tblistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblistadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblistado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1170, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
        );

        jButton2.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(60, 60, 60)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        
        mostrar(txtdni.getText());
        deshabilitar();
        limpiar();
        
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        
        dclientes dts = new dclientes();
        fprestamo fp  = new fprestamo();

        //dts.setEstado(Integer.parseInt(txtestado.getText()));
        int seleccionado = cmbxestado.getSelectedIndex();
        dts.setEstado(Integer.parseInt(cmbxestado.getItemAt(seleccionado)));
        
        dts.setNombrecliente(txtnombre.getText());
        dts.setDnicliente(Integer.parseInt(txtdni.getText()));
        dts.setDiscliente(txtdistrito.getText());
        dts.setDircliente(txtdireccion.getText());
        dts.setTelcliente(Integer.parseInt(txttelefono.getText()));
        dts.setCelcliente(Integer.parseInt(txtcelular.getText()));
        dts.setCodigocliente(Integer.parseInt(txtcodigo.getText()));
        dts.setMonto_pres(Double.parseDouble(txtprestamo.getText()));
        dts.setInteres(Integer.parseInt(txttinteres.getText()));
        dts.setTotalpres(Double.parseDouble(txttotal.getText()));
        dts.setMora(Integer.parseInt(txtmora.getText()));
        Calendar cal;
        int d,m,a;
        cal=date1.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setFechain(new Date(a,m,d));
        cal=date2.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setFechapa(new Date(a,m,d));
        
                
        
        
        if (accion.equals("guardar")) 
        {
            if (fp.insertar(dts))
            {
                JOptionPane.showMessageDialog(rootPane, "se registro :V ");
                mostrar("");
                limpiar();
            }
            
        }else if(accion.equals("editar"))
        {
            dts.setCodigocliente(Integer.parseInt(txtcodigo.getText()));
            dts.setCod_pres(Integer.parseInt(txtcodpres.getText()));
            if (fp.editarestado(dts)) 
            {
                JOptionPane.showMessageDialog(rootPane, "se edito :V ");
                mostrar("");
                limpiar();
                btnnuevo.setEnabled(true);
                btnagregar.setEnabled(false);
                btnguardar.setEnabled(false);
                cmbxestado.setEnabled(false);
                
            }
        }
            
      
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        numero();
        habilitar();
        btnguardar.setText("Guardar");
        accion="guardar";
        
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        
        dclientes dts = new dclientes();
        fprestamo fp  = new fprestamo();

        int seleccionado = cmbxestado.getSelectedIndex();
        dts.setEstado(Integer.parseInt(cmbxestado.getItemAt(seleccionado)));
        dts.setCodigocliente(Integer.parseInt(txtcodigo.getText()));
        dts.setMonto_pres(Double.parseDouble(txtprestamo.getText()));
        dts.setInteres(Integer.parseInt(txttinteres.getText()));
        dts.setTotalpres(Double.parseDouble(txttotal.getText()));
        dts.setMora(Integer.parseInt(txtmora.getText()));
        Calendar cal;
        int d,m,a;
        cal=date1.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setFechain(new Date(a,m,d));
        cal=date2.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        dts.setFechapa(new Date(a,m,d));
        
        fp.insertarnuevoprestamo(dts);
        mostrar("");
        btnnuevo.setEnabled(true);

    }//GEN-LAST:event_btnagregarActionPerformed

    private void btncalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncalActionPerformed
        // TODO add your handling code here:
         calcular();
    }//GEN-LAST:event_btncalActionPerformed

    private void tblistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblistadoMouseClicked
        // TODO add your handling code here:
        btnguardar.setText("Editar");
        btnguardar.setEnabled(true);
        cmbxestado.setEnabled(true);
        btmas.setEnabled(true);
        accion="editar";
        int fila = tblistado.rowAtPoint(evt.getPoint());
        txtcodigo.setText(tblistado.getValueAt(fila, 0).toString());
        txtnombre.setText(tblistado.getValueAt(fila, 1).toString());
        txtdni.setText(tblistado.getValueAt(fila, 2).toString());
        txtcelular.setText(tblistado.getValueAt(fila, 3).toString());
        txttelefono.setText(tblistado.getValueAt(fila, 4).toString());
        txtprestamo.setText(tblistado.getValueAt(fila, 5).toString());
        txttinteres.setText(tblistado.getValueAt(fila, 6).toString());
        txtmora.setText(tblistado.getValueAt(fila, 7).toString());
        txttotal.setText(tblistado.getValueAt(fila, 8).toString());
        date1.setDate(Date.valueOf(tblistado.getValueAt(fila,9).toString()));
        date2.setDate(Date.valueOf(tblistado.getValueAt(fila,10).toString()));
        cmbxestado.setSelectedItem(tblistado.getValueAt(fila, 12).toString());
        txtcodpres.setText(tblistado.getValueAt(fila, 13).toString());
        txtdistrito.setText(tblistado.getValueAt(fila, 14).toString());
        txtdireccion.setText(tblistado.getValueAt(fila, 15).toString());

    }//GEN-LAST:event_tblistadoMouseClicked

    private void btmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmasActionPerformed
        // TODO add your handling code here:
        btnmas();
        btnagregar();
        btnagregar.setEnabled(true);
        cmbxestado.setEnabled(true);
      
    }//GEN-LAST:event_btmasActionPerformed

    private void cmbxestadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbxestadoMouseClicked
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_cmbxestadoMouseClicked

    private void cmbxestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbxestadoActionPerformed
        // TODO add your handling code here:
                if (cmbxestado.getSelectedItem().toString().equals("2")) 
                {
                    tpmora = Integer.parseInt(txttotal.getText());
                    mora= Integer.parseInt(txtmora.getText());

                    tpcm =tpmora+mora;
                    
                    txttotal.setText(String.valueOf(tpcm));
                }
    }//GEN-LAST:event_cmbxestadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmas;
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JToggleButton btncal;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JComboBox<String> cmbxestado;
    private com.toedter.calendar.JDateChooser date1;
    private com.toedter.calendar.JDateChooser date2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblistado;
    private javax.swing.JTextField txtcelular;
    public javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtcodpres;
    public javax.swing.JTextField txtdireccion;
    public javax.swing.JTextField txtdistrito;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtinteres;
    private javax.swing.JTextField txtmora;
    public javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprestamo;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txttinteres;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
