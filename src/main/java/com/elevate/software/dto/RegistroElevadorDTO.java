package com.elevate.software.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegistroElevadorDTO {
	private Character elevador;
	private List<Character> turno;
}
