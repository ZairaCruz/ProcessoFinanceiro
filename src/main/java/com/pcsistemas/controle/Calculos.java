package com.pcsistemas.controle;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.pcsistemas.modelo.Pessoa;
import com.pcsistemas.modelo.Titulo;

@ManagedBean
@SessionScoped
public class Calculos implements Serializable{

	private static final long serialVersionUID = 1L;

	public int diasEntre(Date dtVencimento, Date dtPagamento){ 
        Calendar vencimento = Calendar.getInstance(); 
        vencimento.setTime(dtVencimento);
        Calendar atual = Calendar.getInstance();
        atual.setTime(dtPagamento);
        int dias = 0;    
        while (vencimento.get(Calendar.DAY_OF_MONTH) != atual.get(Calendar.DAY_OF_MONTH)){    
        	   vencimento.add(Calendar.DAY_OF_MONTH, 1);    
            dias ++;    
        }    
        return dias;   
    }
	
	public float taxaJuros(float vlTaxa){
		float taxa = 0;
		taxa = vlTaxa / 100;
		return taxa;
	}
	
	public float valorJuros(float vlTitulo, float vlTaxa){
		
		
		
		return 0;
	}
	
//	public int calcularPeriodo(Titulo titulo) {
//		int periodo;
//		Calendar vencimento = Calendar.getInstance();
//		vencimento.setTime(new Date(titulo.getDtVencimento().getTime()));
//		Calendar dataAtual = Calendar.getInstance();
//		dataAtual.setTime(new Date());
//		int diaVencimento = vencimento.get(Calendar.DAY_OF_MONTH);
//		int mesVencimento = vencimento.get(Calendar.MONTH) + 1;
//		int anoVencimento = vencimento.get(Calendar.YEAR);
//		int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);
//		int mesAtual = dataAtual.get(Calendar.MONTH) + 1;
//		int anoAtual = dataAtual.get(Calendar.YEAR);
//		periodo = (anoAtual - anoVencimento) * 12;
//		
//		if (periodo > 0) {
//			mesVencimento = 12 - mesVencimento;
//		}
//		if (periodo < 12) {
//			periodo = mesVencimento - mesAtual;
//			if (periodo < 0) {
//				periodo *= -1;
//			}
//		} else {
//			if (periodo == 12) {
//				periodo = mesVencimento + mesAtual;
//			} else {
//				periodo += (mesVencimento + mesAtual) - 12;
//			}
//		}
//		return periodo;
//	}
//	
}
