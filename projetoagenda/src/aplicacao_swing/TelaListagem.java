package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Compromissos;
import modelo.Contato;
import modelo.Telefone;

public class TelaListagem extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JTextField text1;
	private JTextField text2;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_grau;
	private int[] grau = Fachada.grau();
	private String[] tipos = Fachada.tiposComp();
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_tipo;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaListagem frame = new TelaListagem();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaListagem(boolean b1, boolean b2, boolean b3, boolean b4, boolean b5) {
		
		setTitle("Listagem");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 342);		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textArea = new JTextArea();		
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(24, 29, 510, 140);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		contentPane.add(scroll);

		if(b1) {
			button1 = new JButton("Listar todos os  Contatos");
			button1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try{
						ArrayList<Contato> lista = Fachada.listarContatos();
						
						String texto = "Listar contatos\n";
						if (lista.isEmpty())
							texto += "não tem contato cadastrada\n";
						else 
							for(Contato p: lista) 
								texto +=  p + "\n"; 
	
						textArea.setText(texto);
					}
					catch(Exception erro){
						JOptionPane.showMessageDialog(null,erro.getMessage());
					}
				}
			});
			button1.setBounds(10, 179, 220, 23);
			contentPane.add(button1);
		}
		
		if(b2) {
			button2 = new JButton("Listar todos os Telefones");
			button2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try{
						String texto;
						ArrayList<Telefone> lista = Fachada.listarTelefones();
						
						texto = "Listagem de telefones: \n";
						if (lista.isEmpty())
							texto += "não tem telefones cadastrados\n";
						else 	
							for(Telefone p: lista) 
								texto +=  p + "\n"; 
	
						textArea.setText(texto);
					}
					catch(Exception erro){
						JOptionPane.showMessageDialog(null,erro.getMessage());
					}
				}
			});
			button2.setBounds(10, 179, 220, 23);
			contentPane.add(button2);
		}
		
		if(b3) {
		button3 = new JButton("Listar todos os Compromissos");
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Compromissos> lista = Fachada.listarCompromissos();
					texto = "Listagem de Compromissos: \n";
					if(lista.isEmpty())
						texto += "Não tem compromissos cadastrados\n";
					else
						for(Compromissos c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		button3.setBounds(10, 179, 220, 23);
		contentPane.add(button3);
		}
		if(b1) {
		button4 = new JButton("Listar Contato por nome: ");
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Contato> lista = Fachada.listarContatosPorNome(text1.getText());
					texto = "Listagem de Compromissos por nome: \n";
					if(lista.isEmpty())
						texto += "Não tem compromissos cadastrados\n";
					else
						for(Contato c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		button4.setBounds(10, 210, 220, 23);
		contentPane.add(button4);
		text1 = new JTextField("Digite o nome do contato");
		text1.setBounds(250, 210, 220, 23);
		contentPane.add(text1);
		
		button5 = new JButton("Listar Contato por telefone: ");
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Contato> lista = Fachada.listarContatosPorTelefone(text2.getText());
					texto = "Listagem de Contatos: \n";
					if(lista.isEmpty())
						texto += "Não tem contatos cadastrados\n";
					else
						for(Contato c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		button5.setBounds(10, 241, 220, 23);
		text2 = new JTextField("Digite o telefone do contato");
		text2.setBounds(250, 241, 220, 23);
		contentPane.add(button5);
		contentPane.add(text2);
		
		button6 = new JButton("Listar Contato por proximidade: ");
		button6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Contato> lista = Fachada.listarContatosPorProximidade(comboBox_grau.getSelectedIndex());
					texto = "Listagem de Contatos: \n";
					if(lista.isEmpty())
						texto += "Não tem contatos cadastrados\n";
					else
						for(Contato c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		button6.setBounds(10, 272, 220, 23);
		comboBox_grau = new JComboBox();
		comboBox_grau.setBounds(250, 272, 220, 23);
		for(int i = 0; i < grau.length; i++) {
			comboBox_grau.addItem(grau[i]);
		}
		contentPane.add(comboBox_grau);
		contentPane.add(button6);
		}
		if(b3) {
		button7 = new JButton("Listar Compromisso por nome: ");
		button7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Compromissos> lista = Fachada.listarCompromissosPorNome(text1.getText());
					texto = "Listagem de Compromissos: \n";
					if(lista.isEmpty())
						texto += "Não tem compromissos cadastrados\n";
					else
						for(Compromissos c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		button7.setBounds(10, 210, 220, 23);
		text1 = new JTextField("Digite o nome do compromisso");
		text1.setBounds(250, 210, 220, 23);
		contentPane.add(button7);
		contentPane.add(text1);
		
		button8 = new JButton("Listar Compromisso por data: ");
		button8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Compromissos> lista = Fachada.listarCompromissos();
					texto = "Listagem de Compromissos: \n";
					if(lista.isEmpty())
						texto += "Não tem compromissos cadastrados\n";
					else
						for(Compromissos c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		button8.setBounds(10, 241, 220, 23);
		text2 = new JTextField("Digite a data do compromisso");
		text2.setBounds(250, 241, 220, 23);
		contentPane.add(button8);
		contentPane.add(text2);
		
		
		button9 = new JButton("Listar Compromisso por tipo: ");
		button9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Compromissos> lista = Fachada.listarCompromissosPorTipo(comboBox_tipo.getSelectedItem().toString());
					texto = "Listagem de Compromissos: \n";
					if(lista.isEmpty())
						texto += "Não tem compromissos cadastrados\n";
					else
						for(Compromissos c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
			}
		});
		button9.setBounds(10, 272, 220, 23);
		contentPane.add(button9);
		
		comboBox_tipo = new JComboBox();
		comboBox_tipo.setBounds(250, 272, 220, 23);
		for(int i = 0; i < tipos.length; i++) {
			comboBox_tipo.addItem(tipos[i]);
		}
		
		contentPane.add(comboBox_tipo);
		if(b4) {
			try{
					ArrayList<Contato> lista = Fachada.listarContatos();
					
					String texto = "Listar contatos\n";
					if (lista.isEmpty())
						texto += "não tem contato cadastrada\n";
					else 
						for(Contato p: lista) 
							texto +=  p + "\n"; 

					textArea.setText(texto);
				}
				catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		if(b5) {
			try{
				String texto;
				ArrayList<Telefone> lista = Fachada.listarTelefones();
				
				texto = "Listagem de telefones: \n";
				if (lista.isEmpty())
					texto += "não tem telefones cadastrados\n";
				else 	
					for(Telefone p: lista) 
						texto +=  p + "\n"; 

				textArea.setText(texto);
			}
			catch(Exception erro){
				JOptionPane.showMessageDialog(null,erro.getMessage());
			}

		}
		}
	}
}
