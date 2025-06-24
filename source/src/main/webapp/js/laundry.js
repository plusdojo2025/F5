document.addEventListener("DOMContentLoaded", () => {
    const categorySections = document.querySelectorAll(".category-section");

    categorySections.forEach(section => {
        const items = section.querySelectorAll(".clothes-item");
        const pages = Math.ceil(items.length / 5);
        let currentPage = 0;

        function updatePagination() {
            items.forEach((item, idx) => {
                const page = Math.floor(idx / 5);
                item.classList.toggle("hidden", page !== currentPage);
            });
        }

        updatePagination();

        const prevBtn = document.querySelector(".prev-btn");
        const nextBtn = document.querySelector(".next-btn");

        prevBtn.addEventListener("click", () => {
            if (currentPage > 0) {
                currentPage--;
                updatePagination();
            }
        });

        nextBtn.addEventListener("click", () => {
            if (currentPage < pages - 1) {
                currentPage++;
                updatePagination();
            }
        });
    });
});

