package br.com.compasso.cadastro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.cadastro.model.Cliente;
import br.com.compasso.cadastro.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	public ClienteRepository repository;

	@Override
	public List<Cliente> pesquisaPorNome(String nome) {
		return repository.pesquisaPorNome("%" + nome + "%");
	}

	@Override
	public Optional<Cliente> pesquisaPorId(Long id) {
		return repository.findById(id);
	}

	@Override
	public Cliente incluir(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public Cliente alterar(Cliente cliente) {
		return repository.save(cliente);
	}

	@Override
	public void removerCliente(Long id) {
		Optional<Cliente> c = repository.findById(id);
		if (c.isPresent())
			repository.delete(c.get());
	}

}
