document.addEventListener("DOMContentLoaded", () => {
  // Load header and footer dynamically
  fetch("header.html")
    .then(res => res.text())
    .then(data => {
      document.getElementById("header").innerHTML = data;

      const script = document.createElement("script");
      script.src = "js/header.js";
      document.body.appendChild(script);
    });

  fetch("footer.html")
    .then(res => res.text())
    .then(data => {
      document.getElementById("footer").innerHTML = data;
    });
});

const productList = document.getElementById("product-list");
const paginationNumbers = document.getElementById("paginationNumbers");
const pageSizeInput = document.getElementById("pageSize");
const productContainer = document.querySelector(".product-container");
const prevPageButton = document.getElementById("prevPage");
const nextPageButton = document.getElementById("nextPage");
const currentPageDisplay = document.getElementById("currentPageDisplay");

let currentPage = 1;
let totalProducts = 0;
let pageSize = parseInt(pageSizeInput.value);
let isLoading = false; // Prevent multiple API calls during scrolling
const productCache = {}; // Cache to store fetched products by page

// Create a sentinel element for IntersectionObserver
const sentinel = document.createElement("div");
sentinel.id = "sentinel";
productContainer.appendChild(sentinel);

// IntersectionObserver to load more products when the sentinel is visible
const observer = new IntersectionObserver(
  (entries) => {
    const entry = entries[0];
    if (entry.isIntersecting && !isLoading && currentPage * pageSize < totalProducts) {
      currentPage++;
      fetchProducts(currentPage, true); // Append products on intersection
    }
  },
  {
    root: productContainer, // Observe within the product container
    rootMargin: "0px",
    threshold: 1.0, // Trigger when the sentinel is fully visible
  }
);

// Start observing the sentinel
observer.observe(sentinel);

// Fetch products from the API
function fetchProducts(page, append = false) {
  if (isLoading) return; // Prevent multiple API calls
  isLoading = true;

  // Check if the data for the requested page is already in the cache
  if (productCache[page]) {
    console.log(`Loading data for page ${page} from cache`);
    renderProducts(productCache[page], append);
    isLoading = false;
    return; // Exit the function to avoid making an API call
  }

  console.log(`Fetching data for page ${page} from API`);
  const skip = (page - 1) * pageSize;
  const url = `https://dummyjson.com/products?limit=${pageSize}&skip=${skip}`;

  fetch(url)
    .then(res => res.json())
    .then(data => {
      totalProducts = data.total;
      productCache[page] = data.products; // Store the fetched data in the cache
      renderProducts(data.products, append);

      // Update pagination buttons only after new products are fetched
      // updatePaginationButtons();
    })
    .catch(error => {
      console.error("Error fetching products:", error);
      productList.innerHTML = "<p>Failed to load products. Try again later.</p>";
    })
    .finally(() => {
      isLoading = false;
    });
}

// Render products in the product list
function renderProducts(products, append = false) {
  if (!append) {
    productList.innerHTML = ""; // Clear the product list if not appending
  }
  products.forEach(product => {
    const card = createProductCard(product);
    productList.appendChild(card);
  });
  updatePaginationButtons();
}

// Create a product card
function createProductCard(product) {
  const card = document.createElement("div");
  card.classList.add("product-card");

  // Check if the product is already in the cart
  const cart = JSON.parse(localStorage.getItem("cart")) || [];
  const isInCart = cart.some(item => item.id === product.id);

  card.innerHTML = `
    <img src="${product.thumbnail}" alt="${product.title}" class="product-image" />
    <div class="product-details">
      <h3 class="product-title">${product.title}</h3>
      <p class="product-price">$${product.price}</p>
      <button class="cart-btn" data-id="${product.id}">
        ${isInCart ? "Remove" : "Add to Cart"}
      </button>
    </div>
  `;

  // Add event listener to the cart button
  const cartButton = card.querySelector(".cart-btn");
  cartButton.addEventListener("click", () => toggleCart(product, cartButton));

  return card;
}

// Function to toggle product in the cart
function toggleCart(product, button) {
  let cart = JSON.parse(localStorage.getItem("cart")) || [];

  // Check if the product is already in the cart
  const productIndex = cart.findIndex(item => item.id === product.id);

  if (productIndex > -1) {
    // Remove the product from the cart
    cart.splice(productIndex, 1);
    button.textContent = "Add to Cart";
  } else {
    // Add the product to the cart
    cart.push({ ...product, quantity: 1 });
    button.textContent = "Remove ";
  }

  // Update the cart in localStorage
  localStorage.setItem("cart", JSON.stringify(cart));

  // Dynamically update the cart count
  const updateCounts = window.updateCounts || (() => {});
  updateCounts();

  // Re-render the product list to update button states
  renderProducts(productCache[currentPage] || []);
}

// Update pagination buttons
function updatePaginationButtons() {
  const totalPages = Math.ceil(totalProducts / pageSize);

  // Update the current page display
  currentPageDisplay.textContent = `${currentPage} of ${totalPages}`;

  // Enable/disable the Previous button
  prevPageButton.disabled = currentPage === 1;

  // Enable/disable the Next button
  nextPageButton.disabled = currentPage === totalPages;

  // Update pagination numbers
  paginationNumbers.innerHTML = "";
  for (let i = 1; i <= totalPages; i++) {
    const btn = document.createElement("button");
    btn.textContent = i;
    if (i === currentPage) {
      btn.classList.add("active-page");
    }

    btn.addEventListener("click", () => {
      currentPage = i;
      fetchProducts(currentPage);
      productContainer.scrollTop = 0; // Scroll to the top of the product container
    });

    paginationNumbers.appendChild(btn);
  }  productContainer.addEventListener("scroll", () => {
    // Infinite scrolling logic
    if (
      productContainer.scrollTop + productContainer.clientHeight >= productContainer.scrollHeight - 50 &&
      !isLoading &&
      currentPage * pageSize < totalProducts
    ) {
      currentPage++;
      fetchProducts(currentPage, true); // Append products on infinite scroll
    }
  
    // Update pagination buttons when scrolling back up
    if (productContainer.scrollTop === 0) {
      updatePaginationButtons();
    }
  });
}

// Event listener for the Previous button
prevPageButton.addEventListener("click", () => {
  if (currentPage > 1) {
    currentPage--;
    fetchProducts(currentPage);
    productContainer.scrollTop = 0; // Scroll to the top of the product container
  }
});

// Event listener for the Next button
nextPageButton.addEventListener("click", () => {
  const totalPages = Math.ceil(totalProducts / pageSize);
  if (currentPage < totalPages) {
    currentPage++;
    fetchProducts(currentPage);
    productContainer.scrollTop = 0; // Scroll to the top of the product container
  }
});

// Infinite scrolling logic
productContainer.addEventListener("scroll", () => {
  if (
    productContainer.scrollTop + productContainer.clientHeight >= productContainer.scrollHeight - 50 &&
    !isLoading &&
    currentPage * pageSize < totalProducts
  ) {
    currentPage++;
    fetchProducts(currentPage, true); // Append products on infinite scroll
  }
});

// Event listener for page size change
pageSizeInput.addEventListener("change", () => {
  const newSize = parseInt(pageSizeInput.value);
  if (newSize > 0 && newSize <= 100) {
    pageSize = newSize;
    currentPage = 1;
    fetchProducts(currentPage);
  } else {
    alert("Please select a valid page size.");
    pageSizeInput.value = pageSize;
  }
});

// Initial fetch
fetchProducts(currentPage);

// function removeFromWishlist(id) {
//   console.log("remove clle");
//   let wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
//   wishlist = wishlist.filter(item => item.id !== id);
//   sessionStorage.setItem("wishlist", JSON.stringify(wishlist));

//   // Update wishlist count dynamically
//   updateCounts();

//   // Remove the item from the DOM
//   const wishlistItem = document.querySelector(`[data-id="${id}"]`);
//   if (wishlistItem) {
//     wishlistItem.remove();
//   }
// }

// Avoid calling fetchProducts or renderProducts here
removeFromWishlist(product.id);
// renderProducts(productCache[currentPage]); // This might cause the issue
