<!DOCTYPE html>
<html>
<head>
	<title></title>
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
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}
</style>

</head>
<body>


<?php

	$server = "localhost";
	$usuario = "root";
	$contraseña = "";
	$bd = "bdproductows";

	$conexion = mysqli_connect($server, $usuario, $contraseña, $bd) 
		or die ("Error en la conexion");

	$consulta = mysqli_query($conexion, "SELECT * from  producto") or die ("Hubo un Error al mostrar los datos");

	echo '<table border="2">';
	echo '<tr>';
	echo '<th id="codigo"> Codigo</th>';
	echo '<th id="nombre"> Nombre  </th>';
	echo '<th id="apellidoP"> ApellidoPaterno  </th>';
	echo '<th id="apellidoM"> ApellidoMaterno  </th>';
	echo '<th id="sexo"> Sexo  </th>';
	echo '<th id="fechaN"> FechaNacimiento </th>';
	echo '<th id="municipio"> Municipio  </th>';
	echo '<th id="centroSalud">  CentroSalud </th>';
	echo '<th id="direccion"> Direccion  </th>';
	echo '<th id="mna"> Manzana-Numero  </th>';
	echo '</tr>';
	

	while ($extraido = mysqli_fetch_array($consulta))
	{
		echo '<tr>';
		echo '<td>'.$extraido['codigo'].'</td>';
		echo '<td>'.$extraido['nombre'].'</td>';
		echo '<td>'.$extraido['apellidoP'].'</td>';
		echo '<td>'.$extraido['apellidoM'].'</td>';
		echo '<td>'.$extraido['sexo'].'</td>';
		echo '<td>'.$extraido['fechaN'].'</td>';
		echo '<td>'.$extraido['municipio'].'</td>';
		echo '<td>'.$extraido['centroSalud'].'</td>';
		echo '<td>'.$extraido['direccion'].'</td>';
		echo '<td>'.$extraido['mna'].'</td>';
		echo '</tr>';

	}
	
	mysqli_close($conexion);
	echo '</table>';

	

?>

</body>
</html> 