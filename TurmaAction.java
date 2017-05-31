package br.com.srctreinamentotecnologico.sgcintegrado.turma.struts;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import srctreinamentotecnologico.exceptions.ApplicationException;
import br.com.srctreinamentotecnologico.sgcintegrado.turma.controller.TurmaFacade;
import br.com.srctreinamentotecnologico.sgcintegrado.turma.model.TurmaPO;
import br.com.srctreinamentotecnologico.sgcintegrado.utilidades.Messages;
import br.com.srctreinamentotecnologico.sgcintegrado.utilidades.Utilidades;

public final class TurmaAction extends DispatchAction{
	public ActionForward abrirCadastro( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		/** fazendo o casting do form */
		TurmaForm meuForm = (TurmaForm) form;
		meuForm.limparCampos();

		return mapping.findForward( "turma_formulario" );
	}

	public ActionForward inserir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) throws IOException {

		/** fazendo o casting do form */
		TurmaForm meuForm = (TurmaForm) form;

		try {

			/*if ( meuForm.getCpf() == null || Utilidades.isCpfValido( meuForm.getCpf() ) == false ) {
				this.addMessages( request, Messages.createMessages( "falha", new String[ ] { "Digite um cpf valido!!" } ) );
				meuForm.setCpf( "" );
				return mapping.findForward( "turma_formulario" );
			}

			if ( meuForm.getCnpj() == null || Utilidades.isCNPJ( meuForm.getCnpj() ) == false ) {
				this.addMessages( request, Messages.createMessages( "falha", new String[ ] { "Cnpj invalido, digite novamente!!!" } ) );
				return mapping.findForward( "turma_formulario" );
			}*/

			TurmaFacade.getInstance().inserir( meuForm.montarPO() );
			meuForm.limparCampos();
			this.addMessages( request, Messages.createMessages( "sucesso" ) );

		} catch ( ApplicationException e ) {
			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { e.getMessage() } ) );
			e.printStackTrace();
		} catch ( ParseException e ) {
			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { "Erro ao converter dados do formulario" } ) );
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addMessages( request, Messages.createMessages( "erro.desconhecido", new String[ ] { e.getMessage() } ) );

		}

		meuForm.limparCampos();
		return mapping.findForward( "turma_formulario" );

	}

	public ActionForward alterar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) throws ApplicationException {

		/** fazendo o casting do form */
		TurmaForm meuForm = (TurmaForm) form;
		try {
			TurmaFacade.getInstance().alterar( meuForm.montarPO() );

			this.addMessages( request, Messages.createMessages( "sucesso" ) );
		} catch ( ApplicationException e ) {
			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { e.getMessage() } ) );
			e.printStackTrace();
		} catch ( ParseException e ) {

			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { "Erro ao converter dados do formulario" } ) );
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addMessages( request, Messages.createMessages( "erro.desconhecido", new String[ ] { e.getMessage() } ) );
		}

		meuForm.limparCampos();
		return mapping.findForward( "turma_formulario" );
	}

	public ActionForward excluir( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		/** fazendo o casting do form */
		TurmaForm meuForm = (TurmaForm) form;
		try {
			TurmaFacade.getInstance().excluir( meuForm.montarPO() );
			meuForm.limparCampos();

			this.addMessages( request, Messages.createMessages( "sucesso" ) );
		} catch ( ApplicationException e ) {
			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { e.getMessage() } ) );
			e.printStackTrace();
		} catch ( ParseException e ) {

			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { "Erro ao converter dados do formulario" } ) );
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addMessages( request, Messages.createMessages( "erro.desconhecido", new String[ ] { e.getMessage() } ) );
		}

		return mapping.findForward( "turma_formulario" );
	}

	public ActionForward novo( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {
		/** fazendo o casting do form */
		TurmaForm meuForm = (TurmaForm) form;

		meuForm.limparCampos();

		return mapping.findForward( "turma_formulario" );
	}

	public ActionForward selecionar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		/** fazendo o casting do form */
		TurmaForm meuForm = (TurmaForm) form;
		try {
			ArrayList< TurmaPO > encontrados = TurmaFacade.getInstance().filtrar( meuForm.montarPO() );
			TurmaPO selecionado = encontrados.get( 0 );
			meuForm.preencherAgenda( selecionado );

		} catch ( ApplicationException e ) {
			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { e.getMessage() } ) );
			e.printStackTrace();
		} catch ( ParseException e ) {

			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { "Erro ao converter dados do formulario" } ) );
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addMessages( request, Messages.createMessages( "erro.desconhecido", new String[ ] { e.getMessage() } ) );
		}

		return mapping.findForward( "turma_formulario" );
	}

	public ActionForward filtrar( ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response ) {

		/** fazendo o casting do form */
		TurmaForm meuForm = (TurmaForm) form;

		try {
			ArrayList< TurmaPO > encontrados = TurmaFacade.getInstance().filtrar( meuForm.montarPO() );

			meuForm.setListaTurma( encontrados );

		} catch ( ApplicationException e ) {
			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { e.getMessage() } ) );
			e.printStackTrace();
		} catch ( ParseException e ) {

			this.addMessages( request, Messages.createMessages( "falha", new String[ ] { "Erro ao converter dados do formulario" } ) );
			e.printStackTrace();
		} catch ( Exception e ) {
			e.printStackTrace();
			this.addMessages( request, Messages.createMessages( "erro.desconhecido", new String[ ] { e.getMessage() } ) );
		}

		return mapping.findForward( "turma_tabela" );
	}
}
