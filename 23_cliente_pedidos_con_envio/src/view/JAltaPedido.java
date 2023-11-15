package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Pedido;
import service.PedidosService;
import service.PedidosServiceFactory;

public class JAltaPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtProducto;
	private JTextField txtTienda;
	private JTextField txtFecha;
	private JTextField txtPrecio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JAltaPedido frame = new JAltaPedido();
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
	public JAltaPedido() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Producto:");
		lblNewLabel.setBounds(51, 31, 72, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblTienda = new JLabel("Tienda:");
		lblTienda.setBounds(51, 65, 72, 19);
		contentPane.add(lblTienda);
		
		JLabel lblFechaPedido = new JLabel("Fecha pedido:");
		lblFechaPedido.setBounds(51, 101, 109, 19);
		contentPane.add(lblFechaPedido);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(51, 142, 72, 19);
		contentPane.add(lblPrecio);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(147, 30, 86, 20);
		contentPane.add(txtProducto);
		txtProducto.setColumns(10);
		
		txtTienda = new JTextField();
		txtTienda.setColumns(10);
		txtTienda.setBounds(147, 64, 86, 20);
		contentPane.add(txtTienda);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(147, 100, 86, 20);
		contentPane.add(txtFecha);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(147, 141, 86, 20);
		contentPane.add(txtPrecio);
		
		JButton btnEnviar = new JButton("Enviar pedido");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PedidosService service =PedidosServiceFactory.getPedidosService();
				Pedido pedido=new Pedido(0, 
						txtProducto.getText(), 
						txtTienda.getText(), 
						LocalDate.parse(txtFecha.getText()), 
						Double.parseDouble(txtPrecio.getText()));
				service.altaPedido(pedido);
			}
		});
		btnEnviar.setBounds(144, 212, 134, 23);
		contentPane.add(btnEnviar);
	}
}
