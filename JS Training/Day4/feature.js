// ✅ setTimeout
console.log("⏳ Starting timer...");


const data = {
    name: 'satya',
    getName : () =>{
        return this.name;
    }
}
setTimeout(function() {
  console.log("✅ setTimeout: This message shows after 2 seconds");
},0);

// ✅ setInterval
let count = 0;
const intervalId = setInterval(() => {
  console.log(`🔁 setInterval: Count is ${++count}`);
  if (count === 3) {
    clearInterval(intervalId); // stop after 3 times
    console.log("🛑 Interval cleared");
  }
}, 1000);

// ✅ Date object
const now = new Date();
console.log("📅 Current Date and Time:", now.toString());
console.log("📆 Year:", now.getFullYear());
console.log("🕒 Hours:", now.getHours());



async function fetchPosts(fn) {
 
  try {
     res = await fetch("https://jsonplaceholder.typicode.com/posts/1",{});

    const rowdata = await res;
    console.log("🌐 Fetch response row:", rowdata);

    const data = await res.json();
    console.log("🌐 Fetch response:", data);
   fn(res)
    
} catch (err) {
    console.error("❌ Fetch error:", err);
    return err;
  }

}
 

fetchPosts((data)=>{
    log(data)
})

fetchPosts().then((res)=>{

})

const data = await fetchPosts();
log(data)

