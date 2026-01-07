Walkthrough - API OCI
API Java REST com Spring Boot integrada ao Oracle Database na OCI.

Estrutura do Projeto
Database: Scripts SQL em 
database/init.sql
Backend: Aplicação Spring Boot em src/main/java
Como Executar
1. Banco de Dados
Execute o script 
init.sql
 no seu banco Oracle na OCI para criar:

Tabela CLIENTES
Package PKG_CLIENTES
2. Configuração
Credenciais configuradas em 
src/main/resources/application.properties
:

Usuário: fredgruber@gmail.com
Senha: *** (Configurada)
Atenção: Verifique se a URL de conexão (jdbc:oracle:thin:@//seu-host-oracle-oci:1521/seu-service-name) precisa ser ajustada com o IP/Host real do seu banco.
3. Executando a Aplicação
Compile e rode o projeto:

mvn spring-boot:run
Endpoints
| Método | URL | Descrição | |Data|---|---| | GET | /api/clientes | Lista todos os clientes | | POST | /api/clientes/{cpf}/bloquear | Bloqueia cliente (Status 'B') | | POST | /api/clientes/{cpf}/desbloquear | Desbloqueia cliente (Status 'D') |
