class LRUCache {
  constructor(capacity) {
    this.capacity = capacity; // Maximum capacity of the cache
    this.cache = new Map(); // Map to store key-value pairs
  }

  get(key) {
    if (!this.cache.has(key)) {
      return -1; // Return -1 if the key is not found
    }
    // Move the accessed key to the end to mark it as recently used
    const value = this.cache.get(key);
    this.cache.delete(key);
    this.cache.set(key, value);
    return value;
  }

  put(key, value) {
    if (this.cache.has(key)) {

      this.cache.delete(key);
    } else if (this.cache.size >= this.capacity) {

      const leastRecentlyUsedKey = this.cache.keys().next().value;
      this.cache.delete(leastRecentlyUsedKey);
    }
    // Add the new key-value pair to the cache
    this.cache.set(key, value);
  }
}

// Example usage
const cache = new LRUCache(2);
cache.put(1, 1);
cache.put(2, 2);
console.log(cache.get(1)); 
cache.put(3, 3); // Evicts key 2
console.log(cache.get(2)); 
cache.put(4, 4); 
console.log(cache.get(1)); // Output: -1
console.log(cache.get(3)); // Output: 3
console.log(cache.get(4)); // Output: 4