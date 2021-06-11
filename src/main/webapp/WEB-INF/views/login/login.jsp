<%@ include file="/WEB-INF/views/includes/includes.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="login-panel panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please Sign In</h3>
					</div>
					<div class="panel-body">

						<form role="form"
							action="${loginUrl}" method="post">
						
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Username" type='text'
										name='j_username'>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password"
										name='j_password' type="password" value="">
								</div>
								<div class="checkbox">
									<label> <input name="remember" type="checkbox"
										value="Remember Me">Remember Me
									</label>
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<input type="submit" class="btn btn-lg btn-success btn-block"
									value="login" />
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>
