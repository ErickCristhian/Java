package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import fachada.Fachada;


@SuppressWarnings("serial")
public class TelaCadastroLivro extends JFrame{

	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblExemplares;
	private JLabel lblEndereco;
	private JLabel lblmsg;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroContato frame = new TelaCadastroContato();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCadastroLivro() throws ParseException {
		setTitle("Cadastrar Pessoa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextField textField = new JTextField();
		textField.setBounds(72, 14, 62, 14);
		contentPane.add(textField);
		textField.setColumns(10);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 14, 62, 14);
		contentPane.add(lblTitulo);
		
		JTextField textField2 = new JTextField();
		textField2.setBounds(72, 49, 180, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		lblExemplares = new JLabel("Exemplares");
		lblExemplares.setBounds(10, 49, 62, 14);
		contentPane.add(lblExemplares);
		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try{
								String titulo = textField.getText();
								int exemplares = Integer.parseInt(textField2.getText());
								System.out.println("funcionando...");
								Fachada.cadastrarLivro(titulo, exemplares);
								
								lblmsg.setText("cadastrado ");
								textField.setText("");
								textField2.setText("");
								
								textField.requestFocus();
							}
							catch(Exception erro){
								lblmsg.setText(erro.getMessage());
			
							}
			}
		});
		btnCriar.setBounds(72, 250, 115, 23);
		contentPane.add(btnCriar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 294, 233, 14);
		contentPane.add(lblmsg);
	}

}
