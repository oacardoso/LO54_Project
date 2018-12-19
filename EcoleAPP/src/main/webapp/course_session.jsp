<%-- 
    Document   : course_session
    Created on : 13 déc. 2018, 19:17:32
    Author     : User
--%>

<%@page import="fr.utbm.ecole.service.SessionService"%>
<%@page import="fr.utbm.ecole.entity.Session"%>
<%@page import="fr.utbm.ecole.entity.Course"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="fr.utbm.ecole.service.CourseService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
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
            .popup {
                position: relative;
                display: inline-block;
                cursor: pointer;
            }

            /* The actual popup (appears on top) */
            .popup .popuptext {
                visibility: hidden;
                width: 160px;
                background-color: #555;
                color: #fff;
                text-align: center;
                border-radius: 6px;
                padding: 8px 0;
                position: absolute;
                z-index: 1;
                bottom: 125%;
                left: 50%;
                margin-left: -80px;
            }

            /* Popup arrow */
            .popup .popuptext::after {
                content: "";
                position: absolute;
                top: 100%;
                left: 50%;
                margin-left: -5px;
                border-width: 5px;
                border-style: solid;
                border-color: #555 transparent transparent transparent;
            }

            /* Toggle this class when clicking on the popup container (hide and show the popup) */
            .popup .show {
                visibility: visible;
                -webkit-animation: fadeIn 1s;
                animation: fadeIn 1s
            }

            /* Add animation (fade in the popup) */
            @-webkit-keyframes fadeIn {
                from {opacity: 0;}
                to {opacity: 1;}
            }

            @keyframes fadeIn {
                from {opacity: 0;}
                to {opacity:1 ;}
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des Sessions</title>
        <script>
            // When the user clicks on <div>, open the popup
            function myFunction() {
                var popup = document.getElementById("myPopup");
                popup.classList.toggle("show");
            }

        </script>
    </head>
    <body>
        <form>
            <h1> Menu</h1>
            <h2>Sessions pour le cours : <% out.print((String) request.getParameter("td")); %></h2>
            <table class="Table_des_cours">
                <thead>
                    <tr>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Percentage</th>
                        <th>Max People</th>
                        <th>Location</th>

                    </tr>
                </thead>
                <tbody>
                    <%
                        SessionService Ses = new SessionService();
                        List<SessionService> Sessions = Ses.listSessions((String) request.getParameter("td"));
                        // si la le buton trier à été clique, on passe la date, sinon on passe null, pour returner tout les session sans trie
                        for (Iterator iterator1 = Sessions.iterator(); iterator1.hasNext();) {
                            Session sessionn = (Session) iterator1.next();
                            int max = sessionn.getMax();
                            // pour session on chercher les nombre de client inscrit( avec list.size() ) pour calculer le percentage de client inscrit
                    %>

                    <tr>
                        <td class="popup" style="cursor:pointer;display:block;width:100%;height:100%;" onclick="
                            <%
                                if (sessionn.getMax() == Ses.numParticipants(sessionn.getId())) {
                            %>
                                myFunction();
                            <%
                            } else {
                            %>
                                location.href = 'http://localhost:8080/EcoleAPP/inscription?id_session=<%out.print(sessionn.getId());%>&code=<%out.print(sessionn.getCourse().getCode());%>';
                            <%
                                }
                            %>


                            " id="t2did" ><% out.print(sessionn.getStart_date()); %>
                            <span class="popuptext" id="myPopup"> Vous ne pouvez pas vous inscrire car le nombre de participant maximum est atteint.</span>
                        </td>
                        <td><% out.print(sessionn.getEnd_date()); %></td>
                        <td><%out.print((((float) Ses.numParticipants(sessionn.getId()) / (float) max)) * 100 + "%");%></td>
                        <td><% out.print(max); %></td>
                        <td><% out.print(sessionn.getLocation().getCity()); %></td>
                    </tr> 
                    <% }%>
                </tbody>
            </table>
        </form>
                
        <form name="form2" class="form-horizontal col-lg-6"  action="course_session" method="POST">
            <input type="submit" id="secondbutton" name="Inscrire" class="btn btn-success" value="Accueil">
        </form>
    </body>
</html>