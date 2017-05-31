package br.com.srctreinamentotecnologico.sgcintegrado.turma.controller;

import java.util.ArrayList;

import srctreinamentotecnologico.exceptions.ApplicationException;
import srctreinamentotecnologico.exceptions.InserirException;
import br.com.srctreinamentotecnologico.sgcintegrado.turma.model.TurmaPO;
import br.com.srctreinamentotecnologico.sgcintegrado.turma.model.TurmaSERVICE;

public class TurmaFacade {
	
	/**
	 * Atributo responsável por possibilitar o acesso da Camada Controller a
	 * Camada MODEL
	 */
	private final TurmaSERVICE SERVICE;

	// ********************************************** \\
	// ************ APLICANDO SINGLETON ************* \\
	// ********************************************** \\
	private static TurmaFacade instance;
	

	private TurmaFacade() {
		SERVICE = new TurmaSERVICE();
	}

	public static TurmaFacade getInstance() {
		if (instance == null) {
			instance = new TurmaFacade();
		}
		return instance;
	}

	// ********************* FIM ******************** \\
	// ************ APLICANDO SINGLETON ************* \\
	// ********************* FIM ******************** \\

	public void inserir(TurmaPO po) throws ApplicationException, InserirException {
		
		SERVICE.inserir(po);
	}

	public void alterar(TurmaPO po) throws ApplicationException {
		SERVICE.alterar(po);
	}

	public void excluir(TurmaPO po) throws ApplicationException {
		SERVICE.excluir(po);
	}

	public ArrayList<TurmaPO> filtrar(TurmaPO po) throws ApplicationException {
		return SERVICE.filtrar(po);
	}
}



