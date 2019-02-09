package br.com.fiap.teste;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.anotacao.Coluna;
import br.com.fiap.anotacao.Tabela;
import br.com.fiap.bean.Pessoa;

public class Teste {

	
	public static void main(String[] args) {
		
		//instanciar uma pessoa
		Pessoa p = new Pessoa();
		
		//API Refletcion -> obter o nome da classe
		String nome = p.getClass().getName();
		System.out.println(nome);
		
		//obter os metodos da classe
		Method[] methods = p.getClass().getMethods();
		
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
		
		//Obter os atributos da classe
		Field[] atributos = p.getClass().getDeclaredFields();
		System.out.println("ATRIBUTOS");
		for (int i = 0; i < atributos.length; i++){
			System.out.println(atributos[i].getName());
			
			//recuperar a anotação @Coluna
			
			Coluna anotacao =
					atributos[i].getAnnotation(Coluna.class);
			System.out.println("Nome: " + anotacao.nome());
			System.out.println("Tipo: " + anotacao.tipo());
			System.out.println("Tamanho: " + anotacao.tamanho());
		}
	
	//obter tabela que referencia a classe
		Tabela tabela = p.getClass().getAnnotation(Tabela.class);
		
		System.out.println("SELECT * FROM " + tabela.nome());
	}
	
}
