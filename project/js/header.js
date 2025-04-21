document.addEventListener("DOMContentLoaded", () => {
    console.log("DOM fully loaded");
  
    const searchInput = document.getElementById("search");
    const suggestionsBox = document.getElementById("suggestions");
  
    if (!searchInput || !suggestionsBox) {
      console.error("Search input or suggestions box not found!");
      return;
    }
  
    let searchTimeout;
  
    searchInput.addEventListener("input", () => {
      console.log("User typed:", searchInput.value);
      clearTimeout(searchTimeout);
      const query = searchInput.value.trim();
  
      if (!query) {
        console.log("Empty input — resetting products.");
        suggestionsBox.innerHTML = "";
        if (typeof window.fetchProducts === "function") {
          window.fetchProducts(1);
        } else {
          console.warn("window.fetchProducts is not defined");
        }
        return;
      }
  
      searchTimeout = setTimeout(() => {
        console.log("Searching for:", query);
        fetch(`https://dummyjson.com/products/search?q=${encodeURIComponent(query)}`)
          .then(res => {
            if (!res.ok) throw new Error(`HTTP error! status: ${res.status}`);
            return res.json();
          })
          .then(data => {
            console.log("Search results:", data);
            suggestionsBox.innerHTML = "";
            const suggestions = data.products || [];
  
            suggestions.forEach(product => {
              const div = document.createElement("div");
              div.textContent = product.title;
              div.className = "suggestion";
              div.addEventListener("click", () => {
                console.log("Product selected:", product);
                searchInput.value = product.title;
                suggestionsBox.innerHTML = "";
                updateProductList([product]);
              });
              suggestionsBox.appendChild(div);
            });
          })
          .catch(err => {
            console.error("Search API error:", err);
          });
      }, 300);
    });
    function updateProductList(products) {
        const productList = document.getElementById("product-list");
        const paginationNumbers = document.getElementById("paginationNumbers");
      
        if (!productList) {
          console.error("product-list element not found");
          return;
        }
      
        paginationNumbers && (paginationNumbers.innerHTML = "");
        productList.innerHTML = "";
      
        products.forEach(product => {
          const card = window.createProductCard(product); // 🔥 Use your utility
          productList.appendChild(card);
        });
      
        console.log("Product list updated");
      }
      
  });
  

  if (window.document.URL.includes("index.html")) {
    Array.from(document.getElementsByClassName("navhide")).forEach(element => {
      element.style.display = "block";
    });
  } else {
    document.getElementsByClassName("hide").style.display = "none";
  }
  