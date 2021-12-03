package DAO;

import DAO.ConnectionDAO;
import model.Funcionario;

import java.sql.SQLException;

public class FuncionarioDAO extends ConnectionDAO {
    //DAO - Data Access Object

    boolean sucesso = false;

    public boolean inserirFuncionario(Funcionario func) {
        connectToDB();
        String sql = "INSERT INTO Funcionario (idFuncionario,nome, salario,Empresa_idEmpresa) values(?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, func.idFuncionario);
            pst.setString(2, func.nome);
            pst.setString(3, func.salario);
            pst.setInt(4, func.Empresa_idEmpresa);
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }

        return sucesso;
    }


    public boolean atualizarFuncionario(int id,int empid, Funcionario func) {
        connectToDB();
        String sql = "UPDATE func SET  nome=?, salario=? where idFuncionario=? and Empresa_idEmpresa =?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, func.nome);
            pst.setString(2, func.salario);
            pst.setInt(3, id);
            pst.setInt(4, empid);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }

    public boolean deletarFuncionario(int id,int empid,Funcionario func) {
        connectToDB();
        String sql = "DELETE FROM func where idFuncionario=? and Empresa_idEmpresa=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, empid);
            pst.execute();
            sucesso = true;

        } catch(SQLException ex) {
            System.out.println("Erro = " +  ex.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
    }
}
