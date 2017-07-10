<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IMAX | theater</title>

</head>

<body>

	<div style="margin: 15px;">

		<ol class="breadcrumb" style="margin-bottom: 5px;">
			<li><a href="/admin">Theater</a></li>
			<li><a href="/cinemas/form">Create cinema</a></li>
			<li class="active">Create movie</li>

		</ol>

		<h1 style="text-align: center;">Create movie</h1>


		<form:form action="/movies/form" method="post" class="form-horizontal">
			<div class="form-group">
				<label for="inputNameMovie" class="col-sm-2 control-label">Name
					movie</label>
				<div class="col-sm-5">
					<input type="text" name="moviename" class="form-control"
						id="inputNameMovie" placeholder="name movie">
				</div>
			</div>

			<div class="form-group">
				<label for="inputMinutes" class="col-sm-2 control-label">Minutes</label>
				<div class="col-sm-5">
					<input type="text" name="minutes" class="form-control"
						id="inputMinutes" placeholder="minutes">
				</div>
			</div>

			<div class="form-group">
				<label for="inputShowFromDate" class="col-sm-2 control-label">Show
					from date</label>
				<div class="col-sm-5">
					<input type="date" name="showFromDate" class="form-control"
						id="inputShowFromDate" placeholder="yyyy-mm-dd">
				</div>
			</div>


			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">create
						moviehall</button>
				</div>
			</div>
		</form:form>


		<div class="container">
			<div class="row"><label>Загрузить изображение:</label><input type="file" id="file" name="file" /></div><br><br>
			<div class="row"><span id="output"></span></div>
			<br><br>

			<div class="row"><label>Мультизагрузка изображений:</label><input type="file" id="fileMulti" name="fileMulti[]" multiple /></div><br><br>
			<div class="row"><span id="outputMulti"></span></div>
		</div>



		<script>
            function handleFileSelectSingle(evt) {
                var file = evt.target.files; // FileList object

                var f = file[0]

                // Only process image files.
                if (!f.type.match('image.*')) {
                    alert("Только изображения....");
                }

                var reader = new FileReader();

                // Closure to capture the file information.
                reader.onload = (function(theFile) {
                    return function(e) {
                        // Render thumbnail.
                        var span = document.createElement('span');
                        span.innerHTML = ['<img class="img-thumbnail" src="', e.target.result,
                            '" title="', escape(theFile.name), '"/>'].join('');
                        document.getElementById('output').innerHTML = "";
                        document.getElementById('output').insertBefore(span, null);
                    };
                })(f);

                // Read in the image file as a data URL.
                reader.readAsDataURL(f);
            }


            document.getElementById('file').addEventListener('change', handleFileSelectSingle, false);

            function handleFileSelectMulti(evt) {
                var files = evt.target.files; // FileList object
                document.getElementById('outputMulti').innerHTML = "";
                for (var i = 0, f; f = files[i]; i++) {

                    // Only process image files.
                    if (!f.type.match('image.*')) {
                        alert("Только изображения....");
                    }

                    var reader = new FileReader();

                    // Closure to capture the file information.
                    reader.onload = (function(theFile) {
                        return function(e) {
                            // Render thumbnail.
                            var span = document.createElement('span');
                            span.innerHTML = ['<img class="img-thumbnail" src="', e.target.result,
                                '" title="', escape(theFile.name), '"/>'].join('');
                            document.getElementById('outputMulti').insertBefore(span, null);
                        };
                    })(f);

                    // Read in the image file as a data URL.
                    reader.readAsDataURL(f);
                }
            }


            document.getElementById('fileMulti').addEventListener('change', handleFileSelectMulti, false);

		</script>


		<br> <br> <a href="/">to theater</a>

	</div>
</body>


</html>