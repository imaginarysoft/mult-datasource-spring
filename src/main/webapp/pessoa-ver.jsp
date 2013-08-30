<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<html>


	<body>

	
	
	<table class="table">
						<thead>
							<tr>


								<th>ID</th>
								<th>Nome </th>
								<th>Email</th>
								<th>Data  Nascimento</th>
							</tr>
						</thead>
						<tbody>
						
						<tr> <td>  <p><c:out value="${PES.id}" /></p>    </td>  
						     <td>  <p><c:out value="${PES.nome}" /></p>    </td>  
						     <td>  <p><c:out value="${PES.email}" /></p>    </td>   
						     <td>  <p><c:out value="${PES.dataNascimento}" /></p>    </td>  
						</tr>
						

    </table>
	
			  	
			  	
			  	  
		             
		   
		      <!-- private Integer id; 
	private String nome; 
	private String email; 
	private Date dataNascimento;
	 
		      -->
		      
		 

		








	</body>

	
	
</html>