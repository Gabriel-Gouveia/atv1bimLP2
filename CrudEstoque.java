import java.util.Date;
import java.util.Scanner;
import java.util.List;
import java.text.DateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.io.*;

// Essa classe serve para cadastrar, alterar e excluir itens do estoque.
public class CrudEstoque {

    static List<Item> lista = new ArrayList<>();

    // cadastro de itens no estoque
    public static void cadastrar() {
        boolean excecao = true;

        do {
            try {
                // instancia um item:
                Item item = new Item();
                Scanner s = new Scanner(System.in);
                System.out.println("Digite o codigo do item:");

                // adiciona o código ao objeto instanciado:
                item.setCodigo(Integer.parseInt(s.nextLine()));

                System.out.println("Digite a data de entrada do item:");

                // pega o que o usuário digitou e atribui a uma variável string
                String texto = s.nextLine();

                // formata a data para dia-mês-ano
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                // converte aquela variável string em data e atribui a uma variável data
                Date data = formatter.parse(texto);

                // adiciona a data de entrada ao objeto instanciado:
                item.setDataEntrada(data);

                System.out.println("Digite o local da compra:");
                item.setLocalCompra(s.nextLine());

                System.out.println("Digite o tipo de roupa:");
                item.setTipo(s.nextLine());

                System.out.println("Digite a marca de roupa:");
                item.setMarca(s.nextLine());

                System.out.println("Digite as caracteristicas, uma descricao da roupa");
                item.setCaracteristicas(s.nextLine());

                System.out.println("Tamanho do item: \n1- P\n2- M\n3- G\n4- GG\n5- XG");
                int t = Integer.parseInt(s.nextLine());
                Tamanho eTamanho;
                boolean valid = false;

                do {
                    switch (t) {
                        case 1:
                            eTamanho = Tamanho.P;
                            item.setTamanho("P");
                            valid = true;
                            break;

                        case 2:
                            eTamanho = Tamanho.M;
                            item.setTamanho("M");
                            valid = true;
                            break;

                        case 3:
                            eTamanho = Tamanho.G;
                            item.setTamanho("G");
                            valid = true;
                            break;

                        case 4:
                            eTamanho = Tamanho.GG;
                            item.setTamanho("GG");
                            valid = true;
                            break;

                        case 5:
                            eTamanho = Tamanho.XG;
                            item.setTamanho("XG");
                            valid = true;
                            break;

                        default:
                            System.out.println("Tamanho invalido.");
                            valid = false;
                            break;
                    }
                } while (valid == false);

                /*
                 * switch (eTamanho) { case P:
                 * 
                 * break;
                 * 
                 * default: break; }
                 */

                System.out.println(
                        "Cor do item:\n1- azul\n2- branco\n3- preto\n4- rosa\n5- roxo\n6- vermelho\n7- verde\n8- amarelo\n9- laranja\n10- lilas"
                                + "\n11- bege\n12- marrom\n13- cinza");
                int c = Integer.parseInt(s.nextLine());
                boolean valido = false;
                Cor eCor;

                do {
                    switch (c) {
                        case 1:
                            valido = true;
                            eCor = Cor.AZUL;
                            item.setCor("azul");
                            break;

                        case 2:
                            valido = true;
                            eCor = Cor.BRANCO;
                            item.setCor("branco");
                            break;

                        case 3:
                            valido = true;
                            eCor = Cor.PRETO;
                            item.setCor("preto");
                            break;

                        case 4:
                            valido = true;
                            eCor = Cor.ROSA;
                            item.setCor("rosa");
                            break;

                        case 5:
                            valido = true;
                            eCor = Cor.ROXO;
                            item.setCor("roxo");
                            break;

                        case 6:
                            valido = true;
                            eCor = Cor.VERMELHO;
                            item.setCor("vermelho");
                            break;

                        case 7:
                            valido = true;
                            eCor = Cor.VERDE;
                            item.setCor("verde");
                            break;

                        case 8:
                            valido = true;
                            eCor = Cor.AMARELO;
                            item.setCor("amarelo");
                            break;

                        case 9:
                            valido = true;
                            eCor = Cor.LARANJA;
                            item.setCor("laranja");
                            break;

                        case 10:
                            valido = true;
                            eCor = Cor.LILÁS;
                            item.setCor("lilas");
                            break;

                        case 11:
                            valido = true;
                            eCor = Cor.BEGE;
                            item.setCor("bege");
                            break;

                        case 12:
                            valido = true;
                            eCor = Cor.MARROM;
                            item.setCor("marrom");
                            break;

                        case 13:
                            valido = true;
                            eCor = Cor.CINZA;
                            item.setCor("cinza");
                            break;

                        default:
                            valido = false;
                            System.out.println("Cor invalida");
                            break;
                    }
                } while (valido == false);
                // converte o que o usuário digitou em double e guarda em um atributo do objeto
                // instanciado:
                System.out.println("Digite o valor de etiqueta de compra:");
                item.setValorEtiquetaCompra(Double.parseDouble(s.nextLine()));

                System.out.println("Digite o valor pago na compra:");
                item.setValorPagoCompra(Double.parseDouble(s.nextLine()));

                // O valor para margem de 100% é o valor pago na compra vezes dois.
                item.setValorMargem(item.getValorPagoCompra() * 2);

                System.out.println();
                System.out.println("O valor para margem de 100 porcento eh de: " + item.getValorMargem());
                System.out.println();

                System.out.println("Digite o preco sugerido:");
                item.setPrecoSugerido(Double.parseDouble(s.nextLine()));

                // Se conseguiu converter tudo na entrada de dados, então vamos deixar a
                // variável excecao no valor false para
                // sair do laço de repetição:
                excecao = false;

                lista.add(item);

                s.close();

            }

            catch (NumberFormatException erro) {
                excecao = true;
                System.out.println("Algum numero digitado esta invalido. Tente de novo.");

            }

            catch (ParseException erro) {
                excecao = true;
                System.out.println("A data deve estar errada. Tente de novo.");

            }

        } while (excecao == true);

    }

    public static void escreverArquivo() {
        String conteudo = "";

        for (Item item : lista) {
            conteudo += item.getCodigo() + "¨" + item.getDataEntrada() + "¨" + item.getLocalCompra() + "¨"
                    + item.getTipo() + "¨" + item.getMarca() + "¨" + item.getCaracteristcas() + "¨" + item.getTamanho()
                    + "¨" + item.getCor() + "¨" + item.getValorDeEtiquetaCompra() + "¨" + item.getValorPagoCompra()
                    + "¨" + item.getValorMargem() + "¨" + item.getPrecoSugerido() + "\n";
        }

        Arquivo.Write("estoque.txt", conteudo);
    }

    public static void lerArquivo() {
        List<String> linhas = Arquivo.retornaLinhas("estoque.txt");

        for (String linha : linhas) {

            if (!linha.equals("")) {
                Item item = new Item();
                String[] vetor = linha.split("¨");
                item.setCodigo(Integer.parseInt(vetor[0]));

                try {
                    String texto = vetor[1];

                    // formata a data para dia-mês-ano
                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

                    // converte aquela variável string em data e atribui a uma variável data
                    Date data = formatter.parse(texto);

                    // adiciona a data de entrada ao objeto instanciado:
                    item.setDataEntrada(data);
                }

                catch (ParseException erro) {
                    System.out.println("Erro ao tentar pegar a data de entrada de um dos itens.");
                }

                item.setLocalCompra(vetor[2]);
                item.setTipo(vetor[3]);
                item.setMarca(vetor[4]);
                item.setCaracteristicas(vetor[5]);
                item.setTamanho(vetor[6]);
                item.setCor(vetor[7]);
                item.setValorEtiquetaCompra(Double.parseDouble(vetor[8]));
                item.setValorPagoCompra(Double.parseDouble(vetor[9]));
                item.setValorMargem(Double.parseDouble(vetor[10]));
                item.setPrecoSugerido(Double.parseDouble(vetor[11]));

                lista.add(item);
            }

        }
    }

    public static void alterar() {
        Scanner s = new Scanner(System.in);
        int codigo;
        boolean continuar = true, excecao = true;
        System.out.println("Digite o codigo do item para ser alterado");
        codigo = Integer.parseInt(s.nextLine());

        for (Item item : lista) {
            if (item.getCodigo() == codigo) {
                int opcao;
                do {
                    try {
                        excecao = true;
                        System.out.println("Digite o que deve ser alterado: ");
                        System.out.println("1- Data de entrada");
                        System.out.println("2- Local da compra");
                        System.out.println("3- Tipo");
                        System.out.println("4- Marca");
                        System.out.println("5- Caracteristicas");
                        System.out.println("6- Tamanho");
                        System.out.println("7- Cor");
                        System.out.println("8- Valor de etiqueta na compra");
                        System.out.println("9- Valor pago na compra");
                        System.out.println("10- Preco sugerido");
                        opcao = Integer.parseInt(s.nextLine());
                        excecao = false;

                        switch (opcao) {
                            case 1:
                                System.out.println("Digite a nova data: ");
                                try {
                                    String texto = s.nextLine();
                                    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                                    Date data = formatter.parse(texto);
                                    item.setDataEntrada(data);

                                    System.out.println("Nova data: " + item.getDataEntrada());

                                    System.out.println("Continuar? [S/N]");
                                    String decisao = s.nextLine().trim().toUpperCase();

                                    if (decisao.equals("N")) {
                                        continuar = false;
                                        return;
                                    }

                                }

                                catch (ParseException erro) {
                                    System.out.println("Erro ao tentar pegar a data de entrada de um dos itens.");
                                }

                                break;

                            case 2:
                                System.out.println("Digite o novo local da compra:");
                                item.setLocalCompra(s.nextLine());
                                System.out.println("Novo local: " + item.getLocalCompra());

                                System.out.println("Continuar? [S/N]");
                                String decisao = s.nextLine().trim().toUpperCase();

                                if (decisao.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 3:
                                System.out.println("Digite o novo tipo: ");
                                item.setTipo(s.nextLine());
                                System.out.println("Novo tipo: " + item.getTipo());

                                System.out.println("Continuar? [S/N]");
                                String decisao1 = s.nextLine().trim().toUpperCase();

                                if (decisao1.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 4:
                                System.out.println("Digite a nova marca:");
                                item.setMarca(s.nextLine());
                                System.out.println("Nova marca: " + item.getMarca());

                                System.out.println("Continuar? [S/N]");
                                String decisao2 = s.nextLine().trim().toUpperCase();

                                if (decisao2.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 5:
                                System.out.println("Digite as novas caracteristicas:");
                                item.setCaracteristicas(s.nextLine());
                                System.out.println("Novas caracteristicas " + item.getCaracteristcas());

                                System.out.println("Continuar? [S/N]");
                                String decisao3 = s.nextLine().trim().toUpperCase();

                                if (decisao3.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 6:
                                System.out.println("Digite o novo tamanho:");
                                item.setTamanho(s.nextLine());
                                System.out.println("Novo tamanho: " + item.getTamanho());

                                System.out.println("Continuar? [S/N]");
                                String decisao91 = s.nextLine().trim().toUpperCase();

                                if (decisao91.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 7:
                                System.out.println("Digite a nova cor:");
                                item.setCor(s.nextLine());
                                System.out.println("Nova cor: " + item.getCor());

                                System.out.println("Continuar? [S/N]");
                                String decisao100 = s.nextLine().trim().toUpperCase();

                                if (decisao100.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 8:
                                System.out.println("Digite o novo valor de etiqueta:");
                                item.setValorEtiquetaCompra(Double.parseDouble(s.nextLine()));
                                System.out.println("Nova valor de etiqueta " + item.getValorDeEtiquetaCompra());

                                System.out.println("Continuar? [S/N]");
                                String decisao4 = s.nextLine().trim().toUpperCase();

                                if (decisao4.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 9:
                                System.out.println("Digite o novo valor pago na compra:");
                                item.setValorPagoCompra(Double.parseDouble(s.nextLine()));
                                System.out.println("Novo valor pago na compra: " + item.getValorPagoCompra());

                                System.out.println("Continuar? [S/N]");
                                String decisao5 = s.nextLine().trim().toUpperCase();

                                if (decisao5.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            case 10:
                                System.out.println("Digite o novo preco sugerido:");
                                item.setPrecoSugerido(Double.parseDouble(s.nextLine()));
                                System.out.println("Novo preco sugerido: " + item.getPrecoSugerido());

                                System.out.println("Continuar? [S/N]");
                                String decisao6 = s.nextLine().trim().toUpperCase();

                                if (decisao6.equals("N")) {
                                    continuar = false;
                                    return;
                                }
                                break;

                            default:
                                System.out.println("opcao invalida.");
                                break;
                        }
                    } catch (NumberFormatException ex) {
                        excecao = true;
                        System.out.println("opcao invalida.");
                    }
                } while (continuar == true || excecao == true);
            }
        }
        s.close();
    }

    public static void deletar() {
        int codigo;
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o codigo do item a ser excluido:");
        codigo = Integer.parseInt(s.nextLine());

        System.out.println("Tem certeza? [S/N]");
        String confirmacao = s.nextLine().trim().toUpperCase();

        if (confirmacao.equals("S")) {
            for (Item item : lista) {
                if (item.getCodigo() == codigo) {
                    lista.remove(item);
                }
            }
        }

        for (Item item : lista) {
            System.out.println();
            System.out.println("Codigo: " + item.getCodigo());
            System.out.println("Data de entrada: " + item.getDataEntrada());
            System.out.println("Local da compra: " + item.getLocalCompra());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Marca: " + item.getMarca());
            System.out.println("Caracteristicas: " + item.getCaracteristcas());
            System.out.println("Tamanho: " + item.getTamanho());
            System.out.println("Cor: " + item.getCor());
            System.out.println("Valor de etiqueta na compra: " + item.getValorDeEtiquetaCompra());
            System.out.println("Valor pago na compra: " + item.getValorPagoCompra());
            System.out.println("Valor para margem de 100 porcento: " + item.getValorMargem());
            System.out.println("Preco sugerido: " + item.getPrecoSugerido());
        }

        s.close();
    }

    public static void main(String[] args) {
        File f = new File("estoque.txt");
        int opcao;        
        boolean flag = true;
        if (f.exists()) {
            lerArquivo();
        }

        do {
            try {
                do {
                    Scanner s = new Scanner(System.in);
                    System.out.println("1- cadastrar \n 2- alterar \n 3- deletar \n 4- consultar \n 5- sair");
                    opcao = Integer.parseInt(s.nextLine());
                    flag = false;

                    switch (opcao) {
                        case 1:
                            cadastrar();
                            escreverArquivo();
                            break;

                        case 2:
                            if (f.exists()) {
                                alterar();
                                escreverArquivo();
                            }

                            else {
                                System.out.println("Nao ha o que alterar.");
                            }
                            break;

                        case 3:
                            if (f.exists()) {
                                deletar();
                                escreverArquivo();
                            } else {
                                System.out.println("Nao ha o que deletar.");

                            }
                            break;

                        case 4:
                            for (Item item : lista) {
                                System.out.println();
                                System.out.println("Codigo: " + item.getCodigo());
                                System.out.println("Data de entrada: " + item.getDataEntrada());
                                System.out.println("Local da compra: " + item.getLocalCompra());
                                System.out.println("Tipo: " + item.getTipo());
                                System.out.println("Marca: " + item.getMarca());
                                System.out.println("Caracteristicas: " + item.getCaracteristcas());
                                System.out.println("Tamanho: " + item.getTamanho());
                                System.out.println("Cor: " + item.getCor());
                                System.out.println("Valor de etiqueta na compra: " + item.getValorDeEtiquetaCompra());
                                System.out.println("Valor pago na compra: " + item.getValorPagoCompra());
                                System.out.println("Valor para margem de 100 porcento: " + item.getValorMargem());
                                System.out.println("Preco sugerido: " + item.getPrecoSugerido());
                            }
                            break;

                        case 5:
                            System.out.println("tchau");
                            return;

                        default:
                            System.out.println("Opcao invalida.");
                            break;
                    }
                    s.close();
                } while (opcao != 5);

            } catch (NumberFormatException ex) {
                System.out.println("opcao invalida.");
            }
        } while (flag == true);        
    }

}
