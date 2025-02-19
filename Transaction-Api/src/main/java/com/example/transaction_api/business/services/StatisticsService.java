package com.example.transaction_api.business.services;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.transaction_api.controller.dtos.StatisticsResponseDTO;
import com.example.transaction_api.controller.dtos.TransactionRequestDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticsService {
    public final TransactionService transactionService;

    public StatisticsResponseDTO calculateTransactionsStatistics(Integer searchInterval) {
        log.info("Iniciada a busca de estatísticas de transações pelo período de tempo " + searchInterval);
        List<TransactionRequestDTO> transactions = transactionService.searchTransactions(searchInterval);

        if (transactions.isEmpty()) {
            return new StatisticsResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics statisticsTransactions = transactions.stream().mapToDouble(TransactionRequestDTO::value)
                .summaryStatistics();

        log.info("Estatísticas retornadas com sucesso");
        return new StatisticsResponseDTO(statisticsTransactions.getCount(), statisticsTransactions.getSum(),
                statisticsTransactions.getAverage(), statisticsTransactions.getMin(), statisticsTransactions.getMax());
    }
}