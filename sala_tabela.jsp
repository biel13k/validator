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
										<a href="#" onclick="alert('Nome: Rafael guimaraes');">Desenvolvedor</a>
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
			    <div id="content" style="width:975px;">
					
					
					
					<!-- TELA EM SI -->
					<div id="principal">
						<!-- Cabeçalho da Janela -->
						<header style="background-color: #3852A3; border-radius:5px 5px 0px 0px;">
							<div style="padding: 10px; font-family: Verdana; color:white; font-size: 18px;">
								<div style="float:left;">
									Unidade de medida
								</div>
								<div style="margin-left: 97%;">
									<a href="${root}/turmaAction.do?method=abrirCadastro">
										<img alt="Fechar" src="${root}/imagens/close_16_16.png">
									</a>
								</div>
							</div>
						</header>
						
						<!-- Corpo da Janela -->
						<section style="padding: 10px;">						
							
								<div id="LinhaTabela">
									<div>
										<div>
											<!-- caso a consulta nao traga nada -->
											<logic:empty property="listaTurma" name="turmaForm">
											<h3>Nenhum registro encontrado</h3>											
											</logic:empty>
											
											<!-- CASO A CONSULTA POSSUA DADOS -->
											<logic:notEmpty  property="listaTurma" name="turmaForm">
												<table>
													<tr style="background-color: #ccc">
														<th style="width: 65px;">Código</th>
														<th style="width: 310px;">nome conta</th>
												
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
															
															
															<!-- IMAGEM PARA SELECIONAR O REGISTRO -->
															<td>
																<a href="${root}/turmaAction.do?method=selecionar&codigo=${turmaCorrente.codigo}" title="Selecionar" style="margin: 0px">
																	<img alt="selecionar" src="${root }/imagens/selecionar.png">
																</a>
															</td>
														</tr>
													</logic:iterate>
												</table>
												
											</logic:notEmpty>
										</div>									
									</div>												
	
								</div>
							
							
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