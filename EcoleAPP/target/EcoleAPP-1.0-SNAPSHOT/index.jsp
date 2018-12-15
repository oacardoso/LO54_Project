<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN">

<%@page import="fr.utbm.ecole.entity.Location"%>
<%@page import="fr.utbm.ecole.service.LocationService"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.ecole.service.CourseService"%>
<%@page import="fr.utbm.ecole.entity.Course"%>
<%@page import="java.util.ArrayList"%>
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
        <h3>Filtrer :</h3>
        <form>
            <select name="ville">
                <%
                    LocationService Ls = new LocationService();
                    List<LocationService> Locations = Ls.listLocations();
                    for (Iterator iterator1 = Locations.iterator(); iterator1.hasNext();) {
                        Location city = (Location) iterator1.next();
                %>
                <option value="<% out.print(city.getCity());%>">
                    <%
                        out.print(city.getCity());
                    %>
                </option>
                <%}%>
            </select>
            <button class="button" >Filtrer Par Ville</button>

        </form>
        <form>
            <input type="date" name="date">

            <button class="button" >Filtrer par date</button>
        </form>
        <form>
            <input type="text" name="mot_clef">

            <button class="button" >Filtrer par mot-clef</button>
        </form>


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
                    if (request.getParameter("ville") != null) {
                        courses = Cs.listCoursesLoc(request.getParameter("ville"));
                    } 
                    if (request.getParameter("date") != null) {

                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                        Date d = sdf.parse(request.getParameter("date"));
                        courses = Cs.listCourses(d);
                    }
                    if (request.getParameter("mot_clef") != null) {
                        courses = Cs.listCourses(request.getParameter("mot_clef"));
                    }
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