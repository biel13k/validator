<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
			<!-- setando na sessao o caminho do WebContent -->	
			<% request.getSession().setAttribute( "root", request.getContextPath() ); %>
			
			<!-- IMPORTAÇÃO DO JQUERY -->
			<script type="text/javascript" src="${root}/jquery/jquery-1.11.1.min.js"></script>
			<!-- IMPORTAÇÃO DAS MASCARAS E DO TEMPLATE -->
  			<script type="text/javascript" src="${root}/jquery/mask/jquery.maskedinput.min.js"></script>
  			<script type="text/javascript" src="${root}/jquery/css/blitzer/jquery-ui-1.9.2.custom.min.js"></script>
  
			<!-- IMPORTAÇÃO DAS FOLHAS DE ESTILO  CSS -->
			<link rel="stylesheet" type="text/css" href="${root}/jquery/css/blitzer/jquery-ui-1.9.2.custom.min.css" />
			<link rel="stylesheet" type="text/css" href="${root}/css/style_template.css" />
			<link rel="stylesheet" type="text/css" href="${root}/css/style_campos.css" />
			<link rel="stylesheet" type="text/css" href="${root}/css/style_botao.css" />
			<link rel="stylesheet" type="text/css" href="${root}/css/style_menu.css" />
			
		<title>Agenda</title>
		
		<script type="text/javascript">
		$(document).ready(function(){
			$('#form_turma').attr("autocomplete", "off");
			
			
			/*definindo campos obrigatorios */
			$('.obrigatorio').attr("required", "required");
			
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
		});
		
		function executar( nomeMetodo ){
		    document.getElementById("form_turma").method.value = nomeMetodo;
			}

			function executarSubmit(nomeMetodo) {
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
		</script>
	</head>
	<body>
	<div id="wrapper">
			
			<!-- BANNER -->
			<div id="headerwrap">
				<div id="header">
					<img alt="banner_src" src="${root}/imagens/banner.png" style="border-radius: 10px 10px 0px 0px;">
				</div>
			</div>
			
			<!-- MENU -->
			<div id="navigationwrap">
				<div id="navigation">
					<div id="cssmenu" class="font_menu">
						<ul>
							<li class="active">
								<a href="${root}/index.html">
									<span>Sair</span>
								</a>
							</li>
							<li class="has-sub">
								<a href="#"><span>Quem sou?</span></a>
								
								<ul>
									<li class="last">
										<a href="#" onclick="alert('Nome: Rafael Guimarães Santos \n Java junior\nCel:(14) 9.9652-7007');">Desenvolvedor</a>
									</li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div><!-- FIM DO NAVIGATIONWRAP -->
			
			<!-- TELA TOTAL -->
			<div id="contentwrap">
			
				<!-- TELA -->
			    <div id="content" style="width:515px;">
					
					<!-- Mensagens Informativas -->
					<div class="ui-widget" style="text-align: center;">
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
					
					<!-- TELA EM SI -->
					<div id="principal">
						<!-- Cabeçalho da Janela -->
						<header style="background-color: #3852A3; border-radius:5px 5px 0px 0px;">
							<div style="padding: 10px; font-family: Verdana; color:white; font-size: 18px;">
								<div style="float:left;">
									Turma
								</div>
								<div style="margin-left: 97%;">
									<a href="${root}/index.html">
										<img alt="Fechar" src="${root}/imagens/close_16_16.png">
									</a>
								</div>
							</div>
						</header>
						
						<!-- Corpo da Janela -->
						<section style="padding: 10px;">
							
							<!-- FAZER O FORMULARIO AQUI -->
							<html:form styleId="form_turma" action="/turmaAction.do" method="post">
								<html:hidden property="method" value="empty"/>
								
								<!--Linha - 1 -->
									
								<div id="Linha1">
									<!-- determina o conjunto label+ campo -->
									<div>
										<div>
											<label for="codigo">Código</label>
											<html:text styleId="codigo" styleClass="campo_formulario_centralizado" property="codigo" name="turmaForm" style="width:414px" readonly="true"/>
										</div>				
									</div>
									
									
									<div>
										<div>
											<label for="nomeConta">Nome da Conta</label>
											<html:text  styleId="nomeConta"  styleClass="campo_formulario_centralizado obrigatorio" property="nomeConta" name="turmaForm" style="width:360px" />
										</div>									
									</div>
									
									<!-- determina o conjunto label+ campo -->
									
									
									
									
									
									
								</div>
								
								<!--Linha - 2 -->
									
								
								<div style="clear: both;"></div>

															<!-- Linha -->
							        <div id="linhaBotoes">
							         <!-- Determina o conjunto label + campo -->
							         <div>
							          <div>
							           <html:submit styleId="inserir" property="turmaForm" title="Inserir" value="Inserir" styleClass="botao" onclick="executar('inserir');"/>
							           <html:submit styleId="alterar" property="turmaForm" title="Alterar" value="Alterar" styleClass="botao" onclick="executar('alterar');"/>
							           <html:button property="turmaForm" title="Excluir" value="Excluir" styleClass="botao" onclick="executarSubmit('excluir');"/>
							           <html:button property="turmaForm" title="Filtrar" value="Filtrar" styleClass="botao" onclick="executarSubmit('filtrar');"/>
							           <html:button property="turmaForm" title="Novo" value="Novo" styleClass="botao" onclick="executarSubmit('novo');"/>
							          </div>
							         </div>        
							        </div>
								
							</html:form> 
							
							
						</section>
					</div>
					
			    </div>
			</div>
			<div id="footerwrap">
				<div id="footer">
					<p>Desenvolvido por SRC Treinamento Tecnológico LTDA ME - Java Aplicado VIII</p>
		            <p>SysAgenda &copy; - Todos os direitos reservados.</p>
				</div>
			</div>
		</div>
	
	
	</body>
</html>