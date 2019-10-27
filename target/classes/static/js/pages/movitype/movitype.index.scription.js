
$(function() {

    var row =[];
    $('#example').DataTable( {
        //dom: 'Bfrtip',
        buttons: [
            'copyHtml5'
        ],
        dom: '<"top"f>Bt<"bottom"lip>',

        "pageLength": 15,
        ajax:{
            url : "/@m!n/api/movitype/getmovitypelist",
            buttons: [
                {
                    text: 'My button',
                    action: function ( e, dt, node, config ) {
                        alert( 'Button activated' );
                    }
                }
            ],
            type : "get",
            dataType: 'json',
            contentType: "application/json",
            dataType: "json",
            "dataSrc": "",
            error: function(data){
                alert();
            },
        },
        columns: [

            {"data": "id",
                "render": function (data, type, row) {
                    data = '<a class="edit-user" data-toggle="modal" data-target="#editUser" attr=' + row.id + ' ><u>' + data + '</u></a>';
                    return data;;
                },
            },
            {"data": "name",},
            {"data": "description",},
            {"data": "createDate",},
            {"data": "createBy",},
            {"data": "modifyDate",},
            {"data": "modifyBy",},
            {
                "data":null,
                "searchable": false,
                "sortable": false,
                "order": false,
                "class": "dt-body-center",
                "render": function (data, type, row) {
                    return  ' <div class="input-group-btn">'
                        + ' <button type="button" class="btn btn-warning dropdown-toggle" data-toggle="dropdown">Action '
                        + ' <span class="fa fa-caret-down"></span></button> '
                        + ' <ul class="dropdown-menu"> '
                        + ' <li onclick="editMoviType('+row.id+')"><a>Edit</a></li> '
                        + ' <li onclick="deleteMoviType('+row.id+')"><a>Delete</a></li> '
                        + ' </ul> '
                        + ' </div>';
                }
            }
        ],

        columnDefs: [
            { className: "text-center text-left", "targets": [0,5] },
            // { className: "text-right", "targets": [2] },
        ]

    });

});


    	   