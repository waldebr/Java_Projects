/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexao;

import java.sql.*;
import javax.swing.JOptionPane;


/**
 * 
 *
 * @author dti
 */
public class Conexao {
    
    final private String driver = "com.mysql.jdbc.Driver";
    final private String url = "jdbc:mysql://localhost/clientes";
    final private String user = "root";
    final private String senha = "usbw";
        private Connection conexao;
    public Statement statement;
    public ResultSet resultset;
    
        
public boolean conecta(){
    boolean result = true;
    try{
   Class.forName(driver);
    conexao =DriverManager.getConnection(url,user,senha);
    JOptionPane.showMessageDialog(null,"conexão estabelecida","mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
    }catch(ClassNotFoundException Driver){
        JOptionPane.showMessageDialog(null,"Driver não localizado"+Driver,"mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        result = false;
    }catch(SQLException Fonte){
        JOptionPane.showMessageDialog(null,"Fonte de dados não localizado"+Fonte,"mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        result = false;
    }
    return result;
}

public void desconecta() {
    try {
        conexao.close();
        JOptionPane.showMessageDialog(null,"conexao com o banco fechada","mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
    }catch(SQLException fecha) {
    
    
    }

    
}

public void executaSQL(String sql) {
    try{
        statement = conexao.createStatement(ResultSet.TYPE_SCROOL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
        resultset = statement.executeQuery(sql);
    }catch(SQLException excecao){
        JOptionPane.showMessageDialog(null,"erro no comando SQL\n"+excecao,"mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
    }
}




}


