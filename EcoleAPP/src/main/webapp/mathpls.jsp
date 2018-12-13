
<!doctype html>
<html>
    <body>

<p>Bonjour et bienvenue sur le site de l'école !</p>

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
  <div class="form-group">
    <button class="pull-right btn btn-default" name="Inscrire" value="Enregistrer">Enregistrer</button>
  </div>
</form>
    </body>
</html>
