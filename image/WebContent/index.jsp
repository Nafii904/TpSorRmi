<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 01/04/2020
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <title>Images</title>
</head>
<body class=" m-0 p-0">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<div class="row m-0">
  <h3 style="margin: auto">
    <strong>
      Image TP
    </strong>
  </h3>
</div>
<div class="row">
<ul class="nav nav-pills mb-3 col-6 text-center" id="pills-tab" role="tablist" style="margin-left: auto ; margin-right: auto">
  <li class="nav-item" >
    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">
    	Enregistrer image
    </a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">
    	Rechercher Image
    </a>
  </li>
</ul>
<div class="tab-content col-12" id="pills-tabContent">
  <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
	  <div class="row m-0 p-2 col-12">
		  <div class="col-8 row p-4" style="margin: auto auto auto auto ; border: outset">
		    <form name="savePicture" class="form-inline col-12 row" action="picture" method="post" enctype='multipart/form-data'>
		      <div class="form-group mb-2 col-12">
		        <div class="col-12 row">
		          <label for="inputTitle" class="col-3 col-form-label text-right"><b>Title</b></label>
		          <input type="text" class="form-control col-5" id="inputTitle" name="title">
		        </div>
		        <hr style="background-color: lightgrey ; width: 100%">
		        <div class="col-12 row mt-3">
		          <label for="picture" class=" col-3 col-form-label text-right"><b>Image</b></label>
		          <input name="file" type="file" readonly class=" col-9 p-0" id="picture" value="image">
		        </div>
		        <hr style="background-color: lightgrey ; width: 100%">
		        <div class="col-12 row mt-3">
		          <button type="submit" class="btn btn-primary mb-2 col-3"
		                  style="margin-left: auto ; margin-right: 0">
		            Charger <i class="fa fa-download"></i>
		          </button>
		        </div>
		      </div>
		
		    </form>
		  </div>
		</div>
  </div>
  <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
	  <div class="row m-0 p-2 col-12">
			  <div class="col-8 row p-4" style="margin: auto auto auto auto ; border: outset">
			    <form name="displayPicture" class="form-inline col-12 row" action="GetPicture" method="get">
			        <div class="col-12 row">
			          <label for="inputTitle" class="col-3 col-form-label text-right"><b>Title</b></label>
			          <input type="text" class="form-control col-5" id="inputTitle" name="title">
			        </div>
			        <button type="submit" class="btn btn-primary mb-2 col-3"
		                  style="margin-left: auto ; margin-right: 0">
		            Charger <i class="fa fa-download"></i>
		          </button>
			    </form>
			  </div>
			</div>
  </div>
</div>
</div>
</body>
</html>
