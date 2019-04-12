<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p> sessao id ${usuario.id} </p>
        <p> sessao nome ${usuario.nome} </p>
        <p> sessao tipo ${usuario.tipo} </p>
        
            <form action="${pageContext.request.contextPath}/ServletLogout" method="post">
            <input type="hidden" name="param" value="logout"/>
            <input type="submit" name ="logout" value="logout"/>
        </form>
    </body>
</html>