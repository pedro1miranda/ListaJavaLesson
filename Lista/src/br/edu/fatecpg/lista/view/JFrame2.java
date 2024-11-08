package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.lista.model.Aluno;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
public class JFrame2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_nome;
	private JTextField txt_telefone;
	private static ArrayList<Aluno> listaAlunos = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame2 frame = new JFrame2();
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
	public JFrame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txt_nome = new JTextField();
		txt_nome.setToolTipText("Nome do aluno");
		txt_nome.setBounds(12, 35, 114, 19);
		contentPane.add(txt_nome);
		txt_nome.setColumns(10);
		
		txt_telefone = new JTextField();
		txt_telefone.setToolTipText("Telefone do aluno");
		txt_telefone.setBounds(12, 66, 114, 19);
		contentPane.add(txt_telefone);
		txt_telefone.setColumns(10);
		
		JButton btn_cadastrar = new JButton("Cadastrar");
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cadastrar Aluno
				String nome = txt_nome.getText();
				String telefone = txt_telefone.getText();
				if(!nome.isEmpty() && !telefone.isEmpty()) {
					listaAlunos.add(new Aluno(nome,telefone));
					JOptionPane.showMessageDialog(btn_cadastrar, "Cadastrado com sucesso");
					txt_nome.setText("");
					txt_telefone.setText("");
				}else {
					JOptionPane.showMessageDialog(btn_cadastrar, "Campos Vazios");
				}
			}
		});
		btn_cadastrar.setBounds(12, 97, 117, 25);
		contentPane.add(btn_cadastrar);
		
		JButton btn_listar = new JButton("Listar");
		btn_listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame1 frame = new JFrame1(listaAlunos);
				frame.setVisible(true);
			}
		});
		btn_listar.setBounds(163, 97, 117, 25);
		contentPane.add(btn_listar);
	}
}
