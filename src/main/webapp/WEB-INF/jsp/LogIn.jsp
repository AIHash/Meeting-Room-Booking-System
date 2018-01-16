<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>Log In</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="shortcut icon" href="logo1.png"/>
</head>
<body >

<div class="container">
    <h3><font color="red">${errorMessage}</font></h3>
  <h2  style="margin-left:17%">Log in to book a room</h2>
  <form class="form-horizontal" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="User">User:</label>
      <div class="col-xs-4">
        <input style="size:55px" type="text" class="form-control" id="User" placeholder="Enter User" name="User">
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-xs-4">          
        <input size="55" type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" >
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Submit</button>
      </div>
    </div>
  </form>
</div>

</body>
  <style>

  body {
     margin: 20px 20px 20px 20px;
    font-family: Arial;
    background-image: url("../Background.jpg");
    background-size: cover;
}
</style>
</html>
