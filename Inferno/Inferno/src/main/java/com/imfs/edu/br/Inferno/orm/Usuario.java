package com.imfs.edu.br.Inferno.orm;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 3)
	private String nome;

	@CPF
	private String cpf;

	@Basic
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@Email
	private String email;
	
	@Max(value = 5)
	@Min(value = 0) 
	private double pontos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPontos() {
		return pontos;
	}

	public void setPontos(double pontos) {
		this.pontos = pontos;
	}

	public Usuario(Long id, String nome, String cpf, Date dataNascimento, String email, double pontos) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.pontos = pontos;
	}
	public Usuario() {
		
	}

	@Override
	public String toString() {
		return "usuario [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + ", pontos=" + pontos + "]";
	}

}
