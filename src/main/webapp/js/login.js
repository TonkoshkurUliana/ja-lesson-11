
function showAlertAfterRegistration() {
  $('div.alert.alert-success').show();
}

$('#register').bind('click',
        function() {
          var firstName = $('#firstName').val();
          var lastName = $('#lastName').val();
          var email = $('#email').val();
          var password = $('#password').val();

          if (firstName == '' || lastName == '' || email == ''
              || password == '' ) {
            alert("Please fill all fields...!!!!!!");
          } else if ((password.length) < 6) {
            alert("Password should atleast 6 character in length...!!!!!!");
          } else {
            var userRegistration = {
              firstName : firstName,
              lastName : lastName,
              email : email,
              password : password
            };

            $.post("registration", userRegistration,
                function(data) {
                  if (data == 'Success') {
                      // loginRegisterSwitch();
                      showAlertAfterRegistration();
                      $(' input[type="text"],  input[type="password"], input[type="email"]').val('');
                  }
                });
          }
        });

$('#login').click(function() {
  var email = $('#loginemail').val();
  var password = $('#loginpassword').val();

  if (email == '' || password == '') {
    alert("Please fill login form!");
  } else {
    var userLogin = {
      email : email,
      password : password
    };

    $.post("login", userLogin, function(data) {
        if(data !== ''){
            var customUrl = '';
            var urlContent = window.location.href.split('/');
            for (var i = 0; i < urlContent.length-1; i++) {
                customUrl+=urlContent[i]+'/'
            }
            customUrl+=data.destinationUrl;
            window.location = customUrl;
        }
        $(' input[type="text"],  input[type="password"], input[type="email"]').val('');
    });
  }
});