/**
 * 
 */
$(function() {
	
	$("#movitypeadd").click(function(){
    	var add = '<form>'
    		// start form
    		
    		// start row
    		+ '<div class="form-row">'
    		
    		+ '<div class="form-group col-md-6"> ' 
	    		+ '<label for="inputEmail4">Name</label>'
	    		+ '<input type="text" class="form-control" id="name" placeholder="Enter Name">'
	    		+ '<span id = "validName" style = "color:red;"></span>'
    		+ '</div>'
    		
    		+ '<div class="form-group col-md-6">'
	    		+ '<label for="inputPassword4">Description</label>'
	    		+ '<textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required></textarea>'
    		+ '</div>'
    		
    		+ '</div>'
    		
    		// end form
    		+ '</form>';

    	BootstrapDialog.show({
            title: 'Add new movies type',
            message: add,
            closable: true,
            closeByBackdrop: false,
            closeByKeyboard: false,
            buttons: [
            	{
                    icon: 'glyphicon glyphicon-download-alt',
                    label: 'Save',
                    cssClass: 'btn-save bg-aqua',
                    action: function(dialogRef) {
                        toDoPostSaveMoviType(dialogRef)
                    }
            	},{
                    icon: 'glyphicon glyphicon-ban-circle',
                    label: 'Close',
                    cssClass: 'btn-close bg-red',
                action: function(dialogRef){
                    dialogRef.close();
                	}
            	}
            ]
        });
	});
});

function toDoPostSaveMoviType(dialogRef) {
	var name = $("#name").val();
	var address = $("#validationTextarea").val();
	var add = {}
	add["name"] = name;
	add["description"] = address;
	if(name === "" || name === undefined || name === null){
//		$("#validName").html("Name is require");
		Swal.fire({
			  type: 'error',
			  title: 'Name is require',
			  text: 'Name went wrong!'
			});
	}
	else {
			$.ajax({
				type: "POST",
				contentType: "application/json",
				url: "/@m!n/api/movitype/save",
				data: JSON.stringify(add), // convert array to JSON
				dataType: 'json',
				cache: false,
				timeout: 100000,
				success: function (data) {
					
					if( data.status === true && data.setStatus === "YSaved") {
						
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