
var user = {korisnickoIme: "", sifra: "", uloga: ""}
//Mislim da sad ovu promenjivu user cuvamo u local storage. i njenu vrednost update-ujemo svaki put
//kada se neko loguje, tj kada neko pozove ovu btnLogIn funkciju, koja dobija ovo data kao korisnika
// ako kontas? :D
// i onda treba napisati funkcije za proveru da li je ulogovan korisnik neki koje cemo koristiti u htmlovima
// na slican nacin kao sto su na vezbama radili


window.addEventListener("load", function () {
	
	$( "#btnAddNewUser" ).click(function() {

		var username = 	$( "#txtUsername" ).val();
		var password = $("#txtPassword").val();
		
		var JSONObject= {"korisnickoIme": username, "sifra": password }; 


		$.ajax({ url: "api/user", 
		type: "POST", 
		data: JSON.stringify(JSONObject), 
		contentType: "application/json",
		success: function(data, textStatus, response){
				
  
		console.log("New user recieved username: " + response.getResponseHeader('Location'));
		   },
		error: function (response, textStatus, errorThrown) {
		console.error("Failed to create a new user!", response);
		}});
		  
	});
	
	
	$( "#btnLogIn" ).click(function() {

		var username = 	$( "#txtUsername" ).val();
		var password = $("#txtPassword").val();
		
		var JSONObject= {"korisnickoIme": username, "sifra": password }; 
		console.log("USAO U FUNKCIJU");
		
		$.ajax({ url: "api/authentication/logIn", 
		data: JSON.stringify(JSONObject), 
		type: "POST", 
		contentType: "application/json",
		success: function(data, textStatus, response){
				console.log(data);
				user.korisnickoIme = data.korisnickoIme;
				user.sifra = data.sifra;
				user.uloga = data.uloga;
  		   },
		error: function (response, textStatus, errorThrown) {
		console.error("Failed to log in");
		}});
		  
	});
	
	
});

