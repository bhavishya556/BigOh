class EventEmitter {
    constructor() {
        // Initialize an empty object to store events and their listeners
        this.events = {};
    }

    // Add a listener for a specific event
    on(event, listener) {
        if (!this.events[event]) {
            this.events[event] = []; // Initialize the event with an empty array if it doesn't exist
        }
        this.events[event].push(listener); // Add the listener to the event's array
    }

    // Emit an event and call all its listeners
    emit(event, ...args) {
        if (this.events[event]) {
            this.events[event].forEach(listener => listener(...args)); // Call each listener with the provided arguments
        }
    }

    // Remove a specific listener for an event
    off(event, listener) {
        if (this.events[event]) {
            this.events[event] = this.events[event].filter(lis => lis !== listener); 
        }
    }
}

// Example usage
const emitter = new EventEmitter();

const hi = (name) => console.log(`Hello, ${name}`);
const by = (name) => console.log(`Goodbye, ${name}`);

// Add listeners
emitter.on('greet', hi);
emitter.on('greet', by);

// Emit the 'greet' event
emitter.emit('greet', 'Alice'); // Output: Hello, Alice
                                //         Goodbye, Alice

// Remove the 'greet' listener
emitter.off('greet', hi);

// Emit the 'greet' event again
emitter.emit('greet', 'Bob'); // Output: Goodbye, Bob