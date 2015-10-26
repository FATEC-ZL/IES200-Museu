package view;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import controller.MaterialController;
import controller.RegisSetorController;


public class FormMaterial extends JFrame {

	static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> cbCategoria;
	private JTextField txtMaterial;
	private JTextField id_material;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormMaterial frame = new FormMaterial();
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
	public FormMaterial() {
		setTitle("Registrar Material - MASP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 540, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdMaterial = new JLabel("ID Material");
		lblIdMaterial.setBounds(93, 35, 75, 16);
		contentPane.add(lblIdMaterial);

		JLabel lblCategoria = new JLabel("Categoria da Obra");
		lblCategoria.setBounds(50, 70, 117, 16);
		contentPane.add(lblCategoria);
		
		cbCategoria = new JComboBox<String>();
		cbCategoria.setBounds(179, 65, 178, 28);
		contentPane.add(cbCategoria);

		
		txtMaterial = new JTextField();
		/*txtMaterial.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtMaterial.setText(null);  //limpa a caixa de texto
			}
		});*/
		txtMaterial.setToolTipText("Digite o novo material…");
		txtMaterial.setText("Digite o novo material…");
		txtMaterial.setBounds(179, 110, 178, 28);
		contentPane.add(txtMaterial);
		txtMaterial.setColumns(10);
		
		JLabel msgGravado = new JLabel("");
		msgGravado.setIcon(new ImageIcon("../MASProject/icons/ok.png"));
		msgGravado.setBounds(43, 177, 230, 23);
		msgGravado.setVisible(false);
		contentPane.add(msgGravado);

		JLabel msgVazio = new JLabel("CAMPO VAZIO!");
		msgVazio.setIcon(new ImageIcon("../MASProject/icons/delete.png"));
		msgVazio.setBounds(43, 177, 192, 23);
		msgVazio.setVisible(false);
		contentPane.add(msgVazio);

		JButton btnGravar = new JButton("Gravar");
		btnGravar.setIcon(new ImageIcon("../MASProject/icons/save.png"));
		btnGravar.setBounds(288, 166, 97, 34);
		contentPane.add(btnGravar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.setIcon(new ImageIcon("../MASProject/icons/ok.png"));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		btnFechar.setBounds(397, 166, 97, 34);
		contentPane.add(btnFechar);
		
		
		id_material = new JTextField();
		id_material.setEditable(false);
		id_material.setBounds(180, 33, 86, 20);
		contentPane.add(id_material);
		id_material.setColumns(10);
		
		
		MaterialController ctrlMaterial = new MaterialController(cbCategoria,id_material, txtMaterial, btnGravar, msgGravado, msgVazio);

		cbCategoria.addComponentListener(ctrlMaterial);
		txtMaterial.addMouseListener(ctrlMaterial.limpaCampo);
		txtMaterial.addActionListener(ctrlMaterial.gravarMaterial);
		btnGravar.addActionListener(ctrlMaterial.gravarMaterial);
	}
}
