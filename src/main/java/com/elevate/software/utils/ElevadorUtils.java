package com.elevate.software.utils;

import java.util.Locale;

public class ElevadorUtils {
	
	public static float percentualdeUsoElevador(long usoElevador, long totalServicoes) {
		float percentual = (usoElevador * 100.0f) /totalServicoes;
		return Float.parseFloat(String.format(Locale.US,"%.2f", percentual));
	}
}
