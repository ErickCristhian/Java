package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

public class TelaRemoverLivro extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRemoverLivro frame = new TelaRemoverLivro();
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
	public TelaRemoverLivro() {
		setTitle("Remover Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLivro = new JLabel("Livro:");
		lblLivro.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblLivro.setBounds(34, 56, 90, 29);
		contentPane.add(lblLivro);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		comboBox.setBounds(160, 58, 158, 27);
		contentPane.add(comboBox);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setForeground(Color.BLUE);
		btnRemover.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnRemover.setBounds(160, 202, 115, 38);
		contentPane.add(btnRemover);
	}

}
