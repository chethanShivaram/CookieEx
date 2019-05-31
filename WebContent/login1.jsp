<!DOCTYPE html>
<html>
<head>
<style>
body {font-family: Calibri;}

input[type=text], input[type=password] {
  width:100%;
  padding: 12px 20px;
  margin: 8px 0;
  border: 1px solid #ccc;
  box-sizing: border-box;
  border-radius: 15px;
  display: inline-block;

}
.container {
  width: 300px;
  position: absolute;
  left: 15%;
  top: 15%; 
}

html,body{
max-width:100%;
overflow-x:hidden;
overflow-y:hidden;
}

button {
  background-image: linear-gradient(to right, blue, #ddd);
  border: 2px solid grey;
  color:black;
  padding: 14px 10px;
  margin: 8px 0;
  border: none;
  border-radius: 15px;
  cursor: pointer;
  text-align: center;
  width: 300px;
  height: 40px;
}
button:hover{
  opacity: 0.4;
}

.box {
  background-color: lightgrey;
  width: 20%;
  border: 1px solid white;
  border-radius: 15px;
  padding: 120px 70px;
  margin: 10px;
  position: absolute;
  left: 33%;
  top: 30%; 
}

</style>
</head>
<body>
<form action="LoginServlet" method="get">
<div class="box">
  <div class="container">
    <label><b>USERNAME</b></label><br>
    <input type="text" name="username" required>
    <label><b>PASSWORD</b></label><br>
    <input type="password" name="pasword" required>
    <button type="submit" id="button">Login</button>
  </div>
</div>
</form>
</body>
</html>