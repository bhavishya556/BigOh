// ✅ Basic Promise Creation
const basicPromise = new Promise((resolve, reject) => {
    const success = true; // change to false to test rejection
  
    if (success) {
      resolve("✅ Basic Promise Resolved!");
    } else {
      reject("❌ Basic Promise Rejected!");
    }
  });
  
  basicPromise
    .then((msg) => console.log("Basic .then():", msg))
    .catch((err) => console.log("Basic .catch():", err));
  
  
  // ✅ Delayed Success with setTimeout
  const delayedPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve("⏳ Delayed success after 1 second");
    }, 1000);
  });
  
  delayedPromise.then((msg) => console.log("Delayed:", msg));
  
  
  // ❌ Handling Rejected Promise
  const errorPromise = new Promise((resolve, reject) => {
    setTimeout(() => {
      reject("💥 Something went wrong!");
    }, 1000);
  });
  
  errorPromise
    .then((msg) => console.log("This won't run"))
    .catch((err) => console.log("Caught error:", err));
  
  
  // 🔁 Chaining Promises
  new Promise((resolve) => {
    setTimeout(() => resolve(10), 500);
  })
    .then((res) => {
      console.log("Step 1:", res); // 10
      return res * 2;
    })
    .then((res) => {
      console.log("Step 2:", res); // 20
      return res * 2;
    })
    .then((res) => {
      console.log("Step 3:", res); // 40
    });
  
  
  // 🧠 Simulating API Call
  function fetchUserData() {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const data = { id: 1, name: "Alice" };
        resolve(data);
      }, 1500);
    });
  }
  
  fetchUserData()
    .then((user) => {
      console.log("Fetched User:", user);
    })
    .catch((err) => {
      console.log("API Error:", err);
    })
    .finally(() => {
      console.log("✔️ Done fetching user");
    });
  
  
  // 🔁 Using Promise with async/await
  function fetchProduct() {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve({ id: 101, name: "Laptop" });
      }, 1000);
    });
  }
  
  async function getProduct() {
    try {
      const product = await fetchProduct();
      console.log("📦 Product (async/await):", product);
    } catch (error) {
      console.log("❌ Error in async/await:", error);
    } finally {
      console.log("✅ Async/Await finished");
    }
  }
  
  getProduct();
  

// 1. Callback function example
function fetchUserDataCallback(callback) {
    setTimeout(() => {
      const user = { username: "Bhavishya", age: 25 };
      callback(null, user);  // First param: error (null means no error), second param: result
    }, 2000);
  }
  
  // Using callback to fetch data
  fetchUserDataCallback((err, user) => {
    if (err) {
      console.log("Callback Error:", err);
    } else {
      console.log("Callback User Data:", user);
    }
  });
  

  
  // Using promise to fetch data
  fetchUserDataPromise()
    .then(user => {
      console.log("Promise User Data:", user);
    })
    .catch(err => {
      console.log("Promise Error:", err);
    });
  
  
  // 3. Async/Await example
  async function fetchUserDataAsync() {
    try {
      const user = await new Promise((resolve, reject) => {
        setTimeout(() => {
          const user = { username: "Bhavishya", age: 25 };
          resolve(user);  // Resolve the promise with user data
        }, 2000);
      });
      console.log("Async/Await User Data:", user);
      console.log(reject);
    } catch (err) {
        console.log(reject);
      console.log("Async/Await Error:", err);
    }
  }
  
  // Using async/await to fetch data
  fetchUserDataAsync();
  
  
  // 4. Real-life example using Async/Await with GitHub API
  async function fetchGitHubUser(username) {
    try {
      const response = await fetch(`https://api.github.com/users/${username}`);
      
      // Checking if the response is OK (status code 200-299)
      if (!response.ok) throw new Error('User not found');
      
      const user = await response.json();
      console.log("GitHub User Data:", user);
    } catch (err) {
      console.log("GitHub Error:", err.message);
    }
  }
  
  // Fetching GitHub user data using async/await
  fetchGitHubUser('bhavishya556');
  


