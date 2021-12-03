package DAO;

import DAO.ConnectionDAO;
import model.Fornecedor;

import java.sql.SQLException;

public class FornecedorDAO extends ConnectionDAO {
    //DAO - Data Access Object

    boolean sucesso = false;

    public boolean inserirFornecedor(Fornecedor forn) {
        connectToDB();
        String sql = "INSERT INTO forn (idForncedor,nome, cnpj,Empresa_idEmpresa) values(?,?,?,?)";

        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, forn.idFornecedor);
            pst.setString(2, forn.nome);
            pst.setString(3, forn.cnpj);
            pst.setInt(4, forn.Empresa_idEmpresa);
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


    public boolean atualizarForncedor(int id,int empid, Fornecedor forn) {
        connectToDB();
        String sql = "UPDATE forn SET  nome=?, cnpj=? where idFornecedor=? and Empresa_idEmpresa =?";

        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, forn.nome);
            pst.setString(2, forn.cnpj);
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

    public boolean deletarFornecedor(int id,int empid,Fornecedor forc) {
        connectToDB();
        String sql = "DELETE FROM forn where idFornecedor=? and Empresa_idEmpresa=?";

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
