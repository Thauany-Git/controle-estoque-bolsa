/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author thaua
 */
public class Vendedor {
    
    public int codigo;
    public String nome;
    public String cpf;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
      public String toString() {
        return this.nome;
    }
    
    public boolean equals(Object o) {
        Vendedor compara = (Vendedor) o;
        return this.codigo== compara.codigo;
    }
    
}
