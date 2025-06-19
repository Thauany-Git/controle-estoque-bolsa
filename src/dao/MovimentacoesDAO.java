/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Movimentações;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author thaua
 */
public class MovimentacoesDAO {
     private Connection conn;

    public MovimentacoesDAO() {
        this.conn = Conexao.getConexao();
    }

    public void inserir(Movimentações m) throws Exception {
        String sql = "INSERT INTO movimentacoes (tipo, descricao, data_movimentacao, codigo_vendedor) "
                + "VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, m.getTipo());
            stmt.setString(2, m.getDescricao());
            stmt.setDate(3, (Date) m.getData_movimentacao());
            stmt.setInt(4, m.getVendedor().getCodigo());

            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir movimentação: " + e.getMessage());
        }
    }
}
