package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Conexion;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AgregarLaptop extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdLaptop;
	private JComboBox <String> cmbMarca;
	private JComboBox <String> cmbActividad;
	private JComboBox cmbTipoPantalla;
	private JTextField txtNombreLaptop;
	private JTextField txtCapacidadProcesador;
	private JTextField txtFechaMercado;
	private JTextField txtNota;
	private JComboBox cmbResolucion;
	private JComboBox cmbMarcaProcesador;
	private JComboBox cmbCondicion;
	private JComboBox cmbRAM;
	private JComboBox cmbTipoDisco;
	private JComboBox cmbAlmacenamiento;
	private JComboBox cmbLectorCD;
	private JComboBox cmbTipoGrafica;
	private JComboBox cmbTarjetaGrafica;
	private JButton btnNewButton;
	private JSpinner spnCapacidadAlmacenamiento;
	private JSpinner spnExistencia;
	private JSpinner spnPrecio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarLaptop dialog = new AgregarLaptop();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarLaptop() {
		setBounds(100, 100, 951, 458);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
			panel_1.setBounds(10, 154, 905, 244);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblIdLaptop = new JLabel("Id Laptop:");
			lblIdLaptop.setBounds(10, 11, 64, 14);
			panel_1.add(lblIdLaptop);
			
			txtIdLaptop = new JTextField();
			txtIdLaptop.setEditable(false);
			txtIdLaptop.setBounds(68, 8, 102, 20);
			panel_1.add(txtIdLaptop);
			txtIdLaptop.setColumns(10);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(180, 11, 64, 14);
			panel_1.add(lblNombre);
			
			txtNombreLaptop = new JTextField();
			txtNombreLaptop.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) { 
					validacionCaracteres(e);
				}
			});
			txtNombreLaptop.setBounds(231, 8, 158, 20);
			panel_1.add(txtNombreLaptop);
			txtNombreLaptop.setColumns(10);
			
			JLabel lblNewLabel_1_1 = new JLabel("Condición:");
			lblNewLabel_1_1.setBounds(726, 11, 64, 14);
			panel_1.add(lblNewLabel_1_1);
			
			cmbCondicion = new JComboBox();
			cmbCondicion.setModel(new DefaultComboBoxModel(new String[] {"Selecciona", "Nueva", "Usada"}));
			cmbCondicion.setBounds(791, 8, 102, 20);
			panel_1.add(cmbCondicion);
			
			JLabel lblAlmacenamiento = new JLabel("Almacenamiento:");
			lblAlmacenamiento.setBounds(460, 84, 102, 14);
			panel_1.add(lblAlmacenamiento);
			
			cmbAlmacenamiento = new JComboBox();
			cmbAlmacenamiento.setBounds(620, 81, 54, 20);
			panel_1.add(cmbAlmacenamiento);
			
			JLabel lblNewLabel_2_2_1_1 = new JLabel("Lector de CD:");
			lblNewLabel_2_2_1_1.setBounds(700, 84, 95, 14);
			panel_1.add(lblNewLabel_2_2_1_1);
			
			cmbLectorCD = new JComboBox();
			cmbLectorCD.setModel(new DefaultComboBoxModel(new String[] {"Selecciona", "Si", "No"}));
			cmbLectorCD.setBounds(791, 81, 102, 20);
			panel_1.add(cmbLectorCD);
			
			JLabel lblProcesador = new JLabel("Procesador:");
			lblProcesador.setBounds(710, 49, 85, 14);
			panel_1.add(lblProcesador);
			
			txtCapacidadProcesador = new JTextField();
			txtCapacidadProcesador.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					validarcamposprocesador(e);
				}
			});
			txtCapacidadProcesador.setColumns(10);
			txtCapacidadProcesador.setBounds(791, 46, 102, 20);
			panel_1.add(txtCapacidadProcesador);
			
			JLabel lblTipoDeTarjeta = new JLabel("Tipo de Tarjeta Grafica:");
			lblTipoDeTarjeta.setBounds(168, 121, 146, 14);
			panel_1.add(lblTipoDeTarjeta);
			
			cmbTipoGrafica = new JComboBox();
			cmbTipoGrafica.setBounds(315, 118, 102, 20);
			panel_1.add(cmbTipoGrafica);
			
			JLabel lblTipoDeTarjeta_1 = new JLabel("Tarjeta Grafica:");
			lblTipoDeTarjeta_1.setBounds(464, 121, 95, 14);
			panel_1.add(lblTipoDeTarjeta_1);
			
			cmbTarjetaGrafica = new JComboBox();
			cmbTarjetaGrafica.setBounds(572, 118, 116, 20);
			panel_1.add(cmbTarjetaGrafica);
			
			JLabel lblPrecio = new JLabel("Precio:");
			lblPrecio.setBounds(59, 156, 83, 14);
			panel_1.add(lblPrecio);
			
			JLabel lblExistencia = new JLabel("Existencia:");
			lblExistencia.setBounds(315, 156, 64, 14);
			panel_1.add(lblExistencia);
			
			JLabel lblFechaEnEl = new JLabel("Año de Fabricación:");
			lblFechaEnEl.setBounds(572, 156, 142, 14);
			panel_1.add(lblFechaEnEl);
			
			txtFechaMercado = new JTextField();
			txtFechaMercado.addFocusListener(new FocusAdapter() {
			    @Override
			    public void focusGained(FocusEvent e) {
			        txtFechaMercado.setText("");
			    }
			});
			txtFechaMercado.setText("dd/mm/aaaa");
			txtFechaMercado.setColumns(10);
			txtFechaMercado.setBounds(688, 153, 102, 20);
			panel_1.add(txtFechaMercado);
			
			JLabel lblNota = new JLabel("Nota:");
			lblNota.setBounds(10, 209, 73, 14);
			panel_1.add(lblNota);
			
			txtNota = new JTextField();
			txtNota.setColumns(10);
			txtNota.setBounds(68, 206, 825, 20);
			panel_1.add(txtNota);
			
			JLabel lblNewLabel_1 = new JLabel("Actividad:");
			lblNewLabel_1.setBounds(399, 11, 64, 14);
			panel_1.add(lblNewLabel_1);
			
			cmbActividad = new JComboBox();
			cmbActividad.setBounds(457, 8, 102, 20);
			panel_1.add(cmbActividad);
			
			JLabel lblNewLabel = new JLabel("Marca:");
			lblNewLabel.setBounds(572, 11, 46, 14);
			panel_1.add(lblNewLabel);
			
			cmbMarca = new JComboBox();
			cmbMarca.setBounds(614, 8, 102, 20);
			panel_1.add(cmbMarca);
			
			JLabel lblNewLabel_2 = new JLabel("Tipo de Pantalla:");
			lblNewLabel_2.setBounds(10, 49, 94, 14);
			panel_1.add(lblNewLabel_2);
			
			cmbTipoPantalla = new JComboBox();
			cmbTipoPantalla.setBounds(114, 46, 102, 20);
			panel_1.add(cmbTipoPantalla);
			
			JLabel lblNewLabel_2_1 = new JLabel("Resolución:");
			lblNewLabel_2_1.setBounds(241, 49, 73, 14);
			panel_1.add(lblNewLabel_2_1);
			
			cmbResolucion = new JComboBox();
			cmbResolucion.setBounds(315, 46, 102, 20);
			panel_1.add(cmbResolucion);
			
			JLabel lblNewLabel_2_2 = new JLabel("Marca del Procesador:");
			lblNewLabel_2_2.setBounds(439, 49, 142, 14);
			panel_1.add(lblNewLabel_2_2);
			
			cmbMarcaProcesador = new JComboBox();
			cmbMarcaProcesador.setBounds(572, 46, 102, 20);
			panel_1.add(cmbMarcaProcesador);
			
			JLabel lblNewLabel_2_2_1 = new JLabel("Memoria RAM:");
			lblNewLabel_2_2_1.setBounds(10, 84, 89, 14);
			panel_1.add(lblNewLabel_2_2_1);
			
			cmbRAM = new JComboBox();
			cmbRAM.setBounds(114, 81, 102, 20);
			panel_1.add(cmbRAM);
			
			JLabel lblTipoDeDisco = new JLabel("Tipo de Disco:");
			lblTipoDeDisco.setBounds(231, 84, 83, 14);
			panel_1.add(lblTipoDeDisco);
			
			cmbTipoDisco = new JComboBox();
			cmbTipoDisco.setBounds(315, 81, 102, 20);
			panel_1.add(cmbTipoDisco);
			
			spnCapacidadAlmacenamiento = new JSpinner();
			spnCapacidadAlmacenamiento.setBounds(572, 81, 46, 20);
			panel_1.add(spnCapacidadAlmacenamiento);
			
			spnExistencia = new JSpinner();
			spnExistencia.setBounds(378, 153, 102, 20);
			panel_1.add(spnExistencia);
			
			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(Float.valueOf(0), null, null, Float.valueOf(1)));
			spnPrecio.setBounds(114, 153, 102, 20);
			panel_1.add(spnPrecio);
			
			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon(AgregarLaptop.class.getResource("/Image/1458264592_laptop_computer_pc_device_notebook_netbook_internet_icon-icons.com_55334.png")));
			lblNewLabel_3.setBounds(47, 11, 128, 132);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_3_1 = new JLabel("");
			lblNewLabel_3_1.setIcon(new ImageIcon(AgregarLaptop.class.getResource("/Image/1458264592_laptop_computer_pc_device_notebook_netbook_internet_icon-icons.com_55334.png")));
			lblNewLabel_3_1.setBounds(747, 11, 128, 132);
			panel.add(lblNewLabel_3_1);
			
			btnNewButton = new JButton("Guardar");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(txtNombreLaptop.getText().isEmpty() || txtFechaMercado.getText().isEmpty() ||  txtCapacidadProcesador.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Campos Vacios");
					}else if(cmbLectorCD.getSelectedItem().toString().equals("Selecciona") || cmbCondicion.getSelectedItem().toString().equals("Selecciona") 
							|| cmbActividad.getSelectedItem().toString().equals("Selecciona") || cmbMarca.getSelectedItem().toString().equals("Selecciona") 
							|| cmbTipoPantalla.getSelectedItem().toString().equals("Selecciona") || cmbResolucion.getSelectedItem().toString().equals("Selecciona") 
							|| cmbMarcaProcesador.getSelectedItem().toString().equals("Selecciona") ||cmbRAM.getSelectedItem().toString().equals("Selecciona") 
							|| cmbTipoDisco.getSelectedItem().toString().equals("Selecciona") || cmbAlmacenamiento.getSelectedItem().toString().equals("Selecciona") 
							|| cmbTipoGrafica.getSelectedItem().toString().equals("Selecciona") || cmbTarjetaGrafica.getSelectedItem().toString().equals("Selecciona")){
							JOptionPane.showMessageDialog(null, "Faltan Selecciones");
						
					}else {
						agregarLaptop(txtNombreLaptop.getText().toString(), cmbCondicion.getSelectedItem().toString(),(int) spnCapacidadAlmacenamiento.getValue(), cmbLectorCD.getSelectedItem().toString(),
						(int) spnCapacidadAlmacenamiento.getValue(), (float)spnPrecio.getValue(), txtFechaMercado.getText().toString(), txtCapacidadProcesador.getText().toString(), 
						txtNota.getText().toString(),cmbActividad.getSelectedItem().toString(), cmbMarca.getSelectedItem().toString(), cmbTipoPantalla.getSelectedItem().toString(),
						cmbResolucion.getSelectedItem().toString(),cmbMarcaProcesador.getSelectedItem().toString(), cmbRAM.getSelectedItem().toString(), cmbTipoDisco.getSelectedItem().toString(), 
						cmbAlmacenamiento.getSelectedItem().toString(),cmbTipoGrafica.getSelectedItem().toString(), cmbTarjetaGrafica.getSelectedItem().toString());
					}					
				}
			});
			btnNewButton.setIcon(new ImageIcon(AgregarLaptop.class.getResource("/Image/Save_icon-icons.com_73702 (3).png")));
			btnNewButton.setBounds(222, 47, 128, 48);
			panel.add(btnNewButton);
			
			JButton btnConsultar = new JButton("Consultar");
			btnConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Consulta consul = new Consulta();
					consul.setVisible(true);
			        //setVisible(false);
				}
			});
			btnConsultar.setIcon(new ImageIcon(AgregarLaptop.class.getResource("/Image/loupe_78956.png")));
			btnConsultar.setBounds(397, 47, 128, 48);
			panel.add(btnConsultar);
			
			JButton btnLimpiador = new JButton("Limpiador");
			btnLimpiador.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Limpiar();
				}
			});
			btnLimpiador.setIcon(new ImageIcon(AgregarLaptop.class.getResource("/Image/Cleaner_icon-icons.com_53211.png")));
			btnLimpiador.setBounds(572, 47, 128, 48);
			panel.add(btnLimpiador);
		}
		
		cmbMarca.setName("Marca");
		Llenar(cmbMarca);
		cmbResolucion.setName("Resolucion");
		Llenar(cmbResolucion);
		cmbActividad.setName("Actividad");
		Llenar(cmbActividad);
		cmbTipoPantalla.setName("Pantalla");
		Llenar(cmbTipoPantalla);
		cmbMarcaProcesador.setName("Procesador");
		Llenar(cmbMarcaProcesador);
		cmbRAM.setName("RAM");
		Llenar(cmbRAM);
		cmbTipoDisco.setName("DiscoDuro");
		Llenar(cmbTipoDisco);
		cmbAlmacenamiento.setName("Almacenamiento");
		Llenar(cmbAlmacenamiento);
		cmbTipoGrafica.setName("TipoTarjetaGrafica");
		Llenar(cmbTipoGrafica);
		cmbTarjetaGrafica.setName("TarjetaGrafica");
		Llenar(cmbTarjetaGrafica);
		IdLaptop();
		
	}
	
	private void Llenar(JComboBox<String> cmBox) {
		
		ArrayList<String> nombresMarca = new ArrayList<String>();
	    try {
	    	java.sql.Statement sqlStatement = Conexion.getConexion().createStatement();
			String consulta = "SELECT Nombre FROM " + cmBox.getName();
			ResultSet resultadoResultSet = sqlStatement.executeQuery(consulta);
	      while (resultadoResultSet.next()) {
	        String nombre = resultadoResultSet.getString("Nombre");
	        nombresMarca.add(nombre);
	      }
	      nombresMarca.add(0, "Selecciona");
	      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
	      for (String marca : nombresMarca) {
	          model.addElement(marca);
	        }
	      
	        cmBox.setModel(model);
	        
	      
		} catch (SQLException  ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}
	
	public void agregarLaptop(String nombreLaptop, String condicion, int capAlmacenamiento, String lectorCD, int existencia, float precio, String fechaMercado, String procesador, 
			String nota,String nombreActividad, String nombreMarca, String tipoPantalla, String resolucion, String marcaProcesador, String memoriaRAM, String tipoDisco, String Almacenamiento,
			String tipoGrafica, String tarjetaGrafica) {
		  
		    try {
		        Connection con = Conexion.getConexion();
		        CallableStatement cs = con.prepareCall("{call AgregarLaptopCompleta(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		        cs.setString(1, nombreLaptop);
		        cs.setString(2, condicion);
		        cs.setInt(3, capAlmacenamiento);
		        cs.setString(4, lectorCD);
		        cs.setInt(5, existencia);
		        cs.setFloat(6, precio);
		        cs.setString(7, fechaMercado);
		        cs.setString(8, procesador);
		        cs.setString(9, nota);
		        cs.setString(10, nombreActividad);
		        cs.setString(11, nombreMarca);
		        cs.setString(12, tipoPantalla);
		        cs.setString(13, resolucion);
		        cs.setString(14, marcaProcesador);
		        cs.setString(15, memoriaRAM);
		        cs.setString(16, tipoDisco);
		        cs.setString(17, Almacenamiento);
		        cs.setString(18, tipoGrafica);
		        cs.setString(19, tarjetaGrafica);
	
		        int result = cs.executeUpdate();
		        if (result > 0) {
		        	JOptionPane.showMessageDialog(null, "Los datos se guardaron correctamente.");
		            Limpiar();
		        } else {
		            System.out.println("Error al insertar los datos.");
		        }
		        
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		}
	public void Limpiar() {
		
		IdLaptop();
		txtNombreLaptop.setText(null);
		cmbCondicion.setSelectedIndex(0);
		spnCapacidadAlmacenamiento.setValue(0);
		cmbLectorCD.setSelectedIndex(0);
		spnCapacidadAlmacenamiento.setValue(0);
		spnPrecio.setValue(0); 
		txtFechaMercado.setText(null);
		txtCapacidadProcesador.setText(null);
		cmbActividad.setSelectedIndex(0); 
		cmbMarca.setSelectedIndex(0);
		cmbTipoPantalla.setSelectedIndex(0); 
		cmbResolucion.setSelectedIndex(0);
		cmbMarcaProcesador.setSelectedIndex(0);
		cmbRAM.setSelectedIndex(0);
		cmbTipoDisco.setSelectedIndex(0); 
		cmbAlmacenamiento.setSelectedIndex(0);
		cmbTipoGrafica.setSelectedIndex(0);
		cmbTarjetaGrafica.setSelectedIndex(0);
		txtNota.setText(null);
		spnExistencia.setValue(0);
	}
	private void IdLaptop() {
		try {
			java.sql.Statement sqlStatement = Conexion.getConexion().createStatement();
			String consulta = "EXEC spGetNextLaptopId;";
			ResultSet resultadoResultSet = sqlStatement.executeQuery(consulta);
			
			if (resultadoResultSet.next()) {
				int nextIdLaptop = resultadoResultSet.getInt("NextLaptopId");
				if(nextIdLaptop == 0){
					txtIdLaptop.setText("1");
				
				}else {
					txtIdLaptop.setText(Integer.toString(nextIdLaptop));
				}
			}
		} catch (SQLException  ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	}

	public void validacionCaracteres(java.awt.event.KeyEvent evento) {
		if(evento.getKeyChar() >= 32 && evento.getKeyChar() <=47
			|| evento.getKeyChar() >= 58 && evento.getKeyChar() <=64
			|| evento.getKeyChar() >= 91 && evento.getKeyChar() <=96 
			|| evento.getKeyChar() >= 123 && evento.getKeyChar() <= 208 
			|| evento.getKeyChar() >= 210 && evento.getKeyChar() <= 240
			|| evento.getKeyChar() >= 242 && evento.getKeyChar() <= 255) {
			
			evento.consume();
			JOptionPane.showMessageDialog(this, "No se permiten caracteres especiales");
		}
	}
	
	public void validarcamposprocesador (java.awt.event.KeyEvent evento) {
		if(evento.getKeyChar() >= 32 && evento.getKeyChar() <=45 ||evento.getKeyChar() == 47
				|| evento.getKeyChar() >= 58 && evento.getKeyChar() <=64
				|| evento.getKeyChar() >= 91 && evento.getKeyChar() <=96 
				|| evento.getKeyChar() >= 123 && evento.getKeyChar() <= 208 
				|| evento.getKeyChar() >= 210 && evento.getKeyChar() <= 240
				|| evento.getKeyChar() >= 242 && evento.getKeyChar() <= 255) {
				
				evento.consume();
				JOptionPane.showMessageDialog(this, "Caracter no permitido");
			}
	}
	
	public void validarcamposPrecio (java.awt.event.KeyEvent evento) {
		if(evento.getKeyChar() >= 32 && evento.getKeyChar() <=43 
				||evento.getKeyChar() == 47 || evento.getKeyChar() == 45 
				|| evento.getKeyChar() >= 58 && evento.getKeyChar() <=255) {
				
				evento.consume();
				JOptionPane.showMessageDialog(this, "Caracter no permitido");
			}
	}

}
