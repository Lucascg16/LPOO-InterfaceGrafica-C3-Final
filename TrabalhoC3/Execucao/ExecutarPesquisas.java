package TrabalhoC3.Execucao;

import java.util.ArrayList;
import TrabalhoC3.Classes.*;
import TrabalhoC3.Manipuladores.*;
import java.io.FileNotFoundException;

public class ExecutarPesquisas {

	static final ArrayList <Long> listaCPFs = lerCPFs();

    public static ArrayList<Compra> pesquisaABB (byte tipoArquivo) {

        ArrayList<Compra> arquivoLeitura = lerDados(tipoArquivo);
        NoABB noPesquisa = new NoABB();
        ArvoreABB arvoreBalanceada = new ArvoreABB();
        ArrayList<NoABB> vetorOrdenado = new ArrayList<>();
        ArrayList<Compra> retornoPesquisa = new ArrayList<>(0);

        for (int contadorInsercao = 0; contadorInsercao < arquivoLeitura.size(); contadorInsercao++) {

            arvoreBalanceada.inserir(arquivoLeitura.get(contadorInsercao));
        }

        vetorOrdenado = arvoreBalanceada.emOrdem();
        arvoreBalanceada = arvoreBalanceada.balancear(vetorOrdenado);

        for (int contadorPesquisa = 0; contadorPesquisa < listaCPFs.size(); contadorPesquisa++) {
            
            noPesquisa = arvoreBalanceada.pesquisarABB(listaCPFs.get(contadorPesquisa));

            if(noPesquisa != null) {

                for (int contadorLista = 0; contadorLista < noPesquisa.getInformacao().size(); contadorLista++) {

                    retornoPesquisa.add(noPesquisa.getInformacao().get(contadorLista));
                }
                
            }
        }
            
        return retornoPesquisa;
    }

    public static ArrayList<Compra> pesquisaAVL (byte tipoArquivo) {

        ArrayList <Compra> arquivoLeitura = lerDados(tipoArquivo);
        ArvoreAVL arvoreAVL = new ArvoreAVL();
        NoAVL noPesquisa = new NoAVL();
        ArrayList<Compra> retornoPesquisa = new ArrayList<>();

        for (int contadorInsercao = 0; contadorInsercao < arquivoLeitura.size(); contadorInsercao++) {

            arvoreAVL.inserir(arquivoLeitura.get(contadorInsercao));
        }

        for (int contadorPesquisa = 0; contadorPesquisa < listaCPFs.size(); contadorPesquisa++) {
        
            noPesquisa = arvoreAVL.pesquisa(listaCPFs.get(contadorPesquisa));
            
            if (noPesquisa != null) {
            
                for (int contadorLista = 0; contadorLista < noPesquisa.getInformacao().size(); contadorLista++) {

                    retornoPesquisa.add(noPesquisa.getInformacao().get(contadorLista));
                }
            }
        }

        return retornoPesquisa;
    }

    public static ArrayList<Compra> pesquisaHash (byte tipoArquivo) {

        ArrayList<Compra> arquivoLeitura = lerDados(tipoArquivo);
        ListaHash listaHash = new ListaHash((int) ((arquivoLeitura.size())*1.1)+1);
        ArrayList<Compra> retornoPesquisa = new ArrayList<>();

        for (int contadorInserir = 0; contadorInserir < arquivoLeitura.size(); contadorInserir++) {

            listaHash.adicionarListaHash(arquivoLeitura.get(contadorInserir));
        }

        for (int contadorPesquisa = 0; contadorPesquisa < listaCPFs.size(); contadorPesquisa++) {
        
            ArrayList <Compra> pesquisaHash = listaHash.pesquisarCPF(listaCPFs.get(contadorPesquisa));
            
            if (pesquisaHash.isEmpty() == false) {
            
                for (int contadorLista = 0; contadorLista < pesquisaHash.size(); contadorLista++) {

                    retornoPesquisa.add(pesquisaHash.get(contadorLista));
                }
            }
        }

        return retornoPesquisa;
    }

    private static ArrayList<Long> lerCPFs () {
		
		ArrayList<Long> listaCPFs = new ArrayList<>();

		try {

			LeDados arquivo = new LeDados("TrabalhoC3/Dados/ListaCPFs.txt");
			listaCPFs = arquivo.lerCPF();
		
		} catch (FileNotFoundException erro) {
			
			System.err.print(erro);
		}
	
		return listaCPFs;
	}

    private static ArrayList<Compra> lerDados (byte tipoArquivo) {

        CadastraCompra listaDados = new CadastraCompra();
        ArrayList<Compra> dadosCompra = new ArrayList<>();
        LeDados arquivo;

        try {

            switch (tipoArquivo) {

                case 1:
                        arquivo = new LeDados("TrabalhoC3/Dados/500_Aleatorios.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 2:
                        arquivo = new LeDados("TrabalhoC3/Dados/500_Invertidos.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 3:
                        arquivo = new LeDados("TrabalhoC3/Dados/500_Ordenados.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 4:
                        arquivo = new LeDados("TrabalhoC3/Dados/1000_Aleatorios.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 5:
                        arquivo = new LeDados("TrabalhoC3/Dados/1000_Invertidos.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 6:
                        arquivo = new LeDados("TrabalhoC3/Dados/1000_Ordenados.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 7:
                        arquivo = new LeDados("TrabalhoC3/Dados/5000_Aleatorios.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 8:
                        arquivo = new LeDados("TrabalhoC3/Dados/5000_Invertidos.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 9:
                        arquivo = new LeDados("TrabalhoC3/Dados/5000_Ordenados.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 10:
                        arquivo = new LeDados("TrabalhoC3/Dados/10000_Aleatorios.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 11:
                        arquivo = new LeDados("TrabalhoC3/Dados/10000_Invertidos.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 12:
                        arquivo = new LeDados("TrabalhoC3/Dados/10000_Ordenados.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 13:
                        arquivo = new LeDados("TrabalhoC3/Dados/50000_Aleatorios.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 14:
                        arquivo = new LeDados("TrabalhoC3/Dados/50000_Invertidos.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;

                case 15:
                        arquivo = new LeDados("TrabalhoC3/Dados/50000_Ordenados.txt");
                        listaDados.setVetorCompra(arquivo.ler());
                        arquivo.fecha();
                    break;
            }

            for (int contador = 0; contador < listaDados.getVetorCompra().size(); contador++) {

                dadosCompra.add(listaDados.getVetorCompra().get(contador));
            }
            		
		} catch (FileNotFoundException erro) {
			
			System.err.print(erro);

		} catch (NumberFormatException erro) {
			
			System.err.print(erro);

		} catch (ArrayIndexOutOfBoundsException erro) {
			
			System.err.print(erro);
		}
	
        return dadosCompra;
    }

    public static ArrayList<Compra> pesquisarCPF (byte tipoArquivo, byte quantidadeDados, String CPFPesquisar) {

        ArrayList<Compra> listaAuxiliar = new ArrayList<>();
        ArrayList<Compra> retornoPesquisa = new ArrayList<>();
        long cpfPesquisar = Long.parseLong(CPFPesquisar);

        switch (tipoArquivo) {

            case 1:
                    listaAuxiliar = pesquisaABB(quantidadeDados);
                break;

            case 2:
                    listaAuxiliar = pesquisaAVL(quantidadeDados);
                break;
            
            case 3:
                    listaAuxiliar = pesquisaHash(quantidadeDados);
                break;
        }

        for (int contador = 0; contador < listaAuxiliar.size(); contador++) {

            if (listaAuxiliar.get(contador).getCliente().getCPF() == cpfPesquisar) {
                
                retornoPesquisa.add(listaAuxiliar.get(contador));
            }
        }
        return retornoPesquisa;
    }
}