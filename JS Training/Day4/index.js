// ✅ DATE IN JAVASCRIPT

// Create date objects
const now = new Date();                        // Current date and time
const specificDate = new Date("2025-04-18");   // From string
const customDate = new Date(2025, 3, 18, 12, 30); // Apr is 3 (0-based index)

// Get components
console.log("Year:", now.getFullYear());
console.log("Month:", now.getMonth());        // 0 = Jan
console.log("Date:", now.getDate());
console.log("Time:", now.getTime());          // ms since Jan 1, 1970

// Set components
now.setFullYear(2030);
now.setMonth(11); // December

// ✅ Calculate Time Difference
const start = new Date("2025-04-01");
const end = new Date();
const diffInMs = end - start;
const diffInDays = Math.floor(diffInMs / (1000 * 60 * 60 * 24));
console.log(`⏱️ Days passed since April 1, 2025: ${diffInDays}`);

// ✅ LOCALSTORAGE

// Store and retrieve string
localStorage.setItem("username", "John");
console.log("👤 Username from localStorage:", localStorage.getItem("username"));

// Store and retrieve object
const user = { name: "Alice", loggedIn: true };
localStorage.setItem("user", JSON.stringify(user));
const retrievedUser = JSON.parse(localStorage.getItem("user"));
console.log("🧠 Stored user:", retrievedUser);

// ❌ No built-in expiry => Simulate it
// const tokenData = {
//   value: "abc123",
//   expiry: new Date().getTime() + 10 * 1000 // 10 seconds from now
// };
// localStorage.setItem("token", JSON.stringify(tokenData));

// // Later: check if token is expired
// const raw = localStorage.getItem("token");
// if (raw) {
//   const parsed = JSON.parse(raw);
//   if (new Date().getTime() > parsed.expiry) {
//     localStorage.removeItem("token");
//     console.log("🚫 Token expired");
//   } else {
//     console.log("✅ Token valid:", parsed.value);
//   }
//}

// ✅ SESSIONSTORAGE (same API as localStorage)

// Data here disappears when tab closes
sessionStorage.setItem("sessionID", "sess-456");
console.log("📦 Session ID:", sessionStorage.getItem("sessionID"));

// Store object
const cart = [{ id: 1, item: "Laptop" }];
sessionStorage.setItem("cart", JSON.stringify(cart));
const retrievedCart = JSON.parse(sessionStorage.getItem("cart"));
console.log("🛒 Cart from sessionStorage:", retrievedCart);

// ✅ SUMMARY (console output only)
console.log(`
📌 Summary:
- Date is used for handling time, durations, and formatting.
- localStorage persists across tabs and refreshes, but has no expiry by default.
- sessionStorage only lasts while the tab is open.
- Use JSON.stringify and JSON.parse to handle objects in storage.
- You can simulate expiry manually using Date timestamps in localStorage.
`);
