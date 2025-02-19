package com.example.transaction_api.business.services;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.transaction_api.controller.dtos.TransactionRequestDTO;
import com.example.transaction_api.infrastructure.exceptions.UnprocessableEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {
    private final List<TransactionRequestDTO> transactionList = new ArrayList<>();

    public void addTransaction(TransactionRequestDTO dto) {
        log.info("Inserindo nova transação " + dto);

        if (dto.dateHour().isAfter(OffsetDateTime.now())) {
            log.error("Data e hora da transação futuras");
            throw new UnprocessableEntity("Data e hora da transação não podem ser futuras");
        }

        if (dto.value() < 0) {
            log.error("Valor da transação menor que zero");
            throw new UnprocessableEntity("O valor da transação deve ser maior que zero");
        }

        transactionList.add(dto);
        log.info("Transações adicionadas com sucesso");
    }

    public void clearTransactions() {
        log.info("Iniciado o processo para limpar as transações");
        transactionList.clear();
        log.info("Transações deletadas com sucesso");
    }

    public List<TransactionRequestDTO> searchTransactions(Integer searchInterval) {
        log.info("Iniciada a busca de transações por tempo");
        OffsetDateTime dateHourInterval = OffsetDateTime.now().minusSeconds(searchInterval);

        log.info("Retorno de transações com sucesso");
        return transactionList.stream().filter(transaction -> transaction.dateHour().isAfter(dateHourInterval))
                .toList();
    }
}