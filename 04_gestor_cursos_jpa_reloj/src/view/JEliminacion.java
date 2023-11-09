package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.FormacionService;
import service.FormacionServiceFactory;

public class JEliminacion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDni;

	
	/**
	 * Create the frame.
	 */
	public JEliminacion() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce DNI:");
		lblNewLabel.setBounds(62, 58, 89, 14);
		contentPane.add(lblNewLabel);
		
		txtDni = new JTextField();
		txtDni.setBounds(163, 55, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service=FormacionServiceFactory.getFormacionService();
				String mensaje;
				if(service.eliminarAlumno(txtDni.getText())) {
					mensaje="Alumno eliminado satisfactoriamente";
				}else {
					mensaje="Error, el alumno no existe o falló la eliminación";
				}
				JOptionPane.showMessageDialog(JEliminacion.this,mensaje);
			}
		});
		btnEliminar.setBounds(121, 126, 89, 23);
		contentPane.add(btnEliminar);
		this.setVisible(true);
	}
}
