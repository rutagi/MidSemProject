document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("registrationForm");

    // Clear input fields when the form is loaded
    form.reset();

    form.addEventListener("submit", function(event) {
        const email = document.getElementById("email").value;
        const password = document.getElementById("password").value;
        const role = document.getElementById("role").value;

        if (!validateEmail(email)) {
            event.preventDefault();
            alert("Invalid email format");
        } else if (password.length < 6) {
            event.preventDefault();
            alert("Password must be at least 6 characters long");
        }
    });

    function validateEmail(email) {
        const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return regex.test(email);
    }
});
