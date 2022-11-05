<?php 
$code;
$result;

  $client = new SoapClient("http://localhost:9191/?wsdl");
// appeler la methode 

$response = $client->__soapCall("listeComptes", array());
//response
if(isset($response->return)){ $result=$response->return ; }



?>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
  <title>home</title>
</head>
<body>
<?php include 'navBar.php';?>

<div class="inner">
<h1>Liste des comptes</h1>
<br>
<table>

  <tr>
    <th>Company</th>
    <th>Contact</th>
    <th>Date de création</th>
  </tr>
  <?php 
  if(isset($result)){ 
  foreach ($result as $res) {?>
  <tr>
    <td><?php echo $res->code ; ?></td>
    <td><?php echo $res->solde ; ?></td>
    <td><?php echo $res->dateCreation ; ?></td>
  </tr>
 <?php 
  }
} else {

  ?>
  <tr>
    <td colspan="3" >pas de Compte pour afficher</td>

  </tr>
 <?php 
  }

?>

  


</table>
</div>
</div>
</body>
</html>
