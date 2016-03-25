

    $(function() {
        	 if (localStorage.chkbx && localStorage.chkbx != '') {
                 $('#remember_me').attr('checked', 'checked');
                 $('#email').val(localStorage.usrname);
                 $('#password').val(localStorage.pass);
             } else {
                 $('#remember_me').removeAttr('checked');
                 $('#email').val('');
                 $('#password').val('');
             }

             $('#remember_me').click(function() {

                 if ($('#remember_me').is(':checked')) {
                     // save username and password
                     localStorage.email = $('#adminemail').val();
                     localStorage.password = $('#adminpassword').val();
                     localStorage.chkbx = $('#remember_me').val();
                 } else {
                     localStorage.adminemail = '';
                     localStorage.adminpassword = '';
                     localStorage.chkbx = '';
                 }
             });
         });

        	
        	
        
        function myFunction()
        {
            document.getElementById("login").style.display="none";
            document.getElementById("adminLogin").style.display="none";
            document.getElementById("registration").style.display="none";

        }
        function showLogin()
        {
            document.getElementById("login").style.display="block";
            document.getElementById("adminLogin").style.display="none";
            document.getElementById("registration").style.display="none";

        }
        function showAdmin()
        {
            document.getElementById("login").style.display="none";
            document.getElementById("adminLogin").style.display="block";
            document.getElementById("registration").style.display="none";

        }
        function showRegistration() {

            document.getElementById("login").style.display="none";
            document.getElementById("adminLogin").style.display="none";
            document.getElementById("registration").style.display="block";
        }

    