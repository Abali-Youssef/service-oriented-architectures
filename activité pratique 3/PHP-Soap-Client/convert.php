<?php 

if(isset($_POST['montant'])){
  $montant = $_POST['montant'];
  $client = new SoapClient("http://localhost:9191/?wsdl");
// appeler la methode 
$params = array(
    "montant" => $montant
  );
$response = $client->__soapCall("Convert", array($params));
//response
$result=$response->return ;
}

?>


<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="style.css">
<!------ Include the above in your HEAD tag --------->
  <title>Convert</title>
</head>
<body>
<?php include 'navBar.php';?>
<div>
  
  <div class="inner">
  <form action="convert.php" method="post" >
  
    <legend>Convertir Dirham au Dollar</legend>
    <div class="mb-3">
     
      <input type="text" id="" name="montant" class="form-control" placeholder="entrer le montant" value="<?php if(isset($montant)){  echo $montant ; }  ?>">
    </div>
    <button style="width: 100% !important;" type="submit" class="btn btn-primary" >Convertir</button>
    
    <fieldset disabled>
    <div class="mb-3">
     
     <input style="margin-top:22px !important ;" type="text" id="" class="form-control" placeholder="montant" value="<?php if(isset($result)){  echo $result ; }  ?>" >
   </div>
  </fieldset>
</form>

</div>
</div>
</body>
</html>






