package controller;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Categoria;

public class RegisCategObraController {

	private JLabel lblMensagemGravado, lblMensagemVazio;
	private JTextField tfNomeCategoria, tfidCategoria;
	private JButton btnGravar;

	private Categoria categoria = new Categoria();
	private static int contador = 1;
	
	public RegisCategObraController( JLabel lblMensagemGravada, JLabel lblMensagemVazio, JButton btnGravar, JTextField tfIdCategoria, JTextField tfNomeCategoria){
		this.lblMensagemGravado = lblMensagemGravada;
		this.lblMensagemVazio = lblMensagemVazio;
		this.tfidCategoria = tfIdCategoria;
		this.tfNomeCategoria = tfNomeCategoria;
		this.btnGravar = btnGravar;
	}
	
	public void gravaSetor() {
		ArquivosController arqController = new ArquivosController();
		// Falta implementar
		// setor.setIdentificacao(idsetor.getText());
		categoria.setNome(tfNomeCategoria.getText());
		//se o campo n�o estiver vazio
		if (!tfNomeCategoria.getText().isEmpty()) {
			try {
				arqController.escreveArquivo("../MASProject/dados/", "categorias", tfNomeCategoria.getText(), categoria);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lblMensagemGravado.setText(tfNomeCategoria.getText()+" salvo com sucesso!!!");
			lblMensagemGravado.setVisible(true);
		}else{
			lblMensagemGravado.setVisible(false);
			lblMensagemVazio.setVisible(true);
		}
		// implementar a acao de apagar o campo de nome e criar uma nova id
		// quando clicar em gravar
	}

	public ActionListener gravarSetor = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			gravaSetor();
		}
	};

	public MouseListener limpaCampo = new MouseListener() {

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			//se for clicado pela primeira vez o campo fica limpo para preencher com o nome do setor
			if (contador == 1) {
				tfNomeCategoria.setText("");
				contador += 1;
			}
			//para que a mensagem n�o fique visivel a todo momento
			lblMensagemGravado.setVisible(false);
            lblMensagemVazio.setVisible(false);
		}
	};
	
}