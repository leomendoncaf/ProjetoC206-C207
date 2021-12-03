import DAO.EmpresaDAO;
import DAO.FornecedorDAO;
import DAO.FuncionarioDAO;
import model.Empresa;
import model.Funcionario;
import model.Fornecedor;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        EmpresaDAO eDAO = new EmpresaDAO();
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        FornecedorDAO fDAO = new FornecedorDAO();
        Funcionario f1 = new Funcionario();
        Fornecedor fo1 = new Fornecedor();
        Empresa e1 = new Empresa();
        Scanner sc = new Scanner(System.in);
        System.out.println("---------MENU----------");
        System.out.println("Para adicionar uma nova empresa digite 1");
        System.out.println("Para atualizar uma empresa, digite 2:");
        System.out.println("Para deletar uma Empresa, digite 3:");
        System.out.println("Para adicionar um novo funcionario digite 4");
        System.out.println("Para atualizar um funcionario, digite 5:");
        System.out.println("Para deletar um funcionario, digite 6:");
        System.out.println("Para adicionar um novo fornecedor digite 7");
        System.out.println("Para atualizar um fornecedor, digite 8:");
        System.out.println("Para deletar um Fornecedor, digite 9:");
        System.out.println("Para sair digite -1");
        int x = sc.nextInt();
        while (x != -1) {
            switch (x) {
                case 1:
                    System.out.println("Digite o id da empresa: ");
                    e1.idEmpresa = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome da empresa:");
                    e1.nome = sc.nextLine();
                    System.out.println("Digite o CNPJ da empresa:");
                    e1.cnpj = sc.nextLine();
                    System.out.println("Digite o numero de funcionarios:");
                    e1.numFuncionarios = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o produto da empresa:");
                    e1.produto = sc.nextLine();
                    if(eDAO.inserirEmpresa(e1))
                        System.out.println("Empresa Adicionada");
                    else System.out.println("Ocorreu um erro");
                        break;

                case 2:
                    System.out.println("Digite o id da empresa que queira atualizar:");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome:");
                    e1.nome = sc.nextLine();
                    System.out.println("CNPJ: ");
                    e1.cnpj = sc.nextLine();
                    System.out.println("Numero de Funcionarios:");
                    e1.numFuncionarios = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Produto:");
                    e1.produto = sc.nextLine();

                    if(eDAO.atualizarEmpresa(id,e1))
                        System.out.println("Empresa atualizada");
                    else System.out.println("Ocorreu um erro");
                    break;

                case 3:
                    System.out.println("Digite o id da empresa que voce quer apagar:");
                    id = sc.nextInt();
                    if(eDAO.deletarEmpresa(id))
                        System.out.println("Empresa deletada");
                    else System.out.println("Ocorreu um erro");
                    break;

                case 4:
                    System.out.println("Digite o id do funcionario: ");
                    f1.idFuncionario = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome do funcionario:");
                    f1.nome = sc.nextLine();
                    System.out.println("Digite o salario do funcionario:");
                    f1.salario = sc.nextLine();
                    System.out.println("Digite o id da empresa:");
                    f1.Empresa_idEmpresa = sc.nextInt();
                    if(funcDAO.inserirFuncionario(f1))
                        System.out.println("Funcionario Adicionada");
                    else System.out.println("Ocorreu um erro");
                    break;
                case 5:
                    System.out.println("Digite o id do funcionario que deseja atualizar:");
                    id = sc.nextInt();
                    System.out.println("Id da empresa:");
                    int empId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome:");
                    f1.nome = sc.nextLine();
                    System.out.println("salario: ");
                    f1.salario = sc.nextLine();


                    if(funcDAO.atualizarFuncionario(id,empId,f1))
                        System.out.println("Funcionario atualizado");
                    else System.out.println("Ocorreu um erro");
                    break;

                case 6:
                    System.out.println("Digite o id do funcionario que voce quer apagar e o id da empresa do mesmo:");
                    id = sc.nextInt();
                    empId = sc.nextInt();
                    if(funcDAO.deletarFuncionario(id,empId,f1))
                        System.out.println("Funcionario deletado");
                    else System.out.println("Ocorreu um erro");
                    break;

                case 7:
                    System.out.println("Digite o id do fornecedor: ");
                    fo1.idFornecedor = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome do fornecedor:");
                    fo1.nome = sc.nextLine();
                    System.out.println("Digite o cnpj do fornecedor:");
                    fo1.cnpj = sc.nextLine();
                    System.out.println("Digite o id da empresa:");
                    fo1.Empresa_idEmpresa = sc.nextInt();
                    if(fDAO.inserirFornecedor(fo1))
                        System.out.println("Fornecedor Adicionada");
                    else System.out.println("Ocorreu um erro");
                    break;
                case 8:
                    System.out.println("Digite o id do fornecedor que deseja atualizar:");
                    id = sc.nextInt();
                    System.out.println("Id da empresa:");
                    empId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nome:");
                    fo1.nome = sc.nextLine();
                    System.out.println("cnpj: ");
                    fo1.cnpj = sc.nextLine();


                    if(fDAO.atualizarForncedor(id,empId,fo1))
                        System.out.println("Fornecedor atualizado");
                    else System.out.println("Ocorreu um erro");
                    break;

                case 9:
                    System.out.println("Digite o id do fornecedor que voce quer apagar e o id da empresa do mesmo:");
                    id = sc.nextInt();
                    empId = sc.nextInt();
                    if(fDAO.deletarFornecedor(id,empId,fo1))
                        System.out.println("Fornecedor deletado");
                    else System.out.println("Ocorreu um erro");
                    break;



                default:
                    System.out.println("Digite sua opção");



            }
            System.out.println("---------MENU----------");
            System.out.println("Para adicionar uma nova empresa digite 1");
            System.out.println("Para atualizar uma empresa, digite 2:");
            System.out.println("Para deletar uma Empresa, digite 3:");
            System.out.println("Para adicionar um novo funcionario digite 4");
            System.out.println("Para atualizar um funcionario, digite 5:");
            System.out.println("Para deletar um funcionario, digite 6:");
            System.out.println("Para adicionar um novo fornecedor digite 7");
            System.out.println("Para atualizar um fornecedor, digite 8:");
            System.out.println("Para deletar um Fornecedor, digite 9:");
            System.out.println("Para sair digite -1");
            x = sc.nextInt();
        }
    }


}
