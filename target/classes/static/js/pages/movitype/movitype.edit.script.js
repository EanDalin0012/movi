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
                + '<input type="text" class="form-control" id="nameEdit" placeholder="Enter Name" value="'+data.name+'">'
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
                            toDoPostDataUpdate(dialogRef, val);
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



function toDoPostDataUpdate(dialogRef, id) {
	var name = $("#nameEdit").val();
	var updatEmoviType = {};
	updatEmoviType['id'] = id;
    updatEmoviType["name"] = name;
    updatEmoviType["description"] = $("#validationTextarea").val();
    if (name === "") {
        Swal.fire({
            type: 'error',
            title: 'Name is require',
            text: 'Something went wrong!',
            //  footer: '<a href>Why do I have this issue?</a>'
        })
    } else if (name === undefined) {
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
            url: "/@m!n/api/movitype/update",
            data: JSON.stringify(updatEmoviType), // convert array to JSON
            dataType: 'json',
            cache: false,
            timeout: 100000,
            success: function (data) {
                if (data.status === true && data.setStatus === "YUpdated") {
                    Swal.fire({
                        type: 'success',
                        title: data.description,
                        showConfirmButton: false,
                        timer: 1500
                    }).then((result) => {
                        result.dismiss === Swal.DismissReason.timer;
                        dialogRef.close();
                    });
                } else  {
                    Swal.fire({
                        type: 'error',
                        title: 'Name is require',
                        text: 'Something went wrong!',
                        //  footer: '<a href>Why do I have this issue?</a>'
                    })
                }

            }, error: function (e) {
                console.log("ERROR : ", e.responseJSON);
                if ( e.responseJSON.status === false &&  e.responseJSON.setStatus === "NUpdate" ) {
                    Swal.fire({
                        type: 'error',
                        title: e.responseJSON.description,
                        text: e.responseJSON.setStatus,
                        //  footer: '<a href>Why do I have this issue?</a>'
                    })
                }

            }
        });
    }
	
}

function alert(message) {

	return true;
}