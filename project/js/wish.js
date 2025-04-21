document.addEventListener("DOMContentLoaded", () => {
    const wishlistContainer = document.getElementById("wishlist-items");
    const wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
  
    if (wishlist.length === 0) {
      wishlistContainer.textContent = "Your wishlist is empty.";
      return;
    }
  
    wishlist.forEach(item => {
      const itemCard = document.createElement("div");
      itemCard.className = "wishlist-item";
  
      const img = document.createElement("img");
      img.src = item.thumbnail;
      img.alt = item.title;
      img.width = 80;
  
      const title = document.createElement("h3");
      title.textContent = item.title;
  
      const price = document.createElement("p");
      price.textContent = `Price: $${item.price}`;
  
      // Button to remove from wishlist
      const removeBtn = document.createElement("button");
      removeBtn.textContent = "Remove from Wishlist";
      removeBtn.className = "remove-from-wishlist-btn";
      removeBtn.addEventListener("click", () => {
        removeFromWishlist(item.id);
      });
  
      // Button to move item to cart
      const moveToCartBtn = document.createElement("button");
      moveToCartBtn.textContent = "Move to Cart";
      moveToCartBtn.className = "move-to-cart-btn";
      moveToCartBtn.addEventListener("click", () => {
        moveToCart(item);
      });
  
      itemCard.appendChild(img);
      itemCard.appendChild(title);
      itemCard.appendChild(price);
      itemCard.appendChild(removeBtn);
      itemCard.appendChild(moveToCartBtn);
  
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
    // alert("Product moved to cart!");
  }
  