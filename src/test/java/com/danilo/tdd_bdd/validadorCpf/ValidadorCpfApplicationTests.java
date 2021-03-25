package com.danilo.tdd_bdd.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.danilo.tdd_bdd.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	@DisplayName("dada que o campo teste seja digitado corretamente com um cpf válido")
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manoela");
		cliente.setCpf("09533107448");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manoela");
		cliente.setCpf("095331074");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manoela");
		cliente.setCpf("095.331.074-48");
		assertEquals(true, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manoela");
		cliente.setCpf("095.331.000-00");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoVazio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manoela");
		cliente.setCpf("");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComLetras() {
		Cliente cliente = new Cliente();
		cliente.setNome("Manoela");
		cliente.setCpf("letras");
		assertEquals(false, cliente.validarCPF());
	}

}
