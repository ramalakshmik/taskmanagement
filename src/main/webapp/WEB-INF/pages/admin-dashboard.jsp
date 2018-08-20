<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Task Management System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Time Management System" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="resources/images/logo.png"> 
        <link rel="stylesheet" type="text/css" href="resources/styles/style.css" />
        <link rel="stylesheet" type="text/css" href="resources/styles/demo.css" />
		<link rel="stylesheet" type="text/css" href="resources/styles/custom.css" />
    </head>
    <style>
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
    </style>
<body>
		<div>
			<table style="width:80%" align="center" >
  <tr>
    <th>Employee Name</th>
    <th>Contact</th>
    <th>Country</th>
	<th colspan="3">Task Actions</th>
  </tr>
  <tr>
    <td>Alfreds Futterkiste</td>
    <td>Maria Anders</td>
    <td>Germany</td>
	<td><button type="button" class="btn btn-link">Assign</button></td>
	<td><button type="button" class="btn btn-link">View History</button></td>
	<td><button type="button" class="btn btn-link">Edit</button></td>
  </tr>
  <tr>
    <td>Centro comercial Moctezuma</td>
    <td>Francisco Chang</td>
    <td>Mexico</td>
	<td><button type="button" class="btn btn-link">assign</button></td>
	<td><button type="button" class="btn btn-link">view</button></td>
	<td><button type="button" class="btn btn-link">edit</button></td>
  </tr>
  <tr>
    <td>Ernst Handel</td>
    <td>Roland Mendel</td>
    <td>Austria</td>
	<td><button type="button" class="btn btn-link">assign</button></td>
	<td><button type="button" class="btn btn-link">view</button></td>
	<td><button type="button" class="btn btn-link">edit</button></td>
  </tr>
  <tr>
    <td>Island Trading</td>
    <td>Helen Bennett</td>
    <td>UK</td>
	<td><button type="button" class="btn btn-link">assign</button></td>
	<td><button type="button" class="btn btn-link">view</button></td>
	<td><button type="button" class="btn btn-link">edit</button></td>
  </tr>
  <tr>
    <td>Laughing Bacchus Winecellars</td>
    <td>Yoshi Tannamuri</td>
    <td>Canada</td>
	<td><button type="button" class="btn btn-link">assign</button></td>
	<td><button type="button" class="btn btn-link">view</button></td>
	<td><button type="button" class="btn btn-link">edit</button></td>
  </tr>
  <tr>
    <td>Magazzini Alimentari Riuniti</td>
    <td>Giovanni Rovelli</td>
    <td>Italy</td>
	<td><button type="button" class="btn btn-link">assign</button></td>
	<td><button type="button" class="btn btn-link">view</button></td>
	<td><button type="button" class="btn btn-link">edit</button></td>
  </tr>
</table>
		</div>
</body>
</html>