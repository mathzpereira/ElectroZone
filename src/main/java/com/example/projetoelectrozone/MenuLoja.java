package com.example.projetoelectrozone;

import com.example.projetoelectrozone.controllers.*;
import com.example.projetoelectrozone.models.Compra;
import com.example.projetoelectrozone.models.Produto;
import com.example.projetoelectrozone.models.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public interface MenuLoja {

    static MenuHelper menuCliente(Usuario u) {
        Scanner in = new Scanner(System.in);
        ProdutoDAO produtoDAO = new ProdutoDAO();
        CompraDAO compraDAO = new CompraDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        Carrinho_has_ProdutoDAO carrinhoHasProdutoDAO = new Carrinho_has_ProdutoDAO();
        Compra_has_ProdutoDAO compraHasProdutoDAO = new Compra_has_ProdutoDAO();
        MenuHelper menuHelper = new MenuHelper(true, true);

        int opcao;
        int idCarrinho = carrinhoDAO.selectCarrinhoID(u.getIdUsuario());
        String email = u.getEmail();
        String senha = u.getSenha();

        System.out.println("Seu saldo é de: R$ " + String.format("%.2f", u.getSaldo()));
        System.out.println("------------------------------------------------");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Listar Produtos");
        System.out.println("2 - Adicionar Produto ao Carrinho");
        System.out.println("3 - Ver carrinho");
        System.out.println("4 - Remover Produto do Carrinho");
        System.out.println("5 - Finalizar Pedido");
        System.out.println("6 - Fazer um depósito");
        System.out.println("7 - Ver compras");
        System.out.println("8 - Fazer logout");
        System.out.println("9 - Encerrar");
        opcao = in.nextInt();
        switch (opcao) {
            case 1:
                produtoDAO.selectProduto();
                break;
            case 2:
                System.out.print("Adicionar produto ao carrinho: ");
                int idproduto = in.nextInt();
                carrinhoHasProdutoDAO.insertCarrinho_has_Produto(idCarrinho, idproduto);
                System.out.println("Produto adicionado ao Carrinho");
                break;
            case 3:
                carrinhoHasProdutoDAO.exibirProdutosCarrinho(u.getIdUsuario());
                break;
            case 4:
                System.out.print("Informe o id do Produto: ");
                int idprodutoAux = in.nextInt();
                carrinhoHasProdutoDAO.deleteCarrinho_Has_Produto(idCarrinho, idprodutoAux);
                System.out.println("Produto removido do Carrinho");
                break;
            case 5:
                double valorCompra = carrinhoHasProdutoDAO.exibirProdutosCarrinho(u.getIdUsuario());
                System.out.println("Digite sua senha para concluir a compra: ");
                in.nextLine();
                senha = in.nextLine();
                try {
                    if (usuarioDAO.selectUsuarioLogin(email, senha) == null)
                        throw new WrongPasswordException();
                    else {
                        if (valorCompra <= u.getSaldo()) {
                            Compra compra = new Compra(valorCompra, LocalDate.now().toString(), u.getIdUsuario());
                            compraDAO.insertCompra(compra);
                            ArrayList<Integer> idProdutos = carrinhoHasProdutoDAO.selectProdutosCarrinho(idCarrinho);
                            int idCompra = compraDAO.selectUltimaCompraID(u.getIdUsuario());
                            for (int produto : idProdutos) {
                                compraHasProdutoDAO.insertCompra_has_Produto(idCompra, produto);
                                produtoDAO.diminuirEstoque(produto);
                            }
                            carrinhoHasProdutoDAO.removerItensCarrinho(idCarrinho);
                            usuarioDAO.removerSaldo(u.getIdUsuario(), valorCompra);
                        } else {
                            new SaldoInsuficienteException();
                        }
                    }
                } catch (WrongPasswordException e) {
                }
                break;
            case 6:
                System.out.print("Digite o valor que deseja depositar: R$ ");
                double valor = in.nextDouble();
                System.out.println("Digite sua senha para confirmar o depósito: ");
                in.nextLine();
                senha = in.nextLine();
                try {
                    if (usuarioDAO.selectUsuarioLogin(email, senha) == null)
                        throw new WrongPasswordException();
                    else
                        usuarioDAO.depositar(u.getIdUsuario(), valor);
                } catch (WrongPasswordException e) {
                }
                break;
            case 7:
                compraDAO.verCompras(u.getIdUsuario());
                break;
            case 8:
                System.out.println("Saindo da conta...");
                menuHelper.setSucesso(false);
                break;
            case 9:
                menuHelper.setFlag(false);
                menuHelper.setSucesso(false);
                break;
        }
        return menuHelper;
    }

    static MenuHelper menuADM(Usuario u) {
        Scanner in = new Scanner(System.in);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        CompraDAO compraDAO = new CompraDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        CarrinhoDAO carrinhoDAO = new CarrinhoDAO();
        Carrinho_has_ProdutoDAO carrinhoHasProdutoDAO = new Carrinho_has_ProdutoDAO();
        Compra_has_ProdutoDAO compraHasProdutoDAO = new Compra_has_ProdutoDAO();
        MenuHelper menuHelper = new MenuHelper(true, true);

        System.out.println("------------------------------------------------");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Adicionar um novo Produto");
        System.out.println("2 - Listar Produtos");
        System.out.println("3 - Atualizar um Produto");
        System.out.println("4 - Remover um Produto da Loja");
        System.out.println("5 - Listar Usuários");
        System.out.println("6 - Criar um novo Administrador");
        System.out.println("7 - Fazer logout");
        System.out.println("8 - Encerrar");

        int opcao;
        int idCarrinho = carrinhoDAO.selectCarrinhoID(u.getIdUsuario());
        String email = u.getEmail();
        String senha = u.getSenha();

        opcao = in.nextInt();

        in.nextLine();

        switch (opcao) {

            case 1:

                System.out.println("Id do produto");
                int idproduto = in.nextInt();

                in.nextLine();

                System.out.println("Nome do Produto");
                String nome = in.nextLine();

                System.out.println("Valor do produto");
                double valor = in.nextDouble();

                System.out.println("Quantidade disponivel");
                int qtd_disponivel = in.nextInt();
                in.nextLine();

                System.out.println("Categoria");
                String categoria = in.nextLine();

                Produto produto=new Produto(idproduto,nome,valor,qtd_disponivel,categoria);

                produtoDAO.insertProduto(produto);
                break;

            case 2:
                produtoDAO.selectProduto();
                break;

            case 3:
                System.out.println("Informe o Id do produto que quer atualizar");
                int id_p=in.nextInt();

                System.out.println("Nome do novo produto");
                String nome_p=in.nextLine();

                System.out.println("Valor do novo produto");
                double valor_p=in.nextDouble();

                System.out.println("Quantidade disponivel do novo produto");
                int qtd_disponivel_p = in.nextInt();

                in.nextLine();

                System.out.println("Categoria do novo produto");
                String categoria_p= in.nextLine();

                Produto produto1=new Produto(nome_p,valor_p,qtd_disponivel_p,categoria_p);
                produtoDAO.updateProduto(id_p,produto1);
                break;

            case 4:
                System.out.print("Informe o id do Produto: ");
                int idprodutoAux = in.nextInt();
                produtoDAO.deleteProduto(idprodutoAux);
                System.out.println("Produto removido do Carrinho");
                break;
            case 5:
                usuarioDAO.selectUsuario();
            case 6:
                System.out.println("CPF do administrador");
                String cpf_adm=in.nextLine();

                System.out.println("Nome do administrador");
                String nome_adm=in.nextLine();

                System.out.println("Email do administrador");
                String email_adm=in.nextLine();

                System.out.println("Senha do administrador");
                String senha_adm=in.nextLine();

                System.out.println("Cargo do administrador");
                String cargo_adm=in.nextLine();

                Usuario usuario=new Usuario(cpf_adm,nome_adm,email_adm,senha_adm,cargo_adm);

                usuarioDAO.insertUsuario(usuario);

                break;
            case 7:
                System.out.println("Saindo da conta...");
                menuHelper.setSucesso(false);
                break;
            case 8:
                menuHelper.setFlag(false);
                menuHelper.setSucesso(false);
                break;
        }

        return menuHelper;


    }

}
