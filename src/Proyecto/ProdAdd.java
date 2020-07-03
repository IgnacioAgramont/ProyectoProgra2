package Proyecto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.SqlUsuarios;
import Clases.CatAdd;
import Clases.Producto;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

public class ProdAdd extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CodProdTF;
	private JTextField ProdTF;
	private JTextField UnidadesTF;
	private JTextField PrecioTF;
	private JTextField StockTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdAdd frame = new ProdAdd();
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
	public ProdAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 888, 571);
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
		
		JMenuItem mntmNewMenuItem_15 = new JMenuItem("Generar Venta");
		mntmNewMenuItem_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallVenta();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_15);
		mnNewMenu_4.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Agregar Usuarios");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallRegistro();
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_12);
		
		JLabel lblNewLabel_2 = new JLabel("Categor\u00EDa:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(117, 239, 86, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("C\u00F3digo de Producto:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(117, 268, 142, 22);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Producto:");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1_1.setBounds(117, 299, 86, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Unidades Por Paquete:");
		lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1_2.setBounds(117, 328, 164, 20);
		contentPane.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Precio Por Paquete:");
		lblNewLabel_2_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1_3.setBounds(117, 361, 142, 22);
		contentPane.add(lblNewLabel_2_1_3);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Paquetes en Stock:");
		lblNewLabel_2_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_1_4.setBounds(117, 396, 129, 22);
		contentPane.add(lblNewLabel_2_1_4);
		
		CodProdTF = new JTextField();
		CodProdTF.setColumns(10);
		CodProdTF.setBounds(293, 269, 210, 22);
		contentPane.add(CodProdTF);
		
		ProdTF = new JTextField();
		ProdTF.setColumns(10);
		ProdTF.setBounds(293, 299, 210, 22);
		contentPane.add(ProdTF);
		
		UnidadesTF = new JTextField();
		UnidadesTF.setColumns(10);
		UnidadesTF.setBounds(293, 328, 210, 22);
		contentPane.add(UnidadesTF);
		
		PrecioTF = new JTextField();
		PrecioTF.setColumns(10);
		PrecioTF.setBounds(293, 361, 210, 22);
		contentPane.add(PrecioTF);
		
		StockTF = new JTextField();
		StockTF.setColumns(10);
		StockTF.setBounds(293, 396, 210, 22);
		contentPane.add(StockTF);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 224));
		panel.setBounds(48, 201, 739, 310);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox<String> CategoriaBox = new JComboBox<String>();
		CategoriaBox.setBounds(245, 37, 211, 25);
		panel.add(CategoriaBox);
		CategoriaBox.removeAllItems();
		ArrayList<String> lista = new ArrayList<String>();
		lista = SqlUsuarios.llenar_cat();
		for(int i = 0; i<lista.size();i++) {
			CategoriaBox.addItem(lista.get(i));
		}
		
		JComboBox<String> ProveedorBox = new JComboBox<String>();
		ProveedorBox.setBounds(245, 230, 211, 25);
		panel.add(ProveedorBox);
		ProveedorBox.removeAllItems();
		ArrayList<String> lista2 = new ArrayList<String>();
		lista2 = SqlUsuarios.llenar_prov();
		for(int i = 0; i<lista2.size();i++) {
			ProveedorBox.addItem(lista2.get(i));
		}	
		
		JCheckBox disponible = new JCheckBox("Disponible");
		disponible.setSelected(true);
		disponible.setBounds(245, 264, 113, 25);
		panel.add(disponible);
		
		JButton btnNewButton = new JButton("Agregar Producto");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SqlUsuarios modsql = new SqlUsuarios();
				Producto mod = new Producto();
				
				String categoria = (String) CategoriaBox.getSelectedItem();
				String proveedor = (String) ProveedorBox.getSelectedItem();
				mod.setCodProd(CodProdTF.getText());
				mod.setNombre(ProdTF.getText());
				mod.setUnidPaq(Integer.parseInt(UnidadesTF.getText()));
				mod.setPrecioPaq(Double.parseDouble(PrecioTF.getText()));
				mod.setPaqStock(Integer.parseInt(StockTF.getText()));
				mod.setCategoria(modsql.getcategoria(categoria));
				mod.setDisponibilidad(disponible.isSelected());
				mod.setProveedor(modsql.getproveedor(proveedor));
				if(modsql.RegProd(mod)) {
					JOptionPane.showMessageDialog(null, "Producto Agregado Exitosamente", "Done",
							JOptionPane.INFORMATION_MESSAGE);
					CodProdTF.setText("");
					ProdTF.setText("");
					UnidadesTF.setText("");
					PrecioTF.setText("");
					StockTF.setText("");
				}else {
					JOptionPane.showMessageDialog(null, "Error al guardar", "Verifique", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(489, 103, 200, 40);
		panel.add(btnNewButton);
		
		JButton NewCategoriaBtn = new JButton("Nueva Categoria");
		NewCategoriaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CallCatAdd();
			}
		});
		NewCategoriaBtn.setBounds(489, 36, 127, 25);
		panel.add(NewCategoriaBtn);
		
		JLabel lblNewLabel_2_2 = new JLabel("Proveedor:");
		lblNewLabel_2_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(69, 231, 86, 22);
		panel.add(lblNewLabel_2_2);
		
		
		
		JButton btnNuevoProveedor = new JButton("Nuevo Proveedor");
		btnNuevoProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CallProvAdd();
			}
		});
		btnNuevoProveedor.setBounds(489, 231, 158, 25);
		panel.add(btnNuevoProveedor);
				
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
	void CallVenta() {
		Venta obj = new Venta();
		this.setVisible(false);
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
