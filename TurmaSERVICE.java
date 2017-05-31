package br.com.srctreinamentotecnologico.sgcintegrado.turma.model;

import java.util.ArrayList;

import br.com.srctreinamentotecnologico.sgcintegrado.turma.dao.TurmaDAO;
import br.com.srctreinamentotecnologico.sgcintegrado.utilidades.Utilidades;
import srctreinamentotecnologico.abstracts.AbstractPO;
import srctreinamentotecnologico.exceptions.AlterarException;
import srctreinamentotecnologico.exceptions.ApplicationException;
import srctreinamentotecnologico.exceptions.CommitException;
import srctreinamentotecnologico.exceptions.ExcluirException;
import srctreinamentotecnologico.exceptions.FiltrarException;
import srctreinamentotecnologico.exceptions.InserirException;
import srctreinamentotecnologico.exceptions.RollbackException;
import srctreinamentotecnologico.exceptions.SessaoException;
import srctreinamentotecnologico.exceptions.TransacaoException;
import srctreinamentotecnologico.interfaces.InterfaceDAO;

public final class TurmaSERVICE{
	private final InterfaceDAO DAO;

	public TurmaSERVICE(){
		DAO = new TurmaDAO();
	}

	public void inserir( TurmaPO po ) throws ApplicationException, InserirException {
		try {

			if(Utilidades.isCpfValido( po.getCpf()) == false){
				
				po.setCpf( null );
				System.out.println("cpf invalido");
			}
			
			if(Utilidades.isCNPJ( po.getCnpj() ) == false){
				
				throw new ApplicationException( "cnpj invalido, por favor digite novamente!" );
				
			}

			DAO.iniciarTransacao();

			DAO.inserir( po );

			DAO.commitTransacao();

		} catch ( TransacaoException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( SessaoException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( CommitException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido, chame o suporte! (014 9.9098-9454)", e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( SessaoException e ) {
				e.printStackTrace();
				throw new ApplicationException( e.getMessage(), e );
			}
		}

	}

	/**
	 * Instanciando o DAO
	 * 
	 * @throws ApplicationException
	 */
	public void alterar( TurmaPO po ) throws ApplicationException {
		try {

			DAO.iniciarTransacao();

			DAO.alterar( po );

			DAO.commitTransacao();

		} catch ( TransacaoException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( SessaoException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( CommitException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( AlterarException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido, chame o suporte! (014 9.9098-9454)", e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( SessaoException e ) {
				e.printStackTrace();
				throw new ApplicationException( e.getMessage(), e );
			}
		}

	}

	/**
	 * Instanciando o DAO
	 * 
	 * @throws ApplicationException
	 */
	public void excluir( TurmaPO po ) throws ApplicationException {
		try {
			DAO.iniciarTransacao();

			DAO.excluir( po );

			DAO.commitTransacao();

		} catch ( TransacaoException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( SessaoException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( CommitException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( ExcluirException e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			try {
				DAO.rollbackTransacao();
			} catch ( RollbackException e1 ) {
				e1.printStackTrace();
				throw new ApplicationException( e1.getMessage(), e );
			}
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido, chame o suporte! (014 9.9098-9454)", e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( SessaoException e ) {
				e.printStackTrace();
				throw new ApplicationException( e.getMessage(), e );
			}
		}
	}

	/**
	 * Instanciando o DAO
	 * 
	 * @throws ApplicationException
	 */
	public ArrayList< TurmaPO > filtrar( TurmaPO po ) throws ApplicationException {
		try {
			DAO.abrirSessao();

			ArrayList< AbstractPO > encontrados = DAO.filtrar( po );

			/**
			 * Processo realizado com o intuito de especialisar todos os
			 * elementos do ArrayList<AbstractPO> para o ArrayList<ContatoPO>
			 */
			ArrayList< TurmaPO > pos = new ArrayList<>();
			for ( AbstractPO abstractCorrente : encontrados ) {
				pos.add( (TurmaPO) abstractCorrente );
			}
			return pos;
		} catch ( SessaoException e ) {
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( FiltrarException e ) {
			e.printStackTrace();
			throw new ApplicationException( e.getMessage(), e );
		} catch ( Exception e ) {
			e.printStackTrace();
			throw new ApplicationException( "Erro desconhecido, chame o suporte! (014 9.9098-9454)", e );
		} finally {
			try {
				DAO.fecharSessao();
			} catch ( SessaoException e ) {
				e.printStackTrace();
				throw new ApplicationException( e.getMessage(), e );
			}
		}
	}
}
