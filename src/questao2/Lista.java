package questao2;

class Lista {
	int no;
	Vizinho prox_viz;
	Lista prox_no;

	Lista(int c) {
		no = c;
		prox_viz = null;
		prox_no = null;
	}

	Vizinho pertence(int no) {
		Vizinho resp = prox_viz;
		while ((resp != null) && (no != resp.no_viz))
			resp = resp.prox;
		return resp;
	}

	void ins_Viz(int c) {
		Vizinho v = pertence(c);
		if (v != null)
			return;
		v = new Vizinho(c);
		v.prox = prox_viz;
		prox_viz = v;
	}

	public String toString() {
		String resp = no + ": \n";
		Vizinho p = prox_viz;
		while (p != null) {
			resp += p.toString();
			p = p.prox;
		}
		return resp + "\n";
	}
}