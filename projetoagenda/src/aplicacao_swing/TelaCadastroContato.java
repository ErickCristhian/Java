package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import fachada.Fachada;
import modelo.Contato;

public class TelaCadastroContato extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JFormattedTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JComboBox comboBox_grau;
	private JFormattedTextField textField7;
	private JFormattedTextField textField8;
	private int[] grau = Fachada.grau();
	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblCep;
	private JLabel lblNumero;
	private JLabel lblLink;
	private JLabel lblGrau;
	private JLabel lblDia;
	private JLabel lblMes;
	private JButton btnCriar;
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
	public TelaCadastroContato() throws ParseException {
		setTitle("Cadastrar Contato");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		MaskFormatter maskCep = new MaskFormatter("#####-###");
		maskCep.setPlaceholderCharacter('_');
		
		MaskFormatter maskDia = new MaskFormatter("##");
		maskDia.setPlaceholderCharacter('_');
		
		MaskFormatter maskMes = new MaskFormatter("##");
		maskMes.setPlaceholderCharacter('_');

		textField = new JTextField();
		textField.setBounds(72, 11, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("nome");
		lblNome.setBounds(10, 14, 62, 14);
		contentPane.add(lblNome);
		
		textField2 = new JTextField();
		textField2.setBounds(72, 46, 180, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 49, 62, 14);
		contentPane.add(lblEmail);
		
		textField3 = new JFormattedTextField(maskCep);
		textField3.setBounds(72, 81, 180, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 84, 62, 14);
		contentPane.add(lblCep);
		
		textField4 = new JTextField();
		textField4.setBounds(72, 116, 180, 20);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(10, 119, 62, 14);
		contentPane.add(lblNumero);
		
		textField5 = new JTextField();
		textField5.setBounds(72, 151, 180, 20);
		contentPane.add(textField5);
		textField5.setColumns(10);
		
		lblLink = new JLabel("Facebook");
		lblLink.setBounds(10, 154, 62, 14);
		contentPane.add(lblLink);
		
		comboBox_grau = new JComboBox();
		comboBox_grau.setBounds(72, 186, 180, 20);
		for(int i = 0; i < grau.length; i++) {
			comboBox_grau.addItem(grau[i]);
		}
		
		contentPane.add(comboBox_grau);
		
		
		lblGrau = new JLabel("Grau");
		lblGrau.setBounds(10, 189, 62, 14);
		contentPane.add(lblGrau);
		
		textField7 = new JFormattedTextField(maskDia);
		textField7.setBounds(72, 221, 180, 20);
		contentPane.add(textField7);
		textField7.setColumns(10);
		
		lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 224, 62, 14);
		contentPane.add(lblDia);
		
		textField8 = new JFormattedTextField(maskMes);
		textField8.setBounds(72, 256, 180, 20);
		contentPane.add(textField8);
		textField8.setColumns(10);
		
		lblMes = new JLabel("Mês");
		lblMes.setBounds(10, 259, 62, 14);
		contentPane.add(lblMes);
		
		

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Pattern padraoEmail = Pattern.compile(
								"^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9a-zA-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$"
						);
						Matcher alvo = padraoEmail.matcher(textField2.getText());
						Pattern padraoNumero = Pattern.compile("[0-9]+");
						Matcher alvo2 = padraoNumero.matcher(textField4.getText());
						if(!alvo.matches()) {
							lblmsg.setText("Email Inválido");
						}
						else if(!alvo2.matches()){
							lblmsg.setText("Numero Inválido");
						}else {
							try{
								String nome = textField.getText();
								String email = textField2.getText();
								String cep = textField3.getText();
								String numero = textField4.getText();
								String link = textField5.getText();
								int grau = (int) comboBox_grau.getSelectedItem();
								int dia = Integer.parseInt(textField7.getText());
								int mes = Integer.parseInt(textField8.getText());
								
								
								Contato pt = Fachada.cadastrarContato(nome, email, cep, numero, link, grau, dia, mes);
								
								lblmsg.setText("cadastrado ");
								textField.setText("");
								textField2.setText("");
								textField3.setText("");
								textField4.setText("");
								textField5.setText("");
								comboBox_grau.setSelectedIndex(0);
								textField7.setText("");
								textField8.setText("");
								
								textField.requestFocus();
							}
							catch(Exception erro){
								lblmsg.setText(erro.getMessage());
			
							}
			}
			}
		});
		btnCriar.setBounds(72, 350, 115, 23);
		contentPane.add(btnCriar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 294, 233, 14);
		contentPane.add(lblmsg);
	}
}
