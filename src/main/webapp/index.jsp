<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->
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
    <body>
        <div class="container">
            <header>
                <h1>Task Management System<span></span></h1>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form action="login" autocomplete="on" method="POST"> 
                                <!-- <h1>Log in</h1>  -->
                                <div>
                                	<img class="logoCenter" alt="Logo" src="resources/images/logo.png">
                                </div>
                                <p> 
                                    <label for="username" class="uname">Username </label>
                                    <input id="username" name="username" required="required" type="text" placeholder=""/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd">Password </label>
                                    <input id="password" name="password" required="required" type="password" placeholder=""/> 
                                </p>
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                            </form>
                        </div>
                    </div>
                </div>  
            </section>
        </div>
    </body>
</html>