class MyPromise {
    constructor(executor) {
        this.state = 'pending';  // Initial state
        this.value = undefined;  // To store the result or error
        this.reason = undefined; // To store the rejection reason

        // Executor function is called immediately when the promise is created
        const resolve = (value) => {
            if (this.state === 'pending') {
                this.state = 'fulfilled';
                this.value = value;
            }
        };

        const reject = (reason) => {
            if (this.state === 'pending') {
                this.state = 'rejected';
                this.reason = reason;
            }
        };

        try {
            executor(resolve, reject); // Execute the executor function with resolve and reject
        } catch (error) {
            reject(error); // If an error occurs in the executor, reject the promise
        }
    }

    then(onFulfilled, onRejected) {
        if (this.state === 'fulfilled') {
            // If promise is fulfilled, call the onFulfilled callback
            return onFulfilled(this.value);
        }

        if (this.state === 'rejected') {
            // If promise is rejected, call the onRejected callback
            return onRejected(this.reason);
        }

        // If the promise is still pending, return this promise to allow chaining
        return this;
    }

    catch(onRejected) {
        return this.then(null, onRejected); // A shorthand for `then(undefined, onRejected)`
    }

    static resolve(value) {
        return new MyPromise((resolve) => resolve(value)); // Return a resolved promise with a value
    }

    static reject(reason) {
        return new MyPromise((_, reject) => reject(reason)); // Return a rejected promise with a reason
    }
}

// Example usage:

const promise = new MyPromise((resolve, reject) => {
    setTimeout(() => resolve('Resolved!'), 1000); // Resolve after 1 second
});

promise.then(value => {
    console.log(value); // Output: Resolved!
}).catch(err => {
    console.log('Error:', err);
});
