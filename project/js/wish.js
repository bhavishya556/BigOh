document.addEventListener("DOMContentLoaded", () => {
  const wishlistContainer = document.getElementById("wishlist-items");
  const wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];

  if (wishlist.length === 0) {
    wishlistContainer.textContent = "Your wishlist is empty.";
    return;
  }

  wishlist.forEach(item => {
    // Use a template literal to create the wishlist item structure
    const itemCard = document.createElement("div");
    itemCard.className = "wishlist-item";
    itemCard.innerHTML = `
      <img src="${item.thumbnail}" alt="${item.title}" width="80" />
      <h3>${item.title}</h3>
      <p>Price: $${item.price}</p>
      <button class="remove-from-wishlist-btn" data-id="${item.id}">Remove from Wishlist</button>
      <button class="move-to-cart-btn" data-id="${item.id}">Move to Cart</button>
    `;

    // Add event listener to the "Remove from Wishlist" button
    const removeBtn = itemCard.querySelector(".remove-from-wishlist-btn");
    removeBtn.addEventListener("click", () => {
      removeFromWishlist(item.id);
    });

    // Add event listener to the "Move to Cart" button
    const moveToCartBtn = itemCard.querySelector(".move-to-cart-btn");
    moveToCartBtn.addEventListener("click", () => {
      moveToCart(item);
    });

    wishlistContainer.appendChild(itemCard);
  });
});

// Function to remove from wishlist
function removeFromWishlist(id) {
  const wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
  const updatedWishlist = wishlist.filter(item => item.id !== id);
  sessionStorage.setItem("wishlist", JSON.stringify(updatedWishlist));
  location.reload(); // Reload to reflect changes
}

// Function to move item to cart
function moveToCart(item) {
  const cart = JSON.parse(localStorage.getItem("cart")) || [];
  const existing = cart.find(cartItem => cartItem.id === item.id);

  if (existing) {
    existing.quantity += 1;
  } else {
    cart.push({ ...item, quantity: 1 });
  }

  localStorage.setItem("cart", JSON.stringify(cart));
  removeFromWishlist(item.id); // Remove from wishlist after moving to cart
}
