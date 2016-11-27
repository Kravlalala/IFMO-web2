/**
 * Created by kravlala on 20.11.16.
 */

/**
 * Created by 1 on 03.05.2016.
 */
$( function() {
    $('#confirm').click( function() {
        var id = $('#id').val();
        var password = $('#password').val();
        var password2 = $('#password2').val();
        //$('#print').load( "/SignUp?&id="+id+"&password="+password+"&password2="+password2);
        $.get("/SignUp",
            {
                id: id,
                password:password,
                password2:password2
            },
            function (responseText) {
                if (responseText.localeCompare("success")!=0){
                    alert(responseText);
                }
                else{
                    alert(responseText);
                    window.location.replace("complete.jsp");
                }
            });
        });
} );
