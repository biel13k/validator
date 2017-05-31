<!DOCTYPE html>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> --%>
<!-- <!DOCTYPE html > -->
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<!-- http://getbootstrap.com/
http://getbootstrap.com/components/
https://code.jquery.com/jquery-1.10.2.min.js -->

<html>
	<head>
				
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- setando na sessao o caminho do WebContent -->	
			<% request.getSession().setAttribute( "root", request.getContextPath() ); %>
			
		<title>Turma</title>
		
		<!-- importando bootstrap -->
		<link href="assets/bootstrap-3.3.5-dist/css/bootstrap.css" rel="stylesheet" media="screen">
		<script src="assets/js/jquery-1.10.2.min.js" type="text/javascript"></script>
		<script src="js/MascaraJS-master/mascara.js"></script>
	<!-- 	<script src="js/MascaraJS-master/jquery.placeholder.js"></script> -->
		
		
		
		<script type="text/javascript">
		
		
		/* function visualizarImg() {
			var preview = document.querySelector('img'); /// pega o campo de imagem
			var file = document.querySelector('input[type=file]').files[0]; // pega o primeiro input que armazena a imagem em base 64
			var reader = new FileReader();

		reader.onloadend = function() {
			preview.src = reader.result;// carrega em base64 a img
			document.getElementById("urlimagemBase64").value = reader.result; // seta o valor da imagem ao intputtext urlimagemBase64
		};

			if (file) {
				reader.readAsDataURL(file); // faz o prewiew da imagem na tela	    
			} else {
				preview.src = "";
			}

	   } */
		
		$(document).ready(function(){
			$('#form_agenda').attr("autocomplete", "off");
			
			/*definindo campos obrigatorios */
			$('#nomeConta').attr("required", "required");
			$('#cpf').attr("required", "required");
			$('#cnpj').attr("required", "required");
			$('#data').attr("required", "required");
			$('#quantidade').attr("required", "required");
			 
			
			
			/*definindo campos obrigatorios */
			/*
			$('.obrigatorio').attr("required", "required"); */
			$(function() {
			    $( "#calendario" ).datepicker();
			});

			
			$(".datepicker").datepicker({
		         dateFormat:'dd/mm/yy',
		         dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
		         dayNamesMin: ['D','S','T','Q','Q','S','S','D'],
		         dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sáb','Dom'],
		         monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
		         monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
		         nextText: 'Próximo',
		         prevText: 'Anterior' 
		          });
		    
		    $(".datepicker").mask("99/99/9999");
			
						
		/* 	$("#enviar").click(function(){
				executar( "enviar" );
			});
			
			$("#limpar").click(function(){
				executarComSubmit( "limpar" );
			});   */
		});
		
		function executar( nomeMetodo ){
		    document.getElementById("form_turma").method.value = nomeMetodo;
			}
		
		function executarComSubmit( nomeMetodo ){
		    document.getElementById("form_turma").method.value = nomeMetodo;
		    document.getElementById("form_turma").submit();
		}
		
		function checkRegexp(o, regexp, n) {
		    if (!(regexp.test(o))) {
		     return false;
		    } else {
		     return true;
		    }
		   }

		   function validarEmail(obj) {
		    if (obj.value.length > 0) {
		     if (checkRegexp(
		       obj.value,
		       /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/i,
		       "Ex: adm@gruposrc.com.br") == false) {
		      obj.focus();
		      obj.style.background = '#FFCC66';
		     } else {
		      obj.style.background = 'white';
		     }
		    } else {
		     obj.style.background = 'white';
		    }
		   }
		   
		   </script>
		
		
	</head>
	<body>
		
		<html:form styleId="form_turma" action="/turmaAction.do" method="post">
		<html:hidden property="method" value="empty"/>
		
		<div class="container ">
			
			<div class="panel panel-group panel-primary">
			
				
				
				<!-- Esse panel é o cabeçalho da página -->
				<div class="panel-heading " style="background-color: black; color: white;">
					<i class="glyphicon glyphicon-user info"></i> 
					Turma
				</div>
				
				
				<!-- Esse é o painel do corpo da minha janela -->
				<div class="panel-body">
					
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 bg-danger">
						<logic:messagesPresent message="true">						
							<html:messages id="message" message="true">											
								<div>
									<p>
										<b><bean:write filter="false" name="message"/></b>	
									</p>
								</div>						
							</html:messages>
						</logic:messagesPresent>
						</div>
					</div>
					
					<!-- Linha -->
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 bg-danger">
							<form>
							
								<div class="row">
								
									<%-- <div class="form-group col-xs-12 col-sm-3 col-md-4 col-lg-4">
											<div class="media">
												<a class="media-left" href="#">
													<img alt="400x400" width="200" height="200" src="">
													 <input onchange="visualizarImg();" type="file" value="Selecionar arquivo"> 
													 <html:text  styleId="urlimagem" styleClass="file"  property="urlimagem" name = "turmaForm" onchange="visualizarImg();"  value="Selecionar a imagem"/> 
												
												</a>
											</div>
									</div> --%>
									
										
									<div class="form-group col-xs-12 col-sm-3 col-md-4 col-lg-4">
										<label for="nomeConta" class="control-label" >Nome Conta</label>
										<!-- <input class="form-control " type="text" id="nomeConta"  name = "turmaForm" placeholder="nome conta"  maxlength="15">  -->
										 <html:text  styleId="nomeConta" styleClass="form-control "  property="nomeConta" name = "turmaForm"/> 
									</div>
									
								    <!--  <div class="form-group col-xs-12 col-sm-3 col-md-3 col-lg-3">
										<label for="cpf" class="control-label" >Cpf</label>
											<input class="form-control " type="text" id="cpf"  name = "turmaForm" placeholder="###.###.###-##"  onkeyup="mascara('###.###.###-##',this, event)" maxlength="15"> 
										
									</div>  -->
									 <div class="form-group col-xs-12 col-sm-3 col-md-4 col-lg-4">
										<label for="cpf" class="control-label" >Cpf</label>
										<html:text  styleId="cpf" styleClass="form-control " maxlength="14" property="cpf" name = "turmaForm" onkeyup="mascara('###.###.###-##',this, event)"/>
									</div>   
									
									<div class="form-group col-xs-12 col-sm-3 col-md-4 col-lg-4">
										<label for="cnpj" class="control-label" >Cnpj</label>
										 <html:text  styleId="cnpj"   styleClass="form-control " maxlength="18"  property="cnpj" name = "turmaForm" onkeyup="mascara('##.###.###/####-##',this,event, false)" /> 
										<!-- <input class="form-control " type="text" id="quantidade"  name = "turmaForm" placeholder="quantidade ex: 3"  maxlength="15">  -->
									</div>
									
									
									<div class="form-group col-xs-12 col-sm-3 col-md-4 col-lg-4">
										<label for="data" class="control-label" >Data</label>
										<!--  <input class="form-control" type="text" id="data"  name = "turmaForm" placeholder="##/##/####" onkeyup="mascara('##/##/####',this,event,true)" maxlength="15">  -->
										 <!--  <input class="form-control " type="text" id="data" name="turmaForm" placeholder="##/##/####" onkeyup="mascara('##/##/####',this,event)" maxlength="15">  -->
										<html:text  styleId="data" styleClass="form-control datepicker"  maxlength="10"  property="data" name = "turmaForm"  onkeyup="mascara('##/##/####',this,event, false)" /> 
									</div>
									
									
									
									
									
									<%-- <div class="form-group col-xs-12 col-sm-3 col-md-3 col-lg-3">
										<label for="data" class="control-label" >Data</label>
										<html:text  styleId="data" styleClass="form-control obrigatorio"  maxlength="10"  property="data" name = "turmaForm"  />
									</div> --%>
									
									<div class="form-group col-xs-12 col-sm-3 col-md-4 col-lg-4">
										<label for="quantidade" class="control-label" >Quantidade</label>
										 <html:text  styleId="quantidade"   styleClass="form-control " maxlength="10"  property="quantidade" name = "turmaForm"  /> 
										<!-- <input class="form-control " type="text" id="quantidade"  name = "turmaForm" placeholder="quantidade ex: 3"  maxlength="15">  -->
									</div>
									
									
									
									
									<%--
										enviando e-mail
									
										<div class="form-group col-xs-12 col-sm-6 col-md-4 col-lg-5">
										<label for="email" class="control-label">E-mail</label>
										<html:text  styleId="email" styleClass="form-control obrigatorio"  property="email" name = "turmaForm"  onblur="validarEmail(this);" onkeyup="validarEmail(this);"/>
									</div> 
									
									--%>
									
									
									<%-- 
									
									checbox exemplo
									
									<div class="form-group col-xs-12 col-sm-4 col-md-4 col-lg-2">
           								<label>HTML</label>
           								<html:select styleClass="form-control" styleId="html" property="html" name="turmaForm">
            								<html:option value="0">0</html:option>
           									<html:option value="1">1</html:option>
            								<html:option value="2">2</html:option>
            								<html:option value="3">3</html:option>
            								<html:option value="4">4</html:option>
            								<html:option value="5">5</html:option>
            								<html:option value="6">6</html:option>
            								<html:option value="7">7</html:option>
            								<html:option value="8">8</html:option>
            								<html:option value="9">9</html:option>
            								<html:option value="10">10</html:option>
           								</html:select>
         							 </div>
									 --%>
									 
									 
									 <%--dados do endereco --%>
									 
									 <div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-8">
										<label for="logradouro">Logradouro</label>
										<html:text styleClass="form-control obrigatorio" styleId="logradouro" name="turmaForm" property="logradouro" />
									</div>
									<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-8">
										<label for="numero">Nº</label>
										<html:text styleClass="form-control obrigatorio" styleId="numero" name="turmaForm" property="numero" maxlength="4"  />
									</div>
									<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-8">
										<label for="bairro">Bairro</label>
										<html:text styleClass="form-control obrigatorio" styleId="bairro" name="turmaForm" property="bairro" />
									</div>
									<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-8">
										<label for="cidade">Cidade</label>
										<html:text styleClass="form-control obrigatorio" styleId="cidade" name="turmaForm" property="cidade" />
									</div>
									<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-8">
										<label for="cep">CEP</label>
										<html:text styleClass="form-control obrigatorio cep" styleId="cep" name="turmaForm" property="cep" onkeyup="mascara('##.###-###',this,event, false)"/>
									</div>
									<div class="form-group col-xs-12 col-sm-6 col-md-6 col-lg-8">
										<label for="uf">UF</label>
										<html:select styleClass="form-control obrigatorio" styleId="uf" name="turmaForm" property="uf">
											<html:option value="">Selecione</html:option>
											<html:option value="SP">SP</html:option>
											<html:option value="PR">PR</html:option>
											<html:option value="AC">AC</html:option>
											<html:option value="AL">AL</html:option>
											<html:option value="AP">AP</html:option>
											<html:option value="AM">AM</html:option>
											<html:option value="BA">BA</html:option>
											<html:option value="CE">CE</html:option>
											<html:option value="DF">DF</html:option>
											<html:option value="ES">ES</html:option>
											<html:option value="GO">GO</html:option>
											<html:option value="MA">MA</html:option>
											<html:option value="MT">MT</html:option>
											<html:option value="MS">MS</html:option>
											<html:option value="MG">MG</html:option>
											<html:option value="PB">PB</html:option>
											<html:option value="PA">PA</html:option>
											<html:option value="PE">PE</html:option>
											<html:option value="PI">PI</html:option>
											<html:option value="RJ">RJ</html:option>
											<html:option value="RN">RN</html:option>
											<html:option value="RS">RS</html:option>
											<html:option value="RO">RO</html:option>
											<html:option value="RR">RR</html:option>
											<html:option value="SC">SC</html:option>
											<html:option value="SE">SE</html:option>
											<html:option value="TO">TO</html:option>
										</html:select>
									</div>
								</div>
									 
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										
										<button type="submit" id="inserir" class="btn btn-success" onclick="executar('inserir');">Inserir</button>		
										<button type="submit" id="alterar" class="btn btn-default" onclick="executar('alterar');">Alterar</button>
										
										 <button type="button" id="filtrar" class="btn btn-primary" onclick="executarComSubmit('filtrar');">Filtrar</button>	
										<%-- <html:button property="turmaForm" title="Filtrar" value="Filtrar" styleClass="btn btn-primary" onclick="executarSubmit('filtrar');"/> --%>
											
										<button type="button" id="excluir" class="btn btn-danger" onclick="executarComSubmit('excluir');">Excluir</button>						
										<button type="button" id="novo" class="btn btn-success" onclick="executarComSubmit('novo');">Limpar</button>
										
									</div>
								</div>
								
								</form>						
						</div>
					</div>
				</div>

				<!-- Esse panel é o Rodape da página -->
				<div class="footer">
					Rafael G. S. &copy;
				</div>
			</div>
		
		</div>
		</html:form>		
	</body>	
</html>