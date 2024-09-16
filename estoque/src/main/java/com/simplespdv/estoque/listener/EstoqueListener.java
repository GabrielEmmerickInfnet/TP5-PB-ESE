package com.simplespdv.estoque.listener;

import com.simplespdv.estoque.model.Estoque;
import com.simplespdv.estoque.service.EstoqueService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EstoqueListener {

    private final EstoqueService estoqueService;

    public EstoqueListener(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @RabbitListener(queues = "produto-queue")
    public void receiveMessage(Estoque estoque) {
        System.out.println("Mensagem recebida: " + estoque);
        estoqueService.atualizarEstoque(estoque);
    }
}
