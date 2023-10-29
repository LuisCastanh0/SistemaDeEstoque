package AVLTest;

//
//Árvore de Busca Binária - Exemplo de implementação em Java
//Copyright (C) 2023 André Kishimoto
//
//This program is free software: you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation, either version 3 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program.  If not, see <https://www.gnu.org/licenses/>.
//

public class BST extends BinaryTree {

	public BST() {
		super();
	}

	public BST(BTNode root) {
		super(root);
	}

	public BTNode search_codigo(int CodigoProd) { 
		return search_codigoHelper(super.getRoot(),CodigoProd);

	}

	private BTNode search_codigoHelper(BTNode node, int data) {
		if (node == null) {
			return null;
		}

		if (data < node.getData().getCodigoProduto()) {
			return search_codigoHelper(node.getLeft(), data);
		} else if (data >  node.getData().getCodigoProduto()) {
			return search_codigoHelper(node.getRight(), data);
		} else {
			return node;
		}
	}


	public BTNode search(Estoque data) {
		return searchHelper(super.getRoot(), data);
	}

	private BTNode searchHelper(BTNode node, Estoque data) {
		if (node == null) {
			return null;
		}

		if (data.getCodigoProduto() < node.getData().getCodigoProduto()) {
			return searchHelper(node.getLeft(), data);
		} else if (data.getCodigoProduto() >  node.getData().getCodigoProduto()) {
			return searchHelper(node.getRight(), data);
		} else {
			return node;
		}
	}

	private void insert(Estoque data) {
		super.setRoot(insertHelper(super.getRoot(), null, data));
	}

	private BTNode insertHelper(BTNode node, BTNode parent, Estoque data) {
		if (node == null) {
			return new BTNode(data, parent);
		}

		if (data.getCodigoProduto() < node.getData().getCodigoProduto()) {
			node.setLeft(insertHelper(node.getLeft(), node, data));
		} else if (data.getCodigoProduto() > node.getData().getCodigoProduto()) {
			node.setRight(insertHelper(node.getRight(), node, data));
		} else {
			// Nessa implementação, não é permitida a inserção de duplicatas na BST.
		}

		return node;
	}

	private void remove(int codigoProduto) {
		super.setRoot(removeHelper(super.getRoot(), codigoProduto));
	}

	private BTNode removeHelper(BTNode node, int codigoProduto) {
		if (node == null) {
			return null;
		}

		if (codigoProduto < node.getData().getCodigoProduto()) {
			node.setLeft(removeHelper(node.getLeft(), codigoProduto));
		} else if (codigoProduto > node.getData().getCodigoProduto()) {
			node.setRight(removeHelper(node.getRight(), codigoProduto));
		} else {
			node = removeNode(node,codigoProduto);
		}

		return node;		
	}

	private BTNode removeNode(BTNode node, int codigoProduto) {
		if (node.isLeaf()) {
			return null;
		}

		if (!node.hasLeftChild()) {
			return node.getRight();
		} else if (!node.hasRightChild()) {
			return node.getLeft();
		} else {
			BTNode predecessor = findMaxHelper(node.getLeft());
			node.setData(predecessor.getData());
			node.setLeft(removeHelper(node.getLeft(), codigoProduto));
		}

		return node;		
	}

	public BTNode findMin() {
		return findMinHelper(super.getRoot());
	}

	private BTNode findMinHelper(BTNode node) {
		if (node == null) {
			return null;
		} else {
			while (node.hasLeftChild()) {
				node = node.getLeft();
			}
			return node;
		}
	}

	public BTNode findMax() {
		return findMaxHelper(super.getRoot());
	}

	private BTNode findMaxHelper(BTNode node) {
		if (node == null) {
			return null;
		} else {
			while (node.hasRightChild()) {
				node = node.getRight();
			}
			return node;
		}
	}

	public BTNode findPredecessor(Estoque data) {
		return predecessor(data, false);
	}

	public BTNode findPredecessorIgnoreCase(Estoque data) {
		return predecessor(data, true);
	}

	private BTNode predecessor(Estoque data, boolean ignoreCase) {
		BTNode node = search(data);
		return node == null ? null : predecessorHelper(node, ignoreCase);
	}

	private BTNode predecessorHelper(BTNode node, boolean ignoreCase) {
		if (node.hasLeftChild()) {
			return findMaxHelper(node.getLeft());
		} else {
			BTNode current = node;
			BTNode parent = node.getParent();

			while (parent != null && current == parent.getLeft()) {
				current = parent;
				parent = current.getParent();
			}

			return parent;
		}
	}

	public BTNode findSuccessor(Estoque data) {
		return successor(data, false);
	}

	public BTNode findSuccessorIgnoreCase(Estoque data) {
		return successor(data, true);
	}

	private BTNode successor(Estoque data, boolean ignoreCase) {
		BTNode node = search(data);
		return node == null ? null : successorHelper(node, ignoreCase);		
	}

	private BTNode successorHelper(BTNode node, boolean ignoreCase) {
		if (node.hasRightChild()) {
			return findMinHelper(node.getRight());
		} else {
			BTNode current = node;
			BTNode parent = node.getParent();

			while (parent != null && current == parent.getRight()) {
				current = parent;
				parent = current.getParent();
			}

			return parent;
		}
	}

	@Override
	public String toString() {
		return "BST - isEmpty(): " + isEmpty()
		+ ", getDegree(): " + getDegree()
		+ ", getHeight(): " + getHeight()
		+ ", root => { " + super.getRoot().getData() + " }";				
	}

}

