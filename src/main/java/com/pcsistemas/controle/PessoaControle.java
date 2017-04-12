package com.pcsistemas.controle;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pcsistemas.modelo.Pessoa;
import com.pcsistemas.persistencia.PessoaDao;

@ManagedBean
@SessionScoped
public class PessoaControle implements Serializable{

	private static final long serialVersionUID = 1L;
	private Pessoa pessoa = new Pessoa();
		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getListagem(){
		return PessoaDao.listaPessoas();
	}
	
	public String actionInserir(){
		pessoa = new Pessoa();
		return "formulario_pessoa";
	}
	
	public String actionGravar() {
		if (pessoa.getId() == 0) {
			PessoaDao.inserir(pessoa);
			return actionInserir();
		}else {
			PessoaDao.alterar(pessoa);
			return "lista_pessoa";
		}
	}
	
//	public String actionExcluir(Pessoa pessoa){
//		PessoaDao.inativar(pessoa);
//		return "lista_pessoa";
//	}
	
	public String actionAlterar(Pessoa p){
		pessoa = p;
		return "formulario_pessoa";
	}
	
	public Pessoa buscarCpnj(String cnpj){
		return PessoaDao.cnpj(cnpj);
	}
	
//	public String actionTitulo(String cnpj){
//		PessoaDao.buscarCnpjFavorecido(cnpj);
//		return "formulario_titulo";
//	}
}
