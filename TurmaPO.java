package br.com.srctreinamentotecnologico.sgcintegrado.turma.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.ForeignKey;

import srctreinamentotecnologico.abstracts.AbstractPO;
import br.com.srctreinamentotecnologico.sgcintegrado.endereco.model.EnderecoPO;

@Entity
@Table( name = "turma", schema = "sgcIntegrado", uniqueConstraints = @UniqueConstraint( columnNames = { "cpf", "cnpj" } ) )
public class TurmaPO extends AbstractPO{

	@Column( name = "nome_conta", nullable = false, length = 30 )
	private String nomeConta;

	@Column( name = "cpf", nullable = false, length = 15 )
	private String cpf;

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "data", nullable = true, length = 15 )
	private Date data;

	@Column( name = "quantidade", nullable = true, length = 15 )
	private Integer quantidade;

	@Temporal( TemporalType.TIMESTAMP )
	@Column( name = "hora", nullable = true, length = 15 )
	private Date hora;

	@Column( name = "valor", nullable = true, length = 30 )
	private Double valor;

	@Column( name = "cnpj", nullable = false, length = 18 )
	private String cnpj;

	@Lob
	@Column( name = "url_imagem", nullable = true )
	private String urlImagem;

	@Lob
	@Column( name = "urlminiimg", nullable = true )
	private String urlminiimg;

	@Lob
	@Column( name = "miniatura", nullable = true )
	private String miniatura;

	@Lob
	@Column( name = "id", nullable = true )
	private Integer id;

	@OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false, orphanRemoval = true )
	@JoinColumn( name = "idEndereco" )
	@ForeignKey( name = "fk_aluno_endereco" )
	private EnderecoPO endereco;

	public TurmaPO(){}

	/*public TurmaPO(String nomeConta,String cpf,Date data, Integer quantidade, Date hora, Double valor, String cnpj, EnderecoPO endereco ){
		setCnpj( cnpj );
		setCpf( cpf );
		setData( data );
		setEndereco( endereco );
		setHora( hora );
		setNomeConta( nomeConta );
		setValor( valor );
		
		
		
		
	}*/

	public String getNomeConta() {
		return nomeConta;
	}

	public void setNomeConta( String nomeConta ) {
		this.nomeConta = nomeConta;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf( String cpf ) {
		this.cpf = cpf;
	}

	public Date getData() {
		return data;
	}

	public void setData( Date data ) {
		this.data = data;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade( Integer quantidade ) {
		this.quantidade = quantidade;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora( Date hora ) {
		this.hora = hora;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor( Double valor ) {
		this.valor = valor;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj( String cnpj ) {
		this.cnpj = cnpj;
	}

	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem( String urlImagem ) {
		this.urlImagem = urlImagem;
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

	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public EnderecoPO getEndereco() {
		return endereco;
	}

	public void setEndereco( EnderecoPO endereco ) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ( ( cnpj == null ) ? 0 : cnpj.hashCode() );
		result = prime * result + ( ( cpf == null ) ? 0 : cpf.hashCode() );
		result = prime * result + ( ( data == null ) ? 0 : data.hashCode() );
		result = prime * result + ( ( endereco == null ) ? 0 : endereco.hashCode() );
		result = prime * result + ( ( hora == null ) ? 0 : hora.hashCode() );
		result = prime * result + ( ( id == null ) ? 0 : id.hashCode() );
		result = prime * result + ( ( miniatura == null ) ? 0 : miniatura.hashCode() );
		result = prime * result + ( ( nomeConta == null ) ? 0 : nomeConta.hashCode() );
		result = prime * result + ( ( quantidade == null ) ? 0 : quantidade.hashCode() );
		result = prime * result + ( ( urlImagem == null ) ? 0 : urlImagem.hashCode() );
		result = prime * result + ( ( urlminiimg == null ) ? 0 : urlminiimg.hashCode() );
		result = prime * result + ( ( valor == null ) ? 0 : valor.hashCode() );
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
		TurmaPO other = (TurmaPO) obj;
		if ( cnpj == null ) {
			if ( other.cnpj != null )
				return false;
		} else if ( !cnpj.equals( other.cnpj ) )
			return false;
		if ( cpf == null ) {
			if ( other.cpf != null )
				return false;
		} else if ( !cpf.equals( other.cpf ) )
			return false;
		if ( data == null ) {
			if ( other.data != null )
				return false;
		} else if ( !data.equals( other.data ) )
			return false;
		if ( endereco == null ) {
			if ( other.endereco != null )
				return false;
		} else if ( !endereco.equals( other.endereco ) )
			return false;
		if ( hora == null ) {
			if ( other.hora != null )
				return false;
		} else if ( !hora.equals( other.hora ) )
			return false;
		if ( id == null ) {
			if ( other.id != null )
				return false;
		} else if ( !id.equals( other.id ) )
			return false;
		if ( miniatura == null ) {
			if ( other.miniatura != null )
				return false;
		} else if ( !miniatura.equals( other.miniatura ) )
			return false;
		if ( nomeConta == null ) {
			if ( other.nomeConta != null )
				return false;
		} else if ( !nomeConta.equals( other.nomeConta ) )
			return false;
		if ( quantidade == null ) {
			if ( other.quantidade != null )
				return false;
		} else if ( !quantidade.equals( other.quantidade ) )
			return false;
		if ( urlImagem == null ) {
			if ( other.urlImagem != null )
				return false;
		} else if ( !urlImagem.equals( other.urlImagem ) )
			return false;
		if ( urlminiimg == null ) {
			if ( other.urlminiimg != null )
				return false;
		} else if ( !urlminiimg.equals( other.urlminiimg ) )
			return false;
		if ( valor == null ) {
			if ( other.valor != null )
				return false;
		} else if ( !valor.equals( other.valor ) )
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TurmaPO [getNomeConta()=" + getNomeConta() + ", getCpf()=" + getCpf() + ", getData()=" + getData() + ", getQuantidade()=" + getQuantidade() + ", getHora()=" + getHora() + ", getValor()=" + getValor() + ", getCnpj()=" + getCnpj() + ", getUrlImagem()=" + getUrlImagem() + ", getUrlminiimg()=" + getUrlminiimg() + ", getMiniatura()=" + getMiniatura() + ", getId()=" + getId() + ", getEndereco()=" + getEndereco() + ", hashCode()=" + hashCode() + "]";
	}

}
