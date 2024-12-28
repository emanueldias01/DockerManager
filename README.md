# DockerManager

O **DockerManager** é uma ferramenta criada como parte de um desafio técnico para o processo seletivo da empresa **Stone**. A aplicação tem como objetivo fornecer uma interface simples e eficiente para gerenciar containers e imagens Docker que estão rodando localmente na máquina. Com ela, é possível listar containers e imagens, iniciar e parar containers, criar novos containers e excluir containers existentes.

## Tecnologias Utilizadas

- **Java**: Linguagem de programação utilizada para o desenvolvimento da aplicação.
- **Spring Framework**: Framework utilizado para estruturar a aplicação e facilitar o desenvolvimento.
- **Docker API**: Biblioteca para interagir diretamente com o Docker e manipular containers e imagens.
- **Maven**: Gerenciador de dependências e build utilizado para compilar e executar o projeto.

## Funcionalidades

O **DockerManager** oferece as seguintes funcionalidades:

### 1. Listar Containers

- **Listar todos os containers (ativos e inativos)**:
  Retorna todos os containers, incluindo os que estão parados.

- **Listar apenas os containers ativos**:
- Retorna somente os containers que estão em execução no momento.


### 2. Listar Imagens
- **Listar todas as imagens Docker**:
- Retorna todas as imagens presentes localmente na máquina.

- **Listar imagens filtrando por nome**:
- Retorna todas as imagens que correspondem ao filtro de nome fornecido.

### 3. Gerenciar Containers
- **Iniciar um container**:
- Inicia um container específico baseado no seu ID.

- **Parar um container**:
- Para um container em execução com o ID fornecido.

-**Criar um novo container a partir de uma imagem**:
- Cria um novo container a partir de uma imagem Docker especificada.

-**Excluir um container**:
- Remove um container específico pelo seu ID.


