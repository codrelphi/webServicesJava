<!Doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login - produitAppV2</title>

    <!-- Bootstrap core CSS -->
    <link href="<%= request.getContextPath() %>/assets/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<%= request.getContextPath() %>/assets/css/login.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form method="post" class="form-signin">
      <h1 class="h3 mb-3 font-weight-normal">Authentification</h1>
      <label for="inputLogin" class="sr-only">Login</label>
      <input type="text" id="inputLogin" name="inputLogin" class="form-control" placeholder="Login" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
      <p class="mt-5 mb-3 text-muted">NiceJavaTeam - @ 2022</p>
    </form>
  </body>
</html>
    