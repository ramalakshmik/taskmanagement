<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Task Management System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Task Management System" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
<style>
<!-- menu details--
body {margin:0;}

.navbar {
    overflow: hidden;
    background-color: #333;
    font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
    float: left;
    font-size: 16px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.subnav {
    float: left;
    overflow: hidden;
}

.subnav .subnavbtn {
    font-size: 16px;    
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin: 0;
}

.navbar a:hover, .subnav:hover .subnavbtn {
    background-color: red;
}

.subnav-content {
    display: none;
    position: absolute;
    left: 0;
    background-color: red;
    width: 100%;
    z-index: 1;
}

.subnav-content a {
    float: left;
    color: white;
    text-decoration: none;
}

.subnav-content a:hover {
    background-color: #eee;
    color: black;
}

.subnav:hover .subnav-content {
    display: block;
}
<!--end of menu details-->
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 2px solid #dddddd;
    text-align: left;
    padding: 7px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
.navbar {
    overflow: hidden;
    background-color:#0c5978;
    position: fixed; /* Set the navbar to fixed position */
    top: 0; /* Position the navbar at the top of the page */
	left:0;
height:1%;
    width: 20%; /* Full width */
}
</style>
</head>
<body>
  <div class="container">
  
  <!-- <header>
  <h1>Task Management System<span></span></h1>
  </header>
  <div class="navbar">
  <a href="#home">Home</a>
  <a href="#" data-toggle="modal" data-target="#logoutModal">LogOut</a>
</div> -->
<%-- <div class="modal" id="logoutModal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-body">
        <p><i class="fa fa-question-circle"></i> Are you sure you want to log-off? <br /></p>
        <div class="actionsBtns">
            <form action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" class="btn btn-default btn-primary" data-dismiss="modal" value="Logout" />
	                <button class="btn btn-default" data-dismiss="modal">Cancel</button>
            </form>
        </div>
      </div>
    </div>
  </div>
</div> --%>
<br/>
<br/>
<br/>
<br/>
<table style="width:80%" align="center" >
  <thead>
    <tr>
      <th scope="col">Task Name</th>
      <th scope="col">Task Description</th>
      <th scope="col">Assigned By</th>
      <th scope="col">Start Date</th>
      <th scope="col">Planned End Date</th>
	  <th colspan="3">Actions</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        <strong>Project Structure</strong>
      </td>
      <td>Frame template for HospitalMgmt</td>
      <td>Vasavi</td>
      <td>13-Aug-2018</td>
      <td>16-Aug-2018</td>
	  <td><button type="button" class="btn btn-link">Edit</button></td>
	  <td><button type="button" class="btn btn-link">View</button></td>
    </tr>
    <tr>
      <td>
        <strong>DB Design</strong>
      </td>
      <td>Create DB design for TMS</td>
      <td>Sarvesh</td>
      <td>10-Aug-2018</td>
      <td>12-Aug-2018</td>
	  <td><button type="button" class="btn btn-link">Edit</button></td>
	  <td><button type="button" class="btn btn-link">View</button></td>
    </tr>
    <tr>
     <td>
        <strong>Project Structure</strong>
      </td>
      <td>Unit Test Class creation using JUnit</td>
      <td>Sarvesh</td>
      <td>01-Aug-2018</td>
      <td>01-Aug-2018</td>
	  <td><button type="button" class="btn btn-link">Edit</button></td>
	  <td><button type="button" class="btn btn-link">View</button></td>
    </tr>
</tbody>
</table>
</div>
</body>
</html>
