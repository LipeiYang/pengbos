var theme_template_dir = jQuery("meta[name=theme_template_dir]").attr('content');
jQuery(document).ready(function($){
			$('#send_message').click(function(e){
				
				//stop the form from being submitted
				e.preventDefault();
				
				/* declare the variables, var error is the variable that we use on the end
				to determine if there was an error or not */
				var error = false;
				var name = $('#visitor').val();
				var email = $('#visitormail').val();
				
				var message = $('#notes').val();
				
				/* in the next section we do the checking by using VARIABLE.length
				where VARIABLE is the variable we are checking (like name, email),
				length is a javascript function to get the number of characters.
				And as you can see if the num of characters is 0 we set the error
				variable to true and show the name_error div with the fadeIn effect. 
				if it's not 0 then we fadeOut the div( that's if the div is shown and
				the error is fixed it fadesOut. 
				
				The only difference from these checks is the email checking, we have
				email.indexOf('@') which checks if there is @ in the email input field.
				This javascript function will return -1 if no occurence have been found.*/
				if(name.length == 0){
					error = true;
				}
				if(email.length == 0 || email.indexOf('@') == '-1'){
					error = true;
				}

				if(message.length == 0){
					error = true;
				}
				
				//now when the validation is done we check if the error variable is false (no errors)
				if(error == false){
					//disable the submit button to avoid spamming
					//and change the button text to Sending...
					$('#send_message').attr({'disabled' : 'true', 'value' : 'Sending...' });
					
					/* using the jquery's post(ajax) function and a lifesaver
					function serialize() which gets all the data from the form
					we submit it to send_email.php */
					$.post(theme_template_dir + "/include/inc_sendmail.php", $("#contacts").serialize(),function(result){
						//and after the ajax request ends we check the text returned
						if(result == 'sent'){
							//if the mail is sent remove the submit paragraph
							 $('#button').remove();
							//and show the mail success div with fadeIn
							$('#mail_success').fadeIn(500);
						}else{
							//show the mail failed div
							$('#mail_fail').fadeIn(500);
							//reenable the submit button by removing attribute disabled and change the text back to Send The Message
							$('#send_message').removeAttr('disabled').attr('value', 'Submit');
						}
					});
				}
			});    
		});