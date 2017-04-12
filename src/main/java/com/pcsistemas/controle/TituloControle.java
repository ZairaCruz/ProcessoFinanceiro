package com.pcsistemas.controle;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pcsistemas.modelo.Pessoa;
import com.pcsistemas.modelo.Titulo;
import com.pcsistemas.persistencia.TituloDao;

@ManagedBean
@SessionScoped
public class TituloControle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Titulo titulo = new Titulo();
	private Calculos calculos = new Calculos();
	
	public Titulo getTitulo() {
		return titulo;
	}
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}
	
	public List<Titulo> getListagem(){
		new TituloDao();
		return TituloDao.listaTitulos();
	}
	
	public List<Pessoa> getListagemPessoa(){
		return new PessoaControle().getListagem();
	}
	
	public String actionInserir(){
		titulo = new Titulo();
		return "formulario_titulo";
	}
	
	public String actionGravar() {
		if (titulo.getId() == 0) {
			TituloDao.inserir(titulo);
			return actionInserir();
		}else {
			TituloDao.baixar(titulo);
			return "lista_titulo?faces-redirect=true";
		}
	}
	
	public String buscarPorNumero(int numero) {
		TituloDao.buscarPorNumero(numero);
		return "formulario_baixarTitulo";
	}
	
	public String actionAlterar(Titulo t){
		titulo = t;
		return "formulario_titulo";
	}
	
	public int calcularDias(Date dtVencimento, Date dtPagamento){
		int dias = 0;
		dias = calculos.diasEntre(titulo.getDtVencimento(), titulo.getDtPagamento());
		return dias;
	}
	
	
}
