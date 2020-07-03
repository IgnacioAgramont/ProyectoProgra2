package Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import BD.SqlUsuarios;
import Clases.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdCli extends JFrame {

	private JPanel contentPane;
	private JTextField NombreTF;
	private JTextField DireccionTF;
	private JTextField CelularTF;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdCli frame = new UpdCli();
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
	public UpdCli() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 629, 506);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Actualizacion de Cliente");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setBounds(151, 56, 298, 34);
		contentPane.add(lblNewLabel);
		
		NombreTF = new JTextField();
		NombreTF.setBounds(151, 163, 266, 22);
		contentPane.add(NombreTF);
		NombreTF.setColumns(10);
		
		DireccionTF = new JTextField();
		DireccionTF.setBounds(150, 245, 267, 22);
		contentPane.add(DireccionTF);
		DireccionTF.setColumns(10);
		
		CelularTF = new JTextField();
		CelularTF.setBounds(150, 319, 266, 22);
		contentPane.add(CelularTF);
		CelularTF.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(150, 131, 97, 22);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(150, 210, 115, 22);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Celular:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_3.setBounds(150, 284, 97, 22);
		contentPane.add(lblNewLabel_3);
		
		SqlUsuarios modsql = new SqlUsuarios();
		Cliente mod = new Cliente();
		BufferedReader w;
		try {
			w = new BufferedReader(new FileReader("cli.txt"));
			String cliente = w.readLine();
			mod.setNombre(cliente);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			String cad = modsql.BuscarCli(mod);
			String [] array = cad.split(";");
			String cod = array[0];
			String Nombre = array[1];
			String Direccion = array[2];
			String Celular = array[3];
			
			mod.setCod(Integer.parseInt(cod));
			mod.setNombre(Nombre);
			mod.setDireccion(Direccion);
			mod.setCelular(Integer.parseInt(Celular));
			NombreTF.setText(Nombre);
			DireccionTF.setText(Direccion);
			CelularTF.setText(Celular);
		
		
		
		btnNewButton = new JButton("Confirmar Cambios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlUsuarios modsql = new SqlUsuarios();
				
				mod.setNombre(NombreTF.getText());
				mod.setDireccion(DireccionTF.getText());
				mod.setCelular(Integer.parseInt(CelularTF.getText()));
				if(modsql.UpdateCli(mod)) {
					JOptionPane.showMessageDialog(null, "Cliente Actualizado con exito");
					CallCliUpd();
				}else {
					JOptionPane.showMessageDialog(null, "Error");
					CallCliUpd();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(199, 378, 198, 41);
		contentPane.add(btnNewButton);
	}
	void CallCliUpd() {
		CliUpd obj = new CliUpd();
		this.setVisible(false);
		obj.setVisible(true);
		obj.setLocationRelativeTo(null);
	}

}
