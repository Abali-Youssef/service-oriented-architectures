<?php 
$code;
$result;
if(isset($_POST['code'])){
  $code = $_POST['code'];
  $client = new SoapClient("http://localhost:9191/?wsdl");
// appeler la methode 
$params = array(
    "code" => $code
  );
$response = $client->__soapCall("getCompte", array($params));
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
  <title>getClient</title>
</head>
<body>
<div>
<?php include 'navBar.php';?>
  <div class="inner">
  <form action="getClient.php" method="post">
  
    <legend>Récupérer les informations d'un compte</legend>
    <div class="mb-3">
     
      <input type="text" id="" name="code" class="form-control" placeholder="code du compte" value="<?php if(isset($code)){  echo $code ; }  ?>">
    </div>
    <button style="width: 100% !important;" type="submit" class="btn btn-primary" >Submit</button>
    
    <fieldset disabled>
    <div style="margin-top:22px !important ;" class="mb-3">
    <label for="disabledTextInput" class="form-label">code</label>
     <input  type="text" id="" class="form-control" placeholder="code" value="<?php if(isset($result)){  echo $result->code ; }  ?>">
   </div>
       <div class="mb-3">
    <label for="disabledTextInput" class="form-label">solde</label>
     <input  type="text" id="" class="form-control" placeholder="solde" value="<?php if(isset($result)){  echo $result->solde ; }  ?>">
   </div>
  </fieldset>
</form>
</div>
</div>
</body>
</html>
