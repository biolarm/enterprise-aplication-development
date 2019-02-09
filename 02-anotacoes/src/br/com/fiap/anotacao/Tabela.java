package br.com.fiap.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)//
@Target(ElementType.TYPE)//anota��o s� para atributos 
public @interface Tabela {
	String nome();
}
