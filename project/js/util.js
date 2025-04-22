// Create product card with dynamic "Add to Cart" button
function createProductCard(product) {
  const cart = JSON.parse(localStorage.getItem("cart")) || [];
  const wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];

  const isInCart = cart.some(item => item.id === product.id);
  const isInWishlist = wishlist.some(item => item.id === product.id);

  // Create the product card using a template literal
  const card = document.createElement("div");
  card.className = "product-card";
  card.innerHTML = `
    <a href="product.html?id=${product.id}">
      <img src="${product.thumbnail}" alt="${product.title}" width="100" />
      <h3>${product.title}</h3>
      <p>$${product.price}</p>
      <p class="product-rating">${'⭐'.repeat(Math.max(1, Math.min(5, Math.floor(product.rating))))}</p>
      <div class="product-tags">
        ${product.tags.map(tag => `<span class="tag">${tag}</span>`).join("")}
      </div>
    </a>
    <button class="add-to-cart-btn">${isInCart ? "Remove from Cart" : "Add to Cart"}</button>
    <button class="add-to-wishlist-btn">
      <i class="${isInWishlist ? "fas fa-heart" : "far fa-heart"}"></i>
    </button>
  `;

  // Add event listener for the "Add to Cart" button
  const addToCartBtn = card.querySelector(".add-to-cart-btn");
  addToCartBtn.addEventListener("click", (e) => {
    e.preventDefault();
    toggleCart(product, addToCartBtn);
  });

  // Add event listener for the "Add to Wishlist" button
  const addToWishlistBtn = card.querySelector(".add-to-wishlist-btn");
  addToWishlistBtn.addEventListener("click", (e) => {
    e.preventDefault();
    toggleWishlist(product, addToWishlistBtn);
  });

  return card;
}

// Check if item is in wishlist
function isItemInWishlist(id) {
  const wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
  return wishlist.some(item => item.id === id); // Check if item ID exists in the wishlist
}

// Add item to wishlist
function addToWishlist(product) {
  const wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
  wishlist.push(product);
  sessionStorage.setItem("wishlist", JSON.stringify(wishlist));

  // Update wishlist count dynamically
  updateCounts();
}

// Remove item from wishlist
function removeFromWishlist(id) {
  console.log("Removing from wishlist:", id);
  let wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
  wishlist = wishlist.filter(item => item.id !== id);
  sessionStorage.setItem("wishlist", JSON.stringify(wishlist));

  // Update wishlist count dynamically
  updateCounts();
}

function addToCart(product) {
  const cart = JSON.parse(localStorage.getItem("cart")) || [];
  const existing = cart.find(item => item.id === product.id);

  if (existing) {
    existing.quantity += 1;
  } else {
    cart.push({ ...product, quantity: 1 });
  }

  localStorage.setItem("cart", JSON.stringify(cart));
  // alert("Product added to cart!");
}

function toggleWishlist(product, btn) {
  let wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];

  // Check if the product is already in the wishlist
  const isInWishlist = wishlist.some(item => item.id === product.id);

  if (isInWishlist) {
    // If the product is in the wishlist, remove it
    wishlist = wishlist.filter(item => item.id !== product.id);
    btn.querySelector("i").className = "far fa-heart"; // Change to outline heart
  } else {
    // If the product is not in the wishlist, add it
    wishlist.push(product);
    btn.querySelector("i").className = "fas fa-heart"; // Change to filled heart
  }

  // Save updated wishlist to sessionStorage
  sessionStorage.setItem("wishlist", JSON.stringify(wishlist));

  // Update wishlist count dynamically
  updateCounts();
}

function toggleCart(product, btn) {
  let cart = JSON.parse(localStorage.getItem("cart")) || [];

  // Check if the product is already in the cart
  const isInCart = cart.some(item => item.id === product.id);

  if (isInCart) {
    // If the product is in the cart, remove it
    cart = cart.filter(item => item.id !== product.id);
    btn.textContent = "Add to Cart"; // Update button text
  } else {
    // If the product is not in the cart, add it
    cart.push({ ...product, quantity: 1 });
    btn.textContent = "Remove "; // Update button text
  }

  // Save updated cart to localStorage
  localStorage.setItem("cart", JSON.stringify(cart));

  // Update cart count dynamically
  updateCounts();
}

function updateCounts() {
  const cart = JSON.parse(localStorage.getItem("cart")) || [];
  const wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || []; // Use sessionStorage for wishlist

  const cartCountElement = document.getElementById("cart-count");
  const wishlistCountElement = document.getElementById("wishlist-count");

  if (cartCountElement) {
    cartCountElement.textContent = cart.length; // Update cart count
  }

  if (wishlistCountElement) {
    wishlistCountElement.textContent = wishlist.length; // Update wishlist count
  }
}
