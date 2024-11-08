package br.edu.fatecpg.lista.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.fatecpg.lista.model.Aluno;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class JFrame1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame1 frame = new JFrame1(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param listaAlunos 
	 */
	public JFrame1(ArrayList<Aluno> listaAlunos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_nome = new JLabel("nome");
		lbl_nome.setBounds(101, 95, 70, 15);
		contentPane.add(lbl_nome);
		
		JLabel lbl_telefone = new JLabel("telefone");
		lbl_telefone.setBounds(101, 115, 70, 15);
		contentPane.add(lbl_telefone);
		
		JComboBox comboBox = new JComboBox<>(listaAlunos.toArray(new Aluno[0]));
		comboBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
			Aluno alunoSelecionado = (Aluno) comboBox.getSelectedItem();
			if(alunoSelecionado != null) {
				lbl_nome.setText(alunoSelecionado.getNome());
				lbl_telefone.setText(alunoSelecionado.getTelefone());
			}
			}
		});
		comboBox.setBounds(101, 59, 142, 24);
		contentPane.add(comboBox);
		
		
	}
}
