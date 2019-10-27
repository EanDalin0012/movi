/**
 *
 */
function deleteMoviType(val){

    BootstrapDialog.show({
        title: 'Delete!',
        message: "<h3>Do you want to delete movi type?</h3>",
        cssClass: 'delete-dialog',
        closable: true,
        closeByBackdrop: false,
        closeByKeyboard: false,
        buttons: [
            {
                icon: 'glyphicon glyphicon glyphicon-paste',
                label: 'Delete',
                cssClass: 'btn-save bg-aqua',
                action: function (dialogRef) {
                    toDoDeleteType(val,dialogRef);
                }
            }, {
                icon: 'glyphicon glyphicon-ban-circle',
                label: 'Close',
                cssClass: 'btn-close bg-red',
                action: function (dialogRef) {
                    dialogRef.close();
                }
            }
        ]
    });
}

function toDoDeleteType(id, dialogRef) {
    var test = 100;
    $.ajax({
        type: "Post",
        url: "/@m!n/api/movitype/delete?id="+id,
        //	    data:{"data":"check"},
        contentType: "application/json",
        dataType: "json",
        success: function(data) {
            console.log(data)
            if (data.status == true && data.setStatus == "YDeleted"){
                Swal.fire({
                    type: 'success',
                    title: data.description,
                    showConfirmButton: false,
                    timer: 2500
                }).then((result)=> {
                    result.dismiss === Swal.DismissReason.timer;
                    console.log(result);
                    dialogRef.close();
                    // window.location.href = "/@m!n/movitype/";
                });
            }
            if(data.status == false && data.setStatus == "NDelete"){
                Swal.fire({
                    type: 'error',
                    title: data.description,
                    // text: data.setStatus,
                    showConfirmButton: false,
                    timer: 3500
                });
            }
        }
    });
}
