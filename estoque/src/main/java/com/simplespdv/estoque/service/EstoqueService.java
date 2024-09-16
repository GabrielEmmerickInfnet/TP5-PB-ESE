package com.simplespdv.estoque.service;

import com.simplespdv.estoque.model.Estoque;
import com.simplespdv.estoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    // Criar novo estoque
    public Estoque create(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    // Buscar todos os estoques
    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    // Buscar estoque por ID
    public Optional<Estoque> findById(Long id) {
        return estoqueRepository.findById(id);
    }

    // Deletar estoque por ID
    public void deleteById(Long id) {
        estoqueRepository.deleteById(id);
    }

    // Atualizar o estoque
    public Estoque update(Estoque estoque) {
        Optional<Estoque> estoqueExistente = estoqueRepository.findById(estoque.getProdutoId());
        if (estoqueExistente.isPresent()) {
            estoqueExistente.get().setQuantidade(estoque.getQuantidade());
            return estoqueRepository.save(estoqueExistente.get());
        }
        return estoqueRepository.save(estoque); 
    }

	public void atualizarEstoque(Estoque estoque) {
		// TODO Auto-generated method stub
		
	}
}
