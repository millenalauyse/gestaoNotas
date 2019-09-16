package com.accenture.model;

public class Avaliacao {
	int codMatricula;
	String nota1;
	String nota2;
	String nota3;
	double mediaponderada;
	double notafinal;
	
	
public double getNotafinal() {
		return notafinal;
	}
	public void setNotafinal(double notafinal) {
		this.notafinal = notafinal;
	}
public double getMediaponderada() {
		return mediaponderada;
	}
	public void setMediaponderada(double mediaponderada2) {
		this.mediaponderada = mediaponderada2;
	}

	public int getCodMatricula() {
		return codMatricula;
	}
	public void setCodMatricula(int codMatriculaInt) {
		this.codMatricula = codMatriculaInt;
	}
	public String getNota1() {
		return nota1;
	}
	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}
	public String getNota2() {
		return nota2;
	}
	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}
	public String getNota3() {
		return nota3;
	}
	public void setNota3(String nota3) {
		this.nota3 = nota3;
	}
	

}
