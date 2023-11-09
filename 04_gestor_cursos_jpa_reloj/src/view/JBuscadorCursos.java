package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.FormacionServiceFactory;
import view.adapters.TablaCursosModel;

public class JBuscadorCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtF1;
	private JTextField txtF2;
	private JTable tbCursos;

	

	/**
	 * Create the frame.
	 */
	public JBuscadorCursos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fecha ini:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(40, 21, 87, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblFechaFin = new JLabel("Fecha fin:");
		lblFechaFin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaFin.setBounds(241, 21, 87, 14);
		contentPane.add(lblFechaFin);
		
		txtF1 = new JTextField();
		txtF1.setBounds(41, 46, 86, 20);
		contentPane.add(txtF1);
		txtF1.setColumns(10);
		
		txtF2 = new JTextField();
		txtF2.setBounds(241, 46, 86, 20);
		contentPane.add(txtF2);
		txtF2.setColumns(10);
		
		JButton btnCursos = new JButton("Ver cursos");
		btnCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					var f1=LocalDate.parse(txtF1.getText());
					var f2=LocalDate.parse(txtF2.getText());
					tbCursos.setModel(new TablaCursosModel(f1,f2));
				}catch(DateTimeParseException ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(JBuscadorCursos.this, "Error en las fechas");
				}
			}
		});
		btnCursos.setBounds(139, 84, 137, 23);
		contentPane.add(btnCursos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 133, 359, 98);
		contentPane.add(scrollPane);
		
		tbCursos = new JTable();
		scrollPane.setViewportView(tbCursos);
		this.setVisible(true);
	}
}
