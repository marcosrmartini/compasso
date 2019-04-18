package br.com.compasso.cadastro.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.cadastro.model.Cliente;
import br.com.compasso.cadastro.service.ClienteService;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public Cliente incluirCliente(@Valid @RequestBody Cliente cliente) {
		return service.incluir(cliente);
	}
	
	@PutMapping
	public Cliente alterarCliente(@Valid @RequestBody Cliente cliente) {
		return service.alterar(cliente);
	}
	
	@RequestMapping(value = "/porNome/{nome}")
	public List<Cliente> pesquisaPorNome( @PathVariable("nome") String nome){
		return service.pesquisaPorNome(nome);
	}
	
	@RequestMapping(value = "/porId/{id}")
	public Optional<Cliente> pesquisaPorId( @PathVariable("id") Long id){
		return service.pesquisaPorId(id);
	}
	
	@DeleteMapping("/{id}")
	public void removerCliente(@PathVariable("id") Long id) {
		service.removerCliente(id);
	}

}
