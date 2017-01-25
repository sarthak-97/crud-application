<html>
<head>
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
      <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection" />
      <link rel="stylesheet" type="text/css" href="css/style.css" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
     
      <link rel="shortcut icon" type="image/png" href="assest/images/favicon.png">
</head>
<body>
<h2>add record</h2>
<br>
<div style="margin-left:4cm;margin-bottom:1cm;valign:middle;align:left;" id="demo">
<Form name=frm action=add method=post>
enter the name<input type=text name=name><br>
enter the age<input type=text name=age><br>
enter the college name<input type=text name=clg><br>
enter address<input type=text name=address><br>
<button class="btn waves-effect waves-light indigo accent-4 centre-align hoverable" type="submit" name="action" onclick="myFunction()">submit here
</button>
</Form>

<br>
DELETE RECORD
<Form name=frm action=del method=post>
enter the id<input type=text name=name><br>
enter the age<input type=text name=age><br>
<button class="btn waves-effect waves-light indigo accent-4 centre-align hoverable" type="submit" name="action" onclick="myFunction()">submit here
</button>

</Form>
<BR>
MODIFY RECORD
<form name=frm3 action=edit method=post>
enter Student id<input type=text name=id><br>
<input type=submit>
</form>
</body>
</html>
