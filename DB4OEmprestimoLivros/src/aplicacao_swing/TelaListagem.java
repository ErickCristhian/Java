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
import modelo.Autor;
import modelo.Emprestimo;
import modelo.Pessoa;
import modelo.Livro;

public class TelaListagem extends JFrame {
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	
	
	
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
//
//		if(b1) {
//			button1 = new JButton("Listar todos os Livros");
//			button1.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					try{
//						ArrayList<Livro> lista = Fachada.listarLivros();
//						
//						String texto = "Listar Livros\n";
//						if (lista.isEmpty())
//							texto += "não tem Livros cadastrados\n";
//						else 
//							for(Livro p: lista) 
//								texto +=  p + "\n"; 
//	
//						textArea.setText(texto);
//					}
//					catch(Exception erro){
//						JOptionPane.showMessageDialog(null,erro.getMessage());
//					}
//				}
//			});
//			button1.setBounds(10, 179, 220, 23);
//			contentPane.add(button1);
//		}
//		
//		if(b2) {
//			button2 = new JButton("Listar todos os Autores");
//			button2.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent arg0) {
//					try{
//						String texto;
//						ArrayList<Autor> lista = Fachada.listarAutores();
//						
//						texto = "Listagem de Autores: \n";
//						if (lista.isEmpty())
//							texto += "não tem Autores cadastrados\n";
//						else 	
//							for(Autor p: lista) 
//								texto +=  p + "\n"; 
//	
//						textArea.setText(texto);
//					}
//					catch(Exception erro){
//						JOptionPane.showMessageDialog(null,erro.getMessage());
//					}
//				}
//			});
//			button2.setBounds(10, 179, 220, 23);
//			contentPane.add(button2);
//		}
//		
//		if(b3) {
//		button3 = new JButton("Listar todos os Emprestimos");
//		button3.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent arg0) {
//				try {
//					String texto;
//					ArrayList<Emprestimo> lista = Fachada.listarEmprestimo();
//					texto = "Listagem de Emprestimos: \n";
//					if(lista.isEmpty())
//						texto += "Não tem Emprestimos cadastrados\n";
//					else
//						for(Emprestimo c: lista)
//							texto += c + "\n";
//					textArea.setText(texto);
//				}
//				catch(Exception erro) {
//					JOptionPane.showMessageDialog(null, erro.getMessage());
//				}
//			}
//		});
//		button3.setBounds(10, 179, 220, 23);
//		contentPane.add(button3);
//		}
		//if(b1) {
		button4 = new JButton("Listar Todas as pessoas ");
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				try {
					String texto;
					ArrayList<Pessoa> lista = Fachada.listarPessoas();
					texto = "Listagem de Pessoas: \n";
					if(lista.isEmpty())
						texto += "Não tem pessoas cadastrados\n";
					else
						for(Pessoa c: lista)
							texto += c + "\n";
					textArea.setText(texto);
				}
				catch(Exception erro) {
					JOptionPane.showMessageDialog(null, "deu ruim");
				}
			}
		});
		button4.setBounds(10, 210, 220, 23);
		contentPane.add(button4);
		}
	//}
}