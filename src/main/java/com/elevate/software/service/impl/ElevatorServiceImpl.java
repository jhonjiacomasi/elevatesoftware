package com.elevate.software.service.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.elevate.software.exception.ElevadorException;
import com.elevate.software.model.RegistroElevador;
import com.elevate.software.service.IElevadorService;
import com.elevate.software.utils.ElevadorUtils;

@Service
public class ElevatorServiceImpl implements IElevadorService {

	private final List<RegistroElevador> registroElevador;

	public ElevatorServiceImpl(DadosService dadosService) {
		this.registroElevador = dadosService.carregarJsonElevador();
	}

	@Override
	public List<Integer> andarMenosUtilizado() {

		try {
			Map<Integer, Long> freqAndarmin = registroElevador.stream()
					.collect(Collectors.groupingBy(RegistroElevador::getAndar, Collectors.counting()));

		
			Long minimoUso = Collections.min(freqAndarmin.values());
			return freqAndarmin.entrySet().stream().filter(entry -> entry.getValue().equals(minimoUso))
					.map(Map.Entry::getKey).collect(Collectors.toList());

		} catch (Exception e) {
			throw new ElevadorException(
					"Erro na logica de acesso as informacoes de Andares mais frequentados" + e.getMessage());

		}
	}

	@Override
	public List<Character> elevadorMaisFrequentado() {
		try {
			return registroElevador.stream().collect(Collectors.collectingAndThen(
					Collectors.groupingBy(RegistroElevador::getElevador, Collectors.counting()), freqMap -> {
						long maximoUso = Collections.max(freqMap.values());
						return freqMap.entrySet().stream().filter(entry -> entry.getValue() == maximoUso)
								.map(Map.Entry::getKey).collect(Collectors.toList());
					}));

		} catch (Exception e) {
			throw new ElevadorException(
					"Erro na logica de acesso as informacoes de Elevadores mais frequentados" + e.getMessage());

		}
	}

	@Override
	public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
		try {
			Map<Character, Long> freqperiodo = registroElevador.stream()
					.collect(Collectors.groupingBy(RegistroElevador::getTurno, Collectors.counting()));

			long maxUso = Collections.max(freqperiodo.values());

			return freqperiodo.entrySet().stream().filter(entry -> entry.getValue() == maxUso).map(Map.Entry::getKey)
					.collect(Collectors.toList());

		} catch (Exception e) {
			throw new ElevadorException(
					"Erro na logica de acesso as informacoes do fluxo do elevador mais frequentados" + e.getMessage());

		}
	}

	@Override
	public List<Character> elevadorMenosFrequentado() {

		try {
			return registroElevador.stream().collect(Collectors.collectingAndThen(
					Collectors.groupingBy(RegistroElevador::getElevador, Collectors.counting()), freqMap -> {
						long minUso = Collections.min(freqMap.values());
						return freqMap.entrySet().stream().filter(entry -> entry.getValue() == minUso)
								.map(Map.Entry::getKey).collect(Collectors.toList());
					}));

		} catch (Exception e) {
			throw new ElevadorException(
					"Erro na logica de acesso as informacoes de Elevadores menos frequentados" + e.getMessage());

		}

	}

	@Override
	public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
		Map<Character, Long> freqperiodo = registroElevador.stream()
				.collect(Collectors.groupingBy(RegistroElevador::getTurno, Collectors.counting()));

		long minUso = Collections.min(freqperiodo.values());

		return freqperiodo.entrySet().stream().filter(entry -> entry.getValue() == minUso).map(Map.Entry::getKey)
				.collect(Collectors.toList());
	}

	@Override
	public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {

		try {
			return registroElevador.stream().collect(Collectors.collectingAndThen(
					Collectors.groupingBy(RegistroElevador::getTurno, Collectors.counting()), freqMap -> {
						long maximoUso = Collections.max(freqMap.values());
						return freqMap.entrySet().stream().filter(entry -> entry.getValue() == maximoUso)
								.map(Map.Entry::getKey).collect(Collectors.toList());
					}));

		} catch (Exception e) {
			throw new ElevadorException(
					"Erro na logica de acesso as informacoes de periodo mais frequentados de todos elevadores"
							+ e.getMessage());

		}
	}

	@Override
	public Map<String, Float> percentualElevadores() {

		try {

			Map<String, Float> percentuais = new HashMap<>();
			percentuais.put("A", percentualDeUsoElevadorA());
			percentuais.put("B", percentualDeUsoElevadorB());
			percentuais.put("C", percentualDeUsoElevadorC());
			percentuais.put("D", percentualDeUsoElevadorD());
			percentuais.put("E", percentualDeUsoElevadorE());

			return percentuais;

		} catch (Exception e) {
			throw new ElevadorException("Erro ao calcular o percentual de uso de Elevadores" + e.getMessage());

		}

	}

	@Override
	public float percentualDeUsoElevadorA() {
		long elevadorA = registroElevador.stream().filter(r -> r.getElevador() == 'A').count();
		long totalServicos = registroElevador.size();
		return ElevadorUtils.percentualdeUsoElevador(elevadorA, totalServicos);
	}

	@Override
	public float percentualDeUsoElevadorB() {
		long elevadorB = registroElevador.stream().filter(r -> r.getElevador() == 'B').count();
		long totalServicos = registroElevador.size();
		return ElevadorUtils.percentualdeUsoElevador(elevadorB, totalServicos);
	}

	@Override
	public float percentualDeUsoElevadorC() {
		long elevadorC = registroElevador.stream().filter(r -> r.getElevador() == 'C').count();
		long totalServicos = registroElevador.size();
		return ElevadorUtils.percentualdeUsoElevador(elevadorC, totalServicos);
	}

	@Override
	public float percentualDeUsoElevadorD() {
		long elevadorD = registroElevador.stream().filter(r -> r.getElevador() == 'D').count();
		long totalServicos = registroElevador.size();
		return ElevadorUtils.percentualdeUsoElevador(elevadorD, totalServicos);
	}

	@Override
	public float percentualDeUsoElevadorE() {
		long elevadorE = registroElevador.stream().filter(r -> r.getElevador() == 'E').count();
		long totalServicos = registroElevador.size();
		return ElevadorUtils.percentualdeUsoElevador(elevadorE, totalServicos);
	}

}
