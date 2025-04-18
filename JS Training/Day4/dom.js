// ======= DOCUMENT OBJECT MODEL METHODS EXPLAINED =======

// 1. getElementById() - Selects a single element by ID
const title = document.getElementById("mainTitle");
console.log("getElementById:", title.textContent);

// 2. getElementsByClassName() - Returns an HTMLCollection (array-like)
const demoElems = document.getElementsByClassName("demo");
console.log("getElementsByClassName:", demoElems[0].textContent);

// 3. getElementsByTagName() - Selects all elements of a given tag
const buttons = document.getElementsByTagName("button");
console.log("getElementsByTagName (buttons):", buttons.length);

// 4. querySelector() - Returns the first matching element (CSS selector)
const input = document.querySelector("#nameInput");

// 5. querySelectorAll() - Returns all matching elements as NodeList
const allButtons = document.querySelectorAll("button");
console.log("querySelectorAll (buttons):", allButtons);

// ======= EVENT LISTENER EXAMPLE =======
const greetBtn = document.getElementById("greetBtn");
const greeting = document.getElementById("greeting");

greetBtn.addEventListener("click", () => {
  const name = input.value;
  greeting.textContent = `Hello, ${name}!`;
});

// ======= DOM MANIPULATION EXAMPLES =======
const titleText = title.textContent;         // Get text
console.log("Text content:", titleText);

title.textContent = "Updated DOM Methods Demo"; // Set text

// Create new element and append
const newPara = document.createElement("p");
newPara.textContent = "This is a dynamically created paragraph.";
document.body.appendChild(newPara);

// ======= DOM CLASS MANIPULATION =======
const box = document.getElementById("animateBox");
const toggleBtn = document.getElementById("toggleAnimation");

toggleBtn.addEventListener("click", () => {
  box.classList.toggle("move");
});

// .classList methods:
// add() - Adds a class
// remove() - Removes a class
// toggle() - Adds if not present, removes if present
// contains() - Checks if class exists

// ======= STYLE ACCESS =======
box.style.borderRadius = "10px"; // Inline style
console.log("Box background color:", getComputedStyle(box).backgroundColor);

// ======= REMOVE ELEMENT =======
// document.body.removeChild(newPara); // Uncomment to remove the paragraph

// ======= SET ATTRIBUTE =======
input.setAttribute("placeholder", "Type your name here");

// ======= GET ATTRIBUTE =======
console.log("Input placeholder:", input.getAttribute("placeholder"));

// ======= INNER HTML =======
const contentDiv = document.createElement("div");
contentDiv.innerHTML = "<strong>Bold content</strong> inside innerHTML.";
document.body.appendChild(contentDiv);

// ======= TEXT VS INNERHTML =======
// textContent sets or gets raw text
// innerHTML sets or gets HTML structure

// ======= SUMMARY =======
console.log(`\n📌 Summary:
- getElementById / Class / Tag / querySelector
- addEventListener for events like click, input, mouseover
- classList for adding/removing CSS classes
- createElement & appendChild for dynamic content
- getComputedStyle to access final rendered styles
- setAttribute / getAttribute to handle element attributes
`);
