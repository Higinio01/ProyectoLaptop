package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Conexion;

import javax.swing.UIManager;
import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Consulta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cmbActividad;
	private JComboBox cmbMarca;
	private JComboBox cmbProcesador;
	private JComboBox cmbRAM;
	private JComboBox cmbTarjetaGrafica;
	private JComboBox cmbCondicion;
	private DefaultTableModel model;
    private Object row[];
    private JButton btnBuscar;
    private JSpinner spnPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Consulta dialog = new Consulta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Consulta() {
		setBounds(100, 100, 710, 587);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(UIManager.getBorder("InternalFrame.border"));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
			panel_1.setBounds(10, 39, 664, 216);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			cmbActividad = new JComboBox();
			cmbActividad.setBounds(71, 36, 126, 22);
			panel_1.add(cmbActividad);
			
			cmbMarca = new JComboBox();
			cmbMarca.setBounds(268, 36, 126, 22);
			panel_1.add(cmbMarca);
			
			cmbProcesador = new JComboBox();
			cmbProcesador.setBounds(465, 36, 126, 22);
			panel_1.add(cmbProcesador);
			
			cmbRAM = new JComboBox();
			cmbRAM.setBounds(71, 100, 126, 22);
			panel_1.add(cmbRAM);
			
			cmbTarjetaGrafica = new JComboBox();
			cmbTarjetaGrafica.setBounds(268, 100, 126, 22);
			panel_1.add(cmbTarjetaGrafica);
			
			cmbCondicion = new JComboBox();
			cmbCondicion.setModel(new DefaultComboBoxModel(new String[] {"Nueva", "Usada"}));
			cmbCondicion.setBounds(465, 100, 126, 22);
			panel_1.add(cmbCondicion);
			
			JLabel lblNewLabel_1 = new JLabel("Actividad:");
			lblNewLabel_1.setBounds(71, 22, 70, 14);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Marca:");
			lblNewLabel_1_1.setBounds(268, 22, 70, 14);
			panel_1.add(lblNewLabel_1_1);
			
			JLabel lblNewLabel_1_2 = new JLabel("Procesador:");
			lblNewLabel_1_2.setBounds(465, 22, 70, 14);
			panel_1.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_3 = new JLabel("Memoria RAM:");
			lblNewLabel_1_3.setBounds(71, 86, 84, 14);
			panel_1.add(lblNewLabel_1_3);
			
			JLabel lblNewLabel_1_4 = new JLabel("Tarjeta Grafica:");
			lblNewLabel_1_4.setBounds(268, 86, 112, 14);
			panel_1.add(lblNewLabel_1_4);
			
			JLabel lblNewLabel_1_5 = new JLabel("Condición:");
			lblNewLabel_1_5.setBounds(465, 86, 84, 14);
			panel_1.add(lblNewLabel_1_5);
			
			spnPrecio = new JSpinner();
			spnPrecio.setModel(new SpinnerNumberModel(Float.valueOf(0), null, null, Float.valueOf(1)));
			spnPrecio.setBounds(71, 158, 126, 20);
			panel_1.add(spnPrecio);
			
			JLabel lblNewLabel_1_3_1 = new JLabel("Precio Maximo:");
			lblNewLabel_1_3_1.setBounds(71, 145, 126, 14);
			panel_1.add(lblNewLabel_1_3_1);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					loadTableTodos(cmbCondicion.getSelectedItem().toString(),cmbActividad.getSelectedItem().toString(), cmbMarca.getSelectedItem().toString(), cmbTarjetaGrafica.getSelectedItem().toString(),
							cmbRAM.getSelectedItem().toString(), (float) spnPrecio.getValue(), cmbProcesador.getSelectedItem().toString());
					
				}
			});
			btnBuscar.setIcon(new ImageIcon(Consulta.class.getResource("/Image/search_look_for_seek_magnifying_glass_lens_icon_141967 (1).png")));
			btnBuscar.setBounds(465, 146, 126, 34);
			panel_1.add(btnBuscar);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
			panel_1_1.setBounds(10, 266, 664, 261);
			panel.add(panel_1_1);
			panel_1_1.setLayout(new BorderLayout(0, 0));
			
			
			
			JScrollPane scrollPane = new JScrollPane();
			JTable tblConsulta = new JTable();
			scrollPane.setViewportView(tblConsulta);
			String headers1[] = {"Id","Laptop","Condicion","Precio","Marca","Grafica"};
			model = new DefaultTableModel();
			model.setColumnIdentifiers(headers1);
			
			tblConsulta.setModel(model);
			panel_1_1.add(scrollPane, BorderLayout.CENTER);
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setForeground(SystemColor.textHighlight);
			panel_2.setBorder(UIManager.getBorder("InternalFrame.border"));
			panel_2.setBounds(10, 11, 664, 29);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Consulta");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(266, 0, 132, 25);
			panel_2.add(lblNewLabel);
		}
		cmbMarca.setName("Marca");
		Llenar(cmbMarca);
		cmbActividad.setName("Actividad");
		Llenar(cmbActividad);
		cmbProcesador.setName("Procesador");
		Llenar(cmbProcesador);
		cmbRAM.setName("RAM");
		Llenar(cmbRAM);
		cmbTarjetaGrafica.setName("TipoTarjetaGrafica");
		Llenar(cmbTarjetaGrafica);
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

	private void loadTableTodos(String condicion, String Actividad, String Marca, String tipoTarjeta, String RAM, float Precio, String Procesador) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		try {
			java.sql.Statement sqlStatement = Conexion.getConexion().createStatement();
			String consulta = "SELECT l.IdLaptop, l.nombreLaptop, l.condicion, l.precio, p.Nombre AS procesador, m.Nombre AS marca, t.Nombre AS TipoTarjetaGrafica\r\n"
					+ "FROM Laptop l\r\n"
					+ "INNER JOIN Laptop_Actividad la ON l.IdLaptop = la.IdLaptop\r\n"
					+ "INNER JOIN Actividad a ON la.IdActividad = a.IdActividad\r\n"
					+ "INNER JOIN Laptop_Procesador lp ON l.IdLaptop = lp.IdLaptop\r\n"
                    + "INNER JOIN Laptop_TipoTarjetaGrafica ltt ON l.IdLaptop = ltt.IdLaptop\r\n"
					+ "INNER JOIN TipoTarjetaGrafica t ON ltt.IdTipoTarjeta = t.IdTipoTarjeta\r\n"
					+ "INNER JOIN Laptop_Marca lm ON l.IdLaptop = lm.IdLaptop\r\n"
					+ "INNER JOIN Marca m ON lm.IdMarca = m.IdMarca\r\n"
					+ "INNER JOIN Laptop_RAM lr ON l.IdLaptop = lr.IdLaptop\r\n"
					+ "INNER JOIN RAM r ON lr.IdRAM = r.IdRAM\r\n"
					+ "INNER JOIN Laptop_Procesador lp2 ON l.IdLaptop = lp2.IdLaptop\r\n"
					+ "INNER JOIN Procesador p ON lp.IdProcesador = p.IdProcesador\r\n"
					+ "WHERE l.condicion = '"+ condicion +" '\r\n"
					+ "AND a.Nombre = '"+ Actividad +" '\r\n"
					+ "AND t.Nombre = '"+ tipoTarjeta +" '\r\n"
					+ "AND m.Nombre = '"+ Marca +" '\r\n"
					+ "AND l.precio <= "+ Precio +" \r\n"
					+ "AND p.Nombre = '"+ Procesador +" '\r\n"
					+ "AND r.Nombre = '"+ RAM +" ';\r\n"
					+ "";
			ResultSet resultadoResultSet = sqlStatement.executeQuery(consulta);
			while(resultadoResultSet.next()) {
				row[0] = resultadoResultSet.getString("IdLaptop");
				row[1] = resultadoResultSet.getString("nombreLaptop");
				row[2] = resultadoResultSet.getString("condicion");
				row[3] =  " $ "+ resultadoResultSet.getString("precio");
				row[4] = resultadoResultSet.getString("marca");
				row[5] = resultadoResultSet.getString("TipoTarjetaGrafica");
				model.addRow(row);
			}
			
		} catch (SQLException  ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	
	}
	private void loadTableTodos1(String condicion, String Actividad, String Marca, String tipoTarjeta, String RAM, float Precio, String Procesador) {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		try {
			java.sql.Statement sqlStatement = Conexion.getConexion().createStatement();
			String consulta = "SELECT l.IdLaptop, l.nombreLaptop, l.condicion, l.precio, p.Nombre AS procesador, m.Nombre AS marca, t.Nombre AS TipoTarjetaGrafica"
					+ "FROM Laptop AS l"
					+ "LEFT JOIN Laptop_Actividad la ON l.IdLaptop = la.IdLaptop"
					+ "LEFT JOIN Actividad a ON la.IdActividad = a.IdActividad"
					+ "LEFT JOIN Laptop_Procesador lp ON l.IdLaptop = lp.IdLaptop"
					+ "LEFT JOIN Procesador p ON lp.IdProcesador = p.IdProcesador"
					+ "LEFT JOIN Laptop_RAM lr ON l.IdLaptop = lr.IdLaptop"
					+ "LEFT JOIN RAM r ON lr.IdRAM = r.IdRAM"
					+ "LEFT JOIN Laptop_Marca lm ON l.IdLaptop = lm.IdLaptop"
					+ "LEFT JOIN Marca m ON lm.IdMarca = m.IdMarca"
					+ "LEFT JOIN Laptop_TipoTarjetaGrafica ltt ON l.IdLaptop = ltt.IdLaptop"
					+ "LEFT JOIN TipoTarjetaGrafica t ON ltt.IdTipoTarjeta = t.IdTipoTarjeta"
					+ "WHERE (a.Nombre = "+ Actividad +" OR a.Nombre IS NOT NULL)"
					  + "AND (p.Nombre = "+ Procesador +" OR p.Nombre IS NOT NULL)"
					  + "AND (r.Nombre = "+ RAM +" OR r.Nombre IS NOT NULL)"
					  + "AND (m.Nombre = "+ Marca +" OR m.Nombre IS NOT NULL)"
					  + "AND (t.Nombre = "+ tipoTarjeta +" OR t.Nombre IS NOT NULL);"
					  + "";
			ResultSet resultadoResultSet = sqlStatement.executeQuery(consulta);
			while(resultadoResultSet.next()) {
				row[0] = resultadoResultSet.getString("IdLaptop");
				row[1] = resultadoResultSet.getString("nombreLaptop");
				row[2] = resultadoResultSet.getString("condicion");
				row[3] =  " $ "+ resultadoResultSet.getString("precio");
				row[4] = resultadoResultSet.getString("marca");
				row[5] = resultadoResultSet.getString("TipoTarjetaGrafica");
				model.addRow(row);
			}
			
		} catch (SQLException  ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
		}
	
	}
	
}
