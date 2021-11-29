package TrabalhoC3.Classes;

import java.util.ArrayList;
import java.util.Calendar;
import TrabalhoC3.Interfaces.*;

public class CadastraCompra implements Vetor {

    private ArrayList<Compra> vetorCompra;

    public CadastraCompra () {

        this.vetorCompra = new ArrayList<>();
    }

    public ArrayList<Compra> getVetorCompra () {

        return vetorCompra;
    }

    public void setVetorCompra (ArrayList<Compra> novoVetorCompra) {

        this.vetorCompra = novoVetorCompra;
    }

    @Override
    public Compra get (int posicao) {

        return vetorCompra.get(posicao);
    }

    @Override
    public void inserir (Compra compra) {

        vetorCompra.add(compra);
    }

    @Override
    public void remover (long CPF, Calendar data) {

        for (int contador = 0; contador < vetorCompra.size(); contador++) {

            if ((vetorCompra.get(contador).getCliente().getCPF() == CPF) && (vetorCompra.get(contador).getData() == data)) {

                vetorCompra.remove(contador);
                contador--;
            }
        }
    }

}