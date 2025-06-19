package com.elevate.software.service.impl;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.elevate.software.model.RegistroElevador;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DadosService {

	@Value("${json.file.path}")
	private String arquivoJson;

	private static final Logger LOGGER = LoggerFactory.getLogger(DadosService.class);

	public List<RegistroElevador> carregarJsonElevador() {

		try {

			ObjectMapper mapper = new ObjectMapper();
			List<RegistroElevador> registros = mapper.readValue(new File(arquivoJson),
					new TypeReference<List<RegistroElevador>>() {
					});

			LOGGER.info("Arquivo Json encontrado na base");
			
			return registros;

		} catch (Exception e) {
			throw new RuntimeException("Erro ao carregar arquivo JSON", e);
		}

	}
}
