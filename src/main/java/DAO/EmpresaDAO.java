package DAO;

import DAO.ConnectionDAO;
import model.Empresa;

import java.sql.SQLException;

public class EmpresaDAO extends ConnectionDAO {
    //DAO - Data Access Object

    boolean sucesso = false;

    public boolean inserirEmpresa(Empresa empresa) {
        connectToDB();
        String sql = "INSERT INTO Empresa (idEmpresa,nome, numFuncionarios, cnpj,produto) values(?,?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, empresa.idEmpresa);
            pst.setString(2, empresa.nome);
            pst.setInt(3, empresa.numFuncionarios);
            pst.setString(4, empresa.cnpj);
            pst.setString(5, empresa.produto);
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


    public boolean atualizarEmpresa(int id, Empresa empresa) {
        connectToDB();
        String sql = "UPDATE empresa SET  nome=?, cnpj=?, numFuncionarios=?, produto=? where idEmpresa=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, empresa.nome);
            pst.setString(2, empresa.cnpj);
            pst.setInt(3, empresa.numFuncionarios);
            pst.setString(4, empresa.produto);
            pst.setInt(5, id);
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

    public boolean deletarEmpresa(int id) {
        connectToDB();
        String sql = "DELETE FROM empresa where idEmpresa=?";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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
