# SistemaDeEstoque
## Objetivo

--> Criar um programa em Java para simular um sistema de estoque, utilizando conceitos aprendidos em aula como AVL, hierarquia de classes e polimorfismo.

--> O projeto conta com 6 classes, sendo 4 delas responsáveis pela estrutura da Árvore AVL utilizada para armazenar os produtos em estoque. 

## Código
**BTNode:** 

--> Esta classe representa um nó (um elemento) na árvore. Os nós contêm informações relevantes sobre a estrutura 
da árvore, como os dados associados, os nós pai e filhos, bem como informações de balanceamento para a implementação de uma Árvore AVL.

**BinaryTree:**

--> Essa classe implementa uma Árvore Binária. Fornece funcionalidades para a manipulação e análise de uma Árvore Binária, incluindo a capacidade de percorrer a árvore em diferentes ordens, calcular sua altura, grau e contar os nós

**BST:**

--> A classe BST é uma extensão da classe BinaryTree, representando uma Árvore de Busca Binária (Binary Search Tree, BST). 

--> Mantém os nós organizados de forma que os valores menores estão à esquerda e os valores maiores estão à direita. 

--> Ela fornece métodos para busca, inserção e remoção de elementos, bem como a localização de elementos mínimos e máximos na árvore. Além disso, ela permite encontrar o predecessor e sucessor de um nó com base nos dados de estoque.

**AVL:**

--> A classe AVL é uma extensão da classe BST (Árvore de Busca Binária), implementando uma Árvore AVL (Árvore Binária de Busca Balanceada).

--> Ela mantém o equilíbrio da árvore após inserções e remoções, garantindo um desempenho eficiente nas operações de busca e manipulação de dados. 

--> Além disso, ela fornece métodos para calcular o valor de produtos no estoque, calcular o valor total do estoque e listar produtos com quantidades inferiores a um limite especificado.  

**Estoque:**

--> A classe Estoque é responsável por representar informações sobre produtos em estoque.

**AVLTest1:**

--> Classe principal para testar o funcionamento das classes.
