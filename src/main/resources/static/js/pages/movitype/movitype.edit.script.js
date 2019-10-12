/**
 * 
 */
function editMoviType(val){
    $.ajax({
        type: "GET",
        url: "/@m!n/api/movitype/getvaluebyid?id=" + val,
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
			console.log(data);
            var update = '<form>'
                // start form

                // start row
                + '<div class="form-row">'

                + '<div class="form-group col-md-6"> '
                + '<label for="inputEmail4">Name</label>'
                + '<input type="text" class="form-control" id="name" placeholder="Enter Name" value="'+data.name+'">'
                + '<span id = "validName" style = "color:red;"></span>'
                + '</div>'

                + '<div class="form-group col-md-6">'
                + '<label for="inputPassword4">Description</label>'
                + '<textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required>'+data.description+'</textarea>'
                + '</div>'

                + '</div>'

                // end form
                + '</form>';

            BootstrapDialog.show({
                title: 'Add new movies type',
                message: update,
                closable: true,
                closeByBackdrop: false,
                closeByKeyboard: false,
                buttons: [
                    {
                        icon: 'glyphicon glyphicon glyphicon-copy',
                        label: 'Update',
                        cssClass: 'btn-save bg-aqua',
                        action: function(dialogRef) {
                            toDoPostDataMoviType(dialogRef)
                        }
                    },{
                        icon: 'glyphicon glyphicon-ban-circle',
                        label: 'Close',
                        cssClass: 'btn-close bg-red btn-danger',
                        action: function(dialogRef){
                            dialogRef.close();
                        }
                    }
                ]
            });

        }, error: function (e) {
            console.log("ERROR : ", e);
        }
    });
}



function toDoPostDataMoviType(dialogRef) {
	var name = $("#name").val();
	var addmainmovi = {}
	addmainmovi["name"] = name;
	addmainmovi["description"] = $("#validationTextarea").val();
	if(name === "" || name !== undefined ){
//		$("#validName").html("Name is require");
		Swal.fire({
			  type: 'error',
			  title: 'Name is require',
			  text: 'Something went wrong!',
			//  footer: '<a href>Why do I have this issue?</a>'
			})
	} else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/@m!n/movitype/addmovitype",
				data: JSON.stringify(addmainmovi), // convert array to JSON
				dataType: 'json',
				cache: false,
				timeout: 100000,
				success: function (data) {
					
					if( data.status === true && data.setStatus === "YInserted") {
						
						Swal.fire({
							  type: 'success',
							  title: data.description,
							  showConfirmButton: false,
							  timer: 1500
						}).then((result) => {
							result.dismiss === Swal.DismissReason.timer;
							dialogRef.close();
						});
						
					}
					
				}, error: function (e) {
		
					console.log("ERROR : ", e);
		
				}
			});
	}
	
}

function alert(message) {

	return true;
}