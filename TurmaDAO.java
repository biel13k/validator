package br.com.srctreinamentotecnologico.sgcintegrado.turma.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Query;

import srctreinamentotecnologico.abstracts.AbstractDAO;
import srctreinamentotecnologico.abstracts.AbstractPO;
import srctreinamentotecnologico.exceptions.FiltrarException;
import srctreinamentotecnologico.utilidades.Utilidades;
import br.com.srctreinamentotecnologico.sgcintegrado.endereco.model.EnderecoPO;
import br.com.srctreinamentotecnologico.sgcintegrado.turma.model.TurmaPO;

import com.mysql.jdbc.Connection;

public class TurmaDAO extends AbstractDAO{
	private Connection connections;

	@SuppressWarnings( "unchecked" )
    @Override
	public ArrayList< AbstractPO > filtrar( AbstractPO abstractPO ) throws FiltrarException {

		if ( Utilidades.isNuloOuVazio( abstractPO ) ) {
			abstractPO = new TurmaPO();
		}

		TurmaPO po = null;

		/* Verificando se o abstractPO é do tipo ContatoPO */
		if ( abstractPO instanceof TurmaPO ) {
			po = (TurmaPO) abstractPO;
		} else {
			throw new FiltrarException( "Objeto informado não condiz com o contexto: " + abstractPO.getClass() );
		}

		try {
			// Criando uma HQL(Hibernate Query Language)
			final StringBuffer HQL = new StringBuffer();
			HQL.append( "SELECT turma FROM TurmaPO turma" );
			HQL.append( " " );
			HQL.append( "WHERE 1=1" );

			montarHQLPrincipal( HQL, po );

			/*
			 * Criando e inicializando uma variavel responsável por criar uma
			 * Query com base na nossa HQL criada acima deixando-a preparada
			 * para o Hibernate executa-la.
			 */
			Query query = sessaoCorrente.createQuery( HQL.toString() );

			/* Preenchendo os coringas da HQL */
			preecherCoringasHQLPrincipal( query, po );

			/*
			 * Executando a consulta list() = Consulta mais que um
			 * uniqueResult() = Consulta apenas 1 registro. Caso a HQL resulte
			 * em mais de um, uma excessão será lançada.
			 */
			return (ArrayList< AbstractPO >) query.list();
		} catch ( Exception e ) {
			throw new FiltrarException( "Erro ao filtrar", e );
		}

	}

	private void montarHQLPrincipal( StringBuffer HQL, TurmaPO turma ) {

		if ( !Utilidades.isNuloOuVazio( turma.getCodigo() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.codigo = :codigoParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getNomeConta() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.nomeConta = :nomeContaParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getCpf() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.cpf = :cpfParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getData() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.data = :dataParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getQuantidade() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.quantidade = :quantidadeParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getValor() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.valor = :valorParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getHora() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.hora = :horaParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getHora() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.cnpj = :cnpjParam" );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getUrlImagem() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.urlImagem = :urlImagemParam" );
		}
		
		if ( !Utilidades.isNuloOuVazio( turma.getUrlminiimg() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.urlminiimg = :urlminiimgParam" );
		}
		
		if ( !Utilidades.isNuloOuVazio( turma.getMiniatura() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.miniatura = :miniaturaParam" );
		}
		
		if ( !Utilidades.isNuloOuVazio( turma.getId() ) ) {
			HQL.append( " " );
			HQL.append( " AND turma.id = :idParam" );
		}
		
		HQL.append( " " );
		HQL.append( "order by turma.nomeConta" );

	}
		
		
		private void montarHQLEndereco(StringBuffer HQL, EnderecoPO endereco) {
			if ( !Utilidades.isNuloOuVazio( endereco.getBairro() ) ) {
				HQL.append( " " );
				HQL.append( " AND turma.endereco.bairro = :bairroParam" );
			}
			
			if ( !Utilidades.isNuloOuVazio( endereco.getCep() ) ) {
				HQL.append( " " );
				HQL.append( " AND turma.endereco.cep = :cepParam" );
			}
			
			if ( !Utilidades.isNuloOuVazio( endereco.getCidade() ) ) {
				HQL.append( " " );
				HQL.append( " AND turma.endereco.cidade = :cidadeParam" );
			}
			
			if ( !Utilidades.isNuloOuVazio( endereco.getLogradouro() ) ) {
				HQL.append( " " );
				HQL.append( " AND turma.endereco.logradouro = :logradouroParam" );
			}
			
			if ( !Utilidades.isNuloOuVazio( endereco.getNumero() ) ) {
				HQL.append( " " );
				HQL.append( " AND turma.endereco.numero = :numeroParam" );
			}
			
			if ( !Utilidades.isNuloOuVazio( endereco.getUf() ) ) {
				HQL.append( " " );
				HQL.append( " AND turma.endereco.uf = :ufParam" );
			}
			
			
	}

	private void preecherCoringasHQLPrincipal( Query query, TurmaPO turma ) {

		if ( !Utilidades.isNuloOuVazio( turma.getCodigo() ) ) {
			query.setLong( "codigoParam", turma.getCodigo() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getNomeConta() ) ) {
			query.setString( "nomeContaParam", turma.getNomeConta() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getCpf() ) ) {
			query.setString( "cpfParam", turma.getCpf() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getData() ) ) {
			query.setDate( "dataParam", turma.getData() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getQuantidade() ) ) {
			query.setInteger( "quantidadeParam", turma.getQuantidade() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getValor() ) ) {
			query.setDouble( "quantidadeParam", turma.getValor() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getHora() ) ) {
			query.setDate( "horaParam", turma.getHora() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getCpf() ) ) {
			query.setString( "cnpjParam", turma.getCnpj() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getUrlImagem() ) ) {
			query.setString( "urlImagemParam", turma.getUrlImagem() );
		}
		
		if ( !Utilidades.isNuloOuVazio( turma.getUrlminiimg() ) ) {
			query.setString( "urlminiimgParam", turma.getUrlminiimg() );
		}
		
		if ( !Utilidades.isNuloOuVazio( turma.getMiniatura() ) ) {
			query.setString( "miniaturaParam", turma.getMiniatura() );
		}

		if ( !Utilidades.isNuloOuVazio( turma.getId() ) ) {
			query.setLong( "idParam", turma.getId() );
		}
		
		
	}
	
	private void preecherCoringasHQLEndereco(Query query, EnderecoPO endereco) {
		if ( !Utilidades.isNuloOuVazio( endereco.getBairro() ) ) {
			query.setString( "bairroParam", endereco.getBairro() );
		}
		
		if ( !Utilidades.isNuloOuVazio( endereco.getCep() ) ) {
			query.setString( "cepParam", endereco.getCep() );
		}
		
		if ( !Utilidades.isNuloOuVazio( endereco.getCidade() ) ) {
			query.setString( "cidadeParam", endereco.getCidade() );
		}
		
		if ( !Utilidades.isNuloOuVazio( endereco.getLogradouro() ) ) {
			query.setString( "logradouroParam", endereco.getLogradouro() );
		}
		
		if ( !Utilidades.isNuloOuVazio( endereco.getNumero() ) ) {
			query.setString( "numeroParam", endereco.getNumero() );
		}
		
		if ( !Utilidades.isNuloOuVazio( endereco.getUf() ) ) {
			query.setString( "ufParam", endereco.getUf() );
		}
		

	}
	
	
	public void salvarOuAtualizar( TurmaPO imagen ) throws Exception {
		try {
			if ( imagen.getCodigo() == null || imagen.getCodigo() <= 0 ) {// insere
				String sql = "INSERT INTO turma(urlImagem )VALUES ( ?);";
				PreparedStatement insert = connections.prepareStatement( sql );
				constroiStatement( imagen, insert );
				insert.execute();
			} else {// atualiza
				atualiza( imagen );
			}
			connections.commit();
		} catch ( SQLException exception ) {
			connections.rollback();
			exception.printStackTrace();
		}
	}

	public TurmaPO consultaOriginal( Integer codigo ) {

		TurmaPO retorno = new TurmaPO();
		try {

			String sql = "select urlimagem FROM turma where codigo = " + codigo;
			PreparedStatement find = connections.prepareStatement( sql );
			ResultSet resultSet = find.executeQuery();
			while ( resultSet.next() ) {
				retorno.setUrlImagem( resultSet.getString( "urlImagem" ) );
			}
		} catch ( Exception e ) {
			throw new RuntimeException( e );
		}
		return retorno;
	}

	private void constroiStatement( TurmaPO imagen, PreparedStatement insert ) throws Exception {
		insert.setString( 1, imagen.getUrlImagem() );
	}

	public void salvar( TurmaPO imagem ) throws Exception {
		try {
			if ( imagem.getCodigo() == null || imagem.getCodigo() <= 0 ) {// insere
				String sql = "INSERT INTO turma(urlImagem)VALUES (?);";
				PreparedStatement insert = connections.prepareStatement( sql );
				constroiStatement( imagem, insert );
				insert.execute();
			} else {// atualiza
				atualiza( imagem );
			}
			connections.commit();
		} catch ( SQLException exception ) {
			connections.rollback();
			exception.printStackTrace();
		}
	}
	
	public void deleta( String codImg ) throws Exception {
		if ( !codImg.isEmpty() && codImg != null ) {
			String sql = "DELETE FROM imagens where id = " + codImg;
			try {
				PreparedStatement delete = connections.prepareStatement( sql );
				delete.execute();
				connections.commit();
			} catch ( SQLException e ) {
				try {
					connections.rollback();
				} catch ( SQLException e1 ) {
					e1.printStackTrace();
				}
				throw new RuntimeException( e );
			}
		}
	}

	private void atualiza( TurmaPO imagem ) throws Exception {
		String sql = "UPDATE turma SET  urlimagem=?  where id = " + imagem.getCodigo();
		PreparedStatement update = connections.prepareStatement( sql );

		constroiStatement( imagem, update );
		update.execute();
		connections.commit();
	}

}
