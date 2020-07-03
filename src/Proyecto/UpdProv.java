package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.SqlUsuarios;
import Clases.Cliente;
import Clases.Proveedores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UpdProv extends JFrame {

	private JPanel contentPane;
	private JTextField EmpresaTF;
	private JTextField DireccionTF;
	private JTextField CelularTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdProv frame = new UpdProv();
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
	public UpdProv() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Actualizacion de Proveedor");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel_4.setBounds(152, 32, 335, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_1 = new JLabel("Empresa:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(151, 107, 115, 22);
		contentPane.add(lblNewLabel_1_1);
		
		EmpresaTF = new JTextField();
		EmpresaTF.setColumns(10);
		EmpresaTF.setBounds(152, 139, 266, 22);
		contentPane.add(EmpresaTF);
		
		JLabel lblNewLabel_2_1 = new JLabel("Direccion:");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2_1.setBounds(151, 186, 115, 22);
		contentPane.add(lblNewLabel_2_1);
		
		DireccionTF = new JTextField();
		DireccionTF.setColumns(10);
		DireccionTF.setBounds(151, 221, 267, 22);
		contentPane.add(DireccionTF);
		
		JLabel lblNewLabel_3_1 = new JLabel("Celular:");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3_1.setBounds(151, 260, 97, 22);
		contentPane.add(lblNewLabel_3_1);
		
		CelularTF = new JTextField();
		
		CelularTF.setColumns(10);
		CelularTF.setBounds(151, 295, 266, 22);
		contentPane.add(CelularTF);
		
		SqlUsuarios modsql = new SqlUsuarios();
		Proveedores mod = new Proveedores();
		BufferedReader w;
		try {
			w = new BufferedReader(new FileReader("prov.txt"));
			String empresa = w.readLine();
			mod.setEmpresa(empresa);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String cad = modsql.BuscarProv(mod);
		String []array = cad.split(";");
		int idProveedor = Integer.parseInt(array[0]);
		String Empresa = array[1];
		String Direccion = array[2];
		int Celular = Integer.parseInt(array[3]);
		
		mod.setIdProveedor(idProveedor);
		mod.setEmpresa(Empresa);
		mod.setDireccion(Direccion);
		mod.setCelular(Celular);
		EmpresaTF.setText(Empresa);
		DireccionTF.setText(Direccion);
		CelularTF.setText(array[3]);
		
		
		JButton btnNewButton_1 = new JButton("Confirmar Cambios");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlUsuarios modsql = new SqlUsuarios();
				
				mod.setEmpresa(EmpresaTF.getText());
				mod.setDireccion(DireccionTF.getText());
				mod.setCelular(Integer.parseInt(CelularTF.getText()));
				if(modsql.UpdateProv(mod)) {
					JOptionPane.showMessageDialog(null, "Proveedor Actualizado con exito");
					CallProvUpd();
				}else {
					JOptionPane.showMessageDialog(null, "Error");
					CallProvUpd();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.setBounds(200, 354, 198, 41);
		contentPane.add(btnNewButton_1);
	}
	void CallProvUpd() {
		ProvUpd obj = new ProvUpd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}
}
