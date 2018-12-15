<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.String"%>
<%@page import="fr.utbm.ecole.entity.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.ecole.service.CourseService"%>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <style>
            @import url('https://fonts.googleapis.com/css?family=IBM+Plex+Mono:400,400i|IBM+Plex+Sans+Condensed:400,400i|IBM+Plex+Sans:100,100i,400,400i,700,700i|IBM+Plex+Serif:400,400i|Slabo+27px');
            td{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <ul class="navbar">
            <li><a href="/EcoleAPP">Course</a>
            <li><a href="course_session">Course Session</a>
            <li><a href="inscription">Course Inscription</a>
        </ul>
        <form name="form1" class="form-horizontal col-lg-6"  action="inscription" method="POST">
            <div class="form-group">
                <h1>Inscription</h1>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="text" class="col-lg-2 control-label" >Nom : </label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="text" required  name="lastname">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Prénom : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" required name="firstname">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Adresse : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" required name="adress">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Numéro : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" required name="number">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">    
                    <label for="textarea" class="col-lg-2 control-label">Email : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" required name="mail">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <div class="col-lg-10">
                        <table class="Tables_choix_sessions">
                            <thead>
                                <tr>
                                    <th>CODE</th>
                                    <th>Description</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%
                                    CourseService Cs = new CourseService();
                                    Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("date"));
                                    List<CourseService> courses = Cs.listCourses(date1);
                                    // si la le buton trier à été clique, on passe la date, sinon on passe null, pour returner tout les session sans trie
                                    for (Iterator iterator1 = courses.iterator(); iterator1.hasNext();) {
                                        Course course = (Course) iterator1.next();
                                        // pour session on chercher les nombre de client inscrit( avec list.size() ) pour calculer le percentage de client inscrit
                                        if (course.getCode().equals(request.getParameter("code"))) {
                                %>
                                <tr>
                                    <td><%out.print(course.getCode()); %></td>
                                    <td><% out.print(course.getTitle());%></td>
                                </tr> 
                                <% }
                                    }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <button class="button" name="Inscrire" value="Enregistrer">Enregistrer</button>
            </div>
        </form>
    </body>
</html>
