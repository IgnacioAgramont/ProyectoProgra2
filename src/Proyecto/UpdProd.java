package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BD.SqlUsuarios;
import Clases.Cliente;
import Clases.Producto;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UpdProd extends JFrame {

	private JPanel contentPane;
	private JTextField NombreTF;
	private JTextField UnidadesTF;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;
	private JTextField PrecioTF;
	private JLabel lblNewLabel_4;
	private JTextField PaquetesTF;
	private JLabel lblNewLabel_5;
	private JButton Btn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdProd frame = new UpdProd();
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
	public UpdProd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 553);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actualizacion de Producto");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setBounds(125, 55, 375, 34);
		contentPane.add(lblNewLabel);
		
		NombreTF = new JTextField();
		NombreTF.setBounds(154, 167, 266, 22);
		contentPane.add(NombreTF);
		NombreTF.setColumns(10);
		
		UnidadesTF = new JTextField();
		UnidadesTF.setBounds(152, 237, 266, 22);
		contentPane.add(UnidadesTF);
		UnidadesTF.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(153, 135, 97, 22);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_3 = new JLabel("Unidades:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(152, 202, 117, 22);
		contentPane.add(lblNewLabel_3);
		
		PrecioTF = new JTextField();
		PrecioTF.setColumns(10);
		PrecioTF.setBounds(154, 307, 266, 22);
		contentPane.add(PrecioTF);
		
		lblNewLabel_4 = new JLabel("Precio:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_4.setBounds(154, 272, 117, 22);
		contentPane.add(lblNewLabel_4);
		
		PaquetesTF = new JTextField();
		PaquetesTF.setColumns(10);
		PaquetesTF.setBounds(154, 377, 266, 22);
		contentPane.add(PaquetesTF);
		
		lblNewLabel_5 = new JLabel("Paquetes:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_5.setBounds(154, 342, 117, 22);
		contentPane.add(lblNewLabel_5);
		
		SqlUsuarios modsql = new SqlUsuarios();
		Producto mod = new Producto();
		BufferedReader w;
		try {
			w = new BufferedReader(new FileReader("prod.txt"));
			String Producto = w.readLine();
			mod.setNombre(Producto);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			String cad = modsql.BuscarProd(mod);
			String []array = cad.split(";");
			
			String idProducto = array[0];
			String Producto = array[1];
			int Unidades = Integer.parseInt(array[2]);
			double Precio = Double.parseDouble(array[3]);
			int Paquetes = Integer.parseInt(array[4]);
			
			mod.setCodProd(idProducto);
			mod.setNombre(Producto);
			mod.setUnidPaq(Unidades);
			mod.setPrecioPaq(Precio);
			mod.setPaqStock(Paquetes);
			NombreTF.setText(Producto);
			UnidadesTF.setText(array[2]);
			PrecioTF.setText(array[3]);
			PaquetesTF.setText(array[4]);
		
		Btn = new JButton("Confirmar Cambios");
		Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlUsuarios modsql = new SqlUsuarios();
				
				mod.setNombre(NombreTF.getText());
				mod.setUnidPaq(Integer.parseInt(UnidadesTF.getText()));
				mod.setPrecioPaq(Double.parseDouble(PrecioTF.getText()));
				mod.setPaqStock(Integer.parseInt(PaquetesTF.getText()));
				if(modsql.UpdateProd(mod)) {
					JOptionPane.showMessageDialog(null, "Producto Actualizado con exito");
					CallProdUpd();
				}else {
					JOptionPane.showMessageDialog(null, "Error");
					CallProdUpd();
				}
			}
		});
		Btn.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Btn.setBounds(192, 427, 198, 41);
		contentPane.add(Btn);
	}
	void CallProdUpd() {
		ProdUpd obj = new ProdUpd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}

}
