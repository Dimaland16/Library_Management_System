document.addEventListener("DOMContentLoaded", function() {
    const categoryLinks = document.querySelectorAll(".category-link");

    categoryLinks.forEach(link => {
        link.addEventListener("click", function(event) {
            event.preventDefault();

            categoryLinks.forEach(link => link.classList.remove("active"));

            event.currentTarget.classList.add("active");

            window.location.href = event.currentTarget.getAttribute("href");
        });
    });
});
