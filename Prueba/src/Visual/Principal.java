package Visual;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.nio.channels.AsynchronousChannelGroup;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("STAR TECNOLOGY");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/Image/iconfinder-rootaccess-4417096_116625.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel_1.setBounds(232, 0, 228, 296);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/Image/detective_avatar_man_person_investigation_icon_191300.png")));
		lblNewLabel_1.setBounds(50, 39, 128, 139);
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Consulta");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consulta consul = new Consulta();
				consul.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(37, 202, 153, 41);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(UIManager.getBorder("InternalFrame.border"));
		panel_2.setBounds(0, 0, 228, 296);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/Image/1458264592_laptop_computer_pc_device_notebook_netbook_internet_icon-icons.com_55334.png")));
		lblNewLabel.setBounds(50, 38, 128, 139);
		panel_2.add(lblNewLabel);
		
		JButton btnAgregarLaptop = new JButton("\r\nAgregar Laptop");
		btnAgregarLaptop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarLaptop agregarLaptop = new AgregarLaptop();
				agregarLaptop.setVisible(true);
		        
			}
		});
		btnAgregarLaptop.setBounds(37, 201, 153, 41);
		panel_2.add(btnAgregarLaptop);
	}

}
