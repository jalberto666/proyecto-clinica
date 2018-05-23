
<!DOCTYPE>
<html>
<head>
	<title></title>
</head>
<body>



<?php
$server = "localhost";
$usuario = "root";
$contraseña = "";
$bd = "bdproductows";

$conexion = mysqli_connect($server, $usuario, $contraseña, $bd) or die ("Hubo un Error en la base de datos");

$codigo = $_POST['txtcodigo'];
$nombre = $_POST['txtnombre'];
$apellidoP = $_POST['txtapellidoP'];
$apellidoM = $_POST['txtapellidoM'];
$sexo = $_POST['txtsexo'];
$fechaN = $_POST['txtfechaN'];
$municipio = $_POST['txtmunicipio'];
$centroSalud = $_POST['txtcentroSalud'];
$direccion = $_POST['txtdireccion'];
$mna = $_POST['txtmna'];

$insertar = "INSERT into producto values ('$codigo', '$nombre', '$apellidoP','$apellidoM','$sexo', '$fechaN' '$municipio' '$centroSalud' '$direccion' '$mna')";

$resultado = mysqli_query($conexion, $insertar)
or die ("Parece que hay un error para registrar los datos revisa bien");

mysqli_close ($conexion);
echo "Datos Registrados correctamente ";

?>


</body>
</html>