package model;

import javalar.SistemaJavaLar;
import javalar.Bugs;
import javalar.Devs;
import javalar.Planetas;
import javalar.PlanoCartesiano;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import view.Janela;

public class DAO {
	
	private SistemaJavaLar sistema;
	private ArrayList<ArrayList<String>> dados = new ArrayList<>();

	
	public DAO(SistemaJavaLar sistema) {
		this.sistema = sistema;

	}
	
    
    public void pegarArquivos() {
    	  	
    	try (Connection conexao = new Conexao().getConexao()) {

    		String consultaSQL = "SELECT * FROM javalar LIMIT 15000";

    		try (PreparedStatement preparedStatement = conexao.prepareStatement(consultaSQL)) {

    		    ResultSet resultado = preparedStatement.executeQuery();
    		    
    		    int numeroDeColunas = resultado.getMetaData().getColumnCount();
    		    
    			  		    
				
    		    for (int i = 1; i <= numeroDeColunas; i++) {
    		    	dados.add(new ArrayList<>());
				}
								
    		    while (resultado.next()) {    		    			    	
    	            for (int i = 1; i <= numeroDeColunas; i++) {    	            	
    	                dados.get(i - 1).add(resultado.getString(i));
    	            }   	              	            
    		    }  		    
    		}   	    
    	} catch (SQLException e) {
    	    e.printStackTrace();
    	}
    }
    
    public ArrayList<ArrayList<String>> getDados() {
    	return dados;
    }
            
    public void relatorio() {
    	String nomeArquivo = sistema.getArquivo();
        String nomeNovoAluno = "Caio";
        int matriculaNovoAluno = 553853;
        

        // Conecta ao banco de dados
        try (Connection conexao = new Conexao().getConexao()) {
            // Instrução para inserir um novo aluno
            String insercaoSQL = "INSERT INTO javalar (nome, matricula, nome_arquivo, bug_python, bug_javascript, bug_ruby, bug_php, "
            		+ "bug_csharp, bug_cmais, bug_c, dev_python, dev_javascript, dev_ruby, dev_php, dev_csharp, dev_cmais, dev_c, "
            		+ "v_python, v_javascript, v_ruby, v_php, v_csharp, v_cmais, v_c, d_python, d_javascript, d_ruby, d_php, "
            		+ "d_csharp, d_cmais, d_c, a_python, a_javascript, a_ruby, a_php, a_csharp, a_cmais, a_c, bug_q1, bug_q2, "
            		+ "bug_q3, bug_q4, dev_q1, dev_q2, dev_q3, dev_q4) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
            		+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = conexao.prepareStatement(insercaoSQL)) {
                // definindo os parâmetros
            
            	
            	
            	preparedStatement.setString(1, nomeNovoAluno);
                preparedStatement.setInt(2, matriculaNovoAluno);
                preparedStatement.setString(3, nomeArquivo);
                
            	for (Planetas pl : sistema.getPlanetas()) {
            		
            		if(pl.GetName() == "Python") {
            			preparedStatement.setDouble(4, pl.getColisoesComBug());
            			preparedStatement.setDouble(11, pl.getColisoesComDev());
            			preparedStatement.setDouble(18, pl.getVelocidadeTranslacao());
            			preparedStatement.setDouble(25, pl.getHoras());
            			preparedStatement.setDouble(32, pl.getAnos());
            		}
            		if(pl.GetName() == "JavaScript") {
            			preparedStatement.setDouble(5, pl.getColisoesComBug());
            			preparedStatement.setDouble(12, pl.getColisoesComDev());
            			preparedStatement.setDouble(19, pl.getVelocidadeTranslacao());
            			preparedStatement.setDouble(26, pl.getHoras());
            			preparedStatement.setDouble(33, pl.getAnos());
            		}
            		if(pl.GetName() == "Ruby On Rails") {
            			preparedStatement.setDouble(6, pl.getColisoesComBug());
            			preparedStatement.setDouble(13, pl.getColisoesComDev());
            			preparedStatement.setDouble(20, pl.getVelocidadeTranslacao());
            			preparedStatement.setDouble(27, pl.getHoras());
            			preparedStatement.setDouble(34, pl.getAnos());
            		}
            		if(pl.GetName() == "PHP") {
            			preparedStatement.setDouble(7, pl.getColisoesComBug());
            			preparedStatement.setDouble(14, pl.getColisoesComDev());
            			preparedStatement.setDouble(21, pl.getVelocidadeTranslacao());
            			preparedStatement.setDouble(28, pl.getHoras());
            			preparedStatement.setDouble(35, pl.getAnos());
            		}
            		if(pl.GetName() == "C#") {
            			preparedStatement.setDouble(8, pl.getColisoesComBug());
            			preparedStatement.setDouble(15, pl.getColisoesComDev());
            			preparedStatement.setDouble(22, pl.getVelocidadeTranslacao());
            			preparedStatement.setDouble(29, pl.getHoras());
            			preparedStatement.setDouble(36, pl.getAnos());
            		}
            		if(pl.GetName() == "C++") {
            			preparedStatement.setDouble(9, pl.getColisoesComBug());
            			preparedStatement.setDouble(16, pl.getColisoesComDev());
            			preparedStatement.setDouble(23, pl.getVelocidadeTranslacao());
            			preparedStatement.setDouble(30, pl.getHoras());
            			preparedStatement.setDouble(37, pl.getAnos());
            		}
            		if(pl.GetName() == "C") {
            			preparedStatement.setDouble(10, pl.getColisoesComBug());
            			preparedStatement.setDouble(17, pl.getColisoesComDev());
            			preparedStatement.setDouble(24, pl.getVelocidadeTranslacao());
            			preparedStatement.setDouble(31, pl.getHoras());
            			preparedStatement.setDouble(38, pl.getAnos());
            		}		            		
            			            		
				}
            	
                int bq1 = 0;
				int bq2 = 0;
				int bq3 = 0;
				int bq4 = 0;
				
            	for (Bugs bug : sistema.getBug()) {
					
					if(bug.getX() <= 8 && bug.getY() >= 8) {
						bq1++;
					}
					else if(bug.getX() > 8 && bug.getY() > 8) {
						bq2++;
					}
					else if(bug.getX() < 8 && bug.getY() < 8) {
						bq3++;
					}
					else if(bug.getX() > 8 && bug.getY() < 8) {
						bq4++;
					}							
				}
            	
                preparedStatement.setDouble(39, bq1);
                preparedStatement.setDouble(40, bq2);
                preparedStatement.setDouble(41, bq3);
                preparedStatement.setDouble(42, bq4);
                
                int dq1 = 0;
				int dq2 = 0;
				int dq3 = 0;
				int dq4 = 0;
				
            	for (Devs dev : sistema.getDev()) {
					
					if(dev.getX() <= 8 && dev.getY() >= 8) {
						dq1++;
					}
					else if(dev.getX() > 8 && dev.getY() > 8) {
						dq2++;
					}
					else if(dev.getX() < 8 && dev.getY() < 8) {
						dq3++;
					}
					else if(dev.getX() > 8 && dev.getY() < 8) {
						dq4++;
					}							
				}
                
                preparedStatement.setDouble(43, dq1);
                preparedStatement.setDouble(44, dq2);
                preparedStatement.setDouble(45, dq3);
                preparedStatement.setDouble(46, dq4);
                
            }
        } catch (SQLException i) {
            i.printStackTrace();
        }
    }
}
