<%@page import="java.util.HashSet"%>
<%@page import="fr.utbm.ecole.entity.Session"%>
<%@page import="fr.utbm.ecole.service.SessionService"%>
<!doctype html>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.String"%>
<%@page import="fr.utbm.ecole.entity.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.ecole.service.CourseService"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscription</title>
        <style>
            @import url('https://fonts.googleapis.com/css?family=IBM+Plex+Mono:400,400i|IBM+Plex+Sans+Condensed:400,400i|IBM+Plex+Sans:100,100i,400,400i,700,700i|IBM+Plex+Serif:400,400i|Slabo+27px');
            table {
                font-family: "Times New Roman", Times, serif;
                border: 2px solid #9E9E9E;
                background-color: #EEEEEE;
                width: 100%;
                text-align: center;
            }
            table td, table th {
                border: 1px solid #BABABA;
                padding: 4px 4px;
            }
            table tbody td {
                font-size: 13px;
                color: #0700FF;
            }
            table tr:nth-child(even) {
                background: #B3CBC3;
            }
            table thead {
                background: #FFFFFF;
                border-bottom: 3px solid #333333;
            }
            table thead th {
                font-size: 15px;
                font-weight: bold;
                color: #000394;
                text-align: center;
                border-left: 2px solid #333333;
            }
            table thead th:first-child {
                border-left: none;
            }

            table tfoot td {
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
        <table class="Tables_choix_sessions">
            <thead>
                <tr>
                    <th>CODE</th>
                    <th>Location</th>
                    <th>Date Debut</th>
                    <th>Date Fin</th>
                </tr>
            </thead>
            <tbody>
                <%
                    Session c_ses = new Session();
                    SessionService Ses = new SessionService();
                    List<SessionService> LSes = Ses.listSessions(request.getParameter("code"));
                    // si la le buton trier ? ?t? clique, on passe la date, sinon on passe null, pour returner tout les session sans trie
                    for (Iterator iterator1 = LSes.iterator(); iterator1.hasNext();) {
                        Session sessionn = (Session) iterator1.next();
                        // pour session on chercher les nombre de client inscrit( avec list.size() ) pour calculer le percentage de client inscrit
                        if (sessionn.getId() == Integer.parseInt(request.getParameter("id_session"))) {
                            c_ses = sessionn;
                %>
                <tr>
                    <td><%out.print(sessionn.getCourse().getCode()); %></td>
                    <td><% out.print(sessionn.getLocation().getCity());%></td>
                    <td><% out.print(sessionn.getStart_date());%></td>
                    <td><% out.print(sessionn.getEnd_date());%></td>

                </tr> 
                <% }
                    }%>
            </tbody>
        </table>
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
                    <label for="textarea" class="col-lg-2 control-label">Prenom : </label>
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
                    <label for="textarea" class="col-lg-2 control-label">Numero : </label>
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
                    <input type="textarea" hidden class="form-control" value="<%out.print(request.getParameter("id_session"));%>" hidden id="textarea" required name="session">
                </div>
            </div>
            <div class="form-group">
                <input type="submit" id="singlebutton" name="Inscrire" class="btn btn-success" value="Enregistrer">
            </div>
        </form>
        <form name="form2" class="form-horizontal col-lg-6"  action="inscription" method="POST">
            <input type="submit" id="secondbutton" name="Inscrire" class="btn btn-success" value="Accueil">
        </form>

        <form name="form3" class="form-horizontal col-lg-6"  action="inscription" method="POST">
            <input type="textarea" hidden class="form-control" value="<%out.print(request.getParameter("id_session"));%>" hidden id="textarea" required name="session">
            <input type="submit" id="secondbutton" name="Inscrire" class="btn btn-success" value="Course session">
        </form>
    </body>
</html>
