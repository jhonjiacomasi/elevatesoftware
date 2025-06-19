package com.elevate.software.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PercentualElevadoresDTO {
	private Map<String,Float> percentuais;
}
