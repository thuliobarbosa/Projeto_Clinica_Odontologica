package br.edu.libertas.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {
	
	public String convertePadraoAmericano(LocalDate data) {
		return data.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
	
	public String convertePadraoBrasileiro(LocalDate data) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
