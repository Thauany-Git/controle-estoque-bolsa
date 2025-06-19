/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Vendedor;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author thaua
 */
public class VendedorDAO {

    private Connection conn;

    public VendedorDAO() {
        this.conn = Conexao.getConexao();
    }

    public void inserir(Vendedor vendedor) throws Exception {
        String sql = "INSERT INTO vendedor (nome, cpf) "
                + "VALUES (?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, vendedor.getNome());
            stmt.setString(2, vendedor.getCpf());

            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir vendedor: " + e.getMessage());
        }
    }

    public List<Vendedor> getVendedores() throws Exception {
        List<Vendedor> lista = new ArrayList();

        String sql = "SELECT * FROM vendedor";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vendedor v = new Vendedor();
                v.setCodigo(rs.getInt("codigo_vendedor"));
                v.setNome(rs.getString("nome"));
                lista.add(v);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Erro ao buscar vendedores: " + e.getMessage());
        }
    }

}
