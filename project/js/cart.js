document.addEventListener("DOMContentLoaded", () => {
  const cartContainer = document.getElementById("cart-items");
  const cart = JSON.parse(localStorage.getItem("cart")) || [];

  if (cart.length === 0) {
    cartContainer.textContent = "Your cart is empty.";
    return;
  }

  cart.forEach(item => {
    const itemCard = document.createElement("div");
    itemCard.className = "cart-item";

    const img = document.createElement("img");
    img.src = item.thumbnail;
    img.alt = item.title;
    img.width = 80;

    const title = document.createElement("h3");
    title.textContent = item.title;

    const price = document.createElement("p");
    price.textContent = `Price: $${item.price}`;

    const quantity = document.createElement("p");
    quantity.textContent = `Quantity: ${item.quantity}`;

    // Create a "Remove from Cart" button
    const removeButton = document.createElement("button");
    removeButton.textContent = "Remove from Cart";
    removeButton.className = "remove-btn";

    // Add event listener to remove the item from the cart
    removeButton.addEventListener("click", () => {
      removeFromCart(item.id);
    });

    itemCard.appendChild(img);
    itemCard.appendChild(title);
    itemCard.appendChild(price);
    itemCard.appendChild(quantity);
    itemCard.appendChild(removeButton);

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
