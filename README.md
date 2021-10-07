# LocadoraGames
Trabalho POO e BD

Minimundo: Locadora de games digitais

Uma locadora de games digitais mantem dados de seus clientes, funcionários e dos jogos disponíveis para locação.
O cliente é identificado pelo seu CPF, nome completo, endereço de e-mail, senha, data de nascimento, endereço.
Os jogos são identificados por título, plataforma, quantidade disponível para locação, e-mail da conta, senha da conta e categoria. 
Embora um jogo possa ser disponibilizado para mais de uma plataforma, ele precisa ter um registro individual para cada plataforma, ou seja, a plataforma possui o jogo.
O cliente aluga um ou mais jogos por no mínimo 7 dias e recebe em seu e-mail os dados da conta em que o jogo está cadastrado (e-mail e senha).
Só é possível alugar um jogo que tenha quantidade disponível não reservada por outro usuário.
A cada locação, um funcionário é alocado para suporte ao cliente caso ele tenha dificuldades em adicionar a conta ao seu console. O cliente recebe junto com os dados da locação, o apelido do funcionário e os contatos do mesmo caso precise de suporte.
Ao fim do período de locação, o funcionário deverá fazer a troca da senha da conta alocada ao cliente, pois os sistemas que gerenciam a conta tem proteções contra acesso de “robôs”. Após a troca da senha o funcionário atualiza o dado no banco de dados.
