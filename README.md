# Transaction-API
Uma API de transações financeiras

# Descrição
Essa API permite realizar operações de transações financeiras, incluindo adicionar, deletar e consultar transações. Além disso, é possível obter estatísticas sobre as transações realizadas

# Endpoints
- POST /transactions: Adicionar uma transação
- DELETE /transactions: Deletar uma transação
- GET /transactions: Consultar transações
- GET /statistics: Obter estatísticas sobre as transações

# Tecnologias utilizadas
- Java 21
- Spring Boot 3.4.2
- Gradle

# Modelos de dados
- TransactionRequestDTO: Representa uma transação a ser adicionada
- StatisticsResponseDTO: Representa as estatísticas sobre as transações

# Serviços
- TransactionService: Responsável por realizar operações de transações
- StatisticsService: Responsável por obter estatísticas sobre as transações
