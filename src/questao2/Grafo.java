package questao2;

import java.util.HashSet;

class Grafo {
	Lista prim;

	Grafo() {
		prim = null;
	}

	Lista pertence(int no) {
		Lista resp = prim;
		while ((resp != null) && (no != resp.no))
			resp = resp.prox_no;
		return resp;
	}

	void insere(int no) {
		Lista p = pertence(no);
		if (p == null) {
			p = new Lista(no);
			Lista q = prim;
			if (q == null) {
				prim = p;
				return;
			}
			while (q.prox_no != null)
				q = q.prox_no;
			q.prox_no = p;
		}
	}

	void insere(int no1, int no2) {
		Lista p = pertence(no1);
		p.ins_Viz(no2);
	}

	public String toString() {
		String resp = "";
		Lista p = prim;
		while (p != null) {
			resp += p.toString();
			p = p.prox_no;
		}
		return resp;
	}

	String classifica() {
		String classificacao = "";
		if (isBipartido()) {
			classificacao += "Bipartido";
		}
		if (isCompleto()) {
			if (!classificacao.isEmpty()) {
				classificacao += " - ";
			}
			classificacao += "Completo";
		}
		if (isRegular()) {
			if (!classificacao.isEmpty()) {
				classificacao += " - ";
			}
			classificacao += "Regular";
		}
		if (classificacao.isEmpty()) {
			return "Simples";
		}
		return classificacao;
	}

	private HashSet<Integer> getNos() {
		HashSet<Integer> nos = new HashSet<>();
		Lista resp = prim;
		while (resp != null) {
			nos.add(resp.no);
			resp = resp.prox_no;
		}
		return nos;
	}


	boolean isCompleto() {
		Lista atual = prim;
		while (atual != null) {
			Vizinho vizinhoAtual = atual.prox_viz;
			HashSet<Integer> nos = getNos();
			nos.remove(atual.no);
			while (vizinhoAtual != null) {
				nos.remove(vizinhoAtual.no_viz);
				vizinhoAtual = vizinhoAtual.prox;
			}
			if (!nos.isEmpty()) {
				return false;
			}
			atual = atual.prox_no;
		}
		return getNos().size()>1;
	}

	boolean isBipartido() {
		HashSet<Integer> nos = getNos();
		HashSet<Integer> c1 = new HashSet<>();
		HashSet<Integer> c2 = new HashSet<>();
		if (prim != null) {
			c1.add(prim.no);
		}
		HashSet<Integer> nosVerificados = new HashSet<>();
		while (nosVerificados.size() < nos.size()) {
			Lista atual = prim;
			while (atual != null) {
				if (!nosVerificados.contains(atual.no) && (c1.contains(atual.no) || c2.contains(atual.no))) {
					Vizinho vizinhoAtual = atual.prox_viz;
					while (vizinhoAtual != null) {
						if (c1.contains(atual.no)) {
							if (c1.contains(vizinhoAtual.no_viz)) {
								return false;
							} else {
								c2.add(vizinhoAtual.no_viz);
							}
						} else if (c2.contains(atual.no)) {
							if (c2.contains(vizinhoAtual.no_viz)) {
								return false;
							} else {
								c1.add(vizinhoAtual.no_viz);
							}
						}
						vizinhoAtual = vizinhoAtual.prox;
					}
					nosVerificados.add(atual.no);
				}
				atual = atual.prox_no;
			}
		}
		return !(c1.isEmpty()||c2.isEmpty());
	}

	boolean isRegular() {
		Integer vizinhos = null;
		Lista atual = prim;
		while (atual != null) {
			int vizinhoCont = 0;
			Vizinho vizinhoAtual = atual.prox_viz;
			while (vizinhoAtual != null) {
				vizinhoCont++;
				vizinhoAtual = vizinhoAtual.prox;
			}
			if (null == vizinhos) {
				vizinhos = vizinhoCont;
			}
			if (vizinhoCont != vizinhos) {
				return false;
			}
			atual = atual.prox_no;
		}
		return true;
	}
}