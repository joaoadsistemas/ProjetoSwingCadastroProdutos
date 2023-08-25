package view;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ProdutoController;
import model.Produto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JList;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewListarProdutos extends JFrame {

	private JPanel contentPane;
	ProdutoController controller;
	private JTable txtTable;
    private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewListarProdutos frame = new viewListarProdutos(null);
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

    public viewListarProdutos(ProdutoController controller) {
        this.controller = controller;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Configuração da janela e da tabela
        // ...
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1009, 783);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        JButton finalizarButton = new JButton("Finalizar");
        finalizarButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        JButton novoCadastroButton = new JButton("Novo Cadastro");
        novoCadastroButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		new viewCadastro(controller).setVisible(true);
        		dispose();
        		
        		
        	}
        });

        // Adicionar os botões ao JPanel
        buttonPanel.add(finalizarButton);
        buttonPanel.add(novoCadastroButton);

        // Adicionar o JPanel de botões ao final do contentPane usando BorderLayout
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Criação do JScrollPane para a JTable
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(58, 27, 887, 656);
        getContentPane().add(scrollPane);

        // Criação da JTable
        table = new JTable();
        scrollPane.setViewportView(table);

        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Valor");
        model.addColumn("Disponível");

        table.setModel(model); // Define o modelo da tabela
    }
    
    public void atualizarTabela() {
        // Limpa a tabela e preenche com os produtos da lista
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Limpa os dados da tabela

        List<Produto> produtos = controller.getProdutos();
        for (Produto produto : produtos) {
            // Adicione cada produto como uma nova linha na tabela
            model.addRow(new Object[] {
                produto.getNomeProduto(),
                produto.getValorProduto(),
                produto.isDisponivel()
            });
        }
    }

}
