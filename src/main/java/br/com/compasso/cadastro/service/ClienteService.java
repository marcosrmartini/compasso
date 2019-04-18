package br.com.compasso.cadastro.service;

import java.util.List;
import java.util.Optional;

import br.com.compasso.cadastro.model.Cliente;

public interface ClienteService {

	public Cliente incluir(Cliente cliente);
	public List<Cliente> pesquisaPorNome(String nome);
	public Optional<Cliente> pesquisaPorId(Long id);
	public Cliente alterar(Cliente cliente);
	public void removerCliente(Long id);
	
}
