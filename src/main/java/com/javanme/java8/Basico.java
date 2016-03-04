package com.javanme.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.print.attribute.standard.JobOriginatingUserName;

/**
 * Clase con ejercicios nivel básico Created by aalopez on 18/08/15.
 */
public class Basico {

	/**
	 * Convertir a mayúsculas cada una de las palabras recibidas como parámetro
	 * Trata de usar uno de los nuevos métodos adicionados a las listas en Java
	 * 8
	 *
	 * @param palabras
	 *            Listado de palabras a convertir
	 * @return Lista que contiene las palabras en mayúsculas
	 */
	public List<String> ejercicio1(List<String> palabras) {
		List<String> palabras3 = palabras.stream().map(String::toUpperCase).collect(Collectors.toList());
		return palabras3;
	}

	/**
	 * Del listado de cadenas de texto eliminar las cadenas de ese listado cuyo
	 * tamaño sea inferior a 10 caracteres Trata de usar uno de los nuevos
	 * métodos adicionados a las listas en Java 8
	 *
	 * @param listado
	 *            cadenas de texto
	 * @return lista que contiene cadenas de texto cuyo tamaño de caracteres es
	 *         superior a 10
	 */
	public List<String> ejercicio2(List<String> listado) {
		List<String> resultadoList = listado.stream().filter(x -> x.length() > 10).collect(Collectors.toList());
		return resultadoList;
	}

	/**
	 * Del listado pasado como parámetro, une la tercera, cuarta y quinta cadena
	 * separadas por guión (-) Usa la API Stream
	 *
	 * @param listado
	 *            cadenas de texto
	 * @return Cadena de texto que se compone de la tercera, cuarta y quinta
	 *         cadena de texto separadas por guiones
	 * @see java.util.stream.Stream
	 * @see java.util.stream.Collectors
	 */
	public String ejercicio3(List<String> listado) {
		Stream<String> resultado = listado.stream().skip(2).limit(3);
		String resultadoS = resultado.collect(Collectors.joining("-"));
		return resultadoS;
	}

	/**
	 * Ordernar el listado pasado como parámetro usando orden natural numérico.
	 * Atención, el listado contiene números, no cadenas de texto se debe hacer
	 * conversión. Usa la API Stream
	 *
	 * @param listado
	 *            números a ordenar
	 * @return Listado de números en orden natural
	 * @see java.util.stream.Stream
	 * @see java.util.stream.Collectors
	 */
	public List<Integer> ejercicio4(List<String> listado) {
		List<Integer> resultadoList = listado.stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
		return resultadoList;
	}

	/**
	 * Ordernar el listado pasado como parámetro primero por tamaño de la cadena
	 * de texto y luego alfabeticamente Usa la API Stream
	 *
	 * @param listado
	 *            cadenas de texto a ordenar
	 * @return Listado ordenado primero por número de caracteres y luego
	 *         alfabeticamente
	 * @see java.util.stream.Stream
	 * @see java.util.stream.Collectors
	 */
	public List<String> ejercicio5(List<String> listado) {
		Comparator<Object> comp = Comparator.comparing(e->e.toString().length()).thenComparing(e->e.toString());
		Stream<String>orden1=listado.stream().sorted(comp);
		
		List<String> resultadoList = orden1.collect(Collectors.toList());
		return resultadoList;
	}
}
