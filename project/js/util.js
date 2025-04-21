// Create product card with dynamic "Add to Cart" button
function createProductCard(product) {
  const card = document.createElement("a");
  card.href = `product.html?id=${product.id}`;
  card.className = "product-card";

  const title = document.createElement("h3");
  title.textContent = product.title;

  const img = document.createElement("img");
  img.src = product.thumbnail;
  img.alt = product.title;
  img.width = 100;

  const price = document.createElement("p");
  price.textContent = `$${product.price}`;

  let rawRating = product.rating;

  // Floor the rating, enforce min 1 and max 5
  let stars = Math.floor(rawRating);
  stars = Math.max(1, Math.min(stars, 5));
  
  // Create the star string
  let starDisplay = '⭐'.repeat(stars);
  
  // Create the rating element
  const rating = document.createElement("p");
  rating.innerHTML = `${starDisplay}`;
  rating.className = "product-rating";
  

  const tagsContainer = document.createElement("div");
  tagsContainer.className = "product-tags";
  product.tags.forEach(tag => {
    const tagElement = document.createElement("span");
    tagElement.textContent = tag;
    tagElement.className = "tag";
    tagsContainer.appendChild(tagElement);
  });


  // Add to Cart button
  const addToCartBtn = document.createElement("button");
  const cart = JSON.parse(localStorage.getItem("cart")) || [];
  const isInCart = cart.some(item => item.id === product.id);
  addToCartBtn.textContent = isInCart ? "Remove" : "Add to Cart";
  addToCartBtn.className = "add-to-cart-btn";
  addToCartBtn.addEventListener("click", (e) => {
    e.preventDefault();
    toggleCart(product, addToCartBtn);
  });

  // Add to Wishlist button with heart icon
  const addToWishlistBtn = document.createElement("button");
  addToWishlistBtn.className = "add-to-wishlist-btn";

  const heartIcon = document.createElement("i");
  heartIcon.className = isItemInWishlist(product.id) ? "fas fa-heart" : "far fa-heart";
  addToWishlistBtn.appendChild(heartIcon);

  addToWishlistBtn.addEventListener("click", (e) => {
    e.preventDefault();
    if (isItemInWishlist(product.id)) {
      removeFromWishlist(product.id);
      heartIcon.className = "far fa-heart"; // Change to outline heart
    } else {
      addToWishlist(product);
      heartIcon.className = "fas fa-heart"; // Change to filled heart
    }
  });

  card.appendChild(title);
  card.appendChild(img);
  card.appendChild(price);
  card.appendChild(rating);
  card.appendChild(tagsContainer);
  card.appendChild(addToCartBtn);
  card.appendChild(addToWishlistBtn);

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
//   alert("Product added to wishlist!");
}

// Remove item from wishlist
function removeFromWishlist(id) {
  let wishlist = JSON.parse(sessionStorage.getItem("wishlist")) || [];
  wishlist = wishlist.filter(item => item.id !== id);
  sessionStorage.setItem("wishlist", JSON.stringify(wishlist));
//   alert("Product removed from wishlist!");
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
      btn.textContent = "Add to Wishlist"; // Update button text
    } else {
      // If the product is not in the wishlist, add it
      wishlist.push(product);
      btn.textContent = "Remove from Wishlist"; // Update button text
    }
  
    // Save updated wishlist to sessionStorage
    sessionStorage.setItem("wishlist", JSON.stringify(wishlist));
  
    // alert(isInWishlist ? "Removed from Wishlist" : "Added to Wishlist");
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
    btn.textContent = "Remove from Cart"; // Update button text
  }

  // Save updated cart to localStorage
  localStorage.setItem("cart", JSON.stringify(cart));

//   alert(isInCart ? "Removed from Cart" : "Added to Cart");
}
