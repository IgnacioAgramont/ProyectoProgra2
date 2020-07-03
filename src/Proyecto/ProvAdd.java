package Proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BD.SqlUsuarios;
import Clases.CatAdd;
import Clases.Proveedores;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ProvAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField DireccionField;
	private JTextField CelularField;
	private JTextField EmpresaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProvAdd frame = new ProvAdd();
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
	public ProvAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ignac\\OneDrive\\Desktop\\Universidad\\Programacion 2\\Proyecto\\123.png"));
		lblNewLabel_1.setBounds(50, 63, 98, 113);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGestionDeInventarios = new JLabel("Gestion de Inventarios");
		lblGestionDeInventarios.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblGestionDeInventarios.setBounds(214, 140, 269, 41);
		contentPane.add(lblGestionDeInventarios);
		
		JLabel lblNewLabel = new JLabel("Marca & Mercadeo");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(228, 86, 248, 41);
		contentPane.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 870, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Productos");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Agregar Productos");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallProdAdd();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Buscar Productos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CallProdBuscar();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Actualizar Productos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallProdUpd();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Proveedores");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Agregar Proveedores");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallProvAdd();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Buscar Proveedores");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallProvBuscar();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Actualizar Proveedores");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallProvUpd();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_5 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Agregar Clientes");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallCliAdd();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_13);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Buscar Clientes");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallCliBuscar();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_6);
		
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Actualizar Clientes");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallCliUpd();
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_14);
		
		JMenu mnNewMenu_3 = new JMenu("Reportes");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Clientes Por Vendedor");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallRepCliVen();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Clientes por Segmento de Mercado");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallRepCliSeg();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Clientes por Canal de Distribucion");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallRepCliCanalDis();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Clientes por Linea  de Producto");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallRepCliLinea();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_10);
		
		JMenu mnNewMenu_4 = new JMenu("Otros");
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Actualizar Contrase\u00F1a");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallPassUpd();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_11);
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Generar Venta");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallVenta();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_15);
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Agregar Usuarios");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallRegistro();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(63, 208, 739, 268);
		contentPane.add(panel);
		
		JButton btnAgregarProveedor = new JButton("Agregar Proveedor");
		btnAgregarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SqlUsuarios modsql = new SqlUsuarios();
				Proveedores mod = new Proveedores();
				
				int celular = Integer.parseInt(CelularField.getText());
				mod.setCelular(celular);
				mod.setDireccion(DireccionField.getText());
				mod.setEmpresa(EmpresaField.getText());
				
				if(modsql.RegProv(mod)) {
					JOptionPane.showMessageDialog(null, "Proveedor Agregado Exitosamente", "Done",
							JOptionPane.INFORMATION_MESSAGE);
					CelularField.setText("");
					DireccionField.setText("");
					EmpresaField.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Error al guardar", "Verifique", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAgregarProveedor.setBounds(490, 112, 200, 40);
		panel.add(btnAgregarProveedor);
		
		JLabel lblNewLabel_2_1 = new JLabel("Direccion:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(73, 120, 142, 22);
		panel.add(lblNewLabel_2_1);
		
		DireccionField = new JTextField();
		DireccionField.setColumns(10);
		DireccionField.setBounds(249, 120, 210, 22);
		panel.add(DireccionField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Empresa:");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(73, 71, 86, 22);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Celular:");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1_2.setBounds(73, 170, 142, 22);
		panel.add(lblNewLabel_2_1_2);
		
		CelularField = new JTextField();
		CelularField.setColumns(10);
		CelularField.setBounds(249, 170, 210, 22);
		panel.add(CelularField);
		
		EmpresaField = new JTextField();
		EmpresaField.setColumns(10);
		EmpresaField.setBounds(249, 72, 210, 22);
		panel.add(EmpresaField);
		
		JLabel lblNewLabel_2 = new JLabel("Categor\u00EDa:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(132, 246, 86, 22);
		contentPane.add(lblNewLabel_2);
	}
	void CallProdAdd() {
		ProdAdd obj = new ProdAdd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallProdBuscar() {
		ProdBuscar obj = new ProdBuscar();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallCatAdd() {
		CatAdd obj = new CatAdd();
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
		
	}
	void CallProdUpd() {
		ProdUpd obj = new ProdUpd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallProvAdd() {
		ProvAdd obj = new ProvAdd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallProvBuscar() {
		ProvBuscar obj = new ProvBuscar();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallProvUpd() {
		ProvUpd obj = new ProvUpd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallRepCliCanalDis() {
		RepCliCanalDis obj = new RepCliCanalDis();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallRepCliLinea() {
		RepCliLinea obj = new RepCliLinea();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallVenta() {
		Venta obj = new Venta();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
		
	}
	void CallRepCliSeg() {
		RepCliSeg obj = new RepCliSeg();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallRepCliVen() {
		RepCliVen obj = new RepCliVen();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallPassUpd() {
		PassUpd obj = new PassUpd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallRegistro() {
		Registro obj = new Registro();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallCliAdd() {
		CliAdd obj = new CliAdd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallCliBuscar() {
		CliBuscar obj = new CliBuscar();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
	void CallCliUpd() {
		CliUpd obj = new CliUpd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
}
