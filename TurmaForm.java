package br.com.srctreinamentotecnologico.sgcintegrado.turma.struts;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.struts.action.ActionForm;

import br.com.srctreinamentotecnologico.sgcintegrado.endereco.model.EnderecoPO;
import br.com.srctreinamentotecnologico.sgcintegrado.turma.model.TurmaPO;
import br.com.srctreinamentotecnologico.sgcintegrado.utilidades.Utilidades;

public class TurmaForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6017534252924122468L;

	private String codigo;
	private String nomeConta;
	private String cpf;
	private String data;
	private String quantidade;
	private String cnpj;
	private String urlImagem;
	private String urlminiimg;
	private String miniatura;
	private String id;

	//dados do endereco
	private String bairro;
	private String uf;
	private String logradouro;
	private String cidade;
	private String cep;
	private String numero;

	private ArrayList< TurmaPO > listaTurma = new ArrayList<>();

	private ArrayList< EnderecoPO > listaEndereco = new ArrayList<>();

	public ArrayList< EnderecoPO > getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco( ArrayList< EnderecoPO > listaEndereco ) {
		this.listaEndereco = listaEndereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro( String bairro ) {
		this.bairro = bairro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf( String uf ) {
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro( String logradouro ) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade( String cidade ) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep( String cep ) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero( String numero ) {
		this.numero = numero;
	}

	public String getUrlminiimg() {
		return urlminiimg;
	}

	public void setUrlminiimg( String urlminiimg ) {
		this.urlminiimg = urlminiimg;
	}

	public String getMiniatura() {
		return miniatura;
	}

	public void setMiniatura( String miniatura ) {
		this.miniatura = miniatura;
	}

	public String getId() {
		return id;
	}

	public void setId( String id ) {
		this.id = id;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem( String urlImagem ) {
		this.urlImagem = urlImagem;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade( String quantidade ) {
		this.quantidade = quantidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getData() {
		return data;
	}

	public void setData( String data ) {
		this.data = data;
	}

	public String getCpf() {

		return cpf;
	}

	public void setCpf( String cpf ) {

		this.cpf = cpf;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo( String codigo ) {
		this.codigo = codigo;
	}

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta( String nomeConta ) {
		this.nomeConta = nomeConta;
	}

	public ArrayList< TurmaPO > getListaTurma() {
		return listaTurma;
	}

	public void setListaTurma( ArrayList< TurmaPO > listaTurma ) {
		this.listaTurma = listaTurma;
	}

	public void preencherAgenda( TurmaPO poEncontrado ) throws ParseException {
		this.setCodigo( poEncontrado.getCodigo().toString() );
		this.setNomeConta( poEncontrado.getNomeConta() );
		this.setCpf( poEncontrado.getCpf() );
		this.setData( Utilidades.parseDate( poEncontrado.getData(), "dd/MM/yyyy" ) );
		this.setQuantidade( poEncontrado.getQuantidade().toString() );
		this.setCnpj( poEncontrado.getCnpj() );
		this.setUrlImagem( poEncontrado.getUrlImagem() );
		this.setUrlminiimg( poEncontrado.getUrlminiimg() );
		this.setId( poEncontrado.getId().toString() );

		//dados do relacionamento one to one com o endereco
		this.setBairro( poEncontrado.getEndereco().getBairro() );
		this.setCep( poEncontrado.getEndereco().getCep() );
		this.setCidade( poEncontrado.getEndereco().getCidade() );
		this.setLogradouro( poEncontrado.getEndereco().getLogradouro() );
		this.setNumero( poEncontrado.getEndereco().getNumero() );
		this.setUf( poEncontrado.getEndereco().getUf() );

	}

	public void preencherEndereco( Set< EnderecoPO > enderecos ) throws ParseException {
		for ( EnderecoPO enderecoCorrente : enderecos ) {
			this.setCep( enderecoCorrente.getCep() );
			this.setCidade( enderecoCorrente.getCidade() );
			this.setLogradouro( enderecoCorrente.getLogradouro() );
			this.setNumero( enderecoCorrente.getNumero() );
			this.setUf( enderecoCorrente.getUf() );
			this.setBairro( enderecoCorrente.getBairro() );

		}

	}

	public TurmaPO montarPO() throws ParseException {
		TurmaPO po = new TurmaPO();

		if ( !Utilidades.isNuloOuVazio( this.getCodigo() ) ) {
			po.setCodigo( Long.valueOf( this.getCodigo() ) );
		}

		if ( !Utilidades.isNuloOuVazio( this.getData() ) ) {
			po.setData( Utilidades.parseDate( this.getData(), "dd/MM/yyyy" ) );
		}

		if ( !Utilidades.isNuloOuVazio( this.getQuantidade() ) ) {
			po.setQuantidade( Integer.valueOf( this.getQuantidade() ) );
		}

		if ( !Utilidades.isNuloOuVazio( this.getId() ) ) {
			po.setId( Integer.valueOf( po.getId() ) );
		}

		po.setNomeConta( this.getNomeConta() );
		po.setCpf( ( this.getCpf() ) );
		po.setCnpj( this.getCnpj() );
		po.setUrlImagem( this.getUrlImagem() );
		po.setUrlminiimg( this.getUrlminiimg() );

		//setando os dados do endereco

		po.setEndereco( new EnderecoPO() );
		/*if ( Utilidades.isNuloOuVazio( getCodigoMercado() ) ) {
			po.getMercado().setCodigo( Long.valueOf( getCodigoMercado() ) );

		}*/
		po.getEndereco().setBairro( this.getBairro() );
		po.getEndereco().setCep( this.getCep() );
		po.getEndereco().setCidade( this.getCidade() );
		po.getEndereco().setLogradouro( this.getLogradouro() );
		po.getEndereco().setNumero( this.getNumero() );
		po.getEndereco().setUf( this.getUf() );


		return po;
	}

	public void limparCampos() {
		this.setCodigo( "" );
		this.setNomeConta( "" );
		this.setCpf( "" );
		this.setData( "" );
		this.setQuantidade( "" );
		this.setCnpj( "" );
		this.setUrlImagem( "" );

		//limpando dados da chave
		this.setBairro( "" );
		this.setCep( "" );
		this.setCidade( "" );
		this.setLogradouro( "" );
		this.setNumero( "" );
		this.setUf( "" );

	}

}
