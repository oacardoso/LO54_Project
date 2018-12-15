
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.ecole.service.CourseService"%>
<%@page import="fr.utbm.ecole.entity.Course"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">
<html>
    <head>
        <title>GreatSchool</title>
        <style>
            @import url('https://fonts.googleapis.com/css?family=IBM+Plex+Mono:400,400i|IBM+Plex+Sans+Condensed:400,400i|IBM+Plex+Sans:100,100i,400,400i,700,700i|IBM+Plex+Serif:400,400i|Slabo+27px');
            table.Table_des_cours {
                font-family: "Times New Roman", Times, serif;
                border: 2px solid #9E9E9E;
                background-color: #EEEEEE;
                width: 100%;
                text-align: center;
            }
            table.Table_des_cours td, table.Table_des_cours th {
                border: 1px solid #BABABA;
                padding: 4px 4px;
            }
            table.Table_des_cours tbody td {
                font-size: 13px;
                color: #0700FF;
            }
            table.Table_des_cours tr:nth-child(even) {
                background: #B3CBC3;
            }
            table.Table_des_cours thead {
                background: #FFFFFF;
                border-bottom: 3px solid #333333;
            }
            table.Table_des_cours thead th {
                font-size: 15px;
                font-weight: bold;
                color: #000394;
                text-align: center;
                border-left: 2px solid #333333;
            }
            table.Table_des_cours thead th:first-child {
                border-left: none;
            }

            table.Table_des_cours tfoot td {
                font-size: 14px;
            }

            #tdid{
                cursor:pointer;
                display:block;
                width:100%;
                height:100%;
            }
        </style>

    </head>  
    <body>

        <h1>Accueil</h1>

        <ul class="navbar">
            <li><a href="/EcoleAPP">Course</a>
            <li><a href="course_session">Course Session</a>
            <li><a href="mathpls">Course Inscription</a>
        </ul>
        <h3>Filtrer :</h3>

    <input type="date" name="start_date">


    <input type="date" name="end_date">

    <table class="Table_des_cours">
        <thead>
            <tr>
                <th>CODE</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <%
                CourseService Cs = new CourseService();
                List<CourseService> courses = Cs.listCourses("");
                // si la le buton trier à été clique, on passe la date ou le mot cle, sinon on passe null, pour returner tout les session sans trie
                for (Iterator iterator1 = courses.iterator(); iterator1.hasNext();) {
                    Course course = (Course) iterator1.next();
            %>
            <tr>
                <td onclick="location.href = 'http://localhost:8080/EcoleAPP/course_session?td=<%out.print(course.getCode());%>'" id="tdid" > <% out.print(course.getCode()); %> </td>
                <td><% out.print(course.getTitle()); %></td>

            </tr> 
            <% }%>
        </tbody>
    </table>
</body>

</html>