package view;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.Curso;
import view.adapters.ListaCursosModel;
import view.adapters.TablaAlumnosModel;

public class JCursosAlumnos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbAlumnos;

	

	/**
	 * Create the frame.
	 */
	public JCursosAlumnos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seleccione curso:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(81, 45, 145, 19);
		contentPane.add(lblNewLabel);
		
		JComboBox<Curso> cbCursos = new JComboBox<>();
		cbCursos.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Curso curso=(Curso)cbCursos.getSelectedItem();
				//cargamos el table model con el id curso seleccionado
				tbAlumnos.setModel(new TablaAlumnosModel(curso.getIdCurso()));
			}
		});
		cbCursos.setBounds(81, 75, 112, 22);
		contentPane.add(cbCursos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 140, 305, 78);
		contentPane.add(scrollPane);
		
		tbAlumnos = new JTable();
		scrollPane.setViewportView(tbAlumnos);
		//carga cursos al abrir la ventana
		cbCursos.setModel(new ListaCursosModel());
		
		
		this.setVisible(true);
	}
}
