<!DOCTYPE html>
<html>
<head>
	<title>Eliminar</title>
</head>
<body>

<?php

	$server = "localhost";
	$usuario = "root";
	$contraseña = "";
	$bd = "bdproductows";

	$conexion = mysqli_connect($server, $usuario, $contraseña, $bd) or die ("Hubo un Error en la base de datos");


	

	$codigo= $_POST['txtcodigo'];
	$nombre = $_POST['txtnombre'];
	


	mysqli_query($conexion, "UPDATE producto set nombre='$nombre' where codigo='$codigo'") or die ("Error al actualizar los datos");

	mysqli_close($conexion);
	echo "<p> Datos actualziados Correctamente </p>" ;


?>

</body>
</html>