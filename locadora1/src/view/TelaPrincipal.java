package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import model.Caminhao;
import model.Carro;
import model.Cliente;
import model.Moto;
import model.Veiculo;

public class TelaPrincipal {
	private List<Veiculo> veiculos = new ArrayList<>();
	private Map<Veiculo, Cliente> alugueis = new HashMap<>();

	public TelaPrincipal() {
		veiculos.add(new Carro("Fiat Marea Turbo", "OXN-1234"));
		veiculos.add(new Moto("Honda NXR BROS 160", "AAS-5678"));
		veiculos.add(new Caminhao("Mercedes-Benz L16-20", "JKL-9999"));
	}

	public void iniciarInterface() {
		JFrame frame = new JFrame("Locadora de Veículos");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 450);

		DefaultListModel<Veiculo> listaModel = new DefaultListModel<>();
		veiculos.forEach(listaModel::addElement);
		JList<Veiculo> listaVeiculos = new JList<>(listaModel);
		JScrollPane scrollPane = new JScrollPane(listaVeiculos);

		JButton alugarBtn = new JButton("Alugar Selecionado");
		JButton devolverBtn = new JButton("Devolver Selecionado");

		alugarBtn.addActionListener(e -> locacao(listaVeiculos, true));
		devolverBtn.addActionListener(e -> locacao(listaVeiculos, false));

		JPanel panel = new JPanel();
		panel.add(alugarBtn);
		panel.add(devolverBtn);

		frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
		frame.getContentPane().add(BorderLayout.SOUTH, panel);

		frame.setVisible(true);
	}

	private void locacao(JList<Veiculo> listaVeiculos, boolean alugar) {
		Veiculo veiculo = listaVeiculos.getSelectedValue();
		if (veiculo != null) {
			if (alugar && veiculo.disponivel) {
				String nome = JOptionPane.showInputDialog("Nome do cliente: ");
				String cpf = JOptionPane.showInputDialog("CPF: : ");
				String numero = JOptionPane.showInputDialog("Telefone/Celular: ");
				String email = JOptionPane.showInputDialog("Email: ");
				String diasStr = JOptionPane.showInputDialog("Dias: ");
				try {
					int dias = Integer.parseInt(diasStr);
					double custo = veiculo.custoLocacao(dias);
					veiculo.disponivel = false;
					Cliente cliente = new Cliente(nome, cpf, numero, email);
					alugueis.put(veiculo, cliente);
					JOptionPane.showMessageDialog(null,
							"Veículo alugado para " + cliente + " por " + dias + " dias.\nCusto total: R$ " + custo);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Número de dias digitado é inválido.");
				}
			} else if (!alugar && !veiculo.disponivel) {
				Cliente cliente = alugueis.get(veiculo);
				veiculo.disponivel = true;
				alugueis.remove(veiculo);
				JOptionPane.showMessageDialog(null, "Veículo devolvido com sucesso!\nCliente: " + cliente);
			} else {
				JOptionPane.showMessageDialog(null, alugar ? "Veículo já está alugado!" : "Veículo está disponível!");
			}
			listaVeiculos.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Selecione um veículo para continuar.");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new TelaPrincipal().iniciarInterface());
	}
}
