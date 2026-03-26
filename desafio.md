🧪 Desafio Prático – Pedra, Papel e Tesoura (API com Spring Boot)

🎯 Objetivo:

Criar uma aplicação Java com Spring Boot que ofereça uma API REST para jogar Pedra, Papel e Tesoura entre dois jogadores.

📝 Requisitos:

A aplicação deve expor um endpoint POST que receba as jogadas dos dois jogadores e retorne o resultado da partida.
As jogadas devem ser informadas como strings: "PEDRA", "PAPEL" ou "TESOURA" (case-insensitive).
A resposta deve indicar:
As jogadas de cada jogador
O resultado da partida:
"Empate"
"Jogador 1 vence"
"Jogador 2 vence"
✅ Regras do jogo:

Pedra vence Tesoura
Tesoura vence Papel
Papel vence Pedra
Jogadas iguais resultam em empate
📦 Exemplo de chamada (POST /jogar):

Request JSON:

{"jogador1": "PAPEL","jogador2": "PEDRA" } 
Response JSON:

{"jogador1": "PAPEL","jogador2": "PEDRA","resultado": "Jogador 1 vence" } 
💡 Dicas Técnicas:

Crie um enum chamado Jogada com os valores PEDRA, PAPEL, TESOURA
Crie uma classe JogoService com a lógica para comparar as jogadas
Use boas práticas de clean code e orientação a objetos
Não é necessário persistência ou banco de dados — apenas lógica
 

🧩 O que será avaliado:

Correção da lógica do jogo
Uso adequado do Spring Boot (REST, DTOs, etc.)
Estrutura e organização do projeto
Código limpo, legível e bem estruturado
 