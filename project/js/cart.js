document.addEventListener("DOMContentLoaded", () => {
  const cartContainer = document.getElementById("cart-items");
  const cart = JSON.parse(localStorage.getItem("cart")) || [];

  if (cart.length === 0) {
    cartContainer.textContent = "Your cart is empty.";
    return;
  }

  cart.forEach(item => {
    // Use a template literal to create the cart item structure
    const itemCard = document.createElement("div");
    itemCard.className = "cart-item";
    itemCard.innerHTML = `
      <img src="${item.thumbnail}" alt="${item.title}" width="80" />
      <h3>${item.title}</h3>
      <p>Price: $${item.price}</p>
      <p>Quantity: ${item.quantity}</p>
      <button class="remove-btn" data-id="${item.id}">Remove</button>
    `;

    // Add event listener to the "Remove from Cart" button
    const removeButton = itemCard.querySelector(".remove-btn");
    removeButton.addEventListener("click", () => {
      removeFromCart(item.id);
    });

    cartContainer.appendChild(itemCard);
  });
});

// Function to remove an item from the cart
function removeFromCart(productId) {
  let cart = JSON.parse(localStorage.getItem("cart")) || [];

  // Filter out the item with the given productId
  cart = cart.filter(item => item.id !== productId);

  // Update the cart in localStorage
  localStorage.setItem("cart", JSON.stringify(cart));

  // Reload the cart page to reflect the changes
  location.reload();
}
