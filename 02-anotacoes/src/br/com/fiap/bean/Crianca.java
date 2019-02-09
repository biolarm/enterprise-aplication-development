package br.com.fiap.bean;

import java.util.Date;

public class Crianca extends Pessoa {

	
	@Override
	@Deprecated // obsolet method
	public void falar() {
		new Date("");
	}
	
}
