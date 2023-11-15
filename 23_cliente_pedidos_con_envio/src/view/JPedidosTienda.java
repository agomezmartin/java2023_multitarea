package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaPedidosModel;

public class JPedidosTienda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTienda;
	private JButton btnPedidos;
	private JTable tbPedidos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JPedidosTienda frame = new JPedidosTienda();
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
	public JPedidosTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce nombre de tienda:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(126, 34, 196, 14);
		contentPane.add(lblNewLabel);
		
		txtTienda = new JTextField();
		txtTienda.setBounds(127, 59, 161, 20);
		contentPane.add(txtTienda);
		txtTienda.setColumns(10);
		
		btnPedidos = new JButton("Ver pedidos");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbPedidos.setModel(new TablaPedidosModel(txtTienda.getText()));
			}
		});
		btnPedidos.setBounds(91, 101, 168, 23);
		contentPane.add(btnPedidos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 146, 285, 104);
		contentPane.add(scrollPane);
		
		tbPedidos = new JTable();
		scrollPane.setViewportView(tbPedidos);
	}
}
