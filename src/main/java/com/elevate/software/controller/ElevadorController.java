package com.elevate.software.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elevate.software.dto.RegistroElevadorDTO;
import com.elevate.software.service.IElevadorService;


@RestController
@RequestMapping("/elevadores")
public class ElevadorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ElevadorController.class);

	private final IElevadorService service;

	public ElevadorController(IElevadorService service) {
		super();
		this.service = service;
	}

	
	@GetMapping("/andarMenosUtilizado")
	
	public List<Integer> getandarMenosUtilizado() {
		List<Integer> resultado = service.andarMenosUtilizado();

		LOGGER.info("Consulta concluida ! Resultado {} ", resultado);

		return service.andarMenosUtilizado();
	}

	@GetMapping("/elevadorMaisUtilizadocomPeriodo")
	public List<RegistroElevadorDTO> getperiodoMaiorFluxoElevadorMaisFrequentado() {
		List<Character> elevadorMaisutilizado = service.elevadorMaisFrequentado();
		List<RegistroElevadorDTO> elevadormaiorComperiodo = new ArrayList<>();

		for (Character elevador : elevadorMaisutilizado) {
			List<Character> periodos = service.periodoMaiorFluxoElevadorMaisFrequentado();
			elevadormaiorComperiodo.add(new RegistroElevadorDTO(elevador, periodos));
		}

		LOGGER.info("Consulta concluida ! Resultado {} ", elevadormaiorComperiodo);

		return elevadormaiorComperiodo;
	}

	@GetMapping("/elevadorMenosUtilizadocomPeriodo")
	public List<RegistroElevadorDTO> getperiodoMenorFluxoElevadorMenosFrequentado() {
		List<Character> elevadorMaisutilizado = service.elevadorMenosFrequentado();
		List<RegistroElevadorDTO> elevadormenorComperiodo = new ArrayList<>();

		for (Character elevador : elevadorMaisutilizado) {
			List<Character> periodos = service.periodoMaiorFluxoElevadorMaisFrequentado();
			elevadormenorComperiodo.add(new RegistroElevadorDTO(elevador, periodos));
		}

		LOGGER.info("Consulta concluida ! Resultado {} ", elevadormenorComperiodo);

		return elevadormenorComperiodo;
	}

	@GetMapping("/maiorUtilizacaoConjuntoElevadores")
	public List<Character> getperiodoMaiorUtilizacaoConjuntoElevadores() {
		List<Character> resultadoConjunto = service.periodoMaiorUtilizacaoConjuntoElevadores();

		LOGGER.info("Consulta concluida ! Resultado {} ", resultadoConjunto);

		return resultadoConjunto;
	}

	@GetMapping("/percentualDeUsoTodosElevadores")
	public Map<String, Float> getercentualDeUsoTodosElevadores() {
		Map<String, Float> resiltadoPercentual = service.percentualElevadores();

		LOGGER.info("Consulta concluida ! Resultado {} ", resiltadoPercentual);
		return resiltadoPercentual;
	}

}
