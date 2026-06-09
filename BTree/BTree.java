package btree;

public class BTree <T extends Comparable<T>> {
	private BNode<T> root;
	private int orden;
	private boolean up;
	private BNode<T> nDes;

	public BTree(int orden) {
		this.orden = orden;
		this.root = null;
	}
	
	public BNode<T> getRoot(){
		return this.root;
	}

	public boolean isEmpty() {
		return this.root == null;
	}

	//==============================================
	public void insert(T cl) {
		up = false;
		T mediana;
		BNode<T> pnew;
		mediana = push(this.root, cl);
		
		if (up) {
			pnew = new BNode<T>(this.orden);
			pnew.count = 1;

			pnew.keys.set(0, mediana);
			pnew.childs.set(0, this.root);
			pnew.childs.set(1, nDes);
			this.root = pnew;
		}
	}
	
	//==========================================
	private T push(BNode<T> current, T cl){
		int pos[] = new int[1];
		T mediana;
		if(current == null)	{
			up = true;
			nDes = null;
			return cl;
			
		} else {
			boolean fl;
			fl = current.searchNode(cl, pos);
			if(fl){
				System.out.println("Item duplicado\n");
				up = false;
				return null;
			}
			
			mediana = push(current.childs.get(pos[0]),cl);
			if(up){
				if(current.nodeFull(this.orden-1))
					mediana = dividedNode(current, mediana, pos[0]);
				else {
					up = false;
					putNode(current, mediana, nDes, pos[0]);
				}
			}
	
			return mediana;
		}
	}
	
	//===========================================
	private void putNode(BNode<T> current, T cl, BNode<T> rd, int k){
		int i;
		for(i = current.count-1; i >= k; i--) {
			current.keys.set(i + 1, current.keys.get(i));
			current.childs.set(i + 2, current.childs.get(i+1));
		}
		
		current.keys.set(k, cl);
		current.childs.set(k+1, rd);
		current.count++;
	}
	
	//==========================================
	private T dividedNode(BNode<T> current, T cl, int k) { 
		BNode<T> rd = nDes;
		int i, posMdna;
		
		posMdna = (k <= this.orden/2) ? this.orden/2 : this.orden/2+1;
		nDes = new BNode<T>(this.orden);
		
		for(i = posMdna; i < this.orden - 1; i++) { 
			nDes.keys.set(i - posMdna, current.keys.get(i));
			nDes.childs.set(i - posMdna + 1, current.childs.get(i+1));
		}
			
		nDes.count = (this.orden - 1) - posMdna;
		current.count = posMdna;
			
		if(k <= this.orden/2)
			putNode(current, cl, rd, k);
		else
			putNode(nDes, cl, rd, k-posMdna);
			
		T median = current.keys.get(current.count - 1);
		nDes.childs.set(0, current.childs.get(current.count));
		current.count--;
		return median;
	}
	
	//=====================================
	@Override
	public String toString() {
		String s = "";
		if(isEmpty()) {
			s+= "BTree is Empty . . .";
		} else {
			s += "ID\tCLAVES\tPADRE\tHIJOS\n";
			s = writeTree(this.root, null);
		}
		
		return s;
	}
	
	private String writeTree(BNode<T> current, BNode<T> parent) {
		if (current == null) {
			return "";
		}
		
		String s = "";
		
		String claves = "(";
		for (int i = 0; i < current.count; i++) {
			claves += current.keys.get(i);
			
			if (i < current.count - 1) {
				claves += ", ";
			}
		}
		claves += ")";
		
		String padre = (parent == null) ? "--" : String.valueOf(parent.idNode);
		
		String hijos = "";
		boolean tieneHijos = false;
		
		for (int i = 0; i <= current.count; i++) {
			if (current.childs.get(i) != null) {
				
				if (!tieneHijos) {
					hijos += "[";
				} else {
					hijos += ", ";
				}
				
				hijos += current.childs.get(i).idNode;
				tieneHijos = true;
			}
		}
		
		if (tieneHijos) {
			hijos += "]";
		} else {
			hijos = "--";
		}
		
		s += current.idNode + "\t"
		   + claves + "\t"
		   + padre + "\t"
		   + hijos + "\n";
		
		for (int i = 0; i <= current.count; i++) {
			if (current.childs.get(i) != null) {
				s += writeTree(current.childs.get(i), current);
			}
		}
		
		return s;
	}
	
	//============================================
	//EJERCICIO 1 ============== ========== ===========
	//==========================================
	public boolean search(T cl) {
		return search(this.root, cl);
	}
	
	private boolean search(BNode<T> current, T cl) {
		if (current == null) {
			return false;
		}
		
		int[] posicion = new int[1];
		if (current.searchNode(cl, posicion)) {
			System.out.println(cl + " se encuentra en el nodo " + current.idNode + " en la posicion " + posicion[0]);
			return true;
		}
		
		return search(current.childs.get(posicion[0]), cl);
	}
	
	//EJERCICIO 02 ============ ================== ============
	public void searchRange(T min, T max) {
		if(min == null || max == null) {
			System.out.println("Rango invalido");
			return;
		}
		
		if(min.compareTo(max) > 0) {
			System.out.println("Rango invalido");
			return;
		}
		
		searchRange(this.root, min, max);
		System.out.println();
	}
	
	private void searchRange(BNode<T> current, T min, T max) {
	    if (current == null) {
	        return;
	    }

	    for (int i = 0; i < current.count; i++) {
	        if (current.keys.get(i).compareTo(min) >= 0) {
	            searchRange(current.childs.get(i), min, max);
	        }

	        if (current.keys.get(i).compareTo(min) >= 0 &&
	            current.keys.get(i).compareTo(max) <= 0) {

	            System.out.print(current.keys.get(i) + " ");
	        }

	        if (current.keys.get(i).compareTo(max) > 0) {
	            return;
	        }
	    }

	    searchRange(current.childs.get(current.count), min, max);
	}
	
	//======================================================
	//EJERCICIO 03 =========== =============== ==================
	//===================== ========================== ============
	public void delete(T key) {
	    if (root == null) {
	    	System.out.println("El arbol esta vacio");
	        return;
	    }

	    delete(root, key);

	    if (root.count == 0) {
	        if(root.childs.get(0) == null) {
	            root = null;
	        } else {
	            root = root.childs.get(0);
	        }
	    }
	}
	
	// ======== ===========
	private boolean delete(BNode<T> node, T key) {
		int pos[] = new int[1];
		boolean found = node.searchNode(key, pos);

		if (found) {
			if (node.childs.get(pos[0]) == null) {
				removeKey(node, pos[0]);
				return true;

			} else {
				T pred = getPredecessor(node, pos[0]);
				node.keys.set(pos[0], pred);
				return delete(node.childs.get(pos[0]), pred);
			}

		} else {
			if (node.childs.get(pos[0]) == null) {
				return false;

			} else {
				boolean isDeleted = delete(node.childs.get(pos[0]), key);
				if (node.childs.get(pos[0]).count < (orden - 1) / 2) {
					fix(node, pos[0]);
				}

				return isDeleted;
			}
		}
	}
	
	//====================
	private void removeKey(BNode<T> node, int index) {
		for(int i = index; i < node.count - 1; i++) {
			node.keys.set(i, node.keys.get(i + 1));
		}
		
		node.keys.set(node.count - 1, null);
		node.count --;
	}
	
	//=========== ============
	private T getPredecessor(BNode<T> node, int index) {
		BNode<T> current = node.childs.get(index);
		while (current.childs.get(current.count) != null) {
			current = current.childs.get(current.count);
		}
		
		return current.keys.get(current.count - 1);
	}
	
	//==============
	private void fix(BNode<T> parent, int index) {
		if (index > 0 && parent.childs.get(index - 1).count > (orden - 1) / 2) {
			borrowFromLeft(parent, index);

		} else if (index < parent.count && parent.childs.get(index + 1).count > (orden - 1) / 2) {
			borrowFromRight(parent, index);

		} else {
			if (index > 0) {
				merge(parent, index - 1);
			} else {
				merge(parent, index);
			}
		}
	}
	
	//======== ============
	private void borrowFromLeft(BNode<T> parent, int index) {
		BNode<T> left = parent.childs.get(index - 1);
		BNode<T> current = parent.childs.get(index);

		for (int i = current.count - 1; i >= 0; i--) {
			current.keys.set(i + 1, current.keys.get(i));
		}

		current.keys.set(0, parent.keys.get(index - 1));
		parent.keys.set(index - 1, left.keys.get(left.count - 1));
		left.keys.set(left.count - 1, null);

		if (left.childs.get(left.count) != null) {
			for (int i = current.count; i >= 0; i--) {
				current.childs.set(i + 1, current.childs.get(i));
			}

			current.childs.set(0, left.childs.get(left.count));
			left.childs.set(left.count, null);
		}

		current.count++;
		left.count--;
	}
	
	//================= ============
	private void borrowFromRight(BNode<T> parent, int index) {
		BNode<T> current = parent.childs.get(index);
		BNode<T> right = parent.childs.get(index + 1);

		current.keys.set(current.count,parent.keys.get(index));

		if (right.childs.get(0) != null) {
			current.childs.set(current.count + 1, right.childs.get(0));
		}

		current.count++;
		parent.keys.set(index, right.keys.get(0));

		for (int i = 0; i < right.count - 1; i++) {
			right.keys.set(i, right.keys.get(i + 1));
		}

		if (right.childs.get(0) != null) {
			for (int i = 0; i < right.count; i++) {
				right.childs.set(i, right.childs.get(i + 1));
			}
		}

		right.keys.set(right.count - 1, null);
		if (right.childs.get(0) != null) {
			right.childs.set(right.count, null);
		}

		right.count--;
	}
	
	//============= ===================
	private void merge(BNode<T> parent, int index) {
		BNode<T> left = parent.childs.get(index);
		BNode<T> right = parent.childs.get(index + 1);

		left.keys.set(left.count, parent.keys.get(index));
		left.count++;

		for (int i = 0; i < right.count; i++) {
			left.keys.set(left.count + i, right.keys.get(i));
		}

		for (int i = 0; i <= right.count; i++) {
			left.childs.set(left.count + i, right.childs.get(i));
		}

		left.count += right.count;

		for (int i = index; i < parent.count - 1; i++) {
			parent.keys.set(i, parent.keys.get(i + 1));
			parent.childs.set(i + 1, parent.childs.get(i + 2));
		}

		parent.keys.set(parent.count - 1, null);
		parent.childs.set(parent.count, null);
		parent.count--;
	}
	
	// ============ ============= ============ =========
	public int height() {
	    return height(this.root);
	}

	private int height(BNode<T> current) {
	    if (current == null) {
	        return 0;
	    }

	    if (current.childs.get(0) == null) {
	        return 1;
	    }

	    return 1 + height(current.childs.get(0));
	}
	
	// =============== ============== ==============
	public int count() {
	    return count(this.root);
	}

	private int count(BNode<T> current) {
	    if (current == null) {
	        return 0;
	    }

	    int total = current.count;

	    for (int i = 0; i <= current.count; i++) {
	        total += count(current.childs.get(i));
	    }

	    return total;
	}
}
