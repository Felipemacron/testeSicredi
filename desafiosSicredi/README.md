## Desafio 1 — Observações e Ajustes nos Testes

- **Nome do campo (documentação vs. site)**: A documentação esperava o campo "from Employeer", porém no site real o campo correspondente é "SalesRepEmployeeNumber".
- **Validação do campo**: No site, "SalesRepEmployeeNumber" aceita apenas números. Já a documentação instrui a preencher com letras (por exemplo, "fixter"). Essa divergência impede o preenchimento conforme a doc, então os testes utilizam apenas valores numéricos.
- **Mensagem de sucesso (documentação vs. site)**:
  - Documentação: "Your data has been successfully stored into the database. Edit Customer or Go back to list"
  - Site real: "Your data has been successfully stored into the database. Edit Record or Go back to list"
  Os asserts dos testes foram ajustados para refletir a mensagem real do site.
- **Comportamento do checkbox em "Search Name"**: Após preencher o nome na coluna "Search Name", ao clicar no checkbox ocorre um loading e o checkbox é desmarcado automaticamente. Para garantir a continuidade do fluxo, o teste repete a ação (clica novamente) para prosseguir sem flakiness.

### Impacto nos testes automatizados
- **Entradas de dados**: uso de valores numéricos em "SalesRepEmployeeNumber" para respeitar a validação real do site.
- **Asserções de mensagens**: verificação ajustada para "Edit Record" em vez de "Edit Customer".
- **Resiliência do fluxo**: duplicação intencional do clique no checkbox após o preenchimento em "Search Name" para evitar intermitências causadas pelo loading que desmarca a seleção.

### Observação
Estas adaptações visam alinhar a suíte de testes ao comportamento real da aplicação em produção, mantendo-os estáveis e representativos até que a documentação e/ou o sistema sejam harmonizados.
