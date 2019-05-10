package br.com.compasso.cadastro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.cadastro.model.Cidade;
import br.com.compasso.cadastro.service.CidadeService;

@RestController
@RequestMapping(value = "/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService service;
	
	@RequestMapping(value = "/porCidade/{cidade}", method = RequestMethod.GET)
	public List<Cidade> pesquisaPorCidade( @PathVariable("cidade") String cidade){
		return service.pesquisaPorNome(cidade);
	}
	
	@RequestMapping(value = "/porEstado/{estado}", method = RequestMethod.GET)
	public List<Cidade> pesquisaPorEstado( @PathVariable("estado") String estado){
		return service.pesquisaPorEstado(estado);
	}
	
	@PostMapping
	public Cidade incluiCidade(@Valid @RequestBody Cidade cidade) {
		return service.incluir(cidade);
	}

}
