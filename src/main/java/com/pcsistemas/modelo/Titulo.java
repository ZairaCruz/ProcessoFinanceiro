package com.pcsistemas.modelo;

import java.io.Serializable;
import java.util.Date;

public class Titulo implements Serializable {

	//<f:convertDateTime pattern="d 'de' MMMM 'de' yyyy" />
	
	private static final long serialVersionUID = 1L;
	private long id;
	private int numero;
	private Date dtCriacao = new Date();
	private Date dtVencimento;
	private float vlTitulo;
	private float txJuro;
	private float vlJuro;
	private float vlDesconto;
	private Date dtPagamento;
	private float vlPago;
	private String tipo;
	private Pessoa pessoa = new Pessoa();
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Date getDtCriacao() {
		return dtCriacao;
	}
	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}
	public Date getDtVencimento() {
		return dtVencimento;
	}
	public void setDtVencimento(Date dtVencimento) {
		this.dtVencimento = dtVencimento;
	}
	public float getVlTitulo() {
		return vlTitulo;
	}
	public void setVlTitulo(float vlTitulo) {
		this.vlTitulo = vlTitulo;
	}
	public float getTxJuro() {
		return txJuro;
	}
	public void setTxJuro(float txJuro) {
		this.txJuro = txJuro;
	}
	public float getVlJuro() {
		return vlJuro;
	}
	public void setVlJuro(float vlJuro) {
		this.vlJuro = vlJuro;
	}
	public float getVlDesconto() {
		return vlDesconto;
	}
	public void setVlDesconto(float vlDesconto) {
		this.vlDesconto = vlDesconto;
	}
	public Date getDtPagamento() {
		return dtPagamento;
	}
	public void setDtPagamento(Date dtPagamento) {
		this.dtPagamento = dtPagamento;
	}
	public float getVlPago() {
		return vlPago;
	}
	public void setVlPago(float vlPago) {
		this.vlPago = vlPago;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + numero;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Titulo other = (Titulo) obj;
		if (id != other.id)
			return false;
		if (numero != other.numero)
			return false;
		return true;
	}
	
	
}
