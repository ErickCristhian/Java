package swing;
/* IFPB 
 * Autor: Erick Cristhian
 * Matrícula: 20171370035*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;


public class Calculadora {
	private static JLabel label;
	private static JLabel label_1;
	private static JLabel label_2;
	private static JTextField tfPrimeiro;
	private static JTextField tfSegundo;
	private static JButton button;
	private static JButton button_1;
	private static JButton button_2;
	private static JButton button_3;
	private static JLabel label_3;
	private static JButton button_4;
	private static JTextArea taHistorico;
	private static List<String> historico = new ArrayList<String>();

   public static void main(String[] args) {
      
      JFrame f = new JFrame("A JFrame");
      f.setSize(483, 380);
      f.setLocation(300,200);
      f.getContentPane().setLayout(null);
      
      
      taHistorico = new JTextArea();
      taHistorico.setBounds(34, 229, 399, 52);
      f.getContentPane().add(taHistorico);
      
      label = new JLabel("Calculadora");
      label.setFont(new Font("Tahoma", Font.PLAIN, 15));
      label.setBounds(192, 11, 101, 14);
      f.getContentPane().add(label);
      
      label_1 = new JLabel("Primeiro N\u00FAmero");
      label_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
      label_1.setBounds(53, 61, 113, 14);
      f.getContentPane().add(label_1);
      
      label_2 = new JLabel("Segundo N\u00FAmero");
      label_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
      label_2.setBounds(315, 61, 118, 14);
      f.getContentPane().add(label_2);
      
      tfPrimeiro = new JTextField();
      tfPrimeiro.setBounds(53, 86, 113, 20);
      f.getContentPane().add(tfPrimeiro);
      tfPrimeiro.setColumns(10);
      
      tfSegundo = new JTextField();
      tfSegundo.setBounds(315, 86, 118, 20);
      f.getContentPane().add(tfSegundo);
      tfSegundo.setColumns(10);
      
      button = new JButton("+");
      button.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		int i = Integer.parseInt(tfPrimeiro.getText()) + Integer.parseInt(tfSegundo.getText());
      		historico.add("\n" + i);
      		taHistorico.setText(historico.toString());
      	}
      });
      button.setFont(new Font("Tahoma", Font.PLAIN, 15));
      button.setBounds(37, 151, 89, 23);
      f.getContentPane().add(button);
      
      button_1 = new JButton("-");
      button_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		int i = Integer.parseInt(tfPrimeiro.getText()) - Integer.parseInt(tfSegundo.getText());
      		historico.add("\n" + i);
      		taHistorico.setText(historico.toString());
      	}
      });
      button_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
      button_1.setBounds(136, 151, 89, 23);
      f.getContentPane().add(button_1);
      
      button_2 = new JButton("/");
      button_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		int i = Integer.parseInt(tfPrimeiro.getText()) / Integer.parseInt(tfSegundo.getText());
      		historico.add("\n" + i);
      		taHistorico.setText(historico.toString());
      	}
      });
      button_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
      button_2.setBounds(235, 151, 89, 23);
      f.getContentPane().add(button_2);
      
      button_3 = new JButton("*");
      button_3.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		int i = Integer.parseInt(tfPrimeiro.getText()) * Integer.parseInt(tfSegundo.getText());
      		historico.add("\n" + i);
      		taHistorico.setText(historico.toString());
      	}
      });
      button_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
      button_3.setBounds(334, 151, 89, 23);
      f.getContentPane().add(button_3);
      
      label_3 = new JLabel("Hist\u00F3rico");
      label_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
      label_3.setBounds(37, 207, 89, 14);
      f.getContentPane().add(label_3);
      
      button_4 = new JButton("Limpar");
      button_4.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		tfPrimeiro.setText("");
      		tfSegundo.setText("");
      	}
      });
      button_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
      button_4.setBounds(193, 307, 89, 23);
      f.getContentPane().add(button_4);

      
    }
}