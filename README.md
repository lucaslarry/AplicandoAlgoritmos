# Aplicando algoritmo

## Descrição
**Aplicando algoritmo** é um projeto desenvolvido durante a competencia de Aplicar algoritmos na Universidade Facisa. Este projeto implementa uma ArrayList personalizada que serve como biblioteca para a gestão de livros, oferecendo funcionalidades para adicionar, listar, buscar e recomendar livros. A ordenação dos livros é realizada utilizando os algoritmos de QuickSort e BubbleSort, enquanto que a recomendação de livros é feita através de um algoritmo guloso utilizando grafos.

## Tecnologias Utilizadas
- Java (versão 17)

## Funcionalidades
- **Adicionar livros:** Permite a inclusão de novos livros na biblioteca. Cada livro contém informações como título e autor.
- **Listar livros:** Exibe todos os livros cadastrados na biblioteca.
- **Buscar livros:** Realiza a busca de livros específicos pelo título.
- **Recomendar livros:** Fornece recomendações de livros utilizando um algoritmo guloso que escolhe livros baseando-se na categória do livro.
- **Ordenação de livros:**
    - **QuickSort:** Algoritmo eficiente de ordenação que usa a técnica de divisão e conquista para organizar os livros rapidamente.
    - **BubbleSort:** Algoritmo de ordenação mais simples que compara e troca adjacências repetidamente até que a lista esteja ordenada. Ideal para pequenos conjuntos de dados.

## Instruções de Instalação e Execução
1. **Clone o repositório:**
    ```sh
    git clone https://github.com/lucaslarry/AplicandoAlgoritmos.git
    ```
2. **Navegue até o diretório src**
    ```sh
    cd AplicandoAlgoritmos\src
    ```
3. **Compile o projeto:**
    ```sh
    javac application/Application.java
    ```
4. **Execute o projeto:**
    ```sh
    java application/Application.java
    ```