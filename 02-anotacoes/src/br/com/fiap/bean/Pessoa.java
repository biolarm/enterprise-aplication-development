package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;

@Tabela(nome="PESSOA")
public class Pessoa {
	
	@Coluna(nome="nm_pessoa", tipo="VARCHA2")
	private String nome;

	@Coluna(nome="dt_nascimento", tipo="DATE")
	private Calendar dataNasacimento;
	
	@Coluna(nome="vl_pessoa", tipo="NUMBER")
	private float peso;
	
	
	@SuppressWarnings("all")
	public void falar() {
		int idade;
	}
	
	
	//GETS AND SETS 
	public String getNome() {
		return nome;
	}
	
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Calendar getDataNasacimento() {
		return dataNasacimento;
	}
	
	
	public void setDataNasacimento(Calendar dataNasacimento) {
		this.dataNasacimento = dataNasacimento;
	}
	
	
	public float getPeso() {
		return peso;
	}
	
	
	public void setPeso(float peso) {
		this.peso = peso;
	}

}
