/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Bolsa;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author thaua
 */
public class BolsaDAO {

    private Connection conn;

    public BolsaDAO() {
        this.conn = Conexao.getConexao();
    }

    public void inserir(Bolsa bolsa) throws Exception {
        String sql = "INSERT INTO bolsa (modelo, tamanho, marca, cor, preco, qtde_estoque, data_cadastro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, bolsa.getModelo());
            stmt.setString(2, bolsa.getTamanho());
            stmt.setString(3, bolsa.getMarca());
            stmt.setString(4, bolsa.getCor());
            stmt.setFloat(5, bolsa.getPreco());
            stmt.setInt(6, bolsa.getQtde_estoque());
            stmt.setDate(7, (Date) bolsa.getData_cadastro());

            stmt.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao inserir bolsa: " + e.getMessage());
        }
    }

}
