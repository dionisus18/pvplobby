/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

$().ready(function(){
    $("#registro").validate({
        rules: {
            nombre: "required",
            usuario: {
                required: true,
                minlength: 2
            },
            pass: {
                required: true,
                minlength: 5
            },
            pass2: {
                required: true,
                minlength: 5,
                equalTo: "#pass"
            },
            email: {
                required: true,
                email: true
            }
            },
            messages: {
                nombre: "Ingrese su nombre",
                usuario: {
                    required: "Ingrese el nombre de usuario",
                    minlenght:"El usuario debe de ser minimo 2 caracteres de largo"
                },
                pass: {
                    required: "Ingrese una contraseña",
                    minlength: "La contraseña debe de ser minimo de 5 caracteres de largo"
                },
                pass2: {
                    required: "Ingrese una contraseña",
                    minlength: "La contraseña debe de ser minimo de 5 caracteres de largo",
                    equalTo: "La contraseña no es la misma que la de arriba"
                }
            },
        invalidHandler: function (event, validator) {
            // 'this' refers to the form
            var errors = validator.numberOfInvalids();
            if (errors) {
                var message = errors === 1
                        ? 'You missed 1 field. It has been highlighted'
                        : 'You missed ' + errors + ' fields. They have been highlighted';
                $("div.error span").html(message);
                $("div.error").show();
            } else {
                $("div.error").hide();
            }
        }
        });
});

 */
