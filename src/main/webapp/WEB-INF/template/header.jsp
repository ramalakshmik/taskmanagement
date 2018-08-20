<style>
	.header {
  overflow: hidden;
  padding:5px;
}

.header a {
  float: left;
  color: black;
  text-align: center;
  padding: 5px;
  text-decoration: none;
  border-radius: 4px;
}

.header a:hover {
  background-color: #ddd;
  color: black;
}

.header a.active {
  background-color: dodgerblue;
  color: white;
}

.header-right {
  float: right;
}

.logoutLblPos{

   position:fixed;
   right:10px;
   top:5px;
}

</style>

 <div class="header" style="display: flex;flex-direction: row;justify-content: space-between;">
    <img class="" style="float:left;width:25%" alt="Logo" src="resources/images/logo.png">
  	<h5>Task Management System</h5>
  	<div>Logout</div>
</div> 

