package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProdutoController;
import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField editNomeProduto;
	private JTextField editValor;
	String nomeProduto;
	String descProduto;
	double valorProduto;
	String disponivel;
	private viewListarProdutos listaProdutos;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoController controller = new ProdutoController(); // Criei a instância do controlador aqui
		            viewCadastro frame = new viewCadastro(controller); //

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
	public viewCadastro(ProdutoController controller) {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(52, 27, 897, 654);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel txtCadastro = new JLabel("Cadastro de Produto");
		txtCadastro.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtCadastro.setBounds(353, 5, 190, 22);
		panel.add(txtCadastro);

		JLabel lblNewLabel = new JLabel("Nome do Produto:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(189, 133, 195, 13);
		panel.add(lblNewLabel);

		JLabel lblDescrioDoProduto = new JLabel("Descrição do Produto:");
		lblDescrioDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrioDoProduto.setBounds(189, 156, 195, 13);
		panel.add(lblDescrioDoProduto);

		JLabel lblValorDoProduto = new JLabel("Valor do Produto:");
		lblValorDoProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblValorDoProduto.setBounds(189, 385, 195, 13);
		panel.add(lblValorDoProduto);

		JLabel lblDisponvelParaVenda = new JLabel("Disponível para venda:");
		lblDisponvelParaVenda.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDisponvelParaVenda.setBounds(189, 408, 195, 13);
		panel.add(lblDisponvelParaVenda);

		JTextArea editDescProduto = new JTextArea();
		editDescProduto.setBounds(189, 178, 492, 197);
		panel.add(editDescProduto);

		editNomeProduto = new JTextField();
		editNomeProduto.setBounds(345, 132, 336, 19);
		panel.add(editNomeProduto);
		editNomeProduto.setColumns(10);

		editValor = new JTextField();
		editValor.setColumns(10);
		editValor.setBounds(345, 384, 336, 19);
		panel.add(editValor);

		JCheckBox checkSim = new JCheckBox("Sim");
		checkSim.setBounds(382, 404, 93, 21);
		panel.add(checkSim);

		JCheckBox checkNao = new JCheckBox("Não");
		checkNao.setBounds(503, 406, 93, 21);
		panel.add(checkNao);

		// regra de negocio checkbox ------
			checkSim.addActionListener(e -> {
				if (checkSim.isSelected()) {
					checkNao.setSelected(false);
					
				}
			});

			checkNao.addActionListener(e -> {
				if (checkNao.isSelected()) {
					checkSim.setSelected(false);
				}
			});
			
		// -------

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				nomeProduto = editNomeProduto.getText();
				descProduto = editDescProduto.getText();
				valorProduto = Double.parseDouble(editValor.getText());
				
				  if (checkSim.isSelected()) {
			            disponivel = "Sim";
			        } else if (checkNao.isSelected()) {
			            disponivel = "Não";
			        }
				  
				  
				  controller.criarProduto(nomeProduto, descProduto,valorProduto,disponivel);
			
				  
				   listaProdutos = new viewListarProdutos(controller);
				  if (listaProdutos != null) {
					  
	                    listaProdutos.atualizarTabela(); // Atualiza a tabela na instância existente
	                    dispose();
	  				  	listaProdutos.setVisible(true);
	  				
	  				
	                }
			        
				 
				 
			}
			
			
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(394, 489, 128, 50);
		panel.add(btnCadastrar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}
		});
		btnFinalizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFinalizar.setBounds(394, 549, 128, 50);
		panel.add(btnFinalizar);
		
		
	}

}
