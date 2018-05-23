<!DOCTYPE html>
<html>
<head>
	<title>Eliminar</title>
	 <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/plantillaSitioWeb.css"/>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">

        <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">    
        <link href="css/styles.css" rel="stylesheet">
</head>
<body>

<div class="col-md-1"></div>

        <h1 align="center">CENTRO DE SALUD CHILCUAHUTLA </h1>


        <div class="col-md-12 text-center">
            <a href="indexMOD.html">Registro </a>
            <a href="eliminar.html"> Eliminar</a>
            <a href="actualizar.html"  >Actualizar</a>
            <a href="consultar.html"> MostrarDatos</a>
            
        </div>


<?php

	$server = "localhost";
	$usuario = "root";
	$contraseña = "";
	$bd = "bdproductows";

	$conexion = mysqli_connect($server, $usuario, $contraseña, $bd) or die ("Hubo un Error en la base de datos");

	$codigo= $_POST['txtcodigo'];
	$nombre = $_POST['txtnombre'];

	mysqli_query($conexion, "DELETE from producto where codigo='$codigo'") or die ("Error al eliminar los datos");

	mysqli_close($conexion);
	echo "Datos eliminados Correctamente";


?>

</body>
</html>