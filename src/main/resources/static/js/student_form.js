function togglePasswordVisibility() {
    var passwordInputs = document.getElementsByClassName("passwordInput");
    var showPasswordBtn = document.getElementById("showPasswordBtn");

    for (var i = 0; i < passwordInputs.length; i++) {
        if (passwordInputs[i].type === "password") {
        passwordInputs[i].type = "text";
        } else {
        passwordInputs[i].type = "password";0
        }
    }

    var img = showPasswordBtn.querySelector('img');
    img.src = (passwordInputs[0].type === "password") ? "/images/eye-close.png" : "/images/eye-open.png";
}

function validatePasswords() {
    var newPassword = document.getElementById("newPassword").value;
    var confirmPassword = document.getElementById("confirmPassword").value;
    var errorMessageElement = document.getElementById("errorMessage");

    if (newPassword !== confirmPassword) {
        errorMessageElement.textContent = "Passwords do not match. Please try again.";
        
        errorMessageElement.style.display = 'block';
        
        setTimeout(() => {
        errorMessageElement.style.display = 'none';
        }, 3000);

        return false;
    } else {
        errorMessageElement.textContent = "";
        return true;
    }
}