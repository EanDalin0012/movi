/**
 *
 */
$(function () {

    $("#test").click(function () {
        var add = '<form>'
            // start form

            // start row
            + '<div class="form-row">'

            + '<div class="form-group col-md-6"> '
            + '<label for="inputEmail4">Name</label>'
            + '<input type="text" class="form-control" id="name" placeholder="Email">'
            + '</div>'

            + '<div class="form-group col-md-6">'
            + '<label for="inputPassword4">Description</label>'
            + '<textarea class="form-control is-invalid" id="validationTextarea" placeholder="Required example textarea" required></textarea>'
            + '</div>'

            + '</div>'

            // end form
            + '</form>';
        BootstrapDialog.show({
            message: 'Hi Apple!',
            message: add,
            closable: true,
            closeByBackdrop: false,
            closeByKeyboard: false,
            buttons: [
                {
                    icon: 'glyphicon glyphicon-download-alt',
                    label: 'Save',
                    cssClass: 'btn-save bg-aqua',
                    action: function (dialogRef) {
                        toDoPostApi(dialogRef);
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
    });
});

function toDoPostApi(dialogRef) {
    var addApiType = {}
    addApiType["name"] = $("#name").val();
    addApiType["description"] = $("#validationTextarea").val();

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/@m!n/api/type/save",
        data: JSON.stringify(addApiType), // convert array to JSON
        dataType: 'json',
        cache: false,
        timeout: 100000,
        success: function (data) {

            console.log("SUCCESS : ", data.status);
            if (data.status == true && data.setStatus == "YInserted"){
                Swal.fire({
                    type: 'success',
                    title: data.description,
                    showConfirmButton: false,
                    timer: 1500
                }).then((result)=> {
                    result.dismiss === Swal.DismissReason.timer;
                    dialogRef.close();
                });
               console.log(data.description)
            }

        },
        error: function (e) {

            console.log("ERROR : ", e);

        }
    });
}