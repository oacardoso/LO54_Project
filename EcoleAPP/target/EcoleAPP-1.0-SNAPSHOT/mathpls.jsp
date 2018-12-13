<!doctype html>
<html>
    <head>
        <style>
            @import url('https://fonts.googleapis.com/css?family=IBM+Plex+Mono:400,400i|IBM+Plex+Sans+Condensed:400,400i|IBM+Plex+Sans:100,100i,400,400i,700,700i|IBM+Plex+Serif:400,400i|Slabo+27px');
            td{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <ul class="navbar">
            <li><a href="index.html">Home page</a>
            <li><a href="mathpls.jsp">Inscripton</a>
        </ul>
        <form class="form-horizontal col-lg-6" action="mathpls" method="POST">
            <div class="form-group">
                <legend>Inscription</legend>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="text" class="col-lg-2 control-label" >Nom : </label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="text" name="lastname">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Prénom : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" name="firstname">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Adresse : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" name="adress">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Numéro : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" name="number">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Email : </label>
                    <div class="col-lg-10">
                        <input type="textarea" class="form-control" id="textarea" name="mail">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="textarea" class="col-lg-2 control-label">Tableau : </label>
                    <div class="col-lg-10">
                        <table>
                            <tr>
                                <td>Carmen</td>
                                <td>33 ans</td>
                                <td>Espagne</td>
                            </tr>
                            <tr>
                                <td>Michelle</td>
                                <td>26 ans</td>
                                <td>États-Unis</td>
                            </tr>
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
