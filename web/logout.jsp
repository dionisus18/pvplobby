<%-- 
    Document   : logout
    Created on : 19/06/2018, 02:41:02 AM
    Author     : Kevin
--%>

<%  
    session.invalidate();
    response.sendRedirect("index.jsp");
%>
