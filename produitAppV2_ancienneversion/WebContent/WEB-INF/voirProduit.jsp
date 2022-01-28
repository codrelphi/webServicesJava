<%@ include file="include/header.jsp" %>

    <!-- Begin page content -->
    <main role="main" class="container">
	     <div class="container">
		    <nav aria-label="breadcrumb">
			  <ol class="breadcrumb">
			    <li class="breadcrumb-item"><a href="<%= request.getContextPath() %>/produits">Home</a></li>
			    <li class="breadcrumb-item active" aria-current="page">Voir un Produit</li>
			  </ol>
			</nav>
	     
			  <div class="form-group row">
			    <label for="code" class="col-sm-2 col-form-label">Code</label>
			    <div class="col-sm-3">
			      <input type="text" readonly value="<c:out value="${produit.code }"></c:out>" class="form-control-plaintext" id="code" name="code">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="prix" class="col-sm-2 col-form-label">Prix</label>
			    <div class="col-sm-3">
			      <input type="number" step=".00" min="0" readonly value="<c:out value="${produit.prix }"></c:out>" class="form-control-plaintext" id="prix" name="prix" placeholder="100.50">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="code" class="col-sm-2 col-form-label">Description</label>
			    <div class="col-sm-8">
			      <input type="text" max="100" readonly value="<c:out value="${produit.description }"></c:out>" class="form-control-plaintext" id="description" name="description">
			    </div>
			  </div>
			  <div class="row">
			  	<div class="col-sm-2">
			  		<a href="<%= request.getContextPath()%>/produits">
			  			<button type="button" class="btn btn-dark btn-md mr-1"><i class="fas fa-backward"></i> Retour</button>
			  		</a>
			  	</div>
			  	<div class="col-sm-3"></div>
			  	<div class="col-sm-7"></div>
			  </div>
	     </div>
	    
    </main>
    
<%@ include file="include/footer.jsp" %>