# ☕ Estudos de Java — Preparação para o Backend do Aviafo

Este documento registra os conceitos de Java e Programação Orientada a Objetos estudados como preparação para o desenvolvimento do backend do Aviafo, utilizando o curso **Java COMPLETO Programação Orientada a Objetos + Projetos** do professor Nelio Alves.

---

## 📚 Módulos Concluídos

### Seção 8 — Introdução à Programação Orientada a Objetos
**12 aulas · 1h 29min**

Conceitos fundamentais de POO aplicados à modelagem do mundo real:

- **Classes e Objetos** — Definição de estruturas e instanciação de objetos em Java
- **Atributos e Membros** — Variáveis de instância, estado do objeto e acesso a membros
- **Membros Estáticos** — Diferença entre membros de instância e de classe (`static`)
- **Estrutura Sequencial** — Fluxo linear de execução e atribuição de variáveis
- **Estrutura Condicional** — Tomada de decisão com `if`, `else` e `switch`
- **Estruturas de Repetição** — Iteração com `for` e `while`

---

### Seção 9 — Construtores, `this`, Sobrecarga e Encapsulamento
**9 aulas · 1h 16min**

Mecanismos mais profundos de POO para construção de classes robustas e reutilizáveis:

- **Construtores** — Inicialização de objetos com construtores padrão e parametrizados
- **Palavra-chave `this`** — Referência à instância atual do objeto e encadeamento de construtores
- **Sobrecarga** — Definição de múltiplos métodos com o mesmo nome e assinaturas diferentes
- **Encapsulamento** — Proteção do estado do objeto com campos `private` e getters/setters `public`

---

## 🏋️ Exercícios Práticos

Exercícios práticos foram realizados ao longo de cada seção para reforçar os conceitos teóricos, abrangendo:

- Modelagem de classes com atributos e comportamentos
- Instanciação de objetos e chamadas de métodos
- Lógica condicional e de repetição aplicada a cenários reais
- Design de classes encapsuladas com acesso controlado ao estado interno

---

## 🔗 Aplicação no Projeto

Esses conceitos se conectam diretamente à arquitetura do backend do Aviafo:

| Conceito Java | Aplicação no Aviafo |
|---|---|
| Classes e Objetos | Cada entidade do banco (`Produto`, `Cliente`, `Pedido`) se torna uma classe Java |
| Encapsulamento | Todos os campos `@Entity` são `private` com getters/setters via Lombok |
| Construtores | JPA exige construtor sem argumentos; construtores parametrizados usados nos DTOs |
| Membros estáticos | Classes utilitárias e constantes na camada de serviço |
| Estruturas condicionais | Validação de regras de negócio na camada `Service` |
| Estruturas de repetição | Processamento de listas, iteração do carrinho e cálculo de itens do pedido |
