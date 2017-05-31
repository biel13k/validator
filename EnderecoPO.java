package br.com.srctreinamentotecnologico.sgcintegrado.endereco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.com.srctreinamentotecnologico.sgcintegrado.abstracts.AbstractPO;

@Entity
@Table( name = "enderecos", schema = "sgcIntegrado", uniqueConstraints = @UniqueConstraint( columnNames = { "logradouro", "numero", "bairro", "bairro", "cep", "uf" } ) )
public final class EnderecoPO extends AbstractPO{

	@Column( name = "logradouro", length = 60, nullable = false )
	private String logradouro;

	@Column( name = "numero", length = 4, nullable = false )
	private String numero;

	@Column( name = "bairro", length = 30, nullable = false )
	private String bairro;

	@Column( name = "cidade", length = 30, nullable = false )
	private String cidade;

	@Column( name = "cep", length = 11, nullable = false )
	private String cep;

	@Column( name = "uf", length = 2, nullable = false )
	private String uf;
	
	public EnderecoPO(){}

	public EnderecoPO(String logradouro, String numero, String bairro, String cidade, String cep, String uf ){
		setLogradouro( logradouro );
		setBairro( bairro );
		setCep( cep );
		setCidade( cidade );
		setLogradouro( logradouro );
		setNumero( numero );
		setUf( uf );
		
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero( String numero ) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro( String bairro ) {
		this.bairro = bairro;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( bairro == null ) ? 0 : bairro.hashCode() );
		result = prime * result + ( ( cep == null ) ? 0 : cep.hashCode() );
		result = prime * result + ( ( cidade == null ) ? 0 : cidade.hashCode() );
		result = prime * result + ( ( logradouro == null ) ? 0 : logradouro.hashCode() );
		result = prime * result + ( ( numero == null ) ? 0 : numero.hashCode() );
		result = prime * result + ( ( uf == null ) ? 0 : uf.hashCode() );
		return result;
	}

	@Override
	public boolean equals( Object obj ) {
		if ( this == obj )
			return true;
		if ( !super.equals( obj ) )
			return false;
		if ( getClass() != obj.getClass() )
			return false;
		EnderecoPO other = (EnderecoPO) obj;
		if ( bairro == null ) {
			if ( other.bairro != null )
				return false;
		} else if ( !bairro.equals( other.bairro ) )
			return false;
		if ( cep == null ) {
			if ( other.cep != null )
				return false;
		} else if ( !cep.equals( other.cep ) )
			return false;
		if ( cidade == null ) {
			if ( other.cidade != null )
				return false;
		} else if ( !cidade.equals( other.cidade ) )
			return false;
		if ( logradouro == null ) {
			if ( other.logradouro != null )
				return false;
		} else if ( !logradouro.equals( other.logradouro ) )
			return false;
		if ( numero == null ) {
			if ( other.numero != null )
				return false;
		} else if ( !numero.equals( other.numero ) )
			return false;
		if ( uf == null ) {
			if ( other.uf != null )
				return false;
		} else if ( !uf.equals( other.uf ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnderecoPO [getLogradouro()=" + getLogradouro() + ", getNumero()=" + getNumero() + ", getBairro()=" + getBairro() + ", getCidade()=" + getCidade() + ", getCep()=" + getCep() + ", getUf()=" + getUf() + ", hashCode()=" + hashCode() + "]";
	}

}
