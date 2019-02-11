package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="TB_PASTEL")//NÃO E OBRIGATORIO, ALTERA O NOME DA TABELA

//name: nome no java(generator, sequenceName: nome no banco
//allocationSize: passo(de um em um))
@SequenceGenerator(name="pastel",sequenceName="SQ_TB_PASTEL", allocationSize=1)
public class Pastel {

	@Id
	@GeneratedValue(generator="pastel", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_sabor", nullable = false, length = 50)
	private String sabor;
	
	@Column(name = "vl_preco", nullable = false)
	private float preco;
	
	@Column(name = "is_especial")
	private boolean especial;
	
	@Column(name="ds_massa")
	@Enumerated(EnumType.STRING) //grava a constante no banco e nao a ordem
	private Massa massa;
	
	@CreationTimestamp //gera a data de cadastro automaticamente
	private Calendar dataCadastro;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataPedido;
	
	@Transient //nao sera uma coluna no banco
	private int numeroComanda;
	
	@Lob //campo para arquivo
	private byte[] foto;
	
	
}
