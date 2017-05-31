<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >

<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
			<!-- setando na sessao o caminho do WebContent -->	
			<% request.getSession().setAttribute( "root", request.getContextPath() ); %>
			
			
  
			<!-- IMPORTAÇÃO DAS FOLHAS DE ESTILO  CSS -->
			<link rel="stylesheet" type="text/css" href="${root}/jquery/css/blitzer/jquery-ui-1.9.2.custom.min.css" />
			<link rel="stylesheet" type="text/css" href="${root}/css/style_template.css" />	
			<link rel="stylesheet" type="text/css" href="${root}/css/style_menu.css" />
			
		<title>Turma</title>
		<!-- importando bootstrap -->
		<link href="assets/bootstrap-3.3.5-dist/css/bootstrap.min.css" rel="stylesheet" media="screen">
		<script src="assets/js/jquery-1.10.2.min.js" type="text/javascript"></script>
		
	</head>
	<body>
	<!-- <div id="wrapper"> -->
	<nav class="navbar navbar-inverse">
	
	</nav>
			
			<!-- BANNER -->
			<div class="row">
			<div class="form-group col-xs-12 col-sm-6 col-md-4 col-lg-12">
			<div id="headerwrap">
				<div id="header">
					<%-- <img alt="banner_src" src="${root}/imagens/banner.png" style="border-radius: 10px 10px 0px 0px;"> --%>
				</div>
			</div>
			</div>
			
			
			<%-- <!-- MENU -->
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
								<!-- <a href="#"><span>Quem sou?</span></a> -->
								
								<!-- <ul>
									<li class="last">
										<a href="#" onclick="alert('Nome: Rafael guimaraes');">Desenvolvedor</a>
									</li>
								</ul> -->
							</li>
						</ul>
					</div>
				</div>
			</div><!-- FIM DO NAVIGATIONWRAP --> --%>
			
			<!-- TELA TOTAL -->
			<div id="contentwrap">
			
				<!-- TELA -->
					<div class="form-group col-xs-12 col-sm-6 col-md-4 col-lg-12">
			    
					
					
					
					<!-- TELA EM SI -->
					
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 bg-danger">
						<!-- Cabeçalho da Janela -->
						<!-- <header style="background-color: #3852A3; border-radius:5px 5px 0px 0px;"> -->
						<div class="form-group col-xs-12 col-sm-6 col-md-4 col-lg-5">
							<!-- <div style="padding: 10px; font-family: Verdana; color:white; font-size: 18px;"> -->
								<!-- <div style="float:left;">
									Turma
								</div> -->
								<div class="form-group col-xs-12 col-sm-6 col-md-4 col-lg-5">
								<!-- <div style="margin-left: 97%;"> -->
									<a href="${root}/turmaAction.do?method=abrirCadastro">
										<img alt="Fechar" src="${root}/imagens/close_16_16.png">
									</a>
								</div>
							</div>
						<!-- </header> -->
						
						<!-- Corpo da Janela -->
						<section style="padding: 10px;">						
							
							
								<!-- <div id="LinhaTabela"> -->
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 bg-danger">
									<div>
										<div>
											<!-- caso a consulta nao traga nada -->
											<logic:empty property="listaTurma" name="turmaForm">
											<h3>Nenhum registro encontrado</h3>											
											</logic:empty>
											
											<!-- CASO A CONSULTA POSSUA DADOS -->
											<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 bg-danger">
											<logic:notEmpty  property="listaTurma" name="turmaForm">
											
												<table>
													<tr style="background-color: #ccc">
														<th style="width: 65px;">Código</th>
														<th style="width: 310px;">nome conta</th>
														<th style="width: 310px;">cpf</th>
														<th style="width: 310px;">data</th>
														<th style="width: 310px;">quantidade</th>
														<th style="width: 310px;">urlImagem</th>
														
												
													</tr>
													
													<!-- fazendo um for para correr a lista -->
													<!-- indexID= nome do dado ao indice corrente
													id = nome dado ao objeto corrente
													name = nome do objeto no qual o proprety sera chamado
													proprety= nome do atributo(lista) contido no objeto definido no "name"
													type = tipo dos objetos contidos no "proprety" (ps: informar o caminho completo) -->
													
													<logic:iterate indexId="i" id="turmaCorrente" name="turmaForm" property="listaTurma" type="br.com.srctreinamentotecnologico.sgcintegrado.turma.model.TurmaPO">
														<tr>
															<td>${turmaCorrente.codigo}</td>
															
															<td>${turmaCorrente.nomeConta}</td>
															
															<td>${turmaCorrente.cpf}</td>
															
															<td>${turmaCorrente.data}</td>
															
															<td>${turmaCorrente.quantidade}</td>
															
															<td>${turmaCorrente.urlImagem}</td>
															
															
															<!-- IMAGEM PARA SELECIONAR O REGISTRO -->
															<td>
																<a href="${root}/turmaAction.do?method=selecionar&codigo=${turmaCorrente.codigo}" title="Selecionar" >
																	<button type="submit" id="selecionar" class="glyphicon glyphicon-ok" onclick="executar('selecionar');">selecionar</button>	
																</a>
															</td>
														</tr>
													</logic:iterate>
												</table>
												
											</logic:notEmpty>
											</div>
										</div>									
									</div>												
	
								</div>
							
							
						</section>
					</div>
					
			    </div>
			</div>
			
		</div>
		
	
	
	</body>
</html>