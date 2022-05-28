package edu.mms.estruturadados.optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/*
 * Permite que você execute operações em valores que podem ser nulos,
 * sem preocupação com as exceptions NullPointerExceptions.
 */
public class OptionalMain {

	public static void main(String[] args) {
		
		Optional<String> optionalString = Optional.of("valor presente");
		
		System.out.println("Valor optional está presente expressão lambda");
		optionalString.ifPresentOrElse(System.out::println, () -> System.out.println("não está presente"));
		
		Optional<String> optionalNull = Optional.ofNullable(null);
		System.out.println("Valor optinal não está presente");
		optionalNull.ifPresentOrElse(System.out::println, () -> System.out.println("null = não está presente"));
		
		Optional<String> emptyOptional = Optional.empty();
		System.out.println("Valor optinal não está presente");
		emptyOptional.ifPresentOrElse(System.out::println, ()-> System.out.println("empty = não está presente"));
		
		System.out.println("Valor inteiro");
		OptionalInt.of(12).ifPresent(System.out::println);
		
		System.out.println("Valor decimal");
		OptionalDouble.of(55.2).ifPresent(System.out::println);
		
		System.out.println("Valor long");
		OptionalLong.of(23L).ifPresent(System.out::println);
		
		Optional<String> optional = Optional.of("Valor optional");
		System.out.println(optional.isPresent());
		
		optional.ifPresent(System.out::println);
		optional.ifPresentOrElse(System.out::println, 
				()-> System.out.println("Valor optional não está presente"));
		
		if(optional.isPresent()){
			String valor = optional.get();
			System.out.println(valor);
		}
		
		optional.map((valor) -> valor.concat("******")).ifPresent(System.out::println);
		
		optional.orElseThrow(IllegalStateException::new);		
		
		Optional<String> optionalNullErro = Optional.of(null);
		System.out.println("Valor optional que lança erro NullPointerException");
		optionalNullErro.ifPresentOrElse(System.out::println, () -> System.out.println("erro = não está presente"));		
		
	}

}
